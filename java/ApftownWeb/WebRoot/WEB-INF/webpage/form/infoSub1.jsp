<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提交信息-Apftown</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/sky-forms.css">
	<%@ include file="../comm/css.jsp" %>
    <%@ include file="../comm/ck.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/apft.css">
  </head>
  
  <body class="gra-pri2">
  <!-- <div class=" overflow-h"> -->
<!--   	<div class="text-center mt-15 mb-15">
  		<h2>产</h2>
  	</div> -->
  	<div class="pt-10">
		  <form id="subForm1" class="sky-form" method="post">
			  <input type="hidden" id="catId" name="catId"  value="100"/>
  	   		<div class="ipt-form mb-15 ml-10">
                  <div class="lab-out-v2">
                      <label for="name" class="ipt-label inline-block line-h-20">姓名:</label>
                  </div>
                  <div class="ipt-out-v2 mr-15">
                      <input type="text"  placeholder="请输入姓名！" id="name"  name="name"  class="ipt-text radius0 f-12" >
                  </div>

              </div>
              <div class="ipt-form mb-15 ml-10">
                  <div class="lab-out-v2">
                      <label for="mobile" class="ipt-label inline-block line-h-20">联系方式:</label>
                  </div>
                  <div class="ipt-out-v2 mr-15">
                      <input type="text" placeholder="请输入联系方式！" id="mobile"  name="mobile"  class="ipt-text radius0 f-12" >
                  </div>
              </div>
              <div class="ipt-form mb-15 ml-10">
                  <div class="lab-out-v2">
                      <lable for="comName" class="ipt-label inline-block line-h-20">邮箱:</lable>
                  </div>
                  <div class="ipt-out-v2 mr-15">
                      <input type="text" placeholder="请输入您所在公司！" id="comName" name="comName"  class="ipt-text radius0 f-12" >
                  </div>
              </div>
              <div class="ipt-form mb-15 ml-10">
                  <div class="lab-out-v2">
                      <lable for="remark" class="ipt-label inline-block line-h-20">留言:</lable>
                  </div>
                  <div class="ipt-out-v2 mr-15">
                      <textarea class="full-w pd-10 ipt f-12"  placeholder="您想说点什么....." name="remark" rows="3" cols="50" style="resize:none;"></textarea>
                  </div>
              </div>
        			<div class="f-13 clear mr-15">
        				<button type="submit" class="btn radius0 gra-pri bor-pri btn-normal pull-right col-white">提交</button>
        			</div> 
      		</form>
  	</div>
    <!-- <img class="pos-a tree1" src="<%=path %>/img/bg/tree.png" alt=""> -->
    <!-- <img class="pos-a cloud" src="<%=path %>/img/bg/cloud.png" alt=""> -->
  <!-- </div> -->
	<%@ include file="../comm/js.jsp" %>
   	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/form/infoSub1.js"></script>
  </body>
</html>
