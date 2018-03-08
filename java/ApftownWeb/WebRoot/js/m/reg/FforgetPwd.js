var path = "";
$().ready(function() {
    path = $("base").attr("href");
    $("#mobileform").validate({
        rules: {
            "userMobile": {
                required: true,
                minlength: 11,
                isMobile: true,
                remote: {
                    type: "post",
                    url: path + "existMoEm.do",
                    data: {
                        function() {
                            return $("#userMobile").val();
                        }
                    }
                }
            },
            "imgCode": {
                required: true,
                remote: {
                    type: "post",
                    url: path + "imgCode.do",
                    data: {
                        function(b1) {
                            return $("#imgCode").val();
                        }
                    }
                }
            },
            "smsCode": {
                required: true,
                minlength: 6,
                maxlength: 6,
                remote: {
                    url: path + "checkCaptcha.do",
                    type: "post",
                    data: {
                        smsCode: function() {
                            return $("#smsCode").val();
                        }
                    }
                }
            }
        },
        messages: {
            "userMobile": {
                required: "请输入手机号",
                minlength: "手机号必需由11个字符组成",
                isMobile: "手机号格式错误！",
                remote: "你的手机号未注册"
            },
            "imgCode": {
                required: "请输入验证码",
                remote: "验证码错误！"
            },
            "smsCode": {
                required: "请输入短信验证码",
                minlength: "请输入6位验证码",
                maxlength: "请输入6位验证码",
                remote: "短信验证码输入有误"
            }
        },errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}/*,
       submitHandler : function(form) {
        	sendMsgPre();
		}*/
    });
    jQuery.validator.addMethod("isMobile",
    function(value, element) {
        var length = value.length;
        return this.optional(element) || (length == 11 && testPhone(value));
    },
    "请正确填写您的手机号码。");
    
    /** email  **/
   $("#emailForm").validate({
        rules: {
            "userEmail": {
                required: true,
                email:true,
                remote: {
                    type: "post",
                    url: path + "existMoEm.do",
                    data: {
                        function() {
                            return $("#userEmail").val();
                        }
                    }
                }
            },
            "imgCode": {
                required: true,
                remote: {
                    type: "post",
                    url: path + "imgCode.do",
                    data: {
                        function(b1) {
                            return $("#imgCode").val();
                        }
                    }
                }
            }
        },
        messages: {
            "userEmail": {
                required: "请输入邮箱",
                required: "邮箱格式错误！",
                email: "你的邮箱未注册"
            },
            "imgCode": {
                required: "请输入验证码",
                remote: "验证码错误！"
            }
        },errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},submitHandler : function(form) {
			sendMailPre();
		}
    }); 
    
});
 function sendMailPre(){
	 var email=$("#userEmail").val();
	 var captcha=$("#emailForm input[name='imgCode']").val();
	 if(isNull(email) || !testEmail(email)){
	        layer.open({
	            title: "提示",
	            content: "请输入正确的邮箱",
	            btn: ["确定"],
	            yes: function(ly) {
	                layer.close(ly);
	                $("#Mail").focus();
	            }
	        })
	        return;
	    }else{
	    	sendEmail('','',email,captcha,'findpwd');
	    }
 }
function sendMsgPre() {
    var isMoblies = $("#userMobile").val();
    var imgCode = $("#imgCode").val();
    if (isNull(isMoblies) && !testPhone(isMoblies)) {
        layer.open({
            title: "提示",
            content: "请输入正确的手机号",
            btn: ["确定"],
            yes: function(ly) {
                layer.close(ly);
                $("#userMobile").focus();
            }
        })
        return;
    }
    if (isNull(imgCode) || checkTuCaptcha(imgCode) == false) {
        layer.open({
            title: "提示",
            content: "请输入正确的验证码",
            btn: ["确定"],
            yes: function(ly) {
                layer.close(ly);
                $("#imgCode").focus();
            }
        })
        return;
    }else{
    	
    	sendMessage(isMoblies, $("#imgCode").val(), "sendCode", null);
    }
}