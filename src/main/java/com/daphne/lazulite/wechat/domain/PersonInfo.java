/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.domain;



import com.daphne.lazulite.wechat.entity.WeMember;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 达芙妮会员信息对象
 * @author TangMj
 *
 */
public class PersonInfo {
	private String name;
	private String openID;
	private String sex;
	private Date birthday;
	private String phoneNum;
	private String shopCode;
	private String memberId;
	private int integral;
	
	public void setWeMember(WeMember member){
		if (!StringUtils.isEmpty(member.getName())) {
			this.name = member.getName();
		}
		if (!StringUtils.isEmpty(member.getSex())) {
			this.sex = member.getSex();
		}
		if (member.getBirthday()!=null) {
			this.birthday = member.getBirthday();
		}
		if (!StringUtils.isEmpty(member.getPhoneNum())) {
			this.phoneNum = member.getPhoneNum();
		}
		if (!StringUtils.isEmpty(member.getShopCode())) {
			this.shopCode = member.getShopCode();
		}
		if (!StringUtils.isEmpty(member.getMemberId())) {
			this.memberId = member.getMemberId();
		}
		/*if (!StringUtils.isEmpty(member.getWechatId())) {
			this.openID = member.getWechatId();
		}*/
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getWeMemberId() {
		return memberId;
	}
	public void setWeMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}
	
}
