/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.jms;

import com.daphne.lazulite.wechat.ActivemqQueueConfig;
import com.daphne.lazulite.wechat.jms.util.CallCrmAPIThread;
import com.daphne.lazulite.wechat.service.util.CRMRequestEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by junfu on 2016/6/7.
 */
@Component
public class CallCrmAPIListener {
    @JmsListener(destination = ActivemqQueueConfig.QUEUE_CALL_CRM_API)
    public void receiveQueue(CRMRequestEntity entity) {
        new CallCrmAPIThread(entity).start();
    }
}
