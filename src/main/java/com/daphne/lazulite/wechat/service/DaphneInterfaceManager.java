/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

import com.daphne.crm.ws.client.entity.*;
import com.daphne.lazulite.wechat.WechatProperties;
import com.daphne.lazulite.wechat.service.util.ShopCouponEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by junfu on 2016/6/2.
 */
@Service
public class DaphneInterfaceManager {
    protected  Logger logger = LoggerFactory.getLogger(this.getClass());
    private static DaphneCRMInterface service = null;
    @Autowired
    private SystemLogService systemLogService;

    @Autowired
    private WechatProperties wechatProperties;

    /**
     * 初始化接口实例
     */
    private void init(){
        if (service==null) {
            synchronized (DaphneInterfaceManager.class) {
                if (service==null) {
                    service = new DaphneCRMInterface(wechatProperties.getDaphneCrmAddress());
                }
            }
        }
    }
    /**
     * Query shop coupon data from daphne CRM system.
     *
     * @param entity
     * @return
     */
    public  QueryCouponResponse queryShopCouponListThroughDaphne(ShopCouponEntity entity) {
        init();
        QueryCouponResponse response = null;
        QueryCouponRequest request = null;
        try {
            request = new QueryCouponRequest();
            request.setMemberID(entity.getMemberID());
           // request.setActivityID(entity.getCrmActivityID());
            //调用接口
            response = service.queryCoupon(request);
        } catch (Exception e) {
            response = new QueryCouponResponse();
            response.setErrorMessage(e.getMessage());
            logger.error("Error to query shop coupon for: "+entity+", message="+e.getMessage(),e);
        } finally{
            // 任何情况下，需要插入到message中
            systemLogService.saveLogForCallCRMQueryCoupon(request, response, response.isSuccess(), response.getErrorMessage());
        }
        return response;
    }

    /**
     * Register by wechat into daphne CRM system
     *
     * @param wechatID
     * @return
     */
    public RegisterResponse wechatRegisterThroughDaphne(String wechatID, String code, String codeName, Date addDate) {
        init();
        RegisterRequest request = null;
        RegisterResponse response = null;
        try {
            request = new RegisterRequest();
            request.setWechatID(wechatID);
            request.setCode(code);
            request.setCodeName(codeName);
            addDate = (addDate==null?new Date():addDate);
            request.setAddDate(new SimpleDateFormat("yyyyMMddHHmmss").format(addDate));
            //调用接口
            response = service.wechatRegister(request);

        } catch (Exception e) {
            response = new RegisterResponse();
            response.setErrorMessage(e.getMessage());
            logger.error("Error to execute wechat register for: "+request+", message="+e.getMessage(),e);
        } finally{
            // 任何情况下，需要插入到message中
            systemLogService.saveLogForCallCRMWechatRegister(request, response, response.isSuccess(), response.getErrorMessage());
        }
        return response;
    }

    /**
     * Verify if mobile already exists in daphne CRM system
     *
     * @param memberID member id in daphne
     * @param mobile
     * @return
     */
    public VerifyMobileResponse verifyMobileThroughDaphne(String memberID, String mobile) {

        init();
        VerifyMobileRequest request = null;
        VerifyMobileResponse response = null;
        try {
            request = new VerifyMobileRequest();
            request.setMobile(mobile);
            request.setMemberID(memberID);
            //调用接口
            response = service.verifyMobile(request);

        } catch (Exception e) {
            response = new VerifyMobileResponse();
            response.setErrorMessage(e.getMessage());
            logger.error("Error to execute verify mobile for: "+request+", message="+e.getMessage(),e);
        } finally{
            // 任何情况下，需要插入到message中
            systemLogService.saveLogForCallCRMVerifyMobile(request, response, response.isSuccess(), response.getErrorMessage());
        }
        return response;
    }

    /**
     * Query member information from daphne CRM system
     *
     * @param memberID
     * @return
     */
    public QueryMemberResponse queryMemberThroughDaphne(String memberID) {
        init();
        QueryMemberRequest request = null;
        QueryMemberResponse response = null;
        try {
            request = new QueryMemberRequest();
            request.setMemberID(memberID);
            //调用接口
            response = service.queryMember(request);

        } catch (Exception e) {
            response = new QueryMemberResponse();
            response.setErrorMessage(e.getMessage());
            logger.error("Error to execute query member for: "+request+", message="+e.getMessage(),e);
        } finally{
            // 任何情况下，需要插入到message中
            systemLogService.saveLogForCallCRMQueryMember(request, response, response.isSuccess(), response.getErrorMessage());
        }
        return response;
    }

    /**
     * update member infos into daphne CRM system
     *
     * @param memberID primary key
     * @param name
     * @param sex
     * @param birthday
     * @return
     */
    public UpdateMemberResponse updateMemberThroughDaphne(String memberID, String name, String sex, String birthday) {
        init();
        UpdateMemberRequest request = null;
        UpdateMemberResponse response = null;
        try {
            request = new UpdateMemberRequest();
            request.setMemberID(memberID);
            request.setBirthday(birthday);
            request.setName(name);
            request.setSex(sex);
            //调用接口
            response = service.updateMember(request);

        } catch (Exception e) {
            response = new UpdateMemberResponse();
            response.setErrorMessage(e.getMessage());
            logger.error("Error to execute update member for: "+request+", message="+e.getMessage(),e);
        } finally{
            // 任何情况下，需要插入到message中
            systemLogService.saveLogForCallCrmUpdateMember(request, response, response.isSuccess(), response.getErrorMessage());
        }
        return response;
    }

    /**
     * Query target user's integral through daphne CRM system
     *
     * @param memberID
     * @return
     */
    public QueryIntegralResponse queryIntegralThroughDaphne(String memberID) {
        init();
        QueryIntegralRequest request = null;
        QueryIntegralResponse response = null;
        try {
            request = new QueryIntegralRequest();
            request.setMemberID(memberID);
            //调用接口
            response = service.queryIntegral(request);
        } catch (Exception e) {
            response = new QueryIntegralResponse();
            response.setErrorMessage(e.getMessage());
            logger.error("Error to execute integral for: "+request+", message="+e.getMessage(),e);
        } finally{
            // 任何情况下，需要插入到message中
            systemLogService.saveLogForCallCRMQueryIntergal(request, response, response.isSuccess(), response.getErrorMessage());
        }
        return response;
    }
}
