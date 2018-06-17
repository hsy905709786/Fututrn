<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品属性增删改查管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/goods/attribute/ykGoodsProperty/">商品属性增删改查列表</a></li>
		<shiro:hasPermission name="goods:attribute:ykGoodsProperty:edit"><li><a href="${ctx}/goods/attribute/ykGoodsProperty/form">商品属性增删改查添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ykGoodsProperty" action="${ctx}/goods/attribute/ykGoodsProperty/" method="post" class="breadcrumb form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	
			<div class="form-group">
			<label for="id">属性ID：</label>
				<form:input placeholder="属性ID" path="id" htmlEscape="false" maxlength="64" class="form-control"/>
		</div>
			<div class="form-group">
			<label for="isShow">是否显示 Y显示，N显示：</label>
				<form:input placeholder="是否显示 Y显示，N显示" path="isShow" htmlEscape="false" maxlength="1" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-primary" id="btnSubmit">查询</button>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="goods:attribute:ykGoodsProperty:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ykGoodsProperty">
			<tr>
				<shiro:hasPermission name="goods:attribute:ykGoodsProperty:edit"><td>
    				<a href="${ctx}/goods/attribute/ykGoodsProperty/form?id=${ykGoodsProperty.id}">修改</a>
					<a href="${ctx}/goods/attribute/ykGoodsProperty/delete?id=${ykGoodsProperty.id}" onclick="return confirmx('确认要删除该商品属性增删改查吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>