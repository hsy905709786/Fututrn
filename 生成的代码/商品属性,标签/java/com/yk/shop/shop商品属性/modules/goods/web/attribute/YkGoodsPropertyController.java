/**
 * 
 */
package com.whs.shop.modules.goods.controller.attribute;

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
import com.whs.shop.modules.goods.entity.attribute.YkGoodsProperty;
import com.whs.shop.modules.goods.service.attribute.YkGoodsPropertyService;

/**
 * 展示商品属性Controller
 * @author 黄寿勇
 * @version 2018-05-04
 */
@Controller
@RequestMapping(value = "${adminPath}/goods/attribute/ykGoodsProperty")
public class YkGoodsPropertyController extends BaseController {

	@Autowired
	private YkGoodsPropertyService ykGoodsPropertyService;
	
	@ModelAttribute
	public YkGoodsProperty get(@RequestParam(required=false) String id) {
		YkGoodsProperty entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ykGoodsPropertyService.get(id);
		}
		if (entity == null){
			entity = new YkGoodsProperty();
		}
		return entity;
	}
	
	@RequiresPermissions("goods:attribute:ykGoodsProperty:view")
	@RequestMapping(value = {"list", ""})
	public String list(YkGoodsProperty ykGoodsProperty, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<YkGoodsProperty> page = ykGoodsPropertyService.findPage(new Page<YkGoodsProperty>(request, response), ykGoodsProperty); 
		model.addAttribute("page", page);
		return "modules/goods/attribute/ykGoodsPropertyList";
	}

	@RequiresPermissions("goods:attribute:ykGoodsProperty:view")
	@RequestMapping(value = "form")
	public String form(YkGoodsProperty ykGoodsProperty, Model model) {
		model.addAttribute("ykGoodsProperty", ykGoodsProperty);
		return "modules/goods/attribute/ykGoodsPropertyForm";
	}

	@RequiresPermissions("goods:attribute:ykGoodsProperty:edit")
	@RequestMapping(value = "save")
	public String save(YkGoodsProperty ykGoodsProperty, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ykGoodsProperty)){
			return form(ykGoodsProperty, model);
		}
		ykGoodsPropertyService.save(ykGoodsProperty);
		addMessage(redirectAttributes, "保存商品属性增删改查成功");
		return "redirect:"+Global.getAdminPath()+"/goods/attribute/ykGoodsProperty/?repage";
	}
	
	@RequiresPermissions("goods:attribute:ykGoodsProperty:edit")
	@RequestMapping(value = "delete")
	public String delete(YkGoodsProperty ykGoodsProperty, RedirectAttributes redirectAttributes) {
		ykGoodsPropertyService.delete(ykGoodsProperty);
		addMessage(redirectAttributes, "删除商品属性增删改查成功");
		return "redirect:"+Global.getAdminPath()+"/goods/attribute/ykGoodsProperty/?repage";
	}

}