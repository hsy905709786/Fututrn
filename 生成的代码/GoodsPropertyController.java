package com.whs.shop.bgrestful.goods.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whs.shop.baseentity.baseentity.rest.Response;
import com.whs.shop.common.utils.ObjectUtils;
import com.whs.shop.common.web.BaseController;
import com.whs.shop.modules.goods.entity.GoodsProperty;
import com.whs.shop.modules.goods.service.interf.IGoodsPropertyService;

/**
 * 展示商品属性Controller
 * @author 黄寿勇
 * @version 2018-05-04
 */
@RestController
@RequestMapping(value = "${adminPath}/rest/goods/attribute")
public class GoodsPropertyController extends BaseController {
	

	@Autowired
	private IGoodsPropertyService goodsPropertyService;



	/**
	 * 根据属性名查找属性
	 */
	@RequestMapping("/get")
	public Response getAttribute(@RequestBody GoodsProperty goodsProperty, HttpServletRequest request) throws Exception {

//		GoodsProperty attribute = ObjectUtils.fromJson(GoodsProperty.class, request);
		
		return new Response().success(goodsPropertyService.get(goodsProperty));
	}
	
	

	/**
	 * 根据属性名删除属性
	 */
	@RequestMapping("/delete")
	public Response deleteAttribute(HttpServletRequest request) throws Exception {
		int status = 0;
		GoodsProperty attribute = ObjectUtils.fromJson(GoodsProperty.class, request);
		try{
			
			goodsPropertyService.delete(attribute);
			status =200;
		}catch(Exception e){
			status =201;
			//logger
		}
		return new Response().success(status);
	}
	
	/**
	 * 添加属性
	 */
	@RequestMapping("/save")
	public Response saveAttribute( HttpServletRequest request) throws Exception {
		int status = 0;
		GoodsProperty attribute = ObjectUtils.fromJson(GoodsProperty.class, request);
		try{
			goodsPropertyService.save(attribute);
			status =200;
		}catch(Exception e){
			status =201;
			//logger
		}
		return new Response().success(status);
	}
	
	/**
	 * 修改属性
	 */
	@RequestMapping("/update")
	public Response update(  HttpServletRequest request) throws Exception {
		int status = 0;
		GoodsProperty attribute = ObjectUtils.fromJson(GoodsProperty.class, request);
		try{
			goodsPropertyService.update(attribute);
			status =200;
		}catch(Exception e){
			status =201;
			//logger
		}
		return new Response().success(status);
	}

	
	
	
}