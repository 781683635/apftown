<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ include file="../comm/tag.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>下载文件显示页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <%@ include file="../comm/css.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/apft.css">
    
  </head>
  
  <body>
   <div class="wrap">
    <%@ include file="../comm/header.jsp" %>
    <input type="hidden" value="<%=user.getRegName() %>" name="fileName"><br/>
    <c:forEach var="me" items="${fileNameMap}">
         <c:url value="/servlet/DownLoadServlet" var="downurl">
             <c:param name="filename" value="${me.key}"></c:param>
         </c:url>
         ${me.value}<a href="${downurl}">下载</a>
         <br/>
     </c:forEach>
    
   </div>
   <%@ include file="../comm/footer.jsp" %>
  <%@ include file="../comm/js.jsp" %>
  </body>
</html>
