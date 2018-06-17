<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>消息管理</title>
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
		<li><a href="${ctx}/message/messageBase/">消息列表</a></li>
		<li class="active"><a href="${ctx}/message/messageBase/form?id=${messageBase.id}">消息<shiro:hasPermission name="message:messageBase:edit">${not empty messageBase.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="message:messageBase:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="messageBase" action="${ctx}/message/messageBase/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="form-group">
			<div class="col-xs-3">
				<label for="msgType">0：</label>
				<form:input path="msgType" htmlEscape="false" maxlength="10" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="title">0：</label>
				<form:input path="title" htmlEscape="false" maxlength="100" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="subTitle">0：</label>
				<form:input path="subTitle" htmlEscape="false" maxlength="100" class="form-control "/>
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
				<label for="content">0：</label>
				<form:textarea path="content" htmlEscape="false" rows="4" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="sendType">0：</label>
				<form:input path="sendType" htmlEscape="false" maxlength="1" class="form-control required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="isPlay">0：</label>
				<form:input path="isPlay" htmlEscape="false" maxlength="1" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="playContent">0：</label>
				<form:input path="playContent" htmlEscape="false" maxlength="200" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="linkType">0：</label>
				<form:input path="linkType" htmlEscape="false" maxlength="10" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="linkContent">0：</label>
				<form:input path="linkContent" htmlEscape="false" maxlength="300" class="form-control "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="message:messageBase:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>