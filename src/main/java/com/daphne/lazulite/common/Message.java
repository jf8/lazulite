/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.common;

/**
 *
 * Message delivery class.
 *
 * @author Rugal Berntein
 */
public class Message
{

    public static Message failMessage(String message)
    {
        return new Message(FAIL, message);
    }

    public static Message successMessage(String message, Object data)
    {
        return new Message(SUCCESS, message, data);
    }

    public static final String SUCCESS = "SUCCESS";

    public static final String FAIL = "FAILURE";

    private String status = FAIL;

    private String message = null;

    private Object data = null;

    private Message()
    {
    }

    private Message(String status, String message, Object data)
    {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private Message(String status, String message)
    {
        this(status, message, null);
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

}
