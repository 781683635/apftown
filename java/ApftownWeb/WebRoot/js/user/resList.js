var path = "", pageNum = 1, pageSize = 10, totalCount = 0, pageCount = 1, cardType = 1; 
$().ready(function() {
	path = $("base").attr("href");
	//querylist(cardType,pageNum, pageSize);
	initPage();
	
	var str = $("input[name='status']").val();
	$("input[name='status']").next().find("span").html($(".opt li[value='"+str+"']").html());
	
	var str2 = $("input[name='code']").val();
	$("input[name='code']").next().find("span").html($(".opt li[value='"+str2+"']").html());
});

/*function querylist(cardType,pageNum, pageSize){
	var lstlength=0;
	$.ajax({
		 url:path+"user/resList.do",
	     type:"post",
	     dataType:"json",
	     async:false,
	     data:{
		"pageNum":pageNum,
		"pageSize":pageSize,
		"cardType":cardType
	     },
	    success:
	}),
	
	$("#pageNum").val(pageNum);
	$("#pageSize").val(pageSize);
	
	$("#pageForm").submit();
	
	//window.location.href = path + "user/resList.do";
}*/
function updateNews(id) {
	window.location.href = path + "user/resAdd.do?id=" + id;
}

function updRes(id, str, cardType) {
	$.ajax({
		url : path + "user/updateRes.do",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			"str" : str,
			"id" : id,
			"cardType" : cardType
		},
		success : function(aj) {
			data = aj.attributes;
			window.location.reload();
		}

	})
}
//全选按钮的选中和取消事件
function chkbox() {
	if ($("input[name='chebox']").is(':checked')) {
		$(":checkbox").prop("checked", true);
	} else {
		$(":checkbox").prop("checked", false);
	}
}
//选中某个checkbox事件
/*     function selchebox(){
 //  var i= $("input:[type='checkbox']:checked").val();

 var ids = "";
 var trid = $("input:checkbox:checked");
 for ( var i = 0; i < trid.length; i++) {
 ids += trid[i].parentNode.id;
 if(i < (trid.length-1))
 ids += ",";
 }
 console.log(ids);
 //  del();
 }*/
function del() {
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
}


function catBkCentre() {
	var cat = $("input[name='catCentre']").val();
	var bk =  $("input[name='bkCentre']").val();
	if(isNull(cat)||isNull(bk)){
		var messages = "请选择首页和楼层！";
		layer.open({
			title : "提示",
			content : messages,
			btn : [ "确定" ],
			yes : function(ly) {
				layer.close(ly);
			}
		});
		return false;
	}
	var resId=$("input[type='checkbox']:checked").parents("tr").attr("resId"); 
	var img = $("input[type='checkbox']:checked").parents("tr").attr("resImg"); 
	if(isNull(resId)){
		var messages = "至少选择一条数据！";
		layer.open({
			title : "提示",
			content : messages,
			btn : [ "确定" ],
			yes : function(ly) {
				layer.close(ly);
			}
		});
	} else {
		$("#selCatBkCentre input[name='rt.res_id']").val(resId);
		$("#selCatBkCentre input[name='rt.cat']").val(cat);
		$("#selCatBkCentre input[name='rt.bk']").val(bk);
		$("#selCatBkCentre input[name='rt.img']").val(img);
		var form = $("#selCatBkCentre").serialize();
		xfm(form);
	}
}




function xfm(form){
	$.ajax({
		url : path + "/xfm.do",
		type : "post",
		dataType : "json",
		async : false,
		data : form,
		success : function(aj) {
			console.log(aj);
			var data = aj.obj;
			if(data.length>0){
				layer.open({
					title:"提示",
					content:"保存成功!",
					btn:["确定"],
					yes:function(){
						window.location.reload();
					}
				})
			}else{
				layer.open({
					title:"提示",
					content:"添加失败!",
					btn:["确定"],
					yes:function(){
						window.location.reload();
					}
				})
			}
		},
		error:function(data){
			if(data.responseText == "tosignin"){
				layer.open({
					title:"提示",
					content:"抱歉，请先登录!",
					btn:["确定"],
					yes:function(){
						window.location.href = path+"/loginui.do";
					}
				})
			}
		}
	})
	
}



