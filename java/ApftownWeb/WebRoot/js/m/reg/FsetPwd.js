var path = "";
$().ready(function() {
	path = $("base").attr("href");
	$("#setPwdForm").validate({
		rules : {
			"newpassword" : {
				required : true,
				minlength : 6,
				maxlength : 12
			},
			"newpassword2" : {
				required : true,
				equalTo : "#newpassword"
			}
		},
		messages : {
			"newpassword" : {
				required : "请输入重置密码",
				minlength : "密码必需由6个字符组成",
				maxlength : "密码最大为12个字符组成"
			},
			"newpassword2" : {
				required : "请再次输入密码",
				equalTo : "密码输入不一致！"
			}
		},errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},
		submitHandler : function(form) {
			updatepwd();
		}
	});
});

function updatepwd() {
	$("#findpwdbtn").attr("disabled", true);
	var formdata = $('#setPwdForm').serialize();

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
		url : path + "updatePwd.do",
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
				var messages = "修改密码成功！请去登录！";
				layer.open({
					title : "提示",
					content : messages,
					btn : [ "确定" ],
					yes : function() {
						window.location.href = path + "regFphone.do";
					}
				});
			} else {
				var messages = "修改失败";
				layer.open({
					title : "提示",
					content : messages,
					btn : [ "确定" ],
					yes : function() {
						window.location.href = path + "forgetFpwd.do";
					}
				});
			}
		}
	});
}