/**
 * 
 */
package com.yk.shop.modules.goodstype.dao.interf;

import com.yk.shop.basedao.CrudDao;
import com.yk.shop.basedao.annotation.MyBatisDao;
import com.yk.shop.modules.goodstype.entity.GoodsType;

/**
 * 描述商品的分类DAO接口
 * @author 黄寿勇
 * @version 2018-05-06
 */
@MyBatisDao
public interface GoodsTypeDao extends CrudDao<GoodsType> {
	
}