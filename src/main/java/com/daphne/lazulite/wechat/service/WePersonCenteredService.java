/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

import com.alibaba.fastjson.JSONObject;
import com.daphne.lazulite.wechat.WechatRedisManager;
import com.daphne.lazulite.wechat.ActivemqQueueConfig;
import com.daphne.lazulite.wechat.MadhouseConst;
import com.daphne.lazulite.wechat.WechatUserInfo;
import com.daphne.lazulite.wechat.WechatUtils;
import com.daphne.lazulite.wechat.dto.CommonResultDto;
import com.daphne.lazulite.wechat.entity.WeMember;
import com.daphne.lazulite.wechat.service.util.CRMRequestEntity;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by junfu on 2016/6/2.
 */
@Service
public class WePersonCenteredService {
    private Logger logger = LoggerFactory.getLogger(WePersonCenteredService.class);
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


    @Autowired
    private WeMemberService memberservice;
    @Autowired
    private SendSmsService sendSmsService;
    @Autowired
    private DaphneInterfaceManager daphneInterface;
    @Autowired
    private WeMessageService messageService;
    @Autowired
    private WechatRedisManager redisManager;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void getVerificationCode(String phoneNum,String openId) {
        if(StringUtils.isEmpty(phoneNum)){
            logger.info("getVerificationCode but have not a phone number!");
            return;
        }
        /**
         * 同一个手机号在30秒内不能重复发短信
         */
        String ALLOWKEY = "ALLOW"+phoneNum;

        String allow = redisManager.getStringValue(ALLOWKEY);
        if(!StringUtils.isEmpty(allow)){
            logger.info("already send VerificationCode to the phone:"+phoneNum+" in 30 seconds ,can not repeatedly sent ");
            return;
        }
        String verificationCode = String.valueOf(RandomUtils.nextInt(100000,999999));
        boolean flag = sendSmsService.sendValidationSMS(phoneNum, verificationCode);
        if(flag){
            /**
             * 设置短信验证码过期时间
             */
            redisManager.setStringValue(phoneNum, verificationCode, MadhouseConst.DAPHNE_SMS_INVALID_TIME*60, TimeUnit.SECONDS);
            redisManager.setStringValue(ALLOWKEY,"ALREADY", 30,TimeUnit.SECONDS);
        }
    }

    public CommonResultDto bindMember(String verificationCode, String openId, String phoneNum) {
        CommonResultDto result = new CommonResultDto();
        if(!verifyBindMember(verificationCode, openId, phoneNum, result)){//验证参数
            return result;
        }
        try {
            //如果手机号绑定过，就不允许再次绑定
            WeMember memberQueriedByPhoneNum = this.memberservice.queryByPhoneNum(phoneNum);
            if(memberQueriedByPhoneNum!=null){
                logger.debug("the phoneNum:"+phoneNum+" is already binded");
                result.setResult(0);
                result.setErrorMsg("该手机号已经被绑定，请更换手机号重新绑定！");
                return result;
            }
            WeMember memberQueriedByOpenId = this.memberservice.queryByOpenId(openId);
            if(memberQueriedByOpenId==null){//openId对应的会员找不到
                logger.debug("openId in bindMember is["+openId+"]");
                result.setResult(0);
                result.setErrorMsg("请重新关注公众号！");
                return result;
            }
            verificationCode = verificationCode.trim();

            String verificationCodeInRedis = redisManager.getStringValue(phoneNum);
            if(!verificationCode.equals(verificationCodeInRedis)){//验证验证码是否正确
                result.setResult(0);
                result.setErrorMsg("验证码错误！");
                return result;
            }
            if(StringUtils.isEmpty(memberQueriedByOpenId.getMemberId())){
                logger.debug("memberId is empty");
                result.setResult(0);
                result.setErrorMsg("手机号绑定失败，请稍后再试！");
                return result;
            }
            // 请求达芙妮
//			VerifyMobileResponse response = daphneInterface.verifyMobileThroughDaphne(memberQueriedByOpenId.getMemberId(), phoneNum);
//			if(!response.isSuccess()){
            // 当失败后，发送消息给redis以供后续调用
            CRMRequestEntity entity = new CRMRequestEntity();
            entity.setCRMBindMobile(memberQueriedByOpenId.getId(), memberQueriedByOpenId.getMemberId(),
                    phoneNum);;
            //发布消息到mq
            jmsMessagingTemplate.convertAndSend(ActivemqQueueConfig.QUEUE_CALL_CRM_API,entity);
            //redisManager.publishCRMRequest(entity);
//				logger.info("bind member failed on invoking crm interface verifyMobileThroughDaphne for member: "+memberQueriedByOpenId.getMemberId()+", throw redis to execute next time.");
//			}
//			String memberId = response.getMemberID();
//			String memberNumber = response.getMemberNumber();
//			String memberId = null;
//			String memberNumber = null;
            memberQueriedByOpenId.setPhoneNum(phoneNum);
            // 当绑定后返回的member信息不为空，并且其与输入的memberID不同时，表示该用户为老用户，那么需要给他发送优惠券信息
//			if (!CommonUtils.isEmpty(memberId)&&!CommonUtils.isEmpty(memberNumber)&&
//					!memberQueriedByOpenId.getMemberId().equals(memberId)) {
//				memberQueriedByOpenId.setMemberId(memberId);
//				memberQueriedByOpenId.setMemberNumber(memberNumber);
//				memberQueriedByOpenId.setIsOldMember(1);
//				// 当为老用户时，需要发送门店优惠券该用户
//				this.messageService.saveAndSendCouponMessage(memberQueriedByOpenId, null, null);
//			}
            // 更新用户信息到数据库以及缓存中
            this.memberservice.update(memberQueriedByOpenId);
        } catch (Exception e) {
            logger.error("绑定会员异常：==>",e.getMessage(),e);
            result.setResult(0);
            result.setErrorMsg("系统异常");
        }
        return result;
    }
    private boolean verifyBindMember(String verificationCode, String openId,
                                     String phoneNum, CommonResultDto result) {
        logger.info("verificationCode="+verificationCode+",openId="+openId+",phoneNum="+phoneNum);
        boolean flag = true;
        if(StringUtils.isEmpty(verificationCode)){
            result.setResult(0);
            result.setErrorMsg("验证码为空！");
            flag = false;
        }else if(StringUtils.isEmpty(phoneNum)){
            result.setResult(0);
            result.setErrorMsg("手机号为空！");
            flag = false;
        }else if(StringUtils.isEmpty(openId)){
            result.setResult(0);
            result.setErrorMsg("openId为空！");
            flag = false;
        }
        flag = true;
        logger.debug("the result of verifyBindMember is "+flag);
        return flag;
    }

    public CommonResultDto updateUserInfo(String openId, String name, Date birthday, String sex) {
        logger.debug("openId="+openId+",name="+name+",birthday="+birthday+",sex="+sex);
        CommonResultDto result = new CommonResultDto();
        try {
            if(StringUtils.isEmpty(openId)){
                result.setResult(0);
                result.setErrorMsg("openId为空！");
                return result;
            }
            WeMember member = this.memberservice.queryByOpenId(openId);
            if(member==null){
                logger.info("member is null ,openId is["+openId+"]");
                result.setResult(0);
                result.setErrorMsg("请重新关注公众号！");
                return result;
            }
            if(StringUtils.isEmpty(member.getMemberId())){
                logger.info("memberId is empty");
                result.setResult(0);
                result.setErrorMsg("会员信息更新失败，请稍后再试！");
                // 同时需要发个注册消息给crm系统用于更新memberID
                CRMRequestEntity entity = new CRMRequestEntity();
                entity.setCRMRegister(member.getId(), member.getWechatId());
               // redisManager.publishCRMRequest(entity);
                jmsMessagingTemplate.convertAndSend(ActivemqQueueConfig.QUEUE_CALL_CRM_API,entity);
                return result;
            }
            /**
             * 请求达芙妮做修改
             */
//			UpdateMemberResponse response = this.daphneInterface.updateMemberThroughDaphne(member.getMemberId(), name, sex,birthday==null?null:format.format(birthday) );
//			if(!response.isSuccess()){
            //如果失败后，记录日志，并重复调用接口
//				logger.error("Failed to update user on invoking crm interface updateMemberThroughDaphne, request="+member.getMemberId()+", response="+response.getErrorMessage());
            CRMRequestEntity entity = new CRMRequestEntity();
            entity.setCRMUpdateUser(member.getId(), member.getMemberId(), name, sex, birthday==null?null:format.format(birthday));
            //redisManager.publishCRMRequest(entity);
            jmsMessagingTemplate.convertAndSend(ActivemqQueueConfig.QUEUE_CALL_CRM_API,entity);
//				return result;
//			}

            //修改数据库中数据
            member.setBirthday(birthday);
            member.setSex(sex);
            member.setName(name);
            this.memberservice.update(member);
            logger.debug("success to update userinfor for user: "+member.getMemberId());
        } catch (Exception e) {
            e.printStackTrace();
            result.setResult(0);
            result.setErrorMsg("系统异常");
            logger.error("修改会员资料异常：==>",e.getMessage(),e);
        }
        return result;
    }

    public CommonResultDto info(String openId) {
        logger.debug("openId="+openId);
        CommonResultDto result = new CommonResultDto();
        if(StringUtils.isEmpty(openId)){
            result.setErrorMsg("openId为空！");
            result.setResult(0);
            return result;
        }
        try {
            String name = null;
            int integral = 0;
            Date birthday = null;
            String phoneNum = null;
            String sex = null;

            WeMember member = memberservice.queryByOpenId(openId);
            if (member==null) {
                logger.info("member is null,openId is["+openId+"]");
                result.setResult(0);
                result.setErrorMsg("请重新关注公众号！");
                return result;
            }


            boolean isUserFirstTimeAccess = redisManager.getMember(member.getWechatId())==null?true:false;
            if (StringUtils.isEmpty(member.getMemberId())) {
                CRMRequestEntity queryMemberEntity = new CRMRequestEntity();
                queryMemberEntity.setCRMRegister(member.getId(), member.getWechatId());
                jmsMessagingTemplate.convertAndSend(ActivemqQueueConfig.QUEUE_CALL_CRM_API,queryMemberEntity);
                //redisManager.publishCRMRequest(queryMemberEntity);
            }else{
                //请求达芙妮获取用户名称和积分 TODO\
                if (isUserFirstTimeAccess) {
                    CRMRequestEntity queryMemberEntity = new CRMRequestEntity();
                    queryMemberEntity.setCRMQueryUser(member.getId(), member.getMemberId());
                    jmsMessagingTemplate.convertAndSend(ActivemqQueueConfig.QUEUE_CALL_CRM_API,queryMemberEntity);
                    //redisManager.publishCRMRequest(queryMemberEntity);
                }

                CRMRequestEntity queryIntegralEntity = new CRMRequestEntity();
                queryIntegralEntity.setCRMQueryIntegral(member.getId(), member.getMemberId());
                jmsMessagingTemplate.convertAndSend(ActivemqQueueConfig.QUEUE_CALL_CRM_API,queryIntegralEntity);
                //redisManager.publishCRMRequest(queryIntegralEntity);
            }

            // 直接从数据库获取
            name = member.getName();//关注后会把微信昵称保存到数据库中
            birthday = member.getBirthday();
            phoneNum = member.getPhoneNum();
            sex = member.getSex();
            integral = member.getPoints()==null?0:member.getPoints();

            if(StringUtils.isEmpty(name)){//用微信昵称替换
                WechatUserInfo userInfo = WechatUtils.getUserInfo(openId);
                name = userInfo==null?null:userInfo.getNickname();
                name = (name==null?"-":name);
            }
            logger.info("name from info is "+name);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", name);
            jsonObject.put("integral", integral);
            jsonObject.put("birthday", birthday);
            jsonObject.put("phoneNum", phoneNum);
            jsonObject.put("sex", sex);
            result.setData(jsonObject);
        } catch (Exception e) {
            logger.error("获取用户信息异常：==>",e.getMessage(),e);
            result.setResult(0);
            result.setErrorMsg("系统异常");
        }
        return result;
    }
}
