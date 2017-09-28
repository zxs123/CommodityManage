<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no" />
<title>客户查询</title>
<link href="../css/index.css" type="text/css" rel="stylesheet"/>
<link href="../css/button.css" type="text/css" rel="stylesheet"/>
<link href="../css/autoHeight.css" type="text/css" rel="stylesheet" />
</head>
<body style="width: 100%;overflow-x: hidden;">
   <div style="width:100%">
<form id="departmentCheckForm" name="departmentCheckForm" action=""  method="post">
	<div class="content">
	<div style="background-color:#ddd;font-size:1.3em;height:30px;line-height:30px;padding-left:8px"><ul style="margin:0px;padding-left:20px;"><li>查询结果</li></ul></div>
		未查询到该号码关联的订单，请稍后再试。
	</div>
  </form> 
  </div>
</body>
</html>

