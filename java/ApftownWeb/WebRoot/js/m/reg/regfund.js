$().ready(function() {

	var path = $("base").attr("href");
	var validator = $("#regfundForm").validate({
		rules : {
			"user_reg_email" : {
				required : true,
				isMobile : true
			}
		},
	messages : {
		"user_reg_email" : {
			required : "请输入手机号",
			isMobile : "手机号码格式不正确"
			
		}
	},errorPlacement : function(error, element) {
		error.insertAfter(element.parent());
	},
	submitHandler:function(){
    	//alert("提交时间！");
		suphone();
    }
   });
	jQuery.validator.addMethod("isMobile", function(value, element) {
		var length = value.length;
		return this.optional(element) || (length == 11 && testPhone(value));
	}, "请正确填写您的手机号码。");
	});
	function suphone(){
	
		$("#regfund").attr("disabled", true);
		if(this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState<4){
			layer.alert("请稍候", {yes:function(ly){ layer.close(ly); } });
			return false;
		}
		user_reg_email=$("#user_reg_email").val();
		var para2 = $("#regfundForm").serialize();
		console.log(para2);
		
		this.ajaxRequest_ = $.ajax({
			cache : false,
			async : false,
			url : path + "/checkEmail.do",
			type : "get",
			data : para2,
			dataType : 'json',
			success : function(aj) {
				var i=aj;
				if(i==false){ 
					window.location.href=path+"regFpwd.do?userName="+user_reg_email;
					//window.location.href = path+"regCode.do?user_reg_mobile="+user_reg_email;
				}else{
					window.location.href=path+"regCode.do?user_reg_moblie="+user_reg_email;
				//window.location.href = path+"regCode.do?user_reg_mobile="+user_reg_email;
				}
			}
	});
}