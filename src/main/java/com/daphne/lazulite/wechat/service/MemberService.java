/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

import com.daphne.lazulite.wechat.entity.Member;

import java.util.List;

/**
 *
 * Created by junfu on 2016/6/2.
 */
public class MemberService {
    /**
     * 新增会员
     *
     * @param member
     */
    public void addMember(Member member) {

    }

    /**
     * 修改会员
     */
    public void update(Member member) {

    }

    /**
     * 查询会员
     */
    public Member queryByOpenId(String openId) {
        return null;
    }

    public Member queryByMemberID(String memberID) {
        return null;
    }

    public Member queryByID(int id) {
        return null;
    }


    public Member queryByPhoneNum(String phoneNum) {
        return null;
    }

    /**
     * Query members by condition.
     *
     * @param openID       wechat id, primary key
     * @param memberID     member id, as unique in Daphne,
     * @param memberNumber member number, should be unique, metched with memberID.
     * @return
     */
    List<Member> queryMembers(String openID, String memberID, String memberNumber) {
        return null;
    }

    /**
     * Validate if current user exists.
     *
     * @param openID
     * @param memberID
     * @param memberNumber
     * @return Only return true if user exist and status is valid.
     */
    boolean isMemberExist(String openID, String memberID, String memberNumber) {
        return false;
    }

}
