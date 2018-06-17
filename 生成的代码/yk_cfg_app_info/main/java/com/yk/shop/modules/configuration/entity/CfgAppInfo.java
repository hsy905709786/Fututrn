/**
 * 
 */
package com.yk.shop.modules.configuration.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.yk.shop.baseentity.DataEntity;

/**
 * infoEntity
 * @author 黄寿勇
 * @version 2018-05-17
 */
public class CfgAppInfo extends DataEntity<CfgAppInfo> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 0
	private String photoUrl;		// 0
	private String linkType;		// 0
	private String linkContent;		// 0
	private String positionCode;		// 0
	private Integer sortNum;		// 0
	private Integer remark;		// 0
	
	public CfgAppInfo() {
		super();
	}

	public CfgAppInfo(String id){
		super(id);
	}

	@Length(min=0, max=50, message="0长度必须介于 0 和 50 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=255, message="0长度必须介于 0 和 255 之间")
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	@Length(min=1, max=20, message="0长度必须介于 1 和 20 之间")
	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	
	public String getLinkContent() {
		return linkContent;
	}

	public void setLinkContent(String linkContent) {
		this.linkContent = linkContent;
	}
	
	@Length(min=1, max=30, message="0长度必须介于 1 和 30 之间")
	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}
	
	@NotNull(message="0不能为空")
	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	
	public Integer getRemark() {
		return remark;
	}

	public void setRemark(Integer remark) {
		this.remark = remark;
	}
	
}