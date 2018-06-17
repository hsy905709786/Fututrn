/**
 * 
 */
package com.pengji.linker.dubbox.services.modules.corpbusinessmanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pengji.linker.common.config.Global;
import com.pengji.linker.baseentity.Page;
import com.pengji.linker.common.web.BaseController;
import com.pengji.linker.common.utils.StringUtils;
import com.pengji.linker.dubbox.services.modules.corpbusinessmanager.entity.AppFunSeeRole;
import com.pengji.linker.dubbox.services.modules.corpbusinessmanager.service.AppFunSeeRoleService;

/**
 * 用户角色查看权限业务Controller
 * @author 谢佯均
 * @version 2018-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/corpbusinessmanager/appFunSeeRole")
public class AppFunSeeRoleController extends BaseController {

	@Autowired
	private AppFunSeeRoleService appFunSeeRoleService;
	
	@ModelAttribute
	public AppFunSeeRole get(@RequestParam(required=false) String id) {
		AppFunSeeRole entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = appFunSeeRoleService.get(id);
		}
		if (entity == null){
			entity = new AppFunSeeRole();
		}
		return entity;
	}
	
	@RequiresPermissions("corpbusinessmanager:appFunSeeRole:view")
	@RequestMapping(value = {"list", ""})
	public String list(AppFunSeeRole appFunSeeRole, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AppFunSeeRole> page = appFunSeeRoleService.findPage(new Page<AppFunSeeRole>(request, response), appFunSeeRole); 
		model.addAttribute("page", page);
		return "modules/corpbusinessmanager/appFunSeeRoleList";
	}

	@RequiresPermissions("corpbusinessmanager:appFunSeeRole:view")
	@RequestMapping(value = "form")
	public String form(AppFunSeeRole appFunSeeRole, Model model) {
		model.addAttribute("appFunSeeRole", appFunSeeRole);
		return "modules/corpbusinessmanager/appFunSeeRoleForm";
	}

	@RequiresPermissions("corpbusinessmanager:appFunSeeRole:edit")
	@RequestMapping(value = "save")
	public String save(AppFunSeeRole appFunSeeRole, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, appFunSeeRole)){
			return form(appFunSeeRole, model);
		}
		appFunSeeRoleService.save(appFunSeeRole);
		addMessage(redirectAttributes, "保存用户角色查看权限业务成功");
		return "redirect:"+Global.getAdminPath()+"/corpbusinessmanager/appFunSeeRole/?repage";
	}
	
	@RequiresPermissions("corpbusinessmanager:appFunSeeRole:edit")
	@RequestMapping(value = "delete")
	public String delete(AppFunSeeRole appFunSeeRole, RedirectAttributes redirectAttributes) {
		appFunSeeRoleService.delete(appFunSeeRole);
		addMessage(redirectAttributes, "删除用户角色查看权限业务成功");
		return "redirect:"+Global.getAdminPath()+"/corpbusinessmanager/appFunSeeRole/?repage";
	}

}