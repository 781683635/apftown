<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../comm/tag.jsp" %>


<% menuType = "setpwd"; %>

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
	<div class="">   
        <div class="container">
            <div class="row clear">
            <div class="col-md-8 col-sm-7 hidden-xs pb-20 mb-20">
                 <img src="<%=path %>/img/comm/image.png" alt="亚太金融（基金）小镇">
            </div>
            <div class="col-md-4 col-sm-5 pd-0 mt-20 mb-20">
                <div class="bg-white pt-20 pb-20 pr-20 mt-20 shadow-rb">
                <div class="pt-20">
                    <p class="pd-5 text-center f-18">密码重置</p>
                    <form id="setPwdForm" class="sky-form pt-20" method="post">
                    	<input type="hidden" name="userId" value="${emailchk.userId }"/> 
                    	<input type="hidden" name="userName" value="${emailchk.userName }"/> 
                    	<input type="hidden" name="userRegEmail" value="${emailchk.userEmail }"/> 
                       	<div>
    			        	<input type="hidden" id="tbUserRegister_id" name="tbUserRegister_id" value="${tbUserRegister.id }">
    		          	</div>
        	            <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <label class="ipt-label inline-block line-h-20">新密码:</label>
                            </div>
                            <div class="ipt-out  mr-15">
                                <input type="password" id="newpassword" name="newpassword" class="ipt-text radius0" placeholder="新密码">
                            </div>
                        </div>
                        <div class="ipt-form mb-15">
                            <div class="lab-out">
                                <lable class="ipt-label inline-block line-h-20">确认密码:</lable>
                            </div>
                            <div class="ipt-out mr-15">
                                <input type="password" id="newpassword2" name="newpassword2" class="ipt-text radius0" placeholder="确认密码">
                            </div>
                        </div>
                        <div class="ipt-form mb-20 pb-10">
                            <div class="lab-out">
                                <label class="ipt-label inline-block">&nbsp;</label>
                            </div>
                            <div class="ipt-out mr-15">
                                 <button class="btn radius0 btn-primary btn-small full-w">重置</button>
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
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/reg/setPwd.js"></script>
</body>
</html>
