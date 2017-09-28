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
<title>用户管理</title>
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
	/**
	 *  保存修改方法
	 */
	$('#btn1').click(function(){
		$.messager.confirm('提示','确定要更新个人信息吗?',function(result){
			if(result){
				if($('#personInfoForm').form('validate')){
					$.ajax({
						type: 'post' ,
						url: '<%=basePath%>personalManage/updateInfo.action',
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
	});
		
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
				<legend>个人信息修改</legend>
					
					   <table class="contentInfo" border="0" cellpadding="2" cellspacing="1" style="width:100%" >					 
									 
					 <tr >
					    <td width="35%" nowrap align="right">员工编号：</td>
					   <td width="65%">
					       <input name="userId" type="text" class="text" style="width:154px" value="${userInfo.userId}" onfocus="this.blur()"/>
						</td>
					  </tr>
					  <tr>
					    <td width="35%" nowrap align="right">姓名：</td>
					   <td width="65%">
					       <input name="userName" type="text" class="text" style="width:154px" value="${userInfo.userName}" onfocus="this.blur()"/>
						</td>
					  </tr>
					  <tr>
					    <td width="35%" nowrap align="right">性别：</td>
					   <td width="65%">
					       <input name="userSex" type="text" class="text" style="width:154px" value="${userInfo.userSex}" onfocus="this.blur()"/>
						</td>
					  </tr>
					   <tr>
					    <td width="35%" nowrap align="right">所属部门：</td>
					    <td width="65%">
					       <input name="depName" type="text" class="text" style="width:154px" value="${userInfo.depName}"  onfocus="this.blur()"/>
						</td>
						<%-- <td align="right">所属部门：</td>
						<td><input name="userDep" class="easyui-combobox" disabled="disabled" 
							data-options="valueField:'depId',textField:'depName',url:'<%=basePath%>dept/getDepName.action'"
							value="${userInfo.userDep}" />
						</td> --%>
					  </tr>
					  <tr>
					    <td width="35%" nowrap align="right">用户角色：</td>
					   <td width="65%">
					   <input name="userPosition" type="text" class="text" style="width:154px" value="${userInfo.roleName}" onfocus="this.blur()"/>
						</td>
						<%-- <td align="right">用户角色：</td>
							<td><input name="userPosition" class="easyui-combobox" disabled="disabled" 
							data-options="valueField:'srId',textField:'srName',url:'<%=basePath%>SystemRole/getRoleName.action'"
							value="${userInfo.userPosition}" /></td> --%>
					  </tr>
					  <tr>
					    <td width="35%" nowrap align="right">身份证号：</td>
					   <td width="65%">
					       <input name="userIdcard" type="text" class="text" style="width:154px" value="${userInfo.userIdcard}"/>
						</td>
					  </tr>
					  <tr>
					    <td width="35%" nowrap align="right">联系电话：</td>
					    <td width="65%">
					       <input name="userTel" type="text" class="text" style="width:154px" value="${userInfo.userTel}"/>
						</td>
					  </tr>
					  <tr>
					    <td width="35%" nowrap align="right">E-mail：</td>
					    <td width="65%">
					       <input name="userEmail" type="text" class="text" style="width:154px" value="${userInfo.userEmail}"/>
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