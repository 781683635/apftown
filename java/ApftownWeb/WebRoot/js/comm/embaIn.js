/*EMBA转场JS*/
/*swiper对象的动画参数定义*/
    var swiperAnimateParam_main1 = {
        slide_1:{
            animate_01:{
                element:'main1_ani_01',
                animation:'fadeInDown',
                finish : 'forwards',
                duration : '1.3s',
                delay : '0.7s',
            },
        },
        slide_2:{
            animate_02:{
                element:'main1_ani_02',
                animation:'lightSpeedIn',
                finish : 'forwards',
                duration : '1.3s',
                delay : '0.3s',
            },
            animate_03:{
                element:'main1_ani_03',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '1s',
                delay : '0.5s',
            },
            animate_04:{
                element:'main1_ani_04',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '1s',
                delay : '0.7s',
            },
            animate_05:{
                element:'main1_ani_05',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '1s',
                delay : '0.9s',
            },
            animate_06:{
                element:'main1_ani_06',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '1.5s',
            },
        },
        slide_3:{
            animate_07:{
                element:'main1_ani_07',
                animation:'fadeInLeft',
                finish : 'forwards',
                duration : '0.7s',
                delay : '0.1s',
            },
            animate_08:{
                element:'main1_ani_08',
                animation:'rollIn',
                finish : 'forwards',
                duration : '2s',
                delay : '1.3s',
            },
            animate_09:{
                element:'main1_ani_09',
                animation:'flipInY',
                finish : 'forwards',
                duration : '0.3s',
                delay : '0.8s',
            },
            animate_10:{
                element:'main1_ani_10',
                animation:'rollIn',
                finish : 'forwards',
                duration : '2s',
                delay : '1.3s',
            },
            animate_11:{
                element:'main1_ani_11',
                animation:'flipInY',
                finish : 'forwards',
                duration : '0.3s',
                delay : '0.8s',
            },
            animate_12:{
                element:'main1_ani_12',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '0.8s',
            },
            animate_13:{
                element:'main1_ani_13',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '1s',
            },
            animate_14:{
                element:'main1_ani_14',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '1s',
            },
            animate_15:{
                element:'main1_ani_15',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '1.3s',
            },
            animate_16:{
                element:'main1_ani_16',
                animation:'fadeInDown',
                finish : 'forwards',
                duration : '0.5s',
                delay : '1.7s',
            },
        },
        slide_4:{
            animate_17:{
                element:'main1_ani_17',
                animation:'fadeInLeft',
                finish : 'forwards',
                duration : '0.5s',
                delay : '0.1s',
            },
            animate_18:{
                element:'main1_ani_18',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '0.7s',
            },
            animate_19:{
                element:'main1_ani_19',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '0.9s',
            },
            animate_20:{
                element:'main1_ani_20',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '1.1s',
            },
            animate_21:{
                element:'main1_ani_21',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '1.3s',
            },
        },
        slide_5:{
            animate_22:{
                element:'main1_ani_22',
                animation:'zoomInLeft',
                finish : 'forwards',
                duration : '1s',
                delay : '1s',
            },
            animate_23:{
                element:'main1_ani_23',
                animation:'zoomInUp',
                finish : 'forwards',
                duration : '1s',
                delay : '1.5s',
            },
            animate_24:{
                element:'main1_ani_24',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '0.1s',
            },
            animate_25:{
                element:'main1_ani_25',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '0.1s',
            },
            animate_26:{
                element:'main1_ani_26',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '0.3s',
            },
            animate_27:{
                element:'main1_ani_27',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '0.3s',
            },
            animate_28:{
                element:'main1_ani_28',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '0.5s',
            },
            animate_29:{
                element:'main1_ani_29',
                animation:'fadeInUp',
                finish : 'forwards',
                duration : '0.5s',
                delay : '0.7s',
            },
        },
            
        };
    /*在全局范围内创建主动画控制器与子动画控制器*/
        var myAC_main1 = new animateControl("main1_ani_");
    /*在全局范围内创建主动画控制器与子动画控制器END*/
/*swiper对象的动画参数定义END*/
/*jquery*/
$(document).ready(function() {
    /*侧边栏*/
    $(".e-mord").click(function() {
         $(".showmore").stop(true,true);
         $(".showul").hide();
         $(".showmore").animate({width:'160px'},300);
         $(".showul").show();
    });
    $(".showmore").mouseleave(function() {
        $(".showmore").stop(true,true);
        $(".showul").hide();
        $(".showmore").animate({width:'0px'},500);
    });
    /*侧边栏END*/
})
/*EMBA转场JSEND*/