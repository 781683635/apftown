<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
		<div class="con-side">
			<ul id="fold1" class="fold"> 
				<li class="item mb-10">
					<h4 class="gradient-gray f-14">
						<img src="${pageContext.request.contextPath}/img/fund/attract.png" class="img-25">
						<span class="f-14 line-h-20 ml-5" >招商服务</span>
						<b>+</b>
					</h4>
					<div class="info">
				 		<ul>
							<li class="<% if("1.1".equals(Type)){ %>tit-current<% } %>">
								<a class="inline-block full-w f-14 " href="<%=path%>/user/fInto.do">企业入驻</a>
							</li>
							<%-- <li class="<% if("1.2".equals(Type)){ %>tit-current<% } %>">
								<a class="inline-block full-w f-14 " href="<%=path%>/f/fChange.do">企业变更</a>
							</li>
							
							<li class="<% if("1.3".equals(Type)){ %>tit-current<% } %>">
					   			<a class="inline-block full-w f-14 " href="<%=path%>/f/fMove.do">外企迁入</a>
					   		</li>
					   		
					   		<li class="<% if("1.4".equals(Type)){ %>tit-current<% } %>">
					   			<a class="inline-block full-w f-14 " href="<%=path%>/f/fPay.do">纳税申报</a>
					   		</li>
					   		
					   		<li class="<% if("1.5".equals(Type)){ %>tit-current<% } %>">
					   			<a class="inline-block full-w f-14 " href="<%=path%>/f/fAnnu.do">企业年检</a>
					   		</li>
					   		
					   		<li class="<% if("1.6".equals(Type)){ %>tit-current<% } %>">
					   			<a class="inline-block full-w f-14 " href="<%=path%>/f/fRec.do">企业备案</a>
					   		</li> --%>
						</ul> 
					</div>
				</li>

				<li class="item mb-10">
					<h4 class="gradient-gray f-14">
						<img src="${pageContext.request.contextPath}/img/fund/doc.png" class="img-25">
						<span class="f-14 line-h-20 ml-5" >政策文件</span>
						<b>+</b>
					</h4>
					<div class="info">
						<ul>
							<li class="<% if("2.1".equals(Type)){%>tit-current<% }%>">
								<a class="inline-block full-w f-14 " href="<%=path%>/user/fLayOut.do">投资类企业政策</a>
							</li>
							<%-- <li class="<% if("2.2".equals(Type)){%>tit-current<% }%>">
								<a class="inline-block full-w f-14 " href="<%=path%>/f/fNet.do"> 互联网金融政策 </a>
							</li>
							
					 	 	<li class="<% if("2.3".equals(Type)){ %>tit-current<% } %>">
					   			<a class="inline-block full-w f-14 " href="<%=path%>/f/fFina.do">融资租赁企业政策</a>
					   		</li>   --%>
						</ul>
					</div>
				</li>
				<li class="item mb-10">
					<h4 class="gradient-gray f-14">
						<img src="${pageContext.request.contextPath}/img/fund/intopark.png" class="img-25">
						<span class="f-14 line-h-20 ml-5" >入园申请</span>
						<b>+</b>
					</h4>
					<div class="info">
						<ul>
							<li class="<% if("4.1".equals(Type)){%>tit-current<% }%>">
								<a class="inline-block full-w f-14 " href="<%=path%>/user/fCInfo.do">提交入园申请</a>
							</li>
							<%-- <li class="<% if("2.2".equals(Type)){%>tit-current<% }%>">
								<a class="inline-block full-w f-14 " href="<%=path%>/f/fNet.do"> 互联网金融政策 </a>
							</li>
							
					 	 	<li class="<% if("2.3".equals(Type)){ %>tit-current<% } %>">
					   			<a class="inline-block full-w f-14 " href="<%=path%>/f/fFina.do">融资租赁企业政策</a>
					   		</li>   --%>
						</ul>
					</div>
				</li>								
				<li class="item mb-10">
					<h4 class="gradient-gray f-14">
						<img src="${pageContext.request.contextPath}/img/fund/ques.png" class="img-25">
						<span class="f-14 line-h-20 ml-5" >问题解答</span>
						<b>+</b>
					</h4>
					<div class="info">
						<ul>
							
							<li class="<% if("3.1".equals(Type)){ %>tit-current<% } %>" >
								<a class="inline-block full-w f-14 " href="<%=path%>/user/fQues.do">常见问题</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="item mb-10">
					<h4 class="gradient-gray f-14">
						<img src="${pageContext.request.contextPath}/img/fund/download.png" class="img-25">
						<span class="f-14 line-h-20 ml-5" >资料下载</span>
						<b>+</b>
					</h4>
					<div class="info">
						<ul>
							<li class="<% if("3.2".equals(Type)){ %>tit-current<% } %>" >
								<a class="inline-block full-w f-14 " href="<%=path%>/user/fDownLoad.do">资料下载</a>
							</li>
						</ul>
					</div>
				</li> 
			</ul> 
		</div> 
