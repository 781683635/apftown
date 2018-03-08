<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>

<% menuType = "2.1"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>我的关注-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
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
	
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/user.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/pagination.css">
	
  </head>
  
<body>
	<div class="wrap">
	    <%@ include file="../comm/header.jsp" %>
	
		<div class="container">
		  <% if(!s_oem.isMobile()){ %>
			<div class="clear">
				<img class="pull-left" src="<%=path %>/img/user/user03.png" alt="亚太金融（基金）小镇"> 
				<span class="pull-left f-18 pt-20 pl-10">用户中心</span>
				<span class="pull-right pt-20">
					<a class="hov-primary" href="<%=path %>/index.do">首页</a>
					<i class=" icon-angle-right pl-5 pr-5"></i><a class="hov-primary" href="<%=path %>/user/index.do">用户中心</a>
					<i class=" icon-angle-right pl-5 pr-5"></i>我的关注
				</span>
			</div>
			<%} %>
			<div class="row clear mb-20 pb-20">
			<!-- 侧边栏菜单 -->
			<%@ include file="./menu.jsp" %>
			<!-- 侧边栏菜单end -->
			<!-- 内容开始 -->
				<div class="col-md-10 pd-0 bor-ddd mt-20">
					<!-- 头部 -->
					<div class="col-xs-12 gradient-gray clear pd-0">
						<div class="col-lg-7 col-md-6 col-sm-5 text-center pull-left pt-10 pb-10 f-12 bor-rb-ddd">
							<span>名称</span>
						</div>
						<div class="col-md-3 col-sm-4 text-center pull-left f-12 pd-0">
							<div class="col-md-6 col-sm-6 pull-left pt-10 pb-10 bor-rb-ddd">
								<span>关注类型</span>
							</div>
							<div class="col-md-6 col-sm-6 pull-left pt-10 pb-10 bor-rb-ddd">
								<span>关注时间</span>
							</div>
						</div>
						<div class="col-lg-2 col-sm-3 text-center pull-left pt-10 pb-10 f-12 bor-b-ddd ">
							<span>操作</span>
						</div>
					</div>
					<!-- 查询 -->
						
					<!-- 循环内容 -->
					<div class="col-xs-12 bg-white clear pd-0" id="commentlist"> 
					</div>
					<!-- 循环结束 -->
					<!-- 分页 -->
					<div>
						<input type="hidden" id="pageNum" name="pageNum" value="${pageNum }">
						<input type="hidden" id="pageSize" name="pageSize" value="${pageSize }">
						<input type="hidden" id="totalCount" value="${totalCount }"> 
						<div class="pageHtml"></div>
					</div>  
				</div>
			<!-- 内容结束 -->
			</div>
		</div>
	</div> 	
	 	    
	    
	    <%@ include file="../comm/footer.jsp" %>
	    <%@ include file="../comm/js.jsp" %>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/pagination.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/userAtten.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/laytpl.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/comment.js"></script>
	<script type="text/javascript">
	$(function(){
		window["_baseNath"]=path;
	})
	</script>
	<script type="text/html" id="commentDemo">
		{{# for (var i in d){ }}  
			<div class="col-lg-7 col-md-6 col-sm-5 text-center pull-left pt-10 pb-10  f-12 bor-rb-ddd clear">
				<div class="col-md-2 col-sm-3 pd-0 pull-left">
					<a href="<%=path %>/n/i.do?no={{d[i].no}}">
						<img src="{{d[i].img }}" class="full-w h-50 cur-p" alt="亚太金融（基金）小镇" title="{{d[i].title }}">
					</a>
				</div>
				<div class="col-md-10 col-sm-9 pull-left text-left pt-15 pb-10">
					<a href="<%=path %>/n/i.do?no={{d[i].no}}">
						<p class="line-h-20 newline text-line-1 f-12 cur-p hov-primary">
							{{d[i].title }}
						</p>
					</a>
				</div>
			</div>
			<div class=" col-md-3 col-sm-4 text-center pull-left pd-0">
				<div class="col-md-6 col-sm-6 pull-left ptb-29 bor-rb-ddd">
					<span>{{d[i].name }}</span>
				</div>
				<div class="col-md-6 col-sm-6 pull-left ptb-29 bor-rb-ddd">
					<span>{{d[i].insert_time }}</span>
				</div>
			</div>
			<div class="col-lg-2 col-md-3 col-sm-3 text-center pull-left f-12 pt-26 pb-20 clear bor-b-ddd clear">
				<div class="col-md-6 col-sm-6 pd-0 pull-left">
					<button class="btn btn-tiny plr-15 btn-primary" onclick="window.location.href=window._baseNath+'n/i.do?no={{d[i].no}}'">
						查看
					</button>
				</div>
				<div class="col-md-6 col-sm-6 pd-0 pull-left">
					<button class="btn btn-tiny plr-15 btn-primary" onclick="nolike(null,'{{d[i].type}}','{{d[i].res_id}}');">
						取消
					</button>
				</div>
			</div>
		{{# }  }}
	</script>    
</body>
</html>
