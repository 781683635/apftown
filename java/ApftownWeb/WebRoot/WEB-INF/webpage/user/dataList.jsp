<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../comm/tag.jsp" %>

<%  menuType = "sys2"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>报名管理-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
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
				<i class=" icon-angle-right pl-5 pr-5"></i>报名信息
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
						<!-- 报名管理头部 -->
						<div class="row mb-10">
							<h3 class="f-14 gradient-gray clear">
								<span class="pull-left pd-10 line-h-20 f-18">报名管理</span>
							</h3>
						</div>
						<br/>
						<!-- 操作管理 -->
						<div class="clear row f-12 pb-10 mb-10 bor-b-2">
							<!-- 添加删除查询 -->
							<%-- <div class="col-sm-4">
								<div class="text-center">
									<button type="button" class=" btn btn-small gradient-primary" onclick="window.open('<%=path %>/user/resAdd.do')">添加</button>
								</div>
								<div class="col-sm-6 text-center">
									<button type="button" class=" btn btn-small gradient-primary"
										onclick="onclick=del();">删除</button>
								</div>
							</div> --%>
							
						
							<form id="pageForm" action="${pageContext.request.contextPath }/user/dataList.do" method="post">
								<input type="hidden" id="pageNum" name="pageNum"  value="${pageNum }"> 
								<input type="hidden" id="pageSize"  name="pageSize"  value="${pageSize }"> 
								<input type="hidden" id="totalCount"  name="totalCount" value="${totalCount }"> 
								<!-- 查询新闻 -->
								<div class="col-sm-8">
									<div class="col-sm-3">
										<div class="sel sel-ck">
											<input type="hidden" id="status" name="status" value="${status }">
											<div class="s-input"><span>请选择状态</span><i class="icon-caret-down"></i></div>
											<ul class="opt opt-ck line-h-20">
												<li value="">全部</li>
												<li value="0">未联系</li>
												<li value="1">已联系</li>
												
											</ul>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="search">
											<div class="search-con">
												<input id="searchTitle" name="attribName" type="text" class="ipt-text size-small" placeholder="输入你想要查找的姓名" value="${attribName }">
												<button class="sea-btn-v2 btn btn-small gradient-primary">查询</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
						<br/>
						<!-- 报名列表 -->
						<div class="clear mb-10 ">
							<table cellspacing="0" class="bor-primary full-w text-center newline line-h-20 ">
								<caption class="f-16 mb-10">报名列表</caption>
								<thead class="bg-l-blue">
									<tr class="">
										<th class="col-1">姓名</th>
										<th class="col-2">电话</th>
										<th class="col-1">邮箱</th>
										<th class="col-2">单位</th>
										<th class="col-1">职位</th>
										<th class="col-2">备注</th>
										<th class="col-1">进度</th>
										<th class="col-2">操作</th>
									</tr>
								</thead>
								<tbody class="text-center line-h-20" id="tradelist">
								<c:forEach var="listMap" items="${listMap }" varStatus="vs">
									<tr class="<c:if test='${vs.index%2==1 }'> bg-l-green </c:if> <c:if test='${vs.index%2!=1 }'>bg-white</c:if>">
									  <input type="hidden" id="res_id" name="res_id" value="${listMap.res_id }">
										<td class="pd-5">
											${listMap.name }
										</td>
										<td class="pd-5">
											${listMap.mobile }
										</td>
										<td class="pd-5">
											${listMap.email }
										</td>
										<td class="pd-5 ">
											${listMap.company}
										</td>
										<td class="pd-5 ">
											${listMap.job}
										</td>
										<td class="pd-5 ">
											${listMap.director }
										</td>
										
										<td class="pd-5 ">
										 	<c:if test="${listMap.update_status==0}">未联系</c:if>
											<c:if test="${listMap.update_status==1}">已联系</c:if>  
										</td>
										<td class="pl-10 pr-10">
											<div class="sel-ck search text-center" id="layer">
												<div class="bg-primary">
													<span class="inline-block icon-edit text-center f-16 col-white"></span>
													<i class="icon-caret-down f-20 col-white"></i>
												</div>
												<ul class="opt opt-ck">
													<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="upShow('remark','${listMap.res_id}');">更改备注</li>
													<li class="pd-5 text-center hov-primary cur-p bor-b-l" onclick="updRes('${listMap.update_status }','${listMap.res_id }')">已联系</li>
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
    <!-- 弹出层 -->
    <!-- 填写用户名 -->
    <div class="show" id="remark">
        <div class="modal-dialog ">
            <div class="modal-content ">
                <div class="modal-header ">
                    <button type="button " class="close-mod ">×</button>
                    <p class="icon-pushpin pl-5">&nbsp;&nbsp;修改备注</p>
                </div>
                <form class="sky-form modal-main " id="updaRemarkForm">
                	<input type="hidden" id="remarkId" value="">
                    <p class="mb-10 line-h-20">
                        <span class="modal-msg icon-info-sign ">&nbsp;温馨提示:</span> 
                            请填写您要修改的备注信息:
                    </p>
                    <div class="row clear mb-15 ">
                        <div class="col-sm-2 text-right f-14 col-999 pt-10 pb-10 pl-0 pr-15 " >
                            备注：
                        </div>
                        <div class="col-sm-10 pl-0">
                            <textarea class="textarea textarea-numberbar radius0" cols="30" rows="10" name="upremark" id="upremark"></textarea>
                        </div>
                    </div>
                    <div class="bor-b-l ">
                    </div>
                    <div class="pd-10 ml-10 mr-10 text-right ">
                    	<button class="btn btn-primary f-14 btn-small mr-20" type="submit">提交</button>
                    	<button class="btn btn-primary f-14 btn-small " type="reset" >重置</button>
                </form>
                    </div>
            </div>
        </div>
    </div>
	<%@ include file="../comm/js.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/pagination.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/user/dataList.js"></script> 
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
  </body>
</html>
