/**
 * 
 */
package com.yk.shop.modules.message.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.shop.baseentity.Page;
import com.yk.shop.common.service.CrudService;
import com.yk.shop.modules.message.entity.MessageBase;
import com.yk.shop.modules.message.dao.MessageBaseDao;

/**
 * 消息Service
 * @author 黄寿勇
 * @version 2018-05-17
 */
@Service
@Transactional(readOnly = true)
public class MessageBaseService extends CrudService<MessageBaseDao, MessageBase> implements IMessageBaseService{
	
}