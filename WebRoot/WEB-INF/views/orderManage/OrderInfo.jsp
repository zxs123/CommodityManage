<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="zxs.ssm.po.Users" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Users user = (Users)session.getAttribute("baseUser");
	System.out.println(user.getUserPosition());
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<title>订单管理</title>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4.4/themes/gray/easyui.css"/>
<link rel="stylesheet" type="text/css" href="/CommodityManage/css/searchOrder.css">
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4.4/themes/icon.css" />
<script type="text/javascript" src="../jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/base-loading.js"></script>
<script type="text/javascript" src="<%=basePath%>js/datagrid-groupview/datagrid-groupview.js"></script>
<script type="text/javascript" src="/CommodityManage/js/test.js"></script>

<script type="text/javascript">
    var index = 1;
    var flag = 0;
    
    jQuery(function($){
		//datagrid订单信息列表
		$('#orderTable').datagrid({
			title:'订单列表', //标题
			method:'post',
			iconCls:'icon-user', //图标
			singleSelect:false, //多选
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:"<%=basePath%>orderManage/orderList.action", //数据来源
			//sortName: 'commodityInfo.commodityname', //排序的列
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
				{field:'createTime',title:'创建时间',width:30,sortable:true,
					formatter:function(value,row,index){return row.createTime;} //需要formatter一下才能显示正确的数据
				},
				{field:'userId',title:'创建人',width:20,sortable:true,
					formatter:function(value,row,index){return row.userId;} 
				},
				{field:'customerName',title:'客户姓名',width:20,sortable:true,
					formatter:function(value,row,index){return row.customerName;}
				},
				{field:'telephone1',title:'联系电话',width:20,sortable:false,
					formatter:function(value,row,index){return row.telephone1;}
				},
				{field:'address',title:'地址',width:30,sortable:false,
					formatter:function(value,row,index){return row.address;}
				},				
				{field:'orderType',title:'订单类型',width:20,sortable:true,
					formatter:function(value,row,index){return row.orderType;}
				},
				{field:'orderStatue',title:'订单状态',width:20,sortable:true,
					formatter:function(value,row,index){
						var statue = "已删除";
						if(1==row.orderZt){
							statue = "待发货";
						}else if(2==row.orderZt){
							statue = "已发货";
						}else if(3==row.orderZt){
							statue = "已退货";
						}
						return statue;
					}
				},
				{field:'orderDetail',title:'订单详情',width:20,sortable:true,
					formatter:function(value,row,index){
						return '<a href="#" onclick="checkOrderDetail(&quot;' + row.orderNum + '&quot;)">查看</a>';}
				},
				{field:'expressDetail',title:'快递详情',width:20,sortable:true,
					formatter:function(value,row,index){
						return '<a href="#" onclick="checkExpress(&quot;' + row.orderNum + '&quot;)">查看</a>';}
				}/* ,
				{field:'photoDetail',title:'照片详情',width:20,sortable:true,
					formatter:function(value,row,index){
						return '<a href="#" onclick="checkPhoto(&quot;' + row.orderNum + '&quot;)">查看</a>';}
				} */
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
				text:'发货',
				iconCls:'icon-remove',
				handler:function(){
					sendrow();
				}
			},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){
					deleterow();
				}
			},'-',{
				text:'上传订单照片',
				iconCls:'icon-add',
				handler:function(){
					addPicture();
				}
			},'-',{
				text:'上传快递照片',
				iconCls:'icon-add',
				handler:function(){
					addExpressPicture();
				}
			},'-'],
			onLoadSuccess:function(){
				$('#orderTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
    	
      	
    	$('.submit-btn').click(function(event) {
    		if($('#orderForm').form('validate')){
				$.ajax({
					type: 'post' ,
					url: '<%=basePath%>orderManage/saveOrder.action?flag='+flag,
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
    		closeOrder();
    	});
    	
    	/**
    	 * 关闭窗口方法
    	 */
    	$('#btnOrderdetail').click(function(){
    		$('#orderdetaillog').dialog('close');
    	});
    	$('#btnExpressInfo').click(function(){
    		$('#expressinfolog').dialog('close');
    	});
    	$('#btnPhotoInfo').click(function(){
    		$('#photoinfolog').dialog('close');
    	});
    	/**
		 * 关闭窗口方法
		 */
		$('#btn4').click(function(){
			$('#mydialog2').dialog('close');
		});
    	
    	//上传订单照片
		<%-- $('#btn1').click(function(){
			if($('#myform2').form('validate')){
				$.ajax({
					type: 'post' ,
					url: '<%=basePath%>orderManage/picUpload.action',
					cache:false ,
					data:$('#myform2').serialize() ,
					dataType:'json' ,
					success:function(result){
						//1 关闭窗口
						$('#mydialog2').dialog('close');
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
		}); --%>
    	
    });
    	
    //新增订单
    function addrow(){
    	var len = $('#commodityTable tbody tr').length;
		while(len != 1){
			$('#commodityTable tbody tr:last-child').remove();
			len = $('#commodityTable tbody tr').length;
		}
		loadCombogrid(index); //加载combogrid的数据
		flag = 1;
		$(".submit-btn").text("提交");
    	$(".container").css("display","");
    	$(".express-info").css("display","none");
	}
    
	//更新订单
    function updaterow(){
		index = 1;
		var arr =$('#orderTable').datagrid('getSelections');		
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一行记录进行修改!'
			});
		} else {
			if(arr[0].orderZt==2){
				$.messager.show({
					title:'提示信息!',
					msg:'该订单已发货，无法进行更新!'
				});
				return;
			}else if(arr[0].orderZt==3){
				$.messager.show({
					title:'提示信息!',
					msg:'该订单已退货，无法进行更新!'
				});
				return;
			}
			var len = $('#commodityTable tbody tr').length;
			while(len != 1){
				$('#commodityTable tbody tr:last-child').remove();
				len = $('#commodityTable tbody tr').length;
			}
			$('#orderForm').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
				orderNum:arr[0].orderNum,
				customerName:arr[0].customerName ,
				telephone1:arr[0].telephone1 ,
				telephone2:arr[0].telephone2 ,
				address:arr[0].address ,
			});
			$.ajax({  
			    type: 'post',  
			    url: "<%=basePath %>orderManage/getOrderDetail.action",  
			    cache: false,  
			    data: {"orderNum":arr[0].orderNum},  
			    dataType: 'text',  
			    success: function(data){  
			       var dataObj=eval("("+data+")");
				   jQuery.each(dataObj, function(i,item){
						if(i==0){
							loadCombogrid(1);
						}else if(i!=0){
						 	addCommodity();
						}
						$("#commoditymarque"+index).combogrid('setValue', item.commoditymarque);
						$("#commodityid"+index).attr("value", item.commodityid);
						$("#commodityname"+index).attr("value", item.commodityname);
						$("#commodityscale"+index).attr("value", item.commodityscale);
						$("#inventorynum"+index).attr("value", item.inventorynum);
				    	$("#purchaseNum"+index).attr("value", item.commodityNum);
			       });  
			    },  
			    error: function(){  
			      return;  
			    }  
			});
			flag = 2;
			$(".submit-btn").text("更新");
			$(".container").css("display","");
			$(".express-info").css("display","none");
		}
	}
	
    function checkOrderDetail(orderNum){
    	
    	$('#orderDetailTable').datagrid({
			title:'订单详情列表', //标题
			method:'post',
			iconCls:'icon-user', //图标
			singleSelect:false, //多选
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:"<%=basePath%>orderManage/getOrderDetail2.action?orderNum="+orderNum, //数据来源
			//sortName: 'commodityInfo.commodityname', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'orderNum', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				
				{field:'orderNum',title:'订单编号',width:20,sortable:true,
					formatter:function(value,row,index){return row.orderNum;} //需要formatter一下才能显示正确的数据
				},
				{field:'commodityMarque',title:'商品型号',width:10,sortable:true,
					formatter:function(value,row,index){return row.commodityMarque;} //需要formatter一下才能显示正确的数据
				},
				{field:'commodityNum',title:'商品数量',width:10,sortable:true,
					formatter:function(value,row,index){return row.commodityNum;} //需要formatter一下才能显示正确的数据
				}
			]],
			
			onLoadSuccess:function(){
				$('#orderTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
    	$('#orderdetaillog').dialog({
			title:'订单详情查看'
		});
		$('#orderdetaillog').dialog('open'); //打开窗口
    }
	
	//选择一条变更记录上传订单照片
	function addPicture(){
		var arr =$('#orderTable').datagrid('getSelections');
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一行记录进行订单照片上传!'
			});
		} else {
			$('#mydialog2').dialog({
				title:'上传照片'
			});
			$('#showNum').hide();
			$('#flag').val('1');
			$('#mydialog2').dialog('open'); //打开窗口
			$('#myform2').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
				orderNum:arr[0].orderNum ,
				
			});
		}
	}
	
	//选择一条变更记录上传图片
	function addExpressPicture(){
		var arr =$('#orderTable').datagrid('getSelections');
		var expressNum='';
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一行记录进行快递照片上传!'
			});
		} 
		if(arr[0].orderZt==1){
			$.messager.show({
				title:'提示信息!',
				msg:'该订单未发货，不能上传快递照片!'
			});
			return;
		}else {
			$('#mydialog2').dialog({
				title:'上传照片'
			});
			$('#flag').val('2');
			$('#showNum').show();
			$('#mydialog2').dialog('open'); //打开窗口
			$('#myform2').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
				expressNum:expressNum ,
				orderNum:arr[0].orderNum ,
			});
		}
	}
	function checkExpress(orderNum){
		$('#expressInfoTable').datagrid({
			title:'订单详情列表', //标题
			method:'post',
			iconCls:'icon-user', //图标
			singleSelect:false, //多选
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:"<%=basePath%>orderManage/getExpressInfo.action?orderNum="+orderNum, //数据来源
			//sortName: 'commodityInfo.commodityname', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'orderNum', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'orderNum',title:'订单编号',width:20,sortable:true,
					formatter:function(value,row,index){return row.orderNum;} //需要formatter一下才能显示正确的数据
				},
				{field:'expressNum',title:'快递单号',width:20,sortable:true,
					formatter:function(value,row,index){return row.expressNum;} //需要formatter一下才能显示正确的数据
				},
				{field:'expressCompany',title:'快递公司',width:10,sortable:true,
					formatter:function(value,row,index){return row.expressCompany;} //需要formatter一下才能显示正确的数据
				},
				{field:'expressCost',title:'邮费',width:10,sortable:true,
					formatter:function(value,row,index){return row.expressCost;} //需要formatter一下才能显示正确的数据
				}
			]],
			
			onLoadSuccess:function(){
				$('#expressInfoTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
    	$('#expressinfolog').dialog({
			title:'快递信息查看'
		});
		$('#expressinfolog').dialog('open'); //打开窗口
	}
	function checkPhoto(orderNum){
		$('#photoInfoTable').datagrid({
			title:'照片信息列表', //标题
			method:'post',
			iconCls:'icon-user', //图标
			singleSelect:false, //多选
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:"<%=basePath%>orderManage/getPhotoInfo.action?orderNum="+orderNum, //数据来源
			//sortName: 'commodityInfo.commodityname', //排序的列
			sortOrder: 'desc', //倒序
			remoteSort: true, //服务器端排序
			idField:'orderNum', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				
				{field:'orderNum',title:'订单编号',width:20,sortable:true,
					formatter:function(value,row,index){return row.orderNum;} //需要formatter一下才能显示正确的数据
				},
				{field:'expressNum',title:'快递单号',width:20,sortable:true,
					formatter:function(value,row,index){return row.expressNum;} //需要formatter一下才能显示正确的数据
				},
				{field:'expressCompany',title:'快递公司',width:10,sortable:true,
					formatter:function(value,row,index){return row.expressCompany;} //需要formatter一下才能显示正确的数据
				},
				{field:'expressCost',title:'邮费',width:10,sortable:true,
					formatter:function(value,row,index){return row.expressCost;} //需要formatter一下才能显示正确的数据
				}
			]],
			
			onLoadSuccess:function(){
				$('#photoInfoTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
    	$('#photoinfolog').dialog({
			title:'快递信息查看'
		});
		$('#photoinfolog').dialog('open'); //打开窗口
	}
	
	//订单发货
	function sendrow(){
		index = 1;
		var arr =$('#orderTable').datagrid('getSelections');
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一个订单进行发货!'
			});
		} else {
			if(arr[0].orderZt==2){
				$.messager.show({
					title:'提示信息!',
					msg:'该订单已发货，无需重复发货!'
				});
				return;
			}else if(arr[0].orderZt==3){
				$.messager.show({
					title:'提示信息!',
					msg:'该订单已退货!'
				});
				return;
			}
			var len = $('#commodityTable tbody tr').length;
			while(len != 1){
				$('#commodityTable tbody tr:last-child').remove();
				len = $('#commodityTable tbody tr').length;
			}
			$('#orderForm').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
				orderNum:arr[0].orderNum,
				customerName:arr[0].customerName ,
				telephone1:arr[0].telephone1 ,
				telephone2:arr[0].telephone2 ,
				address:arr[0].address ,
			});
			$.ajax({  
			    type: 'post',  
			    url: "<%=basePath %>orderManage/getOrderDetail.action",  
			    cache: false,  
			    data: {"orderNum":arr[0].orderNum},  
			    dataType: 'text',  
			    success: function(data){  
			       var dataObj=eval("("+data+")");
				   jQuery.each(dataObj, function(i,item){
					   if(i==0){
						   loadCombogrid(1);   
					   }else{
						   addCommodity();  
					   }
						$("#commoditymarque"+index).combogrid('setValue', item.commoditymarque);
						$("#commodityid"+index).attr("value", item.commodityid);
						$("#commodityname"+index).attr("value", item.commodityname);
						$("#commodityscale"+index).attr("value", item.commodityscale);
						$("#inventorynum"+index).attr("value", item.inventorynum);
				    	$("#purchaseNum"+index).attr("value", item.commodityNum);
			       });  
			    },  
			    error: function(){  
			      return;  
			    }  
			});
			flag = 3;
			$(".submit-btn").text("发货");
			$(".container").css("display","");
			$(".express-info").css("display","");
		}
	};
	
	//订单删除
	function deleterow(){
		index = 1;
		var arr =$('#orderTable').datagrid('getSelections');
		if(arr.length != 1){
			$.messager.show({
				title:'提示信息!',
				msg:'只能选择一个订单进行删除!'
			});
		} else {
			if(arr[0].orderZt==2){
				$.messager.show({
					title:'提示信息!',
					msg:'该订单已发货，无法删除!'
				});
				return;
			}else if(arr[0].orderZt==3){
				$.messager.show({
					title:'提示信息!',
					msg:'该订单已退货，无法删除!'
				});
				return;
			}
			$.messager.confirm('提示','确定要删除吗?',function(result){
		        if (result){
		        	$.post('<%=basePath%>orderManage/deleteOrder.action?orderNum='+arr[0].orderNum,function(data){
			        	$('#orderTable').datagrid('reload');
			        	//显示删除成果或者失败的提示信息
			        	$.messager.show({
			        		title:'提示' , 
							msg:data.mes
						});
		        	});
		      
		        }
		    });
		}
	};

	//添加商品
	function addCommodity(){
		var str = "";
		index++;
		str = '<tr>' +
			'<td>' +
				'<label>商品型号:&nbsp;</label>' +
				'<input id="commoditymarque'+index+'"  class="commodityCombo'+index+'" name="commoditymarque1"  width="150px">&nbsp;&nbsp;'+
				'</td>' +
				'<td>' +
					'<label>名&nbsp;&nbsp;称:&nbsp;</label>' +
					'<input id="commodityname'+index+'" type="text" value="" disabled="true"><input id="commodityid'+index+ '" style="display:none;" name="commodityId" type="text" value="">&nbsp;&nbsp;' +
				'</td>' +
				'<td>' +
					'<label>规&nbsp;&nbsp;格:&nbsp;</label>' +
					'<input id="commodityscale'+index+'" type="text" value="" disabled="true">&nbsp;&nbsp;' +
				'</td>' +
				'<td>' +
					'<label>库存量:&nbsp;</label>' +
					'<input id="inventorynum'+index+'" type="text" value="" disabled="true">&nbsp;&nbsp;' +
				'</td>' +
				'<td>' +
					'<label>购买数量:&nbsp;</label>' +
					'<input id="purchaseNum'+index+'" name="purchaseNum" type="number" value="0">&nbsp;&nbsp;' +
				'</td>' +
			'</tr>';
		$('#commodityTable tbody').append(str);
		loadCombogrid(index); //加载combogrid的数据
	}
	
	//删除商品
	function deleteCommodity(){
		var len = $('#commodityTable tbody tr').length;
		if(len != 1){
			$('#commodityTable tbody tr:last-child').remove();
			index--;
		}
	}
	
	//添加快递单	
	function addExpress(){
		var str = "";
		str = '<tr>' +
			'<td>' +
				'<label>快递单号:&nbsp;</label>' +
				'<input class="expressNum" name="expressNum" type="text" value="">&nbsp;&nbsp;'+
			'</td>' +
			'<td>' +
				'<label>快递公司:&nbsp;</label>' +
				'<input class="expressCompany" name="expressCompany" type="text" value="">&nbsp;&nbsp;' +
			'</td>' +
			'<td>' +
				'<label>快递费用:&nbsp;</label>' +
				'<input class="expressCost" name="expressCost" type="text" value="">&nbsp;&nbsp;' +
			'</td>' +
			'<td>' +
				'<label>发货时间:&nbsp;</label>' +
				'<input id="updateTime" name="updateTime" style="width: 150px" class="easyui-datebox"  data-options="editable:false">&nbsp;&nbsp;' +
			'</td>' +
			'</tr>';
		$('#expressTable tbody').append(str);
	}
	
	//删除快递单
	function deleteExpress(){
		var len = $('#expressTable tbody tr').length;
		if(len != 1){
			$('#expressTable tbody tr:last-child').remove();
		}
	}
	
	//关闭form
	function closeOrder(){
		//1 隐藏窗口
		$(".container").css("display","none");
		var len = $('#commodityTable tbody tr').length;
		while(len != 1){
			$('#commodityTable tbody tr:last-child').remove();
			len = $('#commodityTable tbody tr').length;
			index--;
		}
		index=1;
	}
	
    //表格查询
	function searchMarque(){
		var beginTime=$('#beginTime').datebox('getValue');
	    var endTime=$('#endTime').datebox('getValue');
		var params = $('#orderTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
			
		}); 
		$('#orderTable').datagrid({  
			 url: '<%=basePath%>orderManage/orderList.action?beginTime='+beginTime+'&endTime='+endTime
         });
		$('#orderTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
    
	//清空查询条件
	function clearForm(){
		$('#queryForm').form('clear');
		searchMarque();
	}
	
	function onSelect()
	{ 
		var now = new Date();
	    var year = now.getFullYear();       //年
	    var month = now.getMonth() + 1;     //月
	    var day = now.getDate();            //日
	    var clock = year + "-";
	    if(month < 10) clock += "0";       
	    clock += month + "-";
	    if(day < 10) clock += "0"; 
	    clock += day;
	    return clock;
	}
	
	</script>	
  </head>
  
  <body>
    <form id="queryForm" style="margin:8;text-align: center;" method="post">
		<table>
			<tr>
			<td>订单类型：<select name='orderType' class="easyui-combobox" style='width:85px;' >
					<option value=""></option>
					<option value="普通单">普通单</option>
					  <option value="定金单">定金单</option>
					  <option value="尾款补齐">尾款补齐</option>
				</select>&nbsp;&nbsp;
			</td>
			<td>订单状态：<select name='orderZt' class="easyui-combobox" style='width:85px;' >
					<option value=""></option>
					<option value="1">待发货</option>
					<option value="2">已发货</option>
					<option value="3">已退货</option>
				</select>&nbsp;&nbsp;
			</td>
			<td>时间：<input id="beginTime" name="beginTime" style="width: 92px" class="easyui-datebox"></td>
			<td>至<input id="endTime" name="endTime" style="width: 92px" class="easyui-datebox">&nbsp;&nbsp;</td>
			<td>客户姓名：<input name="customerName" style="width: 85px">&nbsp;&nbsp;</td>
			<td>联系电话：<input name="telephone1" style="width: 85px">&nbsp;&nbsp;</td>
			<td align="center"><a href="#" onclick="searchMarque();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			<td align="center"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td>
			<td align="center"><a href="#" onclick="exportMarque();" class="easyui-linkbutton" iconCls="icon-Excel">导出Execl</a></td>
			</tr>
		</table>
	</form>
	<div style="padding:10" id="tabdiv">
		<table id="orderTable"></table>
	</div>
	
	<div class="container"  style="display:none;">
		<form  id="orderForm" method="post">
			<div style="display:none;"><input id="orderNum" name="orderNum" type="text"></div>
			<div class="content">
				<div class="person-info">
				<div class="title">个人信息：</div>
				<hr/>
					<div class="person-list"><label>客户名：</label><input name="customerName" type="text" value="张三" contentEditable="true"></div>
					<div class="person-list"><label>电话号码1：</label><input name="telephone1" type="text" value="13177276350" contentEditable="true"></div>
					<div class="person-list"><label>电话号码2：</label><input name="telephone2" type="text" value="07124442288" contentEditable="true"></div>
					<div class="person-list"><label>住&nbsp;&nbsp;&nbsp;址：</label><input class="address" name="address" type="text" class="address" value="XX省XX市XX县XX镇" contentEditable="true"></div>
					<div class="person-list"><label>订单属性：</label>
						<select class="type-select" name="orderType">
						  <option value="普通单">普通单</option>
						  <option value="定金单">定金单</option>
						  <option value="尾款补齐">尾款补齐</option>
						</select>
					</div>
				</div>
				<!-- <hr/> -->
				<div class="good-info">
					<div class="title">商品信息：</div>
					<div class="btn-delete" onclick="deleteCommodity();">删除商品</div>
					<div class="btn-add" onclick="addCommodity();">添加商品</div>
				
					<hr/>
					<table id="commodityTable" border="0" class="good-table">
						<tbody>
							<tr>
								<td>
									<label>商品型号:</label>
									<input id="commoditymarque1" class="commodityCombo1" name="commoditymarque1"  width="150px">&nbsp;&nbsp;
								</td>
								<td>
									<label>名&nbsp;&nbsp;称:</label>
									<input id="commodityname1" type="text" value="" disabled="true">
									<input style="display:none;" id="commodityid1" name="commodityId" type="text">
									&nbsp;&nbsp;
								</td>
								<td>
									<label>规&nbsp;&nbsp;格:</label>
									<input id="commodityscale1" type="text" value="" disabled="true">&nbsp;&nbsp;
								</td>
								<td>
									<label>库存量:</label>
									<input id="inventorynum1" name="inventorynum" type="text" value="" disabled="true">&nbsp;&nbsp;
								</td>
								<td>
									<label>购买数量:</label>
									<input id="purchaseNum1" name="purchaseNum" type="number" value="0">
								</td> 
							</tr>
							
						</tbody>
						
					</table>
				</div>
				<div class="express-info">
					<div class="title">快递信息：</div>
					<div class="btn-delete" onclick="deleteExpress();">删除快递单</div>
					<div class="btn-add" onclick="addExpress();">添加快递单</div>
					<hr/>
					<table id="expressTable" border="0" class="good-table">
						<tbody>
							<tr>
								<td>
									<label>快递单号:</label>
									<input class="expressNum" name="expressNum" type="text" value="">&nbsp;&nbsp;
								</td>
								<td>
									<label>快递公司:</label>
									<input class="expressCompany" name="expressCompany" type="text" value="">&nbsp;&nbsp;
								</td>
								<td>
									<label>快递费用:</label>
									<input class="expressCost" name="expressCost" type="text" value="">&nbsp;&nbsp;
								</td>
								<td>
									<label>发货时间:</label>
									<input class="updateTime" id="updateTime" name="updateTime" value="" type="text">
									&nbsp;&nbsp;
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="submit-btn">提交</div><div class="close-btn" onclick="closeOrder()">关闭</div>
		</form>
	</div>
	<div id="orderdetaillog" modal=true class="easyui-dialog" title="订单详情查看" data-options="iconCls:'icon-save',closed:'true'" style="width:400px;height:320px;">
		<form id="orderdetailform" action="" method="post">
			<div style="padding:10;text-align:center;" id="tabdiv">
		        <table id="orderDetailTable">
		        </table>
		        
	        </div>
	        
		</form>
		<div style="margin-bottom:0;text-align:center;"><a  id="btnOrderdetail" class="easyui-linkbutton">关闭</a></div>
	</div>
	<div id="expressinfolog" modal=true class="easyui-dialog" title="快递信息查看" data-options="iconCls:'icon-save',closed:'true'" style="width:400px;height:320px;">
		<form id="expressinfoform" action="" method="post">
			<div style="padding:10;text-align:center;" id="tabdiv">
		        <table id="expressInfoTable">
		        </table>
		        
	        </div>
	        
		</form>
		<div style="margin-bottom:0;text-align:center;"><a  id="btnExpressInfo" class="easyui-linkbutton">关闭</a></div>
	</div>
	<div id="photoinfolog" modal=true class="easyui-dialog" title="照片信息查看" data-options="iconCls:'icon-save',closed:'true'" style="width:400px;height:320px;">
		<form id="photoinfoform" action="" method="post">
			<div style="padding:10;text-align:center;" id="tabdiv">
		        <table id="photoInfoTable">
		        </table>
		        
	        </div>
	        
		</form>
		<div style="margin-bottom:0;text-align:center;"><a  id="btnPhotoInfo" class="easyui-linkbutton">关闭</a></div>
	</div>
	
	<!-- 上传照片 -->
	<div id="mydialog2" modal=true class="easyui-dialog" title="上传照片" data-options="iconCls:'icon-save',closed:'true'" style="width:260px;height:200px;">
		<form id="myform2" action="${pageContext.request.contextPath}/orderManage/picUpload.action"  method="post" enctype="multipart/form-data">
			<input type="hidden"  name="orderNum" value="" />
			<input type="hidden" id="flag"  name="flag" value="" />
			<div id="showNum">快递单号：<input  id="expressNum"  name="expressNum" value="" /></div>
			<table>
				<tr>				    
					<td>上传的文件: <input  id="file" type="file" name="myfiles"/><br/> </td>
				</tr>
				<tr align="center" height="60px">
					<td colspan="2"><button >上传</button>	
					<button type="button" id="btn4">关闭</button></td>
				</tr>
			</table>
		</form>
	</div>
  </body>
  <script type="text/javascript">
	//导出
	function exportMarque(){
		var postForm = document.getElementById("queryForm");
		postForm.action = "<%=basePath%>exportExcel/exportOrder.action";
		postForm.submit();
	}
  </script>

</html>
