$(function(){
	var swiper2=new Swiper('.swiper2',{
		preventClicks : false,
		slidesPerView:6,
		spaceBetween:10,
		// autoplay:3000,
		speed:1000,
		pagination:'.page2',
		loop:true,
		paginationType:'progress',
		grabCursor : true,
	});
	var swiper3=new Swiper('.swiper3',{
		preventClicks : false,
		slidesPerView:6,
		spaceBetween:10,
		// autoplay:3500,
		speed:1000,
		pagination:'.page3',
		paginationType:'progress',
		loop:true,
		autoplayDisableOnInteraction : false,
		grabCursor : true,
	});
	/*视频播放*/
	$(".play").on("click",function(){
		$(".video").fadeIn(500);
		$("video").attr({"src":"./img/video/apft.mp4","autoplay":"autoplay"})
	});
	$(".video").hover(function(){
		$(".closevd").fadeIn(300);
	},function(){
		$(".closevd").fadeOut(300);
	});
	$(".closevd").click(function(){
		$("video").get(0).pause();
		$("video").get(0).currentTime=0;
		$(".video").fadeOut(500);
	});
	// $('.swiper2').hover(function(){
	// 	swiper2.stopAutoplay();
	// },function(){
	// 	swiper2.startAutoplay();
	// });

})	
	