<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员业务管理</title>
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
		<li class="active"><a href="${ctx}/member/ykMember/">会员业务列表</a></li>
		<shiro:hasPermission name="member:ykMember:edit"><li><a href="${ctx}/member/ykMember/form">会员业务添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ykMember" action="${ctx}/member/ykMember/" method="post" class="breadcrumb form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	
			<div class="form-group">
			<label for="loginName">登录名：</label>
				<form:input placeholder="登录名" path="loginName" htmlEscape="false" maxlength="50" class="form-control"/>
		</div>
			<div class="form-group">
			<label for="phone">手机号：</label>
				<form:input placeholder="手机号" path="phone" htmlEscape="false" maxlength="15" class="form-control"/>
		</div>
			<div class="form-group">
			<label for="provinceId">省id：</label>
				<form:input placeholder="省id" path="provinceId" htmlEscape="false" maxlength="20" class="form-control"/>
		</div>
			<div class="form-group">
			<label for="cityId">市id：</label>
				<form:input placeholder="市id" path="cityId" htmlEscape="false" maxlength="20" class="form-control"/>
		</div>
			<div class="form-group">
			<label for="area.id">区id：</label>
				<sys:treeselect id="area" name="area.id" value="${ykMember.area.id}" labelName="area.name" labelValue="${ykMember.area.name}"
					title="区域" url="/sys/area/treeData" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
		</div>
			<div class="form-group">
			<label for="roleType">类型，member会员，store门店：</label>
				<form:input placeholder="类型，member会员，store门店" path="roleType" htmlEscape="false" maxlength="10" class="form-control"/>
		</div>
		<button type="submit" class="btn btn-primary" id="btnSubmit">查询</button>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="member:ykMember:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ykMember">
			<tr>
				<shiro:hasPermission name="member:ykMember:edit"><td>
    				<a href="${ctx}/member/ykMember/form?id=${ykMember.id}">修改</a>
					<a href="${ctx}/member/ykMember/delete?id=${ykMember.id}" onclick="return confirmx('确认要删除该会员业务吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>