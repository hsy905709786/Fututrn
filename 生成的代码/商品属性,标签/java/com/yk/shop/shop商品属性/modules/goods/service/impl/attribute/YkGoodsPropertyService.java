/**
 * 
 */
package com.whs.shop.modules.goods.service.attribute.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.shop.baseentity.Page;
import com.yk.shop.common.service.CrudService;
import com.whs.shop.modules.goods.entity.attribute.YkGoodsProperty;
import com.whs.shop.modules.goods.dao.attribute.YkGoodsPropertyDao;

/**
 * 展示商品属性Service
 * @author 黄寿勇
 * @version 2018-05-04
 */
@Service
@Transactional(readOnly = true)
public class YkGoodsPropertyService extends CrudService<YkGoodsPropertyDao, YkGoodsProperty> implements IYkGoodsPropertyService{
	
}