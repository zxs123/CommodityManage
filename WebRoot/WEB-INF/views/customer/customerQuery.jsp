<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <base href="<%=basePath%>">   
    <title>客户订单查询</title>
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

<form id="FlowConfirm" name="FlowConfirm" method="post" action="orderManage/queryResult.action" enctype="multipart/form-data">
    	<div class="content">
		<div style="background-color:#ddd;font-size:1.3em;height:30px;line-height:30px;padding-left:8px"><ul style="margin:0px;padding-left:20px;"><li>订单查询</li></ul></div>
    	<table style="width:100%;padding-top:30px;" class="table-block">
			<tr><td class="left pad">手机号：</td>
				<td  class="pad" colspan="2"><input name="telephone" class="telephone" style="margin-left:5%;width:78%;height:30px;border:1px solid #1D80CF; border-radius:5px;" name="flowtodep" type="text" value=""/></td>
			</tr>
		   <tr>
  				<td height="40px" class="pad" colspan="3" align="center"><input class="button blue" type="submit" name="submit1" id="submit1" value="查询" onclick="checkSubmit();" /></td>
  		   </tr>
</table>
</div>
</form>
</div>
<script type="text/javascript">
//查询
function  checkSubmit(){
  document.FlowConfirm.submit1.disabled=true; 
  document.FlowConfirm.submit();   
}

</script>
</body>
</html>