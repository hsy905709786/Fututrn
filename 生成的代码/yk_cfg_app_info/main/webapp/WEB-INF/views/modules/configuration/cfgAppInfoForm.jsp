<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>info管理</title>
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
		<li><a href="${ctx}/configuration/cfgAppInfo/">info列表</a></li>
		<li class="active"><a href="${ctx}/configuration/cfgAppInfo/form?id=${cfgAppInfo.id}">info<shiro:hasPermission name="configuration:cfgAppInfo:edit">${not empty cfgAppInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="configuration:cfgAppInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="cfgAppInfo" action="${ctx}/configuration/cfgAppInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="form-group">
			<div class="col-xs-3">
				<label for="title">0：</label>
				<form:input path="title" htmlEscape="false" maxlength="50" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="photoUrl">0：</label>
				<form:input path="photoUrl" htmlEscape="false" maxlength="255" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="linkType">0：</label>
				<form:input path="linkType" htmlEscape="false" maxlength="20" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="linkContent">0：</label>
				<form:input path="linkContent" htmlEscape="false" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="positionCode">0：</label>
				<form:input path="positionCode" htmlEscape="false" maxlength="30" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="sortNum">0：</label>
				<form:input path="sortNum" htmlEscape="false" maxlength="4" class="form-control required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="remark">0：</label>
				<form:input path="remark" htmlEscape="false" maxlength="100" class="form-control  digits"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="configuration:cfgAppInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>