/**
 * 
 */
package com.yk.shop.modules.account.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.yk.shop.baseentity.DataEntity;

/**
 * 支付配置Entity
 * @author 黄寿勇
 * @version 2018-05-14
 */
public class AccountBalance extends DataEntity<AccountBalance> {
	
	private static final long serialVersionUID = 1L;
	private String accountId;		// 0
	private String balanceType;		// 0
	private Double amount;		// 0
	private String userType;		// 0
	
	public AccountBalance() {
		super();
	}

	public AccountBalance(String id){
		super(id);
	}

	@Length(min=1, max=64, message="0长度必须介于 1 和 64 之间")
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	@Length(min=1, max=20, message="0长度必须介于 1 和 20 之间")
	public String getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(String balanceType) {
		this.balanceType = balanceType;
	}
	
	@NotNull(message="0不能为空")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Length(min=1, max=10, message="0长度必须介于 1 和 10 之间")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}