<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品规格管理</title>
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
		<li><a href="${ctx}/goods/goodsSpec/">商品规格列表</a></li>
		<li class="active"><a href="${ctx}/goods/goodsSpec/form?id=${goodsSpec.id}">商品规格<shiro:hasPermission name="goods:goodsSpec:edit">${not empty goodsSpec.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="goods:goodsSpec:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="goodsSpec" action="${ctx}/goods/goodsSpec/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="form-group">
			<div class="col-xs-3">
				<label for="goodsId">0：</label>
				<form:input path="goodsId" htmlEscape="false" maxlength="64" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="goodsSpecNo">0：</label>
				<form:input path="goodsSpecNo" htmlEscape="false" maxlength="64" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="specArray">0：</label>
				<form:input path="specArray" htmlEscape="false" maxlength="1000" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="differencePrice">0：</label>
				<form:input path="differencePrice" htmlEscape="false" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="storeNum">0：</label>
				<form:input path="storeNum" htmlEscape="false" maxlength="4" class="form-control required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="storeWarnVal">0：</label>
				<form:input path="storeWarnVal" htmlEscape="false" maxlength="4" class="form-control required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="goods:goodsSpec:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>