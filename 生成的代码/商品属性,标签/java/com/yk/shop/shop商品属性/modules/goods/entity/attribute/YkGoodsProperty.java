/**
 * 
 */
package com.whs.shop.modules.goods.entity.attribute;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.yk.shop.baseentity.DataEntity;

/**
 * 展示商品属性Entity
 * @author 黄寿勇
 * @version 2018-05-04
 */
public class YkGoodsProperty extends DataEntity<YkGoodsProperty> {
	
	private static final long serialVersionUID = 1L;
	private String propertyName;		// 属性名称
	private Integer propertyType;		// 属性类型 1手机，2配件
	private Integer sortNum;		// 排序号
	private String createByUserID;		// 创建人
	private String isShow;		// 是否显示 Y显示，N显示
	
	public YkGoodsProperty() {
		super();
	}

	public YkGoodsProperty(String id){
		super(id);
	}

	@Length(min=1, max=30, message="属性名称长度必须介于 1 和 30 之间")
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	@NotNull(message="属性类型 1手机，2配件不能为空")
	public Integer getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}
	
	@NotNull(message="排序号不能为空")
	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	
	@Length(min=1, max=64, message="创建人长度必须介于 1 和 64 之间")
	public String getCreateByUserID() {
		return createByUserID;
	}

	public void setCreateByUserID(String createByUserID) {
		this.createByUserID = createByUserID;
	}
	
	@Length(min=1, max=1, message="是否显示 Y显示，N显示长度必须介于 1 和 1 之间")
	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
}