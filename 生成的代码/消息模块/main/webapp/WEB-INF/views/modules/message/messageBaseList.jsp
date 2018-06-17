<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>消息管理</title>
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
		<li class="active"><a href="${ctx}/message/messageBase/">消息列表</a></li>
		<shiro:hasPermission name="message:messageBase:edit"><li><a href="${ctx}/message/messageBase/form">消息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="messageBase" action="${ctx}/message/messageBase/" method="post" class="breadcrumb form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	
			<div class="form-group">
			<label for="title">0：</label>
				<form:input placeholder="0" path="title" htmlEscape="false" maxlength="100" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-primary" id="btnSubmit">查询</button>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>0</th>
				<th>0</th>
				<shiro:hasPermission name="message:messageBase:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="messageBase">
			<tr>
				<td><a href="${ctx}/message/messageBase/form?id=${messageBase.id}">
					${messageBase.title}
				</a></td>
				<td>
					<fmt:formatDate value="${messageBase.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="message:messageBase:edit"><td>
    				<a href="${ctx}/message/messageBase/form?id=${messageBase.id}">修改</a>
					<a href="${ctx}/message/messageBase/delete?id=${messageBase.id}" onclick="return confirmx('确认要删除该消息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>