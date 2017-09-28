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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<title>商品管理软件</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery-easyui-1.4.4/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery-easyui-1.4.4/themes/icon.css" />
<script type="text/javascript"
	src="<%=basePath%>jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/openTab.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/base-loading.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>css/index/top.css" />
</head>

<body class="easyui-layout">
	<div id="header" region="north" split="false" border="false"
		style="height: 100px; overflow: hidden;">
		<div id="CenterAreaBg">
			<div id="Head1">
				<div id="Head1Right"></div>
			</div>
			<div id="Head2">
				<!--<c:if test="${hasFlag==false}">-->
					<div id="Head2_Awoke">
						<ul id="AwokeNum">
							<li><a href="<%=basePath%>flow/myTaskList" target="right">
									<img border="0" width="12" height="14"
									src="<%=basePath%>images/index/top/wait.gif" /> 待办事项（<span
									id="wait" class="taskListSize">1</span>）
							</a></li>

							<!-- 是否有待审批文档的提示2，提示审批 -->
							<li id="messageArea"><a href="javascript:void(0);"
								onclick="javascript:addTab1('<%=basePath%>flow/myTaskList','待我审批')">您有
									1 个待审批文档，请及时审批！★★★★★</a></li>
						</ul>
					</div>
				<!--</c:if>-->
				<div id="Head1Right">
					<div id="Head1Right_UserName">
						<img border="0" width="13" height="14"
							src="<%=basePath%>images/index/top/user.gif" /> 您好，<b>${baseUser.userName}</b>
						&nbsp; <a style="color: #0082DC"
							href="<%=basePath%>user/logout.action" ><b>安全退出</b></a>
					</div>
				</div>
			</div>
		</div>
		<form id="changeForm"
			action="http://10.74.0.15:8080/kh/uums/usermanager/login.action?formAction=loginByNewSys"
			method="post">
			<input type="hidden" name="j_username" value="${baseUser.userName }" />
		</form>
	</div>
	<div region="west" split="false" title="管理菜单"
		style="width: 170px; overflow: hidden;">
		<div class="easyui-accordion" fit="false" border="false"
			id="navigation" style="width: 170px;">
			<c:forEach items="${privileges}" var="one">
				<c:if test="${one.fmCategory==100 }">
					<div title="${one.fmName}">
						<ul style="" class="MenuLevel2">
							<c:forEach items="${privileges}" var="two">
								<c:if test="${one.fmId == two.fmCategory}">
									<li class="level2">
										<div class="level2Style">
											<a style="font: 14px;text-decoration:none" href="javascript:void(0);"
												onclick="javascript:addTab1('<%=basePath %>${two.fmAction}','${two.fmName }')">${two.fmName }</a>
										</div>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<div region="center" split="false" title="" style="overflow: hidden;">
		<div class="easyui-tabs" fit="true" border="false" id="workTabs">
			<div title="首页" style="padding: 0px;">
			
			
 <!-- <iframe src="<%=basePath%>reportFlow/works.action" style="border:0px;overflow:auto;width:100%;height:100%;"></iframe> -->               
            
            </div>
            
		</div>
	</div>
	<div align="center" region="south" split="false"
		style="overflow: hidden; height: 30px;">
		<div align="center" 
			title="Copyright© 2017-2018  梦想工作室&nbsp;&nbsp;兼容IE8以上版本，最佳分辨率1400x900"
			headerCls="titleCenter" collapsible="false" border="false">Copyright© 2017-2018  梦想工作室&nbsp;&nbsp;兼容IE8以上版本，最佳分辨率1400x900</div>
	</div>
</body>

<script type="text/javascript">
$(function(){
	$('#workTabs').tabs({
		onBeforeClose:function(title){
			if(title == '月报录入'){
				var titleArr = child.getMonRepObj();
				var count = 0;
				for(var i=0;i<titleArr.length;i++){
					if(/^\*/.exec(titleArr[i])){  
						count ++;
					}
				} 
				if(count > 0) {  //存在未保存的表
					$.messager.confirm('提示信息','有'+count+'个表尚未保存，确认关闭？',function(r){
						if(r){
							child.resetTabsMark();
						}else{
							return;
						}
					});
					return false;
				}
			}
			
			if(title == '季报录入'){
				var titleArr = quar.getQuarRepObj();
				var count = 0;
				for(var i=0;i<titleArr.length;i++){
					if(/^\*/.exec(titleArr[i])){  
						count ++;
					}
				} 
				if(count > 0) {  //存在未保存的表
					$.messager.confirm('提示信息','有'+count+'个表尚未保存，确认关闭？',function(r){
						if(r){
							quar.resetTabsMark();
						}else{
							return;
						}
					});
					return false;
				}
			}
			
		}
	});
	
});

function closeTab(title) {
	$("#workTabs").tabs('close', title);
}

function addTab1(href,title){
    if($("#workTabs").tabs("exists",title)){
        $("#workTabs").tabs('select',title);
    }else{
    	if(title == '月报录入'){
    		 $("#workTabs").tabs("add",{
    	            title:title,
    	            content:'<iframe src="'+href+'" name="child" style="border:0px;overflow:auto;width:100%;height:100%;"  noresize="noresize"></iframe>',
    	            closable:true
    	        });
    	}else if(title == '季报录入'){
    		 $("#workTabs").tabs("add",{
 	            title:title,
 	            content:'<iframe src="'+href+'" name="quar" style="border:0px;overflow:auto;width:100%;height:100%;"  noresize="noresize"></iframe>',
 	            closable:true
 	        });
    	}else{
   		 $("#workTabs").tabs("add",{
	            title:title,
	            content:'<iframe src="'+href+'" style="border:0px;overflow:auto;width:100%;height:100%;"  noresize="noresize"></iframe>',
	            closable:true
	        });
	    }
    } 
}

</script>
</html>