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
		<li class="active"><a href="${ctx}/account/accountBalance/">支付配置列表</a></li>
		<shiro:hasPermission name="account:accountBalance:edit"><li><a href="${ctx}/account/accountBalance/form">支付配置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="accountBalance" action="${ctx}/account/accountBalance/" method="post" class="breadcrumb form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	
			<div class="form-group">
			<label for="accountId">0：</label>
				<form:input placeholder="0" path="accountId" htmlEscape="false" maxlength="64" class="form-control"/>
		</div>
			<div class="form-group">
			<label for="balanceType">0：</label>
				<form:input placeholder="0" path="balanceType" htmlEscape="false" maxlength="20" class="form-control"/>
		</div>
			<div class="form-group">
			<label for="userType">0：</label>
				<form:input placeholder="0" path="userType" htmlEscape="false" maxlength="10" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-primary" id="btnSubmit">查询</button>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>0</th>
				<shiro:hasPermission name="account:accountBalance:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="accountBalance">
			<tr>
				<td><a href="${ctx}/account/accountBalance/form?id=${accountBalance.id}">
					<fmt:formatDate value="${accountBalance.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<shiro:hasPermission name="account:accountBalance:edit"><td>
    				<a href="${ctx}/account/accountBalance/form?id=${accountBalance.id}">修改</a>
					<a href="${ctx}/account/accountBalance/delete?id=${accountBalance.id}" onclick="return confirmx('确认要删除该支付配置吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>