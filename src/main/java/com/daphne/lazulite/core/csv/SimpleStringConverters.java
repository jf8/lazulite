/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.core.csv;

/**
 * Created by junfu on 2016/5/6.
 */
abstract class SimpleStringConverters {
    SimpleStringConverters() {
    }

    static String toString(String valueAsString) {
        return valueAsString;
    }

    static Integer toInteger(String valueAsString) {
        valueAsString = valueAsString.trim();
        return valueAsString.isEmpty()?null:Integer.valueOf(Integer.parseInt(valueAsString));
    }

    static Integer toInt(String valueAsString) {
        Integer result = toInteger(valueAsString);
        if(result == null) {
            throw new RuntimeException(new RuntimeException("String value for type \'int\' cannot be empty."));
        } else {
            return result;
        }
    }

    static Boolean toBoolean(String valueAsString) {
        valueAsString = valueAsString.trim();
        if(valueAsString.isEmpty()) {
            return null;
        } else if(!valueAsString.equalsIgnoreCase("true") && !valueAsString.equalsIgnoreCase("false")) {
            throw new RuntimeException("Cannot parse boolean from string: " + valueAsString);
        } else {
            return Boolean.valueOf(valueAsString);
        }
    }

    static Boolean toBool(String valueAsString) {
        Boolean result = toBoolean(valueAsString);
        if(result == null) {
            throw new RuntimeException(new RuntimeException("String value for type \'boolean\' cannot be empty."));
        } else {
            return result;
        }
    }
}
