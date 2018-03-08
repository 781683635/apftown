var path = "",pageNum = 1, pageSize = 2, totalCount = 0, pageCount = 1, cardType = 1;

$().ready(function() {
	path=$("base").attr("href");
	initPage();	
	var str = $("input[name='status']").val();
	$("input[name='status']").next().find("span").html($("input[name='status']").parent().find(".opt li[value='"+str+"']").html());
	 $("#updaRemarkForm").validate({
			rules : {
				"upremark":{
					required :true
				},
			},
			messages :{
				"upremark" :{
					required : "备注不能为空"
				},
	        },
	        errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
			},
		  	submitHandler:function(form){
		        	//alert("提交时间！");
				  upremark();
	        }
		});
});

function upShow(remark,id){
	$("#remarkId").val(id);
	show(remark);
}

 function updRes(status,id){
	 $.ajax({
			url : path + "user/upStuatus.do",
			type : "post",
			dataType : "json",
			async : false,
			data : {
				"status" : status,
				"id" : id
			},
			success : function(aj) {
				aj.msg="操作成功";
				var messages = "操作成功";
				layer.open({
					title : "提示",
					content : messages,
					btn : [ "确定" ],
					yes : function(ly) {
						$("#res_id").removeAttr("disabled");
						layer.close(ly);
						window.location.href = path+"/user/dataList.do";
					}
				});
			}

		});
 }
	  function upremark(){
		  var id=$("#remarkId").val();
		  var remark = $("#upremark").val();
		  $.ajax({
				url : path + "user/upRemark.do",
				type : "post",
				dataType : "json",
				async : false,
				data : {
					"id" : id,
					"remark":remark
				},
				success : function(aj) {
					aj.msg="操作成功";
					var messages = "操作成功";
					layer.open({
						title : "提示",
						content : messages,
						btn : [ "确定" ],
						yes : function(ly) {
							$("#remarkId").removeAttr("disabled");
							layer.close(ly);
							window.location.href = path+"/user/dataList.do";
						}
					});
				}

			});
	  }