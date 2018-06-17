<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>info管理</title>
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
		<li class="active"><a href="${ctx}/configuration/cfgAppInfo/">info列表</a></li>
		<shiro:hasPermission name="configuration:cfgAppInfo:edit"><li><a href="${ctx}/configuration/cfgAppInfo/form">info添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="cfgAppInfo" action="${ctx}/configuration/cfgAppInfo/" method="post" class="breadcrumb form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	
			<div class="form-group">
			<label for="title">0：</label>
				<form:input placeholder="0" path="title" htmlEscape="false" maxlength="50" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-primary" id="btnSubmit">查询</button>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>0</th>
				<shiro:hasPermission name="configuration:cfgAppInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cfgAppInfo">
			<tr>
				<td><a href="${ctx}/configuration/cfgAppInfo/form?id=${cfgAppInfo.id}">
					${cfgAppInfo.title}
				</a></td>
				<shiro:hasPermission name="configuration:cfgAppInfo:edit"><td>
    				<a href="${ctx}/configuration/cfgAppInfo/form?id=${cfgAppInfo.id}">修改</a>
					<a href="${ctx}/configuration/cfgAppInfo/delete?id=${cfgAppInfo.id}" onclick="return confirmx('确认要删除该info吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>