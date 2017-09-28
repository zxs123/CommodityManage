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
	<meta charset="UTF-8">
	<title>CheckBox Tree - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4.4/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4.4/themes/icon.css">
	<script type="text/javascript" src="../jquery-easyui-1.4.4/jquery.min.js"></script>
	<script type="text/javascript" src="../jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">
    function changeF()  
    {  
       document.getElementById('makeupCo').value=  
       document.getElementById('makeupCoSe').options[document.getElementById('makeupCoSe').selectedIndex].value;  
    }  
</script>  
<body>
	<h2>CheckBox Tree</h2>
	<p>Tree nodes with check boxes.</p>
	<div style="margin:20px 0;">
		<a href="#" class="easyui-linkbutton" onclick="getChecked()">GetChecked</a> 
	</div>
	<div style="margin:10px 0">
		<input type="checkbox" checked onchange="$('#tt').tree({cascadeCheck:$(this).is(':checked')})">CascadeCheck 
		<input type="checkbox" onchange="$('#tt').tree({onlyLeafCheck:$(this).is(':checked')})">OnlyLeafCheck
	</div>
	<div class="easyui-panel" style="padding:5px">
		<ul id="tt" class="easyui-tree" data-options="url:'<%=basePath%>systemManage/getJson.action',method:'post',animate:true,checkbox:true"></ul>
	</div>
	
	
  
  <div>
<span style="position:absolute;border:1pt solid #c1c1c1;overflow:hidden;width:188px;  
    height:19px;clip:rect(-1px 190px 190px 170px);">  
<select name="makeupCoSe" id="makeupCoSe" style="width:190px;height:20px;margin:-2px;" onChange="changeF();">  
    <option id='1' value='java'>java</option>  
    <option id='2' value='c++'>c++</option>  
    <option id='3' value='python'>python</option>  
    <OPTION id="99999" VALUE="" SELECTED>  
</select>  
</span>  
<span style="position:absolute;border-top:1pt solid #c1c1c1;border-left:1pt   
    solid #c1c1c1;border-bottom:1pt solid #c1c1c1;width:170px;height:19px;">  
    <input type="text" name="makeupCo" id="makeupCo" value="请选择或输入" style="width:170px;height:15px;border:0pt;">  
</span>  
</div>
	<script type="text/javascript">
		function getChecked(){
			var nodes = $('#tt').tree('getChecked');
			var s = '';
			for(var i=0; i<nodes.length; i++){
				if (s != '') s += ',';
				s += nodes[i].text;
			}
			alert(s);
		}
	</script>
</body>
</html>