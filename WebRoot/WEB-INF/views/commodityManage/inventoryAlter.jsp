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
<title>商品库存变更</title>
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.4.4/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.4.4/themes/icon.css" />
<script type="text/javascript"
	src="../jquery-easyui-1.4.4/jquery.min.js"></script>
	<script type="text/javascript"
	src="../jquery-easyui-1.4.4/jquery.form.js"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/base-loading.js"></script>
<script type="text/javascript" src="<%=basePath%>js/datagrid-groupview/datagrid-groupview.js"></script>
<script type="text/javascript">
    jQuery(function($){
	    /**
		 *  保存商品库存变更信息
		 */
		$('#btn1').click(function(){
			if($('#myform').form('validate')){
				$.ajax({
					type: 'post' ,
					enctype: 'multipart/form-data',
					url: '<%=basePath%>commodityManage/saveAlter.action' ,
					cache:false ,
					data:$('#myform').serialize() ,
					dataType:'json' ,
					success:function(result){
						//1 关闭窗口
						$('#mydialog').dialog('close');
						//2刷新datagrid 
						$('#alterTable').datagrid('reload');
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
		
	/**
	 * 关闭窗口方法
	 */
	$('#btn4').click(function(){
		$('#mydialog2').dialog('close');
	});
	
	//datagrid库存更改列表
	$('#alterTable').datagrid({
		title:'库存变更信息列表', //标题
		method:'post',
		iconCls:'icon-user', //图标
		singleSelect:false, //多选
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped: true, //奇偶行颜色不同
		collapsible:true,//可折叠
		url:"<%=basePath%>commodityManage/alterList.action", //数据来源
		sortName: 'alterManage.commoditymarque', //排序的列
		sortOrder: 'desc', //倒序
		remoteSort: true, //服务器端排序
		idField:'alterid', //主键字段
		queryParams:{}, //查询条件
		pagination:true, //显示分页
		rownumbers:true, //显示行号
		columns:[[
			{field:'ck',checkbox:true,width:2}, //显示复选框
			{field:'alterid',title:'变更ID',width:20,sortable:true,hidden:true,
				formatter:function(value,row,index){return row.alterid;} //需要formatter一下才能显示正确的数据
			},
			{field:'commoditymarque',title:'商品型号',width:20,sortable:true,
				formatter:function(value,row,index){return row.commoditymarque;} //需要formatter一下才能显示正确的数据
			},
			{field:'commodityname',title:'商品名称',width:20,sortable:true,
				formatter:function(value,row,index){return row.commodityname;} //需要formatter一下才能显示正确的数据
			},
			{field:'altertime',title:'变更时间',width:20,sortable:true,
				formatter:function(value,row,index){return row.altertime;} 
			},
			{field:'altertype',title:'变更类型',width:20,sortable:true,
				formatter:function(value,row,index){return row.altertype;}
			},
			{field:'alternum',title:'变更数量',width:20,sortable:false,
				formatter:function(value,row,index){return row.alternum;}
			},
			{field:'alterinventory',title:'变更后库存量',width:20,sortable:false,
				formatter:function(value,row,index){return row.alterinventory;}
			},
			{field:'commodityunit',title:'单位',width:20,sortable:false,
				formatter:function(value,row,index){return row.commodityunit;}
			},			
			{field:'username',title:'变更人员',width:30,sortable:true,
				formatter:function(value,row,index){return row.username;}
			},
			{field:'alterremark',title:'备注',width:20,sortable:false,
				formatter:function(value,row,index){return row.alterremark;}
			}
		]],
		toolbar:[{
			text:'变更库存',
			iconCls:'icon-add',
			handler:function(){
				addrow();
			}
		},'-',{
			text:'上传照片',
			iconCls:'icon-add',
			handler:function(){
				addPicture();
			}
		},'-'],
		onLoadSuccess:function(){
			$('#alterTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	
	$('#commodityCombo1').combogrid({
		idField:'commodityid', //ID字段
	    textField:'commodityname', //显示的字段
	    url:"<%=basePath%>commodityManage/queryCommodity.action",
	    fitColumns: true,
		striped: true,
		editable:false,//不可编辑，只能选择
	    columns:[[
	        {field:'commodityname',title:'商品名称',width:150},
	        {field:'commoditymarque',title:'商品型号',width:150}
	    ]],
	});
	
	$('#commodityCombo2').combogrid({
		idField:'commoditymarque', //ID字段
	    textField:'commoditymarque', //显示的字段
	    url:"<%=basePath%>commodityManage/queryCommodity.action",
	    fitColumns: true,
		striped: true,
		editable:false,//不可编辑，只能选择
	    columns:[[
			{field:'commoditymarque',title:'商品型号',width:150},
	        {field:'commodityname',title:'商品名称',width:150}
	        
	    ]],
	    onSelect: function () {
	    	var grid=$("#commodityCombo2").combogrid("grid");//获取表格对象 		    	
	    	var row = grid.datagrid('getSelected');//获取行数据 
	    	$("#commodityname").attr("value", row.commodityname);
	    	$("#commodityid").attr("value", row.commodityid);
	    	$("#inventorynum").attr("value", row.inventorynum);
	    	$("#inventoryInfo").attr("value", row.inventorynum+"  "+row.commodityunit);
	    	grid.datagrid('reload'); 
	    }
	});	
   });
    	
    //新增
    function addrow(){
		$('#mydialog').dialog({
				title:'新增商品信息' 
		});
		
		//清空表单信息、
		$('#myform').get(0).reset();
		$("#commodityname").attr("value", "");
    	$("#inventoryInfo").attr("value", "");
		$('#mydialog').dialog('open');
	}
 
    //表格查询
	function searchAlter(){
    	
		var params = $('#alterTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
			
		}); 
		$('#alterTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
    
	//清空查询条件
	function clearForm(){
		$('#queryForm').form('clear');
		searchAlter();
	}
	
	//导出
	function exportAlter(){
		var postForm = document.getElementById("queryForm");
		postForm.action = "<%=basePath%>exportExcel/exportAlter.action";
		postForm.submit();
	}
	
	//选择一条变更记录上传图片
	function addPicture(){
		var arr =$('#alterTable').datagrid('getSelections');
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一行记录进行修改!'
			});
		} else {
			$('#mydialog2').dialog({
				title:'上传照片'
			});
			$('#mydialog2').dialog('open'); //打开窗口
			$('#myform2').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
				alterid:arr[0].alterid ,
			});
		}
	}
	</script>	
  </head>
  
  <body>
    <form id="queryForm" style="margin:8;text-align: center;" method="post">
		<table>
			<tr>
			<td>商品名称：<input id="commodityCombo1" name="commodityid" width="150px"></td>
			<td>变更类型：
			<select name='altertype' class="easyui-combobox" style='width:200px;' >
						<option value="0"></option>
						<option value="普通入库">普通入库</option>
						<option value="销售出库">销售出库</option>
						<option value="手动调整">手动调整</option>
						<option value="退货入库">退货入库</option>
					</select></td>
			<td align="center"><a href="#" onclick="searchAlter();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			<td align="center"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td>
			<td align="center"><a href="#" onclick="exportAlter();" class="easyui-linkbutton" iconCls="icon-Excel">导出Execl</a></td>
			</tr>
		</table>
	</form>
	<div style="padding:10" id="tabdiv">
		<table id="alterTable"></table>
	</div>
	<div id="mydialog" modal=true class="easyui-dialog" title="添加商品" data-options="iconCls:'icon-save',closed:'true'" style="width:260px;height:320px;">
		<form id="myform" action="" method="post">
			<input id="commodityid" type="hidden" name="commodityid" value="" />
			<input type="hidden" id="inventorynum" name="inventorynum" value="" />
			<table>							
				<tr>
					<td align="right">商品型号：</td>
					<td><input id="commodityCombo2" name="commodityid" width="150px"></td>
					
				</tr>
				<tr>
					<td align="right">商品名称：</td>
					<td><input id="commodityname" type="text" name="commodityname"
						value=""/></td>
				</tr>
				<tr>
					<td align="right">商品库存：</td>
					<td><input id="inventoryInfo" type="text" name="inventoryInfo"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">变更数量：</td>
					<td><input id="alternum" type="text" name="alternum" value="" /></td>
				</tr>
				<tr>
					<td align="right">变更类型</td>
					<td><select  id="altertype" class="type-select" name="altertype">
						  <option value="普通入库">普通入库</option>
						  <option value="销售出库">销售出库</option>
						  <option value="手动调整">手动调整</option>
						  <option value="退货入库">退货入库</option>
						</select>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><a id="btn1" class="easyui-linkbutton">确定</a>
						<a id="btn2" class="easyui-linkbutton">关闭</a></td>
				</tr>
			</table>
			
		</form>
	</div>
	<div id="mydialog2" modal=true class="easyui-dialog" title="上传照片" data-options="iconCls:'icon-save',closed:'true'" style="width:260px;height:200px;">
		<form id="myform2" action="${pageContext.request.contextPath}/commodityManage/picUpload.action"  method="post" enctype="multipart/form-data">
			<input type="hidden"  name="alterid" value="" />
			
			<table>
				<tr>
				    
					<td>上传的文件: <input  id="file" type="file" name="myfiles"/><br/> </td>
				
				</tr>
				<tr align="center" height="60px">
				<td colspan="2"><button type="submit">上传</button>	
				<button type="button" id="btn4">关闭</button></td>
				</tr>
				
			</table>
		</form>
	</div>
  </body>
  

</html>
