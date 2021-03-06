<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>品牌模块管理</title>
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
		<li><a href="${ctx}/品牌模块/brand/">品牌模块列表</a></li>
		<li class="active"><a href="${ctx}/品牌模块/brand/form?id=${brand.id}">品牌模块<shiro:hasPermission name="品牌模块:brand:edit">${not empty brand.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="品牌模块:brand:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="brand" action="${ctx}/品牌模块/brand/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="form-group">
			<div class="col-xs-3">
				<label for="brandNo">0：</label>
				<form:input path="brandNo" htmlEscape="false" maxlength="50" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="brandCname">0：</label>
				<form:input path="brandCname" htmlEscape="false" maxlength="30" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="brandKeywords">0：</label>
				<form:input path="brandKeywords" htmlEscape="false" maxlength="50" class="form-control  digits"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="brandLogo">0：</label>
				<form:input path="brandLogo" htmlEscape="false" maxlength="255" class="form-control  digits"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="brandRemark">0：</label>
				<form:input path="brandRemark" htmlEscape="false" maxlength="255" class="form-control  digits"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="isShow">0：</label>
				<form:input path="isShow" htmlEscape="false" maxlength="1" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="isRecommend">0：</label>
				<form:input path="isRecommend" htmlEscape="false" maxlength="1" class="form-control "/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="sortNum">0：</label>
				<form:input path="sortNum" htmlEscape="false" maxlength="4" class="form-control required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="品牌模块:brand:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>