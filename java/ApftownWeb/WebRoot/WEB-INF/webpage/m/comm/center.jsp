<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div>
	<nav class="pt-10 f-14 bg-gray">
		<div class="swiper-container mobile-nav h-25 line-h-20">
			<div class="swiper-wrapper text-center t-none">
				<div class="swiper-slide"><a class=" inline-block col-black pl-15 pr-15 pb-5 ${empty propCode?'cur':'' }" href="<%=path%>/index.do"><i class="icon-home"></i>首页</a></div>
				<div class="swiper-slide"><a class="inline-block col-black ${fn:substring(propCode, 0, 1) == '1'?'cur':'' }" href="<%=path%>/t/index.do">关于小镇</a></div>
				<div class="swiper-slide"><a class="inline-block col-black ${fn:substring(propCode, 0, 1) == '2'?'cur':'' }" href="<%=path%>/f/index.do">基金一条街</a></div>
				<div class="swiper-slide"><a class="inline-block col-black ${fn:substring(propCode, 0, 1) == '3'?'cur':'' }" href="<%=path%>/e/index.do">国际教育</a></div>
				<div class="swiper-slide"><a class="inline-block col-black ${fn:substring(propCode, 0, 1) == '4'?'cur':'' }" href="<%=path%>/r/index.do">亚太研究</a></div>
				<div class="swiper-slide"><a class="inline-block col-black ${fn:substring(propCode, 0, 1) == '5'?'cur':'' }" href="<%=path%>/s/index.do">服务中心</a></div>
				<div class="swiper-slide"><a class="inline-block col-black ${fn:substring(propCode, 0, 1) == '6'?'cur':'' }" href="<%=path%>/n/index.do">新闻中心</a></div>
			</div>
		</div>
	</nav>
</div>