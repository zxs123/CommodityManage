<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="<%=basePath %>css/common/error.css" />
    
    <title>系统错误页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   		
<div class="col01 clearfix">
	<div class="tips404">
		<h1>抱歉，您访问的页面被外星人劫持了<br>
			<span>Sorry,We cannot find the page you requested.</span></h1>
		<ul>
			<li>输入的地址不正确</li>
			<li>页面已被删除</li>
			<li>数据输入错误</li>
			<li>系统未知BUG</li>
		</ul>
		<h4>
		    欢迎您记录下本次出错的操作界面以及所做操作，然后将问题反馈给信息科技部，我们将在最短时间内解决问题，谢谢您的支持与合作！
			
		</h4>

		<h3 class="cGray">
			<span><a href="javascript:history.go(-1);" id="btnBack" title="返回">返回</a></span> |
			<a href="<%=basePath %>/manage/main" title="系统首页">系统首页</a> |
		</h3>
	</div>
</div>
  </body>
</html>
