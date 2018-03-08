<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<base href="<%=basePath%>">
    
    <title>亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/comm/swiper-3.3.1.min.css">
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="<%=path %>/css/m/mobile-apft.css">
	<link rel="stylesheet" href="<%=path %>/css/colors/colors.css">
</head>
<body>
	<div class="wrap">
		<%@ include file="../comm/header.jsp" %>
		 <!-- center -->
    <%@ include file="./comm/center.jsp" %>
		<!-- banner -->
		<div class="pd-5">
			<div class="swiper-container banner">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<img src="<%=path %>/img/banner/banner1.jpg" alt="亚太金融（基金）小镇">
						 <p class="pos-a pos-l-0 pos-b-0 full-w rgba-70 pd-5 text-overflow-1 col-ccc text-center">发展南海金融、落地国家战略</p> 
					</div>
					<div class="swiper-slide">
						<img src="<%=path %>/img/banner/banner2.jpg" alt="亚太金融（基金）小镇">
						<p class="pos-a pos-l-0 pos-b-0 full-w rgba-70 pd-5 text-overflow-1 col-ccc text-center">扬帆远航共同驶向未来</p>
					</div>
					<div class="swiper-slide">
						<img src="<%=path %>/img/banner/banner3.jpg" alt="亚太金融（基金）小镇">
						<p class="pos-a pos-l-0 pos-b-0 full-w rgba-70 pd-5 text-overflow-1 col-ccc text-center">产学研三位一体，投融资第二总部</p>
					</div>
					<div class="swiper-slide">
						<img src="<%=path %>/img/banner/banner4.jpg" alt="亚太金融（基金）小镇">
						<p class="pos-a pos-l-0 pos-b-0 full-w rgba-70 pd-5 text-overflow-1 col-ccc text-center">上风上水上青田，融资融商融亚太</p>
					</div>
				</div>
			</div>
		</div>
		<div class="pt-5 bg-gray"></div>
		<!-- 二级菜单 -->
		<div class="pd-5">
			<div class="swiper-container h-35 subnav">
				<div class="swiper-wrapper col-pri text-center">
					<div class="swiper-slide"><a class="inline-block pt-10 pb-10" href="">加盟小镇<i class="inline-block pt-5 pl-5 icon-globe col-pri"></i></a><span class="pull-right pt-10 col-999">|</span></div>
					<div class="swiper-slide"><a class="inline-block pt-10 pb-10" href="">EMBA培训<i class="inline-block pt-5 pl-5 icon-repeat col-pri"></i></a><span class="pull-right pt-10 col-999">|</span></div>
					<div class="swiper-slide"><a class="inline-block pt-10 pb-10" href="">金融大数据<i class="inline-block pt-5 pl-5 icon-repeat col-pri"></i></a><span class="pull-right pt-10 col-999">|</span></div>
					<div class="swiper-slide"><a class="inline-block pt-10 pb-10" href="">培训基地<i class="inline-block pt-5 pl-5 icon-repeat col-pri"></i>
					</a></div>
				</div>
			</div>
		</div>
		<div class="pb-5 bg-gray"></div>
		<!-- 产 -->
		<div class="pd-5">
	    	<div class="f-14 mobile-hot bor-b-l bor-pri clear mt-5 mb-5">
	    		<span class="span1 pull-left bg-pri col-white pl-10 pr-5 f-w">产</span>
	    		<span class="span2 pull-left"></span><span class="span1 pull-left pl-5">亚太金融</span>
	    		<!-- <a class="ft-14 pull-right mr-10 col-999">更多<i class="icon-double-angle-right f-18 pl-5 col-999"></i></a> -->
	    	</div>
			<div class="clear mt-5">
				<c:forEach var="list1" items="${listMap }" varStatus="stat">
					<c:if test="${list1.bk==101}">
						<div class="col-xs-6  pt-5 pb-15 pl-5 pr-5" onclick="window.location.href='<%=path %>/n/i.do?no=${list1.no}'">
							<img class="m-showimg" src="${list1.img }" alt="${list1.title }" title="${list1.title }">
							<p class="text-overflow-1 col-black f-14 pt-5">${list1.title }</p>
							<p class=" col-999 mt-10 h-15 line-h-15 text-overflow let-spa-1">${list1.title2 }</p>
							<div class="clear pt-10">
								<time class="pull-left col-999"><fmt:formatDate value="${list1.update_time}" pattern="yyyy-MM-dd"/></time>
								<div class="pull-right">
									<span class="icon-heart-empty pull-left col-red-2 line-h-15"></span>
									<span class="pull-left pr-10">${list1.view_times }</span>
									<span class="pull-left  icon-comment-alt">
									</span>
									<span class="pull-left">${list1.comment }</span>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="pb-5 bg-gray"></div>
		<div class="pd-5 mg-5 gradient-black">
			<div class="swiper-container swiper4">
				<div class="swiper-wrapper">
					<c:forEach var="list2" items="${listMap }" varStatus="stat">
						<c:if test="${list2.bk eq '201' }">
							<div class="swiper-slide" onclick="window.location.href='<%=path %>/n/i.do?no=${list2.no}'">
								<img src="${list2.img }" alt="${list2.title }">
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
		
		<div class="pb-5 bg-gray"></div>
		<!-- 学 -->
		<div class="pd-5">
			<div class="f-14 mobile-hot bor-b-l bor-pri clear mt-5 mb-5">
				<span class="span1 pull-left bg-pri col-white pl-10 pr-5 f-w">学</span>
				<span class="span2 pull-left"></span><span class="span1 pull-left pl-5">亚太金融</span>
				<!-- <a class="ft-14 pull-right mr-10 col-999">更多<i class="icon-double-angle-right f-18 pl-5 col-999"></i></a> -->
			</div>
			<div>
				<c:forEach var="list3" items="${listMap }" varStatus="stat">
					<c:if test="${list3.bk==301 }">
						<div class="clear bor-b-l" onclick="window.location.href='<%=path %>/n/i.do?no=${list3.no}'">
							<div class="col-xs-4 pd-5 mt-5 mb-5">
								<img src="${list3.img }" alt="${list3.title }">
							</div>
							<div class="col-xs-8 pd-5 mt-5 mb-5">
								<p class="text-overflow-1 col-black f-14">${list3.title }</p>
								<p class="text-line-2 h-35 col-999 pt-5 line-h-15 newline let-spa-1">${list3.title2 }</p>
								<div class="pt-5 clear">
									<time class="pull-left col-999"><fmt:formatDate value="${list3.update_time}" pattern="yyyy-MM-dd"/></time>
									<div class="pull-right">
										<span class="icon-heart-empty pull-left col-red-2 line-h-15"></span>
										<span class="pull-left pr-10">${list3.view_times }</span>
										<span class="pull-left  icon-comment-alt">
										</span>
										<span class="pull-left">${list3.comment }</span>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="pb-5 bg-gray"></div>
		<div class="pd-5 mg-5 gradient-black">
			<div class="swiper-container swiper4">
				<div class="swiper-wrapper">
					<c:forEach var="list4" items="${listMap }" varStatus="stat">
						<c:if test="${list4.bk eq '401' }">
							<div class="swiper-slide" onclick="window.location.href='<%=path %>/n/i.do?no=${list4.no}'">
								<img src="${list4.img }" alt="${list4.title }">
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>	
		<div class="pb-5 bg-gray"></div>
		<!-- 研 -->
		<div class="pd-5">
	    	<div class="f-14 mobile-hot bor-b-l bor-pri clear mt-5 mb-5">
	    		<span class="span1 pull-left bg-pri col-white pl-10 pr-5 f-w">研</span>
	    		<span class="span2 pull-left"></span><span class="span1 pull-left pl-5">亚太金融</span>
	    		<!-- <a class="ft-14 pull-right mr-10 col-999">更多<i class="icon-double-angle-right f-18 pl-5 col-999"></i></a> -->
	    	</div>
			<div class="clear mt-5">
				<c:forEach var="list5" items="${listMap }">
					<c:if test="${list5.bk==501 }">
						<div class="col-xs-6 pt-5 pb-15 pl-5 pr-5"  onclick="window.location.href='<%=path %>/n/i.do?no=${list5.no}'">
							<img class="m-showimg" src="${list5.img }" alt="${list5.title }">
							<p class="text-overflow-1 col-black f-14 pt-5">${list5.title }</p>
							<p class="h-15 mt-10 col-999 line-h-15 text-overflow let-spa-1">${list5.title2 }</p>
							<div class="clear pt-10">
								<time class="pull-left col-999"><fmt:formatDate value="${list5.update_time}" pattern="yyyy-MM-dd"/></time>
								<div class="pull-right">
									<span class="icon-heart-empty pull-left col-red-2 line-h-15"></span>
									<span class="pull-left pr-10">${list5.view_times }</span>
									<span class="pull-left  icon-comment-alt">
									</span>
									<span class="pull-left">${list5.comment }</span>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
	
	<%@ include file="../comm/footer.jsp" %> 	
	<%@ include file="../comm/js.jsp" %>
	<script type="text/javascript" src="<%=path %>/js/comm/swiper-3.3.1.jquery.min.js"></script>
  	
	<script>
		var mobile_nav=new Swiper(".mobile-nav",{
			slidesPerView:4,
			spaceBetween:10,
			autoplay:2500,
			speed:1300,
			autoplayDisableOnInteraction : false,
		});
		mobile_nav.slideTo(0,0);
		var swiper2=new Swiper(".banner",{
			autoHeight:true,
			effect:'fade',
			autoplay:3500,
			speed:1000,
			loop:true,
			autoplayDisableOnInteraction : false,
		});
		var swiper3=new Swiper(".subnav",{
			slidesPerView:3,
			spaceBetween:0,
			loop:true,
			autoplay:2000,
			speed:1300,
			autoplayDisableOnInteraction : false,
		});
		var swiper4=new Swiper(".swiper4",{
			autoHeight:true,
			autoplay:3000,
			speed:1300,
			slidesPerView:4,
			spaceBetween:5,
			loop:true,
		});
	</script>
</body>
</html>