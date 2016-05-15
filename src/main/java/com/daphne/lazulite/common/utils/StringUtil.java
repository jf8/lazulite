package com.daphne.lazulite.common.utils;

public class StringUtil {
	public static boolean isNull(String s){
		return s==null||s.trim().length()==0;
	}
	public static String getTopTenStackTrace(Throwable t){
		StringBuilder sb=new StringBuilder();
		sb.append("Exception in thread "+Thread.currentThread().getName()+" "+t.getMessage()+"\n");
		for(int i=0;i<t.getStackTrace().length;i++){
			if(i>5){
				return sb.toString();
			}
			StackTraceElement temp=t.getStackTrace()[i];
			sb.append("at "+temp.getClassName()+"."+temp.getMethodName()+"("+temp.getFileName()+":"+temp.getLineNumber()+")\n");
			}
		return sb.toString();
	}
	public static String isNullToEmpty(String s){
		if(s==null){
			return "";
		}
		return s;
	}
}
