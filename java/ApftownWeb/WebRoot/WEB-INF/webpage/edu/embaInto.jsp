<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>

<!DOCTYPE html>
<html lang="en">
	<head>
    	<base href="<%=basePath%>">
    	<title>进入EMBA-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    
		<meta name="keywords" content="中美,EMBA,课程,金融高级研修班,培训,基金国际班,私募国际班,国际基金培训,亚太EMBA,亚太金融,中美EMBA,金融培训,基金培训,亚太金融（基金）小镇" />
		<meta name="description" content="中美合作,创新金融,基金交流,共享财富,亚太金融研究院联合美国德克萨斯阿灵顿商学院首创亚太金融EMBA项目, 培养世界级创新金融企业家！" />
    
		<meta charset="utf-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">   
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/comm/swiper-3.3.1.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/animate.min.css">
		<%@ include file="../comm/css.jsp" %>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors/colors.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/embaIn.css">
	</head>
	<body class="overflow-h">
		<!-- 头部 -->
			<div class="pos-a e-logod clear z-999">
				<img class="e-logoi" src="${pageContext.request.contextPath}/img/edu-embaIn/logo2.png" alt="">
			</div>
			<div class="pos-a e-mord clear line-h-20 z-999 cur-p">
				<i class="icon-th col-white f-20 mr-5 pos-r pos-t-1 "></i>
				<span class="col-white f-20" >更多</span>
			</div>
		<!-- 头部END -->
		<!-- 弹出层 -->
			<div class="full-h rgba-90 showmore pos-a pos-t-0 z-99 ">
				<ul class="showul pos-a full-w">
					<li onclick="javascript:window.location.href='${pageContext.request.contextPath}/emba/proi.do'">项目介绍</li>
					<li onclick="javascript:window.location.href='${pageContext.request.contextPath}/emba/cursz.do'">课程体系</li>
					<li onclick="javascript:window.location.href='${pageContext.request.contextPath}/emba/teach.do'">师资力量</li>
					<li onclick="javascript:window.location.href='${pageContext.request.contextPath}/emba/notice.do'">报名须知</li>
				</ul>
			</div>
		<!-- 弹出层END -->
		<!-- swiper -->
		<div class="swiper-container swiper-container-main1 full-wh">
		    <div class="swiper-wrapper">
		        <div class="swiper-slide">
		        	<!-- 视频 -->
					<div class="full-wh z-1 clear">
						<video width=100% height=100% loop="loop" muted autoplay="autoplay" class="ob-fi" poster="${pageContext.request.contextPath}/img/edu-embaIn/banner2.png">
						  <source src="${pageContext.request.contextPath}/img/video/embaIn.mp4" type="video/mp4">
							您的浏览器不支持Video标签。
						</video>
					</div>
					<!-- 内容 -->
					<div class="full-wh z-9 clear pos-a pos-l-0 pos-t-0 rgba-30">
						<!-- content -->
						<h1 class="col-white s1-cont1 pos-a full-w text-center cur-d" >
							亚太·<span class="col-white">EMBA</span>
						</h1>
						
							<div class="clear full-w pos-a text-center pos-t-65s" >
								<div class="col-white s1-cont2 dis-ib cur-d main1_ani_01" onclick="javascript:window.location.href='${pageContext.request.contextPath}/emba/proi.do'">
								   	进入EMBA
								</div>
							</div>
						<div class="s1-cont3 pos-a cur-d clear">
							<img src="${pageContext.request.contextPath}/img/edu-embaIn/down.png" alt="">
						</div>
					</div>
		        </div>
		        <div class="swiper-slide">
		        	<img class="full-wh z-1" src="${pageContext.request.contextPath}/img/edu-embaIn/banner2.png" alt="">
		        	<div class="pos-a pos-t-17s col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10 z-9 clear">
		        		<div class="clear full-w text-center main1_ani_02">
		        			<img class="" src="${pageContext.request.contextPath}/img/edu-embaIn/banner2-tips1.png" alt="">
		        		</div>
		        		<div class="clear full-w text-center mt-50 s2-tips2 main1_ani_03">
		        			<div class="pull-left s2-tips21 dis-ib"></div>
		        			不出国门
		        			<div class="pull-right s2-tips21 dis-ib"></div>
		        		</div>
		        		<div class="clear full-w text-center mt-50 main1_ani_04">
		        			<p class="s2-tips3">读世界最顶尖的金融EMBA</p>
		        		</div>
		        		<div class="clear full-w text-center mt-100 main1_ani_05">
		        			<p class="col-white f-30">全美EMBA顶尖学府  州立大学TOP3</p>
		        		</div>
		        	</div>
		        	<div class="clear full-w pos-a text-center pos-t-75s">
						<div class="col-white s1-cont2 dis-ib cur-d main1_ani_06" onclick="fOptRes('./infoSub3.do')">
							立即报名
						</div>
					</div>
					<div class="s1-cont3 pos-a cur-d clear">
						<img src="${pageContext.request.contextPath}/img/edu-embaIn/down.png" alt="">
					</div>
		        </div>
		        <div class="swiper-slide">
		        	<img class="full-wh z-1" src="${pageContext.request.contextPath}/img/edu-embaIn/banner1.jpg" alt="">
		        	<div class="pos-a pos-l-0 pos-t-110 full-w z-9 clear">
		        		<div class="pull-left clear rgba-g-50 col-md-8 col-sm-12 main1_ani_07">
		        			<img class="img-60 pull-left mt-5 mb-5 ml-20 mr-20  dis-ib main1_ani_08" src="${pageContext.request.contextPath}/img/edu-embaIn/banner1-tips1.png" alt="">
		        			<span class="pull-left f-28 col-white h-70 line-h-70 main1_ani_09">亚太金融研究院</span>
		        			<img class="img-60 pull-left mt-5 mb-5 ml-20 mr-20  dis-ib main1_ani_10" src="${pageContext.request.contextPath}/img/edu-embaIn/banner1-tips2.png" alt="">
		        			<span class="pull-left f-28 col-white h-70 line-h-70 main1_ani_11">美国阿灵顿商学院</span>
		        		</div>
		        	</div>
		        	<div class="pos-a full-w pos-t-35s full-w z-9 clear">
		        		<div class="clear">
		        			<div class="col-md-8 col-sm-12 pull-right">
			        			<p class="col-white f-60 text-center main1_ani_12">
				        			中国基金的黄埔军校
				        		</p>
			        		</div>
		        		</div>
		        	</div>
		        	<div class="pos-a full-w pos-t-45s full-w z-9 clear">
		        		<div class="clear">
		        			<div class="col-md-8 col-sm-12 pull-right">
			        			<p class="col-white f-70 f-w text-center main1_ani_13">
				        			亚太金融的合作平台
				        		</p>
			        		</div>
		        		</div>
		        	</div>
		        	<div class="pos-a full-w pos-b-0 full-w z-9 clear">
		        		<div class="clear full-w s3-cont2 main1_ani_14">
		        		</div>
		        		<div class="clear full-w pb-20 pt-20 pr-20 s3-cont1 main1_ani_15">
		        			<p class="col-white f-40 text-right pr-20 main1_ani_16 s3-cont3">
			        			亚太金融EMBA — — 中美私募基金实战班
			        		</p>
		        		</div>
		        	</div>
		        	<div class="s1-cont3 pos-a cur-d clear">
						<img src="${pageContext.request.contextPath}/img/edu-embaIn/down.png" alt="">
					</div>
		        </div>
		        <div class="swiper-slide">
		        	<img class="full-wh z-1" src="${pageContext.request.contextPath}/img/edu-embaIn/banner3.jpg" alt="">
		        	<div class="pos-a pos-t-13s full-w z-9 clear">
		        		<div class="clear col-offset-1 pull-left pl-20 pr-20 f-26  rgba-r-73 radius-40 h-40 line-h-40 main1_ani_17">
		        			<span class="col-white main1_ani_18">亚太金融EMBA汇聚</span>
		        		</div>
		        	</div>
		        	<div class="pos-a pos-t-25s full-w z-9 clear">
		        		<p class="col-offset-1 text-left f-30 col-00479d pb-20 main1_ani_19">
		        			世界顶尖教授
		        		</p>
		        		<p class="col-offset-1 text-left f-30 col-00479d pb-20 pt-20 main1_ani_20">
		        			世界500强精英校友
		        		</p>
		        		<p class="col-offset-1 text-left f-70 col-red pb-20 pt-20 main1_ani_21">
		        			创新的金融课程模式
		        		</p>
		        	</div>
		        	<div class="s1-cont3 pos-a cur-d clear">
						<img src="${pageContext.request.contextPath}/img/edu-embaIn/down.png" alt="">
					</div>
		        </div>
		        <div class="swiper-slide">
		        	<img class="full-wh z-1" src="${pageContext.request.contextPath}/img/edu-embaIn/banner4.jpg" alt="">
		        	<div class="pos-a pos-t-35s full-w z-9 clear s5-cont1">
		        		<div class="clear pos-r col-offset-1 pull-left">
		        			<img class="w-600 main1_ani_22" src="${pageContext.request.contextPath}/img/edu-embaIn/banner4_tips1.png" alt="">
		        		</div>
		        	</div>
		        	<div class="pos-a pos-b-10s col-offset-2 clear z-99">
	        			<img class="w-800 main1_ani_23" src="${pageContext.request.contextPath}/img/edu-embaIn/banner4_tips2.png" alt="">
	        		</div>
		        	<div class="pos-a pos-t-25s full-w z-9 clear">
		        		<div class="col-lg-6 col-lg-offset-5 col-md-8 col-md-offset-3 clear pb-20">
		        			<p class="f-70">
		        				<span class="col-6 col-00479d dis-ib pull-left f-w text-right main1_ani_24">聚焦金融</span>
		        				<span class="col-6 col-00479d dis-ib pull-left text-right main1_ani_25">引领实践</span>
		        			</p>
		        		</div>
		        		<div class="col-lg-6 col-lg-offset-5 col-md-8 col-md-offset-3 clear pt-20 pb-20s">
		        			<p class="f-70">
		        				<span class="col-6 col-00479d dis-ib pull-left text-right main1_ani_26">驾驭资本</span>
		        				<span class="col-6 col-00479d dis-ib pull-left f-w text-right main1_ani_27">驱动革新</span>
		        			</p>
		        		</div>
		        	</div>
		        	<div class="pos-a pos-t-65s full-w z-9 clear">
		        		<div class="f-w clear pt-10 pb-10">
		        			<p class="col-md-6 col-md-offset-5 col-sm-8 col-sm-offset-3 dis-ib col-red f-30 pr-20 text-right main1_ani_28">
			        			亚太金融EMBA
			        		</p>
		        		</div>
		        		<div class="clear pt-10 pb-10">
		        			<p class="col-md-6 col-md-offset-5 col-sm-8 col-sm-offset-3 dis-ib col-red f-40 pr-20 text-right main1_ani_29">
			        			— — 中美私募基金实战班
			        		</p>
		        		</div>
		        	</div>
		        </div>
		    </div>
		    <!-- 如果需要分页器 -->
		    <div class="swiper-pagination swpav1"></div>
		</div>
		<!-- swiperEND -->
		<%@ include file="../comm/js.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/swiper-3.3.1.jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/swiper.animate.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/embaIn.js"></script>
		<script>
			$(document).ready(function(){        
				var mySwiper = new Swiper ('.swiper-container-main1', {
					direction: 'vertical',
					mousewheelControl : true,
					pagination: '.swiper-pagination',
					paginationClickable :true,
					speed:800,

				    onInit: function(swiper){ 
				    	myAC_main1.init(swiperAnimateParam_main1, swiper);
				    	myAC_main1.play();
					 }, 
				    onSlideChangeEnd: function(swiper){
				    	myAC_main1.play();
				    }
				}) 
			});      
	    </script>
	</body>
</html>
