var path = "";
$().ready(function() { 
	path = $("base").attr("href");
	// 提交时验证表单
	var validator = $("#subForm1").validate({
		rules: {
			"name":{
				required:true
			},
		    "mobile":{
			   required:true,
			   isMobile:true
		    },
		    "remark":{
		    	required:true,
		    }
		}, 
		messages:{
			"name":{
				required:"请输入您的姓名"
			},
		    "mobile":{
		    	required:"请输入您的手机号码"
		    },
		    "remark":{
			   required:"请简单描述您的需求"
		    }
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},
		submitHandler:function(){
			 subForm1();
		} 
	});
});
jQuery.validator.addMethod("isMobile", function(value, element) {    
    var length = value.length;    
    return this.optional(element) || (length == 11 && testPhone(value));   }, "请正确填写您的手机号码。");


function subForm1(){
	
	var name=$("#name").val();
	
	
	var catId = $("#catId").val();
	var para = $("#subForm1").serialize();
	
	
	if(this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState<4){
		layer.alert("请稍候", {yes:function(ly){ layer.close(ly); } });
		return false;
	}
	this.ajaxRequest_ = $.ajax({
		url : path + "/subData.do",
		type : "POST",
		data : {"data": para},
		dataType : 'json',
		success : function(aj) {
			var obj = aj.obj;
			if (obj != null) {
				var messages = "报名成功！   您已提交成功，工作人员将在2个工作日之内联系您！";
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





