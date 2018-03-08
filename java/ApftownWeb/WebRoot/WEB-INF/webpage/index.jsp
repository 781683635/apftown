<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./comm/tag.jsp" %>
 
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">

    <title>亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title> 
    <meta name="keywords" content="基金注册,注册基金,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,三亚金融小镇,海南金融小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	<meta name="baidu-site-verification" content="zFv9Ey26yf" />
	
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
   	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">

	<link rel="stylesheet" type="text/css" href="<%=path %>/css/comm/swiper-3.3.1.min.css">
	<%@ include file="./comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/apft.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors/colors.css">
	
	
  </head>
  
  <body>
  
	  <div class="wrap">
  			<%@ include file="./comm/header.jsp" %>
	  		
			<div class="swiper-container banner">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<img class="banner-img full-w" src="<%=path %>/img/banner/banner1.jpg" alt="亚太金融（基金）小镇">
					</div>
					<div class="swiper-slide">
						<img class="full-w" src="<%=path %>/img/banner/banner2.jpg" alt="亚太金融（基金）小镇">
					</div>
					<div class="swiper-slide">
						<img class="full-w" src="<%=path %>/img/banner/banner3.jpg" alt="亚太金融（基金）小镇">
					</div>
					<div class="swiper-slide">
						<img class="full-w" src="<%=path %>/img/banner/banner4.jpg" alt="亚太金融（基金）小镇">
					</div>
				</div>
				<div class="masking-v3 full-w">
				</div>
				<div class="content full-w">
					<div class="container clear">
						<div class="col-sm-3 col-md-2 pl-0 pr-0 pt-20 mt-20 intro-text">
							<div class="overflow-h">
								<div class="triangle3">
								</div>
								<div class="gra-pri2">
									<h3 class="col-black pd-10 f-w f-16">亚太金融(基金)小镇</h3>
									<div class="pb-5 gra-pri2 ml-10 mr-10"></div>
									<p class="line-h-20 index-left-info text-ind first-let let-spa-1 cur-p">
									作为海南省第一个金融（基金）小镇，亚太金融（基金）小镇自2017年1月3日揭牌以来，第一期2.8万平方米已经建成，以构建一个全方位的基金PB服务中心，创建三位一体（产学研）共生金融业态，形成五大特色基金总部基地（全球矿产能源、热带海洋与热带农业、大健康与不动产REITs、大数据与绿色金融、旅游影视音乐文创）为目标，致力于通过一三五模式，构建亚太金融投资生态系。
									<div class="pd-10"></div>
								</div>				
							</div>				
						</div>
						<div class="col-sm-6 col-md-5 col-lg-4 banner-info">
								<p class="col-6 bg-pri pt-5 pb-5 f-16 col-white line-h-20">服务</p>
								<div class="text pd-10">
									<h3 class="col-white2 f-18 mr-20 col-10 pl-0">上风上水上青田，融资融商融亚太</h3>
									<p class="col-white2 line-h-20 mt-10 text-info f-16 newline let-spa-1" style="font-family:Arial Narrow;">With fine surroundings and foremost policy,Sanya is trying to attract elite companies and individuals</p>
									<p class="f-16 pt-10 clear"><span class="pull-left col-white2 pt-5">宣传视频</span><img class="play pull-left img-30 ml-20" src="<%=path %>/img/video.png" alt="视频按钮"></p>
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
						<img class="pull-right cur-p" src="<%=path %>/img/close.png" alt="关闭视频">
					</div>
				</div>
			</div>
			<div class="container clear mt-20 ">
				<div class="col-sm-2 pd-0">				
					<div class="gra-pri2 pd-10 left-min-h">
						<c:forEach var="list0" items="${leftlist }" varStatus="stat">	
							<c:if test="${list0.bk==0 }">
								<div class="line-h-25 edit pd-10" id="${list0.id }">
									${list0.vtext }
								</div>
							</c:if>
						</c:forEach>
					</div>
					<div class="gra-pri2 mt-20 pd-10 left-min-h">
						<div class="line-h-25 cur-d"}">
							<p class="col-black f-16">
								热点知识
							</p>
							<div class="pb-5 gra-pri2 ml-5 mr-5"></div>
								<p class="col-success f-14 pt-5 pb-5">
									<a href="<%=path%>/NewsbaiduOne.do">1.&nbsp;&nbsp;小镇基金注册流程</a>
								</p>
								<p class="col-success f-14 pt-5 pb-5">
									<a href="<%=path%>/NewsbaiduTwo.do">2.&nbsp;&nbsp;基金公司注册条件及流程</a>
								</p>
								<p class="col-success f-14 pt-5 pb-5">
									<a href="<%=path%>/NewsbaiduThree.do">3.&nbsp;&nbsp;注册基金公司的条件</a>
								</p>
								<p class="col-success f-14 pt-5 pb-5">
									<a href="<%=path%>/NewsbaiduFour.do">4.&nbsp;&nbsp;基金注册、成立、备案、产品发行全流程</a>
								</p>
								<p class="col-success f-14 pt-5 pb-5">
									<a href="<%=path%>/NewsbaiduFive.do">5.&nbsp;&nbsp;基金分类与基金公司</a>
								</p>
								<p class="col-success f-14 pt-5 pb-5">
									<a href="<%=path%>/NewsbaiduSix.do">6.&nbsp;&nbsp;基金公司设立原则条件和流程</a>
								</p>
								<p class="col-success f-14 pt-5 pb-5">
									<a href="<%=path%>/NewsbaiduSeven.do">7.&nbsp;&nbsp;基金公司管理相关内容</a>
								</p>
								<p class="col-success f-14 pt-5 pb-15">
									<a href="<%=path%>/NewsbaiduEight.do">8.&nbsp;&nbsp;基金公司数据和政策</a>
								</p>
						</div>
					</div>
				</div>
				<!-- 产 -->
				<div class="col-sm-10 product pr-0">
					<h3 class="theme f-16 clear mobile-hot pt-10 pl-10 pr-5 pb-5 clear" >
						<div class="bor-b-l bor-pri pull-left col-sm-3 col-lg-2 pl-0">
							<span class="span1 pull-left bg-pri col-white pl-10 pr-5 f-w">产</span>
				    		<span class="span2 pull-left "></span>
				    		<span class="span1 pull-left pl-5 ">亚太金融</span>
			    		</div>
					</h3>
					<div class="bg-white clear pr-10">
						<c:forEach var="list1" items="${listMap }" >
							<c:if test="${list1.bk=='101' }">
								<div class="col-sm-3 pl-10 pr-0">  
						     		<!-- <h3 class="col-pri f-16 pt-10 pb-10">基金业态</h3> -->
						     		<div class="line-h-15 mt-10">
						     			<a href="<%=path %>/n/i.do?no=${list1.no}">
						     				<div class="img-out overflow-h">
						     					<img class="full-w transition1" src="${list1.img }" alt="亚太金融（基金）小镇" title="${list1.title }">
						     				</div>  
											<p class="text-overflow col-black pt-5 pb-10 f-13">${list1.title }</p>
										</a>
										<p class="text-line-2 h-30 col-999 let-spa-1 f-12">${list1.title2 }</p>
										<div class="clear pt-10 pb-10  col-999">
										<time class="col-999 pull-left"><fmt:formatDate value="${list1.update_time}" pattern="yyyy-MM-dd"/></time>
											
											<!-- <span class="hidden-sm"><i class=" icon-comment-alt pull-right cur-p"></i>${list1.view_times }
											<i class="icon-heart-empty pull-right pl-10 cur-p"></i>${list1.comment }</span> -->
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
							</c:if>
						</c:forEach>
					</div>			
				
					<div class="mt-15 mb-15">
						<div class="swiper-container swiper2 pd-10">
							<div class="swiper-wrapper">
								<c:forEach var="list2" items="${listMap }" >
									<c:if test="${list2.bk == '201' }">
										<div class="swiper-slide pos-r montext">
											<a class="inline-block
											transition2" href="<%=path %>/n/i.do?no=${list2.no}"> 
												<img class="full-wh " src="${list2.img }" title="${list2.title }">
												<p class="dis-n pos-b-0 pos-a rgba-70 col-ccc text-center col-12 text-overflow line-h-15 f-12
						     		    ">${list2.title }</p>
											</a>
										</div>
									</c:if>
								</c:forEach>
							</div>
							<div class="swiper-padination page2"></div>
						</div>
					</div>
					<!-- 学 -->			
					<h3 class="theme f-16 clear mobile-hot pt-10 pl-10 pr-5 pb-5 clear">
						<div class="bor-b-l bor-pri pull-left col-sm-3 col-lg-2 pl-0">
							<span class="span1 pull-left bg-pri col-white pl-10 pr-5 f-w">学</span>
							<span class="span2 pull-left "></span>
							<span class="span1 pull-left pl-5 ">亚太金融</span>
						</div>
					</h3>
					<div class="bg-white clear">
						<c:forEach var="list3" items="${listMap }" >
							<c:if test="${list3.bk==301 }">
								<div class="col-sm-6 pb-10"> 
						     		<div class="clear mt-10">
						     			<div class="col-md-4 col-sm-5 pd-5">
						     				<a href="<%=path %>/n/i.do?no=${list3.no}"> 
								     			<div class="img-out overflow-h">
								     				<img class="full-w transition1" src="${list3.img }" alt="亚太金融（基金）小镇" title="${list3.title }">
								     			</div>
							     			</a>
								     	</div>
							     		<div class="col-md-8 col-sm-7 line-h-15 pl-5 pr-5">
							     			<a href="<%=path %>/n/i.do?no=${list3.no}"> 
												<p class="text-overflow col-black pb-5 f-13 pt-5">${list3.title }</p>
											</a>
											<p class="text-line-2 h-30 col-999 let-spa-1 f-12">${list3.title2 }</p>
											<div class="pt-5 clear">
												<time class="col-999 pull-left"><fmt:formatDate value="${list3.update_time}" pattern="yyyy-MM-dd"/></time>
												<!-- <span class="hidden-sm"><i class=" icon-comment-alt pull-right cur-p"></i>${list3.view_times }
												<i class="icon-heart-empty pull-right pl-10 cur-p"></i>${list3.comment }</span> -->
												<div class="pull-right">
													<span class="icon-heart-empty pull-left col-red-2 line-h-15"></span>
													<span class="pull-left pr-10 pr-5">${list3.view_times }</span>
													<span class="pull-left icon-comment-alt">
													</span>
													<span class="pull-left">${list3.comment }</span>
												</div>
											</div>
							     		</div>
						     		</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
					<div class="mt-15 mb-15">
						<div class="swiper-container swiper3 pd-10">
							<div class="swiper-wrapper">
								<c:forEach var="list4" items="${listMap }" >
									<c:if test="${list4.bk==401 }">
										<div class="swiper-slide pos-r montext"> 
											<a class="inline-block
											transition2" href="<%=path %>/n/i.do?no=${list4.no}"> 
												<img class="full-wh " src="${list4.img }" title="${list4.title }" >
												<p class="dis-n pos-b-0 pos-a rgba-70 col-ccc text-center col-12 text-overflow line-h-15 f-12
						     		    ">${list4.title }</p>
											</a>
										</div>
									</c:if>
								</c:forEach>
							</div>
							<div class="swiper-padination page3"></div>
						</div>
					</div>	
					
					<!-- 研 -->		
					<h3 class="theme f-16 clear mobile-hot pt-10 pl-10 pr-5 pb-5 clear">
						<div class="bor-b-l bor-pri pull-left col-sm-3 col-lg-2 pl-0">
							<span class="span1 pull-left bg-pri col-white pl-10 pr-5 f-w">研</span>
							<span class="span2 pull-left "></span>
							<span class="span1 pull-left pl-5 ">亚太金融</span>
						</div>
					</h3>
					<div class="bg-white clear pr-15">
						<c:forEach var="list5" items="${listMap }" >
							<c:if test="${list5.bk==501 }">
								<div class="col-sm-3 pl-10 pr-0"> 
						     		<!-- <h3 class="col-pri f-16 pt-10 pb-10">基金业态</h3> -->
						     		<div class="line-h-15 mt-10">
						     			<a href="<%=path %>/n/i.do?no=${list5.no}">
						     				<div class="img-out overflow-h">
						     					<img class="full-w transition1" src="${list5.img }" alt="亚太金融（基金）小镇">
						     				</div> 
											<p class="text-overflow col-black pt-5 pb-10 f-13">${list5.title }</p>
										</a>
										<p class="text-line-2 col-999 let-spa-1 f-12 h-30">${list5.title2 }</p>
										<div class="pt-10 pb-10 clear">
											<time class="col-999 pull-left"><fmt:formatDate value="${list5.update_time}" pattern="yyyy-MM-dd"/></time>
											<div class="pull-right">
												<span class="icon-heart-empty pull-left col-red-2 line-h-15"></span>
												<span class="pull-left pr-5">${list5.view_times }</span>
												<span class="pull-left  icon-comment-alt">
												</span>
												<span class="pull-left">${list5.comment }</span>
											</div>
										</div>
						     		</div> 
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>	
	  </div>
		<div id="fuceng">
			<div class="container text-center">
				<div class="col-sm-offset-1 clear">
					<div class="col-sm-2">
						<span class="join cur-p" onclick="javascript:window.location.href='<%=path %>/user/fInto.do'">join us</span>
					</div>
					<div class="col-sm-2">
						<div class="item-1 items">
							<span><i></i>政府支持</span>
							<p>促进三亚金融发展<br>鼓励基金公司入驻</p>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="item-1 items">
							<span><i></i>卓越环境</span>
							<p>海棠湾核心<br>2.8万平建筑面积</p>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="item-1 items">
							<span><i></i>政府支持</span>
							<p>促进三亚金融发展<br>鼓励基金公司入驻</p>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="item-2 cur-p" onclick="javascript:window.location.href='<%=path %>/user/fInto.do'">
							<p class="f-16">点击入驻</p>
							<p class="f-20 f-w">金融小镇</p>
						</div>
					</div>
				</div>
			</div>
				<span class="close cur-p">×</span>			
		</div>
	<%@ include file="./comm/footer.jsp" %> 	
	<%@ include file="./comm/js.jsp" %>
	
	<script type="text/javascript" src="<%=path %>/js/comm/swiper-3.3.1.jquery.min.js"></script>
  	<script type="text/javascript" src="<%=path %>/js/comm/new_swiper.js"></script>

  	
<%--   	<script type="text/javascript" src="<%=path %>/js/index.js"></script> --%>
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
			var i=swiper.activeIndex;
			if(i>4){i=1}
			$('.text h3').html(arr[i-1]);
			$('.text .text-info').html(arr2[i-1]);
		}
	});
	$('.pands').on('click', function(){ 
 			window.location.href = path + "user/fCInfo.do";
	});

	// 关闭底部浮层
	$("#fuceng .close").on('click',function(){
		$('#fuceng').hide();
	})
	$('.pands').on('click', function(){ 
 			window.location.href = path + "user/fInto.do";
	});
})

</script>
  </body>
</html>
