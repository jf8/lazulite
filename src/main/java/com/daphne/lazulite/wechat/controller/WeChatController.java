/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.controller;

import com.daphne.lazulite.wechat.MyWechat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信入口
 * @author TangMj
 *
 */
@Controller
@RequestMapping(value="/wechat")
public class WeChatController {
	private Logger logger = LoggerFactory.getLogger(WeChatController.class);
	/**
	 * 微信配置url:
	 * http://o2o.dev.sigmad.net/o2o/wechat/wechat.do
	 * 
	 */
	
	/**
	 * 用于微信验证
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/wechat",method= RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			MyWechat wechat = new MyWechat(request);
			String result = wechat.execute();
			response.getOutputStream().write(result.getBytes("UTF-8"));
		} catch (IOException e) {
			logger.error("wechat request failed on a get request ==>:",e.getMessage(),e);
		}
	}
	/**
	 * 用于微信处理信息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/wechat",method= RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			MyWechat wechat = new MyWechat(request);
			String result = wechat.execute();
			response.getOutputStream().write(result.getBytes("UTF-8"));
		} catch (IOException e) {
			logger.error("wechat request failed on a post request ==>:",e.getMessage(),e);
		}
	}
}
