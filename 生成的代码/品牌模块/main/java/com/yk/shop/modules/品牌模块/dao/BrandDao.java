/**
 * 
 */
package com.yk.shop.modules.品牌模块.dao.interf;

import com.yk.shop.basedao.CrudDao;
import com.yk.shop.basedao.annotation.MyBatisDao;
import com.yk.shop.modules.品牌模块.entity.Brand;

/**
 * 品牌模块DAO接口
 * @author 黄寿勇
 * @version 2018-05-11
 */
@MyBatisDao
public interface BrandDao extends CrudDao<Brand> {
	
}