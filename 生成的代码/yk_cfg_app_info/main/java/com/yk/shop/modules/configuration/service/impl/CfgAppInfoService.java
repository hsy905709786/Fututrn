/**
 * 
 */
package com.yk.shop.modules.configuration.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.shop.baseentity.Page;
import com.yk.shop.common.service.CrudService;
import com.yk.shop.modules.configuration.entity.CfgAppInfo;
import com.yk.shop.modules.configuration.dao.CfgAppInfoDao;

/**
 * infoService
 * @author 黄寿勇
 * @version 2018-05-17
 */
@Service
@Transactional(readOnly = true)
public class CfgAppInfoService extends CrudService<CfgAppInfoDao, CfgAppInfo> implements ICfgAppInfoService{
	
}