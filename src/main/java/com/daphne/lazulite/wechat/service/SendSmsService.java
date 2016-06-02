/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

/**
 * Created by junfu on 2016/6/2.
 */
public class SendSmsService {
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
        return false;
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
        return false;
    }
}
