/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.controller;


import com.daphne.lazulite.wechat.domain.BarCodeInfo;
import com.daphne.lazulite.wechat.entity.WeMember;
import com.daphne.lazulite.wechat.service.BarCodeService;
import com.daphne.lazulite.wechat.service.WeMemberService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
@RequestMapping("api/wechat/barCode")
public class BarCodeController {
	private Logger logger = LoggerFactory.getLogger(BarCodeController.class);
	@Autowired
	private BarCodeService barCodeService;
	@Autowired
	private WeMemberService memberService;
	
	@RequestMapping(value="/personnalBarCode")
	@ResponseBody
	public void personnalBarCode(String openId, HttpServletRequest request, HttpServletResponse response){
		try {
			WeMember memeber = memberService.queryByOpenId(openId);
			if(memeber==null|| StringUtils.isEmpty(memeber.getMemberNumber())){
				logger.debug("response default barcode image !openId=["+openId+"]");
				this.responseDefaultImg(response);
			}else{
				String message = memeber==null?null:memeber.getMemberNumber();
				this.barCode(message, response);
			}
		} catch (Exception e) {
			logger.error("get personnalBarCode exception",e.getMessage(),e);
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/barCode/{message}")
	@ResponseBody
	public void barCode(@PathVariable String message, HttpServletResponse response){
		try {
			BarCodeInfo barCodeInfo = new BarCodeInfo();
			barCodeInfo.setMsg(message);
			barCodeInfo.setHrp("bottom");//  none  top  bottom
			barCodeService.createBarCode(barCodeInfo, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	private void responseDefaultImg(HttpServletResponse response){
		InputStream fis= null;
		OutputStream os = null;
		try {
			response.setContentType("image/gif");
			fis = getClass().getClassLoader().getResourceAsStream("image/err.gif");
			os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while( (len=fis.read(buffer)) != -1 ){
				os.write(buffer, 0, len);
			}
			os.flush();
		} catch (Exception e) {
			logger.error("get default barcode image exception",e.getMessage(), e);
		} finally{
			if (os!=null) {
				try{os.close();}catch(Exception e){}
			}
			if (fis!=null) {
				try{fis.close();}catch(Exception e){}
			}
		}
	
	}
}
