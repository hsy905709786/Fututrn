/**
 * 
 */
package com.pengji.linker.dubbox.services.modules.corpbusinessmanager.entity;

import org.hibernate.validator.constraints.Length;

import com.pengji.linker.baseentity.DataEntity;

/**
 * 用户角色查看权限业务Entity
 * @author 谢佯均
 * @version 2018-04-19
 */
public class AppFunSeeRole extends DataEntity<AppFunSeeRole> {
	
	private static final long serialVersionUID = 1L;
	private String funCode;		// 0
	private String roleValue;		// 0
	private String funRemark;		// 0
	private String merchantinfoId;		// 0
	
	public AppFunSeeRole() {
		super();
	}

	public AppFunSeeRole(String id){
		super(id);
	}

	@Length(min=0, max=50, message="0长度必须介于 0 和 50 之间")
	public String getFunCode() {
		return funCode;
	}

	public void setFunCode(String funCode) {
		this.funCode = funCode;
	}
	
	@Length(min=0, max=100, message="0长度必须介于 0 和 100 之间")
	public String getRoleValue() {
		return roleValue;
	}

	public void setRoleValue(String roleValue) {
		this.roleValue = roleValue;
	}
	
	@Length(min=0, max=50, message="0长度必须介于 0 和 50 之间")
	public String getFunRemark() {
		return funRemark;
	}

	public void setFunRemark(String funRemark) {
		this.funRemark = funRemark;
	}
	
	@Length(min=1, max=64, message="0长度必须介于 1 和 64 之间")
	public String getMerchantinfoId() {
		return merchantinfoId;
	}

	public void setMerchantinfoId(String merchantinfoId) {
		this.merchantinfoId = merchantinfoId;
	}
	
}