/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.dto;
/**
 * 二维码发放/领取电影票Dto
 * @author TangMj
 *
 */
public class QrCodeTicketDto {
	private int channelId;
	private String channelName;
	private int yesterdayGaveOut;
	private int totalGaveOut;
	private int yesterdayClaimed;
	private int totalClaimed;
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public int getYesterdayGaveOut() {
		return yesterdayGaveOut;
	}
	public void setYesterdayGaveOut(int yesterdayGaveOut) {
		this.yesterdayGaveOut = yesterdayGaveOut;
	}
	public int getTotalGaveOut() {
		return totalGaveOut;
	}
	public void setTotalGaveOut(int totalGaveOut) {
		this.totalGaveOut = totalGaveOut;
	}
	public int getYesterdayClaimed() {
		return yesterdayClaimed;
	}
	public void setYesterdayClaimed(int yesterdayClaimed) {
		this.yesterdayClaimed = yesterdayClaimed;
	}
	public int getTotalClaimed() {
		return totalClaimed;
	}
	public void setTotalClaimed(int totalClaimed) {
		this.totalClaimed = totalClaimed;
	}
	
}
