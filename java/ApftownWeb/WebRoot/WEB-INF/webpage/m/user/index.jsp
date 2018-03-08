<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../comm/tag.jsp" %>


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
	<%@ include file="../../comm/css.jsp" %>
	
	<link rel="stylesheet" href="<%=path %>/css/comm/swiper-3.3.1.min.css">
	<link rel="stylesheet" href="<%=path %>/css/m/mobile-user.css">
	<link rel="stylesheet" href="<%=path %>/css/colors/colors.css">
	
	<link rel="stylesheet" href="<%=path %>/ctrl/share/css/share.css">
<!-- ==========link结束========== -->
<!-- ==========script结束========== -->


</head>
<body>
	<div class="container">
		<div class="row clear mb-20 pb-20">
			<!-- 手机端 -->
			<div class="col-xs-12 clear pd-0 ">
				<div class="col-xs-12 pt-20 pb-10 pr-0 pl-0 gra-pri ">
				    <div class="clear col-xs-12 pb-10">
				        <img class="pull-left full-wh use-img full-radius" src="${(empty tbUser.userImg) ? './img/comm/noupload.jpg' : tbUser.userImg }" alt="亚太金融（基金）小镇" >
				        <div class="pull-left pl-15  ">
				            <p class=" f-16 col-white pt-5">${tbUser.getRegName() }</p>
				            <p class="pt-10 col-white">认证等级 :
				               	<i class="xinyong-phone"></i>
				                <i class="xinyong-phone"></i>
				                <i class="xinyong-phone"></i>
				                <i class="xinyongno-phone"></i>
				                <i class="xinyongno-phone"></i>		            
				            </p>
				            <p class="pt-10 col-white">账户安全 : <span class="col-success">较高</span></p>
				        </div>
				        <div class="pull-right pt-20 pb-10 f-14 col-white t-none ">
				        	<a href="<%=path %>/user/userAuthen.do">账户管理&nbsp;></a>
				        </div>
				    </div>
				    <div class="col-xs-12 text-center line-h-20 f-14 t-none pt-10 bor-dashed-1 bor-l-none bor-b-none bor-r-none">
				    	<div class="col-xs-4 bor-ccc bor-l-none bor-t-none bor-b-none">
				    		<a href="<%=path%>/user/userMsg.do" class="col-white">站内信</a>
				    	</div>	
				    	<div class="col-xs-4 bor-ccc bor-l-none bor-t-none bor-b-none">
				    		<a href="<%=path%>/user/atten.do" class="col-white">我的关注</a>
				    	</div>	
                    	<div class="col-xs-4">
                    	<a href="javascript:;" class="col-white">浏览历史</a>
                    	</div>
                	</div>
				</div>
				<c:if test="${tbUser.userName == 'news' }">
					<div class="col-xs-12 bg-white bor-b-l">
						<span class="pull-left pt-15 pb-10 f-16 ">系统管理</span>
						<!-- <span class="pull-right pt-15 pb-10 f-13 col-999" >查看全部<i class="icon-angle-right pd-5 col-999"></i></span> -->
					</div>
					<div class="col-xs-12 clear bg-white f-12 mb-10 bor-b-l">
						<div class="pull-left mt-5 mb-5 wid-20 text-center">
							<a href="<%=path %>/user/resAdd.do">
							    <span class="pull-left full-w text-center pt-5">
									<img class="img-32" src="${pageContext.request.contextPath}/img/user/mobile_newsadd.png" alt="亚太金融（基金）小镇">
								</span>
							    <span class="pull-left full-w pt-5 pb-5">发布新闻</span>
						    </a>
						</div>
						<div class="pull-left mt-5 mb-5 wid-20 text-center">
							<a href="<%=path %>/user/resList.do">
							    <span class="pull-left full-w text-center pt-5">
									<img class="img-32" src="${pageContext.request.contextPath}/img/user/mobile_manage.png" alt="亚太金融（基金）小镇">
								</span>
							    <span class="pull-left full-w pt-5 pb-5">新闻管理</span>
						    </a>
						</div>
						<div class="pull-left mt-5 mb-5 wid-20 text-center">
						    <a href="javascript:;">
							    <span class="pull-left full-w text-center pt-5">
									<img class="img-32" src="${pageContext.request.contextPath}/img/user/mobile_apply.png" alt="亚太金融（基金）小镇">
								</span>
							    <span class="pull-left full-w pt-5 pb-5">报名管理</span>
						    </a>
						</div>
						<div class="pull-left mt-5 mb-5 wid-20 text-center">
						    <a href="<%=path %>/user/intoPark.do">
							    <span class="pull-left full-w text-center pt-5">
									<img class="img-32" src="${pageContext.request.contextPath}/img/user/mobile_policy.png" alt="亚太金融（基金）小镇">
								</span>
							    <span class="pull-left full-w pt-5 pb-5">入园管理</span>
						    </a>
						</div>
					</div>
				</c:if>
				<div class="col-xs-12 bg-white bor-b-l">
					<span class="pull-left pt-15 pb-10 f-16 ">关注中心</span>
					<!-- <span class="pull-right pt-15 pb-10 f-13 col-999" >查看全部<i class="icon-angle-right pd-5 col-999"></i></span> -->
				</div>
				<div class="col-xs-12 clear bg-white f-12 mb-10 bor-b-l">
					<div class="pull-left mt-5 mb-5 wid-20 text-center">
					   	<a href="<%=path %>/user/atten.do">
						    <span class="pull-left full-w text-center pt-5">
								<img class="img-32" src="${pageContext.request.contextPath}/img/user/mobile_attention.png" alt="亚太金融（基金）小镇">
							</span>
						    <span class="pull-left full-w pt-5 pb-5">我的关注</span>
						</a>
					</div>
				</div>
				
				<div class="col-xs-12 bg-white bor-b-l">
					<span class="pull-left pt-15 pb-10 f-16 ">红包礼券</span>
					<!-- <span class="pull-right pt-15 pb-10 f-13 col-999" >查看全部<i class="icon-angle-right pd-5 col-999"></i></span> -->
				</div>
				<div class="col-xs-12 clear bg-white f-12 mb-10 bor-b-l">
					<div class="pull-left mt-5 mb-5 wid-20 text-center">
					    <a href="javascript:;" id="appp">
						    <span class="pull-left full-w text-center pt-5">
								<img class="img-32" src="${pageContext.request.contextPath}/img/user/mobile_gift.png" alt="亚太金融（基金）小镇">
							</span>
						    <span class="pull-left full-w pt-5 pb-5">分享</span>
					   	</a>
					</div>
				</div>
				
					<div class="col-xs-12 bg-white bor-b-l">
					<span class="pull-left pt-15 pb-10 f-16 ">入园服务</span>
					<!-- <span class="pull-right pt-15 pb-10 f-13 col-999" >查看全部<i class="icon-angle-right pd-5 col-999"></i></span> -->
				</div>
				<div class="col-xs-12 clear bg-white f-12 mb-10 bor-b-l">
					<div class="pull-left mt-5 mb-5 wid-20 text-center">
					    <a href="<%=path %>/user/UintoPark.do" id="appp">
						    <span class="pull-left full-w text-center pt-5">
								<img class="img-32" src="${pageContext.request.contextPath}/img/user/mobile_policy.png" alt="亚太金融（基金）小镇">
							</span>
						    <span class="pull-left full-w pt-5 pb-5">入园服务</span>
					   	</a>
					</div>
				</div>
				
				<div class="col-xs-12 bg-white bor-b-l">
					<span class="pull-left pt-15 pb-10 f-16 ">其它</span>
					<!-- <span class="pull-right pt-15 pb-10 f-13 col-999" >查看全部<i class="icon-angle-right pd-5 col-999"></i></span> -->
				</div>
				<div class="col-xs-12 clear bg-white f-12 mb-10 bor-b-l">
					<div class="pull-left mt-5 mb-5 wid-20 text-center">
					   	<a href="javascript:;">
						    <span class="pull-left full-w text-center pt-5">
								<img class="img-32" src="${pageContext.request.contextPath}/img/user/mobile_feedback.png" alt="亚太金融（基金）小镇">
							</span>
						    <span class="pull-left full-w pt-5 pb-5">意见反馈</span>
						</a>
					</div>
				</div>
			</div>
		<!-- 内容结束 -->
		</div>

	</div>

	<%@ include file="../../comm/footer.jsp" %>
	<script type="text/javascript" src="<%=path %>/ctrl/share/js/utils.js"></script>
	<script type="text/javascript" src="<%=path %>/ctrl/share/js/share.js" id="shareFile"></script>
	
</body>
</html>