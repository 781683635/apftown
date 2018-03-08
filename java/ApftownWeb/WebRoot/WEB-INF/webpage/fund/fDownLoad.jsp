<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>  
<%String Type = "3.2"; %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>资料下载-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
	<meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	<meta name="renderer" content="webkit"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"> 
	<meta name="apple-mobile-web-app-capable" content="yes"> 
	<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"> 
	<meta name="format-detection" content="telephone=no"> 
	<meta name="apple-touch-fullscreen" content="yes"> 
	<meta name="full-screen" content="yes"> 
	<meta charset="UTF-8"> 
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/apft.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors/colors.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/user/user.css">


  </head>
  
  <body>
  <div class="wrap fund ">
	<%@ include file="../comm/header.jsp" %>
	<div class="container">
		<div class="clear">
			<img class="pull-left" src="${pageContext.request.contextPath}/img/user/user04.png" alt="亚太金融（基金）小镇"> 
			<span class="pull-left f-18 pt-20 pl-10">政策与服务</span>
			<span class="pull-right pt-20">
				<a class="hov-primary" href="<%=path %>/index.do">首页</a>
				<i class=" icon-angle-right pl-5 pr-5" ></i>
				<a class="hov-primary" href="<%=path %>/f/fInto.do">政策与服务</a>
				<i class=" icon-angle-right pl-5 pr-5"></i> 
				资料下载
			</span>
		</div>

		<div class="row clear mb-20 pb-20 mt-10">
		<!-- 侧边栏菜单 --> 
		<div class="col-md-2 col-sm-12  hidden-xs">
			<%@ include file="./fundMenu.jsp"%>
		</div>
		<!-- 侧边栏菜单end -->
		<!-- 内容开始 -->
			<div class="col-md-10 col-sm-12 pd-0  clear">
				<!-- 入园申请头部 -->
					<div class="clear mb-20">
						<h3 class="clear gradient-gray line-h-40">
							<span class="f-20 mt-10 col-primary pl-10 f-w">常用资料下载</span>
		                 	<span class="f-18 mb-10 col-ccc pl-10">Data Download</span>
						</h3>            
		            </div>
		        <!-- 入园申请头部END -->
				<!-- 资料下载 -->
					<div class="foldv2_c">
							<table class="full-w mt-20 mb-20 listv1 bor-ccc">
								<thead class="bg-555">
									<tr>
										<th class="col-1 pt-15 pb-15 col-white">编号</th>
										<th class="col-7 pt-15 pb-15 col-white">文件名称</th>
										<th class="col-2 pt-15 pb-15 col-white">发布时间</th>
										<th class="col-2 pt-15 pb-15 col-white">点击下载</th>
									</tr>
								</thead>
								<tbody class="bg-ddd">
									<tr>
										<td>1</td>
										<td><i class="icon-briefcase f-14 pr-10"></i>亚太金融小镇入驻申请书.zip</td>
										<td>2017-6-1</td>
										<td><a href="http://www.apftown.com/upload/fund/亚太金融小镇入驻申请书.zip"download></a></td>
									</tr>
									<tr class="bg-white">
										<td>2</td>
										<td><i class="icon-briefcase f-14 pr-10"></i>公司登记（备案）申请表.zip</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/公司登记（备案）申请表.zip"download></a></td>
									</tr>
									<tr>
										<td>3</td>
										<td><i class="icon-folder-close-alt f-14 pr-10"></i>企业设立所需资料清单</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/企业设立所需资料清单.docx"download></a></td>
									</tr>
									<tr class="bg-white">
										<td>4</td>
										<td><i class="icon-folder-close-alt f-14 pr-10"></i>承诺书（企业）</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/承诺书（企业）.pdf"download></a></td>
									</tr>
									<tr>
										<td>5</td>
										<td><i class="icon-folder-close-alt f-14 pr-10"></i>公司登记（备案）申请书填写说明</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/公司登记（备案）申请书填写说明.pdf"download></a></td>
									</tr>
									<tr class="bg-white">
										<td>6</td>
										<td><i class="icon-folder-close-alt f-14 pr-10"></i>公司登记（备案）申请书</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/公司登记（备案）申请书.pdf"download></a></td>
									</tr>
									<tr>
										<td>7</td>
										<td><i class="icon-folder-close-alt f-14 pr-10"></i>企业名称预先核准申请书填写说明书</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/企业名称预先核准申请书填写说明书.pdf"download></a></td>
									</tr>
									<tr class="bg-white">
										<td>8</td>
										<td><i class="icon-folder-close-alt f-14 pr-10"></i>企业名称预先核准申请书</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/企业名称预先核准申请书.pdf"download></a></td>
									</tr>
									<tr>
										<td>9</td>
										<td><i class="icon-folder-close-alt f-14 pr-10"></i>一人有限公司章程</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/一人有限公司章程.pdf"download></a></td>
									</tr>
									<tr class="bg-white">
										<td>10</td>
										<td><i class="icon-folder-close-alt f-14 pr-10"></i>有限责任公司章程</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/有限责任公司章程.pdf"download></a></td>
									</tr>
									<tr>
										<td>11</td>
										<td><i class="icon-folder-close-alt f-14 pr-10"></i>指定代表或者共同委托代理人授权委托书填写说明</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/指定代表或者共同委托代理人授权委托书填写说明.pdf"download></a></td>
									</tr>
									<tr class="bg-white">
										<td>12</td>
										<td><i class="icon-folder-close-alt f-14 pr-10"></i>指定代表或者共同委托代理人授权委托书</td>
										<td>2017-5-3</td>
										<td><a href="http://www.apftown.com/upload/fund/指定代表或者共同委托代理人授权委托书.pdf"download></a></td>
									</tr>
								</tbody>
							</table>
						</div>
					<!-- 打包下载end -->
				<!-- 主要内容结束 -->
			</div>
			<!-- 内容结束 -->
		</div> 
	</div> 
  </div> 
  <%@ include file="../comm/footer.jsp" %>
  <%@ include file="../comm/js.jsp" %>
  <script src="${pageContext.request.contextPath}/js/comm/user.js"></script>  
  </body>
</html>