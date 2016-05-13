/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.core.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by junfu on 2016/5/6.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    protected Date m_createdAt;
    protected Date m_updatedAt;

    public BaseEntity() {
    }

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        this.m_createdAt = now;
        this.m_updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.m_updatedAt = new Date();
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "created_at"
    )
    public Date getCreatedAt() {
        return this.m_createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.m_createdAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "updated_at"
    )
    public Date getUpdatedAt() {
        return this.m_updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.m_updatedAt = updatedAt;
    }
}
