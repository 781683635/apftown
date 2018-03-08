<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>  
<%String Type = "1.4"; %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>纳税申报-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
	<meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	<meta name="renderer" content="webkit"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"> 
	<meta name="apple-mobile-web-app-capable" content="yes"> 
	<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"> 
	<meta name="format-detection" content="telephone=no"> 
	<meta name="apple-touch-fullscreen" content="yes"> 
	<meta name="full-screen" content="yes"> 
	<meta charset="UTF-8"> 
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/apft.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors/colors.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/user/user.css">


  </head>
  
  <body>
  <div class="wrap fund ">
	<%@ include file="../comm/header.jsp" %>
	<div class="container">
		<div class="clear">
			<img class="pull-left" src="${pageContext.request.contextPath}/img/user/user04.png" alt="亚太金融（基金）小镇"> 
			<span class="pull-left f-18 pt-20 pl-10">政策与服务</span>
			<span class="pull-right pt-20">
				<a class="hov-primary" href="<%=path %>/index.do">首页</a>
				<i class=" icon-angle-right pl-5 pr-5" ></i>
				<a class="hov-primary" href="<%=path %>/f/fInto.do">政策与服务</a>
				<i class=" icon-angle-right pl-5 pr-5"></i> 
				纳税申报
			</span>
		</div>

		<div class="row clear mb-20 pb-20 mt-10">
		<!-- 侧边栏菜单 --> 
		<div class="col-md-2 col-sm-12  hidden-xs">
			<%@ include file="./fundMenu.jsp"%>
		</div>
		<!-- 侧边栏菜单end -->
		<!-- 内容开始 -->
			<div class="col-md-10 col-sm-12 pd-0  clear">
				<!-- 入园申请头部 -->
					<div class="clear mb-20">
						<h3 class="clear gradient-gray line-h-40">
							<span class="f-20 mt-10 col-primary pl-10 f-w">纳税申报</span>
		                 	<span class="f-18 mb-10 col-ccc pl-10">Investment Services</span>
						</h3>            
		            </div>
		        <!-- 入园申请头部END -->
				<!-- 主要内容开始 -->
					<div class="">
						<p class="pl-10 f-18 ">
							纳税申报服务尚未出台，敬请期待......
						</p>
					</div>
				<!-- 主要内容结束 -->
			</div>
			<!-- 内容结束 -->
		</div> 
	</div> 
  </div> 
  <%@ include file="../comm/footer.jsp" %>
  <%@ include file="../comm/js.jsp" %>
  <script src="${pageContext.request.contextPath}/js/comm/user.js"></script>  
  </body>
</html>
