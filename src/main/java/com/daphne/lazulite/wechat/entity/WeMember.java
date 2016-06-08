/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.entity;

import com.daphne.lazulite.common.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.Date;

/**
 * Created by junfu on 2016/6/3.
 */
@Entity
@javax.persistence.Table(name = "we_member")
public class WeMember extends BaseEntity<Integer> {


    private String wechatId;

    @Basic
    @javax.persistence.Column(name = "wechat_id")
    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    private String memberId;

    @Basic
    @javax.persistence.Column(name = "member_id")
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    private String memberNumber;

    @Basic
    @javax.persistence.Column(name = "member_number")
    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    private String phoneNum;

    @Basic
    @javax.persistence.Column(name = "phoneNum")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }




    private String name;

    @Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String shopCode;

    @Basic
    @javax.persistence.Column(name = "shop_code")
    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    private Integer isActive;

    @Basic
    @javax.persistence.Column(name = "is_active")
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    private Date inactiveDate;

    @Basic
    @javax.persistence.Column(name = "inactive_date")
    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    private String weMembercol;

    @Basic
    @javax.persistence.Column(name = "we_membercol")
    public String getWeMembercol() {
        return weMembercol;
    }

    public void setWeMembercol(String weMembercol) {
        this.weMembercol = weMembercol;
    }

    private Integer channelQrcodeId;

    @Basic
    @javax.persistence.Column(name = "channel_qrcode_id")
    public Integer getChannelQrcodeId() {
        return channelQrcodeId;
    }

    public void setChannelQrcodeId(Integer channelQrcodeId) {
        this.channelQrcodeId = channelQrcodeId;
    }

    private Integer isOldMember;

    @Basic
    @javax.persistence.Column(name = "is_old_member")
    public Integer getIsOldMember() {
        return isOldMember;
    }

    public void setIsOldMember(Integer isOldMember) {
        this.isOldMember = isOldMember;
    }

    private String sex;

    @Basic
    @javax.persistence.Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private Date birthday;

    @Basic
    @javax.persistence.Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private Integer points;

    @Basic
    @javax.persistence.Column(name = "points")
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }



}
