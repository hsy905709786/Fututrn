<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品属性增删改查管理</title>
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
		<li><a href="${ctx}/goods/attribute/ykGoodsProperty/">商品属性增删改查列表</a></li>
		<li class="active"><a href="${ctx}/goods/attribute/ykGoodsProperty/form?id=${ykGoodsProperty.id}">商品属性增删改查<shiro:hasPermission name="goods:attribute:ykGoodsProperty:edit">${not empty ykGoodsProperty.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="goods:attribute:ykGoodsProperty:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="ykGoodsProperty" action="${ctx}/goods/attribute/ykGoodsProperty/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="form-group">
			<div class="col-xs-3">
				<label for="propertyName">属性名称：</label>
				<form:input path="propertyName" htmlEscape="false" maxlength="30" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="propertyType">属性类型 1手机，2配件：</label>
				<form:input path="propertyType" htmlEscape="false" maxlength="1" class="form-control required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="sortNum">排序号：</label>
				<form:input path="sortNum" htmlEscape="false" maxlength="4" class="form-control required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-3">
				<label for="isShow">是否显示 Y显示，N显示：</label>
				<form:input path="isShow" htmlEscape="false" maxlength="1" class="form-control required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="goods:attribute:ykGoodsProperty:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>