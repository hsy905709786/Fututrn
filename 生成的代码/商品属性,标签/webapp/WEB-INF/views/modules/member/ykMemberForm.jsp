<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员业务管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading();
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/member/ykMember/">会员业务列表</a></li>
		<li class="active"><a href="${ctx}/member/ykMember/form?id=${ykMember.id}">会员业务<shiro:hasPermission name="member:ykMember:edit">${not empty ykMember.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="member:ykMember:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="ykMember" action="${ctx}/member/ykMember/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="form-group">
			<div class="col-xs-3">
				<label for="loginName">登录名：</label>
				<form:input path="loginName" htmlEscape="false" maxlength="50" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="loginPassword">登录密码：</label>
				<form:input path="loginPassword" htmlEscape="false" maxlength="100" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="nickName">昵称：</label>
				<form:input path="nickName" htmlEscape="false" maxlength="30" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="trueName">真实姓名：</label>
				<form:input path="trueName" htmlEscape="false" maxlength="20" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="phone">手机号：</label>
				<form:input path="phone" htmlEscape="false" maxlength="15" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="tel">座机电话：</label>
				<form:input path="tel" htmlEscape="false" maxlength="30" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="memberLevelId">会员角色ID：</label>
				<form:input path="memberLevelId" htmlEscape="false" maxlength="64" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="sex">性别 -1不限，1男，2女：</label>
				<form:input path="sex" htmlEscape="false" maxlength="2" class="form-control required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="birthday">生日：</label>
				<input name="birthday" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${ykMember.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="email">邮箱：</label>
				<form:input path="email" htmlEscape="false" maxlength="50" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="headImg">头像：</label>
				<form:input path="headImg" htmlEscape="false" maxlength="255" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="provinceId">省id：</label>
				<form:input path="provinceId" htmlEscape="false" maxlength="20" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="cityId">市id：</label>
				<form:input path="cityId" htmlEscape="false" maxlength="20" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="area.id">区id：</label>
				<sys:treeselect id="area" name="area.id" value="${ykMember.area.id}" labelName="area.name" labelValue="${ykMember.area.name}"
					title="区域" url="/sys/area/treeData" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="regionName">省_市_区名称：</label>
				<form:input path="regionName" htmlEscape="false" maxlength="20" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="address">详细地址：</label>
				<form:input path="address" htmlEscape="false" maxlength="100" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="recommendMemberId">推荐人id：</label>
				<form:input path="recommendMemberId" htmlEscape="false" maxlength="64" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="promoteUrl">推广二维码：</label>
				<form:input path="promoteUrl" htmlEscape="false" maxlength="255" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="roleType">类型，member会员，store门店：</label>
				<form:input path="roleType" htmlEscape="false" maxlength="10" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="status">状态，0有效，1无效：</label>
				<form:input path="status" htmlEscape="false" maxlength="1" class="form-control  digits"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="channelId">来源渠道ID：</label>
				<form:input path="channelId" htmlEscape="false" maxlength="2" class="form-control required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="member:ykMember:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>