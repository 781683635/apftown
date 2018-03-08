<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>国际教育-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    <meta name="keywords" content="中美,EMBA,课程,金融高级研修班,培训,基金国际班,私募国际班,国际基金培训,亚太EMBA,亚太金融,中美EMBA,金融培训,基金培训,亚太金融（基金）小镇" />
    <meta name="description" content="中美合作,创新金融,基金交流,共享财富,亚太金融研究院联合美国德克萨斯阿灵顿商学院首创亚太金融EMBA项目, 培养世界级创新金融企业家！" />
    
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/swiper-3.3.1.min.css">
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/apft.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors/colors.css">
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/pagination.css">
  </head>
  
  <body>
  <div class="wrap educ">
    <%@ include file="../comm/header.jsp" %>
  <%--   <a href="${pageContext.request.contextPath}/e/emba.do">1111</a> --%>
	<div class="swiper-container banner">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img src="<%=path %>/img/banner/banner1.jpg" alt="亚太金融（基金）小镇">
			</div>
			<div class="swiper-slide">
				<img src="<%=path %>/img/banner/banner2.jpg" alt="亚太金融（基金）小镇">
			</div>
			<div class="swiper-slide">
				<img src="<%=path %>/img/banner/banner3.jpg" alt="亚太金融（基金）小镇">
			</div>
			<div class="swiper-slide">
				<img src="<%=path %>/img/banner/banner4.jpg" alt="亚太金融（基金）小镇">
			</div>
		</div>
		<div class="masking-v2 full-w">
		</div>

		<div class="content full-w">
			<div class="container clear">
				<div class="col-sm-3 col-md-2 pl-0 pr-0 pt-20 mt-20 intro-text">
					<div class="overflow-h">
						<div class="triangle3">
						</div>
						<div class="gra-pri2">
							<h3 class="col-black pd-10 f-w f-16">国际教育</h3>
							<div class="pb-5 gra-pri2 ml-10 mr-10"></div>
							<ul class="pt-10 pb-20 t-none f-14 subnav line-h-20">	
								<c:forEach var="list1" items="${listMap1 }">
									<a <c:if test="${list1.code eq '3002' }"> href="<%=path %>/emba/Into.do"</c:if> >
										<li class="mb-5">
											<span class="inline-block full-w pl-15 pt-5 pb-5 cur-p <c:if test='${propCode == list1.code }'>cur-list</c:if>" onclick="changeCode(${list1.code });" id="${list1.code }"><i class="icon-double-angle-right f-16 col-pri pr-5"></i>${list1.name }</span>						
										</li>
									</a>
								</c:forEach>
							</ul>
						</div>			
					</div>				
				</div>
				<div class="col-sm-6 col-md-5 col-lg-4  banner-info">
						<p class="col-6 bg-pri pt-5 pb-5 f-16 col-white line-h-20">服务</p>
						<div class="text pd-10">
							<h3 class="col-white2 f-18 mr-20 col-10 pl-0">上风上水上青田，融资融商融亚太</h3>
							<p class="col-white2 line-h-20 mt-10 text-info">With fine surroundings and foremost policy,Sanya is trying to attract elite companies and individuals</p>
							<p class="f-18 pt-10 clear"><span class="pull-left col-white2 pt-10">宣传视频</span><img class="play pull-left img-30 ml-20" src="<%=path %>/img/video.png" alt="宣传视频"></p>
							<div class="swiper-button-next btn-next1 bg-pri icon-angle-right col-white f-24 f-w text-center"></div>
							<div class="swiper-button-prev btn-prev1 bg-pri icon-angle-left col-white f-24 f-w text-center"></div>
						</div>						
				</div>
			</div>
		</div>
		<div class="video col-7 pd-0 mt-10">
			<video class="full-wh" controls="controls" style="object-fit:fill">
				<source src="" type="video/mp4" />
				<source src="" type="video/ogg" />
				<source src="" type="video/webm" />
			</video>
			<div class="closevd clear full-w pd-5">
				<img class="pull-right cur-p" src="<%=path %>/img/close.png" alt="关闭视频按钮">
			</div>
		</div>
	</div>
	<div class="container clear mt-20 ">
		<div class="col-sm-2 pd-0">
			
			<div class="gra-pri2 pd-10" style="min-height:235px;">
				<c:forEach var="list0" items="${listMap0 }" varStatus="stat">	
					<c:if test="${list0.bk==0  }">
						<div class="line-h-25 edit pd-10" resId="${list0.id }">
							${list0.vtext }
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="col-sm-10 product pr-0">
			<h3 class="theme pd-5 f-16"><span class="inline-block f-w pl-10 pd-10 propName">&nbsp;</span></h3>
			<div class="bg-white clear pr-10">
				<c:forEach var="list2" items="${listMap }" > 
					<div class="col-sm-3 pl-10 pr-0">
				     		<div class="line-h-15 mt-10">
								<a href="<%=path %>/n/i.do?no=${list2.no}"> 
									<div class="img-out overflow-h">
										<img class="full-w transition1" src="${list2.img }" alt="亚太金融（基金）小镇" title="${list2.title }">
									</div> 
									<p class="text-overflow-1 col-black pt-5 pb-10 f-13">${list2.title }</p>
						     	</a>
								<p class="text-line-2 h-30 col-999 let-spa-1 f-12">${list2.title2 }</p>
								<div class="pt-10 pb-10 col-999">
									<fmt:formatDate value="${list2.update_time}" pattern="yyyy-MM-dd"/>
									<div class="pull-right">
										<span class="icon-heart-empty pull-left col-red-2 line-h-15"></span>
										<span class="pull-left pr-10">${list2.view_times }</span>
										<span class="pull-left  icon-comment-alt">
										</span>
										<span class="pull-left">${list2.comment }</span>
									</div>
								</div>
				     		</div>
					</div>
				</c:forEach>
				<form action="<%=path %>/e/index.do" id="pageForm">
					<input type="hidden" id="pageNum" name="pageNum" value="${pageNum }">
					<input type="hidden" id="pageSize" name="pageSize" value="${pageSize }">
					<input type="hidden" id="propCode" name="propCode" value="${propCode }">
				</form>
				<input type="hidden" id="totalCount" name="totalCount" value="${totalCount }">
				<!-- 放分页的DIV -->
				<div class="pageHtml"></div>
			</div>
			<div class="mt-15 mb-15">
				<div class="swiper-container swiper2 pd-10">
					<div class="swiper-wrapper">
						<c:forEach var="list201" items="${listMap201 }" >
							<c:if test="${list201.bk==201 }">
								<div class="montext swiper-slide pos-r">
									<a class="inline-block transition2" href="<%=path %>/n/i.do?no=${list201.no}"> 
										<img class="full-wh " src="${list201.img }" title="${list201.title }" >
										<p class="dis-n pos-b-0 pos-a rgba-70 line-h-15 col-ccc text-center col-12 text-overflow f-12
						     		    ">${list201.title }</p>
									</a>
								</div>
							</c:if>
						</c:forEach>
					</div>
					<div class="swiper-padination page2"></div>
				</div>
			</div>

		</div>
	</div>
	</div>
    <%@ include file="../comm/footer.jsp" %>
    <%@ include file="../comm/js.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/jquery.form.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/swiper-3.3.1.jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/pagination.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/fund/fund.js"></script>
    <script type="text/javascript" src="<%=path %>/js/comm/new_swiper.js"></script>
<script>
$(function(){
	var arr=['上风上水上青田，融资融商融亚太','产学研三位一体，投融资第二总部','发展南海金融、落地国家战略','扬帆远航共同驶向未来'];
	var arr2=['With fine surroundings and foremost policy,Sanya is trying to attract elite companies and individuals','A new headquarter for investment & financing:Industry-Education-Research Cooperation','To develop and improve finance in Hainan,toimplement national strategy,and to promote a sustainable economic growth in Asia-Pacific Region','Sail the Ocean Towards the Bright Future'];
	var banner=new Swiper('.banner',{
		autoHeight:true,
		effect:'fade',
		autoplay:3500,
		speed:1000,
		loop:true,
		autoplayDisableOnInteraction : false,
		nextButton:'.swiper-button-next',
		prevButton:'.swiper-button-prev',
		onTransitionStart:function(swiper){
			console.log(swiper.activeIndex);
			var i=swiper.activeIndex;
			if(i>4){i=1}
			$('.text h3').html(arr[i-1]);
			$('.text .text-info').html(arr2[i-1]);
		}
	})
})
</script>
</body>
</html>
