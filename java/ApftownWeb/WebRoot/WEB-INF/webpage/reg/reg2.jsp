<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>


<% menuType = "reg2"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>短信验证页面-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/comm/sky-forms.css">
	
  </head>
  
  <body>
  	<div class="wrap bg-primary">
	    <%@ include file="../comm/header.jsp" %>
	  	
		<div class="">
			<div class="container">
				<div class="row clear">
					<div class="col-sm-8 hidden-xs pb-20 mb-20 mt-20 pt-20">
						<img src="<%=path %>/img/comm/image.png" alt="亚太金融（基金）小镇">
					</div>
					<div class="col-sm-4 pl-10 pr-10 pb-10 pt-20 mb-20 mt-20">
						<div class="bg-white pd-20 mt-20">
							<div class="pt-10">
								<p class="text-center f-18">注册获取验证码</p>
								<form action="${pageContext.request.contextPath }/reg2.do" class="sky-form pt-20" method="post" id="reg2">
								<input type="hidden" name="uname" value="${name }" id="uname">
						  		<c:if test="${type eq 0 }">
									<div class="f-13 mb-20">
										<div class="lab-out ">
											<label class="ipt-label inline-block line-h-20"
												for="userRegMobile">手机号: </label>
										</div>
										<div class="ipt-out mr-15">
											<input type="text" name="userRegMobile" value="${user_reg_email }" readonly="readonly" class="ipt-text" placeholder="您的手机号">
										</div>
									</div>
									<div class="f-13 mb-20">
										<div class="lab-out ">
											<label class="ipt-label inline-block line-h-20" for="imgCode">短信验证码:</label>
										</div>
										<div class="ipt-out mr-15">
	                                        <input type="text" id="smsCode" name="smsCode" maxlength="6" class="ipt-text" placeholder="请输入短信验证码">
	                                        <button type="button" id="getSmsCode"  class="idcode btn  gradient-gray" onclick="sendMessage('${user_reg_email }','${imgCode }','getSmsCode',null)">获取短信验证</button>
	                                    </div>
										
										<%-- <div class="ipt-out mr-15">
											<input type="text" class="ipt-text" id="smsCode" name="smsCode" maxlength="6" placeholder="请输入短信验证码">
											<button id="getSmsCode" type="button" onclick="sendMessage('${user_reg_email }','${imgCode }','getSmsCode',null)" class="smscode btn btn-small radius0 gradient-gray">短信验证</button>
										</div> --%>
									</div>
									<div class="ipt-form mb-15">
										<div class="lab-out">
											<label class="ipt-label inline-block line-h-20">&nbsp;</label>
										</div>
										<div class="ipt-out mr-15">
											<button id="" type="submit" class="btn radius0 btn-primary btn-small full-w">提交</button>
										</div>
									</div>
									</c:if>
						 		<c:if test="${type eq 1 }">
									<div class="f-14 mb-10 text-center mb-10">
									    <p class="col-red">请您在确认邮箱地址后点击发送验证码</p>
									</div>
									<div class="f-13 mb-10">
										<div class="lab-out ">
											<label class="ipt-label inline-block line-h-20" for="Mail">电子邮件:</label>
										</div>
										<div class="ipt-out mr-15">
											<input type="text"  value="${user_reg_email }" class="ipt-text" id="smsMail" name="smsMail"  placeholder="请输入您的邮箱" readonly="readonly">
											
										</div>
									</div>
									<div class="ipt-form mb-15">
										<div class="lab-out">
											<label class="ipt-label inline-block line-h-20">&nbsp;</label>
										</div>
										<div class="ipt-out mr-15">
											<button type="button" onclick="sendEmail('','${name }','${user_reg_email }','${imgCode }','reg')" class="btn radius0 btn-primary btn-small full-w">发送邮箱验证码</button>
										</div>
									</div>
								</c:if>
									
									

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../comm/footer.jsp" %>
	<%@ include file="../comm/js.jsp" %>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.form.min.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/reg/sendMsg.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/reg/reg2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/ckImgCode.js"></script>
  		
  </body>
</html>
