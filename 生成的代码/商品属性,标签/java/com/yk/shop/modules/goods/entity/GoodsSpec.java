/**
 * 
 */
package com.yk.shop.modules.goods.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.yk.shop.baseentity.DataEntity;

/**
 * 商品规格Entity
 * @author huang
 * @version 2018-05-05
 */
public class GoodsSpec extends DataEntity<GoodsSpec> {
	
	private static final long serialVersionUID = 1L;
	private String goodsId;		// 0
	private String goodsSpecNo;		// 0
	private String specArray;		// 0
	private String differencePrice;		// 0
	private Integer storeNum;		// 0
	private Integer storeWarnVal;		// 0
	
	public GoodsSpec() {
		super();
	}

	public GoodsSpec(String id){
		super(id);
	}

	@Length(min=1, max=64, message="0长度必须介于 1 和 64 之间")
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	
	@Length(min=1, max=64, message="0长度必须介于 1 和 64 之间")
	public String getGoodsSpecNo() {
		return goodsSpecNo;
	}

	public void setGoodsSpecNo(String goodsSpecNo) {
		this.goodsSpecNo = goodsSpecNo;
	}
	
	@Length(min=1, max=1000, message="0长度必须介于 1 和 1000 之间")
	public String getSpecArray() {
		return specArray;
	}

	public void setSpecArray(String specArray) {
		this.specArray = specArray;
	}
	
	public String getDifferencePrice() {
		return differencePrice;
	}

	public void setDifferencePrice(String differencePrice) {
		this.differencePrice = differencePrice;
	}
	
	@NotNull(message="0不能为空")
	public Integer getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(Integer storeNum) {
		this.storeNum = storeNum;
	}
	
	@NotNull(message="0不能为空")
	public Integer getStoreWarnVal() {
		return storeWarnVal;
	}

	public void setStoreWarnVal(Integer storeWarnVal) {
		this.storeWarnVal = storeWarnVal;
	}
	
}