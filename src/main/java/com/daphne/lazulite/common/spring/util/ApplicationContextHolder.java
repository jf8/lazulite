/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.common.spring.util;

import com.google.common.collect.Maps;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by junfu on 2016/5/6.
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    private static final Log LOGGER = LogFactory.getLog(ApplicationContextHolder.class);
    private static ApplicationContext s_appContext;
    private static Map<Class<?>, Object> s_beans = Maps.newHashMap();

    public ApplicationContextHolder() {
    }

    public static <T> T getBean(Class<T> beanType) {
        if(s_beans.containsKey(beanType)) {
            return (T) s_beans.get(beanType);
        } else {
            Map var1 = s_beans;
            synchronized(s_beans) {
                Object var10000;
                try {
                    Object bean = s_appContext.getBean(beanType);
                    if(LOGGER.isDebugEnabled()) {
                        LOGGER.debug(String.format("Retrieving bean %s for bean type %s", new Object[]{bean.getClass(), beanType}));
                    }

                    s_beans.put(beanType, bean);
                    var10000 = bean;
                } catch (NoSuchBeanDefinitionException var3) {
                    return null;
                }

                return (T) var10000;
            }
        }
    }

    public static boolean containsBean(String name) {
        return s_appContext.containsBean(name);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        s_appContext = applicationContext;
    }
}