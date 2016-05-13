/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.sys.resource.service;

import com.daphne.lazulite.sys.resource.entity.Resource;
import com.daphne.lazulite.sys.resource.repository.ResourceRepository;
import com.daphne.lazulite.sys.role.entity.Role;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by junfu on 2016/5/12.
 */
@Service
public class ResourceService implements FilterInvocationSecurityMetadataSource {

    public static final  Logger logger= LoggerFactory.getLogger(ResourceService.class);

    private static Map<String,Collection<ConfigAttribute>> resourceMap=null;

    @Autowired
    private ResourceRepository resourceRepository;

    @PostConstruct
    public void init() throws Exception{
        resourceMap= Maps.newHashMap();
        for (Resource item:resourceRepository.findAll()
             ) {
            resourceMap.put(item.getUrl(),listToCollection(item.getRoles()));
        }
    }

    public Collection<ConfigAttribute> listToCollection(List<Role> roles){
        List<ConfigAttribute> list= Lists.newArrayList();
        for (Role role :
                roles) {
            list.add(new SecurityConfig(role.getName()));
        }
        return list;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String url=((FilterInvocation)object).getRequestUrl();
        logger.debug("为{url}获取属性",url);
        Iterator<String> it= resourceMap.keySet().iterator();
        AntPathMatcher urlMatcher=new AntPathMatcher();
        while(it.hasNext()){
            String resURL=it.next();
            if(urlMatcher.match(resURL,url)){
                Collection<ConfigAttribute> returnCollection=resourceMap.get(resURL);
                return returnCollection;
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes= Sets.newHashSet();
        for (Map.Entry<String,Collection<ConfigAttribute>> entry:
              resourceMap.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }
        return allAttributes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
