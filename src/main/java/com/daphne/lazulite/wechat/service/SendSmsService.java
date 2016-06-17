/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

import com.daphne.lazulite.wechat.WechatProperties;
import com.daphne.lazulite.wechat.entity.WeSystemLog;
import com.daphne.lazulite.wechat.service.util.Base64;
import com.madhouse.daphne.sms.client.Sender;
import com.madhouse.daphne.sms.client.SenderSoap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;

/**
 * Created by junfu on 2016/6/2.
 */
@Service
public class SendSmsService {
    protected  Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private SystemLogService systemLogService;
    private SenderSoap senderService = null;
    @Autowired
    private WechatProperties wechatProperties;

    /**
     * 发送短信<BR>
     * 1 调用daphne短信接口发送短信<BR>
     * 2 将调用结果保存入systemLog表中
     *
     * @param mobile  手机号
     * @param content 短信内容
     * @return
     */
    public boolean sendSMS(String mobile, String content) {
        // 短信内容需要做base64编码，且必须使用UTF-8格式
//		String smsBody = CommonUtils.isEmpty(MadhouseConst.DAPHNE_SMS_TEMPLATE)?formatSMSSoapBody():MadhouseConst.DAPHNE_SMS_TEMPLATE;
//		smsBody = smsBody.replace("#{USERNAME}", username).replace("#{PASSWORD}", this.password)
//				.replace("#{MOBILE}", mobile).replace("#{CONTENT}", Base64.getBase64(content));
        boolean isSuccess = false;
        WeSystemLog log = new WeSystemLog();
        log.setFunctionType(SystemLogService.TYPE_SMS);

        log.setCreateTime(new Date());
        try {
            String smsBody = formatSMSSoapBody();


            smsBody = smsBody.replace("#{USERNAME}", wechatProperties.getSmsUsername()).replace("#{PASSWORD}", wechatProperties.getSmsPassword())
                    .replace("#{MOBILE}", mobile).replace("#{CONTENT}", Base64.getBase64(content));
            String smsResponse = getSenderService().sendMessage(smsBody);

            // 分析返回xml对象，记录并确认该返回值是否成功，并保存该次记录到数据库中<br>
            // 短信返回格式为：<?xml version="1.0" encoding="utf-8"?><Response><Result>0</Result><Reports><Report>7802944577536071984:15801851943:15062438793027</Report></Reports></Response>
            // response format：
            log.setRequest(smsBody);
            log.setResponse(smsResponse);
            // 设置成功代码Result
            int startIndex = smsResponse.indexOf("<Result>")+"<Result>".length();
            int endIndex = smsResponse.indexOf("</Result>");
            // 当返回0时表示成功，否则失败
            if (startIndex>0&&endIndex>startIndex&&"0".equals(smsResponse.substring(startIndex,endIndex))) {
                log.setResponseCode("1");
                isSuccess = true;
            }else{
                log.setResponseCode("0");
            }
        } catch (Exception e) {
            logger.error("Error to send sms to mobile:"+mobile+", message="+e.getMessage(), e);
            log.setResponseCode("0");
            log.setErrorMessage(e.getMessage());
        } finally{
            systemLogService.saveSystemLog(log);
        }

        return isSuccess;
    }
    private String formatSMSSoapBody(){
        StringBuilder str = new StringBuilder();
        str.append("<?xml version='1.0' encoding='UTF-8'?>");
        str.append("<request>");
        str.append("<username>").append("#{USERNAME}").append("</username>");
        str.append("<password>").append("#{PASSWORD}").append("</password>");
        str.append("<Datas>");
        str.append("<data>");
        str.append("<userNumbers>");
        str.append("<mobile>").append("#{MOBILE}").append("</mobile>");
        str.append("</userNumbers>");
        str.append("<content>").append("#{CONTENT}").append("</content>");
        str.append("</data>");
        str.append("</Datas>");
        str.append("</request>");
        return str.toString();
    }

    /**
     * 发送短信<BR>
     * 1 调用daphne短信接口发送短信<BR>
     * 2 将调用结果保存入systemLog表中
     *
     * @param mobile       手机号
     * @param validateCode 验证码
     * @return
     */
    public boolean sendValidationSMS(String mobile, String validateCode) {
        String content = "您的验证码是："+validateCode+"，请尽快使用，验证码将在"+wechatProperties.getSmsInvalidTime()+"分钟后失效，失效请重新获取。回复TD退订";

        return sendSMS(mobile, content);
    }

    public SenderSoap getSenderService(){
        if (this.senderService==null) {
            synchronized (this) {
                if (this.senderService==null) {
                    try {
                        this.senderService = new Sender(new URL(wechatProperties.getSmsAddress())).getSenderSoap();

                    } catch (Exception e) {
                        throw new IllegalArgumentException("Invalid SMS address: "+wechatProperties.getSmsAddress());
                    }
                }
            }
        }
        return this.senderService;
    }
}
