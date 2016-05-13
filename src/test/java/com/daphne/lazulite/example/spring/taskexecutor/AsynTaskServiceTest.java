/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.example.spring.taskexecutor;

import com.daphne.lazulite.LazuliteApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Created by junfu on 2016/5/7.
 */
public class AsynTaskServiceTest extends LazuliteApplicationTests {

    @Autowired
    private AsynTaskService asynTaskService;

    @Test
    public void testExecuteAsyncTask() throws Exception {
        int threadCount=8;
        CountDownLatch count = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            asynTaskService.executeAsyncTask(i,count);
        }
        count.await();
    }

    @Test
    public void testExecuteAsyncTaskPlus() throws Exception {

    }
}