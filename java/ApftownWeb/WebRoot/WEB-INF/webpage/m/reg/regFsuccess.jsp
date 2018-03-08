<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../comm/tag.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册成功-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    
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
    <%@ include file="../../comm/css.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/comm/swiper-3.3.1.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/m/mobile-apft.css">
    <style>
    	.scroll-wrapper {-webkit-overflow-scrolling: touch !important;overflow-y: scroll !important;} 
    </style>
</head> 
<body>
	<div class="wrap clear bg_eaf8ff">
	<!-- 注册成功 -->
		<div class="clear full-w pt-20 pb-20 pl-15 pr-15 bg-white">
			<img class="w-20s pull-left" src="${pageContext.request.contextPath }/img/mobile/reg_f/logo_apft.png" alt="亚太金融小镇logo">
		</div>
		<div class="clear full-w pt-10 pb-20 pl-15 pr-15 text-center line-h-30 bg-white">
			<img class="img-30 dis-ib pos-r pos-t-4l" src="${pageContext.request.contextPath }/img/mobile/reg_f/f_true.png" alt="亚太金融小镇logo">
			<span class="f-20 col_22ac38 pl-10 pr-10">
				恭喜您，注册成功!
			</span>
		</div>
		<div class="clear">
			<img class="full-w pt-10 bg-white" src="${pageContext.request.contextPath }/img/mobile/reg_f/policybg.jpg" alt="">
		</div>
		<div class="clear full-w bor-b-white">
			<div class="col-4 pull-left bor-r-white pd-20 tab1">
				<div class="clear weqh bg_00b0ec bgh_red full-radius">
					<img class="pd-15" src="${pageContext.request.contextPath }/img/mobile/reg_f/succ_tips1.png" alt="">
				</div>
				<p class="text-center pt-10 f-14 col-333">
					公司税收减免
				</p>
			</div>
			<div class="col-4 pull-left bor-r-white pd-20 tab2">
				<div class="clear weqh bg_00a4b4 bgh_red full-radius">
					<img class="pd-15" src="${pageContext.request.contextPath }/img/mobile/reg_f/succ_tips2.png" alt="">
				</div>
				<p class="text-center pt-10 f-14 col-333">
					个人税收
				</p>
			</div>
			<div class="col-4 pull-left bor-r-white pd-20 tab3">
				<div class="clear weqh bg_aacd06 bgh_red full-radius">
					<img class="pd-15" src="${pageContext.request.contextPath }/img/mobile/reg_f/succ_tips3.png" alt="">
				</div>
				<p class="text-center pt-10 f-14 col-333">
					人才一站式服务
				</p>
			</div>
		</div>
		<div class="clear full-w">
			<div class="col-4 pull-left bor-r-white pd-20 tab4">
				<div class="clear weqh bg_f17c00 bgh_red full-radius">
					<img class="pd-15" src="${pageContext.request.contextPath }/img/mobile/reg_f/succ_tips4.png" alt="">
				</div>
				<p class="text-center pt-10 f-14 col-333">
					房屋优惠
				</p>
			</div>
			<div class="col-4 pull-left bor-r-white pd-20 tab5">
				<div class="clear weqh bg_e95098 bgh_red full-radius">
					<img class="pd-15" src="${pageContext.request.contextPath }/img/mobile/reg_f/succ_tips5.png" alt="">
				</div>
				<p class="text-center pt-10 f-14 col-333">
					住宿服务
				</p>
			</div>
			<div class="col-4 pull-left pd-20 tab6">
				<div class="clear weqh bg_7d4698 bgh_red full-radius">
					<img class="pd-15" src="${pageContext.request.contextPath }/img/mobile/reg_f/succ_tips6.png" alt="">
				</div>
				<p class="text-center pt-10 f-14 col-333">
					接送服务
				</p>
			</div>
		</div>
	<!-- 注册成功END -->
	<!-- 完善公司信息 -->
	<div class="full-w clear mt-20 mb-20 f-16">
		<div class="col-12 pull-left mb-10">
			<button type="button" class="btn radius0 btn-primary full-w radius-10 size-large f-20" onclick="javascript:window.location.href='${pageContext.request.contextPath}/user/regFbainfo2.do'">
				完善公司信息<span class="dis-ib pull-right pr-15 icon-angle-right f-20 col-white pos-t-2 pos-r"></span><span class="dis-ib pull-right pr-5 icon-angle-right f-20 col-white pos-t-2 pos-r"></span>
			</button>
		</div>
		<div class="col-12 pull-left mb-10">
			<button type="button" class="btn bor-ccc bor-col-pri col_00a5f7 radius0 full-w radius-10 size-large f-20 tab7">
				查看详细政策文件
			</button>
		</div>
	</div>
	<!-- 完善公司信息END -->
<!-- jquery文件 -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/ctrl/layer/layer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/mining.js"></script>
	<script>
		$('.tab1').on('click', function(){
		  layer.open({
			  title: '公司税收',
			  area: '80%',
			  content: '<p>各类投资基金及管理企业缴交的增值税及企业所得税属三亚市地方分享部分，自认定当年起按前三年100%，后七年60%给予奖励。</p>'
			});
		});
		$('.tab2').on('click', function(){
		  layer.open({
			  title: '个人税收',
			  area: '80%',
			  content: '<p>对各类投资基金及管理企业中层以上管理人员给予个人所得税优惠，自认定当年起十年内按其缴纳个人工薪收入所得税三亚市地方分享部分的70%给予奖励。</p>'
			});
		});
		$('.tab3').on('click', function(){
		  layer.open({
			  title: '人才一站式服务',
			  area: '80%',
			  content: '<p>各类投资基金及管理企业享受三亚市相关人才服务政策包括高端人才落户、医疗、子女教育、人事档案管理、职称评定、社会保障等，市政务中心及各办事大厅实行“一站式服务”。</p>'
			});
		});
		$('.tab4').on('click', function(){
		  layer.open({
			  title: '房屋优惠',
			  area: '80%',
			  content: '<p class="f-16 f-w">小镇为入住投资及基金等公司，提供五年房屋免租：</p><p><span class="f-14 f-w">标准化：</span>小镇提供给每个入驻公司30平方米的五年免租面积，同意配置办公家具。</p><p><span class="f-14 f-w">定制化：</span>小镇根据每个公司的实际需要，共同确认相应的面积，由企业自行安装装修事宜。</p>'
			});
		});
		$('.tab5').on('click', function(){
		  layer.open({
			  title: '住宿服务',
			  area: '80%',
			  content: '<p class="f-16 f-w">小镇自为入驻公司，提供相关住宿服务如下：</p><p><span class="f-14 f-w">小镇公寓：</span>小镇自有100间精品客房，针对入驻企业提供9折优惠；</p><p><span class="f-14 f-w">海棠湾酒店：</span>海棠湾酒店入住，享受小镇与各酒店的协议价（具体以小镇和各酒店协商价格为准）</p><p><span class="f-14 f-w">海棠湾居民：</span>小镇周边民居，小镇免费为入驻公司联系长租服务。</p>'
			});
		});
		$('.tab6').on('click', function(){
		  layer.open({
			  title: '接送服务',
			  area: '80%',
			  content: '<p>对于入驻公司，小镇免费提供每季度一次的接送服务。</p>'
			});
		});
		$('.tab7').on('click', function(){
			layer.open({
				type: 2,
				title: '政策文件',
				maxmin: true,
				shadeClose: false, //点击遮罩关闭层
				area : ['90%' , '90%'],
				content: 'regFpolicy.do',
				success: function(layero){
	               $(layero).addClass("scroll-wrapper");//苹果 iframe 滚动条失效解决方式
	            }
			});
		});
	</script>

</body>
</html>
