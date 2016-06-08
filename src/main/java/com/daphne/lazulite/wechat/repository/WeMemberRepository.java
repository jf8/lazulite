/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.repository;

import com.daphne.lazulite.common.repository.BaseRepository;
import com.daphne.lazulite.wechat.entity.WeActivity;
import com.daphne.lazulite.wechat.entity.WeMember;

/**
 * Created by junfu on 2016/6/3.
 */
public interface WeMemberRepository  extends BaseRepository<WeMember,Integer> {
    public WeMember findByWechatId(String wechatid);
    public WeMember findByMemberId(String memberid);
    public WeMember findByPhoneNum(String phoneNum);
}
