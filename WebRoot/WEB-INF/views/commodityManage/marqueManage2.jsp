<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../jquery-ui-1.12.1/jquery-ui.min.css" />
<script type="text/javascript"
	src="../jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="../jquery-ui-1.12.1/jquery-ui.min.js"></script>
<title>成功提示</title>
<script>
	$(function() {
		$("#tags").autocomplete({
			source : '<%=basePath%>commodityManage/queryCommodity.action'
		});
	});
</script>
</head>
<body>
	<div class="ui-widget">
		<label for="tags">标签：</label> <input id="tags">
	</div>
</body>
</html>