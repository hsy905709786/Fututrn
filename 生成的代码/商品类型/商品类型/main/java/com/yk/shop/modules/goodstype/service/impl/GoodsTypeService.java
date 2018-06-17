/**
 * 
 */
package com.yk.shop.modules.goodstype.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.shop.baseentity.Page;
import com.yk.shop.common.service.CrudService;
import com.yk.shop.modules.goodstype.entity.GoodsType;
import com.yk.shop.modules.goodstype.dao.GoodsTypeDao;

/**
 * 描述商品的分类Service
 * @author 黄寿勇
 * @version 2018-05-06
 */
@Service
@Transactional(readOnly = true)
public class GoodsTypeService extends CrudService<GoodsTypeDao, GoodsType> implements IGoodsTypeService{
	
}