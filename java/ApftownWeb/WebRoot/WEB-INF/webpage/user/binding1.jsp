<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../comm/tag.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'binding1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <%@ include file="../comm/css.jsp" %>
  </head>
  
  <body>
  <div class="wrap">
    <%@ include file="../comm/header.jsp" %>
	    <div class="container" >
		        <div class="bg-primary">
					<div class="container" style="height: 300px; display: flex; align-items:center; text-align: center;">
						<img src="<%=path %>/img/user/8.png">
						    
							<p class="f-18 text-center">
								<span class="col-red"> ${email }
									<c:if test="${status eq 1}">邮箱激活成功！操作成功！</c:if>
									<c:if test="${status eq 0}">邮箱已激活过！操作已处理！</c:if>
								</span>
							</p>
							<p class="text-right">
								<button class="f-16 bg-l-blue">点击跳转<a href="${pageContext.request.contextPath}/index.do">首页</a></button>
							</p>
					</div>
				</div>
		</div>
	</div>
    <%@ include file="../comm/footer.jsp" %> 
    <%@ include file="../comm/js.jsp" %>
  </body>
</html>
