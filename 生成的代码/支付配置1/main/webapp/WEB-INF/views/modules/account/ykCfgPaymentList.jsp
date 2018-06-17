<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>支付配置管理</title>
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
		<li class="active"><a href="${ctx}/account/ykCfgPayment/">支付配置列表</a></li>
		<shiro:hasPermission name="account:ykCfgPayment:edit"><li><a href="${ctx}/account/ykCfgPayment/form">支付配置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ykCfgPayment" action="${ctx}/account/ykCfgPayment/" method="post" class="breadcrumb form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	
		<button type="submit" class="btn btn-primary" id="btnSubmit">查询</button>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="account:ykCfgPayment:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ykCfgPayment">
			<tr>
				<shiro:hasPermission name="account:ykCfgPayment:edit"><td>
    				<a href="${ctx}/account/ykCfgPayment/form?id=${ykCfgPayment.id}">修改</a>
					<a href="${ctx}/account/ykCfgPayment/delete?id=${ykCfgPayment.id}" onclick="return confirmx('确认要删除该支付配置吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>