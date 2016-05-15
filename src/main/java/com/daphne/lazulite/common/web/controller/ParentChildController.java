/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.common.web.controller;

import com.daphne.lazulite.common.Constants;
import com.daphne.lazulite.common.entity.AbstractEntity;
import com.daphne.lazulite.common.service.BaseService;
import com.daphne.lazulite.common.web.bind.annotation.PageableDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract class ParentChildController<P extends AbstractEntity, C extends AbstractEntity, PID extends Serializable, CID extends Serializable>
		extends BaseCRUDController<P, PID> {

	abstract public void setParentInChild(P p, C c);

	abstract public List<C> getChildInParent(P p);
	@Autowired
	private BaseService<C, PID> childService;

	protected ParentChildController() {
		setListAlsoSetCommonData(true);
		setResourceIdentity("showcase:parentchild");
	}



	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(Model model, @Valid @ModelAttribute("m") P parent, BindingResult result,
			 RedirectAttributes redirectAttributes) {

		if (hasError(parent, result)) {
			return showCreateForm(model);
		}
		if (getChildInParent(parent) != null) {
			Iterator<C> it = getChildInParent(parent).iterator();
			while (it.hasNext()) {
				C child = it.next();
				if (child == null) {
					it.remove();
					continue;
				}
				setParentInChild(parent, child);

			}
		}
		baseService.save(parent);
		redirectAttributes.addFlashAttribute(Constants.MESSAGE, "创建成功");
		return redirectToUrl(null);
	}

	@Override
	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") P parent, Model model) {
		model.addAttribute("childList", getChildInParent(parent));
		return super.showUpdateForm(parent, model);
	}

	@Override
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable("id") P m) {
		model.addAttribute("childList", getChildInParent(m));
		return super.view(model, m);
	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.POST)
	public String update(Model model, @Valid @ModelAttribute("m") P parent, BindingResult result,
			@RequestParam(value = "BackURL", required = false) String backURL, RedirectAttributes redirectAttributes) {

		if (hasError(parent, result)) {
			return showUpdateForm(parent, model);
		}
		if (getChildInParent(parent) != null) {
			Iterator<C> it = getChildInParent(parent).iterator();
			while (it.hasNext()) {
				C child = it.next();
				if (child == null) {
					it.remove();
					continue;
				}
				setParentInChild(parent, child);

			}
		}
		baseService.update(parent);
		redirectAttributes.addFlashAttribute(Constants.MESSAGE, "修改成功");
		return redirectToUrl(backURL);
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	@Override
	public String showDeleteForm(@PathVariable("id") P parent, Model model) {
		model.addAttribute("childList", getChildInParent(parent));
		return super.showDeleteForm(parent, model);
	}

	/**
	 * 验证失败返回true
	 *
	 * @param parent
	 * @param result
	 * @return
	 */
	protected boolean hasError(P parent, BindingResult result) {
		Assert.notNull(parent);
		return result.hasErrors();
	}

	////////////////////////////////// child////////////////////////////////////

	@RequestMapping(value = "{parent}/child", method = RequestMethod.GET)
	@PageableDefaults(value = Integer.MAX_VALUE, sort = "id=desc")
	public String listChild(Model model, @PathVariable("parent") P p, Pageable pageable) {

		this.permissionList.assertHasViewPermission();
		model.addAttribute("children", getChildInParent(p));
		return viewName("child/list");
	}

	@RequestMapping(value = "child/create", method = RequestMethod.GET)
	public String showChildCreateForm(Model model, C c) {

		this.permissionList.assertHasEditPermission();
		setCommonData(model);
		model.addAttribute(Constants.OP_NAME, "新增");
		if (!model.containsAttribute("child")) {
			model.addAttribute("child", c);
		}
		return viewName("child/editForm");
	}

	@RequestMapping(value = "child/{id}/update", method = RequestMethod.GET)
	public String showChildUpdateForm(Model model, @PathVariable("id") C child,
			@RequestParam(value = "copy", defaultValue = "false") boolean isCopy,C c) {

		this.permissionList.assertHasEditPermission();

		setCommonData(model);
		model.addAttribute(Constants.OP_NAME, isCopy ? "复制" : "修改");
		if (!model.containsAttribute("child")) {
			if(child==null){
				child=c;
			}
			if (isCopy) {
				child.setId(null);
			}
			model.addAttribute("child", child);
		}
		return viewName("child/editForm");
	}

	@RequestMapping(value = "child/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public C deleteChild(@PathVariable("id") C child) {

		this.permissionList.assertHasEditPermission();

		childService.delete(child);
		return child;
	}

	@RequestMapping(value = "child/batch/delete")
	@ResponseBody
	public Object deleteChildInBatch(@RequestParam(value = "ids", required = false) PID[] ids) {

		this.permissionList.assertHasEditPermission();

		childService.delete(ids);
		return ids;
	}

}
