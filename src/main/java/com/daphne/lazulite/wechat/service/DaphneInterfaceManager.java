/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

import com.daphne.crm.ws.client.entity.*;
import com.daphne.lazulite.wechat.service.util.ShopCouponEntity;

import java.util.Date;

/**
 * Created by junfu on 2016/6/2.
 */
public class DaphneInterfaceManager {


    /**
     * Query shop coupon data from daphne CRM system.
     *
     * @param entity
     * @return
     */
    QueryCouponResponse queryShopCouponListThroughDaphne(ShopCouponEntity entity) {
        return null;
    }

    /**
     * Register by wechat into daphne CRM system
     *
     * @param wechatID
     * @return
     */
    RegisterResponse wechatRegisterThroughDaphne(String wechatID, String code, String codeName, Date addDate) {
        return null;
    }

    /**
     * Verify if mobile already exists in daphne CRM system
     *
     * @param memberID member id in daphne
     * @param mobile
     * @return
     */
    VerifyMobileResponse verifyMobileThroughDaphne(String memberID, String mobile) {
        return null;
    }

    /**
     * Query member information from daphne CRM system
     *
     * @param memberID
     * @return
     */
    QueryMemberResponse queryMemberThroughDaphne(String memberID) {
        return null;
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
    UpdateMemberResponse updateMemberThroughDaphne(String memberID, String name, String sex, String birthday) {
        return null;
    }

    /**
     * Query target user's integral through daphne CRM system
     *
     * @param memberID
     * @return
     */
    QueryIntegralResponse queryIntegralThroughDaphne(String memberID) {
        return null;
    }
}
