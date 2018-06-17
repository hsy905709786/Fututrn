/**
 * 
 */
package com.yk.shop.modules.message.dao.interf;

import com.yk.shop.basedao.CrudDao;
import com.yk.shop.basedao.annotation.MyBatisDao;
import com.yk.shop.modules.message.entity.MessageBase;

/**
 * 消息DAO接口
 * @author 黄寿勇
 * @version 2018-05-17
 */
@MyBatisDao
public interface MessageBaseDao extends CrudDao<MessageBase> {
	
}