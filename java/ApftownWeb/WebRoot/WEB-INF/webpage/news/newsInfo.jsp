<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../comm/tag.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>新闻详情-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
	<meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
	<meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />

	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	<%@ include file="../comm/css.jsp"%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/apft.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors/colors.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ctrl/share/css/share.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ctrl/share/css/share-reset.css">

</head>

<body>
	<div class="wrap <c:if test="${newsInfo.code_val eq '2'}">fund</c:if><c:if test="${newsInfo.code_val eq '3' }">educ</c:if><c:if test="${newsInfo.code_val eq '4' }">research</c:if><c:if test="${newsInfo.code_val eq '5' }">serve</c:if><c:if test="${newsInfo.code_val eq '6' }">news</c:if>">
		<%@ include file="../comm/header.jsp" %>
		<!--================ 新闻页面开始 ===============-->
		<div class="container">
			<!--================== 面包屑导航部分 ================-->
			<div class="row clear bor-b-1">
				<ul class="hov-pri pull-right pd-10">
					<li class="pull-left">
						<a class="pr-5" href="#">首页</a> 
						<i class="inline-block icon-angle-right "></i>
					</li>
					<li class="pull-left">
						<a class="pr-5 pl-5" 
							href="<%=path %>/<c:if test="${newsInfo.code_val eq '1' }">t</c:if><c:if test="${newsInfo.code_val eq '2' }">f</c:if><c:if test="${newsInfo.code_val eq '3' }">e</c:if><c:if test="${newsInfo.code_val eq '4' }">r</c:if><c:if test="${newsInfo.code_val eq '5' }">s</c:if><c:if test="${newsInfo.code_val eq '6' }">n</c:if>/index.do">${newsInfo.code_desc }</a> 
						<i class="inline-block icon-angle-right "></i>
					</li>
					<li class="pull-left">
						<a class="pr-5 pl-5" href="<%=path %>/<c:if test="${newsInfo.code_val eq '1' }">t</c:if><c:if test="${newsInfo.code_val eq '2' }">f</c:if><c:if test="${newsInfo.code_val eq '3' }">e</c:if><c:if test="${newsInfo.code_val eq '4' }">r</c:if><c:if test="${newsInfo.code_val eq '5' }">s</c:if><c:if test="${newsInfo.code_val eq '6' }">n</c:if>/index.do?propCode=${newsInfo.code}">${newsInfo.name }</a> 
						<i class="inline-block icon-angle-right "></i>
					</li>
					<li class="pull-left"><a class="pr-5 pl-5 col-pri" href="#">正文</a>
					</li>
				</ul>
			</div>
			<!--=====================正文====================-->
			<div class="row clear">
				<div class="col-sm-9 pd-0">
					<div class="bg-white new-page">
						<h3 class="f-30 f-w let-spa-2 col-black pb-15 mt-10">${newsInfo.title}</h3>
						<p class="f-12 col-666 line-h-20">${ newsInfo.title2}</p>
						<div class="f-12 line-h-20 clear pt-10 bor-b-l pb-10">
							<p class="pull-left">
								<span class="col-999">来源&nbsp;:&nbsp;</span>
								<span class="col-999 pd-10 mr-10">${ newsInfo.vfrom }</span> 
								<span class="col-999">浏览&nbsp;:&nbsp;</span>
								<span class="col-999 pd-10">${newsInfo.view_num }</span> 
								<span class="col-999">作者&nbsp;:&nbsp;</span>
								<span class="col-999">${newsInfo.author}</span>
							</p>
							<span class="pull-right col-999">发布 ：<fmt:formatDate value="${ newsInfo.update_time}" type="date" pattern="yyyy-MM-dd" /> </span>
						</div>



						<!-- 放这里 -->
						<c:if test="${not empty newsInfo.vdesc }">
							<p class="line-h-20 col-666 pd-10 text-ind news-tit">
								${newsInfo.vdesc} 
							</p>
						</c:if>




						<!--  -->

						<div class="line-h-25 edit pd-10">
							<p class="text-center">
							</p>
							${ newsInfo.vtext}
						</div>
						<div class="clear pr-0">
							<div class="pull-right">
								<span class="cur-p laud f-22" onclick="<c:if test="${newsInfo.likes>0 }">nolike</c:if><c:if test="${newsInfo.likes==0 }">newslike</c:if>(this,'110','${newsInfo.id }')"><i class="icon-heart-empty"></i></span>
								<span class="f-12">（<em>${newsInfo.likes>0?newsInfo.likes:"0" }</em>）</span>
								<span class="cur-p collect f-22" onclick="<c:if test="${resInfo.collection>0 }">nolike</c:if><c:if test="${newsInfo.collection==0 }">newslike</c:if>(this,'120','${newsInfo.id }')"><i class="icon-star-empty"></i></span>
								<span class="f-12">（<em>${newsInfo.collection>0?newsInfo.collection:"0" }</em>）</span>
								<!-- <i><img src="${pageContext.request.contextPath}/img/user/weibo.png" class="img-35 ml-5 cur-p bor-ccc full-radius"></i>
								<i><img src="${pageContext.request.contextPath}/img/user/qqzone.png" class="img-35 ml-5 cur-p bor-ccc full-radius"></i>
								<i><img src="${pageContext.request.contextPath}/img/user/weixin.png" class="img-35 ml-5 cur-p bor-ccc full-radius"></i>
								<i><img src="${pageContext.request.contextPath}/img/user/face.png" class="img-35 ml-5 cur-p bor-ccc full-radius"></i>
								<i><img src="${pageContext.request.contextPath}/img/user/linkin.png" class="img-35 ml-5 cur-p bor-ccc full-radius"></i>
								<i><img src="${pageContext.request.contextPath}/img/user/twitter.png" class="img-35 ml-5 cur-p bor-ccc full-radius"></i>
								<span id="shareId" class="cur-p pd-5 f-14">分享</span> -->
								<div class="sharemeet share-reset"></div>
							</div>
						</div>
					</div>
					<%@ include file="../comm/comment.jsp"%>
				</div>
				<div class="col-sm-3 hidden-xs">
						<h3 class="pt-20 pb-10 f-16 col-red">
							<span class="f-18 pr-10 f-w col-red">|</span>相关内容
						</h3>
						<div class="pd-10 bg-gray bor-ccc ">
						<div class="full-w pos-r cur-p">
						<div class=" pro-img-2"> 
							<a href="<%=path %>/n/i.do?no=${newsInfo.no}">
								<img src="${newsInfo.img }" class="full-w full-h">
							</a>
						</div>
							<a href="<%=path %>/n/i.do?no=${newsInfo.no}">
								<p class="text-center pos-a full-w pos-l-0 pos-b-0 rgba-70 f-14 line-h-20 pd-5 col-white text-overflow ">
									${newsInfo.title }
								</p>
							</a>
						</div>
						<c:forEach var="newslist" items="${newslist }" varStatus="vs">
						 <c:if test='${vs.index<4 }'>
							<div class=" full-w clear pt-5 cur-p">
								<a href="<%=path %>/n/i.do?no=${newslist.no}">
									<div class="col-sm-5 pd-0 pro-img-3">
										<img src="${newslist.img }">
									</div>
								</a>
								<div class="col-sm-7 pl-5 pr-0">
									<a href="<%=path %>/n/i.do?no=${newslist.no}">
										<p class="line-h-20 text-line-2 col-555 f-12">
											${newslist.title }
										</p>
									</a>
								</div>
							</div>
							<p class="text-right col-999 bor-b-2 pb-5">
									<fmt:formatDate value="${newslist.update_time}" type="date" pattern="yyyy-MM-dd" />
							</p>
						</c:if>
						</c:forEach>
					</div>				
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="../comm/footer.jsp"%>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/laytpl.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/utils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ctrl/share/js/share.js"  id="shareFile"></script>


<div id="shareId" style="display:none"></div>
<%@ include file="../comm/js.jsp"%>
<script type="text/javascript">

	(function(Z) {
		    Z(".sharemeet").share({
		        image: $("meta[itemprop=image]").attr("content"),
		        title: $("meta[itemprop=name]").attr("content"),
		        link: "<%=basePath %>/n/i.do?no=${resInfo.no}",
		        vdesc: $("meta[itemprop=description]").attr("content"),
		        btnEvent:"#shareId",
		        "default":["weibo","qzone","fweixin","qq","facebook","twitter","google"]
		    });
		})(jQuery);
	$(function() {
	/*AND r.lang=${newsInfo.lang} AND r.lg=${newsInfo.lg}*/
		queryInfo(
				'commenntDemo',
				'searchlist',
				'DISTINCT(r.title),DATE_FORMAT(update_time,\'%m-%d\') update_time,img,r.id,r.no',
				'tv_res r,tb_res_prop_ln rpl',
				'r.cat_id=${newsInfo.cat_id} AND rpl.code=${newsInfo.code}  AND r.status=10 ORDER BY update_time DESC,ABS(r.lg - ${newsInfo.lg}) ASC',
				'1', '4');
		window["_baseNath"]=path;
		$(".laud").on("click",function(){
			var cla=$(this).find("i").attr("class")=="icon-heart-empty"?"icon-heart":"icon-heart-empty";
			$(this).find("i").attr("class",cla);
		})
		$(".collect").on("click",function(){
			var cla=$(this).find("i").attr("class")=="icon-star-empty"?"icon-star":"icon-star-empty";
			$(this).find("i").attr("class",cla);
		})
	});
</script>

<script type="text/html" id="commenntDemo">
	{{# for (var i in d){ }} 
		{{# if(i==0){ }}	 	
				
			<div class="full-w pos-r cur-p" onclick="window.location.href=window._baseNath+'n/i.do?no={{d[i].no}}'">
				<div class=" pro-img-2">
					<img src="{{ d[i].img }}" class="full-w full-h">
				</div>
				<p class="text-center pos-a full-w pos-l-0 pos-b-0 rgba-70 f-14 line-h-20 pd-5 col-white text-overflow">
					{{ d[i].title }}
				</p>
			</div>

		 {{# }else{  }} 	
			<div class=" full-w clear pt-5 cur-p bor-b-2 pb-5" onclick="window.location.href=window._baseNath+'n/i.do?no={{d[i].no}}'">
				<div class="col-sm-5 pd-0 pro-img-3">
					<img src="{{ d[i].img }}">
				</div>
				<div class="col-sm-7 pl-5 pr-0">
					<p class="line-h-20 text-line-2 col-555 f-12 h-40">
					{{ d[i].title }}
				</p>
				<p class="text-right pt-5">
					<span class="col-999" name="tt">{{d[i].update_time}}</span>
				</p>
				</div>
			</div>
			
		{{# } }}	
	{{# }  }}	
</script>
</body>
</html>
