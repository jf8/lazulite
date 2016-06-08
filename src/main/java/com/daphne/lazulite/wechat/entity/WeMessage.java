/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.entity;

import com.daphne.lazulite.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by junfu on 2016/6/3.
 */
@Entity
@Table(name = "we_message")
public class WeMessage extends BaseEntity<Integer> {

    private Integer weMemberId;
    private String memberId;
    private Integer activityId;
    private String message;
    private Integer isSend;
    private Date sentDate;

    private Integer processId;
    private String messageType;
    private Integer state;
    private Integer failureTime;



    @Basic
    @Column(name = "we_member_id")
    public Integer getWeMemberId() {
        return weMemberId;
    }

    public void setWeMemberId(Integer weMemberId) {
        this.weMemberId = weMemberId;
    }

    @Basic
    @Column(name = "member_id")
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "activity_id")
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "is_send")
    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    @Basic
    @Column(name = "sent_date")
    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }



    @Basic
    @Column(name = "process_id")
    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    @Basic
    @Column(name = "message_type")
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "failure_time")
    public Integer getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(Integer failureTime) {
        this.failureTime = failureTime;
    }


}
