var path = "";


var layerbtn={
	no:function(data){
		layer.close(data);
	},
	yes:function(data){
		layer.close(data);
	}
};


$().ready(function() {
	path = $("base").attr("href");
	var validator = $("#FloginForm").validate({
		rules : {
			"userName" : {
				required : true,
				minlength : 3
			},
			"password" : {
				required : true,
				minlength : 6
			}
		},
		messages : {
			"userName" : {
				required : "请输入你的用户名或手机号",
				minlength : "用户名长度不能小于3"
			},
			"password" : {
				required : "请输入密码",
				minlength : "密码长度不能小于 6"
			}
		},errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},
		submitHandler : function() {
			login();
		}
	});
});

function login() {
	$("#login").attr("disabled", true);

	/*var rememberMe = "";
	if ($("#rememberMe").is(":checked")) {
		rememberMe = "1";
	} else {
		rememberMe = "0";
	}*/

	var formdata = $('#FloginForm').serialize();
	//console.log(formdata);
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
		url : path + "login.do",
		type : 'POST',
		cache : false,
		async : false,
		data : formdata,
		dataType : 'json',
		success : function(aj) {
			var code = aj.attributes.code;
			if (code == "0") {
				var targetUrl=$("#targetUrl").val();
				if(Nulls(targetUrl)!= "" ){
					window.location.href = targetUrl;
				}else{
					window.location.href = path+"loginFsuccess.do";
				}
			} else if (code == "-112") {
				var messages = "密码不匹配";
				layer.open({
					title:"提示",
					content:messages,
					btn:["确定"],
					yes:function(ly){
						$("#login").removeAttr("disabled");
						$("input[name='password']").val('');
						$("input[name='password']").focus();
						layer.close(ly);
					}
				});
			} else if (code == "-111") {
				var messages = "非法的用户名和密码";
				layer.open({
					title : "提示",
					content : messages,
					btn : [ "确定" ],
					yes : function(ly) {
						$("#login").removeAttr("disabled");
						$("input[name='password']").focus();
						layerbtn.yes(ly)
						layer.close(ly);
					},
					cancel: function(index, layero){ 
						layerbtn.no(index)
					}  
				});
			} else {
				var messages = "登录名重复,请与系统管理员联系";
				layer.open({
					title : "提示",
					content : messages,
					btn : [ "确定" ],
					yes : function(ly) {
						$("#login").removeAttr("disabled");
						layer.close(ly);
					}
				});
			}
		}
	});
}
