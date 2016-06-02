/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

import com.daphne.lazulite.wechat.entity.Member;
import com.daphne.lazulite.wechat.entity.Message;

/**
 * Created by junfu on 2016/6/2.
 */
public class MessageService {
    public static final String TYPE_MESSAGE_RESPONSE = "MESSAGE_RESPONSE";
    public static final String TYPE_FILM_TKT_CLAIM_MESSAGE = "MESSAGE_FILM_TKT_CLAIM";
    public static final String TYPE_FILM_TKT_ACTIVITY_MESSAGE = "MESSAGE_FILM_TKT_ACTIVITY";

    public static final String TYPE_COUPON_CLAIM_MESSAGE="MESSAGE_COUPON_CLAIM";
    public static final String TYPE_COUPON_CHECKING_MESSAGE="MESSAGE_COUPON_CHECKING";
    public static final String TYPE_COUPON_DISABLE_MESSAGE="MESSAGE_COUPON_DISABLE";

    public static final String TYPE_USER_INFO_CHECKING_MESSAGE="MESSAGE_USER_INFO_CHECKING";

    /**
     * 验证对应用户对应活动的对应消息类型是否已经发送过了，如果发送过了返回TRUE,否则false<BR>
     * 1 用户ID<BR>
     * 2 活动ID<BR>
     * 3 消息类型<BR>
     *
     * @param weMemberID
     * @param activityID
     * @param messageType
     * @return
     */
    boolean isMessageExist(Integer weMemberID, Integer activityID, String messageType) {
        return false;
    }

    /**
     * 【被动消息】保存响应给用户的消息，该消息为被动消息
     *
     * @param member           用户信息
     * @param activityID       活动ID
     * @param messageProcessID
     * @param message          消息内容
     * @return
     */
    Message saveResponseMessage(Member member, Integer activityID, Integer messageProcessID, String message) {
        return null;
    }

    /**
     * 【被动消息】保存消息，
     *
     * @param member
     * @param activityID
     * @param messageProcessID
     * @return
     */
    Message saveResponseMessageCompleteUserInfo(Member member, Integer activityID, Integer messageProcessID) {
        return null;
    }

    /**
     * @param member
     * @param activityID
     * @param messageProcessID
     * @return
     */
    Message saveResponseMessageClaimCoupons(Member member, Integer activityID, Integer messageProcessID) {
        return null;
    }

    Message saveResponseMessageClaimCouponsAlready(Member member, Integer activityID, Integer messageProcessID) {
        return null;
    }

    Message saveResponseCouponCompleteUserInfoMessage(Member member, Integer activityID, Integer messageProcessID) {
        return null;
    }

    /**
     * 保存并发送领取电影票的消息，将消息发送到redis缓存中<BR>
     * 当该用户在当前活动已经发送过电影票时，不再发送
     *
     * @param member
     * @param referenceID
     * @param ticketNumber
     * @return
     */
    boolean saveAndSendFilmTktClaimMessage(Member member, Integer activityID, Integer referenceID, Integer ticketNumber) {
        return false;
    }

    Message saveAndSendCouponMessage(Member member, Integer activityID, Integer messageProcessID) {
        return null;
    }

    /**
     * 保存并发送电影票活动消息，将消息发送到redis缓存中<BR>
     * 当该用户在当前活动已经发送过该消息时，不再发送
     *
     * @param member
     * @param messageProcessID
     * @return
     */
    boolean saveAndSendFilmTktActivityMessage(Member member, Integer activityID, Integer messageProcessID) {
        return false;
    }
    /**
     * 保存优惠券获取消息
     * @param member
     * @param messageProcessID
     * @return
     */
//	boolean saveAndSendCouponViewMessage(Member member, Integer activityID, Integer messageProcessID);
    /**
     * 保存优惠券用户信息校验信息，用于校验
     * @param member
     * @param messageProcessID
     * @return
     */
//	boolean saveAndSendCouponCompleteUserInfoMessage(Member member, Integer activityID, Integer messageProcessID);

    /**
     * 保存用户优惠券销毁消息
     *
     * @param member
     * @return
     */
    boolean saveAndSendCouponDisableMessage(Member member, String couponCode) {
        return false;
    }

    /**
     * 更新消息状态
     *
     * @param id
     * @param status
     */
    void updateStatus(int id, int status) {

    }

    /**
     * 更新消息状态为已经发送
     *
     * @param id
     */
    void updateStatusAsSent(int id) {

    }

    /**
     * 查询消息
     *
     * @param id
     * @return
     */
    Message findByID(int id) {
        return null;
    }

    /**
     * 判断消息是否存在
     *
     * @param memberID
     * @return
     */
    boolean isExist(String memberID) {
        return false;
    }

    /**
     * 将当前消息发送失败次数加1，最多三次，超过三次后不在发送
     *
     * @param id
     */
    boolean addFailedCountsByID(int id) {
        return false;
    }
}
