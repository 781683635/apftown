<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../comm/tag.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的关注-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
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
	<%@ include file="../../comm/css.jsp" %>
    <!-- 基本样式文件 -->
	<link rel="stylesheet" href="<%=path %>/css/comm/base.css">
	<link rel="stylesheet" href="<%=path %>/css/m/mobile-user.css">
		<link rel="stylesheet" href="<%=path %>/css/comm/pagination.css">
    <!-- 字体样式文件 -->
	<link rel="stylesheet" href="<%=path %>/ctrl/font/css/font-awesome.min.css">
	
  </head>
 
  <body>
	<div class="wrap">
	 	<%@ include file="../../comm/header.jsp" %> 
	   	<div class="container">
			<div class="row clear mb-20 pb-20">
			    <!-- 内容开始 -->
			    <form method="post" class="clear col-sm-8 " action="${pageContext.request.contextPath }/user/atten.do">
			        <div class="col-xs-12 pd-0 bor-ddd">
			            <!-- 查询 -->
			            <div class="col-xs-12 gradient-gray bor-rb-ddd pd-0">
			                <div class="f-13 col-xs-8 pt-5 pb-5 pl-0 pr-0">
			                    <div class="lab-out-v2 ">
			                        <label class="ipt-label inline-block">分类:</label>
			                    </div>
			                    <div class="ipt-out-v2">
			                        <div class="sel sel-ck code" name="code">
			                        	<input type="hidden" name="selectCode" >
			                            <div class="s-input radius-3">
			                                <span class="sel-span">请选择</span><i class="icon-caret-down"></i>
			                            </div>
			                            <ul class="opt opt-ck dis-n sel-ul">
			                       		    <li value="1">关于小镇</li>
			                                <li value="2">基金一条街</li>
			                                <li value="3">国际教育</li>
			                                <li value="4">亚太研究</li>
			                                <li value="5">服务中心</li>
			                                <li value="6">新闻中心</li>
			                            </ul>
			                        </div>
			                    </div>
			                </div>
			                <div class="col-xs-4 pt-5 pb-5 pl-10 pr-0">
			                    <button type="button" onclick="searchQuery()" class="btn radius-3 btn-primary btn-small pull-left">查询</button>
			                </div>
			            </div>
			        </div>    
		        </form>
	            <!-- 一	 -->
	         	<div class="col-xs-12 bg-white clear pd-0"  id="commentlist">
	            	
	            </div> 
	          	<div>
					<input type="hidden" id="pageNum" name="pageNum" value="${pageNum }">
					<input type="hidden" id="pageSize" name="pageSize" value="${pageSize }">
					<input type="hidden" id="totalCount" value="${totalCount }"> 
					<div class="pageHtml"></div>
				</div> 
			</div>
			    <!-- 内容结束 -->
		</div>
	</div>    
	   <%@ include file="../../comm/js.jsp" %>
	   <%@ include file="../../comm/footer.jsp" %>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/pagination.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/m/userAtten.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/laytpl.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/comment.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
		<script type="text/javascript">
			$(function(){
				window["_baseNath"]=path;
			})
		</script>
		<script type="text/html" id="commentDemo">
	{{# for (var i in d){ }}  
						<div class="col-xs-12 bg-white clear pd-0">
		            	<div class="col-xs-3 pd-5 "> 
		                    <img src="{{d[i].img }}" class="full-w h-50 cur-p radius-3" alt="亚太金融（基金）小镇">
		                </div>
						<div class="col-xs-9 pl-0 pr-10">
						        <p class="line-h-20 newline text-line-2 f-12 cur-p hov-primary text-left pt-10 pr-15">
						            {{d[i].title }}
						        </p>
						</div>
						<p class="pl-0 pr-10 col-xs-12">
								<time class="line-h-20 text-line-1 f-12 col-ccc pr-5 pl-5 pull-right">{{d[i].insert_time }}</time>
								<span class="line-h-20 text-line-1 f-12 col-ccc pr-5 pl-5 pull-right">{{d[i].name }}</span>
						</p>
						
						<div class="pos-a pos-close" >
							<img src="<%=path %>/img/user/close.png" class="img-20" onclick="nolike(null,'{{d[i].type}}','{{d[i].res_id}}');">
						</div>
		           		</div>
	{{# }  }}
	</script>
  </body>
  
</html>
