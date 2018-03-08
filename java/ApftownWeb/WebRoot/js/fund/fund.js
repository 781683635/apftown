var path = "", pageNum = 1, pageSize = 2, totalCount = 0, pageCount = 1, cardType = 1;

$().ready(function() {
	path=$("base").attr("href");
	propCode =$("#propCode").val();
	initPage();
	
	var propName = $(".cur-list").text();
	$(".propName").text(propName);
	
});

function changeCode(code){
	$("#propCode").val(code);
	$("#pageNum").val("1");
	$("#pageForm").submit();
}

