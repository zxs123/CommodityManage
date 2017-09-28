<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>月报预览</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/common/table.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery-easyui-1.4.4/themes/default/easyui.css"></link>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery-easyui-1.4.4/themes/icon.css"></link>
<script type="text/javascript"
	src="<%=basePath%>jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/datagrid-groupview/datagrid-groupview.js"></script>
<script type="text/javascript" src="<%=basePath%>js/json2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/swfobject.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/open_flash_chart.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ofc.js"></script>

<style>
#exportWordBtn{
	width:120px;
	cursor: pointer;
	border:1px solid #0099FF;
}
</style>
<script type="text/javascript">
$(function(){
	//将编辑好的月报提交到部门负责人审核
	$('#exportWordBtn').click(function(){
		$.ajax({   
			url:'<%=basePath%>reportFlow/exportWord.action',
			type:'post',
			sync : false, //默认为true 异步   
			error:function(){   
				alert('导出错误');   
			},   
			success:function(data){ 
				alert("导出成功");
			}
		});
	});
	
});
</script>
</head>
<body>
<div id="exportWordBtn"><img  width="32" height="32" src="images/Word.png"/><span>导出统计图</span></div>	
</body>
</html>