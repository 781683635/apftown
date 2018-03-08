<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../comm/tag.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册失败页面-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    
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
    <!-- uc浏览器强制全屏   -->
    <meta name="full-screen" content="yes">

    <%@ include file="../../comm/css.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/swiper-3.3.1.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/m/mobile-apft.css">
</head>
  
  <body>
    <div class="wrap clear">
        <!-- 顶部 -->
        <%@ include file="../../m/comm/header.jsp" %>
        <!-- 顶部END -->
        <div class="clear full-w mt-60">
            <img class="full-w" src="${pageContext.request.contextPath }/img/mobile/reg_f/404error.jpg" alt="">
        </div>
        <div class="clear">
            <div class="col-8 pull-left">
                <p class="f-40 col-8C8575 text-center">E R R O R</p>
                <p class="f-14 col-8C8575 text-center">出错了，您输入的网址无效！</p>
            </div>
            <div class="col-4 pull-left pd-5 mt-10">
                <a class="bor-ccc bor-col-orange f-22 col-orange pd-5 t-none" href="${pageContext.request.contextPath }/regFphone.do">返回首页</a>
            </div>
        </div>
    </div>
     	
        <%@ include file="../../m/comm/footer.jsp" %>
        <%@ include file="../../comm/js.jsp" %>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/m/reg/regfund.js"></script>
        <script src="${pageContext.request.contextPath }/js/comm/swiper-3.3.1.jquery.min.js"></script>
  </body>
</html>
