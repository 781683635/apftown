var path = "", pageNum = 1, pageSize = 10, totalCount = 0, pageCount = 1, cardType = 1; 
$().ready(function() {
	path = $("base").attr("href");
	//querylist(cardType,pageNum, pageSize);
	initPage();
});

function upCInfo(id) {
	window.location.href = path + "user/upCompInfo.do?id=" + id;
}

function upComp(id, str) {
	$.ajax({
		url : path + "user/updateComp.do",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			"str" : str,
			"id" : id,
		},
		success : function(aj) {
			var obj = aj.msg;
			if (obj == '操作成功') {
				var messages = "操作成功";
				layer.open({
					title : "提示",
					content : messages,
					btn : [ "确定" ],
					yes : function(ly) {
						window.location.reload();
					}
				});
			} else {
				var messages = "操作失败";
				layer.open({
					title : "提示",
					content : messages,
					btn : [ "确定" ],
					yes : function(ly) {
						window.location.reload();
					}
				});
			}
			
		}

	})
}
/*//全选按钮的选中和取消事件
function chkbox() {
	if ($("input[name='chebox']").is(':checked')) {
		$(":checkbox").prop("checked", true);
	} else {
		$(":checkbox").prop("checked", false);
	}
}*/

/*function del() {
	var ids = "";
	var trid = $("input:checkbox:checked");
	for ( var i = 0; i < trid.length; i++) {
		ids += trid[i].parentNode.id;
		if (i < (trid.length - 1))
			ids += ",";
	}
	
	if (ids == null || ids == "") {
		var messages = "至少选择以下的一条数据！";
		layer.open({
			title : "提示",
			content : messages,
			btn : [ "确定" ],
			yes : function(ly) {
				$("input[name='chebox']").focus();
				layer.close(ly);
			}
		});
	} else {
		updRes(ids, "delete", cardType);
	}
}*/





