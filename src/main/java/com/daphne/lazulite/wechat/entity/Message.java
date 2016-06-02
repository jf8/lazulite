/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.entity;

import java.util.Date;

public class Message {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.we_member_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private Integer weMemberId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.member_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private String memberId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.activity_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private Integer activityId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.is_send
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private Integer isSend;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.sent_date
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private Date sentDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.create_time
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.update_time
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private Date updateTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.process_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private Integer processId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.message_type
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private String messageType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.state
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private Integer state;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.failure_time
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private Integer failureTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column we_message.message
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	private String message;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.id
	 * @return  the value of we_message.id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.id
	 * @param id  the value for we_message.id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.we_member_id
	 * @return  the value of we_message.we_member_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public Integer getWeMemberId() {
		return weMemberId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.we_member_id
	 * @param weMemberId  the value for we_message.we_member_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setWeMemberId(Integer weMemberId) {
		this.weMemberId = weMemberId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.member_id
	 * @return  the value of we_message.member_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.member_id
	 * @param memberId  the value for we_message.member_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.activity_id
	 * @return  the value of we_message.activity_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public Integer getActivityId() {
		return activityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.activity_id
	 * @param activityId  the value for we_message.activity_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.is_send
	 * @return  the value of we_message.is_send
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public Integer getIsSend() {
		return isSend;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.is_send
	 * @param isSend  the value for we_message.is_send
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setIsSend(Integer isSend) {
		this.isSend = isSend;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.sent_date
	 * @return  the value of we_message.sent_date
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public Date getSentDate() {
		return sentDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.sent_date
	 * @param sentDate  the value for we_message.sent_date
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.create_time
	 * @return  the value of we_message.create_time
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.create_time
	 * @param createTime  the value for we_message.create_time
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.update_time
	 * @return  the value of we_message.update_time
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.update_time
	 * @param updateTime  the value for we_message.update_time
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.process_id
	 * @return  the value of we_message.process_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public Integer getProcessId() {
		return processId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.process_id
	 * @param processId  the value for we_message.process_id
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.message_type
	 * @return  the value of we_message.message_type
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.message_type
	 * @param messageType  the value for we_message.message_type
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.state
	 * @return  the value of we_message.state
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.state
	 * @param state  the value for we_message.state
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.failure_time
	 * @return  the value of we_message.failure_time
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public Integer getFailureTime() {
		return failureTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.failure_time
	 * @param failureTime  the value for we_message.failure_time
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setFailureTime(Integer failureTime) {
		this.failureTime = failureTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column we_message.message
	 * @return  the value of we_message.message
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column we_message.message
	 * @param message  the value for we_message.message
	 * @mbggenerated  Mon Jul 27 11:05:35 CST 2015
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}