<%@page import="com.apft.utils.StringUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<%
String jspUrl = request.getServletPath();
Object objCode = request.getAttribute("propCode");
String strCode = "";
if(StringUtil.isNotEmpty(objCode)){
	strCode = objCode.toString().substring(0, 1);
}
%>
<div class="row clear hidden-xs">
	<div class="col-sm-1 pd-0 mt-10 text-right mr-20">
		<a href="<%=path %>/index.do">
			<img class="logo cur-p" src="<%=path %>/img/logo.png" alt="亚太金融（基金）小镇" title="亚太金融（基金）小镇" >
		</a>
	</div>
	<% if(StringUtil.isNull(menuType)){ %>
		<div class="col-sm-10 mt-15 overflow-h ml-20 pl-1">
			<div class="nav clear bor-ccc bor-t-none bor-b-none bor-r-none">
				<div class="col-sm-2 pl-0 pr-0 pt-5 cur-p poa-r overflow-h ml--5 ">
					<div class="nav-triangle-v1"></div>
					<div class="nav-triangle-v3"></div>
					<div class="<% if(jspUrl.contains("town") || "1".equals(strCode)){ %>gra-pri cur-wrap<% } %> t-none pt-20 town-hovbg" >
						<a href="<%=path %>/t/index.do">
							<h3 class="f-16 pl-20">关于小镇</h3>
							<p class="mt-5 line-h-15 f-11 pl-5 text-line-2 let-spa-1">发展海南金融、落地国家战略、促进亚太经济</p>
						</a>
					</div>
				</div>
				<div class="col-sm-2 pl-0 pr-0 pt-5 cur-p poa-r overflow-h ml-1">
					<div class="nav-list">
						<div class="nav-triangle-v2"></div>
						<div class="nav-triangle-v8"></div>
						<div class="<% if(jspUrl.contains("fund") || "2".equals(strCode)){ %>gra-pri cur-wrap<% } %> t-none pt-20 fund-hovbg">
							<a href="<%=path %>/f/index.do">
								<h3 class="f-16 col-black pl-20">基金一条街</h3>
								<p class="mt-5 line-h-15 f-11 pl-5 text-line-2 let-spa-1">基金注册、募集、投资、论坛，亚太资源交易中心</p>
							</a>
						</div>
					</div>
				</div>

				<div class="col-sm-2 pl-0 pr-0 pt-5 cur-p poa-r overflow-h ml-1">
					<div class="nav-list2">
						<div class="nav-triangle-v1"></div>
						<div class="nav-triangle-v5"></div>						
						<div class="<% if(jspUrl.contains("edu") || "3".equals(strCode)){ %>gra-pri cur-wrap<% } %> t-none pt-20 educ-hovbg">
							<a href="<%=path %>/e/index.do">
								<h3 class="f-16 col-black pl-20">国际教育</h3>
								<p class="mt-5 line-h-15 f-11 pl-5 text-line-2 let-spa-1">亚太金融研究院携手国内外知名院校开展金融培训</p>
							</a>
						</div>
					</div>
				</div>

				<div class="col-sm-2 pl-0 pr-0 pt-5 cur-p poa-r overflow-h ml-1">
					<div class="nav-list">
						<div class="nav-triangle-v2"></div>
						<div class="nav-triangle-v6"></div>
						<div class="<% if(jspUrl.contains("research") || "4".equals(strCode)){ %>gra-pri cur-wrap<% } %> t-none pt-20 research-hovbg">
							<a href="<%=path %>/r/index.do">
								<h3 class="f-16 col-black pl-20">亚太研究</h3>
								<p class="mt-5 line-h-15 f-11 pl-5 text-line-2 let-spa-1">由亚太金融研究院牵头成立并开展研究业务</p>
							</a>
						</div>
					</div>
				</div>


				<div class="col-sm-2 pl-0 pr-0 pt-5 cur-p poa-r overflow-h ml-1">
					<div class="nav-list2">
						<div class="nav-triangle-v1"></div>
						<div class="nav-triangle-v7"></div>
						<div class="<% if(jspUrl.contains("serve") || "5".equals(strCode)){ %>gra-pri cur-wrap<% } %> t-none pt-20 serve-hovbg">
							<a href="<%=path %>/s/index.do">
								<h3 class="f-16 col-black pl-20">服务中心</h3>
								<p class="mt-5 line-h-15 f-11 pl-5 text-line-2 let-spa-1">小镇提供全套优质服务、助力企业发展</p>
							</a>
						</div>
					</div>
				</div>

				<div class="col-sm-2 pl-0 pr-0 pt-5 cur-p poa-r overflow-h ml-1">
					<div class="nav-list">
						<div class="nav-triangle-v2"></div>
						<div class="nav-triangle-v4"></div>
						<div class="<% if(jspUrl.contains("news") && "6".equals(strCode)){ %>gra-pri cur-wrap<% } %> t-none pt-20 news-hovbg">
							<a href="<%=path %>/n/index.do">
								<h3 class="f-16 col-black pl-20">新闻中心</h3>
								<p class="mt-5 line-h-15 f-11 pl-5 text-line-2 let-spa-1">汇集小镇最新资讯、实时解读行业信息</p>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	<% } %>
</div>