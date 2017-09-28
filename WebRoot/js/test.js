/*var location = (window.location+'').split('/');  
var basePath = location[0]+'//'+location[2]+'/'+location[3];  */

function loadCombogrid(i){
	if(i==1){
		$('.commodityCombo1').combogrid({
			idField:'commoditymarque', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"../commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$('.commodityCombo1').combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityid1").attr("value", row.commodityid);
		    	$("#commodityname1").attr("value", row.commodityname);
		    	$("#commodityscale1").attr("value", row.commodityscale);
		    	$("#inventorynum1").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
	}else if(i==2){
		$('.commodityCombo2').combogrid({
			idField:'commoditymarque', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"../commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$('.commodityCombo2').combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityid2").attr("value", row.commodityid);
		    	$("#commodityname2").attr("value", row.commodityname);
		    	$("#commodityscale2").attr("value", row.commodityscale);
		    	$("#inventorynum2").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
	}else if(i==3){
		$('.commodityCombo3').combogrid({
			idField:'commoditymarque', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"../commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$('.commodityCombo3').combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityid3").attr("value", row.commodityid);
		    	$("#commodityname3").attr("value", row.commodityname);
		    	$("#commodityscale3").attr("value", row.commodityscale);
		    	$("#inventorynum3").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
	}else if(i==4){
		$('.commodityCombo4').combogrid({
			idField:'commoditymarque', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"../commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$('.commodityCombo4').combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityid4").attr("value", row.commodityid);
		    	$("#commodityname4").attr("value", row.commodityname);
		    	$("#commodityscale4").attr("value", row.commodityscale);
		    	$("#inventorynum4").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
	}else if(i==5){
		$('.commodityCombo5').combogrid({
			idField:'commoditymarque', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"../commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$('.commodityCombo5').combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityid5").attr("value", row.commodityid);
		    	$("#commodityname5").attr("value", row.commodityname);
		    	$("#commodityscale5").attr("value", row.commodityscale);
		    	$("#inventorynum5").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
	}else if(i==6){
		$('.commodityCombo6').combogrid({
			idField:'commoditymarque', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"../commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$('.commodityCombo6').combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityid6").attr("value", row.commodityid);
		    	$("#commodityname6").attr("value", row.commodityname);
		    	$("#commodityscale6").attr("value", row.commodityscale);
		    	$("#inventorynum6").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
	}else if(i==7){
		$('.commodityCombo7').combogrid({
			idField:'commoditymarque', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"../commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$('.commodityCombo7').combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityid7").attr("value", row.commodityid);
		    	$("#commodityname7").attr("value", row.commodityname);
		    	$("#commodityscale7").attr("value", row.commodityscale);
		    	$("#inventorynum7").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
	}else if(i==8){
		$('.commodityCombo8').combogrid({
			idField:'commoditymarque', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"../commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$('.commodityCombo8').combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityid8").attr("value", row.commodityid);
		    	$("#commodityname8").attr("value", row.commodityname);
		    	$("#commodityscale8").attr("value", row.commodityscale);
		    	$("#inventorynum8").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
	}else if(i==9){
		$('.commodityCombo9').combogrid({
			idField:'commoditymarque', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"../commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$('.commodityCombo9').combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityid9").attr("value", row.commodityid);
		    	$("#commodityname9").attr("value", row.commodityname);
		    	$("#commodityscale9").attr("value", row.commodityscale);
		    	$("#inventorynum9").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
	}else if(i==10){
		$('.commodityCombo10').combogrid({
			idField:'commoditymarque', //ID字段
		    textField:'commoditymarque', //显示的字段
		    url:"../commodityManage/queryCommodity.action",
		    fitColumns: true,
			striped: true,
			editable:false,//不可编辑，只能选择
		    columns:[[
		        {field:'commodityname',title:'商品名称',width:150},
		        {field:'commoditymarque',title:'商品型号',width:150}
		    ]],
		    onSelect: function () {
		    	var grid=$('.commodityCombo10').combogrid("grid");//获取表格对象 		    	
		    	var row = grid.datagrid('getSelected');//获取行数据
		    	$("#commodityid10").attr("value", row.commodityid);
		    	$("#commodityname10").attr("value", row.commodityname);
		    	$("#commodityscale10").attr("value", row.commodityscale);
		    	$("#inventorynum10").attr("value", row.inventorynum);
		    	grid.datagrid('reload'); 
		    }
		});
	}
}