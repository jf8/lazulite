/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

import com.daphne.lazulite.common.service.BaseService;
import com.daphne.lazulite.wechat.entity.WeMember;
import com.daphne.lazulite.wechat.repository.WeMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 * Created by junfu on 2016/6/2.
 */
@Service
@CacheConfig(cacheNames = {"memberCache"})
public class WeMemberService extends BaseService<WeMember,Integer>{

    @Autowired
    private WeMemberRepository weMemberRepository;

    /**
     * 新增会员
     *
     * @param member
     */
//    @Cacheable(key = "T(com.daphne.lazulite.wechat.WechatRedisManager).CACHE_SUB_KEY_USER+#member.wechatId")
//    public void addMember(WeMember member) {
//        member.setCreateTime(new Date());
//        weMemberRepository.save(member);
//    }

    /**
     * 修改会员
     */
//    @CachePut(key = "T(com.daphne.lazulite.wechat.WechatRedisManager).CACHE_SUB_KEY_USER+#member.wechatId" )
//    public WeMember update(WeMember member) {
//        return weMemberRepository.save(member);
//    }

    /**
     * 查询会员
     */
    //@Cacheable(key = "T(com.daphne.lazulite.wechat.WechatRedisManager).CACHE_SUB_KEY_USER+#openId")
    public WeMember queryByOpenId(String openId) {
        return weMemberRepository.findByWechatId(openId);
    }

    public WeMember queryByMemberID(String memberID) {
        return weMemberRepository.findByWechatId(memberID);
    }

//    public WeMember queryByID(int id) {
//        return weMemberRepository.findOne(id);
//    }


    public WeMember queryByPhoneNum(String phoneNum) {
        return weMemberRepository.findByPhoneNum(phoneNum);
    }

}
