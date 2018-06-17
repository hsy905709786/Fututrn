package com.whs.shop.modules.goods.service.impl;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whs.shop.common.service.CrudService;
import com.whs.shop.modules.goods.dao.interf.GoodsPropertyDao;
import com.whs.shop.modules.goods.entity.GoodsProperty;
import com.whs.shop.modules.goods.service.interf.IGoodsPropertyService;

/**
 * 展示商品属性Service
 * @author 黄寿勇
 * @version 2018-05-04
 */
@Service("goodsPropertyService")
@Transactional(readOnly = true)
public class GoodsPropertyService extends CrudService<GoodsPropertyDao, GoodsProperty> implements IGoodsPropertyService{

	@Override
	public void update(GoodsProperty goodsProperty) {
		
		
	}

	/*@Override
	public Object getAttribute(GoodsProperty attribute) {
		
		return null;
	}*/
	
}