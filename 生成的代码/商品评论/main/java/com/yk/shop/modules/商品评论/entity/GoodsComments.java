/**
 * 
 */
package com.yk.shop.modules.商品评论.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.yk.shop.baseentity.DataEntity;

/**
 * 商品点赞Entity
 * @author huangshouyong
 * @version 2018-05-08
 */
public class GoodsComments extends DataEntity<GoodsComments> {
	
	private static final long serialVersionUID = 1L;
	private String goodsId;		// 0
	private String memberId;		// 0
	private String content;		// 0
	private Integer likes;		// 0
	
	public GoodsComments() {
		super();
	}

	public GoodsComments(String id){
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
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@Length(min=1, max=200, message="0长度必须介于 1 和 200 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@NotNull(message="0不能为空")
	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
}