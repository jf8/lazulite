/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.sys.role.entity;


import com.daphne.lazulite.sys.resource.entity.Resource;

import javax.persistence.*;

/**
 * Created by junfu on 2016/5/12.
 */
@Entity
@Table(name="sys_role_resource")
public class RoleResource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @OneToOne
    private Role role;

    @OneToOne
    private Resource resource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
