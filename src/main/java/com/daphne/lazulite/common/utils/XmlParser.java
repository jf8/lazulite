package com.daphne.lazulite.common.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.xml.XppDomDriver;

public class XmlParser {

	private static XStream xstreamDom = null;
	static {
		initXstream();
	}

	private XmlParser() {
		// TODO Auto-generated constructor stub
		throw new UnsupportedOperationException();
	}

	public static String toXml(Object o) {
		xstreamDom.processAnnotations(o.getClass());
		return xstreamDom.toXML(o);
	}

	public static <T> T toObject(String xml, Class<T> clazz) {
		xstreamDom.processAnnotations(clazz);
		try {
			return (T) xstreamDom.fromXML(xml, clazz.newInstance());
		} catch (InstantiationException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) xstreamDom.fromXML(xml);

	}

	/**
	 * 此方法描述的是： 初始化 XStream对象. 是否需要cdata支持.
	 * 
	 * @author: junfu.chen@mail.daphne.com.cn
	 * @version: 2014年12月23日 下午2:31:42
	 */

	public static void initXstream() {
		xstreamDom = new XStream(new XppDomDriver(new NameCoder() {
			@Override
			public String encodeNode(String name) {
				// TODO Auto-generated method stub
				return name;
			}

			@Override
			public String encodeAttribute(String name) {
				// TODO Auto-generated method stub
				return name;
			}

			@Override
			public String decodeNode(String nodeName) {
				// TODO Auto-generated method stub
				return nodeName;
			}

			@Override
			public String decodeAttribute(String attributeName) {
				// TODO Auto-generated method stub
				return attributeName;
			}
		}));
		xstreamDom.setMode(XStream.NO_REFERENCES);
	}

	

}
