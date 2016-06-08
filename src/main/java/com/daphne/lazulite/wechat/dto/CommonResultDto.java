/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.dto;


public class CommonResultDto {
	/**
	 * 操作是否成功  0：否  1：是
	 */
	private Integer result = 1;
	/**
	 * 错误信息  默认“ok”
	 */
	private String errorMsg = "ok";
	/**
	 * 返回的结果数据
	 */
	private Object data;
	
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
//	public static void main(String[] args) {
//		CommonResultDto obj = new CommonResultDto();
//		System.out.println(obj.getResult());
//	}
}
