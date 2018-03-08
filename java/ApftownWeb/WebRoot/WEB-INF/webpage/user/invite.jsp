<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp"%>

<% menuType = "6.1"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>邀请好友-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
<!-- ==========meta开始========== -->	    
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
<!-- ==========meta结束========== -->
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="<%=path %>/css/user/user.css">
  </head>
  
  <body>
  	<div class="wrap">
	    <%@ include file="../comm/header.jsp" %>
		<div class="container">
			<div class="clear">
				<img class="pull-left" src="<%=path %>/img/user/user03.png" alt="亚太金融（基金）小镇"> 
				<span class="pull-left f-18 pt-20 pl-10">用户中心</span>
				<span class="pull-right pt-20">
					<a class="hov-primary" href="<%=path %>/index.do">首页</a>
					<i class=" icon-angle-right pl-5 pr-5"></i><a class="hov-primary" href="<%=path %>/user/index.do">用户首页</a>
					<i class=" icon-angle-right pl-5 pr-5"></i>邀请好友
				</span>
				
			</div>
			<div class="row clear mb-20 pb-20">
			<!-- 侧边栏菜单 -->
				<%@ include file="./menu.jsp" %>
			<!-- 侧边栏菜单end -->
			<!-- 内容开始 -->
				<div class="col-xs-12 col-md-10">
					<div class="bg-white radius-10 text-center">
						<div class="pd-10 gradient-gray bor-ccc  dis-ib clear">
							<div id="qrcode"></div>
						</div>
						<div class="pt-20 pb-20 text-center clear">
						<!-- JiaThis Button BEGIN -->
							<!-- <div id="ckepop">
							<span class="jiathis_txt">分享到：</span>
							<a class="jiathis_button_qzone">QQ空间</a>
							<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jiathis_separator jtico jtico_jiathis" target="_blank">更多</a>
							<a class="jiathis_counter_style"></a>
							</div> -->
							<script type="text/javascript" src="http://v2.jiathis.com/code/jia.js" charset="utf-8"></script>
							<!-- JiaThis Button END -->
							<a href="http://v.t.sina.com.cn/share/share.php?title=欢迎 加盟亚太金融小镇" target="_blank"><i><img src="${pageContext.request.contextPath}/img/user/weibo.png" class="img-35 mg-5 cur-p bor-ccc full-radius"></i></a>
							<i><img src="${pageContext.request.contextPath}/img/user/qqzone.png" class="img-35 mg-5 cur-p bor-ccc full-radius"></i>
							<i><img src="${pageContext.request.contextPath}/img/user/weixin.png" class="img-35 mg-5 cur-p bor-ccc full-radius"></i>
							<i><img src="${pageContext.request.contextPath}/img/user/face.png" class="img-35 mg-5 cur-p bor-ccc full-radius"></i>
							<i><img src="${pageContext.request.contextPath}/img/user/linkin.png" class="img-35 mg-5 cur-p bor-ccc full-radius"></i>
							<i><img src="${pageContext.request.contextPath}/img/user/twitter.png" class="img-35 mg-5 cur-p bor-ccc full-radius"></i>

							<!-- <a href="javascript:(function(){window.open(‘http://v.t.sina.com.cn/share/share.php?title='+encodeURIComponent(document.title)+'&url='+encodeURIComponent(location.href)+'&source=bookmark','_blank','width=450,height=400′);})()" title="新浪微博分享"><img src="http://t.sina.com.cn/favicon.ico"  alt="新浪微博分享" border="0">分享到新浪微博</a> -->
						</div>
					</div>
				</div>
			<!-- 内容结束 -->
			</div>
	
		</div>
	</div>

<%@ include file="../comm/footer.jsp" %>
<%@ include file="../comm/js.jsp" %>
<script type="text/javascript" src="<%=path %>/ctrl/qrcode/jquery.qrcode.js"></script>
<script type="text/javascript" src="<%=path %>/ctrl/qrcode/utf.js"></script>
<script>
	$(function(){
		$("#qrcode").qrcode({
			render : "canvas",
			text :"http://www.apftown.com/regui.do?fm=<%=user.getRegName() %>",
			width : "120",
			height : "120",
			background : "#fff",
			foreground : "#000",
			src :'<%=(StringUtil.isNull(user.getUserImg())?"http://www.apftown.com/img/logo.png":user.getUserImg()) %>'
		})
	});
	// (function(){
	//   var _w = 90 , _h = 24;
	//   var param = {
	//     url:location.href,
	//     type:'2',
	//     count:'1', /**是否显示分享数，1显示(可选)*/
	//     appkey:'', /**您申请的应用appkey,显示分享来源(可选)*/
	//     title:'欢迎加盟-亚太金融小镇', /**分享的文字内容(可选，默认为所在页面的title)*/
	//     pic:'${pageContext.request.contextPath}/img/user/face.png', /**分享图片的路径(可选)*/
	//     ralateUid:'', /**关联用户的UID，分享微博会@该用户(可选)*/
	//  language:'zh_cn', /**设置语言，zh_cn|zh_tw(可选)*/
	//     rnd:new Date().valueOf()
	//   }
	//   var temp = [];
	//   for( var p in param ){
	//     temp.push(p + '=' + encodeURIComponent( param[p] || '' ) )
	//   }
	//   document.write('<iframe allowTransparency="true" frameborder="0" scrolling="no" src="http://hits.sinajs.cn/A1/weiboshare.html?' + temp.join('&') + '" width="'+ _w+'" height="'+_h+'"></iframe>')
	// })()
</script>
  </body>
</html>
