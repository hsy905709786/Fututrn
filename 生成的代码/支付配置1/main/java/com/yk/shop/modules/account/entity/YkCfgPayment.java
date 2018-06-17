/**
 * 
 */
package com.yk.shop.modules.account.entity;

import org.hibernate.validator.constraints.Length;

import com.yk.shop.baseentity.DataEntity;

/**
 * 支付配置Entity
 * @author 黄寿勇
 * @version 2018-05-15
 */
public class YkCfgPayment extends DataEntity<YkCfgPayment> {
	
	private static final long serialVersionUID = 1L;
	private String alipayAppid;		// 0
	private String alipayAppPrivateKey;		// 0
	private String alipayPublicKey;		// 0
	private String wxAppid;		// 0
	private String wxAppsecret;		// 0
	private String wxMchid;		// 0
	private String wxPayKey;		// 0
	private String wxPubAppid;		// 0
	private String wxPubAppsecret;		// 0
	private String wxPubMchid;		// 0
	private String wxPubPayKey;		// 0
	
	public YkCfgPayment() {
		super();
	}

	public YkCfgPayment(String id){
		super(id);
	}

	@Length(min=0, max=32, message="0长度必须介于 0 和 32 之间")
	public String getAlipayAppid() {
		return alipayAppid;
	}

	public void setAlipayAppid(String alipayAppid) {
		this.alipayAppid = alipayAppid;
	}
	
	public String getAlipayAppPrivateKey() {
		return alipayAppPrivateKey;
	}

	public void setAlipayAppPrivateKey(String alipayAppPrivateKey) {
		this.alipayAppPrivateKey = alipayAppPrivateKey;
	}
	
	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}

	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}
	
	@Length(min=0, max=32, message="0长度必须介于 0 和 32 之间")
	public String getWxAppid() {
		return wxAppid;
	}

	public void setWxAppid(String wxAppid) {
		this.wxAppid = wxAppid;
	}
	
	@Length(min=0, max=64, message="0长度必须介于 0 和 64 之间")
	public String getWxAppsecret() {
		return wxAppsecret;
	}

	public void setWxAppsecret(String wxAppsecret) {
		this.wxAppsecret = wxAppsecret;
	}
	
	@Length(min=0, max=32, message="0长度必须介于 0 和 32 之间")
	public String getWxMchid() {
		return wxMchid;
	}

	public void setWxMchid(String wxMchid) {
		this.wxMchid = wxMchid;
	}
	
	@Length(min=0, max=64, message="0长度必须介于 0 和 64 之间")
	public String getWxPayKey() {
		return wxPayKey;
	}

	public void setWxPayKey(String wxPayKey) {
		this.wxPayKey = wxPayKey;
	}
	
	@Length(min=0, max=32, message="0长度必须介于 0 和 32 之间")
	public String getWxPubAppid() {
		return wxPubAppid;
	}

	public void setWxPubAppid(String wxPubAppid) {
		this.wxPubAppid = wxPubAppid;
	}
	
	@Length(min=0, max=64, message="0长度必须介于 0 和 64 之间")
	public String getWxPubAppsecret() {
		return wxPubAppsecret;
	}

	public void setWxPubAppsecret(String wxPubAppsecret) {
		this.wxPubAppsecret = wxPubAppsecret;
	}
	
	@Length(min=0, max=32, message="0长度必须介于 0 和 32 之间")
	public String getWxPubMchid() {
		return wxPubMchid;
	}

	public void setWxPubMchid(String wxPubMchid) {
		this.wxPubMchid = wxPubMchid;
	}
	
	@Length(min=0, max=64, message="0长度必须介于 0 和 64 之间")
	public String getWxPubPayKey() {
		return wxPubPayKey;
	}

	public void setWxPubPayKey(String wxPubPayKey) {
		this.wxPubPayKey = wxPubPayKey;
	}
	
}