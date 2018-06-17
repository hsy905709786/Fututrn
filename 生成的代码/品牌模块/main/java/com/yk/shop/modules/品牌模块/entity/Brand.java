/**
 * 
 */
package com.yk.shop.modules.品牌模块.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.yk.shop.baseentity.DataEntity;

/**
 * 品牌模块Entity
 * @author 黄寿勇
 * @version 2018-05-11
 */
public class Brand extends DataEntity<Brand> {
	
	private static final long serialVersionUID = 1L;
	private String brandNo;		// 0
	private String brandCname;		// 0
	private Integer brandKeywords;		// 0
	private Integer brandLogo;		// 0
	private Integer brandRemark;		// 0
	private String isShow;		// 0
	private String isRecommend;		// 0
	private Integer sortNum;		// 0
	
	public Brand() {
		super();
	}

	public Brand(String id){
		super(id);
	}

	@Length(min=0, max=50, message="0长度必须介于 0 和 50 之间")
	public String getBrandNo() {
		return brandNo;
	}

	public void setBrandNo(String brandNo) {
		this.brandNo = brandNo;
	}
	
	@Length(min=1, max=30, message="0长度必须介于 1 和 30 之间")
	public String getBrandCname() {
		return brandCname;
	}

	public void setBrandCname(String brandCname) {
		this.brandCname = brandCname;
	}
	
	public Integer getBrandKeywords() {
		return brandKeywords;
	}

	public void setBrandKeywords(Integer brandKeywords) {
		this.brandKeywords = brandKeywords;
	}
	
	public Integer getBrandLogo() {
		return brandLogo;
	}

	public void setBrandLogo(Integer brandLogo) {
		this.brandLogo = brandLogo;
	}
	
	public Integer getBrandRemark() {
		return brandRemark;
	}

	public void setBrandRemark(Integer brandRemark) {
		this.brandRemark = brandRemark;
	}
	
	@Length(min=1, max=1, message="0长度必须介于 1 和 1 之间")
	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
	@Length(min=0, max=1, message="0长度必须介于 0 和 1 之间")
	public String getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(String isRecommend) {
		this.isRecommend = isRecommend;
	}
	
	@NotNull(message="0不能为空")
	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	
}