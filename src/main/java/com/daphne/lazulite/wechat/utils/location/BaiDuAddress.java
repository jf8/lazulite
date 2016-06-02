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
public class BaiDuAddress {
	/** 地址**/
	private String address;
	/** 输出格式 （json/xml  默认json）**/
	private String output;
	/** 回调函数名**/
	private String callback;
	/** 城市名（用于一个地址在多个城市出现时过滤）**/
	private String city;
	/**
	 * 地址和ak值必须有
	 * @param ak
	 * @param address
	 */
	public BaiDuAddress(String address){
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
