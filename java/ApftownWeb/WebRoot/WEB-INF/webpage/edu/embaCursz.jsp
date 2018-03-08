<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../comm/tag.jsp" %>
<%String embaType = "1.2"; %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>课程体系-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
	<meta name="keywords" content="中美,EMBA,课程,金融高级研修班,培训,基金国际班,私募国际班,国际基金培训,亚太EMBA,亚太金融,中美EMBA,金融培训,基金培训,亚太金融（基金）小镇" />
    <meta name="description" content="中美合作,创新金融,基金交流,共享财富,亚太金融研究院联合美国德克萨斯阿灵顿商学院首创亚太金融EMBA项目, 培养世界级创新金融企业家！" />
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/swiper-3.3.1.min.css">
	<%@ include file="../comm/css.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/pagination.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/apft.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/emba.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors/colors.css">

  </head>
  
  <body>
	<div class="wrap emba">
    <%@ include file="../comm/header.jsp" %> 
  	<%@ include file="./embaHead.jsp" %>
  	<!-- 内容开始 -->
	<div class="container1 clear">
	    <div class="row1">
	        <div class="bg-bg5 text-center pd-20">
				<p class="col-d-blue f-18 f-w">
					课程体系
				</p>
			</div>
			<div class="bg-t-blue clear">
				<div class="col-md-3 col-sm-3 col-xs-2 text-center pt-20 clear pl-0 pr-0"> 
	    			<p class="netp f-w col-white mt-70 pull-right ml-10 mr-20">
    					实战课程
    				</p>
    				<img class="netb ani ani2-3 pull-right img-35 mt-70" src="<%=path %>/img/edu-emba/cous.png" alt="亚太金融EMBA">
	    		</div>
	    		<div class="col-md-9 col-sm-9 col-xs-10 pd-0">
	    		    <div class="col-md-6 col-sm-6 col-xs-12 pd-0">
						<div class="nwbc bg-ddd mt-10 mb-10 pull-left clear pl-15">
			    			<div class="coun bg-red full-radius img-80 pull-left text-center">
						        <p class="col-white pd-10 f-16 mt-20">中国</p>
						    </div>
		                    <div class="conte pull-left">
				    			<p class="seam col-red f-16 pb-10 bor-b-red f-w">
			    					证券基金与建模
			    				</p>
			    				<p class="seam col-red f-16 pt-10 f-w">
			    					产业基金与并购
			    				</p>
		    				</div>
		    			</div>				    
		    		</div>
	    		    <div class="col-md-6 col-sm-6 col-xs-12 pd-0">
						<div class="nwbc bg-ddd mt-10 mb-10 pull-left clear pl-15">
						    <div class="coun bg-d-blue full-radius img-80 pull-left text-center mt-20 mb-20">
						        <p class="col-white pd-10 f-16 mt-20">美国</p>
						    </div>
		                    <div class="conte pull-left mb-20">
				    			<p class="seam col-d-blue f-16 pb-10 bor-d-blue f-w">
			    					风险基金与估值
			    				</p>
			    				<p class="seam col-d-blue f-16 pt-10 f-w">
			    					对冲基金与监管
			    				</p>
		    				</div>				    
			    		</div>
		    		</div>
	    		</div>
			</div>
			<div class="bg-d-blue clear mb-20 mt-15 pt-15 pl-0 pr-0">
			    <div class="col-md-3 col-sm-3 col-xs-2 text-center pt-10 pd-0">
	    			<p class="netp f-w col-white pull-right mr-20 ml-10">
    					基础课程
    				</p>
    				<img class="netb ani ani2-3 pull-right img-35" src="<%=path %>/img/edu-emba/cous.png" alt="亚太金融EMBA">
	    		</div>
	    		<div class="netn bg-white col-md-2 col-sm-2 col-xs-4 mr-15 pull-left clear radius-10">
                    <div class="ani ani2-3 text-center mt-20 mb-20">
		    			<p class="col-d-blue f-14 f-w">
	    					基础知识
	    				</p>
    				</div>				    
	    		</div>	
	    		<div class="netn bg-white col-md-2 col-sm-2 col-xs-4 mr-15 pull-left clear radius-10">
                    <div class="ani ani2-3 text-center mt-20 mb-20">
		    			<p class="col-d-blue f-14 f-w">
	    					中国基金业
	    				</p>
    				</div>				    
	    		</div>	
	    		<div class="netn bg-white col-md-2 col-sm-2 col-xs-4 mr-15 pull-left clear radius-10 pd-0">
                    <div class="ani ani2-3 text-center mt-20 mb-20">
		    			<p class="col-d-blue f-14 f-w">
	    					基金服务体系
	    				</p>
    				</div>				    
	    		</div>			
			    <div class="netn bg-white col-md-2 col-sm-2 col-xs-4 mr-15 pull-left clear radius-10">
                    <div class="ani ani2-3 text-center mt-20 mb-20">
		    			<p class="col-d-blue f-14 f-w">
	    					全球化基金
	    				</p>
    				</div>				    
	    		</div>			
			</div>


			<div class="tab-v3" id="tab_demo3">
                <div class="tabbar clear"> 
				    <div class="coua col-md-2 col-sm-3 col-sm-offset-2 current bor-blue pd-0 mb-10">
					    <p class="ppa ml-43 ani ani2-3 col-white pt-35 f-16 f-w h-25 line-h-25 bg-d-blue full-radius img-100 mt-40 pl-20">课程安排</p>
					    <p class="col-d-blue ml-50 pt-20 mt-20">点击查看详情<span class="col-d-blue f-12 pull-right">>></span><span class="pull-right col-d-blue f-12">more</span></p>
				    </div>
					<div class="col-md-2 col-sm-3 bor-blue col-md-offset-1 col-sm-offset-2 pd-0 mb-10">
					    <p class="ppa ml-43 ani ani2-3 col-white pt-35 f-16 f-w h-25 line-h-25 bg-d-blue full-radius img-100 mt-40 pl-20">学习模式</p>
					    <p class="col-d-blue ml-50 pt-20 mt-20">点击查看详情<span class="col-d-blue f-12 pull-right">>></span><span class="pull-right col-d-blue f-12">more</span></p>
				    </div>
				    <div class="col-md-2 col-sm-3 bor-blue col-md-offset-1 col-sm-offset-2 pd-0 mb-10">
					    <p class="ppa ml-43 ani ani2-3 col-white pt-35 f-16 f-w h-25 line-h-25 bg-d-blue full-radius img-100 mt-40 pl-20">学位认证</p>
					    <p class="col-d-blue ml-50 pt-20 mt-20">点击查看详情<span class="col-d-blue f-12 pull-right">>></span><span class="pull-right col-d-blue f-12">more</span></p>
				    </div>
				    <div class="col-md-2 col-sm-3 bor-blue col-md-offset-1 col-sm-offset-2 pd-0 mb-10">
					    <p class="ppa ml-43 ani ani2-3 col-white pt-35 f-16 f-w h-25 line-h-25 bg-d-blue full-radius img-100 mt-40 pl-20">课程设置</p>
					    <p class="col-d-blue ml-50 pt-20 mt-20">点击查看详情<span class="col-d-blue f-12 pull-right">>></span><span class="pull-right col-d-blue f-12">more</span></p>
				    </div>
				</div>
				<!-- 课程安排开始 -->
				<div class="tabcon clear"> 
			        <div class="bg-d-blue radius-10 mt-10 mb-20">
						<p class="col-white f-18 f-w pl-15 pt-10 pb-10">
							课程安排
						</p>
					</div>
					<div class="clear mt-20">
						<div class="div1 col-md-6 col-sm-6 pb-20 pl-20 pr-20">
			    			 <img class="pd-20 img1" src="<%=path %>/img/edu-emba/coua.png" alt="亚太金融EMBA">
			    		</div>
						<div class="ani ani2-4 col-sm-6 col-md-6 col-xs-12 line-h-35 pb-20">
						    <p class="f-w col-d-blue f-26 pt-20 let-spa-2">
		    					亚太金融EMBA采用中英双语授课
		    				</p>
		    				<p class="f-w col-d-blue f-16 pt-10 let-spa-1">
		    					(英文授课配备翻译)
		    				</p>
		                    <p class="line-h-25 pt-15 pl-10">
								学制为在职一年半，共计12门课程
							</p>
							<p class="line-h-25 pl-10">
								通过两地访学，五项修炼
							</p>
							<p class="line-h-25 pb-10 bor-b-ccc pl-10">
								培养具有国际视野的金融EMBA
							</p>
							<div class="clear">
							    <div class="bg-red col-md-2 col-sm-3 radius-10 mt-20 text-center">
					    			<span class="col-white f-14">
				    					国内课程
				    				</span>
			    				</div>
			    				<div class="col-md-9 col-sm-9">
				    				<p class="f-w col-red pt-20">
				    					10门课程，通用课程5门，专业课程5门
				    				</p>
			    				</div>
							</div>
							<div class="clear">
							    <div class="bg-red col-md-2 col-sm-3 radius-10 mt-20 text-center">
					    			<span class="col-white f-14">
				    					海外课程
				    				</span>
			    				</div>
			    				<div class="col-md-9 col-sm-9">
				    				<p class="f-w col-red pt-20">
				    					2门（美国纽约、美国硅谷）
				    				</p>
			    				</div>
							</div>
							<div class="clear">
							    <div class="bg-red col-md-2 col-sm-3 radius-10 mt-15 text-center">
					    			<span class="col-white f-14">
				    					学时总计
				    				</span>
			    				</div>
			    				<div class="col-md-9 col-sm-9">
				    				<p class="f-w col-red pt-20">
				    					共8次课程，共计48天
				    				</p>
			    				</div>
							</div>
			    		</div>
		    		</div>
				</div>
				<!-- 课程安排结束 -->											
                <!-- 学习模式开始 -->
                <div class="tabcon clear pt-10"> 
			        <div class="bg-d-blue radius-10 mb-20">
						<p class="col-white f-18 f-w pl-15 pt-10 pb-10">
							学习模式
						</p>
					</div>
		            <div class="clear mt-20 bg-gray">
						<div class="col-md-4 col-sm-4">
			    		    <div class="pb-20 text-center">
				    			<img class="div1 pd-20 img5" src="<%=path %>/img/edu-emba/newy.png" alt="亚太金融EMBA">
				    			<p class="line-h-20">
									美国纽约
								</p>
								<p class="line-h-20 pb-10">
									NEW YORK
								</p>
							</div>
			    		</div>
			    		<div class="col-md-4 col-sm-4">
			    		    <div class="pb-20 text-center">
				    			<img class="div1 pd-20 img5" src="<%=path %>/img/edu-emba/silv.png" alt="亚太金融EMBA">
				    			<p class="line-h-20">
									美国硅谷
								</p>
								<p class="line-h-20 pb-10">
									SILICON VALLEY
								</p>
							</div>
			    		</div>
						<div class="col-md-4 col-sm-4 pb-10">
				            <div class="bg-white line-h-35 pd-15 mt-20 mb-20 radius-5">
				                <div class="div2 pt-20 pb-20 pl-10 pr-10">
								    <div class="text-center">
									    <p class="tfp f-w pt-5">
					    					 两地访学+五项修炼
					    				</p>
				    				</div>
									<p class="tfpl pb-10 col-d-blue pt-10 f-13">
										此EMBA教育将摆脱传统教育模式，不仅传授全球领先的金融投资知识，而且开展国内外鲜活的实战训练
									</p>
									<p class="tfpl">
										通过纽约与硅谷两种基金模式的学习，掌握对冲基金与风险基金的实战投资技巧，理解全球投资基金行业的架构，在每个模块中，通过五项修炼提高学生的国内外投资基金实战能力，成为行业中富有竞争意识和创新精神的产业领袖。
									</p>
								</div>
							</div>
			    		</div>
		    		</div>
		    		<div class="clear bg-gray pd-20 bor-ccc bor-l-none bor-r-none bor-b-none">
						<div class="col-md-4 col-sm-4 pb-20 text-center pt-5">
			    			<img class="pd-20 img2" src="<%=path %>/img/edu-emba/tfdi.png" alt="亚太金融EMBA">
			    		</div>
						<div class="col-md-7 col-sm-7 line-h-35 pd-20 mb-20">
						    <p class="f-w tfp col-red">
		    					5项修炼
		    				</p>
		    				<p class="f-w tfp pb-5 col-red">
		    					学习+考察+交流+对话+团队
		    				</p>
		    				<div class="bg-white mt-20 pd-20 radius-5">
								<p class="div2 prap">
									<span class="f-w">学习：</span><span>学习EMBA各模块课程</span>
								</p>
								<p class="div2 prap">
									<span class="f-w">考察：</span><span>考察美国资本市场（交易所）及基金小镇</span>
								</p>
								<p class="div2 prap">
									<span class="f-w">交流：</span><span>与基金相关机构（银行、保险）及中介机构（券商、律师、会计师等）交流</span>
								</p>
								<p class="div2 prap">
									<span class="f-w">对话：</span><span>与美国金融巨擘及基金领袖对话</span>
								</p>
								<p class="div2 prap">
									<span class="f-w">团队：</span><span>各模块开展团队学习，汇报研讨心得并进行团队论文评比</span>
								</p>
							</div>
			    		</div>
		    		</div>
		    		<div class="clear bg-gray pd-20 mb-70">
					    <p class="f-w tfp col-red text-ind">
							实地考察
						</p>
						<div class="col-md-5 col-sm-5 grep bg-white mt-20 pd-20 clear mb-20 mr-10 radius-5">
						    <div class="div1 col-md-4 col-sm-4 pt-10">
						        <img class="img3" src="<%=path %>/img/edu-emba/grew.png" alt="亚太金融EMBA">
						    </div>
						    <div class="div2 col-md-8 col-sm-8">
								<p class="line-h-20  col-black pt-10 f-w">
									格林威治（对冲基金游学）
								</p>
								<p class="line-h-20 pb-10 col-black">
									格林威治小镇离纽约州60公里，格林威治在纽约和伦敦之后，是全球第三大资产管理规模小镇，小镇汇聚了一半以上的美国对冲基金，集中500多家对冲基金，仅Bridge Water一家就控制着1500亿美元的资金规模。
								</p>
						    </div>
						</div>
						<div class="col-md-5 col-sm-5 bg-white mt-20 pd-20 clear ml-20 mb-20 radius-5">
						    <div class="div1 col-md-4 col-sm-4 pt-15 pb-15">
						        <img class="img4" src="<%=path %>/img/edu-emba/sahr.jpg" alt="亚太金融EMBA">
						    </div>
						    <div class="div2 col-md-8 col-sm-8">
								<p class="line-h-20 col-black pt-10 f-w">
									沙丘路（VC基金游学）
								</p>
								<p class="line-h-20 pb-10 col-black">
									“沙丘路”（Sand Hill Road）是全球风险投资基金的聚集地，位于斯坦福大学北边，虽然只有两三公里长，却汇聚了上百家著名的风险投资公司，在纳斯达克上市的科技公司有一半由这些公司投资。
								</p>
						    </div>
						</div>
		    		</div> 
				</div>
				<!-- 学习模式结束 -->
				<!-- 学位认证开始 -->
				<div class="tabcon clear pt-10"> 
			       <div class="bg-d-blue radius-10 mb-20">
						<p class="col-white f-18 f-w pl-15 pt-10 pb-10">
							学位认证
						</p>
					</div>
		    		<div class="bg-gray clear mb-20 mb-70">
						<div class="cesa col-md-5 col-sm-5 pt-20 pb-20 pl-20 text-center mr-10">
			    			 <img class="div1" src="<%=path %>/img/edu-emba/dipl.jpg" alt="亚太金融EMBA">
			    			 <p class="f-14 line-h-20 pl-10 f-w col-d-blue pt-10">
								金融EMBA学位证书样本
							</p>
			    		</div>
						<div class="degc col-sm-6 col-md-6 col-xs-11 bg-white mt-20 mb-20 radius-5">
						    <ul class="div2 pt-20 pb-20 pl-20">
								<li class="lisp1 col-d-blue">
									• <span>UTA 被权威评审机构卡内基基金会评为115 所全美最顶尖的研究型大学之一(2016 年），级别R-1，与哈佛大学、麻省理工等校属于同一级别。</span>
								</li>
		                        <li class="lisp2 col-d-blue">
									• <span>UTA 商学院排名在世界前80 名</span>
								</li>
								<li class="lisp2 col-d-blue">
									• <span>UTA 在U.S. News & World Report 全球排名中位列世界427 名</span>
								</li>
								<li class="lisp2 col-d-blue">
									• <span>UTA MBA 项目在U.S. New & World Report 排名全美82 名，全美公立大学MBA 排名前50 名</span>
								</li>
								<li class="lisp2 col-d-blue pb-5">
									• <span>UTA 获国际商业教育协会AACSB 认证（此认证全球通过率仅4%。哈佛、耶鲁等常青藤名校均获得此项认证）</span>
								</li>
							</ul>
			    		</div>
		    		</div>						       
				</div>
				<!-- 学位认证结束 -->
				<!-- 课程设置开始 -->
				<div class="tabcon clear pt-10"> 
			        <div class="bg-d-blue radius-10 mb-20">
						<p class="col-white f-18 f-w pl-15 pt-10 pb-10">
							课程设置
						</p>
					</div>
					<img class="mt-10" src="<%=path %>/img/edu-emba/couo.jpg" alt="亚太金融EMBA">
					<img class="mt-20 mb-70" src="<%=path %>/img/edu-emba/cout.jpg" alt="亚太金融EMBA">
				</div>
				<!-- 课程设置结束 -->
			</div> 
		</div> 
	</div>  
  	<!-- 内容结束 --> 
  	<!-- 浮动开始 -->
  	<%@ include file="./embaRight.jsp" %>
  	<!-- 浮动结束-->
		
	</div> 
	<%@ include file="../comm/footer.jsp"%>
    <%@ include file="../comm/js.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/jquery.form.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/swiper-3.3.1.jquery.min.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/edu/emba.js"></script>
		
  </body>
</html>
