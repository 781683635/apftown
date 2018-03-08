<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="container1 clear">
    <div class="row1">
        <div class="col-sm-3 col-xs-3 pl-0 pr-0 bor-r-light">						
			<div class="bg-w-blue text-center t-none">
				<a href="<%=path%>/emba/proi.do"><h3 class="f-16 col-white pd-10 <% if("1.1".equals(embaType)){ %>gra-pri3<% } %>">项目介绍</h3></a>
			</div>
		</div>
		<div class="col-sm-3 col-xs-3 pl-0 pr-0 bor-r-light">						
			<div class="bg-w-blue text-center t-none">
				<a href="<%=path%>/emba/cursz.do"><h3 class="f-16 col-white pd-10 <% if("1.2".equals(embaType)){ %>gra-pri3<% } %>">课程体系</h3></a>
			</div>
		</div>
		<div class="col-sm-3 col-xs-3 pl-0 pr-0 bor-r-light">						
			<div class="bg-w-blue text-center t-none">
				<a href="<%=path%>/emba/teach.do"><h3 class="f-16 col-white pd-10 <% if("1.3".equals(embaType)){ %>gra-pri3<% } %>">师资力量</h3></a>
			</div>
		</div>
		<div class="col-sm-3 col-xs-3 pl-0 pr-0">						
			<div class="bg-w-blue text-center t-none">
				<a href="<%=path%>/emba/notice.do"><h3 class="f-16 col-white pd-10 <% if("1.4".equals(embaType)){ %>gra-pri3<% } %>">报名须知</h3></a>
			</div>
		</div> 
		<div class="swiper-container swiper1">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img src="<%=path %>/img/edu-emba/banner1.jpg" alt="亚太金融EMBA">
				</div>
				<div class="swiper-slide">
					<img src="<%=path %>/img/edu-emba/banner2.jpg" alt="亚太金融EMBA">
				</div>
				<div class="swiper-slide">
					<img src="<%=path %>/img/edu-emba/banner3.jpg" alt="亚太金融EMBA">
				</div>
				<div class="swiper-slide">
					<img src="<%=path %>/img/edu-emba/banner4.jpg" alt="亚太金融EMBA">
				</div>
			</div>
		</div>
   </div>
</div>
