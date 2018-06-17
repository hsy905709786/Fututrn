/**
 * 
 */
package com.yk.shop.modules.goods.dao.interf;

import com.yk.shop.basedao.CrudDao;
import com.yk.shop.basedao.annotation.MyBatisDao;
import com.yk.shop.modules.goods.entity.GoodsSpec;

/**
 * 商品规格DAO接口
 * @author huang
 * @version 2018-05-05
 */
@MyBatisDao
public interface GoodsSpecDao extends CrudDao<GoodsSpec> {
	
}