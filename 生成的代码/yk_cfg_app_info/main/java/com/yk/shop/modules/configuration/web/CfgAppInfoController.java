/**
 * 
 */
package com.yk.shop.modules.configuration.controller;

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

import com.whs.shop.common.config.Global;
import com.whs.shop.baseentity.Page;
import com.whs.shop.common.web.BaseController;
import com.whs.shop.common.utils.StringUtils;
import com.yk.shop.modules.configuration.entity.CfgAppInfo;
import com.yk.shop.modules.configuration.service.CfgAppInfoService;

/**
 * infoController
 * @author 黄寿勇
 * @version 2018-05-17
 */
@Controller
@RequestMapping(value = "${adminPath}/configuration/cfgAppInfo")
public class CfgAppInfoController extends BaseController {

	@Autowired
	private CfgAppInfoService cfgAppInfoService;
	
	@ModelAttribute
	public CfgAppInfo get(@RequestParam(required=false) String id) {
		CfgAppInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cfgAppInfoService.get(id);
		}
		if (entity == null){
			entity = new CfgAppInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("configuration:cfgAppInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(CfgAppInfo cfgAppInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CfgAppInfo> page = cfgAppInfoService.findPage(new Page<CfgAppInfo>(request, response), cfgAppInfo); 
		model.addAttribute("page", page);
		return "modules/configuration/cfgAppInfoList";
	}

	@RequiresPermissions("configuration:cfgAppInfo:view")
	@RequestMapping(value = "form")
	public String form(CfgAppInfo cfgAppInfo, Model model) {
		model.addAttribute("cfgAppInfo", cfgAppInfo);
		return "modules/configuration/cfgAppInfoForm";
	}

	@RequiresPermissions("configuration:cfgAppInfo:edit")
	@RequestMapping(value = "save")
	public String save(CfgAppInfo cfgAppInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cfgAppInfo)){
			return form(cfgAppInfo, model);
		}
		cfgAppInfoService.save(cfgAppInfo);
		addMessage(redirectAttributes, "保存info成功");
		return "redirect:"+Global.getAdminPath()+"/configuration/cfgAppInfo/?repage";
	}
	
	@RequiresPermissions("configuration:cfgAppInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(CfgAppInfo cfgAppInfo, RedirectAttributes redirectAttributes) {
		cfgAppInfoService.delete(cfgAppInfo);
		addMessage(redirectAttributes, "删除info成功");
		return "redirect:"+Global.getAdminPath()+"/configuration/cfgAppInfo/?repage";
	}

}