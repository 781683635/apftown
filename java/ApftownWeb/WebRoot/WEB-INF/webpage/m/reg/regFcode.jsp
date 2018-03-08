<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../comm/tag.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>验证-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    
	<!-- 清空浏览器本地缓存 -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
<!-- 本网页关键字和关键内容 -->
	<meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
<!-- 采用webkit内核(急速内核) -->
	<meta name="renderer" content="webkit">
<!-- 移动屏幕的缩放初始缩放比例1.0，不允许用户缩放，最小比例1.0，最大比例1.0 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
<!-- 网站开启对web app的支持 -->
	<meta name="apple-mobile-web-app-capable" content="yes">
<!-- web app顶部状态条的颜色为灰色半透明 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
<!-- 忽略页面中的数值识别为电话号码 -->
	<meta name="format-detection" content="telephone=no">
<!-- web app设备添加到主屏幕后全屏显示 -->
	<meta name="apple-touch-fullscreen" content="yes">
<!-- uc浏览器强制全屏	 -->
	<meta name="full-screen" content="yes">
<!-- 以utf-8格式编码 -->
	<meta charset="UTF-8">
    <%@ include file="../../comm/css.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/swiper-3.3.1.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/m/mobile-apft.css">
    <style>
    	.scroll-wrapper {-webkit-overflow-scrolling: touch !important;overflow-y: scroll !important;} 
    </style>
  </head>
  
<body>
	<div class="wrap clear">
		<!-- 产学研PB中心 -->
			<div class="full-w clear mb-5">
				<img class="full-w" src="${pageContext.request.contextPath }/img/mobile/reg_f/pb.png" alt="">
			</div>
			<div class="full-w mt-10 mb-5 text-center">
				<img class="w-57s" src="${pageContext.request.contextPath }/img/mobile/reg_f/pb_text.png" alt="">
			</div>
		<!-- 产学研PB中心END -->
	<!-- 产学研介绍 -->
		<div class="full-w clear pd-10">
			<div class="full-w rectangular clear">
				<div class="clear full-w">
					<div class="col-3 pull-left pt-10 pb-10">
						<div class="pd-10 f-30 text-center full-radius bg_00a68d clear">
							<div class="clear weqh col-white">
								产
							</div>
						</div>
					</div>
					<div class="col-9 pull-left pt-10 pb-10 weqh2">
						<p class="line-h-15 f-12 col_00a68d f-w weqh30">
							基金服务
						</p>
						<p class="line-h-15 f-12 col_333 weqh30">
							海南省金融基金类公司注册的快速通道;
						</p>
						<p class="line-h-15 f-12 col_333s weqh30">
							协助登记备案;一站式PB综合服务;
						</p>
					</div>
				</div>
				<div class="clear full-w">
					<div class="col-3 pull-left pt-10 pb-10">
						<div class="pd-10 f-30 text-center full-radius bg_00a68d clear">
							<div class="clear weqh col-white">
								学
							</div>
						</div>
					</div>
					<div class="col-9 pull-left pt-10 pb-10 weqh2">
						<p class="line-h-15 f-12 col_00a68d f-w weqh40">
							教育服务
						</p>
						<p class="line-h-15 f-12 col_333 weqh40">
							首个亚太金融EMBA;
						</p>
						<p class="line-h-15 f-12 col_333s weqh40">
							与清华、北大等高校院所机构合作;
						</p>
						<p class="line-h-15 f-12 col_333s weqh40">
							每年开展5000人次培训;
						</p>
					</div>
				</div>
				<div class="clear full-w">
					<div class="col-3 pull-left pt-10 pb-10">
						<div class="pd-10 f-30 text-center full-radius bg_00a68d clear">
							<div class="clear weqh col-white">
								研
							</div>
						</div>
					</div>
					<div class="col-9 pull-left pt-10 pb-10 weqh2">
						<p class="line-h-15 f-12 col_00a68d f-w weqh30">
							科研服务
						</p>
						<p class="line-h-15 f-12 col_333 weqh30">
							对基金的各项投融资服务开展金融研究;
						</p>
						<p class="line-h-15 f-12 col_333s weqh30">
							年度发表《亚太金融蓝皮书》;
						</p>
					</div>
				</div>
			</div>
		</div>
	<!-- 产学研介绍END -->
	<!-- 手机号提交 -->
	<form action="${pageContext.request.contextPath }/regFpwd.do" method="post" class="sky-form" id="regcodeForm">
		<input  type="hidden" value="${tbUserRegister.userRegEmail }" name="user_reg_email">
		<div class="full-w clear mb-20 mt-10">
			<div class="col-9 pull-left pr-5">
				<input class="ipt-text f_text radius-10" type="text" placeholder="输入验证码" id="smsCode" name="smsCode">
			</div>
			<div class="col-3 pull-left pl-5">
				<button type="button" class="btn radius0 h-34 btn-primary full-w bg_00a68d radius-10" id="getSmsCode" onclick="sendMessage('${user_reg_email }',null,'getSmsCode',1)">获取验证码</button>
			</div>
			<div class="full-w clear pull-left pd-15 text-center">
				<label>
				    <input class="iagree pd-5" type="checkbox">
				    <span>我同意</span><span class="tab1 col-primary">《亚太金融（基金）小镇服务协议》</span>
				</label>
			</div>
			<div class="col-12 pull-right">
				<button type="submit" disabled="disabled" class="btn radius-10 h-34 btn-primary full-w iagreeb f-16">立即注册</button>
			</div>
		</div>
	</form>
	<!-- 手机号提交END -->
	</div>
<!-- jquery文件 -->
	<%@ include file="../../comm/js.jsp" %>
	<script src="${pageContext.request.contextPath }/js/comm/swiper-3.3.1.jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/reg/sendMsg.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/m/reg/regFcode.js"></script>	
<!-- base的js文件 -->
	<script>        
		$(document).ready(function(){
		  $(".iagree").click(function(){
		  	var ig = $(".iagree").prop("checked");
		  	if (ig==true) {
				$('.iagreeb').removeAttr("disabled"); 
		  	}
		  	else{
		  		$('.iagreeb').attr('disabled',"true");
		  	}
		  });
		  $('.tab1').on('click', function(){
				layer.open({
					type: 2,
					title: '亚太金融（基金）小镇服务协议',
					maxmin: true,
					shadeClose: false, //点击遮罩关闭层
					area : ['90%' , '90%'],
					content: 'regFservice.do',
					success: function(layero){
		               $(layero).addClass("scroll-wrapper");//苹果 iframe 滚动条失效解决方式
		            }
				});
			});
		});
		/*宽高相等文字居住*/
		$(document).ready(function(){
	      var heightle=$(".weqh").width();
	      $(".weqh").css({height:heightle+'px'});
	      $(".weqh").css({'line-height':heightle+'px'});
	      $(".weqh2").css({height:heightle+40+'px'});
	      $(".weqh30").css({height:(heightle+20)/3+'px'});
	      $(".weqh30").css({'line-height':(heightle+20)/3+'px'});
	      $(".weqh40").css({height:(heightle+20)/4+'px'});
	      $(".weqh40").css({'line-height':(heightle+20)/4+'px'});
	    });        
	</script>
</body>
</html>
