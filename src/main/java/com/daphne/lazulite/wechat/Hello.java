/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sword.wechat4j.message.CustomerMsg;
import org.sword.wechat4j.user.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by junfu on 2016/5/24.
 */
@Controller
public class Hello {
    private Logger logger = LoggerFactory.getLogger(Hello.class);
    @RequestMapping("/wechat/sendMsg")
    public void sendMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = "你好，wechat4j";
        String op = request.getParameter("op");
        if(StringUtils.isNotBlank(op)){
            //主动发送客服消息
            if(op.equals("1")){
                sendMsg();
                result = "已发送";
            }
        }
        response.setCharacterEncoding("UTF-8");//服务器编码
        response.setHeader("content-type", "text/html;charset=UTF-8");//浏览器编码
        PrintWriter out = response.getWriter();
        out.println(result);
    }
    private void sendMsg(){
        logger.info("主动发送消息demo");
        //获得关注者列表，发送给第一个人消息
        UserManager userManager = new UserManager();
        List<String> userList = userManager.allSubscriber();
        if(userList.size() > 0){
            String toUserOpenId = userList.get(0);
            String content = "主动发送";
            CustomerMsg customerMsg = new CustomerMsg(toUserOpenId);
            customerMsg.sendText(content);
        }
    }
}
