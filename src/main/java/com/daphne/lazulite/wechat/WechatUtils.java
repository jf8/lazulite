/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sword.wechat4j.token.TokenProxy;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WechatUtils {
	private static Logger logger = LoggerFactory.getLogger(WechatUtils.class);
	private static String USERINFOURL= "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public static WechatUserInfo getUserInfo(String openId){
		if(StringUtils.isEmpty(openId)){
			return null;
		}
		WechatUserInfo userInfo = new WechatUserInfo();
		String access_token = null;
		try {
			access_token = TokenProxy.accessToken();
			String url = USERINFOURL;
			url = url.replace("ACCESS_TOKEN",access_token);
			url = url.replace("OPENID", openId);
			String jsonString = null;
			URL wcUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) wcUrl.openConnection(); 
			connection.setConnectTimeout(3000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            int code = connection.getResponseCode();
            if(code ==200){
            	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int len = 0;
                byte[] data = new byte[1024];
            	InputStream inputStream = connection.getInputStream();
                while((len = inputStream.read(data))!=-1){
                    outputStream.write(data,0,len);
                }
                jsonString = new String(outputStream.toByteArray(),"UTF-8");
                logger.debug("get wechat user info succeed!");
                connection.disconnect();
            }else{
            	logger.warn("get wechat user info failed! response code from wechat is ["+code+"]");
            	connection.disconnect();
            	return null;
            }
          //String result = HttpUtils.get(url);
    		JSONObject jsonObject = JSONObject.parseObject(jsonString);
    		
    		userInfo.setCity(jsonObject.getString("city"));
    		userInfo.setCountry(jsonObject.getString("country"));
    		userInfo.setProvince(jsonObject.getString("province"));
    		userInfo.setLanguage(jsonObject.getString("language"));
    		userInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
    		userInfo.setNickname(stringFilter(jsonObject.getString("nickname")));
    		userInfo.setOpenid(jsonObject.getString("openid"));
    		userInfo.setUnionid(jsonObject.getString("unionid"));
    		userInfo.setGroupid(jsonObject.getIntValue("groupid"));
    		userInfo.setSex(jsonObject.getIntValue("sex"));
    		userInfo.setSubscribe(jsonObject.getIntValue("subscribe"));
    		userInfo.setSubscribeTime(jsonObject.getTimestamp("subscribe_time"));
		} catch (Exception e) {
			logger.error("get  wechat user info exception,[access_token="+access_token+"],[openId="+openId+"], ==>:",e.getMessage(),e);
		}
		
		return userInfo;
	}
	
	/**
	 * 过滤掉除用户昵称中的表情符号 
	 * @param str
	 * @return
	 */
	public static String stringFilter(String str){
		if(str==null){
			return null;
		}
		String regEx="[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";     
		Pattern p = Pattern.compile(regEx);        
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
}
