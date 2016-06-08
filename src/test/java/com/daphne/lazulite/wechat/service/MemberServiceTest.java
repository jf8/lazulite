/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

import com.daphne.lazulite.LazuliteApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Created by junfu on 2016/6/7.
 */
public class MemberServiceTest extends LazuliteApplicationTests {

    @Autowired
    private WeMemberService memberService;


    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testQueryByOpenId() throws Exception {
        Assert.notNull(memberService.queryByOpenId("oaB7kjuxxWPhp9xkCsTIe_B50DM4"));
    }

    @Test
    public void testQueryByMemberID() throws Exception {

    }

    @Test
    public void testQueryByID() throws Exception {

    }

    @Test
    public void testQueryByPhoneNum() throws Exception {

    }
}