/**
 * 
 */
package com.yk.shop.modules.goodstype.controller;

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
import com.yk.shop.modules.goodstype.entity.GoodsType;
import com.yk.shop.modules.goodstype.service.GoodsTypeService;

/**
 * 描述商品的分类Controller
 * @author 黄寿勇
 * @version 2018-05-05
 */
@Controller
@RequestMapping(value = "${adminPath}/goodstype/goodsType")
public class GoodsTypeController extends BaseController {

	@Autowired
	private GoodsTypeService goodsTypeService;
	
	@ModelAttribute
	public GoodsType get(@RequestParam(required=false) String id) {
		GoodsType entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = goodsTypeService.get(id);
		}
		if (entity == null){
			entity = new GoodsType();
		}
		return entity;
	}
	
	@RequiresPermissions("goodstype:goodsType:view")
	@RequestMapping(value = {"list", ""})
	public String list(GoodsType goodsType, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GoodsType> page = goodsTypeService.findPage(new Page<GoodsType>(request, response), goodsType); 
		model.addAttribute("page", page);
		return "modules/goodstype/goodsTypeList";
	}

	@RequiresPermissions("goodstype:goodsType:view")
	@RequestMapping(value = "form")
	public String form(GoodsType goodsType, Model model) {
		model.addAttribute("goodsType", goodsType);
		return "modules/goodstype/goodsTypeForm";
	}

	@RequiresPermissions("goodstype:goodsType:edit")
	@RequestMapping(value = "save")
	public String save(GoodsType goodsType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, goodsType)){
			return form(goodsType, model);
		}
		goodsTypeService.save(goodsType);
		addMessage(redirectAttributes, "保存商品模块成功");
		return "redirect:"+Global.getAdminPath()+"/goodstype/goodsType/?repage";
	}
	
	@RequiresPermissions("goodstype:goodsType:edit")
	@RequestMapping(value = "delete")
	public String delete(GoodsType goodsType, RedirectAttributes redirectAttributes) {
		goodsTypeService.delete(goodsType);
		addMessage(redirectAttributes, "删除商品模块成功");
		return "redirect:"+Global.getAdminPath()+"/goodstype/goodsType/?repage";
	}

}