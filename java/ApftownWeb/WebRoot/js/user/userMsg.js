var path = "", pageNum = 1, pageSize = 10, totalCount = 0, pageCount = 1, cardType = 1; 
$().ready(function() {
	path = $("base").attr("href");
	initPage();
});

function chkbox() {
	if ($("input[name='checkAll']").is(':checked')) {
		$(":checkbox").prop("checked", true);
	} else {
		$(":checkbox").prop("checked", false);
	}
}


function opt(ids,str) {
	if(isNull(ids)){
		var trid = $("input:checkbox:checked");
		for ( var i = 0; i < trid.length; i++) {
			ids += trid.eq([i]).parent().attr("msgid");
			if (i < (trid.length - 1))
				ids += ",";
		}
	}
	if (ids == null || ids == "") {
		var messages = "至少选择以下的一条数据！";
		layer.open({
			title : "提示",
			content : messages,
			btn : [ "确定" ],
			yes : function(ly) {
				$("input[name='checkbox']").focus();
				layer.close(ly);
			}
		});
	} else {
		updMsg(ids, str);
		window.location.reload(); 
	}
}

function updMsg(id, str) {
	$.ajax({
		url : path + "user/updateMsg.do",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			"str" : str,
			"id" : id
		},
		success : function(aj) {
			data = aj.attributes;
			
		}

	})
}



function set(a){
	 var title = $(a).parents(".passValue").find("td").eq(1).html();
	 var name = $(a).parents(".passValue").find("td").eq(2).html();
	 var content = $(a).html();
	 var time = $(a).parents(".passValue").find("td").eq(4).html();
	 console.log(title);
	 $("#msg_name").html(name);
	 $("#create_time").html(time);
	 $("#msg_content").html(content);
	 var ids = $(a).parents(".passValue").find("td").eq(0).attr("msgid");
	 updMsg(ids, "read");	
}

