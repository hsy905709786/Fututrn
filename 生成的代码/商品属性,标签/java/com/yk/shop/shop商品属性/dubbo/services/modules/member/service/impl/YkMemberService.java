/**
 * 
 */
package com.whs.shop.dubbo.services.modules.member.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.shop.baseentity.Page;
import com.yk.shop.common.service.CrudService;
import com.whs.shop.dubbo.services.modules.member.entity.YkMember;
import com.whs.shop.dubbo.services.modules.member.dao.YkMemberDao;

/**
 * 会员业务Service
 * @author xie
 * @version 2018-05-02
 */
@Service
@Transactional(readOnly = true)
public class YkMemberService extends CrudService<YkMemberDao, YkMember> implements IYkMemberService{
	
}