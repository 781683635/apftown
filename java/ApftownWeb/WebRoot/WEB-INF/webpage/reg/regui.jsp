<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>

<% menuType = "regui"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
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
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/comm/sky-forms.css">
	
	
  </head>
  
  <body>
  <div class="wrap bg-primary">
  	<%@ include file="../comm/header.jsp" %>
	<div class="container pd-0">
		<div class="clear mt-20 pt-20">
			<div class="col-md-8 col-sm-6 hidden-xs">
				<img src="<%=path %>/img/comm/image.png" alt="亚太金融（基金）小镇" class="">
			</div>
			<div class="col-md-4 col-sm-6 mt-20 mb-20">
				<div class="bg-white pt-20 pb-20 ml-10 mr-10 shadow-rb">
					<div class="pt-10">
						<p class="text-center f-18 pt-10">注册</p>
						<form action="${pageContext.request.contextPath }/reg.do"
							class="sky-form pt-20 f-12" method="post" id="regForm">
							<div class="mb-10">
								<div class="lab-out ">
									<label class="ipt-label inline-block line-h-20" for="userName">用户名:</label>
								</div>
								<div class="ipt-out mr-15">
									<input type="text" class="ipt-text" placeholder="您的用户名"
										id="userName" name="userName">
								</div>
							</div>
							<div class="mb-10">
								<div class="lab-out">
									<label class="ipt-label inline-block line-h-20"
										for="userRegMobile">手机号/邮箱:</label>
								</div>
								<div class="ipt-out mr-15">
									<input type="text" id="user_reg_email" name="user_reg_email" class="ipt-text" placeholder="您的手机号或邮箱">
									<!-- <input type="hidden" id="userRegMail" name="userRegMail" class="ipt-text" placeholder="您的手机号或邮箱"> -->
								</div>
								
								
							</div>
							<div class="mb-10">
								<div class="lab-out ">
									<label class="ipt-label inline-block line-h-20" for="userPwd">密码:</label>
								</div>
								<div class="ipt-out mr-15">
									<input type="password" class="ipt-text" id="userPwd"
										name="userPwd" placeholder="建议使用6-20个字母、数字">
								</div>
							</div>
							<div class="mb-10">
								<div class="lab-out ">
									<label class="ipt-label inline-block line-h-20" for="userPwd2">确认密码:</label>
								</div>
								<div class="ipt-out mr-15">
									<input type="password" class="ipt-text" id="userPwd2"
										name="userPwd2" placeholder="确认密码">
								</div>
							</div>
							<div class="mb-10">
								<div class="lab-out ">
									<label class="ipt-label inline-block line-h-20" for="imgCode">推荐码:</label>
								</div>
								<div class="ipt-out mr-15">
									<input type="text" class="ipt-text" id="userFrom"
										name="userFrom" placeholder="请输入推荐码">
								</div>
							</div>
							<div class="mb-10">
								<div class="lab-out ">
									<label class="ipt-label inline-block line-h-20" for="imgCode">图形验证码:</label>
								</div>
								<div class="ipt-out mr-15">
									<input type="text" class="ipt-text" id="imgCode"
										name="imgCode" maxlength="4" placeholder="请输入图形验证码">
									<img id="randCode"
										src="${pageContext.request.contextPath }/randcode"
										onclick="updateCode('randCode');" class="idcode"
										title="看不清，换一张">
								</div>
							</div>
							<div class="mb-10 clear">
								<div class="mr-15 clear col-sm-11 col-offset-1">
									<button id="reg" type="submit"
										class="btn radius0 btn-primary btn-small full-w">注册提交</button>
								</div>
							</div>
							<p class="mr-20 mb-10 pr-20 clear text-right">
								已有账户，请<a class="col-primary" href="<%=path %>/loginui.do">登录</a>
							</p>
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
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/ckImgCode.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/reg/regui.js"></script>
</body>
</html>
