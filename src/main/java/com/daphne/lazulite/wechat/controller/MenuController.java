/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.controller;

import com.daphne.lazulite.wechat.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value="api/wechat/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	
	@RequestMapping(value="/createMenu")
	public void createMenu(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException{
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		 this.menuService.createMunu();
		response.getWriter().print("sucess");
	}
	@RequestMapping(value="/delMenu")
	public void delMenu(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException{
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		response.getWriter().print("success");
	}
	@RequestMapping(value="/getMenu")
	public void getMenu(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException{
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(this.menuService.getMenu());
	}
}
