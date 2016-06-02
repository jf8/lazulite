/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.utils;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class JackSonMapper {
	
	public static final Logger logger = LoggerFactory.getLogger(JackSonMapper.class);
	
	public static ObjectMapper mapper = new ObjectMapper();
	
	
	public static <T> T fromJson(String jsonString,Class<T> clazz) {
		if (CommonUtils.isEmpty(jsonString))
			return null;
	
		try {
			ObjectMapper mapper = getInstance();
			return mapper.readValue(jsonString, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T fromJsonThrowEx(String jsonString,Class<T> clazz) throws JsonMappingException, IOException {
		if (CommonUtils.isEmpty(jsonString))
			return null;
	
			ObjectMapper mapper = getInstance();
			return mapper.readValue(jsonString, clazz);
	}
	
	public static <T> T fromJson(String jsonString, JavaType javaType) {
		if (CommonUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			ObjectMapper mapper = getInstance();
			return mapper.readValue(jsonString, javaType);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
			return null;
		}
	}
	
	public static String toJson(Object object) {
		ObjectMapper mapper = getInstance();
		try {
			String jsonStr =  mapper.writeValueAsString(object);
			logger.debug("result json  : " + jsonStr);
			return jsonStr;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ObjectMapper getInstance() {
		return mapper;
	}

	public static JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
		ObjectMapper mapper = getInstance();
		return mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
	}
}
