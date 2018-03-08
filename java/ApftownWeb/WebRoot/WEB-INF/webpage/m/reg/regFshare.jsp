<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../comm/tag.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>联系我们-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/swiper-3.3.1.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/m/mobile-apft.css">
    <style type="text/css">
    	.share-mask{display: none;}
    </style>
  </head>
  
<body class="bg-l-blue">
	<meta name="sharePic" content="http://www.apftown.com/img/logo3.jpg"/>
    <meta name="shareDesc" content="共享千亿基金产学研平台"/>
	<meta name="shareTitle" content="联系我们亚太金融小镇"/>
  	<input type="hidden" value="http://www.apftown.com/img/logo3.jpg" id="sharePic">
	<input type="hidden" value="共享千亿基金产学研平台" id="shareDesc">
	<input type="hidden" value="联系我们亚太金融小镇" id="shareTitle">
	<div class="sharemeet share-reset" id="shareId" style="display:none"></div>

	<div class="wrap clear">
	<!-- 联系我们 -->
	<div class="clear full-w bg_eaf8ff bor-b-434343">
		<p class="text-center pt-15 pb-15 f-26 col_00a5f7">
			<img class="dis-ib pos-r pos-t-2l img-30 bg_00a0e6 radius-5 pd-5 mr-10" src="${pageContext.request.contextPath }/img/mobile/reg_f/share_tips1.png" alt="">联系我们
		</p>
	</div>
	<!-- 联系我们END -->
	<!-- 小镇地图和分享 -->
		<div class="clear text-center mt-10 mb-10">
			<iframe width="304" height="265" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://j.map.baidu.com/GYRxI"></iframe>
		</div>
		<p class="f-16 text-center mt-10 mb-10 col_00a5f7 line-h-20">
			小镇地址
		</p>
		<div class="clear">
			<div class="col-6 clear pull-left mt-10 mb-10">
				<img src="${pageContext.request.contextPath }/img/mobile/reg_f/yataiqr.jpg" alt="">
			</div>
			<div class="col-6 clear pull-left mt-10 mb-10">
				<img src="${pageContext.request.contextPath }/img/mobile/reg_f/yataifp.jpg" alt="">
			</div>
		</div>
		<p class="text-center pt-15 col_00a5f7 f-14">
			分享三家公司，并成功加盟
		</p>
		<p class="text-center pt-10 pb-10 f-w col_00a5f7 f-24 pl-15 pr-15">
			即可享受三亚海棠湾免费住宿一晚（并赠送接送机场一次）服务
		</p>
		<!-- 小镇地图END -->
	</div>
	<div class="clear bg_a8e2ff pt-20 pb-20 footer">
		<p class="f-14 mt-5 mb-10 pl-15 pr-15 line-h-15">
			<span class="f-w">联系电话：</span><a class="hov-pri" href="tel:400-0881124">400-0881124</a>
		</p>
		<p class="f-14 mt-5 mb-10 pl-15 pr-15 line-h-15">
			<span class="f-w">邮箱：</span><a href="mailto:info@apftown.com">info@apftown.com</a>
		</p>
		<p class="f-14 mt-5 mb-10 pl-15 pr-15 line-h-15">
			<span class="f-w">地址：</span>海南省三亚市海棠湾亚太金融（基金）小镇
		</p>
	</div>
<!-- jquery文件 -->
	<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script src="${pageContext.request.contextPath }/js/comm/swiper-3.3.1.jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/mining.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/utils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ctrl/share/js/share.js"  id="shareFile"></script>

<!-- base的js文件 -->
	<script>        
		(function(Z) {
		    Z(".sharemeet").share({
		        image: $("meta[name=sharePic]").attr("content"),
		        title: $("meta[name=shareTitle]").attr("content"),
		        link: "<%=basePath%>regFshare.do",
		        vdesc: $("meta[name=shareDesc]").attr("content"),
		        btnEvent:"#shareId",
		        "default":["weibo","qzone","fweixin","qq","facebook","twitter","google"]
		    });
		})(jQuery);
	 </script>
</body>
</html>
