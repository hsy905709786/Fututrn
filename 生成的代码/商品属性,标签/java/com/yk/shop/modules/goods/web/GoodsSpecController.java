/**
 * 
 */
package com.yk.shop.modules.goods.controller;

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
import com.yk.shop.modules.goods.entity.GoodsSpec;
import com.yk.shop.modules.goods.service.GoodsSpecService;

/**
 * 商品规格Controller
 * @author huang
 * @version 2018-05-05
 */
@Controller
@RequestMapping(value = "${adminPath}/goods/goodsSpec")
public class GoodsSpecController extends BaseController {

	@Autowired
	private GoodsSpecService goodsSpecService;
	
	@ModelAttribute
	public GoodsSpec get(@RequestParam(required=false) String id) {
		GoodsSpec entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = goodsSpecService.get(id);
		}
		if (entity == null){
			entity = new GoodsSpec();
		}
		return entity;
	}
	
	@RequiresPermissions("goods:goodsSpec:view")
	@RequestMapping(value = {"list", ""})
	public String list(GoodsSpec goodsSpec, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GoodsSpec> page = goodsSpecService.findPage(new Page<GoodsSpec>(request, response), goodsSpec); 
		model.addAttribute("page", page);
		return "modules/goods/goodsSpecList";
	}

	@RequiresPermissions("goods:goodsSpec:view")
	@RequestMapping(value = "form")
	public String form(GoodsSpec goodsSpec, Model model) {
		model.addAttribute("goodsSpec", goodsSpec);
		return "modules/goods/goodsSpecForm";
	}

	@RequiresPermissions("goods:goodsSpec:edit")
	@RequestMapping(value = "save")
	public String save(GoodsSpec goodsSpec, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, goodsSpec)){
			return form(goodsSpec, model);
		}
		goodsSpecService.save(goodsSpec);
		addMessage(redirectAttributes, "保存商品规格成功");
		return "redirect:"+Global.getAdminPath()+"/goods/goodsSpec/?repage";
	}
	
	@RequiresPermissions("goods:goodsSpec:edit")
	@RequestMapping(value = "delete")
	public String delete(GoodsSpec goodsSpec, RedirectAttributes redirectAttributes) {
		goodsSpecService.delete(goodsSpec);
		addMessage(redirectAttributes, "删除商品规格成功");
		return "redirect:"+Global.getAdminPath()+"/goods/goodsSpec/?repage";
	}

}