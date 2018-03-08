var path = "";
$().ready(function() { 
	path = $("base").attr("href");
	// 提交时验证表单
	var validator = $("#subForm1").validate({
		rules: {
			"name":{
				required:true
			},
			"compName":{
			   required:true
		    },
		    "phone":{
			   required:true,
			   isMobile:true
		    },
		    "vdesc":{
		    	required:true,
		    }
		}, 
		messages:{
			"name":{
				required:"请输入姓名"
			},
			"compName":{
			   required:"请输入单位名称"
		    },
		    "phone":{
		    	required:"请输入手机号码"
		    },
		    "vdesc":{
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
	
	var para = $("#subForm1").val();
	
	console.log(para);
	
}





