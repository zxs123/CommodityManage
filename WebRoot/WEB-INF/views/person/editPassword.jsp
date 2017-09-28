<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<title>修改密码</title>
    <script language="javascript" src="<%= basePath %>js/common/jquery.js"></script>
    <script language="javascript" src="<%=basePath %>js/base-loading.js"></script>
    <script language="javascript" src="<%= basePath %>js/common/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="<%= basePath %>js/common/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="<%= basePath %>js/common/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="<%= basePath %>js/common/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="<%= basePath %>css/common/pageCommon.css" />
<script type="text/javascript">
$(document).ready(function(){
			var result = '${result}';
			if("success" == result) {
				alert("修改成功");
				location.href = "<%=basePath%>manage/userList";
			} else if("error" == result) {
				alert("修改失败");
			}
			});
			
	function checkData() {
		var oldPassword = $.trim($("#oldPassword").val());	
		var userId='${user.id}';
		var Flag = false;
		if(null == oldPassword || "" == oldPassword) {
			alert("请填写原密码");
			return false;
		}
		$.ajax({
		url : "<%=basePath %>manage/checkPassword",
		type : 'post',
		async : false,
		data : {
			oldPassword : oldPassword,
			userId    : userId
		},
		dataType : 'json',
		success : function(data) {
			if("OK" == data.result) {
				Flag = true;
			}
		}
	});
	if (!Flag) {
		alert("对不起！原密码输入错误！请重新输入!");
		 $("#oldPassword").focus();
		return false;
	}
	var password = $.trim($("#password").val());
	var password2 = $.trim($("#password2").val());
	if(password.length == 0 || password2.length == 0) {
			alert("新密码不能为空！");
			return false;
		}
	if(password != password2){
		alert("两次新密码输入不一致！请重新输入！");
			return false;
	}
	
	}
</script>
</head>
<body style="overflow-x: hidden;">

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="<%= basePath %>images/common/title_arrow.gif"/> 修改密码
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="<%=basePath%>manage/editPassword" method="post" onsubmit="return checkData() ">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
            <IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="<%= basePath %>images/common/item_point.gif" /> 修改密码 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr height="50">
                        <td width="150">
                            <img border="0" width="4" height="7" src="<%= basePath %>images/common/item_point.gif" />
                            请输入原密码
                        </td>
                        <td><input type="password" id="oldPassword" name="oldPassword" class="InputStyle" /> *</td>
                    </tr>
                    <tr height="25">
                        <td width="150">
                            <img border="0" width="4" height="7" src="<%= basePath %>images/common/item_point.gif" />
                            请填写新密码
                        </td>
                        <td><input type="password" id="password" name="password" class="InputStyle" /> *</td>
                        <td></td>
                    </tr>
                    <tr height="25">
                        <td width="150">
                            <img border="0" width="4" height="7" src="<%= basePath %>images/common/item_point.gif" />
                            再次输入新密码
                        </td>
                        <td><input type="password" id="password2" name="password2" class="InputStyle" /></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
       
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="<%= basePath %>images/common/save.png"/>
            <a href="javascript:history.go(-1);"><img src="<%= basePath %>images/common/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
    验证规则：<br />
    1，旧密码不能为空。<br />
    2，新密码不能为空。<br />
    3，再次输入的密码要和新密码一致。<br />
</div>

</body>
</html>
