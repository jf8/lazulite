/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.controller;

import com.daphne.lazulite.wechat.dto.CommonResultDto;
import com.daphne.lazulite.wechat.service.WePersonCenteredService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value="api/wechat/personCentered")
public class PersonCenteredController {
	@Autowired
	private WePersonCenteredService personCenteredService;
	/**
	 * 跳转到个人中心页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="info")
	@ResponseBody
	public CommonResultDto PersonCentered(String openId){
		return this.personCenteredService.info(openId);
	}
	/**
	 * 获取手机验证码
	 */
	@RequestMapping(value="getVerificationCode")
	@ResponseBody
	public void getVerificationCode(String phoneNum,String openId){
		personCenteredService.getVerificationCode(phoneNum,openId);
	}
	
	/**
	 * 绑定会员
	 */
	@RequestMapping(value="bindMember")
	@ResponseBody
	public CommonResultDto bindMember(String verificationCode,String openId,String phoneNum){
		return personCenteredService.bindMember(verificationCode,openId,phoneNum);
	}
	
	/**
	 * 修改个人信息
	 * @param name
	 * @param birthday
	 * @param sex
	 */
	@RequestMapping(value="updateUserInfo")
	@ResponseBody
	public CommonResultDto updateUserInfo(String openId,String name,Date birthday,String sex){
		return personCenteredService.updateUserInfo(openId,name,birthday,sex);
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));//true:允许输入空值，false:不能为空值
	}
}
