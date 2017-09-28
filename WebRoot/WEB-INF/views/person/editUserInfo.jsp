<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<title>修改个人信息</title>
    <script language="javascript" src="<%= basePath %>js/common/jquery.js"></script>
    <script language="javascript" src="<%=basePath %>js/base-loading.js"></script>
    <script language="javascript" src="<%= basePath %>js/common/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="<%= basePath %>js/common/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="<%= basePath %>js/common/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="<%= basePath %>js/common/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="<%= basePath %>css/common/pageCommon.css" />
    <link type="text/css" rel="stylesheet" href="<%= basePath %>css/common/style.css" />
    <script language="javascript" src="<%= basePath %>js/common/iOnt47/iOnt-mymin.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var result = '${result}';
		if("success" == result) {
			alert("修改成功");
			location.href = "<%=basePath %>manage/initEditUserInfo";
		} else if("error" == result) {
			alert("修改失败");
		}
		
		var pictureUrl = '${user.imageUrl}';
		if(null != pictureUrl && "" != pictureUrl) {
			$("#wjtp ul").empty();
			$("#wjtp ul").append("<li><input type=hidden id='pictureUrl' name='pictureUrl' value='" + pictureUrl +"'/><img width=180 height=180 src='" + pictureUrl +"' /><span class=\"sublh_bq\"><em class=\"fr1\"><a href='#' onclick=\"delPic()\">删除</a></em></span></li>");
		}
		
		var editor = KindEditor.create('textarea[name="detail"]', {
			uploadJson : '<%=basePath%>templet/editor_upload_gate/shop${baseShop.shopId}',
			width : '100%',
			height : '300',
			items: [
				'undo', 'redo', '|', 'justifyleft', 'justifycenter', 'justifyright',
				'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
				'superscript', '|',
				'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
				'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|',
				'image',
				'table', 'hr', 'emoticons','|', 'clearhtml', 'selectall',  'fullscreen',
			],
			allowFlashUpload : false,
			allowMediaUpload : false,
			allowFileUpload : true,
		});
	});

	KindEditor.ready(function(K) {
		var uploadeditor = K.editor({
			uploadJson : '<%=basePath%>manage/editPerson/personImage',
			allowFileManager : true
		});

		K('#image3').click(function() {
			uploadeditor.loadPlugin('image', function() {
				uploadeditor.plugin.imageDialog({
					showRemote : false,
					clickFn : function(url, title, width, height, border, align) {
						$("#wjtp ul").empty();
						$("#wjtp ul").append("<li><input type=hidden id='pictureUrl' name='pictureUrl' value='" + url +"'/><img width=180 height=180 src='" + url +"' /><span class=\"sublh_bq\"><em class=\"fr1\"><a href='#' onclick=\"delPic()\">删除</a></em></span></li>");
						uploadeditor.hideDialog();
					}
				});
			});
		});
	});
	
	function delPic() {
		$("#wjtp ul").empty();
	}
	</script>
</head>
<body style="overflow-x: hidden;">

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="<%= basePath %>images/common/title_arrow.gif"/> 个人信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
   <form id="searchForm" method="post" action="<%=basePath %>manage/editPersonalInfo">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
            <IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="../style/blue/images/item_point.gif" /> 个人信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="150">用户ID（登录名）</td>
                        <td>${user.loginName}</td>
                        <td rowspan="5" align="right">
                            	<div id="wjtp" class="sublh_2tb" style="margin-top:20px;">
									<ul></ul>
									<div class="clearfix"></div>
								</div>
                        </td>
                    </tr>
                     <tr>
                        <td>姓名</td>
                        <td>${user.name}</td>
                    </tr>
                    
                     <tr>
                        <td>性别</td>
                        <td>${user.gender}</td>
                    </tr>
                    
                    <tr>
                        <td>移动电话</td>
                        <td>${user.phoneNumber}</td>
                    </tr>
                    <tr>
                        <td>部门</td>
                        <td>${user.department.name}</td>
                    </tr>
                    
                    <tr>
                        <td>职务</td>
                        <td>${user.position.positionName}</td>
                    </tr>
                    
                     <tr>
                        <td>邮箱</td>
                        <td>${user.email}</td>
                    </tr>
                    
                    <tr>
                        <td>角色</td>
                        <td>
                        <c:forEach items="${user.roles}" var="role">
                        	${role.name} &nbsp;
                        </c:forEach>
                        	<!-- 项目经理 &nbsp; 系统管理员 -->
                        </td>
                    </tr>
                   
                    <tr>
                        <td>头像</td>
                       		<td> 
							<span class="sub_ip" style="width:360px;"><input type="button" id="image3"  class="text_an" value="上传图片" style="width:80px;height:30px;" /></span>
							</td>								
                    </tr>
                </table>
            </div>
        </div>
       
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="<%= basePath %>images/common/save.png"/>
            <a href="javascript:history.go(-1);"><img src="<%= basePath %>images/common/goBack.png"/></a>
        </div>
    </form>
</div>

<div style="display:none;">
		<textarea rows="1" cols="1" name="detail"></textarea>
	</div>
	
<div class="Description">
    验证规则：<br />
    1，可以修改自已的头像，在右侧是头像的预览。<br />
</div>

</body>
</html>
