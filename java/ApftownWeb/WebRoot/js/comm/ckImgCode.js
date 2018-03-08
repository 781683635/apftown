var path = "";
$().ready(function(){
	path = $("base").attr("href");
	
})



function updateCode(cCode){
    //单击触发图片重载事件，完成图片验证码的更换
	//$("#"+vCode).src = "/Finance/v3/randcode?tt="+new Date().getTime();
	$("#"+cCode).attr("src",path+"randcode?tt="+new Date().getTime());
}




/*
 * 校验图形验证码
 */

var ret;
function checkTuCaptcha(tucaptcha){
	//var tucaptcha = $("#tucaptcha").val();
	if(tucaptcha != null && tucaptcha.length == 4){
		$.ajax({
			url : path+"/imgCode.do",
			type : 'POST',
			cache : false,
			async : false,
			data : {
				'imgCode' : tucaptcha
			},
			dataType : 'json',
			success : function(data) {
				if(!data){
					$("#imgCode").val("");
				}
				ret =  data;
			},
			error : function() {
				var lgalert = lg("操作错误,请与系统管理员联系!");
				alert(lgalert);
				ret = false;
			}
		});
		return ret;
	}else{
		return false;
	}
}



