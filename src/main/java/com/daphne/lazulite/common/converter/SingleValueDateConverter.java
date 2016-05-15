/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.common.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class SingleValueDateConverter implements Converter {
	
	public static String pattern="yyyy-MM-dd HH:mm:ss";
	
    public void marshal(Object source, HierarchicalStreamWriter writer,
            MarshallingContext context) {
    	Date date = (Date) source;
        writer.setValue(DateFormatUtils.format(date, pattern));
    }
    
    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) {
    	Date date = null;
		try {
			date = DateUtils.parseDate(reader.getValue(), pattern);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return date;
    }

    public boolean canConvert(Class type) {
        return type.equals(Date.class);
    }
}