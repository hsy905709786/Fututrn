/**
 * 
 */
package com.pengji.linker.dubbox.services.modules.corpbusinessmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengji.linker.baseentity.Page;
import com.pengji.linker.common.service.CrudService;
import com.pengji.linker.dubbox.services.modules.corpbusinessmanager.entity.AppFunSeeRole;
import com.pengji.linker.dubbox.services.modules.corpbusinessmanager.dao.AppFunSeeRoleDao;

/**
 * 用户角色查看权限业务Service
 * @author 谢佯均
 * @version 2018-04-19
 */
@Service
@Transactional(readOnly = true)
public class AppFunSeeRoleService extends CrudService<AppFunSeeRoleDao, AppFunSeeRole> implements IAppFunSeeRoleService{
	
}