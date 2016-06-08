/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service.util;


import com.daphne.lazulite.wechat.entity.WeMember;
import org.apache.commons.lang3.StringUtils;

/**
 * WeMember service tools class,
 * @ClassName: MemberServiceUtil 
 * @author Walter.xu
 * @date 2015年7月25日 上午10:38:19
 */
public class MemberServiceUtil {
	/**
	 * Validate if user has complete the self-information, including phone, name, sex and birthday.
	 * @param member
	 * @return
	 */
	public static boolean isUserInfCompleted(WeMember member){
		if (member!=null&&!StringUtils.isEmpty(member.getName())&&
				!StringUtils.isEmpty(member.getPhoneNum())&&member.getBirthday()!=null&&
				!StringUtils.isEmpty(member.getSex())) {
			return true;
		}
		return false;
	}
}
