<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript">
//===========================点击展开关闭效果====================================
function openShutManager(oSourceObj,oTargetObj,shutAble,oOpenTip,oShutTip){
	var sourceObj = typeof oSourceObj == "string" ? document.getElementById(oSourceObj) : oSourceObj;
	var targetObj = typeof oTargetObj == "string" ? document.getElementById(oTargetObj) : oTargetObj;
	var openTip = oOpenTip || "";
	var shutTip = oShutTip || "";
	if(targetObj.style.display!="none"){
	   if(shutAble) return; 
	   targetObj.style.display="none";
	   if(openTip  &&  shutTip){
	    sourceObj.innerHTML = shutTip; 
	   }
	} else {
		//alert(1);
	   targetObj.style.display="block";
	   if(openTip  &&  shutTip){
	    sourceObj.innerHTML = openTip; 
	   }
	}
}
</script>
</head>
<body style="width: 100%;overflow-x: hidden;">
   <div style="width:100%">
<form id="departmentCheckForm" name="departmentCheckForm" action=""  method="post">
	<div class="content">
		<div style="background-color:#ddd;font-size:1.3em;height:30px;line-height:30px;padding-left:8px"><ul style="margin:0px;padding-left:20px;"><li>查询结果</li></ul></div>
		<c:forEach items="${orderlist}" var="one">
			<div style="background-color:#ddd;font-size:1.3em;height:30px;line-height:30px;padding-left:8px" onclick="openShutManager(this,'${one.orderNum}',false,'订单编号：${one.orderNum}&lt;','订单编号：${one.orderNum}>')">订单编号：${one.orderNum}&lt;</div>
			<div id="${one.orderNum}">
			<div>${one.createTime}您的订单开始处理...</div>
			<c:if test="${one.isSent == 1}">
				<div>${one.sendTime}您的订单物品已寄出...</div>				
			</c:if>
			</div>
		</c:forEach>
     </div>
  </form> 
  </div>
</body>
</html>

