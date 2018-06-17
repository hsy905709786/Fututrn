<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>支付配置管理</title>
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
		<li><a href="${ctx}/account/accountBalance/">支付配置列表</a></li>
		<li class="active"><a href="${ctx}/account/accountBalance/form?id=${accountBalance.id}">支付配置<shiro:hasPermission name="account:accountBalance:edit">${not empty accountBalance.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="account:accountBalance:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="accountBalance" action="${ctx}/account/accountBalance/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="form-group">
			<div class="col-xs-3">
				<label for="accountId">0：</label>
				<form:input path="accountId" htmlEscape="false" maxlength="64" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="balanceType">0：</label>
				<form:input path="balanceType" htmlEscape="false" maxlength="20" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="amount">0：</label>
				<form:input path="amount" htmlEscape="false" class="form-control required number"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="userType">0：</label>
				<form:input path="userType" htmlEscape="false" maxlength="10" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="account:accountBalance:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>