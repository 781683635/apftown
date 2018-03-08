/*jquery*/
  var headHeight=$(".swiper-container").height()-0;
  var nav=$(".nav");
  $(window).scroll(function(){
    if($(this).scrollTop()>headHeight){
      nav.addClass("div1");
    }
    else{
      nav.removeClass("div1");
    }
  });    
/* 显示或隐藏效果开始 */
    $(document).ready(function(){
      $("#hide1").click(function(){
        $(".lxb-container1").hide();
        $(".lxb-close-btn").show();
      });
      $(".lxb-close-btn").click(function(){
        $(".lxb-container1").show();
        $(".lxb-close-btn").hide();
      });
      $("#hide2").click(function(){
        $(".lxb-container2").hide();
      });
      $(".right_float_inner4").click(function(){
        $(".right_float").show();
        $(".right_float_inner4").hide();
        $(".right_float_inner4").hide(1000);
      });
      $(".clctit").click("slow",function(){
        $(".right_float").hide();
        $(".right_float_inner4").show();
        $(".right_float_inner4").show(1000);
      });
    });
/* 显示或隐藏效果结束 */

/* 延迟出现开始 */
setTimeout("delay1.style.visibility='visible'",1000);
/* 延迟出现结束 */
var mySwiper = new Swiper('.swiper-container',{
	effect:'fade',
	autoplay:2000,
	speed:1000,
	loop:true,
	autoplayDisableOnInteraction : false,
});



