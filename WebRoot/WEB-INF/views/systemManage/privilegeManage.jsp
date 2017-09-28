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
<script type="text/javascript">
    jQuery(function($){
    	
    	var flag="" ;		//undefined 判断新增和修改方法
    	
    	/**
		 *  保存用户信息方法
		 */
		$('#btn1').click(function(){
			var nodes = $('#tt').tree('getChecked');
			var s = '';
			for(var i=0; i<nodes.length; i++){
				if (s != '') s += ',';
				s += nodes[i].text;
			}
			s = encodeURI(s);
			if($('#myform').form('validate') && nodes.length>0){
				$.ajax({
					type: 'post' ,
					url: flag=='add'?'<%=basePath%>systemManage/saveRole.action?role='+s:'<%=basePath%>systemManage/updateRole.action?role='+s ,
					cache:false ,
					data:$('#myform').serialize() ,
					dataType:'json' ,
					success:function(result){
						//1 关闭窗口
						$('#roleManage').dialog('close');
						//2刷新datagrid 
						$('#roleTable').datagrid('reload');
						//3 提示信息
						$.messager.show({
							title:result.status , 
							msg:result.message
						});
					} ,
					error:function(result){
						$.meesager.show({
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
			$('#roleManage').dialog('close');
		});
    	
		$('#roleTable').datagrid({
			title:'角色列表', //标题
			method:'post',
			iconCls:'icon-user', //图标
			singleSelect:false, //多选
			//height:360, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:"<%=basePath%>systemManage/roleList.action", //数据来源
			sortName: 'srId', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'srId', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'ck',checkbox:true,width:2}, //显示复选框
				{field:'srId',title:'角色编号',width:20,sortable:true,
					formatter:function(value,row,index){return row.srId;} //需要formatter一下才能显示正确的数据
				},
				{field:'srName',title:'角色名称',width:20,sortable:true,
					formatter:function(value,row,index){return row.srName;}
				}
			]],
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
			},'-'],
			onLoadSuccess:function(){
				$('#roleTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});

	  //新增
	    function addrow(){
	    	flag = 'add';
			$('#roleManage').dialog({
					title:'新增角色' 
			});
			//$('#myform').find('input[name!=sex]').val("");
			$('#myform').get(0).reset();
			//$('#myform').form('clear');
			$('#roleManage').dialog('open');
		}
	    
	  //更新
	    function updaterow(){
	    	flag = 'edit';
			var arr =$('#roleTable').datagrid('getSelections');
			if(arr.length != 1){
				$.messager.show({
					title:'提示信息!',
					msg:'只能选择一行记录进行修改!'
				});
			} else {
				$('#roleManage').dialog({
					title:'修改角色'
				});
				$('#roleManage').dialog('open'); //打开窗口
				$('#myform').get(0).reset();   //清空表单数据 
				$('#myform').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
					srId:arr[0].srId ,
					srName:arr[0].srName ,
					srReid:arr[0].srReid,
				});
			}
		}
	  	
	  //删除
	  	function deleterow(){
			var rows =$('#roleTable').datagrid('getSelections');
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
			        			ps += "?srId="+n.srId;
			        		else
			        			ps += "&srId="+n.srId;
			        	});
			        	$.post('<%=basePath%>systemManage/deleteRole.action' + ps,
								function(data) {
									$('#roleTable').datagrid('reload');
									$.messager.alert('提示', data.mes, 'info');
								});
					}
				});
			}
		}
	});

	function getUrl(){
		//alert(flag+"cc");
		var url = '<%=basePath%>systemManage/getJson.action?';
		return url;
	};
</script>

</head>
  
  <body>
	<div style="padding:10" id="tabdiv">
		<table id="roleTable"></table>
	</div>
	<div id="roleManage" modal=true class="easyui-dialog" title="添加用户" data-options="iconCls:'icon-save',closed:'true'" style="width:260px;height:320px;">
		<form id="myform" action="" method="post">
			<input type="text" name="srId" value="" style="display:none;"/>
			<table>
				<tr>
					<td align="right">角色名称：</td>
					<td><input id="srName" type="text" name="srName"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">角色分类：</td>
					<td><select name="srReid" id="srReid">
						<option value =""></option>
  						<option value ="0">员工</option>
  						<option value="1">领导</option>
					</select>
				</tr>
				<tr>
					<td colspan="2"><div class="easyui-panel" style="padding: 5px">
							<ul id="tt" class="easyui-tree"
								data-options="url:getUrl(),method:'post',animate:true,checkbox:true"></ul>
						</div></td>
				</tr>
				<tr align="center">
					<td colspan="2"><a id="btn1" class="easyui-linkbutton">确定</a>
						<a id="btn2" class="easyui-linkbutton">关闭</a></td>
				</tr>
			</table>
		</form>
	</div>
	</body>
   <script type="text/javascript">
		function getChecked(){
			var nodes = $('#tt').tree('getChecked');
			var s = '';
			for(var i=0; i<nodes.length; i++){
				if (s != '') s += ',';
				s += nodes[i].text;
			}
		};
	</script>
</html>

