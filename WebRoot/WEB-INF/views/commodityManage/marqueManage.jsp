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
<title>型号管理</title>
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
		 *  保存用户商品方法
		 */
		$('#btn1').click(function(){
				if($('#myform').form('validate')){
					$.ajax({
						type: 'post' ,
						url: flag=='add'?'<%=basePath%>commodityManage/saveMarque.action':'<%=basePath%>commodityManage/updateMarque.action' ,
						cache:false ,
						data:$('#myform').serialize() ,
						dataType:'json' ,
						success:function(result){
							//1 关闭窗口
							$('#mydialog').dialog('close');
							//2刷新datagrid 
							$('#marqueTable').datagrid('reload');
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
		
		//datagrid商品型号列表
		$('#marqueTable').datagrid({
			title:'型号列表', //标题
			method:'post',
			iconCls:'icon-user', //图标
			singleSelect:false, //多选
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:"<%=basePath%>commodityManage/marqueList.action", //数据来源
			sortName: 'commodityInfo.commodityname', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'commodityid', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'ck',checkbox:true,width:2}, //显示复选框
				{field:'commoditymarque',title:'商品型号',width:20,sortable:true,
					formatter:function(value,row,index){return row.commoditymarque;} //需要formatter一下才能显示正确的数据
				},
				{field:'commodityname',title:'商品名称',width:20,sortable:true,
					formatter:function(value,row,index){return row.commodityname;} //需要formatter一下才能显示正确的数据
				},
				{field:'commoditytype',title:'商品类型',width:20,sortable:true,
					formatter:function(value,row,index){return row.commoditytype;} 
				},
				{field:'commodityscale',title:'商品规格',width:20,sortable:true,
					formatter:function(value,row,index){return row.commodityscale;}
				},
				{field:'inventorynum',title:'库存量',width:20,sortable:false,
					formatter:function(value,row,index){return row.inventorynum;}
				},
				{field:'commodityunit',title:'商品单位',width:20,sortable:false,
					formatter:function(value,row,index){return row.commodityunit;}
				},				
				{field:'qiyong',title:'是否启用',width:30,sortable:true,
					formatter:function(value,row,index){return row.qiyong;}
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
				$('#marqueTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
    });
    	
    //新增
    function addrow(){
    	flag = 'add';
    	$("#commoditymarque").attr("disabled", false);
		$('#mydialog').dialog({
				title:'新增商品信息' 
		});
		$('#myform').get(0).reset();
		$('#mydialog').dialog('open');
	}
    
  //更新
    function updaterow(){
    	flag = 'edit';
    	$("#commoditymarque").attr("disabled", true);
		var arr =$('#marqueTable').datagrid('getSelections');
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一行记录进行修改!'
			});
		} else {
			$('#mydialog').dialog({
				title:'更新商品信息'
			});
			$('#mydialog').dialog('open'); //打开窗口
			$('#myform').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
				commodityid:arr[0].commodityid ,
				commodityname:arr[0].commodityname ,
				commoditytype:arr[0].commoditytype ,
				commodityscale:arr[0].commodityscale ,
				commoditymarque:arr[0].commoditymarque ,
				commodityunit:arr[0].commodityunit ,
				qiyong:arr[0].qiyong ,
			});
		}
	}
  	
  //删除
  	function deleterow(){
		var rows =$('#marqueTable').datagrid('getSelections');
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
		        			ps += "?commodityid="+n.commodityid;
		        		else
		        			ps += "&commodityid="+n.commodityid;
		        	});
		        	$.post('<%=basePath%>commodityManage/deleteMarques.action'+ps,function(data){
			        	$('#marqueTable').datagrid('reload');
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

    //表格查询
	function searchMarque(){
		var params = $('#marqueTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#marqueTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
    
	//清空查询条件
	function clearForm(){
		$('#queryForm').form('clear');
		searchMarque();
	}
	
	
	//导出
	function exportMarque(){
		var postForm = document.getElementById("queryForm");
		postForm.action = "<%=basePath%>exportExcel/exportMarque.action";
		postForm.submit();
	}
	</script>	
  </head>
  
  <body>
    <form id="queryForm" style="margin:8;text-align: center;" method="post">
		<table>
			<tr>
			<td>商品名称：<input name="commodityname" style="width: 200"></td>
			<td>商品型号：<input name="commoditymarque" style="width: 200"></td>
			<td>是否启用：<select name="qiyong" style="width: 200">
					<option value=-1></option>
   					 <option value=1>已启用</option>
   					 <option value=0>未启用</option>
					</select>
			</td>
			<td align="center"><a href="#" onclick="searchMarque();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			<td align="center"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td>
			<td align="center"><a href="#" onclick="exportMarque();" class="easyui-linkbutton" iconCls="icon-Excel">导出Execl</a></td>
			</tr>
		</table>
	</form>
	<div style="padding:10" id="tabdiv">
		<table id="marqueTable"></table>
	</div>
	<div id="mydialog" modal=true class="easyui-dialog" title="添加商品" data-options="iconCls:'icon-save',closed:'true'" style="width:260px;height:320px;">
		<form id="myform" action="" method="post">
			<input type="hidden" name="commodityid" value="" />
			<table>
				<tr>
					<td align="right">商品型号：</td>
					<td><input id="commoditymarque" type="text" name="commoditymarque"
						value="" disabled="disabled"/></td>
				</tr>
				<tr>
					<td align="right">商品名称：</td>
					<td><input id="commodityname" type="text" name="commodityname"
						value="" /></td>
				</tr>
				
				<tr>
					<td align="right">商品类型：</td>
					<td><input id="commoditytype" type="text" name="commoditytype"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">商品规格：</td>
					<td><input id="commodityscale" type="text" name="commodityscale" value="" /></td>
				</tr>
				<tr>
					<td align="right">单位：</td>
					<td><input id="commodityunit" type="text" name="commodityunit" value="" /></td>
				</tr>
				<tr>
				
					<td align="right">是否启用：</td>
					<td>
						是<input class="radio1" type="radio" checked="checked" name="qiyong" value="1" />
						否<input class="radio2" type="radio" name="qiyong" value="0" />
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><font size="2px" color="red">*商品型号确定后不可修改*</font></td>
				</tr>
				<tr align="center" height="60px">
					<td colspan="2"><a id="btn1" class="easyui-linkbutton">确定</a>
						<a id="btn2" class="easyui-linkbutton">关闭</a></td>
				</tr>
			</table>
		</form>
	</div>
  </body>
  

</html>
