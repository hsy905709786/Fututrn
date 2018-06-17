/**
 * 
 */
package com.yk.shop.modules.品牌模块.controller;

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
import com.yk.shop.modules.品牌模块.entity.Brand;
import com.yk.shop.modules.品牌模块.service.BrandService;

/**
 * 品牌模块Controller
 * @author 黄寿勇
 * @version 2018-05-11
 */
@Controller
@RequestMapping(value = "${adminPath}/品牌模块/brand")
public class BrandController extends BaseController {

	@Autowired
	private BrandService brandService;
	
	@ModelAttribute
	public Brand get(@RequestParam(required=false) String id) {
		Brand entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = brandService.get(id);
		}
		if (entity == null){
			entity = new Brand();
		}
		return entity;
	}
	
	@RequiresPermissions("品牌模块:brand:view")
	@RequestMapping(value = {"list", ""})
	public String list(Brand brand, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Brand> page = brandService.findPage(new Page<Brand>(request, response), brand); 
		model.addAttribute("page", page);
		return "modules/品牌模块/brandList";
	}

	@RequiresPermissions("品牌模块:brand:view")
	@RequestMapping(value = "form")
	public String form(Brand brand, Model model) {
		model.addAttribute("brand", brand);
		return "modules/品牌模块/brandForm";
	}

	@RequiresPermissions("品牌模块:brand:edit")
	@RequestMapping(value = "save")
	public String save(Brand brand, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, brand)){
			return form(brand, model);
		}
		brandService.save(brand);
		addMessage(redirectAttributes, "保存品牌模块成功");
		return "redirect:"+Global.getAdminPath()+"/品牌模块/brand/?repage";
	}
	
	@RequiresPermissions("品牌模块:brand:edit")
	@RequestMapping(value = "delete")
	public String delete(Brand brand, RedirectAttributes redirectAttributes) {
		brandService.delete(brand);
		addMessage(redirectAttributes, "删除品牌模块成功");
		return "redirect:"+Global.getAdminPath()+"/品牌模块/brand/?repage";
	}

}