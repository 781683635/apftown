<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../comm/tag.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>完善公司信息-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    
<!-- ==========meta开始========== -->	
<!-- 清空浏览器本地缓存 -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
<!-- 本网页关键字和关键内容 -->
	<meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
<!-- 采用webkit内核(急速内核) -->
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
<!-- ==========meta结束========== -->
	<%@ include file="../../comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/swiper-3.3.1.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/m/mobile-apft.css">
	<style>
    	.scroll-wrapper {-webkit-overflow-scrolling: touch !important;overflow-y: scroll !important;} 
    </style>
  </head>
  
<body>
	<div class="clear">
	<!-- 填写公司信息 -->
	<div class="clear full-w bg_eaf8ff bor-b-434343">
		<p class="text-center pt-15 pb-15 f-26 col_00a5f7">
			<img class="dis-ib img-30 bg_00a0e6 radius-5 pd-5 mr-10" src="${pageContext.request.contextPath }/img/mobile/reg_f/succ_tips1.png" alt="">填写公司信息
		</p>
	</div>
	<!-- 填写公司信息END -->
		<form class="sky-form" action="" id="regFbainfoForm" name="regFbainfoForm">
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
	    
			<!-- 企业名称及入驻类型 -->
				<div class="col-12 pull-left pt-15">
					<div class="col-4 pull-left pl-0 pr-0 pt-5 pb-5">
						<label class="inline-block ipt-label pull-right">
							<em class="col-red">*&nbsp;</em>
							拟定企业名称:
						</label>
					</div>
					<div class="col-8 pull-left pd-0">
						<div class="clear">
							<input type="text" class="ipt-text f_text mb-10" placeholder="" name="i.company_name" value="${comp[0].company_name }">
						</div>
					</div>
				</div>
				<div class="col-12 pull-left pt-15">
					<div class="col-4 pull-left pl-0 pr-0 pt-5">
						<label class="inline-block ipt-label pull-right">
							<em class="col-red">*&nbsp;</em>
							入驻类型:
						</label>
					</div>
					<div class="col-8 pull-left pl-5 pr-0 pt-12">
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
			<!-- 企业名称及入驻类型END -->
			<!-- 基金种类 -->
				<div class="col-12 pull-left pt-15">
					<div class="col-4 pull-left pl-0 pr-0 pt-5">
						<label class="inline-block ipt-label pull-right">
							<em class="col-red">*&nbsp;</em>
							基金种类:
						</label>
					</div>
					<div class="col-8 pull-right pl-5 pr-0 pt-12">
					<c:if test="${comp[0].fund_type=='0' || comp[0].fund_type==null}">
							<label class="mr-20"><input checked="checked"  class="infse" name="i.fund_type" type="radio" value="0" />私募创业投资</label>
							<label class="mr-20"><input  class="infse" name="i.fund_type" type="radio" value="1" />股权投资</label> 
						</div>
						<div class="col-8 pull-right pl-5 pr-0 pt-12">
							<label class="mr-20"><input class="infse" name="i.fund_type" type="radio" value="2" />私募证券投资 </label>
							<label class="mr-20"><input class="infseo infse" name="i.fund_type" type="radio" value="3" />其他 </label>
						</div>
						<div class="col-8 pull-right pl-0 pr-0 mt-10 mb-10">
							<input type="text" class="ipt-text infsein dis-n" placeholder="">
						</div>
					</c:if>
					<c:if test="${comp[0].fund_type=='1' }">
							<label class="mr-20"><input   class="infse" name="i.fund_type" type="radio" value="0" />私募创业投资</label>
							<label class="mr-20"><input  class="infse" name="i.fund_type" type="radio" value="1" checked="checked"/>股权投资</label> 
						</div>
						<div class="col-8 pull-right pl-5 pr-0 pt-12">
							<label class="mr-20"><input class="infse" name="i.fund_type" type="radio" value="2" />私募证券投资 </label>
							<label class="mr-20"><input class="infseo infse" name="i.fund_type" type="radio" value="3" />其他 </label>
						</div>
						<div class="col-8 pull-right pl-0 pr-0 mt-10 mb-10">
							<input type="text" class="ipt-text infsein dis-n" placeholder="">
						</div>
					</c:if>
					<c:if test="${comp[0].fund_type=='2' }">
							<label class="mr-20"><input   class="infse" name="i.fund_type" type="radio" value="0" />私募创业投资</label>
							<label class="mr-20"><input  class="infse" name="i.fund_type" type="radio" value="1" />股权投资</label> 
						</div>
						<div class="col-8 pull-right pl-5 pr-0 pt-12">
							<label class="mr-20"><input class="infse" name="i.fund_type" type="radio" value="2" checked="checked"/>私募证券投资 </label>
							<label class="mr-20"><input class="infseo infse" name="i.fund_type" type="radio" value="3" />其他 </label>
						</div>
						<div class="col-8 pull-right pl-0 pr-0 mt-10 mb-10">
							<input type="text" class="ipt-text infsein dis-n" placeholder="">
						</div>
					</c:if>
					<c:if test="${comp[0].fund_type=='3' }">
							<label class="mr-20"><input checked="checked"  class="infse" name="i.fund_type" type="radio" value="0" />私募创业投资</label>
							<label class="mr-20"><input  class="infse" name="i.fund_type" type="radio" value="1" />股权投资</label> 
						</div>
						<div class="col-8 pull-right pl-5 pr-0 pt-12">
							<label class="mr-20"><input class="infse" name="i.fund_type" type="radio" value="2" />私募证券投资 </label>
							<label class="mr-20"><input class="infseo infse" name="i.fund_type" type="radio" value="3" checked="checked"/>其他 </label>
						</div>
						<div class="col-8 pull-right pl-0 pr-0 mt-10 mb-10">
							<input type="text" class="ipt-text infsein dis-n" placeholder="">
						</div>
					</c:if>
				</div>
			<!-- 基金种类END -->
			<!-- 办公地址及人数 -->
				<div class="col-12 pull-left pt-15">
					<div class="col-4 pull-left pl-0 pr-0 pt-5 pb-5">
						<label class="inline-block ipt-label pull-right">
							<em class="col-red">*&nbsp;</em>
							实际办公地址:
						</label>
					</div>
					<div class="col-8 pull-left pd-0">
						<div class="clear">
							<input type="text" class="ipt-text mb-10 f_text" placeholder="" name="i.office_address" value="${comp[0].office_address }">
						</div>
					</div>
				</div>
				<div class="col-12 pull-left pt-15">
					<div class="col-4 pull-left pl-0 pr-0 pt-5 pb-5">
						<label class="inline-block ipt-label pull-right">
							<em class="col-red">*&nbsp;</em>
							全职办公人数:
						</label>
					</div>
					<div class="col-8 pull-left pd-0">
						<div class="clear">
							<input type="text" class="ipt-text mb-10 f_text" placeholder="" name="i.employees" value="${comp[0].employees }">
						</div>
					</div>
				</div>
			<!-- 办公地址及人数END -->
			<!-- 邮编 -->
				<div class="col-12 pull-left pt-15">
					<div class="col-4 pull-left pl-0 pr-0 pt-5 pb-5">
						<label class="inline-block ipt-label pull-right">
							<em class="col-red">*&nbsp;</em>
							邮编:
						</label>
					</div>
					<div class="col-8 pull-left pd-0">
						<div class="clear">
							<input type="text" class="ipt-text mb-10 f_text" placeholder="" name="i.zipcode" value="${comp[0].zipcode }">
						</div>
					</div>
				</div>
			<!-- 邮编END -->
			<!-- 基金管理公司 -->
				<div class="col-12 pull-left pt-15">
					<div class="col-12 pull-left pl-0 pr-0">
						<div class="col-4 pull-left pl-0 pr-0 pt-5 pb-5">
							<label class="inline-block ipt-label pull-right">
								<em class="col-red">*&nbsp;</em>
								基金管理公司:
							</label>
						</div>
						<div class="col-3 pull-left pl-0 pr-0 pt-5 pb-5">
							<label class="inline-block pull-right pt-10 pr-10">
								注册资本:
							</label>
						</div>
						<div class="col-3 pull-left pd-0">
							<div class="clear">
								<input type="text" class="ipt-text bor-tlr-none text-center f_text" placeholder="" name="i.registecapital" value="${comp[0].registecapital }">
							</div>
						</div>
						<div class="col-2 pull-left pl-0 pr-0 pt-5 pb-5">
							<label class="inline-block ipt-label">
								万元
							</label>
						</div>
					</div>
					<div class="col-12 pull-right pl-0 pr-0 mt-10">
						<div class="col-3 col-offset-4 pull-left pl-0 pr-0 pt-5 pb-5">
							<label class="inline-block pull-right pt-10 pr-10">
								实缴资本:
							</label>
						</div>
						<div class="col-3 pull-left pd-0">
							<div class="clear">
								<input type="text" class="ipt-text bor-tlr-none text-center f_text" placeholder="" name="i.paidcapital" value="${comp[0].paidcapital }">
							</div>
						</div>
						<div class="col-2 pull-left pl-0 pr-0 pt-5 pb-5">
							<label class="inline-block ipt-label">
								万元
							</label>
						</div>
					</div>
				</div>
			<!-- 基金管理公司END -->
			<!-- 发起基金 -->
				<div class="col-12 pull-left pt-15 mb-20">
					<div class="col-12 pull-left pl-0 pr-0">
						<div class="col-4 pull-left pl-0 pr-0 pt-5 pb-5">
							<label class="inline-block ipt-label pull-right">
								<em class="col-red">*&nbsp;</em>
								发起基金:
							</label>
						</div>
						<div class="col-3 pull-left pl-0 pr-0 pt-5 pb-5">
							<label class="inline-block pull-right pt-10 pr-10">
								管理规模:
							</label>
						</div>
						<div class="col-3 pull-left pd-0">
							<div class="clear">
								<input type="text" class="ipt-text bor-tlr-none text-center f_text" placeholder="" name="i.managescale" value="${comp[0].managescale }">
							</div>
						</div>
						<div class="col-2 pull-left pl-0 pr-0 pt-5 pb-5">
							<label class="inline-block ipt-label">
								万元
							</label>
						</div>
					</div>
					<div class="col-12 pull-right pl-0 pr-0 mt-10">
						<div class="col-3 col-offset-4 pull-left pl-0 pr-0 pt-5 pb-5">
							<label class="inline-block pull-right pt-10 pr-10">
								第一期到位:
							</label>
						</div>
						<div class="col-3 pull-left pd-0">
							<div class="clear">
								<input type="text" class="ipt-text bor-tlr-none text-center f_text" placeholder="" name="i.firstcapital" value="${comp[0].firstcapital }">
							</div>
						</div>
						<div class="col-2 pull-left pl-0 pr-0 pt-5 pb-5">
							<label class="inline-block ipt-label">
								万元
							</label>
						</div>
					</div>
				</div>
			<!-- 发起基金 -->
			<!-- 完善负责人信息 -->
				<div class="full-w clear mb-10 mt-20 clear pl-15 pr-15">
					<div class="col-12 pull-left mb-10">
						<button type="submit" class="btn radius0 btn-primary full-w radius-10 size-large f-20">
							完善负责人信息<span class="dis-ib pull-right pr-15 icon-angle-right f-20 col-white pos-t-2 pos-r"></span><span class="dis-ib pull-right pr-5 icon-angle-right f-20 col-white pos-t-2 pos-r"></span>
						</button>
					</div>
					<div class="col-12 pull-left mb-10">
						<button type="button" class="btn bor-ccc bor-col-pri col_00a5f7 radius0 full-w radius-10 size-large f-20 tab1">
							查看完整入园表
						</button>
					</div>
				</div>
			<!-- 完善负责人信息END -->
		</form>
	</div>
	<%@ include file="../../comm/js.jsp" %>
	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/swiper-3.3.1.jquery.min.js"></script> 
	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/m/reg/regFbainfo2.js"></script> 
<!-- base的js文件 -->
	<script>
		$(document).ready(function(){
		    $(".infse").click(function(){
		  	  var s=$(".infseo:checked").val();
		  	   if(s==""){
	                $(".infsein").show();
	            }
	            else{
	               $(".infsein").hide();
	            }
		  });
		});
		$('.tab1').on('click', function(){
			layer.open({
				type: 2,
				title: '完整入园表',
				maxmin: true,
				shadeClose: false, //点击遮罩关闭层
				area : ['90%' , '90%'],
				content: 'regFtabinpark.do',
				success: function(layero){
	               $(layero).addClass("scroll-wrapper");//苹果 iframe 滚动条失效解决方式
	            }
			});
		});
	</script>
</body>
</html>
