<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商品管理软件</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="<%=basePath%>css/windows.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/frameStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/base-loading.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/loadmask/jquery.loadmask.css" />
<script type="text/javascript" src="<%=basePath%>js/loadmask/jquery.loadmask.js"></script>	
<script type="text/javascript">
$(function() {  
	// 重定向时跳出iframe
	if(window != top) {
		top.location.href = location.href;
	}	
	
	
	   $(document).ready(function(){
			$("#username").focus();
	   });
	   
	   document.onkeydown = function(e){    
	    var ev = document.all ? window.event : e;  
	    if(ev.keyCode==13) {
	    	$("#login_btn").click();
	    }  
	  }; 
	
  $("#login_btn").click(function(){ 
	 $("body").mask("页面加载中，请等待...");
      $.post("<%=basePath %>user/checklogin.action",
          {username:  $("#username").val(),
 	 	  userpass:  $("#userpass").val()
          },  
             function(data){       
                 $.each(data,function(key,values) { 
                	$("body").unmask();
                 	if (key == "err")
                 		alert(values);
                 	else if (key == "success")
                 	{    
                         location.href = "<%=basePath %>user/main.action";
                 	}  
               	});  

        });  
  });  
  
}); 
</script>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
	marginheight="0">
	<form name="login" action="login()" method="post">
		<table width="100%" border="0" height="100%" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="599" background="images/old_login/login_01.gif">&nbsp;</td>
				<td width="1024">
					<!-- ImageReady Slices (1_120531001852_1.psd) -->
					<table id="__01" width="1024" height="100%" border="0"
						cellpadding="0" cellspacing="0">
						<tr>
							<td rowspan="11"><img src="images/old_login/1_120531001852_1_01.gif"
								width="272" height="580" alt=""></td>
							<td colspan="6"><img src="images/old_login/login_02.gif" width="495"
								height="60" alt=""></td>
							<td rowspan="11"><img src="images/old_login/login_03.gif" width="257"
								height="580" alt=""></td>
						</tr>
						<tr>
							<td colspan="2"><img src="images/old_login/login_04.gif" width="196"
								height="58" alt=""></td>
							<td colspan="4"><img src="images/old_login/login_05.gif" width="299"
								height="58" alt=""></td>
						</tr>
						<tr>
							<td colspan="6"><img src="images/old_login/login_06.gif" width="495"
								height="46" alt=""></td>
						</tr>
						<tr>
							<td colspan="6"><img src="images/old_login/login_07.gif" width="495"
								height="58" alt=""></td>
						</tr>
						<tr>
							<td><img src="images/old_login/login_08.gif" width="192" height="29"
								alt=""></td>
							<td colspan="4" width="151" height="29"><input id="username" name="username"
								type="text"
								style="width: 150px; height: 26px; border: 0px; border-style: none; line-height: 26px; background-image: url(images/old_login/login_09.gif)" /></td>
							<td><img src="images/old_login/login_10.gif" width="152" height="29"
								alt=""></td>
						</tr>
						<tr>
							<td colspan="6"><img src="images/old_login/login_11.gif" width="495"
								height="22" alt=""></td>
						</tr>
						<tr>
							<td><img src="images/old_login/login_12.gif" width="192" height="29"
								alt=""></td>
							<td colspan="4" background="images/old_login/login_13.gif" width="151"
								height="29"><input id="userpass"  name="password" type="password"
								style="width: 150px; height: 26px; vertical-align: middle; line-height: 26px; border: 0px; border-style: none; background-image: url(images/old_login/login_13.gif)" /></td>
							<td><img src="images/old_login/login_14.gif" width="152" height="29"
								alt=""></td>
						</tr>
						<tr>
							<td colspan="6"><img src="images/old_login/login_15.gif" width="495"
								height="18" alt=""></td>
						</tr>
						<tr>
							<td colspan="3"><img src="images/old_login/1_120531001852_1_17.gif"
								width="280" height="24" alt=""></td>
							<td><input id="login_btn" type="button" style="width: 54px; border: 0px; cursor: pointer; height: 24px; background-image: url(images/old_login/login_17.gif)"/>
							</td>
							<td colspan="2"><img src="images/old_login/1_120531001852_1_18.gif"
								width="161" height="24" alt=""></td>
						</tr>
						<tr>
							<td colspan="6"><img src="images/old_login/login_19.gif" width="495"
								height="107" alt=""></td>
						</tr>
						<tr>
							<td colspan="6"><img src="images/old_login/login_20.gif" width="495"
								height="129" alt=""></td>
						</tr>
						<tr>
							<td colspan="8" style="background-color: #f5f5f5; height: 19px;">&nbsp;
							</td>
						</tr>
						<tr style="background-color: #f5f5f5;">
							<td style="background-color: #f5f5f5;" width="272" height="1">
							</td>
							<td style="background-color: #f5f5f5;" width="192" height="1">
							</td>
							<td style="background-color: #f5f5f5;" width="4" height="1">
							</td>
							<td style="background-color: #f5f5f5;" width="84" height="1">
							</td>
							<td style="background-color: #f5f5f5;" width="54" height="1">
							</td>
							<td style="background-color: #f5f5f5;" width="9" height="1">
							</td>
							<td style="background-color: #f5f5f5;" width="152" height="1">
							</td>
							<td style="background-color: #f5f5f5;" width="257" height="1">
							</td>
						</tr>
					</table> <!-- End ImageReady Slices -->
				</td>
				<td background="images/old_login/login_01.gif">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" style="background-color: #f5f5f5;">&nbsp;</td>
			</tr>
		</table>
	</form>

</body>
</html>
