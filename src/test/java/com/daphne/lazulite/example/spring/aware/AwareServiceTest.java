/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.example.spring.aware;

import com.daphne.lazulite.LazuliteApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by junfu on 2016/5/7.
 */
public class AwareServiceTest extends LazuliteApplicationTests {

    @Autowired
    private AwareService awareService;

    @Test
    public void testOutputResult() throws Exception {
        awareService.outputResult();
    }
}