/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

/**
 * Created by junfu on 2016/6/2.
 */
@Configurable
public class ActivemqQueueConfig {
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

    @Bean
    public Queue channelCoupon() {
        return new ActiveMQQueue(QUEUE_CHANNEL_COUPON);
    }

    @Bean
    public Queue channelCommon() {
        return new ActiveMQQueue(QUEUE_CHANNEL_COMMON);
    }
    @Bean
    public Queue channelMassMessage() {
        return new ActiveMQQueue(QUEUE_MASS_MESSAGE);
    }


    @Bean
    public Queue channelCustomMessage() {
        return new ActiveMQQueue(QUEUE_CUSTOM_MESSAGE);
    }
    @Bean
    public Queue channelTemlateMessage() {
        return new ActiveMQQueue(QUEUE_TEMPLATE_MESSAGE);
    }
    @Bean
    public Queue channelCallCrmApi() {
        return new ActiveMQQueue(QUEUE_CALL_CRM_API);
    }

    @Bean
    public Queue channelWechatMessageRequest() {
        return new ActiveMQQueue(QUEUE_WECHAT_MESSAGE_REQUEST);
    }

}
