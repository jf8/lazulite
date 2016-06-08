/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat;

import java.sql.Timestamp;

/**
 * 微信拉取的用户信息
 * @author TangMj
 *
 */
public class WechatUserInfo {
	/**值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID*/
	private int subscribe;
	/**用户的标识，对当前公众号唯一 */
	private String  openid;
	/**用户的昵称 */
	private String  nickname;
	/**值为1时是男性，值为2时是女性，值为0时是未知 */
	private int  sex;
	/**用户的语言，简体中文为zh_CN */
	private String language;
	/**用户所在省份 */
	private String  province;
	/**用户所在城市*/
	private String  city;
	/**用户所在国家 */
	private String  country;
	/**用户关注时间，为时间戳*/
	private Timestamp subscribeTime;
	private String  headimgurl;
	/**只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段*/
	private String unionid;
	/**公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注*/
	private String remark;
	/**用户所在的分组ID */
	private int groupid;
	public int getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Timestamp getSubscribeTime() {
		return subscribeTime;
	}
	public void setSubscribeTime(Timestamp subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	@Override
	public String toString() {
		return "WechatUserInfo [subscribe=" + subscribe + ", openid=" + openid
				+ ", nickname=" + nickname + ", sex=" + sex + ", language="
				+ language + ", province=" + province + ", city=" + city
				+ ", country=" + country + ", subscribeTime=" + subscribeTime
				+ ", headimgurl=" + headimgurl + ", unionid=" + unionid
				+ ", remark=" + remark + ", groupid=" + groupid + "]";
	}
	
}
