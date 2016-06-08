/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.entity;



import com.daphne.lazulite.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by junfu on 2016/6/7.
 */
@Entity
@Table(name = "we_channel_qrcode")
public class WeChannelQrcode extends BaseEntity<Integer> {

    private String channelId;
    private String channelName;
    private byte[] qrcodeImg;
    private Byte delFlag;
    private String imgUrl;

    @Basic
    @Column(name = "channel_id")
    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Basic
    @Column(name = "channel_name")
    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @Basic
    @Column(name = "qrcode_img")
    public byte[] getQrcodeImg() {
        return qrcodeImg;
    }

    public void setQrcodeImg(byte[] qrcodeImg) {
        this.qrcodeImg = qrcodeImg;
    }


    @Basic
    @Column(name = "del_flag")
    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    @Basic
    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


}
