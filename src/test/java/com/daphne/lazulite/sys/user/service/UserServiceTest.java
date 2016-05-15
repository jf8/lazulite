/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.sys.user.service;

import com.daphne.lazulite.LazuliteApplicationTests;
import com.daphne.lazulite.sys.user.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by junfu on 2016/5/14.
 */
public class UserServiceTest extends LazuliteApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void testFindUserByUsername(){
        Assert.assertNotNull(userService.findByUsername("admin"));
    }
}