<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../comm/tag.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基金一条街-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=path %>/css/comm/swiper-3.3.1.min.css">
	<%@ include file="../../comm/css.jsp" %>
	<link rel="stylesheet" href="<%=path %>/css/m/mobile-apft.css">
	<link rel="stylesheet" href="<%=path %>/css/colors/colors.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/pagination.css">
  </head>
  
  <body>
  <div class="wrap">
    <%@ include file="../../comm/header.jsp" %>
     <!-- center -->
    <%@ include file="../comm/center.jsp" %>
		<!-- banner -->
	<div class="pd-5">
		<div class="swiper-container banner">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img src="<%=path %>/img/banner/banner1.jpg" alt="亚太金融（基金）小镇">
					<p class="pos-a pos-l-0 pos-b-0 full-w rgba-70 pd-5 text-overflow-1 col-ccc text-center">上风上水上青田，融资融商融亚太</p>
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
					<p class="pos-a pos-l-0 pos-b-0 full-w rgba-70 pd-5 text-overflow-1 col-ccc text-center">发展南海金融、落地国家战略</p>
				</div>
		</div>
	</div>
	<div class="pd-5 bg-gray"></div>
	<!-- 二级菜单 -->
	<!-- <div class="pd-5">
		<div class="swiper-container h-35 subnav">
			<div class="swiper-wrapper col-pri text-center">
				<c:forEach var="list1" items="${listMap1 }">
					<div class="swiper-slide"><a class="inline-block pt-10 pb-10 <c:if test='${propCode == list1.code }'>current-list</c:if>" onclick="changeCode(${list1.code });" id="${list1.code }" href="javascript:;" >${list1.name }<i class="inline-block pt-5 pl-5 icon-globe col-pri"></i></a><span class="pull-right pt-10 col-999">|</span></div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="pb-5 bg-gray"></div> -->
		<!-- 产 -->
	<div class="pd-5">
    	<div class="clear">
    		<div class="col-xs-9 pl-5 pr-5 mt-5">
    			<!-- <div class="swiper-container swiper-news h-35 pl-5">
    				<div class="swiper-wrapper line-h-20">
    									<div class="swiper-slide">
    									<p class="pt-10 text-overflow-1"><a href=""><i class="icon-double-angle-up pr-5 col-pri f-13"></i>内蒙古鄂伦春自治旗吉峰林场铅锌金多金属矿项目</a></p>
    									</div>
    									<div class="swiper-slide">
    									<p class="pt-10 text-overflow-1"><a href=""><i class="icon-double-angle-up pr-5 col-pri f-13"></i>珠海蓝天地力钛业高新技术项目</a></p>
    									</div>
    									<div class="swiper-slide">
    									<p class="pt-10 text-overflow-1"><a href=""><i class="icon-double-angle-up pr-5 col-pri f-13"></i>内蒙古珠海蓝天地力钛业高新技术项目</a></p>
    									</div>
    									<div class="swiper-slide">
    									<p class="pt-10 text-overflow-1"><a href=""><i class="icon-double-angle-up pr-5 col-pri f-13"></i>珠海蓝天内蒙古鄂伦春自治旗吉</a></p>
    									</div>
    				</div>
    			</div> -->
    			<div class="swiper-container h-35 subnav">
					<div class="swiper-wrapper col-pri text-center">
						<span class="pull-right pt-10 col-999">|</span>
						<c:forEach var="list1" items="${listMap1 }">
							<div class="swiper-slide"><a class="inline-block pt-10 pb-10 <c:if test='${propCode == list1.code }'>current-list</c:if>" onclick="changeCode(${list1.code });" id="${list1.code }" href="javascript:;" >${list1.name }<i class="inline-block pt-5 pl-5 icon-globe col-pri"></i></a><span class="pull-right pt-10 col-999">|</span></div>
						</c:forEach>
					</div>
				</div>
    		</div>
    		<div class="col-xs-3 pd-0 f-20 mt-5">
    			<span class="pull-right icon-th-list pd-5 ml-10 switchB"></span>
    			<span class="pull-right icon-th-large pd-5 col-pri switchA"></span>
    		</div>
    	</div>

		<div class="clear mt-5">
			<c:forEach var="list1" items="${listMap }">
				<div class="col-xs-6 pt-5 pb-15 pl-5 pr-5 lists">
					<a href="<%=path %>/n/i.do?no=${list1.no}">
						<img class="m-showimg" src="${list1.img }" alt="亚太金融（基金）小镇" title="${list1.title }">
					</a>
					<div class="list-info">
						<a href="<%=path %>/n/i.do?no=${list1.no}">
							<p class="text-overflow-1 col-black f-14 pt-5">${list1.title }</p>
						</a>
						<p class=" col-999 mt-10 h-15 line-h-15 text-overflow let-spa-1">${list1.title2 }</p>
						<div class="clear pt-10">
							<time class="pull-left col-999"><fmt:formatDate value="${list1.update_time}" pattern="yyy-MM-dd"/> </time>
							<div class="pull-right">
								<span class="icon-heart-empty pull-left col-red-2 line-h-15"></span>
								<span class="pull-left pr-10">${list1.view_times }</span>
								<span class="pull-left  icon-comment-alt">
								</span>
								<span class="pull-left">${list1.comment }</span>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<form action="<%=path %>/f/index.do" id="pageForm" method="get">
				<input type="hidden" id="pageNum" name="pageNum" value="${pageNum }">
				<input type="hidden" id="pageSize" name="pageSize" value="${pageSize }"> 
				<input type="hidden" id="propCode" name="propCode" value="${propCode }"> 
			</form>
			<input type="hidden" id="totalCount" value="${totalCount }"> 
			<!-- 放分页的DIV -->
			<div class="pageHtml"></div>			
		</div>
	</div>
	<div class="pb-5 bg-gray"></div>
	<div class="pd-5 mg-5 gradient-black">
		<div class="swiper-container swiper4">
			<div class="swiper-wrapper">
				<c:forEach var="list201" items="${listMap201 }">
					<c:if test="${list201.bk==201 }">
						<div class="swiper-slide">
							<a href="<%=path %>/n/i.do?no=${list201.no}">
								<img src="${list201.img }" alt="亚太金融（基金）小镇" title="${list201.title }">
							</a>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div> 
	<div class="pb-5 bg-gray"></div>
	<div class="clear pl-5 pr-5 mt-5">
		<div class="h-35 subnav col-pri text-center">
			<div class="col-6 pull-left bor-ccc bor-t-none bor-b-none bor-l-none">
                <a class="inline-block pt-10 pb-10 current-list" onclick="fOptRes('./infoSub2.do')">
                    入园申请
                    <i class="inline-block pt-5 pl-5 icon-globe col-pri"></i>
                </a>
            </div>
            <div class="col-6 pull-left">
                <a class="inline-block pt-10 pb-10 current-list" href="<%=path %>/f/fInto.do">
                    政策与服务
                    <i class="inline-block pt-5 pl-5 icon-globe col-pri"></i>
                </a>
            </div>
		</div>
	</div>
</div>
</div>	
	<%@ include file="../../comm/footer.jsp" %>
	<%@ include file="../../comm/js.jsp" %>
	<script type="text/javascript" src="<%=path %>/js/comm/swiper-3.3.1.jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/pagination.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/fund/fund.js"></script>
	
	<script>
	$(function(){
		var mobile_nav=new Swiper(".mobile-nav",{
			slidesPerView:4,
			spaceBetween:10,
			autoplay:2500,
			speed:1300,
			autoplayDisableOnInteraction : false,
		})
		mobile_nav.slideTo(2,0)
		var swiper2=new Swiper(".banner",{
			autoHeight:true,
			effect:'fade',
			autoplay:3500,
			speed:1000,
			loop:true,
			autoplayDisableOnInteraction : false,
		})
		var swiper3=new Swiper(".subnav",{
			slidesPerView:2,
			spaceBetween:0,
			loop:true,
			autoplay:2000,
			speed:1300,
			autoplayDisableOnInteraction : false,
		})
		var swiper4=new Swiper(".swiper4",{
			autoHeight:true,
			autoplay:3000,
			speed:1300,
			slidesPerView:4,
			spaceBetween:5,
			loop:true,
		})
		var swiper_news=new Swiper('.swiper-news',{
			direction : 'vertical',
			autoplay:3000,
			speed:1500,
			loop:true,
		})
		$(".switchB").click(function(){
			$(".lists").addClass("list-style2");
			$(this).addClass("col-pri");
			$(".switchA").removeClass("col-pri");
		})
		$(".switchA").click(function(){
			$(".lists").removeClass("list-style2");
			$(this).addClass("col-pri");
			$(".switchB").removeClass("col-pri");
		})
	})
		
	</script>
	
  </body>
</html>
