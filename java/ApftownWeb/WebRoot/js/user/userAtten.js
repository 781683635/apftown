var path = "", pageNum = 1, pageSize =2, totalCount = 0, pageCount = 1, cardType = 1; 
$().ready(function() {
	path = $("base").attr("href");
	querylist(cardType,pageNum,pageSize);
	
	/*var str2 = $("input[name='selectCode']").val();
	$("input[name='selectCode']").next().find("span").html($(".opt li[value='"+str2+"']").html());*/
});

function querylist(cardType,pageNum, pageSize) {
	$.ajax({
		url : path+"user/attenJson.do",
		type : "post",
		dataType : "json",
		async: false,
		data : {
			"pageNum" : pageNum,
			"pageSize" : pageSize
		},
		success : function(retdt){
			pageNum = retdt.attributes.pageNum;
			pageSize = retdt.attributes.pageSize;
			totalCount = retdt.attributes.totalCount;
			pageCount=Math.ceil(totalCount/pageSize);
			pageCount=(pageCount==0?1:pageCount);
			var tradelist=retdt.attributes.listMap;
			var listHtml = "";
			if(tradelist.length > 0){
				var gettpl = document.getElementById('commentDemo').innerHTML;   //获取jsp html模板
				listHtml = laytpl(gettpl).render(tradelist);// 插件赋值
			}else{
				listHtml = "<div class='col-xs-12 bg-white clear pt-20 pb-20 mt-10 text-center f-14'><img src='"+path+"/img/user/warning.png' class='img-20'><span class='dis-ib ml-10'>没有数据，请查看其它内容!</span></div>"
			}
			document.getElementById('commentlist').innerHTML = listHtml; //把值放在 commentliAst 里面
			
			$("#pageNum").val(pageNum);
			$("#pageSize").val(pageSize);
			$("#totalCount").val(totalCount);
			initPage();
			
		}
	})
	
	
}