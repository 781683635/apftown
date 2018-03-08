var intDiff = parseInt(60);//倒计时总秒数量
//catcha图形验证码,btn的id,最后一个为空，
function timer(mobile,captcha,btn,nosms){
	var tbtn = $("#"+btn);
	intDiff=60;
	interval=window.setInterval(function(){
	if(intDiff<=0){
		tbtn.attr("disabled",false);
		tbtn.html('获取语音验证码');	
		tbtn.attr("onclick","sendVoice('"+mobile+"','"+captcha+"','"+btn+"',"+nosms+")");
		m1=2;
		clearTimeout(interval); 
		return;
	}
	tbtn.html('倒计时'+intDiff);
	intDiff--;
	}, 1000);
}



function sendMessage(mobile,captcha,btn,nosms){
	var path = $("base").attr("href");
	$("#"+btn).removeAttr("onclick");
	if(isNull(nosms))
		nosms = 'null';
	if (testPhone(mobile) ) {
		$.ajax({
			url: path+"/sendMessage.do",  
			type : 'POST',
			cache: false,
			async: false,
			data : {
				'mobilePhone' : mobile,
				'imgCode' : captcha,
				'nosms':nosms
			},
			dataType : 'json',  
			success : function(data) {
				if(data.success){
					  timer(mobile,captcha,btn,nosms+" ");
				}else if(data.msg == "-3"){
					layer.open({
					  title:"提示",
					  content:"请输入正确的图形验证码！",
					  btn:["确定"],
					  yes:function(yt){
						  $("#"+btn).removeAttr("disabled");
						  layer.close(yt);
					  }
					});
					return false;
				}else{
					layer.open({
					  title:"提示",
					  content:"验证码发送失败！请重新操作",
					  btn:["确定"],
					  yes:function(yt){
						  $("#"+btn).removeAttr("disabled");
						  layer.close(yt);
					  }
					});
					return false;
				}
			},
			error : function() {
				$("#"+btn).removeAttr("disabled");
				alert('操作错误,请与系统管理员联系!');
			}
		});
	
	}else{
    	//新手机为空时
	   	layer.open({
			  title:"提示",
			  content:"请输入正确的手机号码",
			  btn:["确定"],
			  yes:function(yt){
				  $("#"+btn).removeAttr("disabled");
				  layer.close(yt);
			  }
		  });
	   	 $('#newmobile').val('');
		 $('#newmobile').focus();
	   	 return false;
    }
}


function sendVoice(mobile,captcha,btn,nosms){
	var path = $("base").attr("href");
	$("#"+btn).removeAttr("onclick");
	//var partten = /^0?(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$/;
	if (testPhone(mobile)) {
		$.ajax({
			url: path+"/sendVoice.do",  
			type : 'POST',
			cache: false,
			async: false,
			data : {
				'mobilePhone' : mobile,
				'imgCode' : captcha,
				'nosms' : nosms
			},
			dataType : 'json',  
			success : function(data) {
				if(data.msg=="1"){
					timer(mobile,captcha,btn,nosms);
				}
			},
			error : function() {
				$("#"+btn).removeAttr("disabled");
				alert('操作错误,请与系统管理员联系!');	
			}
		});
	}else{
    	//新手机为空时
		$("#"+btn).removeAttr("disabled");
	   	 alert("请输入正确的手机号码");
	   	 $('#user_mobile').val('');
		 $('#user_mobile').focus();
	   	 return false;
    }
}


function sendEmail(uid,uname,email,captcha,act){
	var isMReg = $("#isMReg").val();
	$.ajax({
		url:'sendMail.do',
		type:'POST',
		data:{
			'uid':uid,
			'uname':uname,
			'regEmail':email,
			'act': act
		},
		success:function(data){
			console.log(data);
			data = eval("("+data+")");
			if(data.success){
				var payindex=layer.open({
					title: '发送成功',				 
					content: '邮件发送成功！请在48小时之内查收邮件并点击激活',
					btn:["确定"],
	            	yes:function(){
	            		layer.close(payindex);
	            		if(null != isMReg && isMReg != undefined){
	            		}else
	            			location.href = path+"index.do";
	            	},
				});
			}else if(data.msg == "-1"){
				var payindex=layer.open({
					title: '提示',				 
					content: '该邮箱已注册',
					btn:["去登陆"],
	            	yes:function(){
	            		if(null != isMReg && isMReg != undefined){
	            			location.href = path+"/mlogin.do?uname="+email+"&at=lv";
	            		}else
	            			location.href = path+"/loginui.do";
	            	},
				});
			}else if(data.msg == "-2"){
				var payindex=layer.open({
					title: '提示',				 
					content: '该邮箱未注册',
					btn:["确定"],
	            	yes:function(){
	            		$("#"+btn).removeAttr("disabled");
	            		layer.close(payindex);
	            	},
				});
			}else{
				var payindex=layer.open({
					title: '发送失败',				 
					content: '邮件发送失败。。。请验证邮箱是否正确',
					btn:["确定"],
	            	yes:function(){
	            		$("#"+btn).removeAttr("disabled");
	            		layer.close(payindex);
	            	},
				});
			}
		}
	});
	 
	
}










