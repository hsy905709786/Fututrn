/**
 * 
 */
package com.yk.shop.modules.goods.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.shop.baseentity.Page;
import com.yk.shop.common.service.CrudService;
import com.yk.shop.modules.goods.entity.GoodsSpec;
import com.yk.shop.modules.goods.dao.GoodsSpecDao;

/**
 * 商品规格Service
 * @author huang
 * @version 2018-05-05
 */
@Service
@Transactional(readOnly = true)
public class GoodsSpecService extends CrudService<GoodsSpecDao, GoodsSpec> implements IGoodsSpecService{
	
}