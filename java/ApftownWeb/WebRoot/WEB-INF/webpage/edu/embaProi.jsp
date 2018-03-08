<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>
<%String embaType = "1.1"; %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>项目介绍-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
	<meta name="keywords" content="中美,EMBA,课程,金融高级研修班,培训,基金国际班,私募国际班,国际基金培训,亚太EMBA,亚太金融,中美EMBA,金融培训,基金培训,亚太金融（基金）小镇" />
    <meta name="description" content="中美合作,创新金融,基金交流,共享财富,亚太金融研究院联合美国德克萨斯阿灵顿商学院首创亚太金融EMBA项目, 培养世界级创新金融企业家！" />
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/swiper-3.3.1.min.css">
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/pagination.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/apft.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/emba.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors/colors.css">

  </head>
  
  <body>
	<div class="wrap emba">
    <%@ include file="../comm/header.jsp" %> 
  	<%@ include file="./embaHead.jsp" %>
  	<!-- 内容开始 -->
  	<div class="container1 clear">
	    <div class="row1">
	        <div class="bg-bg1 text-center pd-20">
				<p class="titp col-l-blue f-w">
					项目介绍
				</p>
			</div>
			<div class="rasp bg-d-blue">
			    <div class="bg-l-blue clear">
					<div class="ani ani2-3 col-md-2 col-sm-2 hidden-xs pt-20 mt-20 img-out">
		    			<img class="pl-20 pt-10" src="<%=path %>/img/edu-emba/idea.png" alt="亚太金融EMBA">
		    		</div>
					<div class="col-sm-10 col-xs-12 pd-20">
	    				<p class="ideap f-w col-white bor-b-l pb-10 pt-20 col-md-2 col-sm-2 col-xs-4 pl-0 ml-15">
	    					办学理念
	    				</p>
	    				<div class="ani ani2-2 line-h-25 pt-20 col-md-11 col-sm-11 col-xs-11">
	    					<p class="col-white">
	    						无人能左右变化，唯有走在变化之前 !中国投资行业经过十年高速发展，依然极具潜力，
	    					</p>
	    					<p class="col-white">
	    						"一带一路"、"亚太自贸区"、"人民币国际化"战略为基金行业带来新的机遇；
	    					</p>
	    					<p class="col-white">
	    						中国金融改革开放大门正在向全球打开,
	    					</p>
	    					<p class="col-white">
	    						了解国际投资规则，掌握投资基金的发起设立、投融管退、构建金融服务体系,
	    					</p>
	    					<p class="col-white">
	    						学习美国金融百年经验，与国际基金巨头合作共赢未来。
	    					</p>
	    					<p class="col-white">
	    						在当前的金融新趋势面前，企业家们如何通过金融的力量创造一个繁荣发展的新世界？
	    					</p> 
	    					<p class="col-white">
	    						基此背景下，亚太金融研究院联合美国德克萨斯阿灵顿商学院首创亚太金融EMBA项目,
	    					</p>
	    					<p class="pb-20 col-white">
	    						培养世界级创新金融企业家！
	    					</p>
    					</div>
		    		</div>
	    		</div>
			</div>
			<div class="rasp bg-l-blue mb-20">
			    <div class="bg-d-blue clear">
					<div class="ani ani2-3 img-out col-md-2 col-sm-2 hidden-xs pt-20 pl-20">
		    			<img class="pl-20 pt-10" src="<%=path %>/img/edu-emba/schm.png" alt="亚太金融EMBA">
		    		</div>
					<div class="col-sm-10 col-xs-12 pd-20">
	    				<p class="schmp f-w col-white bor-b-l pb-10 pt-20 col-md-2 col-sm-2 col-xs-4 pl-0 ml-15">
	    					办学使命
	    				</p>
    					<p class="ani ani2-2 col-white line-h-25 pt-20 pb-20 col-md-11 col-sm-11 col-xs-11">
    						中美合作  创新金融  基金交流  共享财富
    					</p>
		    		</div>
	    		</div>
			</div>
			<div class="bg-bg2 text-center pd-20">
				<p class="titp col-white f-w">
					主办单位
				</p>
			</div>
			<div>
				<div class="couv clear">
					<div class="col-md-5 col-sm-5 col-xs-5 pd-20 text-center">
		    			<img class="pt-20 pb-10" src="<%=path %>/img/edu-emba/logoa.png" alt="亚太金融EMBA">
	    				<p class="aspp col-red pt-20 line-h-15">
	    					亚太金融研究院
	    				</p>
		    		</div>
		    		<div class="iconf text-center col-md-2 col-sm-1 col-xs-2 pt-120 col-ccc">
		    		    <i class="icon-plus pt-20"></i>
		    		</div>
					<div class="col-md-5 col-sm-5 col-xs-5 pd-20 text-center">
					    <img class="pt-20 pb-10" src="<%=path %>/img/edu-emba/logou.png" alt="亚太金融EMBA">
	    				<p class="aspp col-h-blue pt-20 line-h-15">
	    					美国阿灵顿商学院
	    				</p>
		    		</div>
				</div>
				<div class="pl-40 pr-40 clear">
					<div class="desc col-md-5 col-sm-5 pt-20">
					    <div class="apif img-out1 overflow-h pos-r">
		    			    <img class="transition1 full-wh" src="<%=path %>/img/edu-emba/imga.jpg" alt="亚太金融EMBA">
		    			    <div class="dis-n pos-a rgba-80 pos-b-0 pos-r-0 clear ani ani2-3">
		    			        <img class="img-35 pull-left ml-20 full-wh mg-5" src="<%=path %>/img/edu-emba/logoa.png" alt="亚太金融EMBA">
		    			        <p class="aspp col-white f-14 line-h-35 pd-5 pull-left mr-20">亚太金融研究院</p>
		    			    </div>
		    			</div>
						<p class="ani ani2-2 line-h-25 pt-20 pb-20">
							亚太金融研究院(简称“研究院”)由热带海洋学院在海南三亚设立，位于三亚亚太金融（基金）小镇内，该院配合中国“一带一路”、“亚太自贸区”、“人民币国际化”等国家战略，汇集中美等国的顶尖学者及金融与企业实践的行业领袖，致力于培养高端金融人才，打造亚太地区金融领域领先的产、学、研基地。
						</p>
		    		</div>
		    		<div class="col-md-1 col-sm-1">
		    		  
		    		</div>
					<div class="iout col-md-5 col-sm-5 pt-20 col-md-offset-1">
					    <div class="arli img-out1 overflow-h pos-r">
		    			    <img class="transition1 full-wh" src="<%=path %>/img/edu-emba/imgu.jpg" alt="亚太金融EMBA">
		    			    <div class="dis-n pos-a rgba-80 pos-b-0 pos-r-0 clear ani ani2-3">		    			    
		    			        <img class="img-35 pull-left full-wh mg-5" src="<%=path %>/img/edu-emba/logou.png" alt="亚太金融EMBA">
			    				<p class="aspp col-white f-14 line-h-35 pd-5 pull-left">美国阿灵顿商学院</p>
		    			    </div>
		    			</div>
						<p class="ani ani2-2 line-h-25 pt-20 pb-20">
							美国德克萨斯大学是百年名校，下属的阿灵顿商学院（UTA）建于1895年，全球排名八十位，作为AACSB认证院校，其金融、财务、会计等领域国际领先，自2002年启动中国EMBA项目以来，15年培养了3000余名EMBA毕业生。AACSB认证代表着管理教育的顶尖学术标准、优秀声望、高水平师资、严格的入学标准以及相应的高学费等，目前在中国办学的商学院中被AACSB认证的屈指可数。
						</p>
		    		</div>
				</div>
			</div>
			<div class="bg-bg3 pd-20">
				<p class="titp col-h-blue f-w">
					办学特色
				</p>
			</div>
			<div class="bg-gray clear mb-20">
				<div class="ani ani2-3 col-md-2 col-sm-2 hidden-xs pt-20 pb-20 pl-20">
	    			 <img class="pd-20 ml-20" src="<%=path %>/img/edu-emba/char.png" alt="亚太金融EMBA">
	    		</div>
				<div class="schcl ani ani2-4 col-sm-10 col-md-10 col-xs-12 pt-20 pb-20">
				    <ul class="pt-20">
						<li>
							<p class="f-16 col-d-blue f-w">• 新模式、新课程</p>
							<div>
								<p class="f-13 line-h-20 pl-10">
									2地访学：美国纽约+美国硅谷
								</p>
								<p class="f-13 line-h-20 pl-10">
									5项修炼：学习+考察+交流+对话+团队
								</p>
							</div>
						</li>
                        <li class="f-16 col-d-blue  f-w">
							• 全球最佳基金学习与交流平台
						</li>
						<li class="f-16 col-d-blue  f-w">
							• 全美EMBA頂尖学府、州立大学TOP3
						</li>
						 <li class="f-16 col-d-blue  f-w">
							•  AACSB认证的EMBA硕士学位、全球通用 
						</li>
						<li class="f-16 col-d-blue  f-w">
							• 前沿的世界金融案例库教学和中国实践的完美结合
						</li>
						 <li class="f-16 col-d-blue  f-w">
							•  世界教授教学、双语授课模式
						</li>
						<li class="f-16 col-d-blue  f-w">
							• 中外校友高端人脉、全球资源共享、助力人生飞跃
						</li>
					</ul>
	    		</div>
    		</div>

		</div>

	</div>

  	<!-- 内容结束 --> 
  	<!-- 浮动开始 -->
  	<%@ include file="./embaRight.jsp" %>
  	<!-- 浮动结束--> 
	</div> 
	<%@ include file="../comm/footer.jsp"%>
    <%@ include file="../comm/js.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/jquery.form.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/swiper-3.3.1.jquery.min.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/edu/emba.js"></script>
	
  </body>
</html>
