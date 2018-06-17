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
		<li><a href="${ctx}/account/ykCfgPayment/">支付配置列表</a></li>
		<li class="active"><a href="${ctx}/account/ykCfgPayment/form?id=${ykCfgPayment.id}">支付配置<shiro:hasPermission name="account:ykCfgPayment:edit">${not empty ykCfgPayment.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="account:ykCfgPayment:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="ykCfgPayment" action="${ctx}/account/ykCfgPayment/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="form-group">
			<div class="col-xs-3">
				<label for="alipayAppid">0：</label>
				<form:input path="alipayAppid" htmlEscape="false" maxlength="32" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="alipayAppPrivateKey">0：</label>
				<form:input path="alipayAppPrivateKey" htmlEscape="false" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="alipayPublicKey">0：</label>
				<form:input path="alipayPublicKey" htmlEscape="false" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="wxAppid">0：</label>
				<form:input path="wxAppid" htmlEscape="false" maxlength="32" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="wxAppsecret">0：</label>
				<form:input path="wxAppsecret" htmlEscape="false" maxlength="64" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="wxMchid">0：</label>
				<form:input path="wxMchid" htmlEscape="false" maxlength="32" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="wxPayKey">0：</label>
				<form:input path="wxPayKey" htmlEscape="false" maxlength="64" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="wxPubAppid">0：</label>
				<form:input path="wxPubAppid" htmlEscape="false" maxlength="32" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="wxPubAppsecret">0：</label>
				<form:input path="wxPubAppsecret" htmlEscape="false" maxlength="64" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="wxPubMchid">0：</label>
				<form:input path="wxPubMchid" htmlEscape="false" maxlength="32" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="wxPubPayKey">0：</label>
				<form:input path="wxPubPayKey" htmlEscape="false" maxlength="64" class="form-control "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="account:ykCfgPayment:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>