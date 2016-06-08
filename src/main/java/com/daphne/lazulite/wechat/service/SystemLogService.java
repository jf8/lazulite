/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

import com.alibaba.fastjson.JSON;
import com.daphne.lazulite.wechat.entity.WeSystemLog;
import com.daphne.lazulite.wechat.repository.WeSystemLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by junfu on 2016/6/3.
 */
@Service
public class SystemLogService {

    private  Logger logger = LoggerFactory.getLogger(this.getClass());
    public final static String TYPE_SMS = "SMS";
    public final static String TYPE_FTP_IMPORT_ONLINE="FTP_IMPORT_ONLINE";
    public final static String TYPE_FTP_IMPORT_OFFLINE="FTP_IMPORT_FFLINE";

    public final static String TYPE_DAPHNE_CRM_WECHAT_REGISTER="CRM_WECHAT_REGISTER";
    public final static String TYPE_DAPHNE_CRM_VERIFY_MOBILE="CRM_VERIFY_MOBILE";
    public final static String TYPE_DAPHNE_CRM_QUERY_MEMBER="CRM_QUERY_MEMBER";
    public final static String TYPE_DAPHNE_CRM_UPDATE_MEMBER="CRM_UPDATE_MEMBER";
    public final static String TYPE_DAPHNE_CRM_QUERY_INTEGRAL="CRM_QUERY_INTEGRAL";
    public final static String TYPE_DAPHNE_CRM_QUERY_COUPON="CRM_SHOP_COUPON";

    @Autowired
    private WeSystemLogRepository weSystemLogRepository;

    /**
     * Save system log object.
     *
     * @param log
     */
    void saveSystemLog(WeSystemLog log) {
        weSystemLogRepository.save(log);
    }

    /**
     * Save interface log for call Daphne crm webservice.
     *
     * @param functionType
     * @param request
     * @param response
     * @param success
     * @param errorMessage
     */
    void saveLog(String functionType, Object request, Object response, boolean success, String errorMessage) {
        WeSystemLog log = new WeSystemLog();
        log.setCreateTime(new Date());
        log.setFunctionType(functionType);
        log.setRequest(request==null?null: JSON.toJSONString(request));
        log.setResponse(response==null?null:JSON.toJSONString(response));
        log.setResponseCode(success?"1":"0");
        log.setErrorMessage(errorMessage);
        saveSystemLog(log);
    }

    void saveLogForCallCRMWechatRegister(Object request, Object response, boolean success, String errorMessage) {
        saveLog(TYPE_DAPHNE_CRM_WECHAT_REGISTER, request, response, success, errorMessage);
    }

    void saveLogForCallCRMVerifyMobile(Object request, Object response, boolean success, String errorMessage) {
        saveLog(TYPE_DAPHNE_CRM_VERIFY_MOBILE, request, response, success, errorMessage);
    }

    void saveLogForCallCRMQueryMember(Object request, Object response, boolean success, String errorMessage) {
        saveLog(TYPE_DAPHNE_CRM_QUERY_MEMBER, request, response, success, errorMessage);
    }

    void saveLogForCallCrmUpdateMember(Object request, Object response, boolean success, String errorMessage) {
        saveLog(TYPE_DAPHNE_CRM_UPDATE_MEMBER, request, response, success, errorMessage);
    }

    void saveLogForCallCRMQueryIntergal(Object request, Object response, boolean success, String errorMessage) {
        saveLog(TYPE_DAPHNE_CRM_QUERY_INTEGRAL, request, response, success, errorMessage);
    }


    void saveLogForCallCRMQueryCoupon(Object request, Object response, boolean success, String errorMessage) {
        saveLog(TYPE_DAPHNE_CRM_QUERY_COUPON, request, response, success, errorMessage);
    }
}
