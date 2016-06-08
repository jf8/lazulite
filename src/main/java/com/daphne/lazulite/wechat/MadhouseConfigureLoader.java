
/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取配置文件类，由spring初始化
 * @ClassName: MadhouseConfigureLoader 
 * @author Walter.xu
 * @date 2015年7月3日 下午4:59:22
 */
public class MadhouseConfigureLoader {
	protected transient Logger logger = LoggerFactory.getLogger(this.getClass());
	private static Properties properties = new Properties();
	public MadhouseConfigureLoader(String resource){
		init(resource);
	}
	/**
	 * 构造函时创建
	 * @param resource
	 */
	private void init(String resource){
		BufferedReader reader = null;
		try {
			// 读取properties
			InputStream is = this.getClass().getResourceAsStream(resource);
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			properties.load(reader);
			// Local folder path setting
			initLocalFolderConfig();
			initSMSConfig();
			initDaphneCRMConfig();
			initWechatConfig();
			initWechatMessageConfig();
			initLimitsConfig();
			initWechatCustomerRecord();
			logger.info("Success to load configure data into MadhouseConst class");
		} catch (Exception e) {
			logger.error("Error to load configure file: "+resource+", message="+e.getMessage(), e);
		} finally{
			if (reader!=null) {
				try{reader.close();}catch(Exception e){}
			}
		}
	}
	/**
	 * 设置SMS短信的相关配置
	 */
	private void initSMSConfig(){
		if (getString("sms.username")!=null) {
			MadhouseConst.DAPHNE_SMS_USERNAME = getString("sms.username");
		}
		if (getString("sms.password")!=null) {
			MadhouseConst.DAPHNE_SMS_PASSWORD = getString("sms.password");
		}
		if (getString("sms.address")!=null) {
			MadhouseConst.DAPHNE_SMS_ADDRESS = getString("sms.address");
		}
		if (getString("sms.template")!=null) {
			MadhouseConst.DAPHNE_SMS_TEMPLATE = getString("sms.template");
		}
		if (getInteger("sms.invalidTime",null)!=null) {
			MadhouseConst.DAPHNE_SMS_INVALID_TIME = getInteger("sms.invalidTime", null);
		}
		logger.info("[SMS] SMS address="+MadhouseConst.DAPHNE_SMS_ADDRESS);
		logger.info("[SMS] SMS username="+MadhouseConst.DAPHNE_SMS_USERNAME);
		logger.info("[SMS] SMS password="+MadhouseConst.DAPHNE_SMS_PASSWORD);
		logger.info("[SMS] SMS template="+MadhouseConst.DAPHNE_SMS_TEMPLATE);
		logger.info("[SMS] SMS invalidTime="+MadhouseConst.DAPHNE_SMS_INVALID_TIME);
	}
	/**
	 * 初始化daphne crm接口wsdl配置信息
	 */
	private void initDaphneCRMConfig(){
		if (!org.apache.commons.lang3.StringUtils.isEmpty(getString("daphne.crm.address"))) {
			MadhouseConst.DAPHNE_CRM_WS_ADDRESS = getString("daphne.crm.address");
		}
		logger.info("[DAPHNE CRM] CRM wsdl address = "+MadhouseConst.DAPHNE_CRM_WS_ADDRESS);
	}
	
	/**
	 * 设置本地文件夹的相关配置，在处理Daphne FTP文件时使用
	 */
	private void initLocalFolderConfig(){
		if (getString("config.daphneLocalFolder")!=null) {
			MadhouseConst.PATH_LOCAL_STORAGE_FOLDER = getString("config.daphneLocalFolder");
			MadhouseConst.PATH_LOCAL_FTP_MOVING_FOLDER = MadhouseConst.PATH_LOCAL_STORAGE_FOLDER+File.separator+"MOVING";
			MadhouseConst.PATH_LOCAL_FTP_MOVED_FOLDER = MadhouseConst.PATH_LOCAL_STORAGE_FOLDER+File.separator+"MOVED";
		}
		if (getString("config.daphneFTPFolder")!=null) {
			MadhouseConst.DAPHNE_FTP_FOLDER = getString("config.daphneFTPFolder");
		}
		if (getInteger("config.fileLoadBatchSize", null)!=null) {
			MadhouseConst.PATH_LOCAL_BATCH_SIZE = getInteger("config.fileLoadBatchSize", null);
		}
		if (getString("config.daphneFTPFileOfflinePrefix")!=null) {
			MadhouseConst.DAPHNE_FTP_OFFLINE_MOVIE_TKT_FILE_PREFIX = getString("config.daphneFTPFileOfflinePrefix");
		}
		if (getString("config.daphneFTPFileOnlinePrefix")!=null) {
			MadhouseConst.DAPHNE_FTP_ONLINE_MOVIE_TKT_FILE_PREFIX = getString("config.daphneFTPFileOnlinePrefix");
		}
		logger.info("[FTP CONNECT] LOCAL FOLDER PATH = "+MadhouseConst.PATH_LOCAL_STORAGE_FOLDER);
		logger.info("[FTP CONNECT] LOCAL MOVING PATH = "+MadhouseConst.PATH_LOCAL_FTP_MOVING_FOLDER);
		logger.info("[FTP CONNECT] LOCAL MOVIED PATH = "+MadhouseConst.PATH_LOCAL_FTP_MOVED_FOLDER);
		logger.info("[FTP CONNECT] DAPHNE FTP PATH = "+MadhouseConst.DAPHNE_FTP_FOLDER);
		logger.info("[FTP CONNECT] FILE BATCH SIZE = "+MadhouseConst.PATH_LOCAL_BATCH_SIZE);
		logger.info("[FTP CONNECT] ONLINE PREFIX = "+MadhouseConst.DAPHNE_FTP_ONLINE_MOVIE_TKT_FILE_PREFIX);
		logger.info("[FTP CONNECT] OFFLINE PREFIX = "+MadhouseConst.DAPHNE_FTP_OFFLINE_MOVIE_TKT_FILE_PREFIX);
		
	}
	/**
	 * 初始化微信的相关配置，如果模板ID的配置
	 */
	private void initWechatConfig(){
		if (getString("wechat.id.wpmessage")!=null) {
			MadhouseConst.MULTI_WP_ID_OF_OFFLINE_MESSAGE = getString("wechat.id.wpmessage");
		}
		if (getString("wechat.id.couponReceivedTemplate")!=null) {
			MadhouseConst.TEMPLATE_ID_OF_RECEIVING_COUPONS = getString("wechat.id.couponReceivedTemplate");
		}
		if (getString("wechat.id.couponUsedTemplate")!=null) {
			MadhouseConst.TEMPLATE_ID_OF_USING_COUPONS = getString("wechat.id.couponUsedTemplate");
		}
		if (getString("wechat.tokenAddress")!=null) {
			MadhouseConst.WECHAT_TOKEN_ADDRESS = getString("wechat.tokenAddress");
		}
		logger.info("[WECHAT CONFIG] TOKEN ADDRESS="+MadhouseConst.WECHAT_TOKEN_ADDRESS);
		logger.info("[WECHAT CONFIG] couponUsedTemplate="+MadhouseConst.TEMPLATE_ID_OF_USING_COUPONS);
	}
	/**
	 * 初始化发送给用户的消息模板配置，
	 */
	private void initWechatMessageConfig(){
		if (getString("message.filmTicket.claim")!=null) {
			MadhouseConst.MESSAGE_FILM_TICKET_CLAIM = getString("message.filmTicket.claim");
		}
		if (getString("message.completeUserInfo")!=null) {
			MadhouseConst.MESSAGE_COMPLETE_USER_INFO = getString("message.completeUserInfo");
		}
		if (getString("message.shopCoupon.claim")!=null) {
			MadhouseConst.MESSAGE_SHOP_COUPON_CLAIM = getString("message.shopCoupon.claim");
		}
		if (getString("message.shopCoupon.completeUserInfo")!=null) {
			MadhouseConst.MESSAGE_SHOP_COUPON_COMPLETE_USER_INFO = getString("message.shopCoupon.completeUserInfo");
		}
		if (getString("message.shopCoupon.view")!=null) {
			MadhouseConst.MESSAGE_SHOP_COUPON_VIEW = getString("message.shopCoupon.view");
		}
		if (getString("message.shopCoupon.claim.already")!=null) {
			MadhouseConst.MESSAGE_SHOP_COUPON_CLAIM_ALREADY = getString("message.shopCoupon.claim.already");
		}
	}
	/**
	 * 初始化限制性信息配置，主要为可发优惠券的品牌以及可发优惠券的渠道ID
	 */
	private void initLimitsConfig(){
		if (getString("sendCoupons.limits.offline.brands")!=null) {
			MadhouseConst.LIMITS_SHOPCOUPON_OFFLINE_BRAND = getString("sendCoupons.limits.offline.brands");
		}
		if (getString("sendCoupons.limits.channels")!=null) {
			MadhouseConst.LIMITS_SHOPCOUPON_CHANNELS = getString("sendCoupons.limits.channels").replaceAll(";", ",").split(",");
		}
	}
	/**
	 * 初始化获取客服聊天记录的时间间隔
	 */
	private void initWechatCustomerRecord(){
		if(getInteger("wechat.customer.record.interval",null)!=null){
			MadhouseConst.WECHAT_CUSTOMER_RECORD_INTERVAL = getInteger("wechat.customer.record.interval");
		}
		logger.info("the minutes of WECHAT_CUSTOMER_RECORD_INTERVAL is ["+MadhouseConst.WECHAT_CUSTOMER_RECORD_INTERVAL+"]");
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	protected String getString(String key){
		try {
			Object object = properties.get(key);
			return object==null?null:object.toString();
		} catch (Exception e) {
		}
		return null;
	}
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	protected Integer getInteger(String key, Integer defaultValue){
		try {
			Object object = properties.get(key);
			return object==null?defaultValue:Integer.valueOf(object.toString().trim());
		} catch (Exception e) {
		}
		return defaultValue;
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	protected Integer getInteger(String key){
		return getInteger(key, null);
	}
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	protected Double getDouble(String key, Double defaultValue){
		try {
			Object object = properties.get(key);
			return object==null?defaultValue:Double.valueOf(object.toString().trim());
		} catch (Exception e) {
		}
		return defaultValue;
	}
	protected Long getLong(String key, Long defaultValue){
		try {
			Object object = properties.get(key);
			return object==null?defaultValue:Long.valueOf(object.toString().trim());
		} catch (Exception e) {
		}
		return defaultValue;
	}
	/**
	 * 从properties中通过KEY获取对应的value值
	 * @param key
	 * @return
	 */
	public static String get(String key){
		Object object = properties.get(key);
		return object==null?null:object.toString();
	}
}
