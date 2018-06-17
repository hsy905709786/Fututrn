/**
 * 
 */
package com.yk.shop.modules.商品评论.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.shop.baseentity.Page;
import com.yk.shop.common.service.CrudService;
import com.yk.shop.modules.商品评论.entity.GoodsComments;
import com.yk.shop.modules.商品评论.dao.GoodsCommentsDao;

/**
 * 商品点赞Service
 * @author huangshouyong
 * @version 2018-05-08
 */
@Service
@Transactional(readOnly = true)
public class GoodsCommentsService extends CrudService<GoodsCommentsDao, GoodsComments> implements IGoodsCommentsService{
	
}