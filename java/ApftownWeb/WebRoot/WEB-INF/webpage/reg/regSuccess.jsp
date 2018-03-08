<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>

<% menuType = "regSucc"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册成功-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="../comm/css.jsp" %>
	
  </head>
  
  <body>
    <div class="wrap">
  		<%@ include file="../comm/header.jsp" %>
    	<div class="container" >
		    <div class="clear">
		        <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 content text-center bor-light mt-20 pd-0">
		            <p class="text-left f-18 pd-10 bor-b-l bg-gray">注册成功</p>
		            <div class="pro-img-2">
		                <img src="<%=path %>/img/comm/su.png" alt="亚太金融（基金）小镇" class="pt-10 pb-10">
		            </div>
		            <p class="pt-15 pb-5 p-w f-18">恭喜<span><%=user.getRegName() %></span>，<span class="col-success"> 注册成功！</span></p>
		            <button type="button" class="btn btn-small mg-20 btn-primary" onclick="window.location.href='${pageContext.request.contextPath}/index.do'">进入首页</button>
		        </div>
		    </div>
		</div>
    	
	</div>
	<%@ include file="../comm/footer.jsp" %>
	<%@ include file="../comm/js.jsp" %>
  </body>
</html>
