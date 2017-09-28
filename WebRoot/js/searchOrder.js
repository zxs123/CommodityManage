 var index = 1;

//新增
function addrow(){
	var len = $('#commodityTable tbody tr').length;
	console.log("len========="+len);
	while(len != 1){
		$('#commodityTable tbody tr:last-child').remove();
		len = $('#commodityTable tbody tr').length;
	}
	loadCombogrid(); //加载combogrid的数据
	$(".container").css("display","");
	$(".express-info").css("display","none");
}

//更新
function updaterow(){
	var arr =$('#orderTable').datagrid('getSelections');
	if(arr.length != 1){
		$.messager.show({
			title:'提示信息!',
			msg:'只能选择一行记录进行修改!'
		});
	} else {			
		$('#orderForm').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
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
		       console.log(data);
		       var dataObj=eval("("+data+")");
			   jQuery.each(dataObj, function(i,item){
				   loadCombogrid();
				   console.log("i==========="+i);
				   if(i!=0){
					   addCommodity();
				   }
					console.log(item.commodityMarque+","+item.commodityNum); 
					console.log("index====="+index);
					$("#commoditymarque"+index).combogrid('setValue', item.commodityMarque);
			    	$("#purchaseNum"+index).attr("value", item.commodityNum);
		       });  
		    },  
		    error: function(){  
		      return;  
		    }  
		});
		$(".container").css("display","");
		$(".express-info").css("display","none");
	}
}

//发货
function sendrow(){
	var arr =$('#orderTable').datagrid('getSelections');
	if(arr.length != 1){
		$.messager.show({
			title:'提示信息!',
			msg:'只能选择一行记录进行修改!'
		});
	} else {			
		$('#orderForm').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
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
		       console.log(data);
		       var dataObj=eval("("+data+")");
			   jQuery.each(dataObj, function(i,item){
				   loadCombogrid();
				   console.log("i==========="+i);
				   if(i!=0){
					   addCommodity();
				   }
					console.log(item.commodityMarque+","+item.commodityNum); 
					console.log("index====="+index);
					$("#commoditymarque"+index).combogrid('setValue', item.commodityMarque);
			    	$("#purchaseNum"+index).attr("value", item.commodityNum);
		       });  
		    },  
		    error: function(){  
		      return;  
		    }  
		});
		$(".container").css("display","");
		$(".express-info").css("display","");
	}
};

//发货
function deleterow(){
	var arr =$('#orderTable').datagrid('getSelections');
	if(arr.length != 1){
		$.messager.show({
			title:'提示信息!',
			msg:'只能选择一行记录进行删除!'
		});
	} else {			
		$('#orderForm').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
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
		       console.log(data);
		       var dataObj=eval("("+data+")");
			   jQuery.each(dataObj, function(i,item){
				   loadCombogrid();
				   console.log("i==========="+i);
				   if(i!=0){
					   addCommodity();
				   }
					console.log(item.commodityMarque+","+item.commodityNum); 
					console.log("index====="+index);
					$("#commoditymarque"+index).combogrid('setValue', item.commodityMarque);
			    	$("#purchaseNum"+index).attr("value", item.commodityNum);
		       });  
		    },  
		    error: function(){  
		      return;  
		    }  
		});
		$(".container").css("display","");
		$(".express-info").css("display","");
	}
};

//获取商品信息
function loadCombogrid(){
	$('.commodityCombo'+index).combogrid({
		idField:'commoditymarque', //ID字段
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
	    	var grid=$('.commodityCombo'+index).combogrid("grid");//获取表格对象 		    	
	    	var row = grid.datagrid('getSelected');//获取行数据
	    	$("#commodityname"+index).attr("value", row.commodityname);
	    	$("#commodityscale"+index).attr("value", row.commodityscale);
	    	$("#inventorynum"+index).attr("value", row.inventorynum);
	    	grid.datagrid('reload'); 
	    }
	});
}

function addCommodity(){
	var str = "";
	index++;
	str = '<tr>' +
		'<td>' +
			'<label>商品型号:&nbsp;</label>' +
			'<input id="commoditymarque'+index+'"  class="commodityCombo'+index+'" name="commoditymarque1"  width="150px">'+
			'</td>' +
			'<td>' +
				'<label>名&nbsp;&nbsp;称:&nbsp;</label>' +
				'<input id="commodityname'+index+'" type="text" value="" disabled="true">' +
			'</td>' +
			'<td>' +
				'<label>规&nbsp;&nbsp;格:&nbsp;</label>' +
				'<input id="commodityscale'+index+'" type="text" value="" disabled="true">' +
			'</td>' +
			'<td>' +
				'<label>库存量:&nbsp;</label>' +
				'<input id="inventorynum'+index+'" type="text" value="" disabled="true">' +
			'</td>' +
			'<td>' +
				'<label>购买数量:&nbsp;</label>' +
				'<input id="purchaseNum'+index+'" name="purchaseNum" type="number" value="0">' +
			'</td>' +
		'</tr>';
	$('#commodityTable tbody').append(str);
	loadCombogrid(); //加载combogrid的数据
}

function deleteCommodity(){
	var len = $('#commodityTable tbody tr').length;
	console.log("len========="+len);
	if(len != 1){
		$('#commodityTable tbody tr:last-child').remove();
		index--;
	}
}

function submitForm(){
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
	closeOrder();
}

function closeOrder(){
	//1 隐藏窗口
	$(".container").css("display","none");
	var len = $('#commodityTable tbody tr').length;
	console.log("len========="+len);
	while(len != 1){
		$('#commodityTable tbody tr:last-child').remove();
		len = $('#commodityTable tbody tr').length;
		index--;
	}
	index=1;
}