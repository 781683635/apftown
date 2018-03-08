 $().ready(function() {
	   var path=$("base").attr("href");
	   setResProp("0","code");
	  
	  
	   $("#newsaddForm").validate({
		   rules:{
			  "rl.title":{
				  required:true
			  },
			  "rl.title2":{ 
				  required:true,
				  minlength:5
			  },
			  "rl.vfrom":{
				  required:true
			  },
			  "rl.author":{
				  required:true
			  },
			  "r.keyword":{
				  required:true
			  },
			  "rl.vdesc":{
				  required:true
			  }
		   },
		   messages:{
			   "rl.title":{
					  required:"请输入标题"
				  },
				 "rl.title2":{
					  required:"请输入副标题",
					  minlength:"最小为5个汉字"
				  },
				  "rl.vfrom":{
					  required:"请输入来源"
				  },
				  "rl.author":{
					  required:"请输入作者"
				  },
				  "r.keyword":{
					  required:"请输入关键字"
				  },
				  "rl.vdesc":{
					  required:"请输入简述"
				  }
		   },errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
		   },
		   submitHandler:function(){
	        	//alert("提交时间！");
			   btnAction();
	        }
	   });
 });

function btnAction() {
	var code3 = $("#selectCode3").attr("value");
	var code2 = $("#selectCode2").attr("value");
	var code1 = $("#selectCode").attr("value");
	if (!isNull(code3)) {
		$("input[name='rpl.code']").val(code3);
	} else if (!isNull(code2)) {
		$("input[name='rpl.code']").val(code2);
	} else if (!isNull(code1)) {
		$("input[name='rpl.code']").val(code1);
	} else {
		var messages = "分类不能为空";
		layer.open({
			title : "提示",
			content : messages,
			btn : [ "确定" ],
			yes : function(ly) {
				$("input[name='rpl.code']").val('');
				$("input[name='rpl.code']").focus();
				layer.close(ly);
			}
		});
		return false;
	}

	var cartext1 = isNull(editor1) ? "" : editor1.getData("");
	if (!isNull(cartext1)) {
		$("#content1").val(cartext1);
	} else {
		var messages = "文本内容不能为空";
		layer.open({
			title : "提示",
			content : messages,
			btn : [ "确定" ],
			yes : function(ly) {
				$("input[name='rl.vtext']").val('');
				$("input[name='rl.vtext']").focus();
				layer.close(ly);
			}
		});
		return false;
	}

	var form = $('#newsaddForm').serialize();
		
	if(this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState<4){
		layer.alert("请稍候", {yes:function(ly){ layer.close(ly); } });
		return false;
	}
	this.ajaxRequest_ = $.ajax({
		url : path + "/xfm.do",
		type : 'POST',
		cache : false,
		async : false,
		data : form,
		dataType : 'json',
		success : function(aj) {
			var obj = aj.obj;
			if (obj != null) {
				var messages = "保存成功";
				layer.open({
					title : "提示",
					content : messages,
					btn : [ "确定" ],
					yes : function(ly) {
						window.location.href = path + "user/resList.do";
					}
				});
			} else {
				var messages = "添加失败";
				layer.open({
					title : "提示",
					content : messages,
					btn : [ "确定" ],
					yes : function(ly) {
						window.location.href = path + "user/resAdd.do";
					}
				});
			}

		}
	});
}