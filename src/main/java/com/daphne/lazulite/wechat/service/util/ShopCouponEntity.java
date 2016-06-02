/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service.util;

import com.madhouse.daphne.dao.model.Activity;
import com.madhouse.daphne.dao.model.Member;

import java.io.Serializable;

/**
 * 用于传递到redis队列中，供后续调用处理<BR>
 * 仅适用于与门店优惠券
 * @ClassName: ShopCouponEntity 
 * @author Walter.xu
 * @date 2015年6月29日 下午6:10:29
 */
public class ShopCouponEntity implements Serializable{
	private static final long serialVersionUID = 1L;	
	private String memberID;
	private int id; // we_member primary key
	private int messageID;
	private String messageType;
	private Integer activityID;
	private String crmActivityID;
	private int failureCount = 0;
	
	public void setMember(Member member){
		if (member!=null) {
			this.id= member.getId();
			this.memberID = member.getMemberId();
		}
	}
	public void setActivity(Activity activity){
		if (activity!=null) {
			this.activityID = activity.getId();
			this.crmActivityID = activity.getCouponActivityId();
		}
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public Integer getActivityID() {
		return activityID;
	}
	public void setActivityID(Integer activityID) {
		this.activityID = activityID;
	}
	public String getCrmActivityID() {
		return crmActivityID;
	}
	public void setCrmActivityID(String crmActivityID) {
		this.crmActivityID = crmActivityID;
	}
	public int getFailureCount() {
		return failureCount;
	}
	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}
	public void addFailureCount(){
		this.failureCount++;
	}
	@Override
	public String toString(){
		return "id="+id+", memberID="+memberID+", "+"memberID="+memberID+",activityID="+activityID+",crmActivityID="+crmActivityID;
	}
}
