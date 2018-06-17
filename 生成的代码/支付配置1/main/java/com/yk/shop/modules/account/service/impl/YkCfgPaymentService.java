/**
 * 
 */
package com.yk.shop.modules.account.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.shop.baseentity.Page;
import com.yk.shop.common.service.CrudService;
import com.yk.shop.modules.account.entity.YkCfgPayment;
import com.yk.shop.modules.account.dao.YkCfgPaymentDao;

/**
 * 支付配置Service
 * @author 黄寿勇
 * @version 2018-05-15
 */
@Service
@Transactional(readOnly = true)
public class YkCfgPaymentService extends CrudService<YkCfgPaymentDao, YkCfgPayment> implements IYkCfgPaymentService{
	
}