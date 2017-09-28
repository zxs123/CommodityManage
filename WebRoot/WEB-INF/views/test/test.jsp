<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../jquery-easyui-1.4.4/jquery.min.js"></script>
<title>成功提示</title>
<script>
$("#tags").keyup(function(){
    //取名称
    var n = $(this).val();
    if(n!=""){//判断输入框里是否为空
        //调AJAX
        $.ajax({
        	type: 'post' ,
			url: flag=='add'?'<%=basePath%>commodityManage/testReserch.action':'<%=basePath%>commodityManage/updateMarque.action' ,
			cache:false ,
			data:$('#myform').serialize() ,
			dataType:'json' ,
			success:function(result){
				str = str+"<div class='l'>"+sz[i]+"</div>";
				/* var sz = data.split("|");
                var str = ""; */
                /* for(var i=0;i<sz.length;i++){
                    str = str+"<div class='l'>"+sz[i]+"</div>";
                    
                    }
                    $("#list").html(str); */
                }
          });    
        }else{
            $("#list").html("");
            }
    });
</script>
</head>
<body>
	<div class="ui-widget">
		<label for="tags">标签：</label> <input id="tags">
	</div>
</body>
</html>