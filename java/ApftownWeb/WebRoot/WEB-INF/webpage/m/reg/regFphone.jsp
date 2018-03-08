<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../comm/tag.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录——亚太金融（基金）小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
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

    <%@ include file="../../comm/css.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/swiper-3.3.1.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/m/mobile-apft.css">
    <style type="text/css">
    	.share-mask{display: none;}
    </style>
  </head>
  
  <body class="bg-l-blue">
      	<meta name="sharePic" content="http://www.apftown.com/img/logo3.jpg"/>
        <meta name="shareDesc" content="共享千亿基金产学研平台"/>
    	<meta name="shareTitle" content="欢迎加入亚太金融小镇"/>
      	<input type="hidden" value="http://www.apftown.com/img/logo3.jpg" id="sharePic">
		<input type="hidden" value="共享千亿基金产学研平台" id="shareDesc">
		<input type="hidden" value="欢迎加入亚太金融小镇" id="shareTitle">
		<div class="sharemeet share-reset" id="shareId" style="display:none"></div>


	<div class="wrap clear">
		<!-- Swiper -->
			<div class="full-w clear pos-r">
				<div class="swiper-containerv1">
				    <div class="swiper-wrapper">
				        <div class="swiper-slide">
				        	<img src="${pageContext.request.contextPath }/img/mobile/reg_f/banner1.png" alt="">
				        </div>
				        <div class="swiper-slide">
				        	<img src="${pageContext.request.contextPath }/img/mobile/reg_f/banner2.png" alt="">
				        </div>
				        <div class="swiper-slide">
				        	<img src="${pageContext.request.contextPath }/img/mobile/reg_f/banner3.png" alt="">
				        </div>
				    </div>
				    <!-- 如果需要分页器 -->
				    <div class="swiper-pagination"></div>
				</div>
			</div>
		<!-- SwiperEND -->
		<div class="text-center mt-20 mb-20">
			<img class="w-20s" src="${pageContext.request.contextPath }/img/mobile/reg_f/logo_apft.png" alt="亚太金融小镇logo">
		</div>
		<p class="f-16 text-center  mb-20">
			欢迎加入  <span class="f-w family-ht">亚太金融（基金）小镇</span>
		</p>
	<!-- 视频 -->
		<div class="full-w clear pos-r">
			<video class="f_video" width="100%" height="200px" controls="controls" poster="${pageContext.request.contextPath }/img/mobile/reg_f/video_poster.png">
			  <source src="${pageContext.request.contextPath }/img/video/apft.mp4" type="video/mp4">
				您的浏览器不支持Video标签。
			</video>
			<div class="pos-a full-w h-30 line-h-30 bg-black pos-t-0 z-99 rgba-50 col-white f-16 pl-10">
				小镇介绍
			</div>
		</div>
	<!-- 视频end -->
	<!-- 手机号提交 -->
	<form action="" name="regfundForm" id="regfundForm" class="sky-form" method="post">
		<div class="full-w clear mb-20 f-16">
			<div class="col-12 pull-left mt-10 mb-10">
				<div class="clear">
					<input class="ipt-text f_text text-center radius-10 size-large" type="text" placeholder="填写您的手机号" name="user_reg_email" id="user_reg_email">
				</div>
			</div>
			<div class="col-12 pull-left mb-10">
				<button type="submit" id="regfund" class="btn radius0 btn-primary full-w radius-10 size-large f-16" >下一步</button>
			</div>
		</div>
	</form>
	<!-- 手机号提交END -->
	</div>
	<%@ include file="../../comm/js.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
	<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/m/reg/regfund.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/swiper-3.3.1.jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/utils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ctrl/share/js/share.js"  id="shareFile"></script>
<!-- base的js文件 -->
	
	<script>        
		(function(Z) {
		    Z(".sharemeet").share({
		        image: $("meta[name=sharePic]").attr("content"),
		        title: $("meta[name=shareTitle]").attr("content"),
		        link: "<%=basePath%>regFphone.do",
		        vdesc: $("meta[name=shareDesc]").attr("content"),
		        btnEvent:"#shareId",
		        "default":["weibo","qzone","fweixin","qq","facebook","twitter","google"]
		    });
		})(jQuery);
		var mySwiper = new Swiper ('.swiper-containerv1', {
			loop: true,
			autoplay : 3000,
			speed:500,
			effect : 'fade',
			pagination: '.swiper-pagination',
		});        
  </script>
</body>
</html>
