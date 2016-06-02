/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service.util;

import java.io.Serializable;

/**
 * 请求对象
 * @ClassName: CRMRequestEntity 
 * @author Walter.xu
 * @date 2015年8月4日 下午1:53:52
 */
public class CRMRequestEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String TYPE_REGISTER = "REGISTER";
	public static final String TYPE_BIND_MOBILE = "BIND_MOBILE";
	public static final String TYPE_QUERY_USER = "QUERY_USER";
	public static final String TYPE_QUERY_INTEGRAL = "QUERY_INTEGRAL";
	public static final String TYPE_UPDATE_USER = "UPDATE_USER";
	// 调用接口失败次数
	private int failedCount = 0;
	private int weMemberID; // member 主键ID
	private String wechatID;
	private String memberID;
	private String type;
	private String mobile;
	private String name;
	private String sex;
	private String birthday;
	@Override
	public String toString(){
		if (type.equals(TYPE_REGISTER)) {
			return type+","+wechatID;
		}else if (type.equals(TYPE_BIND_MOBILE)) {
			return type+","+memberID+","+mobile;
		}else if (type.equals(TYPE_QUERY_USER)) {
			return type+","+memberID;
		}else if (type.equals(TYPE_QUERY_INTEGRAL)) {
			return type+","+memberID;
		}else if (type.equals(TYPE_UPDATE_USER)) {
			return type+","+memberID+","+name+","+sex+","+birthday;
		}else {
			return type+","+memberID+","+name+","+sex+","+birthday+","+wechatID+","+mobile;
		}
	}
	/**
	 * 设置"注册"接口的相关参数
	 * @param wechatID
	 */
	public void setCRMRegister(int weMemberID, String wechatID){
		this.type = TYPE_REGISTER;
		this.weMemberID = weMemberID;
		this.wechatID = wechatID;
	}
	/**
	 * 设置"更新用户"接口的相关参数
	 * @param memberID
	 * @param name
	 * @param sex
	 * @param birthday
	 */
	public void setCRMUpdateUser(int weMemberID, String memberID, String name, String sex, String birthday){
		this.type = TYPE_UPDATE_USER;
		this.weMemberID = weMemberID;
		this.memberID = memberID;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}
	/**
	 * 设置"查询用户信息"接口的相关参数
	 * @param memberID
	 */
	public void setCRMQueryUser(int weMemberID, String memberID){
		this.type = TYPE_QUERY_USER;
		this.weMemberID = weMemberID;
		this.memberID = memberID;
	}
	/**
	 * 设置"查询用户积分"接口的相关参数
	 * @param memberID
	 */
	public void setCRMQueryIntegral(int weMemberID, String memberID){
		this.type = TYPE_QUERY_INTEGRAL;
		this.weMemberID = weMemberID;
		this.memberID = memberID;
	}
	/**
	 * 设置"绑定用户手机"接口的相关参数
	 * @param memberID
	 * @param mobile
	 */
	public void setCRMBindMobile(int weMemberID, String memberID, String mobile){
		this.type = TYPE_BIND_MOBILE;
		this.weMemberID = weMemberID;
		this.memberID = memberID;
		this.mobile = mobile;
	}
	
	public int getFailedCount() {
		return failedCount;
	}
	public String getWechatID() {
		return wechatID;
	}
	public String getMemberID() {
		return memberID;
	}
	public String getType() {
		return type;
	}
	public String getMobile() {
		return mobile;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void addFailedCount() {
		this.failedCount++;
	}
	public int getWeMemberID(){
		return weMemberID;
	}
}
