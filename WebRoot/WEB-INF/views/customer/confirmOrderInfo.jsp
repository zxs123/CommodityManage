<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <base href="<%=basePath%>">   
    <title>订单信息确认</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
</head>
 <body>
<div style="width:100%;">

<form id="myForm" name="myForm" method="post" action="orderManage/comfirmOrderInfo.action" enctype="multipart/form-data">
    <div class="content">
		<div style="background-color:#ddd;font-size:1.3em;height:30px;line-height:30px;padding-left:8px"><ul style="margin:0px;padding-left:20px;"><li>个人信息</li></ul></div>
	    	<input  type="hidden" name="telephone" value="${OrderInfo.telephone1}"/>
	    	<div style="padding-left: 40px">
				<div>姓&nbsp;&nbsp;&nbsp;&nbsp;名：${OrderInfo.customerName}</div>
				<div>手机号：${OrderInfo.telephone1}</div>
				<div>地&nbsp;&nbsp;&nbsp;&nbsp;址：${OrderInfo.address}</div>
				<div>订单类型：${OrderInfo.orderType}</div>
			</div>
		<div style="background-color:#ddd;font-size:1.3em;height:30px;line-height:30px;padding-left:8px"><ul style="margin:0px;padding-left:20px;"><li>订单信息</li></ul></div>
		<c:forEach items="${orderDetailList}" var="one">
			<div  style="padding-left:20px;padding-top: 10px">
				<div style="background-color:#eee;font-size:1.1em;height:20px;line-height:20px;" onclick="openShutManager(this,'${one.commoditymarque}',false,'商品编号：${one.commoditymarque}&lt;','商品编号：${one.commoditymarque}>')">商品编号：${one.commoditymarque}&lt;</div>
				<div id="${one.orderNum}" style="padding-left: 20px;padding-top: 5px;">
					<div>商品名称：${one.commodityname}</div>
					<div>商品规格：${one.commodityscale}</div>
					<div>购买数量：${one.commodityNum}</div>
				</div>
			</div>
		</c:forEach>
		<div style="text-indent:2em;padding-left:20px;padding-top: 10px;padding-right: 20px;font-size:0.9em;color:#F00">请您确认您的个人信息和订单信息是否正确，如无误，请点击“订单确认无误”按钮；如果有误，请联系微信客服进行修改。本页内容只会出现一次请您认真检查</div>
		<div align="center"  style="padding-top: 30px;">
			<input style="font-size: 1.1em" class="button blue" type="submit" name="submit1" id="submit1" value="确认订单无误" onclick="autoSubmit(1);" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input style="font-size: 1.1em" class="button blue" type="submit" name="submit1" id="submit1" value="有误，已反馈" onclick="autoSubmit(2);" />
		</div>
	</div>
</form>
</div>
<script type="text/javascript">
//查询
function autoSubmit(type){
	document.getElementById('myForm').action = "orderManage/comfirmOrderInfo.action?type="+type;  
    document.getElementById("myForm").submit();  
}

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
</body>
</html>