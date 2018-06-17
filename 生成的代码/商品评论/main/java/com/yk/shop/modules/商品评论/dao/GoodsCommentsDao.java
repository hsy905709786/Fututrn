/**
 * 
 */
package com.yk.shop.modules.商品评论.dao.interf;

import com.yk.shop.basedao.CrudDao;
import com.yk.shop.basedao.annotation.MyBatisDao;
import com.yk.shop.modules.商品评论.entity.GoodsComments;

/**
 * 商品点赞DAO接口
 * @author huangshouyong
 * @version 2018-05-08
 */
@MyBatisDao
public interface GoodsCommentsDao extends CrudDao<GoodsComments> {
	
}