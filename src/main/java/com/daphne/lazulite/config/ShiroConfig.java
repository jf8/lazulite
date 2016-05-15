/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.spring.SpringCacheManagerWrapper;
import org.apache.shiro.session.mgt.OnlineSessionFactory;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.OnlineSessionDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by junfu on 2016/5/13.
 */
@Configuration
public class ShiroConfig {
    @Bean
    public CacheManager shiroCacheManager(org.springframework.cache.CacheManager cacheManager){
        SpringCacheManagerWrapper springCacheManagerWrapper=new SpringCacheManagerWrapper();
        springCacheManagerWrapper.setCacheManager(cacheManager);
        return springCacheManagerWrapper;
    }

    @Bean
    public OnlineSessionFactory onlineSessionFactory(){
        OnlineSessionFactory onlineSessionFactory=new OnlineSessionFactory();
        return onlineSessionFactory;
    }

    @Bean
    public OnlineSessionDAO onlineSessionDAO(){
        JavaUuidSessionIdGenerator javaUuidSessionIdGenerator=new JavaUuidSessionIdGenerator();

        OnlineSessionDAO onlineSessionDAO=new OnlineSessionDAO();
        onlineSessionDAO.setSessionIdGenerator(javaUuidSessionIdGenerator);
        onlineSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        return onlineSessionDAO;
    }

}
