<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>按季度对计划投标情况的统计结果</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common/table.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.4/demo/demo.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.4/themes/default/easyui.css"></link>
<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4.4/themes/icon.css"></link>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/datagrid-groupview/datagrid-groupview.js"></script>
<script type="text/javascript" src="<%=basePath%>js/json2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/swfobject.js"></script>
<script type="text/javascript" src="<%=basePath%>js/open_flash_chart.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ofc.js"></script>
<%-- <script type="text/javascript" src="<%=basePath%>js/export/export.js"></script> --%>

<!-- 自定义的style让同一div中的两个图片并排居中显示 -->
<!-- <style type="text/css">
   div {display:inline;}
</style> -->
  
</head>
<%-- <script type="text/javascript"  charset="UTF-8">
$(function() {     
    $("#btnOK").click(function() {     
        var jsondata = "";
    	$.ajax({     
            //要用post方式      
            type: "Post",     
            //方法所在页面和方法名      
            url: "<%=basePath%>returnChartJson/getJson.action",     
            contentType: "application/json; charset=utf-8", 
            async:false,
            success: function(data) {     
                //返回的数据用data.d获取内容      
            	jsondata = data;     
            }
        }); 
    	jsondata = encodeURI(encodeURI(jsondata));
    	alert(jsondata);
    	return jsondata;    
    });     
});

function getChartData8(){
	var jsondata = "";
	$.ajax({     
        //要用post方式      
        type: "Post",     
        //方法所在页面和方法名      
        url: "<%=basePath%>returnChartJson/getJson.action",     
        contentType: "application/json; charset=utf-8", 
        dataType:json,
        async:false,
        success: function(data) {     
            //返回的数据用data.d获取内容      
        	jsondata = data;     
        }
    });     
	jsondata = encodeURI(encodeURI(jsondata));
    return jsonData;  
}
</script> --%>
<body style="margin-left:10%;margin-right:10%">

<Form id="byTimeForm" class="easyui-form">
	<input type="button" id="btnOK" value="测试"></input>
	<!-- 将合同完成值以及完成百分比图并排居中显示 -->
    <div style="margin:20px 0; display:inline;border-collapse:collapse;padding:10px;" align="center" > 
        <table style="width:60%">
             <tr>
                <td id="contractTotalValueChart" >总体业务合同完成值图示</td>
                <td style="width:5%;"></td>
                <td id="contractTotalPercentChart">总体业务合同完成百分比图示</td>
             </tr>
        </table>
    </div>
    
    <!-- 测试用 -->
   <!-- <div id="OpenFlashChartContainer8"></div> -->
    
<script type="text/javascript">
	/* //测试横向柱状图
	swfobject.embedSWF("open-flash-chart.swf", "OpenFlashChartContainer8", "300", "250",  
	"9.0.0", "expressInstall.swf",{"get-data":"getChartData8",  
	     "id":"chart8",  
	     "save_image_message":"把图形保存为图片",  
	     "loading":"正在加载中..."}  
	 );  */

//2.显示总体业务合同完成目标百分比
  swfobject.embedSWF(
    		 "open-flash-chart-SimplifiedChinese.swf", 
    		 "contractTotalPercentChart", 
    		 "300", 
    		 "300",
    		 "9.0.0", 
    		 "expressInstall.swf",
    		 {"data-file":escape("returnChartJson/chart1.action?startTime=2016&endTime=01")},  
    			{wmode:"transparent"}
    		 ); 
     </script>
      <!-- <input type="button" name="btncopy" onclick="OFC.jquery.rasterize('BidsAndWinTotalInfoResultChart', 'ImagePanel');save_image();" value="生成图片" />  -->
</Form>
</body>
</html>