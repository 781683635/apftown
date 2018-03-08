<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>

<%  menuType = "sys4"; %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>修改入驻申请-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <%@ include file="../comm/css.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/user/user.css">
   	
      
  </head>
  
  <body>
  	 <div class="wrap">
		<!-- <header class="full-w" style="height: 100px; background-color: green;"></header> -->
		<%@ include file="../comm/header.jsp" %>
		<div class="container">
			<% if(!s_oem.isMobile()){ %>
				<div class="clear">
					<img class="pull-left" src="<%=path %>/img/user/user03.png" alt="亚太金融（基金）小镇"> 
					<span class="pull-left f-18 pt-20 pl-10">用户中心</span>
					<span class="pull-right pt-20">
						<a class="hov-primary" href="<%=path %>/index.do">首页</a>
						<i class=" icon-angle-right pl-5 pr-5"></i>入园服务
						<i class=" icon-angle-right pl-5 pr-5"></i>修改入驻申请
					</span>
				</div>
			 <%} %>

		<div class="row clear mb-20 pb-20">
		<%@ include file="./menu.jsp" %>
		<!-- 内容开始 -->
		<div class="col-md-10 col-sm-12 pd-0  clear">
			<!-- 入园申请头部 -->
				<div class="clear mb-20">
					<h3 class="clear gradient-gray line-h-40">
						<span class="f-20 mt-10 col-primary pl-10 f-w">修改入驻申请</span>
	                 	<span class="f-18 mb-10 col-ccc pl-10">In The Application</span>
					</h3>            
	            </div>
	        <!-- 入园申请头部END -->
		<div class="clear full-w">
		<form class="sky-form clear" action="" id="FbainfoForm" name="FbainfoForm">
			<input name="#no" value="comp_information i" type="hidden">
	        <input name="#fk" value="i.user_id=u.id" type="hidden"> 
	        <c:choose> 
	        	<c:when test="${not empty comp[0].user_id}">
					<input type="hidden" name="i.user_id" value="${comp[0].user_id }">
				</c:when>
				<c:otherwise>
					<input type="hidden" name="i.user_id" value="@sUid@">
				</c:otherwise>
			</c:choose>
	        <input type="hidden" name="i.update_time" value="@tIMe@">
	        <input type="hidden" name="i.id" value="${comp[0].id }">
	        <c:choose> 
	        	<c:when test="${comp[0].status==0|| comp[0].status==null}">
					<input type="hidden" name="i.status" value="0">
				</c:when>
				<c:otherwise>
					<input type="hidden" name="i.status" value="${comp[0].status }">
				</c:otherwise>
			</c:choose>
	        <p class="f-22 text-center">入驻基本信息</p>
	        <!-- 姓名电话 -->
			 	<div class="full-w pull-left pt-15">
			 		<div class="col-6 pull-left">
						<div class="col-4 pull-left pd-0">
							<label class="inline-block ipt-label">
								<em class="col-red">*&nbsp;</em>
								姓名:
							</label>
						</div>
						<div class="col-8 pull-left pd-0">
							 <div class="clear">
								<input type="text" class="ipt-text" placeholder="" name="i.contact_person" id="i.contact_person" value="${comp[0].contact_person }">
							</div> 
						</div>
					</div>
					<div class="col-6 pull-left">
						<div class="col-4 pull-left pd-0">
							<label class="inline-block ipt-label">
								<em class="col-red">*&nbsp;</em>
								电话:
							</label>
						</div>
						<div class="col-8 pull-left pd-0">
							<div class="clear">
								<input type="text" class="ipt-text" placeholder="" name="i.contact_phone" id="i.contact_phone" value="${comp[0].contact_phone }">
							</div>
						</div>
					</div>
			 	</div>
			<!-- 姓名电话END -->
			<!-- 邮箱职位 -->
			 	<div class="full-w pull-left pt-15">
			 		<div class="col-6 pull-left">
						<div class="col-4 pull-left pd-0">
							<label class="inline-block ipt-label">
								<em class="col-red">*&nbsp;</em>
								邮箱:
							</label>
						</div>
						<div class="col-8 pull-left pd-0">
							<div class="clear">
								<input type="text" class="ipt-text" placeholder="" name="i.contact_email" id="i.contact_email" value="${comp[0].contact_email }">
							</div>
						</div>
					</div>
					<div class="col-6 pull-left">
						<div class="col-4 pull-left pd-0">
							<label class="inline-block ipt-label">
								<em class="col-red">*&nbsp;</em>
								职位:
							</label>
						</div>
						<div class="col-8 pull-left pd-0">
							<div class="clear">
								<input type="text" class="ipt-text" placeholder="" name="i.duties" id="i.duties" value="${comp[0].duties }">
							</div>
						</div>
					</div>
			 	</div>
			<!-- 邮箱职位END -->
			<!-- 企业名称及邮编 -->
			<div class="clear full-w ">
				<div class="col-6 pull-left pt-15">
					<div class="col-4 pull-left pl-0 pr-0">
						<label class="inline-block ipt-label">
							<em class="col-red">*&nbsp;</em>
							拟定企业名称:
						</label>
					</div>
					<div class="col-8 pull-left pd-0">
						<div class="clear">
							<input type="text" class="ipt-text" placeholder="" name="i.company_name" value="${comp[0].company_name }">
						</div>
					</div>
				</div>
				<div class="col-6 pull-left pt-15">
					<div class="col-4 pull-left pd-0">
						<label class="inline-block ipt-label">
							<em class="col-red">*&nbsp;</em>
							邮编:
						</label>
					</div>
					<div class="col-8 pull-left pd-0">
						<div class="clear">
							<input type="text" class="ipt-text mb-10" placeholder="" name="i.zipcode" value="${comp[0].zipcode }">
						</div>
					</div>
				</div>
			</div>
			<!-- 企业名称及邮编 -->
			<div class="clear full-w ">
				<div class="col-6 pull-left pt-15">
					<div class="col-4 pull-left pl-0 pr-0">
						<label class="inline-block ipt-label">
							<em class="col-red">*&nbsp;</em>
							实际办公地址:
						</label>
					</div>
					<div class="col-8 pull-left pd-0">
						<div class="clear">
							<input type="text" class="ipt-text" placeholder="" name="i.office_address" value="${comp[0].office_address }">
						</div>
					</div>
				</div>
				<div class="col-6 pull-left pt-15">
					<div class="col-4 pull-left pd-0">
						<label class="inline-block ipt-label">
							<em class="col-red">*&nbsp;</em>
							办公人数:
						</label>
					</div>
					<div class="col-8 pull-left pd-0">
						<div class="clear">
							<input type="text" class="ipt-text mb-10" placeholder="" name="i.employees" value="${comp[0].employees }">
						</div>
					</div>
				</div>
			</div>
			<!-- 入驻类型 -->
				<div class="col-6 pull-left pt-15">
					<div class="col-4 pull-left pl-0 pr-0">
						<label class="inline-block ipt-label">
							<em class="col-red">*&nbsp;</em>
							入驻类型:
						</label>
					</div>
					<div class="col-8 pull-left ipt-label">
						<c:if test="${comp[0].type_of_entity=='0' || comp[0].type_of_entity==null}">
						 	<label class="mr-20"><input name="i.type_of_entity" type="radio" checked="checked" value="0"/>新设 </label> 
							<label class="ml-20"><input name="i.type_of_entity" type="radio"  value="1" />迁址 </label>
						</c:if>
						<c:if test="${comp[0].type_of_entity=='1' }">
						 	<label class="mr-20"><input name="i.type_of_entity" type="radio"  value="0"/>新设 </label> 
							<label class="ml-20"><input name="i.type_of_entity" type="radio"  checked="checked" value="1" />迁址 </label>
						</c:if>
						
					</div>
				</div>
			<!-- 入驻类型END -->
			<!-- 基金种类 -->
				<div class="col-12 pull-left pt-15">
					<div class="col-2 pull-left pd-0">
						<label class="inline-block ipt-label">
							<em class="col-red">*&nbsp;</em>
							基金种类:
						</label>
					</div>
					<div class="col-10 pull-left pl-0 pr-15">
						<c:if test="${comp[0].fund_type=='0' || comp[0].fund_type==null}">
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input checked="checked"  class="infse" name="i.fund_type" type="radio" value="0" />私募创业投资</label>
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input  class="infse" name="i.fund_type" type="radio" value="1" />股权投资</label> 
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input class="infse" name="i.fund_type" type="radio" value="2" />私募证券投资 </label>
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input class="infseo infse" name="i.fund_type" type="radio" value="3" />其他 </label> 
							</div>
						</c:if>
						<c:if test="${comp[0].fund_type=='1' }">
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input  class="infse" name="i.fund_type" type="radio" value="0" />私募创业投资</label>
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input checked="checked" class="infse" name="i.fund_type" type="radio" value="1" />股权投资</label> 
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input class="infse" name="i.fund_type" type="radio" value="2" />私募证券投资 </label>
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input class="infseo infse" name="i.fund_type" type="radio" value="3" />其他 </label> 
							</div>
						</c:if>
						<c:if test="${comp[0].fund_type=='2' }">
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input  class="infse" name="i.fund_type" type="radio" value="0" />私募创业投资</label>
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input class="infse" name="i.fund_type" type="radio" value="1" />股权投资</label> 
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input checked="checked" class="infse" name="i.fund_type" type="radio" value="2" />私募证券投资 </label>
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input class="infseo infse" name="i.fund_type" type="radio" value="3" />其他 </label> 
							</div>
						</c:if>
						<c:if test="${comp[0].fund_type=='3' }">
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input  class="infse" name="i.fund_type" type="radio" value="0" />私募创业投资</label>
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input class="infse" name="i.fund_type" type="radio" value="1" />股权投资</label> 
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input class="infse" name="i.fund_type" type="radio" value="2" />私募证券投资 </label>
							</div>
							<div class="col-3 pull-left ipt-label">
								<label class="mr-20"><input checked="checked" class="infseo infse" name="i.fund_type" type="radio" value="3" />其他 </label> 
							</div>
						</c:if>
					</div>
				</div>
			<!-- 基金种类END -->
			
			
			<!-- 基金管理公司 -->
				<div class="full-w pull-left pt-15">
					<div class="col-6 pull-left pt-15">
						<div class="col-4 pull-left pd-0">
							<label class="inline-block ipt-label">
								<em class="col-red">*&nbsp;</em>
								基金管理公司:
							</label>
						</div>
						<div class="col-8 pull-left pd-0">
							<div class="col-3 pull-left pd-0">
								<label class="inline-block ipt-label">
									注册资本:
								</label>
							</div>
							<div class="col-7 pull-left pd-0">
								<div class="clear">
									<input type="text" class="ipt-text mb-10" placeholder="" name="i.registecapital" value="${comp[0].registecapital }">
								</div>
							</div>
							<div class="col-2 pull-left pd-0">
								<label class="inline-block ipt-label">
									万元
								</label>
							</div>
						</div>
					</div>
					<div class="col-6 pull-left pt-15">
						<div class="col-3 pull-left pd-0">
							<label class="inline-block ipt-label">
								实缴资本:
							</label>
						</div>
						<div class="col-7 pull-left pd-0">
							<div class="clear">
								<input type="text" class="ipt-text mb-10" placeholder="" name="i.paidcapital" value="${comp[0].paidcapital }">
							</div>
						</div>
						<div class="col-2 pull-left pd-0">
							<label class="inline-block ipt-label">
								万元
							</label>
						</div>
					</div>
				</div>
			<!-- 基金管理公司END -->
			<!-- 发起基金 -->
				<div class="full-w pull-left pt-15">
					<div class="col-6 pull-left pt-15">
						<div class="col-4 pull-left pd-0">
							<label class="inline-block ipt-label">
								<em class="col-red">*&nbsp;</em>
								发起基金:
							</label>
						</div>
						<div class="col-8 pull-left pd-0">
							<div class="col-3 pull-left pd-0">
								<label class="inline-block ipt-label">
									管理规模:
								</label>
							</div>
							<div class="col-7 pull-left pd-0">
								<div class="clear">
									<input type="text" class="ipt-text mb-10" placeholder="" name="i.managescale" value="${comp[0].managescale }">
								</div>
							</div>
							<div class="col-2 pull-left pd-0">
								<label class="inline-block ipt-label">
									万元
								</label>
							</div>
						</div>
					</div>
					<div class="col-6 pull-left pt-15">
						<div class="col-3 pull-left pd-0">
							<label class="inline-block ipt-label">
								第一期到位:
							</label>
						</div>
						<div class="col-7 pull-left pd-0">
							<div class="clear">
								<input type="text" class="ipt-text mb-10" placeholder="" name="i.firstcapital" value="${comp[0].firstcapital }">
							</div>
						</div>
						<div class="col-2 pull-left pd-0">
							<label class="inline-block ipt-label">
								万元
							</label>
						</div>
					</div>
				</div>
			<!-- 发起基金END -->
			<div class="clear full-w pt-20">
				<div class="col-6 text-center pull-left pt-20">
					<div class="col-6 dis-ib">
						<button class="btn btn-small btn-primary full-w f-14" type="submit">
							提交
						</button>
					</div>
				</div>
				<div class="col-6 text-center pull-left">
					<div class="col-6 dis-ib pt-20">
						<button onclick="javascript:window.location.href='${pageContext.request.contextPath}/user/phintoPark.do'" class="btn btn-small btn-primary full-w f-14" type="button">
							取消
						</button>
					</div>
				</div>
			</div>
		</form>
		</div>
		</div>
		<!-- 内容结束 -->
		</div>

	</div>

	</div>
    <%@ include file="../comm/footer.jsp" %> 
    <%@ include file="../comm/js.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/user.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/user/upCompInfo.js"></script>
  </body>
  
</html>
