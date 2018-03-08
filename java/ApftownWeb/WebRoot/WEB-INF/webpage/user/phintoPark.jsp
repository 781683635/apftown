 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../comm/tag.jsp" %>

<%  menuType = "sys4"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>手机入园-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
    <%@ include file="../comm/css.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/user.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/pagination.css">
	
  </head>
  
  <body>
	<div class="wrap clear">
		<%@ include file="../comm/header.jsp" %>
		<div class="container clear">
			<div class="clear">
				<img class="pull-left" src="<%=path %>/img/user/user03.png" alt="亚太金融（基金）小镇"> 
				<span class="pull-left f-18 pt-20 pl-10">用户中心</span>
				<span class="pull-right pt-20">
					<a class="hov-primary" href="<%=path %>/index.do">首页</a>
					<i class=" icon-angle-right pl-5 pr-5"></i>
						<a class="hov-primary" href="<%=path %>/user/index.do">用户中心</a>
					<i class=" icon-angle-right pl-5 pr-5"></i>入院管理
				</span>
			</div>
			<div class="row pt-10">
				<%@ include file="./menu.jsp"%>
				<div class="col-sm-12 col-md-10 mb-10 bor-light pt-5">
					<div class="clear">
						<c:if test="${sessionScope.UserEntity.getUserName() != 'news' }">
							<div class="text-center mt-20"> 
								<h2 class="">抱歉，您不是管理员</h2>
							</div>
						</c:if>
						<c:if test="${sessionScope.UserEntity.getUserName() == 'news' }">
							<!-- 入园管理头部 -->
							<div class="row mb-10">
								<h3 class="f-14 gradient-gray clear">
									<span class="pull-left pd-10 line-h-20 f-18">入园管理</span>
								</h3>
							</div>
							<!-- 操作管理 -->
							<div class="clear row f-12 pb-10 mt-10 bor-b-2">
								<form class="clear" id="pageForm" action="${pageContext.request.contextPath }/user/phintoPark.do" method="post">
									<input type="hidden" id="pageNum" name="pageNum"  value="${pageNum }"> 
									<input type="hidden" id="pageSize"  name="pageSize"  value="${pageSize }"> 
									<input type="hidden" id="totalCount"  name="totalCount" value="${totalCount }"> 
									<!-- 查询入园联系人 -->
									<div class="col-sm-6 col-md-4 pull-right">
										<div class="search">
											<div class="search-con">
												<input id="searchTitle" name="company_name" type="text" class="ipt-text size-small" placeholder="输入你想要查找的公司名称" value="${companyname }">
												<button class="sea-btn-v2 btn btn-small gradient-primary">查询</button>
											</div>
										</div>
									</div>
								</form>
							</div>
							<!-- 入园列表 -->
							<div class="clear mb-10 mt-10">
								<table cellspacing="0" class="bor-primary full-w text-center newline line-h-20 ">
									<caption class="f-16 mb-10">入园申请书列表</caption>
									<thead class="bg-l-blue">
										<tr class="">
											<th class="col-1">姓名</th>
											<th class="col-2">电话</th>
											<th class="col-1">邮箱</th>
											<th class="col-1">职务</th>
											<th class="col-2">公司名称</th>
											<th class="col-1">时间</th>
											<!-- <th class="col-2">状态</th> -->
											 <th class="col-2">操作</th> 
										</tr>
									</thead>
									<tbody class="text-center line-h-20" id="tradelist">
										<c:forEach var="listMap" items="${listMap }" varStatus="vs">
											<tr class="<c:if test='${vs.index%2==1 }'> bg-l-green </c:if> <c:if test='${vs.index%2!=1 }'>bg-white</c:if>">
											  <input type="hidden" id="id" name="id" value="${listMap.id }">
												<td class="pd-5">
													${listMap.contact_person}
												</td>
												<td class="pd-5">
													${listMap.contact_phone}
												</td>
												<td class="pd-5">
													${listMap.contact_email}
												</td>
												<td class="pd-5 ">
													${listMap.duties}
												</td>
												<td class="pd-5 ">
													${listMap.company_name}
												</td>
												<td class="pd-5 ">
													${listMap.update_time}
												</td>
												<%-- <td class="pd-5 ">
													<c:if test="${listMap.status=='0'}">入驻申请</c:if>
													<c:if test="${listMap.status=='1'}">预先核名</c:if>
													<c:if test="${listMap.status=='2'}">企业登记</c:if>
													<c:if test="${listMap.status=='3'}">刻章</c:if>
													<c:if test="${listMap.status=='4'}">银行开户</c:if>
													<c:if test="${listMap.status=='5'}">税务登记</c:if>
													<c:if test="${listMap.status=='6'}">已结束</c:if>
													
												</td>
												--%>
												<td class="pd-5">
													<div class="sel-ck search text-center" id="layer">
														<div class="bg-primary">
															<span class="inline-block icon-edit text-center f-16 col-white"></span>
															<i class="icon-caret-down f-20 col-white"></i>
														</div>
														<ul class="opt opt-ck">
																<%-- 	<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="upComp('${listMap.id }','0')">入驻申请</li>
																	<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="upComp('${listMap.id }','1')">预先核名</li>
																	<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="upComp('${listMap.id }','2')">企业登记</li>
																	<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="upComp('${listMap.id }','3')">刻章</li>
																	<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="upComp('${listMap.id }','4')">银行开户</li>
																	<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="upComp('${listMap.id }','5')">税务登记</li>
																	<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="upComp('${listMap.id }','6')">已结束</li> --%>
																	<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="upCInfo('${listMap.id }')">修改入驻信息</li>
																	<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="upComp('${listMap.id }','delete')">删除记录</li>
														</ul>
													</div>
												</td> 
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div align="center" class="pull-left full-w text-center mt-10 mb-10">
									<div class="pageHtml"></div>
								</div>
							</div>
						</c:if>
					</div>
				</div>		
			</div>
		</div>
	</div>
    <%@ include file="../comm/footer.jsp"%>
	<%@ include file="../comm/js.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/pagination.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/user/resList.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/user/pintoPark.js"></script> 
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
  </body>
</html>
