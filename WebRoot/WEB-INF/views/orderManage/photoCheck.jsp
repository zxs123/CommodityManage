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
<title>照片信息查看</title>
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
		//datagrid退换货列表
		$('#orderTable').datagrid({
			title:'照片信息列表', //标题
			method:'post',
			iconCls:'icon-user', //图标
			singleSelect:false, //多选
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:"<%=basePath%>orderManage/photoList.action", //数据来源
			sortName: 'commodityInfo.commodityname', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'orderNum', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				
				//{field:'ck',checkbox:true,width:2}, //显示复选框
				{field:'relationNum',title:'关联ID',width:20,sortable:true,
					formatter:function(value,row,index){return row.relationNum;} //需要formatter一下才能显示正确的数据
				},
				{field:'photoType',title:'关联类型',width:30,sortable:true,
					formatter:function(value,row,index){
						return (row.photoType=='1')?'订单类型':(row.photoType=='2'?'变更类型':'快递类型');} //需要formatter一下才能显示正确的数据
				},
				{field:'customerName',title:'客户姓名',width:20,sortable:true,
					formatter:function(value,row,index){return row.customerName;}
				},
				{field:'telephone1',title:'联系电话',width:20,sortable:false,
					formatter:function(value,row,index){return row.telephone1;}
				},
				{field:'userName',title:'上传人',width:20,sortable:true,
					formatter:function(value,row,index){return row.userName;} 
				},
				{field:'commitTime',title:'上传时间',width:20,sortable:true,
					formatter:function(value,row,index){return row.commitTime;}
				},
				{field:'photoBz',title:'备注',width:20,sortable:false,
					formatter:function(value,row,index){return row.photoBz;}
				},
				{field:'checkPhoto',title:'照片查看',width:30,sortable:false,
					formatter:function(value,row,index){ //var str = '<a href="#"  name="opera" class="easyui-linkbutton" ></a>';  
			      
					return '<a href="#" onclick="checkPhoto(&quot;' + row.photo + '&quot;)">查看</a>';}
				}
			]],
			
			onLoadSuccess:function(){
				$('#orderTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
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
						$('#orderTable').datagrid('reload');
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
    	
    	var arr =$('#orderTable').datagrid('getSelections');
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一行记录进行修改!'
			});
		} else {
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
	function searchPhoto(){
		 var beginTime=$('#beginTime').datebox('getValue');
		    var endTime=$('#endTime').datebox('getValue');
		var params = $('#orderTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			
			params[field.name] = field.value; //设置查询参数
		}); 
//		params['relateNum']='';
 		$('#orderTable').datagrid({  
			 url: '<%=basePath%>orderManage/photoList.action?beginTime='+beginTime+'&endTime='+endTime
          });
		$('#orderTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
    
	//清空查询条件
	function clearForm(){
		$('#queryForm').form('clear');
		searchPhoto();
	}
	
	function checkPhoto(photo){
		
		var photoPath='/CommodityManage'+photo;
//		alert(request.getContextPath());
		$('#photoPath').attr("src",photoPath);
		$('#mydialog').dialog({
			title:'查看照片'
		});
		$('#mydialog').dialog('open'); //打开窗口
	}
	</script>	
  </head>
  
  <body>
    <form id="queryForm" style="margin:8;text-align: center;" method="post">
		<table>
			<tr>
			<td>类型：<select id='cc' class='easyui-combobox' name='photoType' style='width:70px;'>
						<option value=""></option>
						<option value="1">订单号</option>
						<option value="2">变更ID</option>
						<option value="3">快递单号</option>
					</select>&nbsp;&nbsp;
			</td>
			<td>时间：<input id="beginTime" name="beginTime" style="width:92px" class="easyui-datebox"></td>
			<td>至<input id="endTime" name="endTime" style="width:92px" class="easyui-datebox">&nbsp;&nbsp;</td>
			<td style="text-align: left;">
			关联单号：<input name="relationNum" style="width: 80px">&nbsp;&nbsp;</td>
			<td>上传人：<input name="userName" style="width: 50px">&nbsp;&nbsp;</td>
			<td>客户姓名：<input name="customerName" style="width: 50px">&nbsp;&nbsp;</td>
			<td>联系电话：<input name="telephone1" style="width: 85px">&nbsp;&nbsp;</td>
			<td><a href="#" onclick="searchPhoto();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			<td><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td>
			</tr>
		</table>
	</form>
	<div style="padding:10" id="tabdiv">
		<table id="orderTable"></table>
	</div>
	
	<div id="mydialog" modal=true class="easyui-dialog" title="照片查看" data-options="iconCls:'icon-save',closed:'true'" style="width:59%;height:400px;">
		<form id="myform" action="" method="post">
			<input type="hidden"  name="orderNum" value="" />
			<input type="hidden" name="expressNum" value="" />
			<table width="100%" height="100%">
				<tr style="height:80%;width:100%">
					
					<td><img id="photoPath" name="photoPath" width="630px;;" height="320px;" src="" alt="照片" /></td>
				</tr>
				
				<tr align="center" height="20%">
					<td colspan="2" valign="bottom"><a id="btn2" class="easyui-linkbutton">关闭</a></td>
				</tr>
			</table>
		</form>
	</div>
  </body>
  

</html>
