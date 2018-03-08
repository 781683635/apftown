<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>

<% menuType = "login"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>">
    
    <title>登录界面-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	<!-- 清空浏览器本地缓存 -->
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    
  </head>
  
  <body>

    <div class="wrap bg-primary">
		<%@ include file="../comm/header.jsp" %>
        <div class="container pd-0"> 
            <div class="clear mt-20 pt-20">
                <div class="col-md-8 col-sm-7 hidden-xs">
                     <img src="<%=path %>/img/comm/image.png" alt="亚太金融（基金）小镇" class="">
                </div>
                <div class="col-md-4 col-sm-5 mt-20 mb-20">
                    <div class="bg-white pt-20 pb-20 mr-10 ml-10 shadow-rb">
                        <div class="pt-10">
                            <p class="pd-5 text-center f-18">登录</p>
                            <input type="hidden" value="${ sessionScope.targetUrl}" id="targetUrl">
                            <form id="loginform" class="sky-form pt-20" method="post" name="loginform">
                                <div class="ipt-form mb-15">
                                    <div class="lab-out-v2 ">
                                        <label class="ipt-label inline-block line-h-20">用户名:</label>
                                    </div>
                                    <div class="ipt-out-v2 mr-15">
                                        <input type="text" id="userName"  name="userName"  class="ipt-text radius0" placeholder="用户名/手机号">
                                    </div>
                                </div>
                                <div class="ipt-form mb-15">
                                    <div class="lab-out-v2">
                                        <lable class="ipt-label inline-block line-h-20">密码:</lable>
                                    </div>
                                    <div class="ipt-out-v2 mr-15">
                                        <input type="password" id="userPwd" name="password"  class="ipt-text radius0" placeholder="密码">
                                    </div>
                                </div>
                                <div class=" clear mb-10">
                                    <div class="mr-15 clear col-sm-10 col-offset-1">
                                        <label class="pull-left">
                                        <input id="rememberMe" type="checkbox" name="rememberMe" onkeydown="check_enter(event)"><span class="inline-block pl-10 adr-text">记住用户名</span></label>
                                         <a class="pull-right" href="${pageContext.request.contextPath }/forgetPwd.do">忘记密码？</a>
                                    </div>
                                </div>
                                <div class="clear mb-10">
                                    <div class="mr-15 clear col-sm-11 col-offset-1">
                                         <button id="login" class="btn radius0 btn-primary btn-small full-w">登录</button>
                                    </div>
                                </div>
                                <p class="text-right f-12 mr-20 mb-10 clear">没有账户，<a class="col-red" href="${pageContext.request.contextPath }/regui.do">立即注册</a>&nbsp;一个新账户</p>
                            </form>
                        </div>
                    </div>   
                </div>
            </div>
        </div>
    </div>  
    <%@ include file="../comm/footer.jsp" %>
    <%@ include file="../comm/js.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/reg/login.js" ></script>
  </body>
</html>
