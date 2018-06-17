/**
 * 
 */
package com.whs.shop.modules.goods.dao.interf.attribute;

import com.yk.shop.basedao.CrudDao;
import com.yk.shop.basedao.annotation.MyBatisDao;
import com.whs.shop.modules.goods.entity.attribute.YkGoodsProperty;

/**
 * 展示商品属性DAO接口
 * @author 黄寿勇
 * @version 2018-05-04
 */
@MyBatisDao
public interface YkGoodsPropertyDao extends CrudDao<YkGoodsProperty> {
	
}