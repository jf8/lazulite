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
package com.daphne.lazulite.sys.group.web.controller;

import com.daphne.lazulite.common.Constants;
import com.daphne.lazulite.common.entity.enums.BooleanEnum;
import com.daphne.lazulite.common.web.bind.annotation.PageableDefaults;
import com.daphne.lazulite.common.web.controller.BaseCRUDController;
import com.daphne.lazulite.common.web.controller.permission.PermissionList;
import com.daphne.lazulite.sys.group.entity.Group;
import com.daphne.lazulite.sys.group.entity.GroupType;
import com.daphne.lazulite.sys.group.service.GroupRelationService;
import com.daphne.lazulite.sys.group.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

/**
 * <p>User: 
 * <p>Date: 13-1-28 下午4:29
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "/admin/sys/group")
public class GroupController extends BaseCRUDController<Group, Long> {

    @Autowired
    private GroupRelationService groupRelationService;


    public GroupController() {
        setListAlsoSetCommonData(true);
        setResourceIdentity("sys:group");
    }

    private GroupService getGroupService() {
        return (GroupService) baseService;
    }

    @Override
    protected void setCommonData(Model model) {
        super.setCommonData(model);
        model.addAttribute("types", GroupType.values());
        model.addAttribute("booleanList", BooleanEnum.values());
    }


    @RequestMapping(value = "{type}/list", method = RequestMethod.GET)
    @PageableDefaults(sort = "id=desc")
    public String list(@PathVariable("type") GroupType type, Pageable pageable, Model model) {

    //    pageable.addSearchParam("type_eq", type);

        return list(pageable, model);
    }

    @RequestMapping(value = "create/discard", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        throw new RuntimeException("discarded method");
    }


    @RequestMapping(value = "{type}/create", method = RequestMethod.GET)
    public String showCreateFormWithType(@PathVariable("type") GroupType type, Model model) {
        if (!model.containsAttribute("m")) {
            Group group = new Group();
            group.setType(type);
            model.addAttribute("m", group);
        }
        return super.showCreateForm(model);
    }

    @RequestMapping(value = "{type}/create", method = RequestMethod.POST)
    public String create(
            Model model, @Valid @ModelAttribute("m") Group m, BindingResult result,
            RedirectAttributes redirectAttributes) {

        return super.create(model, m, result, redirectAttributes);
    }


    @RequestMapping(value = "/changeStatus/{newStatus}")
    public String changeShowStatus(
            HttpServletRequest request,
            @PathVariable("newStatus") Boolean newStatus,
            @RequestParam("ids") Long[] ids
    ) {

        this.permissionList.assertHasUpdatePermission();

        for (Long id : ids) {
            Group group = getGroupService().findOne(id);
            group.setShow(newStatus);
            getGroupService().update(group);
        }
        return "redirect:" + request.getAttribute(Constants.BACK_URL);
    }


    @RequestMapping(value = "/changeDefaultGroup/{newStatus}")
    public String changeDefaultGroup(
            HttpServletRequest request,
            @PathVariable("newStatus") Boolean newStatus,
            @RequestParam("ids") Long[] ids
    ) {

        this.permissionList.assertHasUpdatePermission();

        for (Long id : ids) {
            Group group = getGroupService().findOne(id);
            if (group.getType() != GroupType.user) {//只有用户组 可设置为默认 其他无效
                continue;
            }
            group.setDefaultGroup(newStatus);
            getGroupService().update(group);
        }
        return "redirect:" + request.getAttribute(Constants.BACK_URL);
    }


    @RequestMapping("ajax/autocomplete")
    @PageableDefaults(value = 30)
    @ResponseBody
    public Set<Map<String, Object>> autocomplete(
            Pageable pageable,
            @RequestParam("term") String term) {

        return getGroupService().findIdAndNames(pageable, term);
    }


    ///////////////////////////////分组 内//////////////////////////////////////
    @RequestMapping(value = "/{group}/listRelation", method = RequestMethod.GET)
    @PageableDefaults(sort = "id=desc")
    public String listGroupRelation(@PathVariable("group") Group group, Pageable pageable, Model model) {

        this.permissionList.assertHasViewPermission();


        Page page = null;
        if (group.getType() == GroupType.user) {
            page = groupRelationService.findAll(pageable);
        }

        if (group.getType() == GroupType.organization) {
            page = groupRelationService.findAll(pageable);
        }

        model.addAttribute("page", page);

        return viewName("relation/relationList");
    }


    @RequestMapping(value = "/{group}/listRelation", headers = "table=true", method = RequestMethod.GET)
    @PageableDefaults(sort = "id=desc")
    public String listGroupRelationTable(@PathVariable("group") Group group, Pageable pageable, Model model) {

        this.permissionList.assertHasViewPermission();

        this.listGroupRelation(group, pageable, model);
        return viewName("relation/relationListTable");

    }

    @RequestMapping(value = "{group}/batch/delete", method = RequestMethod.GET)
    public String batchDeleteGroupRelation(
            @PathVariable("group") Group group,
            @RequestParam("ids") Long[] ids,
            @RequestParam(value = Constants.BACK_URL, required = false) String backURL,
            RedirectAttributes redirectAttributes) {

        this.permissionList.assertHasDeletePermission();

        if (group.getType() == GroupType.user) {
            groupRelationService.delete(ids);
        }

        if (group.getType() == GroupType.organization) {
            groupRelationService.delete(ids);
        }

        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "删除成功");
        return redirectToUrl(backURL);

    }

    @RequestMapping(value = "{group}/batch/append", method = RequestMethod.GET)
    public String showBatchAppendGroupRelationForm(@PathVariable("group") Group group) {

        this.permissionList.assertHasAnyPermission(
                new String[]{PermissionList.CREATE_PERMISSION, PermissionList.UPDATE_PERMISSION});

        if (group.getType() == GroupType.user) {
            return viewName("relation/appendUserGroupRelation");
        }

        if (group.getType() == GroupType.organization) {
            return viewName("relation/appendOrganizationGroupRelation");
        }

        throw new RuntimeException("group type error");
    }

    @RequestMapping(value = "{group}/batch/append", method = RequestMethod.POST)
    public String batchAppendGroupRelation(
            @PathVariable("group") Group group,
            @RequestParam("ids") Long[] ids,
            //只有用户组 有fromIds endIds
            @RequestParam(value = "startIds", required = false) Long[] startIds,
            @RequestParam(value = "endIds", required = false) Long[] endIds,
            @RequestParam(value = Constants.BACK_URL, required = false) String backURL,
            RedirectAttributes redirectAttributes) {

        this.permissionList.assertHasAnyPermission(
                new String[]{PermissionList.CREATE_PERMISSION, PermissionList.UPDATE_PERMISSION});

        if (group.getType() == GroupType.organization) {
            groupRelationService.appendRelation(group.getId(), ids);
        }

        if (group.getType() == GroupType.user) {
            groupRelationService.appendRelation(group.getId(), ids, startIds, endIds);
        }


        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "批量添加成功");

        return redirectToUrl(backURL);
    }


}
