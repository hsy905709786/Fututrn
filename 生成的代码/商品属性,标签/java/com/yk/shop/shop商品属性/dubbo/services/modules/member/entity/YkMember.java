/**
 * 
 */
package com.whs.shop.dubbo.services.modules.member.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.yk.shop.baseentity.DataEntity;

/**
 * 会员业务Entity
 * @author xie
 * @version 2018-05-02
 */
public class YkMember extends DataEntity<YkMember> {
	
	private static final long serialVersionUID = 1L;
	private String loginName;		// 登录名
	private String loginPassword;		// 登录密码
	private String nickName;		// 昵称
	private String trueName;		// 真实姓名
	private String phone;		// 手机号
	private String tel;		// 座机电话
	private String memberLevelId;		// 会员角色ID
	private Integer sex;		// 性别 -1不限，1男，2女
	private Date birthday;		// 生日
	private String email;		// 邮箱
	private String headImg;		// 头像
	private String provinceId;		// 省id
	private String cityId;		// 市id
	private String area;		// 区id
	private String regionName;		// 省_市_区名称
	private String address;		// 详细地址
	private String recommendMemberId;		// 推荐人id
	private String promoteUrl;		// 推广二维码
	private String roleType;		// 类型，member会员，store门店
	private Integer status;		// 状态，0有效，1无效
	private Integer channelId;		// 来源渠道ID
	
	public YkMember() {
		super();
	}

	public YkMember(String id){
		super(id);
	}

	@Length(min=1, max=50, message="登录名长度必须介于 1 和 50 之间")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Length(min=1, max=100, message="登录密码长度必须介于 1 和 100 之间")
	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	@Length(min=1, max=30, message="昵称长度必须介于 1 和 30 之间")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Length(min=1, max=20, message="真实姓名长度必须介于 1 和 20 之间")
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	@Length(min=1, max=15, message="手机号长度必须介于 1 和 15 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=30, message="座机电话长度必须介于 0 和 30 之间")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Length(min=1, max=64, message="会员角色ID长度必须介于 1 和 64 之间")
	public String getMemberLevelId() {
		return memberLevelId;
	}

	public void setMemberLevelId(String memberLevelId) {
		this.memberLevelId = memberLevelId;
	}
	
	@NotNull(message="性别 -1不限，1男，2女不能为空")
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=0, max=50, message="邮箱长度必须介于 0 和 50 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=255, message="头像长度必须介于 0 和 255 之间")
	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	
	@Length(min=0, max=20, message="省id长度必须介于 0 和 20 之间")
	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	
	@Length(min=0, max=20, message="市id长度必须介于 0 和 20 之间")
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	@Length(min=0, max=20, message="区id长度必须介于 0 和 20 之间")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=20, message="省_市_区名称长度必须介于 0 和 20 之间")
	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	@Length(min=0, max=100, message="详细地址长度必须介于 0 和 100 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=1, max=64, message="推荐人id长度必须介于 1 和 64 之间")
	public String getRecommendMemberId() {
		return recommendMemberId;
	}

	public void setRecommendMemberId(String recommendMemberId) {
		this.recommendMemberId = recommendMemberId;
	}
	
	@Length(min=0, max=255, message="推广二维码长度必须介于 0 和 255 之间")
	public String getPromoteUrl() {
		return promoteUrl;
	}

	public void setPromoteUrl(String promoteUrl) {
		this.promoteUrl = promoteUrl;
	}
	
	@Length(min=1, max=10, message="类型，member会员，store门店长度必须介于 1 和 10 之间")
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@NotNull(message="来源渠道ID不能为空")
	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	
}