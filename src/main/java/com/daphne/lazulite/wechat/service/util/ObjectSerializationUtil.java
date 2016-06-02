/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service.util;

import java.io.*;

/**
 * 对象序列化工具类，用于将对象序列化成byte数组，并将byte数组转换成对象内，需转化的对象必须实现java Serializable接口 
 * @ClassName: ObjectSerializationUtil 
 * @author Walter.xu
 * @date 2015年6月26日 下午2:00:48
 */
public class ObjectSerializationUtil {
	/**
	 * 将对象序列化成bytes数组
	 * @param object
	 * @return
	 */
	public static byte[] object2Bytes(Object object){
		if (!(object instanceof Serializable)) {
			throw new IllegalArgumentException("Invalid object, must be an instance of 'Serializable'");
		}
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(object);
			return bos.toByteArray();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		} finally{
			if (oos!=null) {
				try{oos.close();}catch(Exception e){}
			}
			if (bos!=null) {
				try{bos.close();}catch(Exception e){}
			}
		}
	}
	
	/**
	 * 将bytes数组序列化成对象
	 * @param bytes
	 * @return
	 */
	public static Object bytes2Object(byte[] bytes){
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bis);
			return ois.readObject();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		} finally{
			if (ois!=null) {
				try{ois.close();}catch(Exception e){}
			}
			if (bis!=null) {
				try{bis.close();}catch(Exception e){}
			}
		}
	}
}
