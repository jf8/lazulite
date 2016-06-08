/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.daphne.lazulite.common.entity;

import org.apache.shiro.SecurityUtils;

import javax.persistence.*;
import javax.security.auth.Subject;
import java.io.Serializable;
import java.util.Date;

/**
 * <p> 抽象实体基类，提供统一的ID，和相关的基本功能方法
 * 如果是oracle请参考{@link BaseOracleEntity}
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-12 下午4:05
 * <p>Version: 1.0
 */
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> extends AbstractEntity<ID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    //@SequenceGenerator(name="seq",sequenceName="common_seq",allocationSize=1,initialValue=5000)
    private ID id;

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id = id;
    }

    private Date createTime;

    private Date updateTime;

    private String creator;

    private String modifier;
    @Basic
    @javax.persistence.Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Basic
    @javax.persistence.Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    @Basic
    @javax.persistence.Column(name = "creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    @Basic
    @javax.persistence.Column(name = "modifier")
    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @PrePersist
    void prePersist() {
        this.createTime=new Date();
        this.updateTime=new Date();
        //creator= SecurityUtils.getSubject()!=null?SecurityUtils.getSubject().getPrincipal().toString():"";
    }

    @PreUpdate
    void preUpdate() {
        this.updateTime=new Date();
        //modifier= SecurityUtils.getSubject()!=null?SecurityUtils.getSubject().getPrincipal().toString():"";
    }

}
