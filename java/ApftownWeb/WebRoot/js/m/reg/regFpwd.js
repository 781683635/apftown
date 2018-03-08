$().ready(function(){
var path=$("base").attr("href");
var validator = $("#regpwdFrom").validate({
	rules:{
		"regPwd":{
			required:true,
			minlength:6
			
		}
	},
	messages:{
		"regPwd":{
			required:"请输入密码",
			minlength:"最小输入6位密码"
		}
	},errorPlacement : function(error, element) {
		error.insertAfter(element.parent());
	},
	submitHandler:function(){
    	//alert("提交时间！");
		subxi();
    }
 });
});


function subxi(){
	var user_reg_email=$("#user_reg_email").val();
	var	userName=$("#userName").val();
	var	password=$("#regPwd").val();
	if(this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState<4){
		layer.alert("请稍候", {yes:function(ly){ layer.close(ly); } });
		return false;
	}
	if(user_reg_email!=null && user_reg_email!=""){
			this.ajaxRequest_ = $.ajax({
				cache : false,
				async : false,
				url : path + "/regFsub.do",
				type : "get",
				data : {
					"user_reg_email":user_reg_email,
					"password":password,
					},
				dataType : 'json',
				success : function(aj) {
					var msg=aj.msg;
					if(msg=="注册成功"){
						window.location.href =path+"regFsuccess.do";
					}else{
						window.location.href=path+"regFfail.do";
					}
				}
		});
			
	}else{
		
		/*if(this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState<4){
			layer.alert("请稍候", {yes:function(ly){ layer.close(ly); } });
			return false;
		}*/
		this.ajaxRequest_ = $.ajax({
			cache : false,
			async : false,
			url : path + "/regFlogin.do",
			type : "post",
			data : {
				"userName":userName,
				"password":password,
				},
			dataType : 'json',
			success : function(aj) {
				var code = aj.attributes.code;
				if (code == "0") {
					window.location.href =path+"loginFsuccess.do";
					
				} else if (code == "-112") {
					var messages = "密码不匹配";
					layer.open({
						title:"提示",
						content:messages,
						btn:["确定"],
						yes:function(ly){
							$("#regpwdFrom").removeAttr("disabled");
							$("input[name='regPwd']").val('');
							$("input[name='regPwd']").focus();
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
							$("#regpwdFrom").removeAttr("disabled");
							$("input[name='regPwd']").focus();
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
}