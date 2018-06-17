/**
 * 
 */
package com.yk.shop.modules.商品评论.controller;

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
import com.yk.shop.modules.商品评论.entity.GoodsComments;
import com.yk.shop.modules.商品评论.service.GoodsCommentsService;

/**
 * 商品点赞Controller
 * @author huangshouyong
 * @version 2018-05-08
 */
@Controller
@RequestMapping(value = "${adminPath}/商品评论/goodsComments")
public class GoodsCommentsController extends BaseController {

	@Autowired
	private GoodsCommentsService goodsCommentsService;
	
	@ModelAttribute
	public GoodsComments get(@RequestParam(required=false) String id) {
		GoodsComments entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = goodsCommentsService.get(id);
		}
		if (entity == null){
			entity = new GoodsComments();
		}
		return entity;
	}
	
	@RequiresPermissions("商品评论:goodsComments:view")
	@RequestMapping(value = {"list", ""})
	public String list(GoodsComments goodsComments, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GoodsComments> page = goodsCommentsService.findPage(new Page<GoodsComments>(request, response), goodsComments); 
		model.addAttribute("page", page);
		return "modules/商品评论/goodsCommentsList";
	}

	@RequiresPermissions("商品评论:goodsComments:view")
	@RequestMapping(value = "form")
	public String form(GoodsComments goodsComments, Model model) {
		model.addAttribute("goodsComments", goodsComments);
		return "modules/商品评论/goodsCommentsForm";
	}

	@RequiresPermissions("商品评论:goodsComments:edit")
	@RequestMapping(value = "save")
	public String save(GoodsComments goodsComments, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, goodsComments)){
			return form(goodsComments, model);
		}
		goodsCommentsService.save(goodsComments);
		addMessage(redirectAttributes, "保存记录点赞次数成功");
		return "redirect:"+Global.getAdminPath()+"/商品评论/goodsComments/?repage";
	}
	
	@RequiresPermissions("商品评论:goodsComments:edit")
	@RequestMapping(value = "delete")
	public String delete(GoodsComments goodsComments, RedirectAttributes redirectAttributes) {
		goodsCommentsService.delete(goodsComments);
		addMessage(redirectAttributes, "删除记录点赞次数成功");
		return "redirect:"+Global.getAdminPath()+"/商品评论/goodsComments/?repage";
	}

}