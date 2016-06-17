/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by junfu on 2016/6/16.
 */
@ConfigurationProperties(prefix = "wechat")
public class WechatProperties {

    private String idCouponReceivedTemplate;

    private String idWpmessage;

    private String webPersonnalCenterUrl;

    private String smsAddress;

    private String webMyFavorableUrl;

    private String webNearShopUrl;

    private String tokenAddress;

    private String userInfoUrl;

    private String daphneCrmAddress;

    private String authUrl;

    private String smsPassword;

    private String idCouponUsedTemplate;

    private String customerRecordInterval;

    private String smsInvalidTime;

    private String smsUsername;

    private String webToTheMallUrl;

    private String webPointsExchangeUrl;

    public String getIdCouponReceivedTemplate() {
        return idCouponReceivedTemplate;
    }

    public void setIdCouponReceivedTemplate(String idCouponReceivedTemplate) {
        this.idCouponReceivedTemplate = idCouponReceivedTemplate;
    }

    public String getIdWpmessage() {
        return idWpmessage;
    }

    public void setIdWpmessage(String idWpmessage) {
        this.idWpmessage = idWpmessage;
    }

    public String getWebPersonnalCenterUrl() {
        return webPersonnalCenterUrl;
    }

    public void setWebPersonnalCenterUrl(String webPersonnalCenterUrl) {
        this.webPersonnalCenterUrl = webPersonnalCenterUrl;
    }

    public String getSmsAddress() {
        return smsAddress;
    }

    public void setSmsAddress(String smsAddress) {
        this.smsAddress = smsAddress;
    }

    public String getWebMyFavorableUrl() {
        return webMyFavorableUrl;
    }

    public void setWebMyFavorableUrl(String webMyFavorableUrl) {
        this.webMyFavorableUrl = webMyFavorableUrl;
    }

    public String getWebNearShopUrl() {
        return webNearShopUrl;
    }

    public void setWebNearShopUrl(String webNearShopUrl) {
        this.webNearShopUrl = webNearShopUrl;
    }

    public String getTokenAddress() {
        return tokenAddress;
    }

    public void setTokenAddress(String tokenAddress) {
        this.tokenAddress = tokenAddress;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    public String getDaphneCrmAddress() {
        return daphneCrmAddress;
    }

    public void setDaphneCrmAddress(String daphneCrmAddress) {
        this.daphneCrmAddress = daphneCrmAddress;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getSmsPassword() {
        return smsPassword;
    }

    public void setSmsPassword(String smsPassword) {
        this.smsPassword = smsPassword;
    }

    public String getIdCouponUsedTemplate() {
        return idCouponUsedTemplate;
    }

    public void setIdCouponUsedTemplate(String idCouponUsedTemplate) {
        this.idCouponUsedTemplate = idCouponUsedTemplate;
    }

    public String getCustomerRecordInterval() {
        return customerRecordInterval;
    }

    public void setCustomerRecordInterval(String customerRecordInterval) {
        this.customerRecordInterval = customerRecordInterval;
    }

    public String getSmsInvalidTime() {
        return smsInvalidTime;
    }

    public void setSmsInvalidTime(String smsInvalidTime) {
        this.smsInvalidTime = smsInvalidTime;
    }

    public String getSmsUsername() {
        return smsUsername;
    }

    public void setSmsUsername(String smsUsername) {
        this.smsUsername = smsUsername;
    }

    public String getWebToTheMallUrl() {
        return webToTheMallUrl;
    }

    public void setWebToTheMallUrl(String webToTheMallUrl) {
        this.webToTheMallUrl = webToTheMallUrl;
    }

    public String getWebPointsExchangeUrl() {
        return webPointsExchangeUrl;
    }

    public void setWebPointsExchangeUrl(String webPointsExchangeUrl) {
        this.webPointsExchangeUrl = webPointsExchangeUrl;
    }
}
