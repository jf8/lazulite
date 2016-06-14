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
import com.lazulite.spring.boot.autoconfig.shiro.RetryLimitHashedCredentialsMatcher;
import com.lazulite.spring.boot.autoconfig.shiro.ShiroProperties;
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

    @Autowired
    private PasswordService passwordService;


    @Test
    public void testFindUserByUsername(){
        Assert.assertNotNull(userService.findByUsername("admin"));
    }

    @Test
    public void testPassword(){
        System.out.println("\n password:"+passwordService.encryptPassword("admin","admin","yDd1956wn1"));
        System.out.println("\n password:"+passwordService.encryptPassword("user","user","hSSixwNQwt"));
        System.out.println("\n password:"+passwordService.encryptPassword("sys","sys","MANHOoCpnb"));
        System.out.println("\n password:"+passwordService.encryptPassword("maintain","maintain","iY71e4dtoa"));
    }
}