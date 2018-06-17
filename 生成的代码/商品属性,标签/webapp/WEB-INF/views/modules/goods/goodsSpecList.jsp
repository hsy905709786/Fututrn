<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品规格管理</title>
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
		<li class="active"><a href="${ctx}/goods/goodsSpec/">商品规格列表</a></li>
		<shiro:hasPermission name="goods:goodsSpec:edit"><li><a href="${ctx}/goods/goodsSpec/form">商品规格添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="goodsSpec" action="${ctx}/goods/goodsSpec/" method="post" class="breadcrumb form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	
		<button type="submit" class="btn btn-primary" id="btnSubmit">查询</button>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>0</th>
				<shiro:hasPermission name="goods:goodsSpec:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="goodsSpec">
			<tr>
				<td><a href="${ctx}/goods/goodsSpec/form?id=${goodsSpec.id}">
					<fmt:formatDate value="${goodsSpec.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<shiro:hasPermission name="goods:goodsSpec:edit"><td>
    				<a href="${ctx}/goods/goodsSpec/form?id=${goodsSpec.id}">修改</a>
					<a href="${ctx}/goods/goodsSpec/delete?id=${goodsSpec.id}" onclick="return confirmx('确认要删除该商品规格吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>