//获取分页的页数

//初始化分页html代码

//查询查询提交
function searchData(pageNum,totalPageNum){
	if(pageNum>=1&&pageNum<=totalPageNum){
		if(pageNum!=parseInt($("#pageNum").val())){
			$("#pageNum").val(pageNum);
			$("input[name='pageNum']").val(pageNum);
				if(typeof querylist === "function"){ 
					querylist(cardType,pageNum, pageSize); 
				}else if($("#pageForm").length>0){ 
					$("#pageForm").submit();
				}else if(typeof queryInfo === "function"){ 
					queryInfo(demoS, lstIdS, clS, tbS, stS, pageNum, 8); 
				}
		}
	}
	
}
function GOsearchData(data,totalPageNum){
	var ipt = $(data).parent().prev().find(".pagination_ipt input").val();
	if(ipt<=totalPageNum){
		 searchData(ipt,totalPageNum);
	}
}


function GOsearchData(data,totalPageNum){
	var ipt = $(data).parent().prev().find(".pagination_ipt input").val();
	if(ipt<=totalPageNum){
		 searchData(ipt,totalPageNum);
	}
}


//初始化分页数据
function initPage(){
	var pageNum = parseInt($("#pageNum").val());
	//获取总记录数
	var totalCount = parseInt($("#totalCount").val());
	var tt = $("#totalCount").val();
	//获取每页的显示
	var perPageCount = parseInt($("#pageSize").val());
	//计算出来一共有多少页
	var totalPageNum = Math.ceil(totalCount/perPageCount);// +totalCount%perPageCount == 0 ?0:1;
	
	var pageHtml = "";
	//如果页数少于5页的处理方式
	if(totalCount>perPageCount){
		var lgPage = ("第一页");
		var lgLastPage = ("最后一页");
		
		var upper = "", down = "";
		if(pageNum==1)
			upper = "disab";
		if(pageNum == totalPageNum)
			down = "disab";
			
		pageHtml += '<div align="center" class="pull-left full-w text-center mt-10 mb-10">'+
						'<div class="inline-block">'+
							'<ul class="pagination">';
		
		
		pageHtml += '<li><a href="javascript:;" onclick="searchData('+(1)+','+(totalPageNum)+')" tittle="'+lgPage+'" class="pagination_first icon-step-backward col-primary '+upper+'"></a></li>'+
				  	'<li><a href="javascript:;" onclick="searchData('+(pageNum-1)+','+(totalPageNum)+')" class="pagination_prev icon-caret-left  text-center col-primary '+upper+'"></a></li>'+
				  	'<li><a href="javascript:;" class="pagination_pagenum">'+pageNum+'/'+totalPageNum+'</a></li>'+
				  	'<li id="go-num"><a href="javascript:;" class="pagination_ipt"><input class="ipt-text go-num pull-left" type="text" onkeyup="this.value=this.value.replace(/[^\\d.]/g,\'\')"></a></li>'+
				  	'<li><a class="go" href="javascript:;" onclick="GOsearchData(this,'+totalPageNum+')">GO</a></li>'+
				  	'<li><a href="javascript:;" onclick="searchData('+(pageNum+1)+','+(totalPageNum)+')" class="pagination_next icon-caret-right col-primary '+down+'"></a></li>'+
				  	'<li><a href="javascript:;" onclick="searchData('+(totalPageNum)+','+(totalPageNum)+')" tittle="'+lgLastPage+'" class="pagination_last icon-step-forward col-primary '+down+'"></a></li>';		
	
			
		pageHtml += '</ul> </div> </div>';
	}

	//生成分页
	$(".pageHtml").html(pageHtml);
}