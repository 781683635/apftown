 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../comm/tag.jsp" %> 
<%  menuType = "sys3"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>内容位置管理-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/user.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/pagination.css">
	
  </head>
  
  <body>
  <div class="warp">
	<%@ include file="../comm/header.jsp" %>
	<div class="container clear">
	<div class="clear">
			<img class="pull-left" src="<%=path %>/img/user/user03.png" alt="亚太金融（基金）小镇"> 
			<span class="pull-left f-18 pt-20 pl-10">用户中心</span>
			<span class="pull-right pt-20">
				<a class="hov-primary" href="<%=path %>/index.do">首页</a>
				<i class=" icon-angle-right pl-5 pr-5"></i><a class="hov-primary" href="<%=path %>/user/index.do">用户中心</a>
				<i class=" icon-angle-right pl-5 pr-5"></i>top管理
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
						
						<!-- 新闻管理头部 -->
						<div class="row mb-10">
							<h3 class="f-14 gradient-gray clear">
								<span class="pull-left pd-10 line-h-20 f-18">top管理</span>
							</h3>
						</div>
						<br/>
						<!-- 新闻发布 -->
						<div class="clear row f-12 pb-10 mb-10 bor-b-2">
							<form id="pageForm" method="post" class="clear col-sm-8 " action="${pageContext.request.contextPath }/user/top.do">
							 	<input type="hidden" id="pageNum" name="pageNum"  value="${pageNum }"> 
								<input type="hidden" id="pageSize"  name="pageSize"  value="${pageSize }"> 
								<input type="hidden" id="totalCount"  name="totalCount" value="${count }">
							
								<div class="col-sm-3">
									<span class="inline-block pt-10 pb-10 pull-right">请选择查询位置：</span>
								</div>
								<div class="col-sm-3">
									<div class="sel sel-ck">
										<input type="hidden"  name="catCentre" value="${cat }">
										<div class="s-input"><span>请选择页面</span><i class="icon-caret-down"></i></div>
										<ul class="opt opt-ck line-h-20">
											<li value="0">首页</li>
											<li value="1">小镇</li>
											<li value="2">基金</li>
											<li value="3">教育</li>
											<li value="4">研究</li>
											<li value="5">服务</li>
											<li value="6">新闻</li>
										</ul>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="sel sel-ck">
										<input type="hidden" name="bkCentre" value="${bk}">
										<div class="s-input"><span>请选择位置</span><i class="icon-caret-down"></i></div>
										<ul class="opt opt-ck line-h-20"> 
											<li value="0">左侧</li>
											<li value="101">中间1层</li>
											<li value="201">中间2层</li>
											<li value="301">中间3层</li>
											<li value="401">中间4层</li>
											<li value="501">中间5层</li>
										</ul>
									</div>
								</div>
								<div class="col-sm-3 text-right">
									<button class="btn btn-small gradient-primary" type="submit">查询</button>
								</div>
								<input name="#no" value="res_top rt" type="hidden">
								<input type="hidden"  name="rt.cat" value="${cat}"> 
								<input type="hidden"  name="rt.bk" value="${bk}"> 
								 <input type="hidden"  name="rt.res_id" value=""> 
								
								<!-- <input type="hidden"  name="rt.id" value=""> 
								<input type="hidden"  name="rt.top" value=""> 
								<input type="hidden"  name="rt.img" value=""> 	 -->
							</form>
						</div>
						<br/><br/>
						<br/>
						<!-- 新闻列表 -->
						
						<div class="clear mb-10 ">
							<table cellspacing="0" class="bor-primary full-w text-center newline line-h-20 ">
								<caption class="f-16 mb-10">新闻列表</caption>
								<thead class="bg-l-blue">
									<tr class="">
										<th class="col-1">
											<label> 
												<input type="checkbox" name="chebox" onclick="chkbox();">
												<span class="hidden-sm dis-ib ml-5">全选</span> 
											</label>
										</th>
										<th class="col-1">编号</th>
										<th class="newlist_media_1">标题</th>
										<th class="col-2">时间</th>
										<th class="col-1">操作</th>
									</tr>
								</thead>
								<tbody class="text-center line-h-20" id="tradelist">
									<c:forEach var="list" items="${listMap }" varStatus="vs">
										<tr class="<c:if test='${vs.index%2==1 }'> bg-l-green </c:if> <c:if test='${vs.index%2!=1 }'>bg-white</c:if> " resId="${list.id }" resImg="${list.img }">
											<td>
											  <input type="checkbox"><img src="${list.img}" class="img-60 ml-10">
											</td>
											<td class="pd-5">${list.no }</td>
											<td class="pd-5" onclick="window.location.href='<%=path %>/n/i.do?no=${ list.no}'">
												<p class="text-line-2">${list.title}</p>
											</td>
											<td class="pd-5">${list.update_time}</td>
											<td class="pl-10 pr-10">
												<div class="sel-ck search text-center" id="layer">
													<div class="bg-primary">
														<span class="inline-block icon-edit text-center f-16 col-white"></span>
														<i class="icon-caret-down f-20 col-white"></i>
													</div>
													<ul class="opt opt-ck">
														<%-- <li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="updRes('${list.id }')">修改</li> --%>
														<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="updRes('${list.id }','top')">置顶</li>
														<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="updRes('${list.id }','delete')">删除</li>
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
	<%@ include file="../comm/js.jsp" %>

<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/laytpl.js"></script>  --%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/pagination.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/user/topMange.js"></script>
 

  </body>
</html>
