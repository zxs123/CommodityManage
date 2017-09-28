<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>商品订单管理</title>
	<link rel="stylesheet" type="text/css" href="/CommodityManage/css/searchOrder.css">
	<link rel="stylesheet" type="text/css"	href="/CommodityManage/jquery-easyui-1.4.4/themes/gray/easyui.css" />
	<link rel="stylesheet" type="text/css"	href="/CommodityManage/jquery-easyui-1.4.4/themes/icon.css" />
	<script type="text/javascript" src="/CommodityManage/jquery-easyui-1.4.4/jquery.min.js"></script>
	<script type="text/javascript" src="/CommodityManage/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/CommodityManage/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<!-- 	<script type="text/javascript" src="/CommodityManage/js/searchOrder.js"></script>  -->
	<script type="text/javascript" src="<%=basePath%>js/datagrid-groupview/datagrid-groupview.js"></script>
	<script type="text/javascript">
    jQuery(function($){
    	$('#commodityCombo').combogrid({
			idField:'commodityid', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"<%=basePath%>commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$("#commodityCombo").combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityname").attr("value", row.commodityname);
		    	$("#commodityscale").attr("value", row.commodityscale);
		    	$("#inventorynum").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
    	
    	$('.btn-add').click(function(event) {
    		var str = "";
    		str = '<tr>' +
				'<td>' +
					'<label>商品型号:&nbsp;</label>' +
					'<input class="commodityCombo" name="commodityid"  width="150px">'+
					'</td>' +
					'<td>' +
						'<label>名&nbsp;&nbsp;称:&nbsp;</label>' +
						'<input type="text" value="" disabled="true">' +
					'</td>' +
					'<td>' +
						'<label>规&nbsp;&nbsp;格:&nbsp;</label>' +
						'<input type="text" value="" disabled="true">' +
					'</td>' +
					'<td>' +
						'<label>库存量:&nbsp;</label>' +
						'<input type="text" value="" disabled="true">' +
					'</td>' +
					'<td>' +
						'<label>购买数量:&nbsp;</label>' +
						'<input type="number" value="0">' +
					'</td>' +
				'</tr>';
    		$('table tbody').append(str);
    	});
    	
    	$('.btn-delete').click(function(event) {
    		var len = $('table tbody tr').length;
    		if(len != 1){
    			$('table tbody tr:last-child').remove();
    		}
    	});
    	
    	$('.btn').click(function(event) {
    		if($('#orderForm').form('validate')){
				$.ajax({
					type: 'post' ,
					url: '<%=basePath%>orderManage/saveOrder.action',
					cache:false ,
					data:$('#orderForm').serialize() ,
					dataType:'json' ,
					success:function(result){
						//1 提示信息
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
    });
 </script>
</head>
<body>
	<div class="container">
		<form  id="orderForm" method="post">
			<div class="content">
				<div class="person-info">
				<div class="title">个人信息：</div>
				<hr/>
					<div class="person-list"><label>客户名：</label><input name="customerName" type="text" value="张三" contentEditable="true"></div>
					<div class="person-list"><label>电话号码1：</label><input name="telephone1" type="text" value="13177276350" contentEditable="true"></div>
					<div class="person-list"><label>电话号码2：</label><input name="telephone2" type="text" value="07124442288" contentEditable="true"></div>
					<div class="person-list"><label>住&nbsp;&nbsp;&nbsp;址：</label><input name="address" type="text" class="address" value="XX省XX市XX县XX镇" contentEditable="true"></div>
				</div>
				<!-- <hr/> -->
				<div class="good-info">
					<div class="title">商品信息：</div>
					<div class="btn-delete">删除商品</div>
					<div class="btn-add">添加商品</div>
					<hr/>
					<table border="0" class="good-table">
						<tbody>
							<tr>
								<td>
									<label>商品型号:</label>
									<input id="commodityCombo" name="commodityid"  width="150px">
								</td>
								<td>
									<label>名&nbsp;&nbsp;称:</label>
									<input id="commodityname" type="text" value="" disabled="true">
								</td>
								<td>
									<label>规&nbsp;&nbsp;格:</label>
									<input id="commodityscale" type="text" value="" disabled="true">
								</td>
								<td>
									<label>库存量:</label>
									<input id="inventorynum" name="inventorynum" type="text" value="" disabled="true">
								</td>
								<td>
									<label>购买数量:</label>
									<input name="purchaseNum" type="number" value="0">
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="submit-btn">提交</div>
		</form>
	</div>
</body>
</html>
