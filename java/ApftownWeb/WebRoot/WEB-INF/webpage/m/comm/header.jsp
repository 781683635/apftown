<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<header class="clear pl-5 pr-5 bg-black h-30">
		<div class="pull-left clear full-h col-3 ">
			<img class="img-20 mt-5" src="${pageContext.request.contextPath }/img/logo2.png" alt="">
			<h1 class="h1">亚太金融(基金)小镇</h1>
		</div>
		<div class="pull-right clear full-h col-9 text-right ">
			<p class="f-14 pr-10 text-right line-h-30 h-30"><a href="http://www.apftown.com/" class="col-ccc">小镇官网</a></p>
		</div>
	</header>
