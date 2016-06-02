/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.dto;

/**
 * 响应对象（给孙宇航他们的）
 * @author TangMj
 *
 */
public class ResponseDto {

	private ResponseHeaderDto responseHeaderDto;
	
	private Object results;

	public ResponseHeaderDto getResponseHeaderDto() {
		return responseHeaderDto;
	}

	public void setResponseHeaderDto(ResponseHeaderDto responseHeaderDto) {
		this.responseHeaderDto = responseHeaderDto;
	}

	public Object getResults() {
		return results;
	}

	public void setResults(Object results) {
		this.results = results;
	}
}
