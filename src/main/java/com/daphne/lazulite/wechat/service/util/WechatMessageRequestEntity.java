/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service.util;

import java.io.Serializable;


/**
 * 查询微信聊天记录请求类，
 * @ClassName: WechatMessageRequestEntity 
 * @author Walter.xu
 * @date 2015年8月27日 下午2:07:24
 */
public class WechatMessageRequestEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int dataLogID;
	private long startSecond;
	private long endSecond;
	@Override
	public String toString(){
		return "[id:"+dataLogID+",startSecond:"+startSecond+", endSecond:"+endSecond+"]";
	}
	
	public int getDataLogID() {
		return dataLogID;
	}
	public void setDataLogID(int dataLogID) {
		this.dataLogID = dataLogID;
	}
	public long getStartSecond() {
		return startSecond;
	}
	public void setStartSecond(long startSecond) {
		this.startSecond = startSecond;
	}
	public long getEndSecond() {
		return endSecond;
	}
	public void setEndSecond(long endSecond) {
		this.endSecond = endSecond;
	}
}
