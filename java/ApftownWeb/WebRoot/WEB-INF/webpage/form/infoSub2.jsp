<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>入园管理-Apftown</title>
    
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
  	<div class="pt-10">

  		
  		<form id="subForm2" class="sky-form" method="post">
		 <input name="#no" value="res r,res_attrib ra,res_lg rl,res_prop_ln rpl" type="hidden"/>
		<input name="#fk" value="ra.res_id=r.id,rl.res_id=r.id,rpl.res_id=r.id" type="hidden"/>
		<input name="#un" value="ra=res_id+label" type="hidden"/>
		<c:if test="${not empty userId }">
			<input type="hidden" name="r.user_id" value="${userId }">
		</c:if>
	     <input type="hidden" name="r.update_time" value="@tIMe@">
			<input type="hidden" name="rpl.code" value="2"/>
		 	<input type="hidden" name="rl.lg" value="0">
		 	<input type="hidden" name="rl.title" value="xFormSubmit">
		    <input type="hidden" name="r.lang" value="1">
		    <input type="hidden" name="r.director" value="未联系">
  	   		<div class="ipt-form mb-15">
	                  <div class="lab-out-v2">
	                      <label for="name" class="ipt-label inline-block line-h-20"><span class="col-red">*</span>姓名:</label>
	                  </div>
	                  <div class="ipt-out-v2 mr-10">
	                  	  <input type="hidden" name="ra.label" value="name">
	                      <input type="text"  placeholder="请输入姓名！" id="ra.value"  name="ra.value"  class="ipt-text radius0" >
	                  </div>
              </div>
              <div class="ipt-form mb-15">
	                  <div class="lab-out-v2">
	                      <lable class="ipt-label inline-block line-h-20"><span class="col-red">*</span>联系电话:</lable>
	                  </div>
	                  <div class="ipt-out-v2 mr-10">
	                  	  <input type="hidden" name="ra#1.label" value="mobile">
	                      <input type="text" placeholder="请输入联系方式！！" id="ra#1.value" name="ra#1.value"  class="ipt-text radius0" >
	                  </div>
              </div>
              <div class="ipt-form mb-15">
	                  <div class="lab-out-v2">
	                      <label for="mobile" class="ipt-label inline-block line-h-20">电子邮箱:</label>
	                  </div>
	                  <div class="ipt-out-v2 mr-10">
	                  	  <input type="hidden" name="ra#2.label" value="email">
	                      <input type="text" placeholder="请输入电子邮箱" id="ra#2.value"  name="ra#2.value"  class="ipt-text radius0" >
	                  </div>
              </div>
              <div class="ipt-form mb-15">
	                  <div class="lab-out-v2">
	                      <lable for="remark" class="ipt-label inline-block line-h-20"><span class="col-red">*</span>留言:</lable>
	                  </div>
	                  <div class="ipt-out-v2 mr-10">
	                  	  <input type="hidden" name="ra#3.label" value="remark">
	                      <textarea class="full-w pd-10 ipt f-12" placeholder="例如：公司简介，个人简介，项目案例" id="ra#3.value" name="ra#3.value" rows="4" cols="50" style="resize:none;"></textarea>
	                  </div>
              </div>
  			<div class="f-13 pb-15 clear mr-15">
  				<button type="submit" class="btn radius0 gra-pri bor-pri btn-small pull-right col-white" >提交</button>
  			</div> 
  		</form>
  	</div>
	<%@ include file="../comm/js.jsp" %>
   	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/form/infoSub2.js"></script>
  </body>
</html>
