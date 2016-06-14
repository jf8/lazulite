/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan. 
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna. 
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus. 
 * Vestibulum commodo. Ut rhoncus gravida arcu. 
 */

package com.daphne.lazulite.wechat.service.thread;

import com.daphne.crm.ws.client.entity.RegisterResponse;
import com.daphne.lazulite.common.utils.SpringUtils;
import com.daphne.lazulite.wechat.ActivemqQueueConfig;
import com.daphne.lazulite.wechat.WechatUserInfo;
import com.daphne.lazulite.wechat.WechatUtils;
import com.daphne.lazulite.wechat.entity.WeChannelQrcode;
import com.daphne.lazulite.wechat.entity.WeMember;
import com.daphne.lazulite.wechat.service.DaphneInterfaceManager;
import com.daphne.lazulite.wechat.service.WeChannelQrcodeService;
import com.daphne.lazulite.wechat.service.WeMemberService;
import com.daphne.lazulite.wechat.service.util.CRMRequestEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;

public class SubscribeThread implements Runnable{
	
	private Logger logger = LoggerFactory.getLogger(SubscribeThread.class);

	private WeMember targetMember;


	@Override
	public void run() {
		try {
			// 非法性校验
			if (targetMember==null||targetMember.getId()==null) {
				logger.error("Invalid subscribe for member: "+targetMember==null?null:(targetMember.getWechatId()));
				return ;
			}
			WeMemberService memberService = SpringUtils.getBean(WeMemberService.class);
			DaphneInterfaceManager daphneInterfaceManager = SpringUtils.getBean(DaphneInterfaceManager.class);
			RedisTemplate redisTemplate = SpringUtils.getBean("redisTemplate");
			boolean isMemberNeedUpdate = false;
			// 当名称为空，需要去获取微信昵称
			if (StringUtils.isEmpty(targetMember.getName())) {
				WechatUserInfo userInfo = WechatUtils.getUserInfo(targetMember.getWechatId());
				String niekName = userInfo==null?null:userInfo.getNickname();
				targetMember.setName(niekName);
				isMemberNeedUpdate = true;
			}
			// 如果memberID为空，则需要去crm中执行注册操作
			if (StringUtils.isEmpty(targetMember.getMemberId())) {
				
				WeChannelQrcode channel = null;
				if (targetMember.getChannelQrcodeId()!=null) {
					WeChannelQrcodeService channelQrcodeService = SpringUtils.getBean(WeChannelQrcodeService.class);
					channel = channelQrcodeService.findOne(targetMember.getChannelQrcodeId());

				}
				
				RegisterResponse response = daphneInterfaceManager.wechatRegisterThroughDaphne(
						targetMember.getWechatId(),channel==null?null:channel.getId().toString(),channel==null?null:channel.getChannelName()
								,targetMember.getCreateTime());
				targetMember.setMemberId(response.getMemberID());
				targetMember.setMemberNumber(response.getMemberNumber());
				// 当注册失败时，需要重复性去注册，
				if (!response.isSuccess()) {
					CRMRequestEntity crmRequest = new CRMRequestEntity();
					crmRequest.setCRMRegister(targetMember.getId(), targetMember.getWechatId());
					JmsMessagingTemplate jmsMessagingTemplate=SpringUtils.getBean(JmsMessagingTemplate.class);
					jmsMessagingTemplate.convertAndSend(ActivemqQueueConfig.QUEUE_CALL_CRM_API,crmRequest);
					//jedisCacheManager.publishCRMRequest(crmRequest);
				}else{
					isMemberNeedUpdate = true;
				}
			}
			// 如果需要更新，则调用更新接口，更新数据库以及regis缓存中的用户信息
			if (isMemberNeedUpdate) {
				memberService.update(targetMember);
			}
			// 新用户关注完成后，需要验证是否需要给该用户发送优惠券发送消息
//			if (MadhouseConst.LIMITS_SHOPCOUPON_CHANNELS!=null&&MadhouseConst.LIMITS_SHOPCOUPON_CHANNELS.length>0&&
//					targetMember.getChannelQrcodeId()!=null) {
//				for(String channel: MadhouseConst.LIMITS_SHOPCOUPON_CHANNELS){
//					if (channel.equals(targetMember.getChannelQrcodeId())) {
//						IMessageService messageService = (IMessageService) BaseService
//								.getBean("messageService");
//						messageService.saveAndSendCouponMessage(targetMember, null, null);
//						break;
//					}
//				}
//			}
		} catch (Exception e) {
			logger.error("Error to execute subscribe thread for member: "+targetMember.getId()+", "+targetMember.getWechatId()
					+", message="+e.getMessage(), e);
		}

	}
	public SubscribeThread(WeMember targetMember) {
		this.targetMember = targetMember;
	}
}
