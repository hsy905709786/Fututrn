package com.whs.shop.bgrestful.goods.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whs.shop.baseentity.baseentity.rest.Response;
import com.whs.shop.common.web.BaseController;
import com.whs.shop.common.utils.ObjectUtils;
import com.whs.shop.modules.goods.entity.GoodsSpec;
import com.whs.shop.modules.goods.service.interf.IGoodsSpecService;

/**
 * 商品规格Controller
 * @author huang
 * @version 2018-05-05
 */
@RestController
@RequestMapping(value = "${adminPath}/rest/goods/goodsSpec")
public class GoodsSpecController extends BaseController {

	@Autowired
	private IGoodsSpecService goodsSpecService;
	
	/**
	 * 添加商品标签
	 */
	@RequestMapping("/add")
	public Response addgoodsSpec(HttpServletRequest request,Model model, RedirectAttributes redirectAttributes) throws Exception {
		GoodsSpec goodsSpec = ObjectUtils.fromJson(GoodsSpec.class, request);
		
			goodsSpecService.insert(goodsSpec);
	
		return new Response().success();
		
	}
	/**
	 * 删除商品标签
	 */
	@RequestMapping("/delete")
	public Response deletegoodsSpec(HttpServletRequest request) throws Exception {
		GoodsSpec goodsSpec = ObjectUtils.fromJson(GoodsSpec.class, request);
		int status = 0;
		try{
			goodsSpecService.delete(goodsSpec);
			status =200;
		}catch(Exception e){
			status =201;
			
		}
		return new Response().success(status);
	}
	/**
	 *修改商品标签
	 */
	@RequestMapping("/update")
	public Response updategoodsSpec(HttpServletRequest request) throws Exception {
		GoodsSpec goodsSpec = ObjectUtils.fromJson(GoodsSpec.class, request);
		int status = 0;
		try{
			goodsSpecService.update(goodsSpec);
			status =200;
		}catch(Exception e){
			status =201;
			
		}
		return new Response().success(status);
		
	}
	/**
	 * 查询商品标签
	 */
	@RequestMapping("/get")
	public Response getgoodsSpec(HttpServletRequest request) throws Exception {
		GoodsSpec goodsSpec = ObjectUtils.fromJson(GoodsSpec.class, request);
		
		return new Response().success(goodsSpecService.get(goodsSpec));
	}
	
	
	/*@RequestMapping("/list")
	public Response list(HttpServletRequest request) throws Exception {
		GoodsSpec goodsSpec = ObjectUtils.fromJson(GoodsSpec.class, request);
		return null;
		
	}*/
}