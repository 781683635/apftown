<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>消息提示</title>
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	--> 
	<%@ include file="../comm/css.jsp" %>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/apft.css">
  </head>
  
  <body>
  <div class="wrap">
		  <%@ include file="../comm/header.jsp" %>
		 	 ${message}
  </div>
  <%@ include file="../comm/footer.jsp" %>
  <%@ include file="../comm/js.jsp" %>
  </body>
</html>
