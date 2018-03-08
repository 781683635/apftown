var resId = "", parentId = "", path = "";
$().ready(function(){
	path=$("base").attr("href");
	resId = $("#resId").val();
	
	dealTime();
})

function pubCmt(ths){
	
	var pubCon = $(ths).parents(".ipt").find("textarea").val();
	var parentId = $(ths).parents(".com-list").attr("pid");
	parentId = Nulls(parentId);
	
	/*var a=$(ths).parents(".com-list").length;
	var clas=$(ths).parents(".com-list").attr("class");
	if (a==0) {
		var comment='<div class="com-list comment3" pid="5a1d744d09e111e7a0efac496a39deb0"><p><img class="img-25 full-rounded" src="http://www.miningcircle.com/img/comm/new-logo.png" alt=""><span class="col-primary pl-5 pr-5">888888</span><span class="col-999">2017-03-16 08:41:07.0</span></p><p class="pd-5 line-h-20">'+pubCon+'</p><div class="repl-out"><p class="clear"><span class="pull-right pd-5 col-primary cur-p" onclick="commentdel(this)">删除</span><span class="pull-right pd-5 col-primary cur-p repl" onclick="commentRepl(this)">回复</span><span class="pull-right pd-5 col-primary laud cur-p" onclick="commentlike(this)">支持（<span class="col-primary">0</span>）</span></p><div class="bor-light transition1 overflow-h ipt" style="height:0;visibility:hidden"><textarea name="" class="full-w ipt pd-10" style="height:60px;border:none;resize:none;" id="" cols="30" rows="10"></textarea><p class="clear bg-gray"><span class="pull-right pd-5 col-white bg-primary cur-p" onclick="pubCmt(this)">&nbsp;回复&nbsp;</span></p></div></div></div>';
		$(comment).prependTo($('#commentlist'));
	}else{
		clas='comment'+(parseInt(clas.charAt(clas.length-1))+1);
		var comment='<div class="com-list '+clas+'" pid="5a1d744d09e111e7a0efac496a39deb0"><p><img class="img-25 full-rounded" src="http://www.miningcircle.com/img/comm/new-logo.png" alt=""><span class="col-primary pl-5 pr-5">888888</span><span class="col-999">2017-03-16 08:41:07.0</span></p><p class="pd-5 line-h-20">'+pubCon+'</p><div class="repl-out"><p class="clear"><span class="pull-right pd-5 col-primary cur-p" onclick="commentdel(this)">删除</span><span class="pull-right pd-5 col-primary cur-p repl" onclick="commentRepl(this)">回复</span><span class="pull-right pd-5 col-primary laud cur-p" onclick="commentlike(this)">支持（<span class="col-primary">0</span>）</span></p><div class="bor-light transition1 overflow-h ipt" style="height:0;visibility:hidden"><textarea name="" class="full-w ipt pd-10" style="height:60px;border:none;resize:none;" id="" cols="30" rows="10"></textarea><p class="clear bg-gray"><span class="pull-right pd-5 col-white bg-primary cur-p" onclick="pubCmt(this)">&nbsp;回复&nbsp;</span></p></div></div></div>';
		$(comment).insertAfter($(ths).parents(".com-list"));
		$(ths).parents(".repl-out").find('.transition1').css({"height":'0',"visibility":"hidden"});
		$(ths).parents(".repl-out").find(".repl").html("回复");
	}
	$(ths).parents(".ipt").find("textarea").val(" ");*/
	
	saveComment(resId, pubCon, parentId);
	$(ths).parents(".ipt").find("textarea").val(" ");
	// Time(0);
}


function saveComment(resid,comment,parentid){
	if(this.ajaxRequest_!= undefined && this.ajaxRequest_.readyState < 4){
		layer.alert("请稍后", {yes:function(ly){layer.close(ly);}})
		return false;
	}
	this.ajaxRequest_ = $.ajax({
		url:path+"/user/saveComment.do",
		type:"POST",
		data:{
			"resId":resid,
			"comment":comment,
			"parentId":parentid,
			"type":0
		},
		dataType:"json",
		success:function(retdata){ 
			fuzhi(retdata.attributes);
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
	});
}

function fuzhi(data){
	var gettpl = document.getElementById('commentDemo').innerHTML;   //获取jsp html模板
	var result = laytpl(gettpl).render(data);// 插件赋值
	document.getElementById('commentlist').innerHTML = result; //把值放在 commentlist 里面
	
	$("#commentCnt").text(data.commlst.length);
	$(".ipt textarea").val('');
	
	dealTime();
}

function commentRepl(ths){
	var str=$(ths).html();
	if (str=="回复") {
		$('.repl-out .text-out').hide();
		$(ths).parents(".repl-out").find('.text-out').slideToggle(300);
		str="收起";
	}else{
		$(ths).parents(".repl-out").find('.text-out').slideToggle(200);
		str="回复";
	}
	$(ths).html(str);
}


function commentlike(dian){
	$(dian).attr("disabled", "true");
	
	parentId = $(dian).parents(".com-list").attr("pid"); 

	if(!isNull(resId) && !isNull(parentId) ){
		
		$(dian).css({"color":"#00B0EC"});
		$(dian).find("*").css({"color":"#00B0EC"});
		$.ajax({
			url:path+"/user/commentLike.do",
			type:"POST",
			data:{
				"resId":resId,
				"commentId":parentId
			},
			dataType:"json",
			success:function(retdata){
				$(dian).removeAttr("disabled");
				
				$(dian).find('span').html(retdata.obj);
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
		});
	}else{
		layer.open({
			title:"提示",
			content:"您的操作有误，请刷新页面重新操作",
			yes:function(){
				window.onload();
			}
		})
		
	}
}


function commentdel(dian){
	parentId = $(dian).parents(".com-list").attr("pid"); 
	layer.open({
		title:"提示",
		content:"确定要删除此次评论吗？",
		btn:["确定", "取消"],
		yes:function(lyyes){
			if(!isNull(resId) && !isNull(parentId) ){
				$.ajax({
					url:path+"/user/commentDel.do",
					type:"POST",
					data:{
						"resId":resId,
						"commentId":parentId
					},
					dataType:"json",
					success:function(retdata){
						if(retdata.success){
							fuzhi(retdata.attributes);
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
				});
			}
			layer.close(lyyes);
		}
	});
} 



function dealTime(){
	var spanOldTime = $("span[name='tt']");
	var spanNewTime = "";
	if(spanOldTime.length>0){
		for ( var i = 0; i < spanOldTime.length; i++) {
			spanNewTime = spanOldTime[i].innerText; 
			spanNewTime = getMd(spanNewTime, new Date().Format("yyyy-MM-dd hh:mm:ss"), 0);
			
			spanOldTime.eq(i).html(spanNewTime);
		}
	}
}




/** 取消关注 */
function nolike(who,type,resid){
	$(who).removeAttr('onclick');
	if(null != resid ){
		 if (this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState < 4) {
			if(kuangbar == undefined ){
				layer.alert(lg("请您稍等"),{yes:function(app){layer.close(app)	}})
			}
			return false;
	     }
	     this.ajaxRequest_ = $.ajax({
			url:path+"/user/nolike.do",
			type:"POST",
			data:{
				"resId":resid,
				"type":type
			},
			dataType:"json",
			success:function(retdata){
				var b = $(who).find("i");
				if(retdata.success){
					$(who).next().find("em").text(retdata.attributes.count); 
					$(who).find("i").removeClass("color-yellow");
					$(who).find("i").removeClass("color-red"); 
					$(who).find("i").addClass("color-blue");
					$(who).addClass("color-blue");
					$(who).attr('onclick',"newslike(this,"+type+",'"+resid+"')"); 
					$(who).removeClass("color-red");
					
				}
				window.location.reload();
			},error:function(data){
				if(data.responseText == "tosignin"){
					window.location.href = path+"/loginui.do";
				}
			}
		})
	}
}




/** 关注 */
function newslike(who,type,resid){
	$(who).removeAttr('onclick');
	if(null != resid ){
		 if (this.ajaxRequest_ != undefined && this.ajaxRequest_.readyState < 4) {
			 layer.alert(lg("请您稍等"),{yes:function(app){layer.close(app)}})
			 return false;
	     }
	     this.ajaxRequest_ = $.ajax({
			url:path+"/user/likes.do",
			type:"POST",
			data:{
				"resId":resid,
				"type":type
			},
			dataType:"json",
			success:function(retdata){
				var b = $(who).find("i");
				if(retdata.success){
					$(who).next().find("em").text(retdata.attributes.count);
					
					$(who).find("i").removeClass("color-blue");
					if(type == '110'){
						$(who).find("i").addClass("color-yellow");
					}else if(type == '120'){
						$(who).find("i").addClass("color-red");
					}
					
					$(who).attr('onclick',"nolike(this,"+type+",'"+resid+"')");
					
					$(who).removeClass("color-blue");
					$(who).addClass("color-red");
					
				}
			},
			error:function(data){
				if(data.responseText == "tosignin"){
					window.location.href = path+"/loginui.do";
				}
			}
		});
	}
}




