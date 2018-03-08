<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../comm/tag.jsp" %>

<% menuType = "findpwd"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
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
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
	
  </head>

<body>
<div class="wrap bg-primary">
	<%@ include file="../comm/header.jsp" %>
<div class="bg-primary">
    <div class="container pd-0">
        <div class="clear mt-20 pt-20">
            <div class="col-md-8 col-sm-6 hidden-xs">
                <img src="<%=path %>/img/comm/image.png" alt="亚太金融（基金）小镇" class="">
            </div>
            <div class="col-md-4 col-sm-6 mt-20 mb-20">
                <div class="bg-white pt-20 pb-20 ml-10 mr-10 shadow-rb">
                    <div class="pt-10" id="redio-option">
                        <p class="pd-10 text-center f-18">找回密码</p>
                        <!-- 选择 -->
                        <div class="row pd-10 tabbar mb-20">
                          <div class="col-xs-6 text-center">
                              <label class="radio state-success"><input type="radio" checked="checked" name="radio">手机找回</label>
                          </div>
                          <div class="col-xs-6 text-center">
                              <label class="radio state-success"><input type="radio" name="radio">邮箱找回</label>
                          </div>
                        </div>
                        <form method="post" action="${pageContext.request.contextPath }/setPwd.do" id="mobileform" class="sky-form">
                            <!-- 用手机号找回 -->
                            <div class="ipt-form mb-15 ">
                                <div class="lab-out">
                                    <label class="ipt-label inline-block line-h-20">手机号：</label>
                                </div>
                                <div class="ipt-out mr-15">
                                    <input type="text" id="userMobile"  name="userMobile" class="ipt-text" placeholder="请输入您注册的手机号">
                                </div>
                            </div>
                            <div class="ipt-form mb-15">
                                <div class="lab-out">
                                    <label class="ipt-label inline-block line-h-20">图形验证码：</label>
                                </div>
                                <div class="ipt-out mr-15">
                                    <input type="text" id="imgCode"  name="imgCode" maxlength="4" class="ipt-text " placeholder="请输入图形验证码">
                                    <img id="randCode" name="randCode" src="${pageContext.request.contextPath}/randcode" onclick="updateCode('randCode')"  class="idcode ">
                                </div>
                            </div>
                            <div class="ipt-form mb-10">
                                <div class="lab-out">
                                    <label class="ipt-label inline-block line-h-20">短信验证码：</label>
                                </div>
                                <div class="ipt-out mr-15">
                                    <input type="text" id="smsCode"  name="smsCode" maxlength="6" class="ipt-text" placeholder="请输入短信验证码">
                                    <button type="button"  id="sendCode" onclick="sendMsgPre();" class="idcode btn  gradient-gray">短信验证</button>
                                </div>
                            </div>
                            <div class="mb-15 clear">
                                <div class="mr-15 clear col-sm-11 col-offset-1">
                                    <button id="BackPass" type="submit" class="btn btn-primary btn-small full-w">提交</button>
                                </div>
                            </div>
                        </form>
                            
                        <!-- 用邮箱找回 -->
                        <form id="emailForm" class="sky-form" hidden>
                            <div class="ipt-form mb-15">
                                <div class="lab-out">
                                    <label class="ipt-label inline-block line-h-20">邮箱：</label>
                                </div>
                                <div class="ipt-out mr-15">
                                    <input type="text" class="ipt-text" placeholder="请输入您的邮箱" id="userEmail" name="userEmail">
                                </div>
                            </div>
                            <div class="ipt-form mb-15">
                                <div class="lab-out">
                                    <label class="ipt-label inline-block line-h-20">验证码：</label>
                                </div>
                                <div class="ipt-out mr-15">
                                    <input type="text" name="imgCode" maxlength="4" class="ipt-text " placeholder="请输入图形验证码">
                                    <img  id="rCode" name="rCode" src="${pageContext.request.contextPath}/randcode" onclick="updateCode('rCode')"  class="idcode ">
                                </div>
                            </div>
                            <div class="mb-15 clear">
                                <div class="mr-15 clear col-sm-11 col-offset-1">
                                    <button id="BackPass" type="submit" class="btn btn-primary btn-small full-w">发送邮件</button>
                                </div>
                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>	
    </div>           
</div>
</div>
	<%@ include file="../comm/footer.jsp"%>
	<%@ include file="../comm/js.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/reg/forgetPwd.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/reg/sendMsg.js"></script>
    
   	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/ckImgCode.js"></script>
   	<script>
        $(document).ready(function(){ 
            /*单选框jq数据传入*/
            $.Tab("#redio-option .tabbar label","#redio-option form","checked","click","0");
        });
    </script>
</body>
</html>
