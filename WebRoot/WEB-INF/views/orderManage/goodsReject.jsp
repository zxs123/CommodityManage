<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:MM"); 
    java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
    String str_date1 = formatter.format(currentTime); //将日期时间格式化 
        
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>退换货管理</title>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4.4/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css" href="/CommodityManage/css/searchOrder.css">
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4.4/themes/icon.css" />
<script type="text/javascript" src="../jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/base-loading.js"></script>
<script type="text/javascript" src="<%=basePath%>js/datagrid-groupview/datagrid-groupview.js"></script>
<script type="text/javascript">
    var index = 1;
    
    jQuery(function($){
    	
    	/**
    	 * 关闭窗口方法
    	 */
    	$('#btn2').click(function(){
    		$('#mydialog').dialog('close');
    	});
    	
    	/**
		 *  退换货处理，需要对快递表和订单表进行更新操作
		 */
		$('#btn1').click(function(){
				if($('#myform').form('validate')){
					$.ajax({
						type: 'post' ,
						url: '<%=basePath%>orderManage/goodsRejectConfirm.action',
						cache:false ,
						data:$('#myform').serialize() ,
						dataType:'json' ,
						success:function(result){
							//1 关闭窗口
							$('#mydialog').dialog('close');
							//2刷新datagrid 
							$('#expressTable').datagrid('reload');
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
    	
		//datagrid退换货列表
		$('#expressTable').datagrid({
			title:'退换货列表', //标题
			method:'post',
			iconCls:'icon-user', //图标
			singleSelect:false, //多选
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:"<%=basePath%>orderManage/expressList.action", //数据来源
			sortName: 'commodityInfo.commodityname', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'orderNum', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'ck',checkbox:true,width:2}, //显示复选框
				{field:'orderNum',title:'订单编号',width:20,sortable:true,
					formatter:function(value,row,index){return row.orderNum;} //需要formatter一下才能显示正确的数据
				},
				{field:'expressNum',title:'快递单号',width:30,sortable:true,
					formatter:function(value,row,index){return row.expressNum;} //需要formatter一下才能显示正确的数据
				},
				{field:'expressCompany',title:'快递公司',width:20,sortable:true,
					formatter:function(value,row,index){return row.expressCompany;} 
				},
				{field:'expressCost',title:'运费',width:20,sortable:true,
					formatter:function(value,row,index){return row.expressCost;}
				},
				{field:'updateUser',title:'操作人',width:20,sortable:false,
					formatter:function(value,row,index){return row.updateUser;}
				},
				{field:'updateTime',title:'操作时间',width:30,sortable:false,
					formatter:function(value,row,index){return row.updateTime;}
				},
				{field:'expressZt',title:'是否退货',width:30,sortable:false,
					formatter:function(value,row,index){
						var expressZt = row.expressZt;
						if(expressZt==3){
							return "是";
						}else{
							return "否";
						} 
					}
				}
			]],
			toolbar:"#tb",
			onLoadSuccess:function(){
				$('#expressTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				var rows = $('#expressTable').datagrid('getRows')//获取当前的数据行
			    var total = 0;
			    for (var i = 0; i < rows.length; i++) {
			        total += rows[i]['expressCost'];
			    }
			    var cost  = total + "元";
			    $("#expressCost").val(cost); 
			}
		});
		
		
		/**
		 *  保存用户商品方法
		 */
		$('#confirm').click(function(){
			if($('#mexpressForm').form('validate')){
				$.ajax({
					type: 'post' ,
					url: '<%=basePath%>orderManage/updateExpress.action',
					cache:false ,
					data:$('#expressForm').serialize() ,
					dataType:'json' ,
					success:function(result){
						//1 关闭窗口
						$('#expressDialog').dialog('close');
						//2刷新datagrid 
						$('#expressTable').datagrid('reload');
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
		$('#close').click(function(){
			$('#expressDialog').dialog('close');
		});
    	
    	
    	//关闭窗口
    	$('.close-btn').click(function(event) {
    		//1 隐藏窗口
			$(".container").css("display","none");
    		index=1;
    	});
    	
    	$('.submit-btn').click(function(event) {
    		if($('#orderForm').form('validate')){
				$.ajax({
					type: 'post' ,
					url: '<%=basePath%>orderManage/saveOrder.action',
					cache:false ,
					data:$('#orderForm').serialize() ,
					dataType:'json' ,
					success:function(result){
						//1 隐藏窗口
						$(".container").css("display","none");
						//2刷新datagrid 
						$('#expressTable').datagrid('reload');
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
    });
     	
    //退换货
    function goodsReject(){
    	var arr =$('#expressTable').datagrid('getSelections');
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一行记录进行修改!'
			});
		} else if(arr[0].expressZt==3){
			$.messager.show({
				title:'提示信息!',
				msg:'该订单已退货，无需再进行退货!'
			});
			return;
		}else {
			$('#mydialog').dialog({
				title:'退换货确认'
			});
			$('#mydialog').dialog('open'); //打开窗口
			$('#myform').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
				orderNum:arr[0].orderNum ,
				expressNum:arr[0].expressNum ,
			});
		}
	}
	
  //表格查询
	function searchMarque(){
	    var beginTime=$('#beginTime').datebox('getValue');
	    var endTime=$('#endTime').datebox('getValue');
		var params = $('#expressTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
				
			 params[field.name] = field.value; //设置查询参数
		});
		  $('#expressTable').datagrid({  
			 url: '<%=basePath%>orderManage/expressList.action?beginTime='+beginTime+'&endTime='+endTime
          });
		$('#expressTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
    
	//清空查询条件
	function clearForm(){
		$('#queryForm').form('clear');
		$("#return_select").val("");
		searchMarque();
	}

	//更新
    function updaterow(){
		var arr =$('#expressTable').datagrid('getSelections');
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一行记录进行修改!'
			});
		} else if(arr[0].expressZt==3){
			$.messager.show({
				title:'提示信息!',
				msg:'该订单已退货，无需再进行修改!'
			});
		}else {
			$('#expressDialog').dialog({
				title:'修改快递单信息'
			});
			$('#expressDialog').dialog('open'); //打开窗口
			$('#expressForm').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
				orderNum_old:arr[0].orderNum ,
				expressNum_old:arr[0].expressNum ,
				expressNum:arr[0].expressNum ,
				expressCompany:arr[0].expressCompany ,
				expressCost:arr[0].expressCost
			});
		}
	}
	</script>	
  </head>
  
  <body>
	  <div id="tb" style="padding:5px;height:auto">    
		<table style="width:100%">
		<tr>
			<td align="left" onclick="goodsReject();" class="easyui-linkbutton" iconCls="icon-remove" plain="true">退换货</td>
			<td align="left" onclick="updaterow();" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改快递单</td>
			<td align="right">总运费: <input id="expressCost" style="width:80px"></td>
		</tr>
		</table> 
	</div> 
    <form id="queryForm" style="margin:8;text-align: center;" method="post">
		<table>
			<tr>
				<td>订单编号：<input name="orderNum" style="width: 200"></td>
				<td>快递单号：<input name="expressNum" style="width: 200"></td>
				<td>快递公司：<input name="expressCompany" style="width: 200"></td>
				<td>是否退货：<select id="return_select"name="expressZt" style="width: 200">
						 <option value=""></option>
	   					 <option value=1>是</option>
	   					 <option value=0>否</option>
						</select>
				</td>
			</tr>
			<tr>			
				<td>起始时间：<input id="beginTime" name="beginTime" style="width: 200" class="easyui-datebox"></td>
				<td>截止时间：<input id="endTime" name="endTime" style="width: 200" class="easyui-datebox"></td>
				<td>发货人：<input name="updateUser" style="width: 200"></td>
			<td align="left"><a href="#" onclick="searchMarque();" class="easyui-linkbutton" iconCls="icon-search">查询</a>
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td>
			</tr>
		</table>
	</form>
	<div style="padding:10" id="tabdiv">
		<table id="expressTable"></table>
	</div>
	
	<div id="mydialog" modal=true class="easyui-dialog" title="退换货确认" data-options="iconCls:'icon-save',closed:'true'" style="width:260px;height:320px;">
		<form id="myform" action="" method="post">
			<input type="hidden"  name="orderNum" value="" />
			<input type="hidden" name="expressNum" value="" />
			<table>
				<tr>
					
					<td>退换货时间：<input id="returnTime" type="text" name="returnTime" style="width:50%;"
						value="<%=str_date1%>" disabled="disabled"/></td>
				</tr>
				
				<tr align="center" height="60px">
					<td colspan="2"><a id="btn1" class="easyui-linkbutton">确定</a>
						<a id="btn2" class="easyui-linkbutton">关闭</a></td>
				</tr>
			</table>
		</form>
	</div>
		<div id="expressDialog" modal=true class="easyui-dialog" title="添加商品" data-options="iconCls:'icon-save',closed:'true'" style="width:260px;height:320px;">
		<form id="expressForm" action="" method="post">
			<input type="hidden" name="orderNum_old" value="" />
			<input type="hidden" name="expressNum_old" value="" />
			<table>
				<tr>
					<td align="right">快递单号：</td>
					<td><input id="expressNum" type="text" name="expressNum"
						value=""/></td>
				</tr>
				<tr>
					<td align="right">快递公司：</td>
					<td><input id="expressCompany" type="text" name="expressCompany"
						value="" /></td>
				</tr>
				
				<tr>
					<td align="right">运费：</td>
					<td><input id="expressCost" type="text" name="expressCost"
						value="" /></td>
				</tr>
				<tr align="center" height="60px">
					<td colspan="2"><a id="confirm" class="easyui-linkbutton">确定</a>
						<a id="close" class="easyui-linkbutton">关闭</a></td>
				</tr>
			</table>
		</form>
	</div>
  </body>

</html>
