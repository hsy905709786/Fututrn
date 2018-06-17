/**
 * 
 */
package com.yk.shop.modules.品牌模块.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.shop.baseentity.Page;
import com.yk.shop.common.service.CrudService;
import com.yk.shop.modules.品牌模块.entity.Brand;
import com.yk.shop.modules.品牌模块.dao.BrandDao;

/**
 * 品牌模块Service
 * @author 黄寿勇
 * @version 2018-05-11
 */
@Service
@Transactional(readOnly = true)
public class BrandService extends CrudService<BrandDao, Brand> implements IBrandService{
	
}