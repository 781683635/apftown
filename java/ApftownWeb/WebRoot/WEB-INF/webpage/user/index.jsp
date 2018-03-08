<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>


<% menuType = "1.1";%>

<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<title>用户中心-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
<!-- ==========meta开始========== -->	
<!-- 清空浏览器本地缓存 -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
<!-- 本网页关键字和关键内容 -->
	<meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
<!-- 采用webkit内核(急速内核) -->
	<meta name="renderer" content="webkit">
<!-- 移动屏幕的缩放初始缩放比例1.0，不允许用户缩放，最小比例1.0，最大比例1.0 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
<!-- 网站开启对web app的支持 -->
	<meta name="apple-mobile-web-app-capable" content="yes">
<!-- web app顶部状态条的颜色为灰色半透明 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
<!-- 忽略页面中的数值识别为电话号码 -->
	<meta name="format-detection" content="telephone=no">
<!-- web app设备添加到主屏幕后全屏显示 -->
	<meta name="apple-touch-fullscreen" content="yes">
<!-- uc浏览器强制全屏	 -->
	<meta name="full-screen" content="yes">
<!-- 以utf-8格式编码 -->
	<meta charset="UTF-8">
<!-- ==========meta结束========== -->
<!-- ==========link开始========== -->		
<!-- 基本样式文件 -->
	<link rel="stylesheet" href="<%=path %>/css/comm/swiper-3.3.1.min.css">
	<%@ include file="../comm/css.jsp" %>
	
	<link rel="stylesheet" href="<%=path %>/css/user/user.css">

<!-- ==========link结束========== -->
<!-- ==========script结束========== -->

</head>
<body>
	<div class="wrap">
		<%@ include file="../comm/header.jsp" %>
		<div class="container">
			<div class="clear">
				<img class="pull-left" src="<%=path %>/img/user/user03.png" alt="亚太金融（基金）小镇"> 
				<span class="pull-left f-18 pt-20 pl-10">用户中心</span>
				<span class="pull-right hov-primary pt-20">
					<a class="hov-primary" href="<%=path %>/index.do">首页</a>
					<i class=" icon-angle-right pl-5 pr-5"></i>用户首页
				</span>
			</div>
			<div class="row clear mb-20 pb-20 mt-10">
				<%@ include file="./menu.jsp"%>
				<!-- 内容开始 -->
				<div class="col-md-10 col-sm-12">
					<!-- 第一栏 -->
					<div class="row clear bor-light mb-15">
						<div class="col-lg-4 col-md-4 col-sm-5 pd-20">
							<div class="clear">
								<img class="pull-left full-wh use-img full-radius" src="${empty tbUser.userImg?'img/comm/noupload.jpg':tbUser.userImg }" alt="亚太金融（基金）小镇">
								<div class="pull-left pl-15">
									<p class="col-333 f-16 pt-5">${tbUser.getRegName() } <!-- <span class="col-555 f-12"> Xiaoxiao Liao </span> --></p>
									<p class="pt-10">账户积分 : <span class="col-success">100</span></p>
									<!-- <p class="pt-10">认证等级 :
										<i class="xinyong"></i>
										<i class="xinyong"></i>
										<i class="xinyong"></i>
										<i class="xinyongno"></i>
										<i class="xinyongno"></i>
									</p> -->
									<p class="pt-10">账户安全 : <span class="col-success">较高</span></p>
								</div>
							</div>
							<div class="clear pt-10 pl-20">
								<!-- 1-手机，2-(1:add,2:llapy,3:bfcer,4:fy)银行卡，3-身份证，4-资金密码，5-用户名，6-头像，7-邮件， --> 
								<a href="<%=path %>/user/userAuthen.do" title="用户名" class="pull-left mr-10 i-user${fn:substring(tbUser.userStatus, 4, 5)!='1'?'':'-act' } img-25"></a>
								<a href="<%=path %>/user/userAuthen.do" title="登录密码" class="pull-left mr-10 i-pwd img-25"></a>
								<a href="<%=path %>/user/userAuthen.do" title="个人头像" class="pull-left mr-10 i-github${fn:substring(tbUser.userStatus, 5, 6)!='1'?'':'-act' } img-25"></a>
								<a href="<%=path %>/user/userAuthen.do" title="手机号" class="pull-left mr-10 i-phone${fn:substring(tbUser.userStatus, 0, 1)!='1'?'':'-act' } img-25"></a>
								<a href="<%=path %>/user/userAuthen.do" title="邮箱" class="pull-left mr-10 i-globe${fn:substring(tbUser.userStatus, 6, 7)!='1'?'':'-act' } img-25"></a>
								<!-- <a href="#" title="银行卡" class="pull-left mr-10 i-cardh img-25"></a> -->
							</div>
						</div>
					</div>
					<!-- 第二栏 -->
					<!-- <div class="row clear bor-light mb-15">
						<div class="col-lg-9 col-md-9 col-sm-8 pd-20">
							<div>
							    <p class="clear">
							    	<strong class="f-14 col-666 pull-left">我的订阅</strong> 
								    <a href="#" class="pull-right ">
								   		查看全部<i class="icon-double-angle-right f-14"></i>
								    </a>
							    </p>
							    <div class="pt-20 clear mt-10">
							    </div>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-4 pd-20 bor-light bor-t-none bor-r-none bor-b-none">
							<p class="pd-10 f-14 f-w text-center">会员推荐</p>
							会员推荐轮播
							<div class="pos-r">
							<div class="swiper-container full-w overflow-h swiper1">
							    <div class="swiper-wrapper" id="recommList">
							    </div>
						    
							</div>
							<div class="swiper-button-prev swi-prev1" ></div>
							<div class="swiper-button-next swi-next1" ></div>
							</div>	
						</div>
					</div> -->
					<!-- 第三栏 -->
					<div class="row clear bor-light mb-15">
						<div class="pd-20 full-w">
							<p class="pd-10 f-14 f-w text-center">浏览历史</p>
							<!-- 浏览历史轮播 -->
							<div class="swiper-container full-w overflow-h swiper2">
							    <div class="swiper-wrapper" >
									<c:forEach var="ulog" items="${loglist }">
										<div class="swiper-slide"><a href="<%=path %>/n/i.do?id=${ulog.id }"><img class="img240-135" src="${ulog.img }"></a></div>
									</c:forEach>
									<c:if test="${empty loglist }">
										<div class="text-center f-14 col-12 pt-10 pb-10"><img src="${pageContext.request.contextPath}/img/user/warning.png" class="img-20"><span class="dis-ib ml-10">没有数据，请查看其它内容!</span></div>
									</c:if>
							    </div>
							    <div class="swiper-pagination"></div>
							</div>
						</div>
					</div>
				</div>
				<!-- 内容结束 -->
			</div>
		</div>
	</div>

	<%@ include file="../comm/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/swiper-3.3.1.jquery.min.js"></script>
    <%@ include file="../comm/js.jsp" %> 
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/laytpl.js"></script>
	<script>
		var mySwiper1 = new Swiper('.swiper1', {
		    loop: true,
		    autoplay : 5000,
		    nextButton: '.swi-prev1',
    		prevButton: '.swi-next1',
			autoplayDisableOnInteraction : false,
		});
		var mySwiper2 = new Swiper('.swiper2', {
			loop: true,
			autoplay : 6000,
			autoplayDisableOnInteraction : false,
	        pagination: '.swiper-pagination',
	        slidesPerView: 5,
	        paginationClickable: true,
	        spaceBetween: 30
		});
		$().ready(function(){
			//queryInfo('recommDemo', 'recommList', 'r.title,r.img,r.id', 'tv_res r', 'r.cat_id=200000 ORDER BY r.update_time DESC,ABS(lg - ) ASC', '1', '6');
			/*AND r.lang=1 AND r.lg=0 */
		});
	</script>
	<script type="text/html" id="recommDemo">
		{{# for(var i in d){ }}
			<div class="swiper-slide"><img class="img240-135" src="{{d[i].img}}" title="{{d[i].title}}"></div>
		{{# } }}
	</script>

</body>
</html>