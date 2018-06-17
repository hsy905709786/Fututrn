/**
 * 
 */
package com.yk.shop.modules.account.dao.interf;

import com.yk.shop.basedao.CrudDao;
import com.yk.shop.basedao.annotation.MyBatisDao;
import com.yk.shop.modules.account.entity.YkCfgPayment;

/**
 * 支付配置DAO接口
 * @author 黄寿勇
 * @version 2018-05-15
 */
@MyBatisDao
public interface YkCfgPaymentDao extends CrudDao<YkCfgPayment> {
	
}