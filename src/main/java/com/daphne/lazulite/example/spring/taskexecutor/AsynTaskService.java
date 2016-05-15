/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.example.spring.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * Created by junfu on 2016/5/7.
 */
@Service
public class AsynTaskService {
    @Async
    public void executeAsyncTask(Integer i, CountDownLatch countDownLatch) throws InterruptedException {
        System.out.println("执行异步任务："+i);System.out.println(Thread.currentThread().getName());
        countDownLatch.countDown();
    }
    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务："+(i+1));
    }
}
