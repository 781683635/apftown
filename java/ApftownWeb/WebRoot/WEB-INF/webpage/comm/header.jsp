<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.apft.core.ApplicationContextUtil"%>
<%@page import="com.apft.utils.ZToken"%>
<%@page import="com.apft.utils.SessionUtil"%>
<%@page import="com.apft.mvc.model.TbUserEntity"%>
<%@page import="com.apft.utils.StringUtil"%>

<%
TbUserEntity user = SessionUtil.getSessionUser();
if (user == null) {
	ZToken zt = ApplicationContextUtil.getContext().getBean(ZToken.class);
	user = zt.signUserToken(request, response);
}
if(null != user){
 %>
<input type="hidden" value="<%=user.getId()%>" name="uid" id="uid">
<% } %>

<% if(s_oem.isMobile()){ %>

	<% if(!s_oem.isUAP()){ %>
		<!-- mobile-header  -->
		<header class="clear pl-5 pr-5 bg-black f-12">
			<div class="col-xs-3 pl-0">
				<img class="img-30 pd-5" onclick="window.location.href='<%=path %>/index.do'" src="<%=path %>/img/logo.png" alt="亚太金融（基金）小镇">
				<h1 class="h1">亚太金融小镇</h1>
				 
			</div>
			<div class="col-xs-9 pr-0">
				<ul class="pull-right line-h-20 col-ccc">
					<li class="pull-left"><a class="inline-block pt-5" href="<%=path %>/index.do">金融小镇</a></li>
					<li class="pull-left pd-5">|</li>
					<!-- <li class="pull-left"><a class="inline-block pt-5" href="#">下载App</a></li>
					<li class="pull-left pd-5">|</li> -->
					
					<li class="pull-left"><a class="inline-block pt-5" href="javascript:;"  onclick="chanageSZ('l')">电脑版</a></li>
					<li class="pull-left pd-5">|</li>
					
					<% if (user != null) { %>
					     
						<li class="pull-left"><a class="inline-block pt-5" href="<%=path %>/user/index.do"><%=user.getRegName() %></a></li>
						<li class="pull-left pd-5">|</li>
						<li class="pull-left"><a class="inline-block pt-5" href="<%=path %>/logout.do">退出</a></li>
					<% } else { %>
						<li class="pull-left"><a class="inline-block pt-5" href="<%=path %>/loginui.do">登录</a></li>
						<li class="pull-left pd-5">|</li>
						<li class="pull-left"><a class="inline-block pt-5" href="<%=path %>/regui.do">注册</a></li>
					<% } %>	
				</ul>
			</div>
		
		</header>
	<%}%>
	<!-- 导航 -->
	
<% } else { %>
	<header id="header">
		<div class="container clear">
			<div class="clear">
				<div class="nav-topbar pull-right pt-5">
					<ul class="clear">
						<li><a class="col-555" href="<%=path %>/index.do">首页</a></li>
						<li class="topbar-devider f-12 col-555">|</li>
						<li><a class="col-555" href="<%=path %>/aboutUs.do">关于我们</a></li>
						<li class="topbar-devider f-12 col-555">|</li> 
						
						 
						
						<li><a class="col-555" href="javascript:;" onclick="chanageSZ('s')">手机版</a></li>
						<li class="topbar-devider f-12 col-555">|</li>
						
						<% if (user != null) { %>
							<li><a class="col-555" href="<%=path %>/user/index.do"><%=user.getRegName() %></a></li>
								<li class="topbar-devider f-12 col-555">|</li>
								<li><a class="col-555" href="<%=path %>/logout.do">退出</a></li>
						<% } else { %>
							<li><a class="col-555" href="<%=path %>/loginui.do">登录</a></li>
								<li class="topbar-devider f-12 col-555">|</li>
								<li><a class="col-555" href="<%=path %>/regui.do">注册</a></li>
						<% } %>	
					</ul>
				</div>
			</div>
  			<%@ include file="./center.jsp" %>
  		</div>
  		
  	</header>
	<div class="border gra-pri"></div>
	

<% } %>


<!-- <script >
/*切换手机版*/

</script> -->



