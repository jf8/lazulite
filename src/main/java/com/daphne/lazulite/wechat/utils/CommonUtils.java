/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.utils;

import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CommonUtils {
	/**
	 * 判断给定的字符串是否为空（""、 "  "、null返回false）
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str)||"".equals(str.trim())){
			return true;
		}
		return false;
	}
	/**
	 * 判断集合是否为空(coll==null, coll.size==0)
	 * @param coll
	 * @return 
	 */
	public static boolean isEmpty(Collection<?> coll){
		if (coll==null||coll.size()==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 将时间按照给定的格式进行格式化
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateFormat(Date date,String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	/**
	 * 将字符串按照指定格式解析成时间
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String date,String format) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(date);
	}
	
	public static Date parseDate(String date, String format, Date defaultValue){
		try {
			return parseDate(date, format);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * 将javaBean 装成map
	 * @param bean
	 * @throws IntrospectionException 
	 */
	public static Map<String, Object> bean2Map(Object bean){
		Map<String, Object> map = new HashMap<String, Object>();
		if(bean==null){
			return map;
		}
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				String pdName = pd.getName();
				if(!"class".equals(pdName)){
					Method getter = pd.getReadMethod();
					getter.setAccessible(true);
					Object value = getter.invoke(bean, new Object[0]);
					if(value!=null){
						map.put(pdName, value);
					}else{
						map.put(pdName,null);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 将map转成javaBean
	 * @param map
	 * @return
	 */
	public static <T> T map2Bean(Map<String, Object> map,Class<T> clazz){
		T bean = null;
		try {
			bean = clazz.newInstance();
			BeanInfo beanIfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] pds = beanIfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				String pdName = pd.getName();
				if(!"class".equals(pdName)&&map.containsKey(pdName)){
					Method setter = pd.getWriteMethod();
					if(setter!=null){
						setter.setAccessible(true);
						/*Object value = map.get(pdName);
						Object[] args = new Object[1];
			            args[0] = value;*/
						setter.invoke(bean,map.get(pdName) );
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	/**
	 * 两个对象之间值传递
	 * @param source
	 * @param target
	 */
	public static void copyProperties(Object source,Object target){
		BeanUtils.copyProperties(source, target);
	}
	/**
	 * string -- int转换，非法则返回空
	 * @param arg0
	 * @return
	 */
	public static Integer parseInt(String arg0){
		return parseInt(arg0, null);
	}
	/**
	 * string -- int转换，非法则返回defaultValue
	 * @param arg0
	 * @param defaultValue
	 * @return
	 */
	public static Integer parseInt(String arg0, Integer defaultValue){
		if (isEmpty(arg0)) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(arg0);
		} catch (Exception e) {
		}
		return defaultValue;
	}
	/**
	 * string -- double转换，非法则返回空
	 * @param arg0
	 * @return
	 */
	public static Double parseDouble(String arg0){
		return praseDouble(arg0, null);
	}
	/**
	 * string -- double转换，非法则返回空
	 * @param arg0
	 * @param defaultValue
	 * @return
	 */
	public static Double praseDouble(String arg0, Double defaultValue){
		if (isEmpty(arg0)) {
			return defaultValue;
		}
		try {
			return Double.valueOf(arg0);
		} catch (Exception e) {
		}
		return defaultValue;
	}
	/**
	 * string -- int转换，非法则返回空
	 * @param arg0
	 * @return
	 */
	public static Long parseLong(String arg0){
		return parseLong(arg0, null);
	}
	/**
	 * string -- int转换，非法则返回defaultValue
	 * @param arg0
	 * @param defaultValue
	 * @return
	 */
	public static Long parseLong(String arg0, Long defaultValue){
		if (isEmpty(arg0)) {
			return defaultValue;
		}
		try {
			return Long.parseLong(arg0);
		} catch (Exception e) {
		}
		return defaultValue;
	}
	/**
	 * 移除UTF-8编码字符串开头的的BOM无用字符
	 * @param utf8Str
	 * @return
	 */
	public static String removeBOMOfUTF8(String utf8Str){
		if (!isEmpty(utf8Str)) {
			try {
				byte[] bytes = utf8Str.getBytes("utf-8");
				if (bytes[0]==-17&&bytes[1]==-69&&bytes[2]==-65) {
					utf8Str = utf8Str.substring(1);
				}
			} catch (Exception e) {
			}
		}
		return utf8Str;
	}
}
