/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service.util;



import com.daphne.lazulite.wechat.entity.WeMember;
import com.daphne.lazulite.wechat.entity.WeMessage;

import java.io.Serializable;

/**
 * 返回用戶消息類，用於定義傳輸與redis中的消息信息，
 * @ClassName: MessageResponseEntity 
 * @author Walter.xu
 * @date 2015年7月28日 下午2:38:13
 */
public class MessageResponseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;     //member.id
	private String openID;  //member.wechatID 微信ID
	private String memberID;       // member.memberID Daphne crm id
	private Integer messageID;     // message.id 
	private String messageType;    // message.messageType 
	private String message;        // message.message  
	private Integer messageProcessID;   // message.processID
	
	private Integer referenceID;   // 关联ID， 如FilmTicketOffline.id
	private Integer failCount = 0;      // message.failCount
	@Override
	public String toString(){
		return "id="+id+",memberID="+memberID+",messageID="+messageID+",messageType="+messageType+",message="+message;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public Integer getMessageID() {
		return messageID;
	}
	public void setMessageID(Integer messageID) {
		this.messageID = messageID;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getFailCount() {
		return failCount;
	}
	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}
	public Integer getMessageProcessID() {
		return messageProcessID;
	}
	public void setMessageProcessID(Integer messageProcessID) {
		this.messageProcessID = messageProcessID;
	}
	public Integer getReferenceID() {
		return referenceID;
	}
	public void setReferenceID(Integer referenceID) {
		this.referenceID = referenceID;
	}
	public void setMember(WeMember member){
		if (member!=null) {
			this.id = member.getId();
			this.memberID = member.getMemberId();
			this.openID = member.getWechatId();
		}
	}
	public void setMessage(WeMessage message){
		if (message!=null) {
			this.messageID = message.getId();
			this.message = message.getMessage();
			this.messageType = message.getMessageType();
			this.messageProcessID = message.getProcessId();
		}
	}
}
