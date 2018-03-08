var path = "",pageNum = 1, pageSize = 2, totalCount = 0, pageCount = 1, cardType = 1;

$().ready(function() {
	path=$("base").attr("href");
	initPage();
	var str = $("input[name='catCentre']").val();
	$("input[name='catCentre']").next().find("span").html($("input[name='catCentre']").parent().find(".opt li[value='"+str+"']").html());
	var st = $("input[name='bkCentre']").val();
	$("input[name='bkCentre']").next().find("span").html($("input[name='bkCentre']").parent().find(".opt li[value='"+st+"']").html());
});

function changeCb(cat,bk){
	$("#pageNum").val("1");
	$("#pageForm").submit();
}

function updRes(id,top){
	/*var ids = "";
	var trid = $("input:checkbox:checked");
	for ( var i = 0; i < trid.length; i++) {
		ids += trid[i].parentNode.id;
		if (i < (trid.length - 1))
			ids += ",";
	}*/
	$.ajax({
		url : path + "user/zTop.do",
		type : "post",
		dataType : "json",
		async : false,
		data : {id:id},
		success : function(aj) {
			//console.log(aj);
			var messages = "置顶成功!";
			layer.open({
				title:"提示",
				content:messages,
				btn:["确定"],
				yes:function(){
					window.location.reload();
				}
			})
		}
	});
}
