<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../comm/tag.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>输入密码-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <%@ include file="../../comm/css.jsp" %>
     <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/m/mobile-apft.css">
</head>
<body>
	<div class="clear">
	<!-- 生活 -->
		<div class="full-w clear z-1">
			<img class="full-w z-1" src="${pageContext.request.contextPath }/img/mobile/reg_f/facethesea.jpg" alt="">
		</div>
		<div class="full-w clear z-9 pd-10 pos-r pos-t-50l">
			<div class="clear full-w  bg-white rectanyew">
				<div class="clear">
					<div class="col-3 pull-left pd-0 weqh">
						<div class="full-wh pd-10">
							<div class="f-22 full-wh text-center full-radius bg_00a0e6 clear heql col-white">
								交通
							</div>
						</div>
					</div>
					<div class="col-9 pull-left pt-10 pb-10 weqh2"> 
						<p class="line-h-15 f-12 col_333 weqh30">
							小镇背靠青龙山、头枕青天河、面向铁路港、眺望海棠湾，附近是游艇母港，远处是高端酒店群，前有榆亚省际国道，后有海南高速，距高铁站十分钟路程。
						</p>
					</div>
				</div>
				<div class="clear">
					<div class="col-3 pull-left pd-0 weqh">
						<div class="full-wh pd-10">
							<div class="f-22 full-wh text-center full-radius bg_5f52a0 clear heql col-white">
								品质
							</div>
						</div>
					</div>
					<div class="col-9 pull-left pt-10 pb-10 weqh2"> 
						<p class="line-h-15 f-12 col_333 weqh30">
							小镇在镇上完善配套基础上，依靠海棠湾国际高端酒店群、301医院养生圈、人大附中教育带、CDF离岛免税店等系列配套设施，辅以卓越的物业、管理、从居住、医疗、教育等方面，形成完善的品质生活体系。
						</p>
					</div>
				</div>
				<div class="clear">
					<div class="col-3 pull-left pd-0 weqh">
						<div class="full-wh pd-10">
							<div class="f-22 full-wh text-center full-radius bg_ea68a2 clear heql col-white">
								生活
							</div>
						</div>
					</div>
					<div class="col-9 pull-left pt-10 pb-10 weqh2"> 
						<p class="line-h-15 f-12 col_333 weqh30">
							小镇拥有完善的运动设施，不仅有户外青龙山爬山步道，而且有室内健身全套器材，清晨爬上青龙山瞭望大海，傍晚游泳海棠湾欣赏天边落日，呼吸清洁的空气，给您一个健康的体魄。
						</p>
					</div>
				</div>
			</div>
		</div>
	<!-- 生活END -->
	<!-- 填写密码 -->
		<form action="" id="regpwdFrom"  name="regpwdFrom"  method="post" class="sky-form">
			<input type="hidden" id="user_reg_email" name="user_reg_email" value="${tbUserRegister.userRegMobile }">
			<input type="hidden" id="userName"  name="userName" value="${tbUserRegister.userName }">
			<div class="full-w clear f-16 pos-r pos-t-50l">
				<div class="col-12 pull-left mt-10 mb-10">
					<input class="ipt-text f_text text-center radius-10 size-large" type="password" placeholder="输入密码" id="regPwd" name="regPwd">
				</div>
				<div class="col-12 pull-left mt-10">
					<button type="submit" class="btn radius0 btn-primary full-w radius-10 size-large f-16" >下一步</button>
				</div>
				<c:if test="${tbUserRegister.userName!=null}">
					<div class="col-12 pull-left mt-10">
						<button type="button" class="btn radius0 btn-primary full-w radius-10 size-large f-16" onclick="javascript:window.location.href='<%=path%>/forgetFpwd.do'">忘记密码</button>
				</c:if>
			</div>
			<!-- 填写密码END -->
		</form>
	</div>
	<!-- 填写密码END -->
	<%@ include file="../../comm/js.jsp" %>
	<script type="text/javascript"  src="${pageContext.request.contextPath }/js/comm/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/m/reg/regFpwd.js"></script>
	<script src="${pageContext.request.contextPath }/js/comm/swiper-3.3.1.jquery.min.js"></script>
	<script>
		/*宽高相等文字居住*/
		$(document).ready(function(){
	      var heightle=$(".weqh").width();
	      var lheightle=$(".heql").width();
	      $(".weqh").css({height:heightle+'px'});
	      $(".heql").css({'line-height':lheightle+'px'});
	    });
	</script>
	</body>

</html>
