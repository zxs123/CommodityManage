
	function checkData() {
		var GUIYDH = $.trim($("#GUIYDH").val());
		if (null == GUIYDH || "" == GUIYDH) {
			alert("请填写柜员代号！");
			$("#GUIYDH").focus();
			return false;
		}

	
		var QUANZH = $.trim($("#QUANZH").val());
		if (null == QUANZH || "" == QUANZH) {
			alert("请填写权重！");
			$("#QUANZH").focus();
			return false;
		}

		

		var KEHHAO = $.trim($("#KEHHAO").val());
		if (null == KEHHAO || "" == KEHHAO) {
			alert("请填写客户号！");
			$("#KEHHAO").focus();
			return false;
		}

		var relation = $.trim($("#relation").val());
		if (null == relation || "" == relation || relation == 0) {
			alert("请至少选择一个认领方式！！");
			$("#relation").focus();
			return false;
		}

		var custname = $.trim($("#custname").val());
		if (null == custname || "" == custname) {
			alert("请填写客户姓名！");
			$("#custname").focus();
			return false;
		}

		var workname = $.trim($("#workname").val());
		if (null == workname || "" == workname) {
			alert("请填写工作人员姓名！");
			$("#workname").focus();
			return false;
		}
	}