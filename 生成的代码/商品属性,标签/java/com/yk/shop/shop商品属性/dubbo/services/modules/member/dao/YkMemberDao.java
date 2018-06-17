/**
 * 
 */
package com.whs.shop.dubbo.services.modules.member.dao.interf;

import com.yk.shop.basedao.CrudDao;
import com.yk.shop.basedao.annotation.MyBatisDao;
import com.whs.shop.dubbo.services.modules.member.entity.YkMember;

/**
 * 会员业务DAO接口
 * @author xie
 * @version 2018-05-02
 */
@MyBatisDao
public interface YkMemberDao extends CrudDao<YkMember> {
	
}