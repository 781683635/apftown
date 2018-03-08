var path = "";
$().ready(function() { 
	path = $("base").attr("href");
	// 提交时验证表单
	var validator = $("#pageForm").validate({
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
		    }
		}, 
		messages:{
			"ra.value":{
				required:"请输入您的姓名"
			},
		    "ra#1.value":{
		    	required:"请输入您的手机号码",
		    	isMobile:"请输入正确的手机号"
		    },
		    "ra#2.value":{
		    	required:"邮箱不能为空",
		    	email:"请输入正确的邮箱的格式"
		    }
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},
		submitHandler:function(){
			 subForm2();
		} 
	});
	jQuery.validator.addMethod("isMobile", function(value, element) {    
		var length = value.length;    
		return this.optional(element) || (length == 11 && testPhone(value));   }, "请正确填写您的手机号码。");
});



function subForm2(){
	
	var name=$("input[name='ra.value']").val();
	var moblie=$("input[name='ra#1.value']").val();
	var mail=$("input[name='ra#2.value']").val();
	var company=$("input[name='ra#3.value']").val();
	var job=$("input[name='ra#4.value']").val();
	
	var form = $('#pageForm').serialize();
	if(this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState<4){
		layer.alert("请稍候", {yes:function(ly){ layer.close(ly); } });
		return false;
	}
	this.ajaxRequest_ = $.ajax({
		cache : false,
		async : false,
		url : path + "xfm.do",
		type : "POST",
		data : form,
		dataType : 'json',
		success : function(aj) {
			var obj = aj.obj;
			if (obj != null) {
				var messages = "报名成功！   您已报名成功，工作人员将在2个工作日之内联系您！";
				layer.open({
					title : "提示",
					content : messages,
					btn : [ "确定" ],
					yes : function(ly) {
						window.parent.location.reload();
					}
				});
			} else {
				var messages = "报名失败";
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