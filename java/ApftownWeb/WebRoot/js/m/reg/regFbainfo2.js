

$().ready(function(){
var path=$("base").attr("href");
	
	var validator = $("#regFbainfoForm").validate({
		rules:{
			"i.company_name":{
				required:true
			},
			"i.office_address":{
				required:true
			},
			"i.employees":{
				required:true,
				number:true
			},
			"i.zipcode":{
				required:true
			},
			"i.registecapital":{
				required:true,
				number:true
			},
			"i.paidcapital":{
				required:true,
				number:true
			},
			"i.managescale":{
				required:true,
				number:true
			},
			"i.firstcapital":{
				required:true,
				number:true
			}
		
		},
		messages:{
			"i.company_name":{
				required:"请输入公司名称"
			},
			"i.office_address":{
				required:"请输入实际办公地址"
			},
			"i.employees":{
				required:"请输入全职办公人数",
				number:"请输入数字"
			},
			"i.zipcode":{
				required:"请输入邮编"
			},
			"i.registecapital":{
				required:"请输入注册资本",
				number:"请输入数字"
			},
			"i.paidcapital":{
				required:"请输入实缴资本",
				number:"请输入数字"
			},
			"i.managescale":{
				required:"请输入管理规模",
				number:"请输入数字"
			},
			"i.firstcapital":{
				required:"请输入第一期到位",
				number:"请输入数字"
			}
		
		},errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},
		submitHandler : function() {
			bainfo();
		}
	});
	
});
	function bainfo(){
		var type_of_entity=$("input[name='i.type_of_entity']:checked").val();
		var fund_type= $("input[name='i.fund_type']:checked").val();
		var para2 = $("#regFbainfoForm").serialize();
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
							window.location.href=path+"/user/regFmaininfo.do";
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

