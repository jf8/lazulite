package com.daphne.lazulite.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static String DEFALUT_FORMAT="yyyy-MM-dd hh:mm:ss";
	private static String SIMPLE_FORMAT="yyyyMMdd";
	public static String DateToString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(DEFALUT_FORMAT);
		return df.format(date);
	}
	/***
	 *  e.q 20150713
	 * @param date
	 * @return
	 */
	public static String DateToOnlyDateString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(SIMPLE_FORMAT);
		return df.format(date);
	}
	public static String DateToString(Date date,String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
	public static Date StringToDate(String date,String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//	public static void main(String[] args) {
//		System.out.println(DateToOnlyDateString(new Date()));
//	}
}
