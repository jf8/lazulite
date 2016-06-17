/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat;

import java.io.File;

public class MadhouseConst {
	// ##############################################
	// ### 自定义常量
	// ##############################################
	public static final boolean IS_DEBUGING = false;
	// message status
	public static final int STATE_MESSAGE_UNLOAD_COUPON = 0;   // 为加载coupon信息
	public static final int STATE_MESSAGE_LOADED_COUPON = 5;   // 已经获取到coupon信息但未发送消息给用户
	public static final int STATE_MESSAGE_SUCCESS = 1;         // 已经获取到coupon,并发送消息成功
	public static final int STATE_MESSAGE_FAILED= 2;           // 发送消息失败
	
	// ##############################################
	// ### 配置常量信息
	// ##############################################
	
	// daphne ftp文件相关
	public static String DAPHNE_FTP_FOLDER = "/services/data/ftp/daphne";             // daphne ftp默认路径地址
	public static String DAPHNE_FTP_OFFLINE_MOVIE_TKT_FILE_PREFIX = "TicketOffline";  // 以该参数开头的为线下门店的待发送电影票文件
	public static String DAPHNE_FTP_ONLINE_MOVIE_TKT_FILE_PREFIX = "TicketOnline";    // 以该参数开头的为线上门店的待发送电影票文件
	public static String DAPHNE_FTP_RE_REGISTER_USER_PREFIX ="UnResiteredUser";       // 以该参数开头的为未注册成功的wechatID列表，重新注册
	public static String DAPHNE_FTP_MEMBER_ADJUST_PREFIX = "CRM_AUS_WECHAT_VIP";      // 以该参数开头的未需要纠正的memberID列表
	public static String DAPHNE_FTP_SHOP_COUPON_RELOAD_PREFIX = "shopCouponReload";   // 以该参数开头的需重新加载获取优惠券列表的用户
	
	// 本地文件存放配置地址
	public static String PATH_LOCAL_STORAGE_FOLDER = "/services/data/backup";                               // 备份文件夹
	public static String PATH_LOCAL_FTP_MOVING_FOLDER = PATH_LOCAL_STORAGE_FOLDER+File.separator+"MOVING";  // 待执行的文件夹-还未将数据导入到数据库中
	public static String PATH_LOCAL_FTP_MOVED_FOLDER = PATH_LOCAL_STORAGE_FOLDER+File.separator+"MOVED";    // 已执行的文件夹-数据已经导入到数据库中
	public static int PATH_LOCAL_BATCH_SIZE = 200;                                                          // 拆分的每个文件的行数大小，以该大小批量将数据导入到数据库中，
	
	// 短信相关
	public static String DAPHNE_SMS_USERNAME = "madhouse";
	public static String DAPHNE_SMS_PASSWORD = "madhouse20150623";
	public static String DAPHNE_SMS_ADDRESS = "http://218.83.242.235:8080/Sender.asmx?wsdl";
	public static String DAPHNE_SMS_TEMPLATE = "您的验证码是：#CODE，请尽快使用，验证码将在30分钟后失效，失效请重新获取。回复TD退订";
	public static int DAPHNE_SMS_INVALID_TIME = 5;                    // 短信过期时间，放在redis缓存中
	
	// wechat ID配置
	@Deprecated
	public static String MULTI_WP_ID_OF_OFFLINE_MESSAGE="IjnlbhfE9BOJtNl28h4RuRPuixnH0EV1YHdYYtjSncI"; 
	@Deprecated
	public static String TEMPLATE_ID_OF_RECEIVING_COUPONS="FumB-92uAQxoG4RoO3Xj9Qe8pp4fsksg_QenKuI7cF8";
	public static String TEMPLATE_ID_OF_USING_COUPONS="FumB-92uAQxoG4RoO3Xj9Qe8pp4fsksg_QenKuI7cF8";
	public static String WECHAT_TOKEN_ADDRESS = null;    // 获取链接wechat服务器的token地址，从ui中获取
	// 微信消息配置相关
//	public static String WECHAT_MOVIE_URL = "http://www.baidu.com";
	
	// 微信消息配置相关
	public static String MESSAGE_FILM_TICKET_CLAIM = "恭喜您获得有悦无限赠送的电影票#{ticketNum}张，请<a href=\"http://www.baidu.com\">点击领取</a>。请在48小时内完成领取，逾期不领取的视为自动放弃。领取后尽快进入微信卡包使用《落跑吧爱情》的电影票进行选座观影（或进入微信公众号\"电影演出票\"-\"我的\"-\"订单\"-\"选座券\"使用）。\\n具体可兑换院线以微信公众号“电影演出票”中上映《落跑吧爱情》的影院为准，全国通用。《落跑吧爱情》影片下档后赠送的电影票将不再可用，视为自动放弃观影机会。";
	public static String MESSAGE_SHOP_COUPON_VIEW = "恭喜您获得有悦无限赠送的千元礼包一份，请进入“个人中心”-“我的优惠”查看。";
	public static String MESSAGE_SHOP_COUPON_COMPLETE_USER_INFO = "恭喜您获得有悦无限赠送的千元礼包一份，请进入“个人中心”绑定手机并完善个人资料，系统将在24小时内自动为您发放。";
	public static String MESSAGE_COMPLETE_USER_INFO = "请进入“个人中心”绑定手机并完善个人资料。";
	public static String MESSAGE_SHOP_COUPON_CLAIM = "恭喜您获得有悦无限赠送的千元礼包一份，请稍后进入“个人中心”-“我的优惠”查看。";
	public static String MESSAGE_SHOP_COUPON_CLAIM_ALREADY ="您已经领取过有悦无限赠送的千元大礼包，请进入“个人中心”-“我的优惠”查看";
	
	// 发送电影票的限制渠道或者品牌
	public static String LIMITS_SHOPCOUPON_OFFLINE_BRAND = "鞋柜,达芙妮";  // 线下门店中可以发送优惠券的品牌列表
	public static String[] LIMITS_SHOPCOUPON_CHANNELS = new String[]{"87"};               // 可以发送优惠券的渠道id列表,通we_channel_qrcode的主键ID
	
	// Daphne接口WSDL地址
	public static String DAPHNE_CRM_WS_ADDRESS = "http://116.247.121.54:8888/Crm_Madhouse_App-Crm_Madhouse_Pro-context-root/Crm_Madhouse_WebSoapHttpPort?wsdl";


	//获取微信客服聊天记录时间间隔（分钟）
	public static int WECHAT_CUSTOMER_RECORD_INTERVAL = 5;
}
