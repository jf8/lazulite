/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.lazulite.sys.auth.service;

import com.daphne.lazulite.sys.group.service.GroupService;
import com.daphne.lazulite.sys.organization.service.JobService;
import com.daphne.lazulite.sys.organization.service.OrganizationService;
import com.daphne.lazulite.sys.permission.entity.Permission;
import com.daphne.lazulite.sys.permission.entity.Role;
import com.daphne.lazulite.sys.permission.entity.RoleResourcePermission;
import com.daphne.lazulite.sys.permission.service.PermissionService;
import com.daphne.lazulite.sys.permission.service.RoleService;
import com.daphne.lazulite.sys.resource.entity.Resource;
import com.daphne.lazulite.sys.resource.service.ResourceService;
import com.daphne.lazulite.sys.user.entity.User;
import com.daphne.lazulite.sys.user.entity.UserOrganizationJob;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * 分组、组织机构、用户、新增、修改、删除时evict缓存
 * <p/>
 * 获取用户授权的角色及组装好的权限
 * <p>User: 
 * <p>Date: 13-5-1 下午2:38
 * <p>Version: 1.0
 */
@Service
public class UserAuthService {

    @Autowired
    private GroupService groupService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private JobService jobService;

    @Autowired
    private AuthService authService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private PermissionService permissionService;


    public Set<Role> findRoles(User user) {

        if (user == null) {
            return Sets.newHashSet();
        }

        Long userId = user.getId();

        Set<Long[]> organizationJobIds = Sets.newHashSet();
        Set<Long> organizationIds = Sets.newHashSet();
        Set<Long> jobIds = Sets.newHashSet();

        for (UserOrganizationJob o : user.getOrganizationJobs()) {
            Long organizationId = o.getOrganizationId();
            Long jobId = o.getJobId();

            if (organizationId != null && jobId != null && organizationId != 0L && jobId != 0L) {
                organizationJobIds.add(new Long[]{organizationId, jobId});
            }
            organizationIds.add(organizationId);
            jobIds.add(jobId);
        }

        //TODO 目前默认子会继承父 后续实现添加flag控制是否继承

        //找组织机构祖先
        //organizationIds.addAll(organizationService.findAncestorIds(organizationIds));
        //找工作职务的祖先
       // jobIds.addAll(jobService.findAncestorIds(jobIds));

        //过滤组织机构 仅获取目前可用的组织机构数据
        organizationService.filterForCanShow(organizationIds, organizationJobIds);
        jobService.filterForCanShow(jobIds, organizationJobIds);

        //过滤工作职务 仅获取目前可用的工作职务数据

        //默认分组 + 根据用户编号 和 组织编号 找 分组
        Set<Long> groupIds = groupService.findShowGroupIds(userId, organizationIds);

        //获取权限
        //1.1、获取用户角色
        //1.2、获取组织机构角色
        //1.3、获取工作职务角色
        //1.4、获取组织机构和工作职务组合的角色
        //1.5、获取组角色
        Set<Long> roleIds = authService.findRoleIds(userId, groupIds, organizationIds, jobIds, organizationJobIds);

        Set<Role> roles = roleService.findShowRoles(roleIds);

        return roles;

    }

    public Set<String> findStringRoles(User user) {
        Set<Role> roles = ((UserAuthService) AopContext.currentProxy()).findRoles(user);
        return Sets.newHashSet(Collections2.transform(roles, new Function<Role, String>() {
            @Override
            public String apply(Role input) {
                return input.getRole();
            }
        }));
    }

    /**
     * 根据角色获取 权限字符串 如sys:admin
     *
     * @param user
     * @return
     */
    public Set<String> findStringPermissions(User user) {
        Set<String> permissions = Sets.newHashSet();

        Set<Role> roles = ((UserAuthService) AopContext.currentProxy()).findRoles(user);
        for (Role role : roles) {
            for (RoleResourcePermission rrp : role.getResourcePermissions()) {
                Resource resource = resourceService.findOne(rrp.getResourceId());

                String actualResourceIdentity = resourceService.findActualResourceIdentity(resource);

                //不可用 即没查到 或者标识字符串不存在
                if (resource == null || StringUtils.isEmpty(actualResourceIdentity)) {
                    continue;
                }

                for (Long permissionId : rrp.getPermissionIds()) {
                    Permission permission = permissionService.findOne(permissionId);

                    //不可用
                    if (permission == null || Boolean.FALSE.equals(permission.getShow())) {
                        continue;
                    }
                    permissions.add(actualResourceIdentity + ":" + permission.getPermission());

                }
            }

        }

        return permissions;
    }

}