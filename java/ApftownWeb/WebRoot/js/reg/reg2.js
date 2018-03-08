$().ready(function(){
var path=$("base").attr("href");
	
	var validator = $("#reg2").validate({
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
/*
function sendMail(){
   var uid=null;
   var uname=$("#uname").val();
   var Mail=$("#smsMail").val();
	$.ajax({
		url : path + "sendMail.do",
		type : 'POST',
		cache : false,
		async : false,
		dataType : 'json',
		data : {
			"regEmail":Mail,
			"uid":null,
			"act":"reg",
			"uname":uname
		},
		success:function(aj){
			var msg=aj.success;
			if(msg){
				layer.open({
					title:"发送成功",
					content:"邮件验证码发送成功，请在48小时内点击激活！",
					btn:["确定"],
					yes:function(ly){
						$("#eMail").removeAttr("disabled");
						$("input[name='smsMail']").val('');
						$("input[name='smsMail']").focus();
						layer.close(ly);
						window.location.href=path+"index.do";
					}
				});	
			}else{
				layer.open({
					title:"提示",
					content:"发送失败，请重新注册！",
					btn:["确定"],
					yes:function(ly){
						$("#eMail").removeAttr("disabled");
						$("input[name='smsMail']").val('');
						$("input[name='smsMail']").focus();
						layer.close(ly);
						window.location.href=path+"regui.do";
					}
				});	
			}
		}
	})
}*/