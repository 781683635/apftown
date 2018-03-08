<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>






<footer class="footer">
	<% if(s_oem.isMobile()){ %>
		<div class="bg-black2 text-center pd-5 t-none"><p class=" col-ccc line-h-20">三亚清蓝亚太贸易有限公司&nbsp;&nbsp;|&nbsp;&nbsp;<a class="hov-pri" href="">京ICP证150482</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a class="hov-pri" href="">京公网安备11010502027200</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a class="hov-pri" href="">京ICP备14044935号-2</a> </p>
		</div>	
	<% } else { %>
		<div class="bg-black2 hidden-xs">
			<div class="container1 clear">
				<div class="row1 clear">
					<div class="col-sm-4">
						<h3 class="f-16 pt-10 pb-10 col-white">友情链接</h3>
						<div class="bor-ccc"></div>
						<ul class="line-h-15 t-none hov-pri pt-10">	
							<li class="clear">
								<div class="clear">
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo1"></i><span class="pull-left pt-5 pl-5 col-white">山东黄金</span></a>
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo2"></i><span class="pull-left pt-5 pl-5 col-white">山东招金</span></a>
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo4"></i><span class="pull-left pt-5 pl-5 col-white">万宝矿产</span></a>
	   								<!-- <a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo24"></i><span class="pull-left pt-5 pl-5 col-white">吉顺矿业</span></a> -->
								</div>	
							</li>
							<li class="clear pt-5">    
								<div class="clear">
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo5"></i><span class="pull-left pt-5 pl-5 col-white">紫金矿业</span></a>
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo6"></i><span class="pull-left pt-5 pl-5 col-white">中铁资源</span></a>
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo7"></i><span class="pull-left pt-5 pl-5 col-white">中国五矿</span></a>
	   								<!-- <a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo27"></i><span class="pull-left pt-5 pl-5 col-white">宝金矿业</span></a>	 -->
								</div>	
							</li>
							<li class="clear pt-5"> 
								<div class="clear">
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo9"></i><span class="pull-left pt-5 pl-5 col-white">中冶海外</span></a>
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo10"></i><span class="pull-left pt-5 pl-5 col-white">首钢集团</span></a>
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo11"></i><span class="pull-left pt-5 pl-5 col-white">中国铝业</span></a>
									<!-- <a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo12"></i><span class="pull-left pt-5 pl-5 col-white">中国黄金</span></a>			 -->
								</div>
							</li>
							<!-- <li class="clear pt-5 pb-5">
								<div class="clear">
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo13"></i><span class="pull-left pt-5 pl-5 col-white">中国有色</span></a>
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo14"></i><span class="pull-left pt-5 pl-5 col-white">江西铜业</span></a>
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo15"></i><span class="pull-left pt-5 pl-5 col-white">潞安集团</span></a>	
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo17"></i><span class="pull-left pt-5 pl-5 col-white">中盛资源</span></a>		
								</div>
							</li> -->
							<!-- <li class="clear pt-5 pb-5">
								<div class="clear">
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo18"></i><span class="pull-left pt-5 pl-5 col-white">中国有色</span></a>
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo19"></i><span class="pull-left pt-5 pl-5 col-white">江西铜业</span></a>
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo20"></i><span class="pull-left pt-5 pl-5 col-white">潞安集团</span></a>	
									<a class="pd-5 pull-left" href=""><i class="pull-left partners pats-logo21"></i><span class="pull-left pt-5 pl-5 col-white">中盛资源</span></a>		
								</div>
							</li> -->
						</ul>
					</div>
					
					<div class="col-sm-4">
						<h3 class="f-16 pt-10 pb-10 col-white">客户服务</h3>
						<div class="bor-ccc"></div>
						<div class="clear pt-10">
							<div class="col-sm-3 pd-0">
								<span class="pull-left pt-5 col-white">服务平台：</span>
							</div>
							<div class="col-sm-9 col-white">
								<div class="col-sm-6">
									<div class="pull-left">
										<img src="<%=path %>/img/fuwu.jpg" alt="">
										<p class="pt-5 col-white text-center">服务号</p>
									</div>								
								</div>
								<div class="col-sm-6">
									<div class="pull-left">
										<img src="<%=path %>/img/appdown.png" alt="">
										<p class="pt-5 col-white text-center">APP</p>
									</div>	
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						
						<h3 class="f-16 pt-10 pb-10 col-white">联系我们</h3>
						<div class="bor-ccc"></div>
						<div class="line-h-20 col-white">
							<p class="pt-10 pb-5 col-white">客服电话：</p>
							<p class="pt-5 pb-5"><a class="hov-pri" href="tel:0898-31002721">0898-88650759</a><span class="ml-10 col-white">(9:00-18:00)</span></p>
							<p class="pt-5 pb-5 col-white">地址：海南省三亚市海棠湾亚太金融(基金)小镇</p>							<p class="pt-5 pb-5 hov-pri"><a href="mailto:info@miningcircle.com">邮箱：info@apftown.com</a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="bg-555 text-center pd-10 col-white t-none">
			©2014&nbsp;亚太金融（基金）小镇&nbsp;All&nbsp;rights&nbsp;reserved&nbsp;&nbsp;|&nbsp;&nbsp;海南省三亚市海棠湾亚太金融（基金）小镇&nbsp;&nbsp;|&nbsp;&nbsp;<a class="hov-pri" href="javascript:;">琼ICP备17000007号-1</a>&nbsp;&nbsp;
			<!-- |&nbsp;&nbsp;<a class="hov-pri" href="">京公网安备11010502027200</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a class="hov-pri" href="">京ICP备14044935号-2</a> -->  
		</div>
	<% } %>
</footer>