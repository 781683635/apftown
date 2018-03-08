$().ready(function(){
var path=$("base").attr("href");
	
	var validator = $("#regFmainForm").validate({
		rules:{
			"i.contact_person":{
				required:true
			},
			"i.contact_phone":{
				required:true,
				isMobile : true
			},
			"i.contact_email":{
				required:true,
				email:true
			},
			"i.duties":{
				required:true
			}
		},
		messages:{
			"i.contact_person":{
				required:"请输入联系人姓名"
			},
			"i.contact_phone":{
				required:"请输入联系人手机号",
				isMobile: "请输入正确的手机号"
			},
			"i.contact_email":{
				required:"请输入联系人邮件",
				email:"邮箱格式不对"
			},
			"i.duties":{
				required:"请输入联系人职位"
			}
		},errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},
		submitHandler:function(){
			 mainfo();
		}
	});
	jQuery.validator.addMethod("isMobile", function(value, element) {
		var length = value.length;
		return this.optional(element) || (length == 11 && testPhone(value));
	}, "请正确填写您的手机号码。");
});

 	function mainfo(){
 		var contact_person = $("input[name='i.contact_person']").val();
		var contact_phone=$("input[name='i.contact_phone']").val();
		var contact_emai= $("input[name='i.contact_email']").val();
		var duties=$("input[name='i.duties']").val();
		var para2 = $("#regFmainForm").serialize();
		console.log(para2);
		
		if(this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState<4){
			layer.alert("请稍候", {yes:function(ly){ layer.close(ly); } });
			return false;
		}
		this.ajaxRequest_ = $.ajax({
			cache : false,
			async : false,
			url : path + "xfm.do",
			type : "POST",
			data : para2,
			dataType : 'json',
			success : function(aj) {
				var obj = aj.obj;
				if (obj != null) {
					var messages = "保存成功";
					layer.open({
						title : "提示",
						content : messages,
						btn : [ "确定" ],
						yes : function(ly) {
							window.location.href=path+"regFshare.do";
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

