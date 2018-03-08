<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

		<!-- 侧边栏菜单 -->
		<div class="col-sm-12 col-md-2 hidden-xs">
			<div class="con-side">
				<ul id="fold1" class="fold bg-white">
					<% if("news".equals(user.getUserName())){ %>
						<li class="item mb-10">
							<h4 class="gradient-gray f-13">
								<img src="${pageContext.request.contextPath}/img/user/system.png" class="img-25">
								<span class="f-14 line-h-20 ml-5" >系统管理</span>
								<b>+</b>
							</h4>
							<div class="info">
								<ul>
									<li class="<% if("sys1".equals(menuType)){ %>tit-current<% } %>">
										<a class="inline-block full-w f-14 " href="<%=path %>/user/resList.do">新闻管理</a>
									</li>
									<li class="<% if("sys2".equals(menuType)){ %>tit-current<% } %>">
										<a class="inline-block full-w f-14 " href="<%=path %>/user/dataList.do">报名管理</a>
									</li>
									<li class="<% if("sys3".equals(menuType)){ %>tit-current<% } %>">
										<a class="inline-block full-w f-14 " href="<%=path %>/user/top.do">top管理</a>
									</li>
									<li class="<% if("sys4".equals(menuType)){ %>tit-current<% } %>">
										<a class="inline-block full-w f-14 " href="<%=path %>/user/phintoPark.do">入园管理</a>
									</li>
								</ul>
							</div>
						</li>
					<% } %>
					
					<li class="item mb-10">
					  <h4 class="gradient-gray f-14">
							<img src="${pageContext.request.contextPath}/img/user/user.png" class="img-25">
							<span class="f-14 line-h-20 ml-5" >用户中心</span>
							<b>+</b>
						</h4>
						<div class="info">
							<ul>
								<li class="<% if("1.1".equals(menuType)){ %>tit-current<% } %>">
									<a class="inline-block full-w f-14 " href="<%=path %>/user/index.do">用户首页</a>
								</li>
								<li class="<% if("1.2".equals(menuType)){ %>tit-current<% } %>">
									<a class="inline-block full-w f-14 " href="${pageContext.request.contextPath }/user/userAuthen.do">基本资料</a>
								</li>
								<li class="<% if("1.3".equals(menuType)){ %>tit-current<% } %>">
						   			<a class="inline-block full-w f-14 " href="<%=path%>/user/userMsg.do">站内信</a>
						   		</li>
						   		<li class="<% if("1.4".equals(menuType)){ %>tit-current<% } %>">
						   			<a class="inline-block full-w f-14 " href="<%=path%>/user/UintoPark.do">入园服务</a>
						   		</li>
							</ul>
						</div>
					</li>
					
					<li class="item mb-10">
						<h4 class="gradient-gray f-14">
							<img src="${pageContext.request.contextPath}/img/user/attention.png" class="img-25">
							<span class="f-14 line-h-20 ml-5" >关注中心</span>
							<b>+</b>
						</h4>
						<div class="info">
							<ul>
								<li class="<% if("2.1".equals(menuType)){ %>tit-current<% } %>">
									<a class="inline-block full-w f-14 " href="<%=path%>/user/atten.do">我的关注</a>
								</li>
							</ul>
						</div>
					</li>				
															
					<li class="item mb-10">
						<h4 class="gradient-gray f-14">
							<img src="${pageContext.request.contextPath}/img/user/gift.png" class="img-25">
							<span class="f-14 line-h-20 ml-5" >礼券邀请</span>
							<b>+</b>
						</h4>
						<div class="info">
							<ul>
								<li class="<% if("6.1".equals(menuType)){ %>tit-current<% } %>">
									<a class="inline-block full-w f-14 " href="<%=path %>/user/invite.do">邀请好友</a>
								</li>
							</ul>
						</div>
					</li>					  
				  
				</ul>

			</div>
		</div>
		<!-- 侧边栏菜单end -->
