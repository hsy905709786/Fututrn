/**
 * 
 */
package com.yk.shop.modules.configuration.dao.interf;

import com.yk.shop.basedao.CrudDao;
import com.yk.shop.basedao.annotation.MyBatisDao;
import com.yk.shop.modules.configuration.entity.CfgAppInfo;

/**
 * infoDAO接口
 * @author 黄寿勇
 * @version 2018-05-17
 */
@MyBatisDao
public interface CfgAppInfoDao extends CrudDao<CfgAppInfo> {
	
}