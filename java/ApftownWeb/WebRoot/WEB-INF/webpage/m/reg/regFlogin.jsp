<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../comm/tag.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
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
	
	<%@ include file="../../comm/css.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/swiper-3.3.1.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/m/mobile-apft.css">
  </head>
  
  <body class="bg-l-blue">
  	<div class="wrap clear">
  		<%@ include file="../../m/comm/header.jsp" %>
		<!-- 登录 -->
			<div class="mt-60 pl-15 pr-15 mb-20">
                <div class="bg-white pt-20 pb-20 shadow-rb">
                    <div class="pt-10">
                        <p class="pd-5 text-center f-18">登录</p>
                        <form  class="sky-form pt-20" method="post" action="" id="FloginForm">
                            <div class="ipt-form mb-15">
                                <div class="lab-out-v2 ">
                                    <label class="ipt-label inline-block line-h-20">用户名:</label>
                                </div>
                                <div class="ipt-out-v2 mr-15">
                                    <input type="text"  class="ipt-text radius0" placeholder="用户名/手机号" id="userName"  name="userName" >
                                </div>
                            </div>
                            <div class="ipt-form mb-15">
                                <div class="lab-out-v2">
                                    <lable class="ipt-label inline-block line-h-20">密码:</lable>
                                </div>
                                <div class="ipt-out-v2 mr-15">
                                    <input type="password" class="ipt-text radius0" placeholder="密码" id="userPwd" name="password">
                                </div>
                            </div>
                            <div class="clear mb-10">
                                <div class="mr-15 ml-15 clear">
                                     <button class="btn radius0 btn-primary btn-small full-w" id="login">登录</button>
                                </div>
                            </div>
                            <p class="text-center f-12 mb-10 clear">
                            	<a class="col-primary dis-ib pl-10 pr-10" href="${pageContext.request.contextPath }/forgetFpwd.do">
                            		忘记密码
                            		<i class="icon-double-angle-right pr-5 pl-5 col-primary"></i>
                            	</a>
                            	<a class="col-primary dis-ib pl-10 pr-10"  href="${pageContext.request.contextPath }/regFphone.do">
                            		返回上一级
                            		<i class="icon-double-angle-right pr-5 pl-5 col-primary"></i>
                            	</a>
                            </p>
                        </form>
                    </div>
                </div>   
            </div>
		<!-- 登录END -->
  	</div>
	<%@ include file="../../m/comm/footer.jsp" %>
	<%@ include file="../../comm/js.jsp" %>
	  <script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/m/reg/regFlogin.js"></script> 
  </body>
</html>
