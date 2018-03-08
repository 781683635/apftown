<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>

<% menuType = "1.3"; %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>站内信-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="renderer" content="webkit">
<!-- 移动屏幕的缩放初始缩放比例1.0，不允许用户缩放，最小比例1.0，最大比例1.0 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
<!-- 网站开启对web app的支持 -->
	<meta name="apple-mobile-web-app-capable" content="yes">
<!-- web app顶部状态条的颜色为灰色半透明 -->
	<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
<!-- 忽略页面中的数值识别为电话号码 -->
	<meta name="format-detection" content="telephone=no">
<!-- web app设备添加到主屏幕后全屏显示 -->
	<meta name="apple-touch-fullscreen" content="yes">
<!-- uc浏览器强制全屏	 -->
	<meta name="full-screen" content="yes">
<!-- 以utf-8格式编码 -->
	<meta charset="UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/user.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/pagination.css">
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
					<i class=" icon-angle-right pl-5 pr-5"></i><a class="hov-primary" href="<%=path %>/user/index.do">用户中心</a>
					<i class=" icon-angle-right pl-5 pr-5"></i>站内信
				</span>
			</div> 
		<%} %>
	
			<div class="row clear mb-20 pb-20">
				<%@ include file="./menu.jsp" %>
				<div class="col-sm-10 col-xs-12">
				     <div class="clear">
		                 <p class="pull-left col-555 mt-10 line-h-25 f-18 mb-10">站内信息
		                 </p>
		                 <div class="pull-right t-none col-white line-h-15 ">
			                 <c:if test="${fn:length(listMap)!=0 }">
			                    <a class="bg-primary pt-5 pb-5 pl-20 pr-20 mg-10 inline-block" onclick="opt('','read');">标记已读</a>
			                    <a class="btn-red pt-5 pb-5 pl-20 pr-20 mt-10 mb-10 inline-block" onclick="opt('','delete');">删除</a>
			                 </c:if>
		                 </div>                
		            </div>
					<div class="content">
			             <table class="hade bor-b-ccc col-12">
			                  <tbody class="col-12"> 
			       				 <tr class="text-center gradient-gray">
			                         <th class="text-center col-1 pd-10 bor-ccc">
			                         	<input id="checkAll" name="checkAll" type="checkbox" onclick="chkbox();"/>
			                         	<span class="hidden-sm">全选</span> 
			                         </th>
			                         <th class="col-2 bor-ccc pl-0 pr-0">标题
			                         </th>
			                         <th class="col-2 bor-ccc pl-0 pr-0">发件人
			                         </th>
			                         <th class="col-4 bor-ccc">内容
			                         </th>
			                         <th class="col-2 bor-ccc pl-0 pr-0">时间
			                         </th>
			                         <th class="col-3 wid-25 bor-ccc">状态
			                         </th>
			                     </tr>
								
			                     		<!-- 当没用信息时显示的内容 -->
		                     	<c:if test="${fn:length(listMap)==0 }">
			                    	 <tr>
				                     	<td class="text-center pt-20 pb-20 bor-ccc f-14" colspan="6">
				                     		<img src="${pageContext.request.contextPath}/img/user/warning.png" class="img-20"><span class="dis-ib ml-10">没有数据，请查看其它内容!</span>
				                     	</td>
			                    	 </tr>
			                    </c:if>
			                    <c:if test="${fn:length(listMap)!=0 }">
				                     <c:forEach var="list" items="${listMap }">
				                     	
					                     <tr class="text-center passValue" >
					                         <td class="text-center pd-10 bor-ccc" msgid="${list.id }">
					                         	<input name="subBox" type="checkbox" />
					                         </td>
					                         <td class="bor-ccc" >
					                            ${list.msg_title }
					                         </td>
					                         <td class="bor-ccc" >矿业圈
					                         </td>
					                         <td class="t-none bor-ccc" >
					                         	<div class="text-line-2" >
				                                    <a class="col-primary t-none line-h-15 "  onclick="show('popup');set(this);">
				                                      	${list.msg_content }
				                                    </a>            
				                                </div>
					                         </td>
					                         <td class="bor-ccc" >${list.create_time }
					                         </td>
					                         <td class="bor-ccc">
					                         	<c:if test="${list.status==0 }">
					                         		未读
					                         	</c:if>
					                         	<c:if test="${list.status==1 }">
					                         		已读
					                         	</c:if> 
					                         </td>
					                     </tr>	
				                     </c:forEach>
				                 </c:if>	
			                 </tbody>
			             </table>
			             <div class="pageHtml"></div>
					</div>
			    </div>
			</div>
			<form>
				<div class="show" id="popup">
				    <div class="modal-dialog">
				        <div class="modal-content">
				             <div class="modal-header clear">
				                <button type="button" class="close-mod pd-5">×</button>
				                <p class="ppa f-16 col-primary">内容</p>
				            </div>
				            <div class="pt-20 pb-20 pl-10 bor-b-ccc f-w">
				            	<span id="msg_name"></span>
				                <span id="create_time"></span>
				            </div>
				            <div class="pd-20">
				                <span class="col-ccc" id="msg_content"> </span>                  
				            </div>
				            <div class="pd-10 mt-20 text-center">
				                <button class="btn btn-small pt-5 pb-5 pl-20 pr-20 mr-10 col-white btn-primary
				                "type="submit"  onclick="window.location.href=<%=path %>user/userMsg.do">确定</button>
				            </div>
				        </div>
				    </div>
			    </div>
		    </form> 
		   <!--  <div class="show" id="delete">
		        <div class="modal-dialog">
		        	<div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close-mod pd-5">×</button>
			                <p class="ppa f-16 col-primary">标题</p>
			            </div>
			            <div class="text-center pt-20 pb-20">
			                <p class="col-ccc">你确定要删除此条消息吗？</p>                  
			            </div>
			            <div class="pd-10 mt-20 text-center">
			                <button class="btn btn-small pt-5 pb-5 pl-20 pr-20 mr-10 col-white btn-primary
			                ">确定</button>
			                <button class="btn btn-small pt-5 pb-5 pl-20 pr-20 col-white btn-gray">取消</button>
			            </div>
		        	</div> 
		        </div>	
			</div> -->
		
		</div> 
		<form action="<%=path %>/user/userMsg.do" id="pageForm">
			<input type="hidden" id="pageNum" name="pageNum" value="${pageNum }">
			<input type="hidden" id="pageSize" name="pageSize" value="${pageSize }">
			<input type="hidden" id="propCode" name="propCode" value="${propCode }">
		</form>
			<input type="hidden" id="totalCount" name="totalCount" value="${totalCount }"> 
	</div>
    
    
    
	<%@ include file="../comm/footer.jsp" %>
	<%@ include file="../comm/js.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/pagination.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/laytpl.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/comment.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/userMsg.js"></script>

  
  </body>
</html>
