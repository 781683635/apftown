var path = "";
$().ready(function() { 
	path = $("base").attr("href");
	// 提交时验证表单
	var validator = $("#subForm2").validate({
		rules: {
			"ra.value":{
				required:true
			},
		    "ra#1.value":{
			   required:true,
			   isMobile:true
		    },
		    "ra#2.value":{
			   required:true,
				email:true
			    },
		    "ra#3.value":{
		    	required:true,
		    }
		}, 
		messages:{
			"ra.value":{
				required:"请输入您的姓名"
			},
		    "ra#1.value":{
		    	required:"请输入您的手机号码"
		    },
		    "ra#2.value":{
			   required:"请输入您的电子邮箱",
			   email:"您的电子邮箱错误！"
			    },
		    "ra#3.value":{
			   required:"请简单描述您的需求"
		    }
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},
		submitHandler:function(){
			 subForm2();
		}
	});
});
jQuery.validator.addMethod("isMobile", function(value, element) {    
	var length = value.length;    
	return this.optional(element) || (length == 11 && testPhone(value));   }, "请正确填写您的手机号码。");


	function subForm2(){
		var name = $("input[name='ra.value']").val();
		var mobile=$("input[name='ra#1.value']").val();
		var email= $("input[name='ra#2.value']").val();
		var remark=$("textarea[name='ra#3.value']").val();
		var para2 = $("#subForm2").serialize();
		
		console.log(para2);
		if(this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState<4){
			layer.alert("请稍候", {yes:function(ly){ layer.close(ly); } });
			return false;
		}
		this.ajaxRequest_ = $.ajax({
			cache : false,
			async : false,
			url : path + "xfm.do",
			type : "POST",
			data : para2,
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
							window.parent.location.reload();
						}
					});
				} else {
					var messages = "添加失败";
					layer.open({
						title : "提示",
						content : messages,
						btn : [ "确定" ],
						yes : function(ly) {
							window.parent.location.reload();
						}
					});
				}
	
			}
		});
	}





