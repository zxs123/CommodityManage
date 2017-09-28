function addTab(url,title){
    if($("#workTabs").tabs("exists",title)){
        $("#workTabs").tabs('select',title);
    }else{
        $("#workTabs").tabs("add",{
            title:title,
            content:'<iframe src="'+url+'" style="border:0px;overflow:auto;width:100%;height:100%;"  noresize="noresize"></iframe>',
            closable:true
        });
    } 
}

function updateTab(url,reportId){
	var tab = $('#workTabs').tabs('select','待办已办');
	var url = '<%=basePath%>reportFlow/reportReview.action?reportId='+reportId;
	$('#workTabs').tabs('update',{
        tab: tab,
        options:{
            href: url
        }
    }); 
	tab.panel('refresh');
}