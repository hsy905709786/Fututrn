<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品模块管理</title>
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
		<li class="active"><a href="${ctx}/goodstype/goodsType/">商品模块列表</a></li>
		<shiro:hasPermission name="goodstype:goodsType:edit"><li><a href="${ctx}/goodstype/goodsType/form">商品模块添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="goodsType" action="${ctx}/goodstype/goodsType/" method="post" class="breadcrumb form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	
		<button type="submit" class="btn btn-primary" id="btnSubmit">查询</button>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>0</th>
				<shiro:hasPermission name="goodstype:goodsType:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="goodsType">
			<tr>
				<td><a href="${ctx}/goodstype/goodsType/form?id=${goodsType.id}">
					<fmt:formatDate value="${goodsType.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<shiro:hasPermission name="goodstype:goodsType:edit"><td>
    				<a href="${ctx}/goodstype/goodsType/form?id=${goodsType.id}">修改</a>
					<a href="${ctx}/goodstype/goodsType/delete?id=${goodsType.id}" onclick="return confirmx('确认要删除该商品模块吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>