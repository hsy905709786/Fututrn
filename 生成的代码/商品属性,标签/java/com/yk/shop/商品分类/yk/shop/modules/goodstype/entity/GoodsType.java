/**
 * 
 */
package com.yk.shop.modules.goodstype.entity;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;

import com.yk.shop.baseentity.DataEntity;

/**
 * 描述商品的分类Entity
 * @author 黄寿勇
 * @version 2018-05-05
 */
public class GoodsType extends DataEntity<GoodsType> {
	
	private static final long serialVersionUID = 1L;
	private String typeName;		// 0
	private GoodsType parent;		// 0
	private String typePhotoUrl;		// 0
	private String isShow;		// 0
	private Integer goodsNum;		// 0
	private Integer sortNum;		// 0
	
	public GoodsType() {
		super();
	}

	public GoodsType(String id){
		super(id);
	}

	@Length(min=1, max=64, message="0长度必须介于 1 和 64 之间")
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@JsonBackReference
	@NotNull(message="0不能为空")
	public GoodsType getParent() {
		return parent;
	}

	public void setParent(GoodsType parent) {
		this.parent = parent;
	}
	
	@Length(min=0, max=255, message="0长度必须介于 0 和 255 之间")
	public String getTypePhotoUrl() {
		return typePhotoUrl;
	}

	public void setTypePhotoUrl(String typePhotoUrl) {
		this.typePhotoUrl = typePhotoUrl;
	}
	
	@Length(min=1, max=1, message="0长度必须介于 1 和 1 之间")
	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
	@NotNull(message="0不能为空")
	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	
	@NotNull(message="0不能为空")
	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	
}