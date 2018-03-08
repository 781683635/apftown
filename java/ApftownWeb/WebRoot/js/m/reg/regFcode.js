$().ready(function(){
var path=$("base").attr("href");
	
	var validator = $("#regcodeForm").validate({
		rules:{
			"smsCode":{
				required:true,
				minlength:6,
				maxlength:6,
				remote:{
					url:path + "checkCaptcha.do",
					type:"post",
					data:{
						smsCode:function() {
							return $("#smsCode").val();
						}
					}
				}
			}
		},
		messages:{
			"smsCode":{
				required:"请输入短信验证码",
				minlength:"请输入6位验证码",
				maxlength:"请输入6位验证码",
				remote:"短信验证码输入有误"
			}
		},errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
	 
});