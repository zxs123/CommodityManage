<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>密码管理</title>
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.4.4/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.4.4/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="../css/webstyle.css" />
<script type="text/javascript"
	src="../jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/base-loading.js"></script>
<style>
	.save{width:58px; border:0px; cursor:pointer; height:26px;background-image:url(/DataManage/images/frame/savebutton.png);}
</style>


<script type="text/javascript">
jQuery(function($){
	//保存修改的方法
	$("#btn1").click(function(){
	      $.post("<%=basePath %>personalManage/checklogin.action",
	          {oldPassword:  $("#oldPassword").val(),
	    	  newPassword:  $("#newPassword").val(),
	    	  renewPassword:$("#renewPassword").val()	    	  
	          },
	             function(data){
	                 $.each(data,function(key,values) {
	                	//$("body").unmask();
	                 	if (key == "err")
	                 		alert(values);
	                 	else if (key == "success")
	                 	{
	                         <%-- //*location.href = "<%=basePath %>user/main.action";*/ --%>
	                 		$.messager.confirm('提示','确定要修改密码吗?',function(result){
	                			if(result){
	                				if($('#personInfoForm').form('validate')){
	                					$.ajax({
	                						type: 'post' ,
	                						url: '<%=basePath%>personalManage/modifyPassword.action',
	                						cache:false ,
	                						data:$('#personInfoForm').serialize() ,
	                						dataType:'json' ,
	                						success:function(result){
	                							$.messager.show({
	                								title:result.status , 
	                								msg:result.message
	                							}); 
	                							console.log("成功!");
	                						} ,
	                						error:function(result){
	                							$.meesager.show({
	                								title:result.status , 
	                								msg:result.message
	                							});
	                							console.log("失败!");
	                						}
	                					});
	                				} else {
	                					$.messager.show({
	                						title:'提示信息!' ,
	                						msg:'数据验证不通过,不能保存!'
	                					});
	                				}
	                			}
	                		});
	                 	}
	               	});
	
	        });
	  });

	/**
	 *  保存修改方法
	 */
	<%-- $('#btn1').click(function(){
		$.messager.confirm('提示','确定要修改密码吗?',function(result){
			if(result){
				if($('#personInfoForm').form('validate')){
					$.ajax({
						type: 'post' ,
						url: '<%=basePath%>personalManage/modifyPassword.action',
						cache:false ,
						data:$('#personInfoForm').serialize() ,
						dataType:'json' ,
						success:function(result){
							$.messager.show({
								title:result.status , 
								msg:result.message
							}); 
							console.log("成功!");
						} ,
						error:function(result){
							$.meesager.show({
								title:result.status , 
								msg:result.message
							});
							console.log("失败!");
						}
					});
				} else {
					$.messager.show({
						title:'提示信息!' ,
						msg:'数据验证不通过,不能保存!'
					});
				}
			}
		});
	}); --%>
		
});
		
</script>
</head>
  
 <body class="ContentBody">
<form action="" method="post"  name="personInfoForm" id="personInfoForm">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr >
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0">	
		<tr>
			<td width="100%">			
				<fieldset>
				<legend>密码修改</legend>
					
					   <table class="contentInfo" border="0" cellpadding="2" cellspacing="1" style="width:100%" >					 
									 
					 <tr >
					    <td width="35%" nowrap align="right">原密码：</td>
					   <td width="65%">
					   <input id="oldPassword" name="oldPassword" type="text" class="text" style="width:154px" value=""/>
						</td>
					  </tr>
					  <tr>
					    <td width="35%" nowrap align="right">新密码：</td>
					   <td width="65%">
					       <input id="newPassword" name="newPassword" type="text" class="text" style="width:154px" value="""/>
						</td>
					  </tr>
					  <tr>
					    <td width="35%" nowrap align="right">确认新密码：</td>
					   <td width="65%">
					       <input id="renewPassword" name="renewPassword" type="text" class="text" style="width:154px" value=""/>
						</td>
					  </tr>
					  </table>
				</fieldset>	
				</td>
		</tr>
		</table>
	 </td>
  </tr>
		<tr >
			<td align="center" height="50px">
				<input id="btn1" value="" class="save"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
</table>
</div>
</form>
</body>
</html>