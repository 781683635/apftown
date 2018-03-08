<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>


<% menuType = "1.2"; %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户认证-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/ctrl/laydate/need/laydate.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/user/user.css">
   	
      
  </head>
  
  <body>
   <div class="wrap">
      		<%@ include file="../comm/header.jsp" %>
	<div class="container">
	<% if(!s_oem.isMobile()){ %>
		<div class="clear">
			<img class="pull-left" src="<%=path %>/img/user/user03.png" alt="亚太金融（基金）小镇"> 
			<span class="pull-left f-18 pt-20 pl-10">用户中心</span>
			<span class="pull-right pt-20">
				<a class="hov-primary" href="<%=path %>/index.do">首页</a>
				<i class=" icon-angle-right pl-5 pr-5"></i>基本资料
			</span>
		</div>
	 <%} %>
	
        <!-- 主界面 -->
        <div class="row clear mb-15 pb-20 clear">
            <%@ include file="./menu.jsp" %>
            <div class="col-sm-10 mb-10 pd-20">
                <!-- 用户名 -->
                <div class="row clear bor-dashed-1 bor-l-none bor-r-none bor-t-none pt-15">
                    <div class="col-sm-3 col-xs-6 line-h-20 pd-5">
                        <div class="clear"><i class="i-user${fn:substring(ssUser.userStatus,4, 5) == '1'?'-act':'' } pull-left f-20 img-25"></i> <span class="f-14 ml-10 pull-left pd-5">用户名</span></div>
                    </div>
                    <div class="col-sm-3 col-xs-6 line-h-20 bor-dashed-1 bor-t-none bor-b-none pd-5">
                   	 	<c:if test="${fn:substring(ssUser.userStatus,4, 5) != '1'}">
                        	<i class="icon-remove inline-block f-20"></i> <span class="f-14 ml-15 inline-block pd-5">未认证</span>
                       	</c:if>
                   	 	<c:if test="${fn:substring(ssUser.userStatus,4, 5) == '1'}">
                        	<i class="icon-ok inline-block f-20"></i> <span class="f-14 ml-10 inline-block pd-5">已认证</span>
                       	</c:if>
                    </div>
                    <div class="col-sm-3 col-xs-6 pd-5 clear">
                        <p class=" f-12 newline text-line-2  line-h-25">
                            <i class="icon-volume-up i-volume-border inline-block f-14 "></i> 用于登录小镇
                        </p>
                    </div>
                    <c:if test="${fn:substring(ssUser.userStatus,4, 5) != '1'}">
	                    <div class="col-sm-3 col-xs-6 line-h-15 bor-dashed-1 bor-t-none bor-b-none bor-r-none pd-5">
	                    	<button class="cur-p btn btn-tiny btn-primary inline-block mg-5" onclick="show('username')">填写</button>
	                    </div>
                    </c:if>
                </div>
                <!-- 登录密码 -->
                <div class="row clear bor-dashed-1 bor-l-none bor-r-none bor-t-none pt-5">
                    <div class="col-sm-3 col-xs-6 line-h-20 pd-5">
                        <div class="clear"><i class="i-pwd-act pull-left f-20 img-25"></i> <span class="f-14 ml-10 pull-left pd-5">登录密码</span></div>
                    </div>
                    <div class="col-sm-3 col-xs-6 line-h-20 bor-dashed-1 bor-t-none bor-b-none pd-5">
                        <i class="icon-ok inline-block f-20"></i> <span class="f-14 ml-15 inline-block pd-5">已认证</span>
                    </div>
                    <div class="col-sm-3 col-xs-6 pd-5 clear">
	                    <p class=" f-12 newline text-line-2 line-h-25">
	                        <i class="icon-volume-up i-volume-border inline-block f-14 "></i> 用于登录小镇
	                    </p>
                    </div>
                    <div class="col-sm-3 col-xs-6 line-h-15 bor-dashed-1 bor-t-none bor-b-none bor-r-none pd-5">
                    	<button class="cur-p btn btn-tiny btn-primary inline-block mg-5" onclick="show('loginpassword')">修改</button>
                    </div>
                </div>
                
                <!-- 头像 -->
                <div class="row clear bor-dashed-1 bor-l-none bor-r-none bor-t-none pt-5">
                    <div class="col-sm-3 col-xs-6 line-h-20 pd-5">
                        <div class="clear"><i class="i-github${fn:substring(ssUser.userStatus, 5, 6) == '1'?'-act':'' } pull-left f-20 img-25"></i> <span class="f-14 ml-10 pull-left pd-5">头像</span></div>
                    </div>
                    <div class="col-sm-3 col-xs-6 line-h-20 bor-dashed-1 bor-t-none bor-b-none pd-5">
                        <c:if test="${fn:substring(ssUser.userStatus,5, 6) != '1'}">
		                    <i class="icon-remove inline-block  f-20"></i> <span class="f-14 ml-10 inline-block pd-5">未认证</span>
	                    </c:if>
	                    <c:if test="${fn:substring(ssUser.userStatus,5, 6) == '1'}">
		                   <i class="icon-ok inline-block  f-20"></i> <span class="f-14 ml-10 inline-block pd-5">已认证</span>
                    	</c:if>
                    </div>
                    <div class="col-sm-3 col-xs-6 pd-5 clear">
                        <p class=" f-12 newline text-line-2 line-h-25">
                                <i class="icon-volume-up i-volume-border inline-block f-14 "></i>    用于头像认证
                        </p>
                    </div>
                    <div class="col-sm-3 col-xs-6 line-h-15 bor-dashed-1 bor-t-none bor-b-none bor-r-none pd-5">
                    	<button class="cur-p btn btn-tiny btn-primary inline-block mg-5" onclick="show('show_cutImg')">${fn:substring(ssUser.userStatus, 5, 6) == '1'?'修改':'设置' }</button>
                    </div>
                </div>
                
                
                <!-- 绑定手机 -->
                <div class="row clear bor-dashed-1 bor-l-none bor-r-none bor-t-none pt-5">
                    <div class="col-sm-3 col-xs-6 line-h-20 pd-5">
                        <div class="clear"><i class="i-phone${fn:substring(ssUser.userStatus, 0, 1) == '1'?'-act':'' } pull-left f-20 img-25"></i> <span class="f-14 ml-10 pull-left pd-5">绑定手机</span></div>
                    </div>
                    <div class="col-sm-3 col-xs-6 line-h-20 bor-dashed-1 bor-t-none bor-b-none pd-5">
                    	<c:if test="${fn:substring(ssUser.userStatus,0, 1) != '1'}">
                       		<i class="icon-remove inline-block  f-20"></i> <span class="f-14 ml-10 inline-block pd-5">未认证</span>
                       	</c:if>
                       	<c:if test="${fn:substring(ssUser.userStatus,0, 1) == '1'}">
                       		<i class="icon-ok inline-block  f-20"></i> <span class="f-14 ml-10 inline-block pd-5">已认证</span>
                       	</c:if>
                    </div>
                    <div class="col-sm-3 col-xs-6 pd-5 clear">
                        <p class=" f-12 newline text-line-2 line-h-25">
                         	<i class="icon-volume-up i-volume-border inline-block f-14 "></i>   用于密码找回
                        </p>
                    </div>
                    <div class="col-sm-3 col-xs-6 line-h-15 bor-dashed-1 bor-t-none bor-b-none bor-r-none pd-5">
                    	<c:if test="${fn:substring(ssUser.userStatus,0, 1) != '1'}">
                    		<button class="cur-p btn btn-tiny btn-primary inline-block mg-5" onclick="show('bindphone');">绑定</button>
                    	</c:if>
                    	<c:if test="${fn:substring(ssUser.userStatus,0, 1) == '1'}">
                    		<button class="cur-p btn btn-tiny btn-primary inline-block mg-5" onclick="show('updatephone')">修改</button>
                    	</c:if>
                    </div>
                </div>
                
                
                <!-- 电子邮件 -->
                 <div class="row clear bor-dashed-1 bor-l-none bor-r-none bor-t-none pt-5">
                    <div class="col-sm-3 col-xs-6 line-h-20 pd-5">
                        <div class="clear"><i class="i-globe${fn:substring(ssUser.userStatus, 6, 7) == '1'?'-act':'' } pull-left f-20 img-25"></i> <span class="f-14 ml-10 pull-left pd-5">电子邮件</span></div>
                    </div>
                    <div class="col-sm-3 col-xs-6 line-h-20 bor-dashed-1 bor-t-none bor-b-none pd-5">
                    	<c:if test="${fn:substring(ssUser.userStatus,6, 7) != '1'}">
                       		<i class="icon-remove inline-block  f-20"></i> <span class="f-14 ml-10 inline-block pd-5">未认证</span>
                       	</c:if>
                       	<c:if test="${fn:substring(ssUser.userStatus,6, 7) == '1'}">
                       		<i class="icon-ok inline-block  f-20"></i> <span class="f-14 ml-10 inline-block pd-5">已认证</span>
                       	</c:if>
                    </div>
                    <div class="col-sm-3 col-xs-6 pd-5 clear">
                        <p class=" f-12 newline text-line-2 line-h-25">
                        	<i class="icon-volume-up i-volume-border inline-block f-14 "></i>  用于找回密码
                        </p>
                    </div>
                    <div class="col-sm-3 col-xs-6 line-h-15 bor-dashed-1 bor-t-none bor-b-none bor-r-none pd-5">
                    	<c:if test="${fn:substring(ssUser.userStatus,6, 7) != '1'}">
                    	</c:if>
                    		<button class="cur-p btn btn-tiny btn-primary inline-block mg-5 email">绑定</button>
                    </div>
                </div>
                
                
            </div>
        </div>
    <!-- 弹出层 -->
        <!-- 填写用户名 -->
        <div class="show" id="username">
            <div class="modal-dialog ">
                <div class="modal-content ">
                    <div class="modal-header ">
                        <button type="button " class="close-mod ">×</button>
                        <p class="icon-user">填写用户名</p>
                    </div>
                    <form class="sky-form modal-main " id="setUserNameForm">
                        <p class="mb-10 line-h-20">
                            <span class="modal-msg icon-info-sign ">&nbsp;温馨提示:</span> 
                                请填写您的用户名(用户一旦确定,不可以改):
                        </p>
                        <div class="row clear mb-15 ">
                            <div class="col-xs-4 col-sm-2 pull-left text-right f-14 col-999 pt-10 pb-10 pl-0 pr-0 " >
                                用户名：
                            </div>
                            <div class="col-xs-8 col-sm-10 pull-left ">
                                <input type="text " class="ipt-text " id="userName" name="userName">
                            </div>
                        </div>
                        <div class="bor-b-l ">
                        </div>
                        <div class="pd-20 ml-10 mr-10 text-right ">
                            <button class="btn btn-primary f-14 btn-small ">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- 修改密码 -->
        <div class="show" id="loginpassword">
            <div class="modal-dialog ">
                <div class="modal-content ">
                    <div class="modal-header ">
                        <button type="button " class="close-mod ">×</button>
                        <p class="icon-key">修改登录密码</p>
                    </div>
                    <form class="sky-form modal-main "  method="post" id="userAuthenForm">
                        <p class="mb-10 line-h-20">
                            <span class="modal-msg icon-info-sign ">&nbsp;温馨提示:</span> 为了您的账户安全，请定期更换登录密码，并确保登录密码设置与资金密码不同。
                        </p>
                        <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <label class="ipt-label inline-block line-h-20">原密码：</label>
                            </div>
                            <div class="ipt-out mr-15">
                                <input type="password" id="oldPwd"  name="oldPwd"  class="ipt-text">
                            </div>
                        </div>
                        <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <label class="ipt-label inline-block line-h-20">新密码：</label>
                            </div>
                            <div class="ipt-out mr-15">
                                <input type="password" id="resetPw"  name="resetPw"  class="ipt-text">
                            </div>
                        </div>
                        <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <label class="ipt-label inline-block line-h-20">确认密码：</label>
                            </div>
                            <div class="ipt-out mr-15">
                                <input type="password" id="resetsPw"  name="resetsPw"  class="ipt-text">
                            </div>
                        </div>
                        <div class="bor-b-l ">
                        </div>
                        <div class="pd-20 ml-10 mr-10 text-right ">
                            <button class="btn btn-primary f-14 btn-small ">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- 身份认证 -->
        <div class="show" id="authent">
            <div class="modal-dialog ">
                <div class="modal-content clear" >
                    <div class="modal-header ">
                        <button type="button " class="close-mod ">×</button>
                        <p class="icon-ok-sign">尊敬的客户，您好</p>
                    </div>
                    <p class="pd-10 mr-10 ml-10 line-h-20 f-14 ">
                        为了保证您的资金安全，现需为您进行身份及银行卡认证，通过与银行合作，充值至少1分钱即可完成安全认证。根据反洗钱相关条例，维护金融市场安全有序运行，用户只能通过绑定的银行卡进行资金操作。
                    </p>
                    <div class="row pd-10 clear ">
                        <div class="col-5 pull-left ">
                            <button class="btn btn-primary btn-tiny pull-right ">确认</button>
                        </div>
                        <div class="col-5 pull-right ">
                            <button class="btn btn-primary btn-tiny pull-left ">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 上传头像 -->
        <div class="show" id="show_cutImg">
            <div class="modal-dialog">  
                <div class="modal-content clear" id="myModal">
                    <div class="modal-body clear">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding:0px;">
                            <div class="img-container">
                                <img src="" alt="点击下面选择文件按钮进行选择文件！">
                                <div class="img-type" style="display:none">userImg</div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer2 clear">
                        <div class=" col-xs-12">
                            <div class="row clear mt-10 mb-5">
                                <div class="col-sm-7 clear">
                                    <button class="btn btn-operate btn-margin-t3 bbttnn operate" data-method="zoom" data-option="0.1" type="button" title="Zoom In">
                                        <span class="docs-tooltip inline-block" data-toggle="tooltip">
                                            <span class="f-18 line-h-20 icon-zoom-in"></span>
                                        </span>
                                    </button>
                                    <button class="btn btn-operate btn-margin-t3 bbttnn operate" data-method="zoom" data-option="-0.1" type="button" title="Zoom Out">
                                        <span class="docs-tooltip inline-block" data-toggle="tooltip">
                                            <span class="f-18 line-h-20 icon-zoom-out"></span>
                                        </span>
                                    </button>
                                    <button class="btn btn-operate btn-margin-t3 bbttnn operate" data-method="rotate" data-option="-90" type="button" title="Rotate Left">
                                        <span class="docs-tooltip inline-block" data-toggle="tooltip">
                                            <span class="f-18 line-h-20 icon-rotate-left"></span>
                                         </span>
                                    </button>
                                    <button class="btn btn-operate btn-margin-t3 bbttnn operate" data-method="rotate" data-option="90" type="button" title="Rotate Right">
                                        <span class="docs-tooltip inline-block" data-toggle="tooltip">
                                            <span class="f-18 line-h-20 icon-rotate-right"></span>
                                        </span>
                                    </button>
                                    <button class="btn btn-operate btn-margin-t3 bbttnn operate" data-method="reset" type="button" title="Reset">
                                        <span class="docs-tooltip inline-block" data-toggle="tooltip">
                                            <span class="icon icon-refresh "></span>
                                        </span>
                                    </button>
                                </div>
                                <div class="col-sm-5 upload-fr clear">
                                <label style="overflow:hidden;" class="btn btn-upload btn-margin-r3 bbttnn pull-left" for="inputImage" title="Upload image file">
                                    <input class="sr-only" id="inputImage" type="file" name="file">
                                    <span class="btn-operate docs-tooltip chose" data-toggle="tooltip">
                                        选择文件
                                    </span>
                                </label>  
                                <label class="btn btn-operate btn-upload btn-margin-r3 bbttnn pull-left" data-method="getCroppedCanvas" type="button">
                                    <span class="span-upload docs-tooltip inline-block" data-toggle="tooltip">
                                        确认上传
                                    </span>
                                </label>
                                <label  class=" btn btn-operate btn-margin-r3 bbttnn inline-block pull-left" type="button">
                                    <span class="span-upload docs-tooltip inline-block" data-dismiss="modal" id="cancle">
                                        取消
                                    </span>
                                </label>
                                </div>
                            </div>
                        </div>
                        
                        <div class="modal fade docs-cropped" id="getCroppedCanvasModal" aria-hidden="true" aria-labelledby="getCroppedCanvasTitle" role="dialog" tabindex="-1">
                        </div>
                    </div>
                </div>  
            </div>
        </div>
        <!-- 绑定手机 -->
        <div class="show" id="bindphone">
            <div class="modal-dialog ">
                <div class="modal-content ">
                    <div class="modal-header ">
                        <button type="button " class="close-mod ">×</button>
                        <p class="icon-phone">绑定手机</p>
                    </div>
                    <form class="sky-form modal-main " id="setUMobileForm">
                        <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <label class="ipt-label inline-block line-h-20">手机号:</label>
                            </div>
                            <div class="ipt-out mr-15">
                                <input type="text" id="userRegMobile"  name="userRegMobile"  class="ipt-text" placeholder="请输入您的手机号码">
                            </div>
                        </div>                        
                        <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <label class="ipt-label inline-block line-h-20">图形验证码:</label>
                            </div>
                            <div class="ipt-out mr-15">
                                <input type="text" id="imgCode" maxlength="4"  name="imgCode"  class="ipt-text" placeholder="请输入图形验证码">
                                <img src="<%=path %>/randcode" class=" idcode " id="vCode" onclick="updateCode('vCode')" id="randCode" name="randCode">
                            </div>
                        </div> 
                        <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <label class="ipt-label inline-block line-h-20">手机验证码:</label>
                            </div>
                            <div class="ipt-out mr-15">
                                <input type="text" id="smsCode" maxlength="6"  name="smsCode"  class="ipt-text" placeholder="请输入手机验证码">
                                <button id="getSmsCode" type="button" onclick="sendMsgPre()" class="btn btn-gray f-14  idcode">获取验证码</button>
                            </div>
                        </div> 
                        <div class="bor-b-l ">
                        </div>
                        <div class="pd-20 ml-10 mr-10 text-right ">
                            <button class="btn btn-primary f-14 btn-small " id="setUMobile">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- 修改手机 -->
        <div class="show" id="updatephone">
            <div class="modal-dialog ">
                <div class="modal-content ">
                    <div class="modal-header ">
                        <button type="button " class="close-mod ">×</button>
                        <p class="icon-phone">修改手机</p>
                    </div>
                    <form class="sky-form modal-main " id="UpdateMobileForm">
                        <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <label class="ipt-label inline-block line-h-20">手机号:</label>
                            </div>
                            <div class="ipt-out mr-15">
                                <input type="text" id="userRegMobile2"  name="userRegMobile"  class="ipt-text" placeholder="请输入您要修改的手机号码">
                            </div>
                        </div>                        
                        <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <label class="ipt-label inline-block line-h-20">图形验证码:</label>
                            </div>
                            <div class="ipt-out mr-15">
                                <input type="text" id="imgCode2" maxlength="4"  name="imgCode"  class="ipt-text" placeholder="请输入图形验证码">
                                <img src="<%=path %>/randcode" class=" idcode " id="vCode" onclick="updateCode('vCode')" id="randCode" name="randCode">
                            </div>
                        </div> 
                        <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <label class="ipt-label inline-block line-h-20">手机验证码:</label>
                            </div>
                            <div class="ipt-out mr-15">
                                <input type="text" id="smsCode" maxlength="6"  name="smsCode"  class="ipt-text" placeholder="请输入您要发送的手机验证码">
                                <button id="getSmsCode" type="button" onclick="sendMsgPre2()" class="btn btn-gray f-14  idcode">获取验证码</button>
                            </div>
                        </div> 
                        <div class="bor-b-l ">
                        </div>
                        <div class="pd-20 ml-10 mr-10 text-right ">
                            <button class="btn btn-primary f-14 btn-small " id="upMoblie">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- 绑定邮箱 -->
        <div class="show" id="email">
            <div class="modal-dialog clear">
                <div class="modal-content ">
                    <div class="modal-header ">
                        <button type="button " class="close-mod ">×</button>
                        <p class="icon-envelope">绑定邮箱</p>
                    </div>
                    
                    <div class="modal-email-content">
                        <div class="pd-20 ">
                        <img src="${pageContext.request.contextPath }/img/user/email1.jpg" class="full-w">
                        </div>
                        <div class="pd-20 ">
                            <p class="mb-10 line-h-20 f-14">
                                <span class="modal-msg icon-info-sign ">&nbsp;温馨提示:</span> 
                               邮件是系统登录时可使用的用户名或找回密码，为了您的账户安全，请先填写您的登录密码后绑定/修改邮件.
                            </p>
                        </div>
                        <div class="clear pd-20">
                            <div class="col-xs-5 col-sm-3 pull-left text-right f-14 col-999 pd-10 ">
                                请输入密码：
                            </div>
                            <div class="col-xs-7 col-sm-9 pull-left pd-0">
                                 <input type="password" class="ipt-text " id="passUpwd" name="passUpwd">
                            </div>
                        </div>
                        <div class="pd-20  text-right ">
                            <button type="button" class="btn btn-primary f-14 btn-small emailnext-v1 " onclick="setUPwd();">下一步</button>
                        </div>
                    </div>
                    <div class="modal-email-content dis-n">
                        
                        <form class="sky-form modal-main " method="post" id="setEmailForm">
	                        <div class="pd-20">
	                            <img src="${pageContext.request.contextPath}/img/user/email2.jpg" class="full-w">
	                        </div>
	                        <div class="clear pd-20  ">
	                            <div class="col-xs-4 col-sm-3 pull-left text-right f-14 col-999 pd-10 ">  新邮箱：</div>
	                            <div class="col-xs-8 col-sm-9 pull-left pd-0">
	                                 <input type="text" class="ipt-text " id="userRegEmail" name="userRegEmail">
	                            </div>
	                        </div>
	                        <div class="pd-20 text-right ">
	                            <button class="btn btn-primary f-14 btn-small emailnext-v2" >下一步</button>
	                        </div>
                        </form>
                    </div>
                    <div class="modal-email-content dis-n">
                        <div class="pd-20 ">
                            <img src="${pageContext.request.contextPath }/img/user/email3.jpg" class="full-w">
                        </div>
                        <div class="pd-20 ">
                            <p class="mb-10 line-h-25 f-20">
                               邮件验证码发送成功，请在48小时内点击激活
                            </p>
                        </div>
                        <div class="pd-20 text-right ">
                            <button class="btn btn-primary f-14 btn-small emailcancel " >确定</button>
                        </div>
                    </div>
                     
                </div>
            </div>
        </div>
        <!-- 设置资金密码 -->
        <div class="show" id="bankroll">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close-mod">×</button>
                        <p class="icon-credit-card">修改资金密码</p>
                    </div>
                    <form class="sky-form modal-main" id="setMoneyForm">
                        <p class="mb-10 ">
                            <span class="modal-msg icon-info-sign ">&nbsp;温馨提示:</span> 
                            资金密码是系统操作资金时使用的密码，为了您的账户安全，请先修改资金密码后使用当您初次设置资金密码时，“原资金密码”则无需输入
                        </p>
                        <div class="row clear mb-15 ">
                            <div class="col-xs-5 col-sm-3 pull-left text-right f-14 col-999 pd-10">
                                原资金密码：
                            </div>
                            <div class="col-xs-7 col-sm-9 pull-left">
                                <input type="password" class="ipt-text " name="oldmoPwd">
                            </div>
                        </div>
                        <div class="row clear mb-15 ">
                            <div class="col-xs-5 col-sm-3 pull-left text-right f-14 col-999 pd-10">
                                新密码：
                            </div>
                            <div class="col-xs-7 col-sm-9 pull-left ">
                                <input type="password" class="ipt-text " name="newmoPwd">
                            </div>
                        </div>
                        <div class="row clear mb-15 ">
                            <div class="col-xs-5 col-sm-3 pull-left text-right f-14 col-999 pd-10">
                                确认密码：
                            </div>
                            <div class="col-xs-7 col-sm-9 pull-left ">
                                <input type="password" class="ipt-text " name="newsmoPwd">
                            </div>
                        </div>
                        <div class="bor-b-l ">
                        </div>
                        <div class="pd-20 ml-10 mr-10 text-right ">
                            <button class="btn btn-primary f-14 btn-small " id="setMoney">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- 找回资金密码 -->
        <div class="show" id="findbankpwd">
            <div class="modal-dialog ">
                <div class="modal-content ">
                    <div class="modal-header ">
                        <button type="button " class="close-mod ">×</button>
                        <p class="icon-credit-card">找回资金密码</p>
                    </div>
                    <form class="sky-form modal-main ">
                        <div class="row clear mb-15 ">
                            <div class="col-xs-4 col-sm-3 pull-left text-right f-14 col-999 pd-10 lab-out" >
                                <p>手机号:</p>
                            </div>
                            <div class="col-xs-7 col-sm-8 pull-left f-14 col-999 pl-10 pr-0 ">
                                <input type="text " class="ipt-text " placeholder="请输入您的手机号码">
                            </div>
                        </div>
                        <div class="row clear mb-15 ">
                            <div class="col-xs-4 col-sm-3 pull-left text-right f-14 col-999 pd-10 lab-out">
                                <p>图形验证码:</p>
                            </div>
                            <div class="col-xs-7 col-sm-8 pull-left pos-r pl-10 pr-0">
                                <input type="text " class="ipt-text " maxlength="4" placeholder="请输入图形验证码" >
                                <img src="../../img/news/11.jpg" class=" idcode ">
                            </div>
                        </div>
                        <div class="row clear mb-15 ">
                            <div class=" col-xs-4 col-sm-3 pull-left text-right f-14 col-999 pd-10 ">
                                 <p class=" ">手机验证码:</p>
                            </div>
                            <div class="col-xs-7 col-sm-8 pull-left pos-r pl-10 pr-0">
                                <input type="text " class="ipt-text " maxlength="6" placeholder="请输入旧手机验证码">
                                <button class="btn btn-gray f-14  idcode">获取验证码</button>
                            </div>
                        </div>
                        <div class="bor-b-l ">
                        </div>
                        <div class="pd-20 ml-10 mr-10 text-right ">
                            <button class="btn btn-primary f-14 btn-small ">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </div>
    </div>

    <%@ include file="../comm/footer.jsp" %> 
    <%@ include file="../comm/js.jsp" %>
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/reg/sendMsg.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/ckImgCode.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
    <!-- 弹框文件 -->
   
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/user/userAuthen.js"></script>
    <script>
            /*邮箱的选项卡切换*/
            $(document).ready(function(){
              $(".email").click(function(){
                $('#email').fadeToggle(200);
                $(".modal-email-content").hide();
                $(".modal-email-content").eq(0).show();
              });
              $(".emailcancel").click(function(){
                $(".show").hide()
              });
            }); 
        </script> 
	<%@ include file="../comm/cutImg.jsp" %>
  </body>
  
</html>
