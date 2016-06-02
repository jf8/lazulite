/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.utils;

import java.io.*;
import java.util.Properties;

/**
 * 对属性文件的读写操作类
 * @author Madhouse
 *
 */
public class PropertiesUtils {
	/**
	 * 指定属性文件名，得到相应的key对应的值(属性文件的位置默认放在resources/properties下面)
	 * @param fileName  文件名
	 * @param key
	 * @return
	 */
	public static String getPropertiesByKey(String fileName,String key){
		try {
			Properties properties = loadProperties(fileName);
			return properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	/**
	 * 指定属性文件名，修改相应的值
	 * @param fileName 文件名
	 * @param key
	 * @param value
	 */
	public static void modifyProperties(String fileName,String key,String value){
		try {
			Properties properties = loadProperties(fileName);
			properties.setProperty(key, value);
			String path = PropertiesUtils.class.getResource("/properties/"+fileName).getPath();
			OutputStream out = new BufferedOutputStream(new FileOutputStream(path));
			properties.store(out, "modify");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 按文件名加载属性文件  属性文件放在  resources/properties/下
	 * @param fileName
	 * @return
	 */
	private static Properties loadProperties(String fileName){
		Properties properties = new Properties();
		try {
			String path = PropertiesUtils.class.getResource("/properties/"+fileName).getPath();
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			properties.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	/*public static void main(String[] args) {
		String value1 = getPropertiesByKey("url.properties", "baidu");
		System.out.println(value1);
		modifyProperties("url.properties", "baidu","http://www.baidu.com");
		String value2 = getPropertiesByKey("url.properties", "baidu");
		System.out.println(value2);
	}*/
}
