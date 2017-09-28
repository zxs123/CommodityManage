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
<script type="text/javascript"
	src="../jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/base-loading.js"></script>
<script type="text/javascript" src="<%=basePath%>js/datagrid-groupview/datagrid-groupview.js"></script>
<script type="text/javascript">
    jQuery(function($){
	    /**
		 *  保存用户信息方法
		 */
		$('#btn1').click(function(){
				if($('#myform').form('validate')){
					$.ajax({
						type: 'post' ,
						url: flag=='add'?'<%=basePath%>systemManage/saveUser.action':'<%=basePath%>systemManage/updateUser.action' ,
						cache:false ,
						data:$('#myform').serialize() ,
						dataType:'json' ,
						success:function(result){
							//1 关闭窗口
							$('#mydialog').dialog('close');
							//2刷新datagrid 
							$('#userTable').datagrid('reload');
							//3 提示信息
							$.messager.show({
								title:result.status , 
								msg:result.message
							});
						} ,
						error:function(result){
							$.mesager.show({
								title:result.status , 
								msg:result.message
							});
						}
					});
				} else {
					$.messager.show({
						title:'提示信息!' ,
						msg:'数据验证不通过,不能保存!'
					});
				}
		});
		
		/**
		 * 关闭窗口方法
		 */
		$('#btn2').click(function(){
			$('#mydialog').dialog('close');
		});
		
		//datagrid用户列表
		$('#userTable').datagrid({
			title:'用户列表', //标题
			method:'post',
			iconCls:'icon-user', //图标
			singleSelect:false, //多选
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:"<%=basePath%>systemManage/queryUserList.action", //数据来源
			sortName: 'user.userName', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'userId', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'ck',checkbox:true,width:2}, //显示复选框
				{field:'userName',title:'姓名',width:20,sortable:true,
					formatter:function(value,row,index){return row.userName;} //需要formatter一下才能显示正确的数据
				},
				{field:'userSex',title:'性别',width:20,sortable:true,
					formatter:function(value,row,index){return row.userSex;} 
				},
				{field:'userId',title:'登录账号',width:20,sortable:true,
					formatter:function(value,row,index){return row.userId;}
				},
				{field:'depName',title:'所属部门',width:30,sortable:true,
					formatter:function(value,row,index){
						return row.depName;  //该列的值是deptId，显示的是deptName
					}
				},
				{field:'srName',title:'用户角色',width:20,sortable:false,
					formatter:function(value,row,index){return row.srName;}
				},
				{field:'userTel',title:'办公电话',width:30,sortable:true,
					formatter:function(value,row,index){return row.userTel;}
				},
				{field:'userCellphone',title:'手机',width:30,sortable:true,
					formatter:function(value,row,index){return row.userCellphone;}
				},
				{field:'userIdcard',title:'身份证号',width:30,sortable:true,
					formatter:function(value,row,index){return row.userIdcard;}
				},
				{field:'userEmail',title:'电子邮箱',width:30,sortable:true,
					formatter:function(value,row,index){
						return row.userEmail;
					}
				} 
			]],
			sortName: 'userName', //初始排序字段
            sortOrder: 'desc' ,//初始排序方式
			toolbar:[{
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					addrow();
				}
			},'-',{
				text:'更新',
				iconCls:'icon-edit',
				handler:function(){
					updaterow();
				}
			},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){
					deleterow();
				}
			},'-',{
				text:'初始化密码',
				iconCls:'icon-reset',
				handler:function(){
					initializeP();
				}
			},'-'],
			onLoadSuccess:function(){
				$('#userTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
    	
		//下拉表格初始化，这个东西在ajax下要尽量少用，太变态了，每加载一次就会重新创建一次，隐藏在页面上，
		//时间一长效率很低，用firebug一看页面上有几十个同样的层保存着下拉框中的内容，只有整个页面全部刷新才清除。
		//不知道新版本修正了没有，我目前的做法是点击菜单的时候手动清除一下。
		$('#deptCombo').combogrid({
			idField:'depId', //ID字段
		    textField:'depName', //显示的字段
		    url:"<%=basePath%>dept/queryAll.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        /* {field:'depId',title:'编号',width:100}, */
		        {field:'depName',title:'部门名称',width:150},
		        {field:'depId',title:'部门编号',width:150}
		    ]]
		});

	});
    
    //新增
    function addrow(){
    	flag = 'add';
		$('#mydialog').dialog({
				title:'新增用户' 
		});
		//$('#myform').find('input[name!=sex]').val("");
		$('#myform').get(0).reset();
		//$('#myform').form('clear');
		$('#mydialog').dialog('open');
	}
    
  //更新
    function updaterow(){
    	flag = 'edit';
		var arr =$('#userTable').datagrid('getSelections');
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一行记录进行修改!'
			});
		} else {
			$('#mydialog').dialog({
				title:'修改用户'
			});
			$('#mydialog').dialog('open'); //打开窗口
			//$('#myform').get(0).reset();   //清空表单数据 
			$('#myform').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
				userId:arr[0].userId ,
				userName:arr[0].userName ,
				userSex:arr[0].userSex ,
				userDep:arr[0].depId ,
				userPosition:arr[0].srId ,
				userCellphone:arr[0].userCellphone ,
				userTel:arr[0].userTel ,
				userEmail:arr[0].userEmail ,
				userIdcard:arr[0].userIdcard,
			});
		}
	}
  	
  //删除
  	function deleterow(){
		var rows =$('#userTable').datagrid('getSelections');
		if(rows.length == 0){
			$.messager.show({
				title:'提示信息!',
				msg:'至少选择一条记录进行删除!'
			});
		} else {
	  		$.messager.confirm('提示','确定要删除吗?',function(result){
		        if (result){
		        	var ps = "";
		        	$.each(rows,function(i,n){
		        		if(i==0) 
		        			ps += "?userId="+n.userId;
		        		else
		        			ps += "&userId="+n.userId;
		        	});
		        	$.post('<%=basePath%>systemManage/deleteUser.action'+ps,function(data){
			        	$('#userTable').datagrid('reload');
			        	//显示删除成果或者失败的提示信息
			        	$.messager.show({
			        		title:'提示' , 
							msg:data.mes
						});
		        	});
		        }
		    });
		}
  	}
  
  //初始化密码
  	function initializeP(){
  		var rows =$('#userTable').datagrid('getSelections');
		if(rows.length == 0){
			$.messager.show({
				title:'提示信息!',
				msg:'至少选择一条记录进行初始化密码!'
			});
		} else {
			$.messager.confirm('提示','确定要初始化密码吗?',function(result){
		        if (result){
		        	var ps = "";
		        	$.each(rows,function(i,n){
		        		if(i==0) 
		        			ps += "?userId="+n.userId;
		        		else
		        			ps += "&userId="+n.userId;
		        	});
		        	$.post('<%=basePath%>systemManage/initializeP.action'+ps,function(data){
			        	$('#userTable').datagrid('reload'); 
		        		$.messager.alert('提示',data.mes,'info');
		        	});
		        }
	    	});
		}
	}
  
    //表格查询
	function searchUser(){
		var params = $('#userTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#userTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
    
	//清空查询条件
	function clearForm(){
		$('#queryForm').form('clear');
		searchUser();
	}
	
	</script>	
  </head>
  
  <body>
    <form id="queryForm" style="margin:8;text-align: center;">
		<table>
			<tr>
			<td>所属部门：<input id="deptCombo" name="userDep" width="200px"></td>
			<td>名字：<input name="userName" style="width: 200"></td>
			<td>登录账号：<input name="userId" style="width: 200"></td>
			<td>用户状态：<select name="userRname" style="width: 200">
					<option value="kongbai"></option>
   					 <option value=1>已启用</option>
   					 <option value=0>未启用</option>
					</select>
			</td>
			<td align="center"><a href="#" onclick="searchUser();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			<td align="center"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td>
			</tr>
		</table>
	</form>
	<div style="padding:10" id="tabdiv">
		<table id="userTable"></table>
	</div>
	<div id="mydialog" modal=true class="easyui-dialog" title="添加用户" data-options="iconCls:'icon-save',closed:'true'" style="width:260px;height:320px;">
		<form id="myform" action="" method="post">
			<input type="hidden" name="id" value="" />
			<table>
				<tr>
					<td align="right">登录帐号：</td>
					<td><input type="text" name="userId"
						class="easyui-validatebox" required=ture validTyp="midLength(2,5)"
						missingMessage="登录用户"></input></td>
				</tr>
				<tr>
					<td align="right">姓名：</td>
					<td><input type="text" name="userName"
						class="easyui-validatebox" required=ture validTyp="midLength(2,5)"
						missingMessage="姓名"></input></td>
				</tr>
				<tr>
				
					<td align="right">性别：</td>
					<td>
						男<input class="radio1" type="radio" checked="checked" name="userSex" value="男" />
						女<input class="radio2" type="radio" name="userSex" value="女" />
					</td>
				</tr>
				<tr>
					<td align="right">所属部门：</td>
					<td><input name="userDep" class="easyui-combobox"
						data-options="valueField:'depId',textField:'depName',url:'<%=basePath%>dept/getDepName.action'"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">用户角色：</td>
					<td><input name="userPosition" class="easyui-combobox"
						data-options="valueField:'srId',textField:'srName',url:'<%=basePath%>SystemRole/getRoleName.action'"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">办公电话：</td>
					<td><input id="userCellphone" type="text" name="userCellphone"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">手机：</td>
					<td><input id="userTel" type="text" name="userTel" value="" /></td>
				</tr>
				<tr>
					<td align="right">邮箱：</td>
					<td><input id="userEmail" type="text" name="userEmail" value="" /></td>
				</tr>
				<tr>
					<td align="right">身份证号：</td>
					<td><input id="userIdcard" type="text" name="userIdcard" value="" /></td>
				</tr>
				<tr align="center">
					<td colspan="2"><a id="btn1" class="easyui-linkbutton">确定</a>
						<a id="btn2" class="easyui-linkbutton">关闭</a></td>
				</tr>
			</table>
		</form>
	</div>
  </body>
  

</html>
