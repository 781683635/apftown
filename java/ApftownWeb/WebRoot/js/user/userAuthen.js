var path = "";
$().ready(function() {
	path = $("base").attr("href");
	$("#setUMobileForm").validate({
		rules: {
        	"userRegMobile":{	
			   required:true,
			   isMobile:true,
			   remote : {
					url : path + "ckUserRepeat.do?",
					type : "post",
					dataType: "json",
					cache:false,
					data : {
						username : function() {
							return $("#userRegMobile").val();
						}
					}
				}
		    },
		    "imgCode" : {
				required : true,
				minlength: 4,
			    maxlength: 4,
			    remote : {
					url : path + "imgCode.do?",
					type : "post",
					dataType: "json",
					data : {
						username : function() {
							return $("#imgCode").val();
						}
					}
				}
			},
			"smsCode" : {
				required : true,
				minlength: 6,
			    maxlength: 6,
			    remote : {
					url : path + "checkCaptcha.do?",
					type : "post",
					dataType: "json",
					data : {
						username : function() {
							return $("#smsCode").val();
						}
					}
				}
			}
		}, 
		messages:{
		   "userRegMobile":{
		 	    required:"请输入手机号码",
		 	   isMobile:"请输入正确的手机号码",
				remote : "您输入的手机号码已存在"
		   },
		   "imgCode" : {
				required : "请输入图形验证码",
				minlength : "长度为4个字符",
				maxlength : "长度为4个字符",
				remote : "请输入正确的图形验证码"
			},
			"smsCode" : {
				required : "请再次输入短信验证码",
				minlength : "长度为6个字符",
				maxlength : "长度为6个字符",
				remote : "请输入正确的短信验证码"
			}
		},
		submitHandler:function(){
			setUMobile();
	    },
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
	//用于修改手机号
	$("#UpdateMobileForm").validate({
		rules: {
        	"userRegMobile":{	
			   required:true,
			   isMobile:true,
			   remote : {
					url : path + "ckUserRepeat.do?",
					type : "post",
					dataType: "json",
					cache:false,
					data : {
						username : function() {
							return $("#userRegMobile").val();
						}
					}
				}
		    },
		    "imgCode" : {
				required : true,
				minlength: 4,
			    maxlength: 4,
			    remote : {
					url : path + "imgCode.do?",
					type : "post",
					dataType: "json",
					data : {
						username : function() {
							return $("#imgCode").val();
						}
					}
				}
			},
			"smsCode" : {
				required : true,
				minlength: 6,
			    maxlength: 6,
			    remote : {
					url : path + "checkCaptcha.do?",
					type : "post",
					dataType: "json",
					data : {
						username : function() {
							return $("#smsCode").val();
						}
					}
				}
			}
		}, 
		messages:{
		   "userRegMobile":{
		 	    required:"请输入你要修改的手机号码",
		 	   isMobile:"请输入正确的手机号码",
				remote : "您输入的手机号码已被注册"
		   },
		   "imgCode" : {
				required : "请输入图形验证码",
				minlength : "长度为4个字符",
				maxlength : "长度为4个字符",
				remote : "请输入正确的图形验证码"
			},
			"smsCode" : {
				required : "请再次输入短信验证码",
				minlength : "长度为6个字符",
				maxlength : "长度为6个字符",
				remote : "请输入正确的短信验证码"
			}
		},
		submitHandler:function(){
			UpdateMobile();
	    },
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
	

	
	$("#setUserNameForm").validate({
		rules:{
			"userName":{
				required :true
			}
		},
		messages :{
			"userName" :{
				required : "用户名不能为空"
			}
		},
		 errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
		}
	});
	
	$("#userAuthenForm").validate({
		rules : {
			"oldPwd":{
				required :true,
				minlength:6,
				remote:{
				    url: path+"user/checkOldPwd.do",     // 后台处理程序
				    type: "post",               // 数据发送方式
				    dataType: "json",           // 接受数据格式
				    data: {                     // 要传递的数据
				    	"oldPwd": function() {
				            return $("#oldPwd").val();
				        }
				    }
				}
			},
			"resetPw" :{
				required :true,
				minlength:6
			},
			"resetsPw":{
				required :true,
				equalTo :"#resetPw"
			}
			
		},
		messages :{
			"oldPwd" :{
				required : "原密码不能为空",
				minlength : "密码最小长度为6",
				remote:"密码错误！请重新输入！"
			},
			"resetPw":{
				required :"新密码不能为空",
				minlength : "密码最小长度为6"
			},
			"resetsPw":{
				required : "确认密码不能为空",
				equalTo : "与新密码不一致"
			}
			
        },
		submitHandler : function(form) {
			updatepwd();
			
		},
        errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
	$("#setMoneyForm").validate({
		rules : {
			"oldmoPwd":{
				required :true,
				minlength:6,
				remote:{
				    url: path+"user/checkOldPwd.do",     // 后台处理程序
				    type: "post",               // 数据发送方式
				    dataType: "json",           // 接受数据格式
				    data: {                     // 要传递的数据
				    	"oldPwd": function() {
				            return $("#oldmoPwd").val();
				        }
				    }
				}
			},
			"newmoPwd" :{
				required :true,
				minlength:6
			},
			"newsmoPwd":{
				required :true,
				equalTo :"#newmoPwd"
			}
			
		},
		messages :{
			"oldmoPwd" :{
				required : "原资金密码不能为空",
				minlength : "密码最小长度为6",
				remote:"密码错误！请重新输入！"
			},
			"newmoPwd":{
				required :"新密码不能为空",
				minlength : "密码最小长度为6"
			},
			"newsmoPwd":{
				required : "确认密码不能为空",
				equalTo : "与新密码不一致"
			}
			
        },
		submitHandler : function(form) {
			updatepwd();
			
		},
        errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
	
	
	$("#setEmailForm").validate({
		rules : {
			"userRegEmail" :{
				required :true,
				email:true,
				remote:{
				    url: path+"ckUserRepeat.do",     // 后台处理程序
				    type: "post",               // 数据发送方式
				    dataType: "json",           // 接受数据格式
				    data: {                     // 要传递的数据
				    	"userRegEmail": function() {
				            return $("#userRegEmail").val();
				        }
				    }
				}
			}
		},
		messages :{
			"userRegEmail":{
				required :"新密码不能为空",
				email : "请输入正确的邮箱",
				remote : "邮箱已存在"
			}			
        },
		submitHandler : function(form) {
			updateEmail();
		},
        errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
	

	 jQuery.validator.addMethod("isMobile",
			 function(value, element) {
		 var length = value.length;
		 return this.optional(element) || (length == 11 && testPhone(value));
	 },
	 "请正确填写您的手机号码。");
	 
});

	//绑定手机号
	function setUMobile(){
		$("#setUMobile").attr("disabled", true);
		var formdata = $('#setUMobileForm').serialize();
		formdata += "&type=usMobile";
		setUinfo(formdata);
	}
	//修改手机号
	function UpdateMobile(){
	//	$("#upMoblie").attr("disabled", true);
		var formdata = $('#UpdateMobileForm').serialize();
		console.log(formdata);
		formdata += "&type=usMobile";
		setUinfo(formdata);
	}
	function updateEmail(){
		
		
		sendEmail('','',$("#userRegEmail").val(),'','bind');
	}

	function updatepwd() {
		$("#updatePwd").attr("disabled", true);
		var formdata = $('#userAuthenForm').serialize();
	
		// 防止重复提交,顺便把提交按钮禁用
		if (this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState < 4) {
			layer.alert("请稍后", {
				yes : function(ly) {
					layer.close(ly);
				}
			})
			return false;
		}
		this.ajaxRequest_ = $.ajax({
			url : path + "/user/updateuserpwd.do",
			type : 'POST',
			cache : false,
			async : false,
			data : formdata,
			dataType : 'json',
			success : function(aj) {
				console.log(aj);
				var i = aj.obj;
				console.log(i);
				if (i == 1) {
					var messages = "修改密码成功!";
					layer.open({
						title : "提示",
						content : messages,
						btn : [ "确定" ],
						yes : function() {
							window.location.href = path + "user/userAuthen.do";
						}
					});
				} else {
					var messages = "修改失败";
					layer.open({
						title : "提示",
						content : messages,
						btn : [ "确定" ],
						yes : function() {
							window.location.href = path + "user/userAuthen.do";
						}
					});
				}
			}
			});
		}
function sendMsgPre() {
	var userRegMobile =$("#userRegMobile").val();
    var imgCode = $("#imgCode").val();
    sendMessage(userRegMobile, imgCode, "getSmsCode", null);
}
   function setUImg(imgUrl){
	  // var imgUrl=$("input[name='userImg']").val();
	  var dataform="&type=usImg&userImg="+imgUrl;
	  setUinfo(dataform);
   }   
    function setUinfo(dataform){
	this.ajaxRequest_ = $.ajax({
	    	url : path + "/user/setUserInfo.do",
	    	type : 'POST',
			cache : false,
			async : false,
			data : dataform,
			dataType : 'json',
			success : function(aj) {
				console.log(aj);
				if("0"==aj.msg){
					var messages = "设置成功!";
					layer.open({
						title : "提示",
						content : messages,
						btn : [ "确定" ],
						yes : function() {
							window.location.href = path + "user/userAuthen.do";
						}
					});	
				} else {
					var messages = "设置失败";
					layer.open({
						title : "提示",
						content : messages,
						btn : [ "确定" ],
						yes : function() {
							window.location.href = path + "user/userAuthen.do";
						}
					});
				}
			}
	});
   }
    /**
     * 发送短信验证码
     */
    function sendMsgPre2() {
        var isMoblies = $("#userRegMobile2").val();
        var imgCode = $("#imgCode2").val();
        if (isNull(isMoblies) && !testPhone(isMoblies)) {
            layer.open({
                title: "提示",
                content: "请输入正确的手机号",
                btn: ["确定"],
                yes: function(ly) {
                    layer.close(ly);
                    $("#userRegMobile").focus();
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
                    $("#imgCode2").focus();
                }
            })
            return;
        }else{
        	
        	sendMessage(isMoblies, $("#imgCode2").val(), "sendCode", null);
        }
    }     
    function setUPwd(){
		var passUwd=$("#passUpwd").val();
		
		if(passUwd.length>0){
			$.ajax({
		    	url : path + "user/passwd.do",
		    	type : 'POST',
				cache : false,
				async : false,
				data : {"passUpwd":passUwd},
				dataType : 'json',
				success:function(aj){
					var i=aj.obj;
					if(i==1){
		                $(".modal-email-content").hide();
		                $(".modal-email-content").eq(1).show();
					}else{
						var messages = "密码不正确，请重新输入！";
						layer.open({
							title:"提示",
							content:messages,
							btn:["确定"],
							yes:function(ly){
								$("#passUpwd").removeAttr("disabled");
								$("input[name='passUpwd']").val('');
								$("input[name='passUpwd']").focus();
								layer.close(ly);
								/*$(".emailnext-v1").click(function(){
									$(".modal-email-content").hide();
									$(".modal-email-content").eq(1).show();
								});*/
							}
						});
					}
				}
			});
		}
	}
    
    function seteMail(){
		var eMail=$("#eMail").val();
		var i=testEmail(eMail);
		if(!testEmail(eMail)){
			var messages = "邮箱格式不正确，请重新输入！";
			layer.open({
				title:"提示",
				content:messages,
				btn:["确定"],
				yes:function(ly){
					$("#eMail").removeAttr("disabled");
					$("input[name='eMail']").val('');
					$("input[name='eMail']").focus();
					layer.close(ly);
					$(".modal-email-content").hide();
	                $(".modal-email-content").eq(1).show();
					
				}
			});	
		}else{
		var uid=$("#uid").val();
		
			if(eMail.length>0){
				$.ajax({
			    	url : path + "sendMail.do",
			    	type : 'POST',
					cache : false,
					async : false,
					dataType : 'json',
					data : {
						"regEmail":eMail,
						"uid":uid,
						"act":"bind",
						"uname":""
						},
					
					success:function(aj){
						console.log(aj);
						var msg=aj.success;
						if(msg){
							layer.open({
								title:"发送成功",
								content:"邮件验证码发送成功，请在48小时内点击激活！",
								btn:["确定"],
								yes:function(ly){
									$("#eMail").removeAttr("disabled");
									$("input[name='eMail']").val('');
									$("input[name='eMail']").focus();
									layer.close(ly);
									$(".modal-email-content").hide();
					                $(".modal-email-content").eq(2).show();
									
								}
							});	
						}else{
							layer.open({
								title:"提示",
								content:"发送失败，请重新操作！",
								btn:["确定"],
								yes:function(ly){
									$("#eMail").removeAttr("disabled");
									$("input[name='eMail']").val('');
									$("input[name='eMail']").focus();
									layer.close(ly);
									$(".modal-email-content").hide();
					                $(".modal-email-content").eq(1).show();
								}
							});	
						}
					
					
				}
			});
		}
	}	
   }