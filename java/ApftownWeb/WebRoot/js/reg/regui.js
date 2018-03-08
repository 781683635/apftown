$().ready(function() {

	var path = $("base").attr("href");

	var validator = $("#regForm").validate({
		rules : {
			"userName" : {
				required : true,
				minlength : 4,
				maxlength : 20,
				remote : {
					url : path + "ckUserRepeat.do",
					type : "post",
					dataType : "json",
					data : {
						userName : function() {
							return $("#userName").val();
						}
					}
				}
			},
			"user_reg_email" : {
				required : true,
				/*isMobile : true,*/
				remote : {
					url : path + "checkEmail.do",
					type : "post",
					dataType : "json",
					data : {
						userRegMobile : function() {
							return $("#user_reg_email").val();
						}
					}
				}
			
			},
		
			"userPwd" : {
				required : true,
				minlength : 6,
				maxlength : 20
			},
			"userPwd2" : {
				required : true,
				equalTo : "#userPwd"
			},
			"imgCode" : {
				required : true,
				minlength : 4,
				maxlength : 4,
				remote : {
					url : path + "imgCode.do",
					type : "post",
					dataType : "json",
					data : {
						imgCode : function() {
							return $("#imgCode").val();
						}
					}
				}
			}
		},
		messages : {
			"userName" : {
				required : "请输入用户名",
				minlength : "用户名长度在4-20个字符之间",
				maxlength : "用户名长度在4-20个字符之间",
				remote : "该用户名已存在!"
			},
			"userPwd" : {
				required : "请输入密码",
				minlength : "密码长度在6-20个字符之间",
				maxlength : "密码长度在6-20个字符之间"
			},
			"userPwd2" : {
				required : "请再次输入密码",
				equalTo : "两次输入的密码不一致"
			},
			"imgCode" : {
				required : "请输入验证码",
				minlength : "请正确输入验证码",
				maxlength : "请正确输入验证码",
				remote : "请正确输入验证码"
			},
			"user_reg_email" : {
				required : "请输入手机号或邮箱",
				/*isMobile : "手机号码格式不正确",*/
				remote : "您输入的手机号/邮箱不正确或已注册!"
			}
		},errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
	jQuery.validator.addMethod("isMobile", function(value, element) {
		var length = value.length;
		return this.optional(element) || (length == 11 && testPhone(value));
	}, "请正确填写您的手机号码。");
});
