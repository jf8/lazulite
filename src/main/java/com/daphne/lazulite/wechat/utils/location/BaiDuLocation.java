/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.utils.location;
/**
 * 百度API参数对象
 * @author TangMj
 *
 */
public class BaiDuLocation {
	/** 地址**/
	private String location;
	/** 输出格式 （json/xml  默认json）**/
	private String output;
	/** 回调函数名**/
	private String callback;
	
	private int pois;
	/**
	 * 地址和ak值必须有
	 * @param ak
	 * @param address
	 */
	public BaiDuLocation(String location){
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOutput() {
		if(output==null||output.equals("")){
			output = "json";
		}
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	public int getPois() {
		return pois;
	}
	public void setPois(int pois) {
		this.pois = pois;
	}
	
}
