/**
 * 
 */
package com.yk.shop.modules.account.dao.interf;

import com.yk.shop.basedao.CrudDao;
import com.yk.shop.basedao.annotation.MyBatisDao;
import com.yk.shop.modules.account.entity.AccountBalance;

/**
 * 支付配置DAO接口
 * @author 黄寿勇
 * @version 2018-05-14
 */
@MyBatisDao
public interface AccountBalanceDao extends CrudDao<AccountBalance> {
	
}