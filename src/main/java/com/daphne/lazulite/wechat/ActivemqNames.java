/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat;

/**
 * Created by junfu on 2016/6/2.
 */
public class ActivemqNames {
    /**
     * 门店优惠券频道
     */
    public static final String QUEUE_CHANNEL_COUPON = "CHANNEL_COUPON";
    /**
     * 公用的队列频道
     */
    public static final String QUEUE_CHANNEL_COMMON = "CHANNEL_COMMON";
    public static final String QUEUE_MASS_MESSAGE = "CHANNEL_MASS_MESSAGE";
    public static final String QUEUE_CUSTOM_MESSAGE = "CHANNEL_CUSTOM_MESSAGE";
    public static final String QUEUE_TEMPLATE_MESSAGE = "CHANNEL_TEMLATE_MESSAGE";
    public static final String QUEUE_CALL_CRM_API = "CHANNEL_CALL_CRM_API";
    public static final String QUEUE_WECHAT_MESSAGE_REQUEST = "CHANNEL_WECHAT_MESSAGE_REQUEST";
}
