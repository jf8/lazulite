/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan. 
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna. 
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus. 
 * Vestibulum commodo. Ut rhoncus gravida arcu. 
 */

package com.daphne.lazulite.wechat.jms.util;

import com.daphne.crm.ws.client.entity.*;
import com.daphne.lazulite.common.utils.SpringUtils;
import com.daphne.lazulite.wechat.ActivemqQueueConfig;
import com.daphne.lazulite.wechat.entity.WeChannelQrcode;
import com.daphne.lazulite.wechat.entity.WeMember;
import com.daphne.lazulite.wechat.service.DaphneInterfaceManager;
import com.daphne.lazulite.wechat.service.WeChannelQrcodeService;
import com.daphne.lazulite.wechat.service.WeMemberService;
import com.daphne.lazulite.wechat.service.util.CRMRequestEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * 盗用crm系统API的任务线程，用于通过线程执行查询操作，执行的操作包括如下共计5个接口
 * <br>用户注册| 查询用户信息| 绑定手机| 更新用户信息| 查询积分
 * <br>执行流程如下:
 * <br>1 验证当前请求是否已经连续失败三次，如果是，则写日志，丢弃该请求
 * <br>2 校验当前请求是隶属于如上哪一类请求，并做对应处理
 * <br>2.1 如果是属于注册请求，则执行用户注册接口，成功后则将相关信息更新到用户表中
 * <br>2.2 如果属于绑定手机请求，则执行帮忙手机接口，并将相关信息更新到用户表中
 * <br>2.3 如果属于查询用户信息接口，则执行查询用户接口，并将信息更新到用户表中
 * <br>2.4 如果是更新用户信息接口，则调用接口更新即可
 * <br>2.5 如果是查询积分接口，则调用查询积分接口即可 TODO
 * <br>3 当上述调用接口失败后，则将该请求继续丢入到redis中，待再一次调用接口尝试
 * <br>
 * @ClassName: CallCrmAPIThread 
 * @author Walter.xu
 * @date 2015年8月4日 下午2:41:53
 */
public class CallCrmAPIThread extends Thread{
	protected transient Logger logger = LoggerFactory.getLogger(this.getClass());
	private CRMRequestEntity entity;
	public CallCrmAPIThread(CRMRequestEntity entity){
		this.entity = entity;
	}


	@Override
	public void run(){
		try {
			
			// 超过三次，则丢弃
			if (entity.getFailedCount()>=20) {
				logger.error("Error to execute CallCRMAPI for 3 times, abandon it:"+entity);
				return ;
			}

			boolean callAPISuccess = false;
			DaphneInterfaceManager daphneInterfaceManager=SpringUtils.getBean("daphneInterfaceManager");
			WeMemberService weMemberService = SpringUtils.getBean("weMemberService");
			// 用户注册
			if (CRMRequestEntity.TYPE_REGISTER.equals(entity.getType())) {

				WeMember member = weMemberService.findOne(entity.getWeMemberID());
				WeChannelQrcode channel = null;
				if (member.getChannelQrcodeId()!=null) {
					WeChannelQrcodeService weChannelQrcodeService=SpringUtils.getBean("weChannelQrcodeService");
					channel = weChannelQrcodeService.findOne(member.getChannelQrcodeId());
				}

				RegisterResponse res = daphneInterfaceManager.wechatRegisterThroughDaphne(entity.getWechatID(),
						channel==null?null:channel.getId().toString(),channel==null?null:channel.getChannelName()
								,member.getCreateTime());
				// 如果成功，则更新
				if (res.isSuccess()) {
					member = new WeMember();
					member.setId(entity.getWeMemberID());
					member.setMemberId(res.getMemberID());
					member.setMemberNumber(res.getMemberNumber());
					weMemberService.update(member);
					callAPISuccess = true;
				}
			}else if (CRMRequestEntity.TYPE_BIND_MOBILE.equals(entity.getType())) {
				// 绑定手机
				VerifyMobileResponse res = daphneInterfaceManager.verifyMobileThroughDaphne(entity.getMemberID(), entity.getMobile());
				if (res.isSuccess()) {
					WeMember member = weMemberService.findOne(entity.getWeMemberID());
					member.setId(entity.getWeMemberID());
					member.setMemberId(res.getMemberID());
					member.setMemberNumber(res.getMemberNumber());
					
					if (!entity.getMemberID().equals(res.getMemberID())) {
						member.setIsOldMember(1);
						// 当用户为老用户时需要发送优惠券
						//weMessageService.saveAndSendCouponMessage(member, null, null);
					}
					weMemberService.update(member);
					
					callAPISuccess = true;
				}
			}else if (CRMRequestEntity.TYPE_QUERY_USER.equals(entity.getType())) {
				// 查询用户信息
				QueryMemberResponse res = daphneInterfaceManager.queryMemberThroughDaphne(entity.getMemberID());
				if (res.isSuccess()) {
					WeMember member = weMemberService.findOne(entity.getWeMemberID());
					member.setId(entity.getWeMemberID());
					if (!StringUtils.isEmpty(entity.getBirthday())) {
						member.setBirthday(DateUtils.parseDate(entity.getBirthday(), "yyyy-MM-dd"));
					}
					member.setName(res.getName());
					member.setSex(res.getSex());
					member.setShopCode(res.getShopcode());
					member.setPhoneNum(res.getMobile());
					weMemberService.update(member);
					callAPISuccess = true;
				}
			}else if (CRMRequestEntity.TYPE_QUERY_INTEGRAL.equals(entity.getType())) {
				// 查询积分
				QueryIntegralResponse res = daphneInterfaceManager.queryIntegralThroughDaphne(entity.getMemberID());
				if (res.isSuccess()) {
					WeMember member = weMemberService.findOne(entity.getWeMemberID());
					member.setId(entity.getWeMemberID());
					member.setPoints(res.getIntegral());
					weMemberService.update(member);
					callAPISuccess = true;
				}
			}else if (CRMRequestEntity.TYPE_UPDATE_USER.equals(entity.getType())) {
			    // 更新用户信息
				UpdateMemberResponse res = daphneInterfaceManager.updateMemberThroughDaphne(entity.getMemberID(),
			    		entity.getName(), entity.getSex(), entity.getBirthday());
				if (res.isSuccess()) {
					callAPISuccess = true;
				}
			}else{
				logger.error("Error to call CRMAPI, error type:"+entity);
				return ;
			}
			
			// 失败后，则重新尝试
			if (!callAPISuccess) {
				entity.addFailedCount();
				JmsMessagingTemplate jmsMessagingTemplate=SpringUtils.getBean("jmsMessagingTemplate");
				jmsMessagingTemplate.convertAndSend(ActivemqQueueConfig.QUEUE_CALL_CRM_API,entity);
				logger.warn("Failed to call CRMAPI, set request["+entity+"] into redis and try another time, current:"+entity.getFailedCount());
				return ;
			}
			logger.debug("Success to call CRM API: "+entity);
		} catch (Exception e) {
			logger.error("Error to call crm api, request:"+entity+", message="+e.getMessage(), e);
		}
	}
}
