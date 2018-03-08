<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EMBA报名信息-亚太金融(基金)小镇</title>
	<meta http-equiv="keywords" content="中美,EMBA,课程,金融高级研修班,培训,基金国际班,私募国际班,国际基金培训,亚太EMBA,亚太金融,中美EMBA,金融培训,基金培训,亚太金融（基金）小镇">
	<meta http-equiv="description" content="中美合作,创新金融,基金交流,共享财富,亚太金融研究院联合美国德克萨斯阿灵顿商学院首创亚太金融EMBA项目, 培养世界级创新金融企业家！">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/sky-forms.css">
	<%@ include file="../comm/css.jsp" %>
    <%@ include file="../comm/ck.jsp" %>
  </head>
  
  <body class="gra-pri2">
<!-- <div class=" overflow-h"> -->
  	<!-- <div class="text-center mt-15 mb-15">
  		<h2>研 </h2>
  	</div> -->
  	<div>
	  <!--  		<form id="pageForm" class="pd-20 pb-0 bg-h-blue radius-5 col-12"   >
  	<div class=""> -->
	   		<form id="pageForm" class="sky-form pd-20 pb-0 bg-h-blue bor-ccc radius-5 col-12"   >
   	            <input name="#no" value="res r,res_attrib ra,res_lg rl,res_prop_ln rpl" type="hidden"/>
				<input name="#fk" value="ra.res_id=r.id,rl.res_id=r.id,rpl.res_id=r.id" type="hidden"/>
				<input name="#un" value="ra=res_id+label" type="hidden"/>
				<c:if test="${not empty userId }">
					<input type="hidden" name="r.user_id" value="${userId }">
				</c:if>
				<input type="hidden" name="rpl.code" value="3"/>
			 	<input type="hidden" name="rl.lg" value="0">
			 	<input type="hidden" name="rl.title" value="xFormSubmit">
			    <input type="hidden" name="r.lang" value="1">
			    <input type="hidden" name="r.director" value="未联系"> 
   	            <div class="mb-15">
                       <div class="lab-out">
       		            <label class="ipt-label inline-block line-h-20 col-white"><span class="col-red ml-5">*</span>姓名:</label>
                       </div>
                       <div class="ipt-out mr-20">
                     		<input type="hidden" name="ra.label" value="name">
       		        	<input type="text" id="ra.value"  name="ra.value" class="ipt-text radius0 pr-0" placeholder="您的姓名">
                       </div>
   		        </div>
   		        <div class="mb-15 mt-15">
					<div class="lab-out">
						<label class="ipt-label inline-block line-h-20  col-white"><span class="col-red ml-5">*</span>手机号:</label>
					</div>
					<div class="ipt-out mr-20">
						<input type="hidden" name="ra#1.label" value="mobile">
						<input type="text" id="ra#1.value" name="ra#1.value" class="ipt-text" placeholder="您的手机号">
					</div>
				</div>
				<div class="mb-15 mt-15">
					<div class="lab-out">
						<label class="ipt-label inline-block line-h-20  col-white"><span class="col-red ml-5">*</span>邮箱:</label>
					</div>
					<div class="ipt-out mr-20">
						<input type="hidden" name="ra#2.label" value="email">
						<input type="text" id="ra#2.value"  name="ra#2.value" class="ipt-text" placeholder="您的邮箱">
					</div>
				</div>
				<div class="mb-15 mt-15">
					<div class="lab-out">
						<label class="ipt-label inline-block line-h-20  col-white"></span>单位:</label>
					</div>
					<div class="ipt-out mr-20"> 
						<input type="hidden" name="ra#3.label" value="company">
						<input type="text" id="ra#3.value"  name="ra#3.value" class="ipt-text" placeholder="您的单位">
					</div>
				</div>
				<div class="mb-15 mt-15">
					<div class="lab-out">
						<label class="ipt-label inline-block line-h-20  col-white">职位:</label>
					</div>
					<div class="ipt-out mr-20">
						<input type="hidden" name="ra#4.label" value="job">
						<input type="text" id="ra#4.value"  name="ra#4.value" class="ipt-text" placeholder="您的职位">
					</div>
				</div> 
                      <div class="ipt-out mr-20 mt-15">
  	                     <button type="submit" class="btn radius0 full-w col-h-blue f-w h-20 line-h-15 f-14" >提交</button>
                      </div>
   	        </form>
	</div>
<!-- </div> -->
	<%@ include file="../comm/js.jsp" %>
   	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/edu/embaApply.js"></script> 
  </body>
</html>
