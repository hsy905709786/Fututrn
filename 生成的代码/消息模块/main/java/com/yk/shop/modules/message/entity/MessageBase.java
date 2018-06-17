/**
 * 
 */
package com.yk.shop.modules.message.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.yk.shop.baseentity.DataEntity;

/**
 * 消息Entity
 * @author 黄寿勇
 * @version 2018-05-17
 */
public class MessageBase extends DataEntity<MessageBase> {
	
	private static final long serialVersionUID = 1L;
	private String msgType;		// 0
	private String title;		// 0
	private String subTitle;		// 0
	private String photoUrl;		// 0
	private String content;		// 0
	private Integer sendType;		// 0
	private String isPlay;		// 0
	private String playContent;		// 0
	private String linkType;		// 0
	private String linkContent;		// 0
	
	public MessageBase() {
		super();
	}

	public MessageBase(String id){
		super(id);
	}

	@Length(min=1, max=10, message="0长度必须介于 1 和 10 之间")
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	@Length(min=1, max=100, message="0长度必须介于 1 和 100 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=100, message="0长度必须介于 0 和 100 之间")
	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	
	@Length(min=0, max=255, message="0长度必须介于 0 和 255 之间")
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@NotNull(message="0不能为空")
	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}
	
	@Length(min=1, max=1, message="0长度必须介于 1 和 1 之间")
	public String getIsPlay() {
		return isPlay;
	}

	public void setIsPlay(String isPlay) {
		this.isPlay = isPlay;
	}
	
	@Length(min=0, max=200, message="0长度必须介于 0 和 200 之间")
	public String getPlayContent() {
		return playContent;
	}

	public void setPlayContent(String playContent) {
		this.playContent = playContent;
	}
	
	@Length(min=1, max=10, message="0长度必须介于 1 和 10 之间")
	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	
	@Length(min=0, max=300, message="0长度必须介于 0 和 300 之间")
	public String getLinkContent() {
		return linkContent;
	}

	public void setLinkContent(String linkContent) {
		this.linkContent = linkContent;
	}
	
}