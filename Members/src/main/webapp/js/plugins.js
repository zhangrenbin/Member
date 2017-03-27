
/* ============================================================
 * 登录页面焦点图切换。
 * ============================================================ */
(function($){
    $.fn.extend({
         yx_rotaion: function(options) {
		    //默认参数
            var defaults = {
			     /**轮换间隔时间，单位毫秒*/
                 during:4000,
				 /**是否显示左右按钮*/
                 btn:false,
				 /**是否显示焦点按钮*/
                 focus:false,
				 /**是否显示标题*/
                 title:false,
				 /**是否自动播放*/
                 auto:true
            }
            var options = $.extend(defaults, options);
            return this.each(function(){
			    var o = options;
				var curr_index = 0;
                var $this = $(this);
                var $li = $this.find("li");
                var li_count = $li.length;
				$this.css({position:'relative',width:$li.find("img").width(),height:$li.find("img").height()});
				$this.find("li").css({position:'absolute',left:0,top:0}).hide();
			    $li.first().show();
			    $this.append('<div class="yx-rotaion-btn"><span class="left_btn"><\/span><span class="right_btn"></span><\/div>');
				if(!o.btn) $(".yx-rotaion-btn").css({visibility:'hidden'});
                if(o.title) $this.append(' <div class="yx-rotation-title"><\/div><a href="" class="yx-rotation-t"><\/a>');
                if(o.focus) $this.append('<div class="yx-rotation-focus"><\/div>');
				var $btn = $(".yx-rotaion-btn span"),$title = $(".yx-rotation-t"),$title_bg = $(".yx-rotation-title"),$focus = $(".yx-rotation-focus");
				//如果自动播放，设置定时器
				if(o.auto) var t = setInterval(function(){$btn.last().click()},o.during);
                $title.text($li.first().find("img").attr("alt"));
				$title.attr("href",$li.first().find("a").attr("href"));

               // 输出焦点按钮
               for(i=1;i<=li_count;i++){
                 $focus.append('<span>'+i+'</span>');
               }
               // 兼容IE6透明图片
               // if($.browser.msie && $.browser.version == "6.0" ){
               //    $btn.add($focus.children("span")).css({backgroundImage:'url(img/ico.gif)'});
               // }
               var $f = $focus.children("span");
               $f.first().addClass("hover");
               // 鼠标覆盖左右按钮设置透明度
               $btn.hover(function(){
	              $(this).addClass("hover");
               },function(){
	              $(this).removeClass("hover");
               });
			   //鼠标覆盖元素，清除计时器
               $btn.add($li).add($f).hover(function(){
                if(t) clearInterval(t);
               },function(){
                if(o.auto) t = setInterval(function(){$btn.last().click()},o.during);
               });
			   //鼠标覆盖焦点按钮效果
               $f.bind("mouseover",function(){
	             var i = $(this).index();
	             $(this).addClass("hover");
	             $focus.children("span").not($(this)).removeClass("hover");
	             $li.eq(i).fadeIn(300);
                 $li.not($li.eq(i)).fadeOut(300);
	             $title.text($li.eq(i).find("img").attr("alt"));
	             curr_index = i;
               });
			   //鼠标点击左右按钮效果
               $btn.bind("click",function(){
                 $(this).index() == 1?curr_index++:curr_index--;
	             if(curr_index >= li_count) curr_index = 0;
	             if(curr_index < 0) curr_index = li_count-1;
                 $li.eq(curr_index).fadeIn(300);
	             $li.not($li.eq(curr_index)).fadeOut(300);
	             $f.eq(curr_index).addClass("hover");
	             $f.not($f.eq(curr_index)).removeClass("hover");
	             $title.text($li.eq(curr_index).find("img").attr("alt"));
				 $title.attr("href",$li.eq(curr_index).find("a").attr("href"));
               });

            });
        }
    });

})(jQuery);
$(".yx-rotaion").yx_rotaion({auto:true});

/* ============================================================
 * 计算content的高度。
 * ============================================================ */
var contentH = function(){
  var h = (window.innerHeight || (window.document.documentElement.clientHeight || window.document.body.clientHeight));
    $("#ctrolcenter").css({"height":h-61-50});
    $("#indexcontent").css({"height":h});
  // var w = (window.innerWidth || (window.document.documentElement.offsetwidth || window.document.body.offsetwidth));
  //   $('#pikachoose').css({"width":w-629});
};
contentH();
$(window).resize(contentH);



/* ============================================================
 * iframe自动适应高度。
 * ============================================================ */
function iFrameHeight() {
  var ifm= document.getElementById("iframepage");
  var subWeb = document.frames ? document.frames["iframepage"].document:ifm.contentDocument;
  if(ifm != null && subWeb != null) {
    ifm.height = subWeb.body.scrollHeight;
  }
}

/* ============================================================
 * 列表页面左侧菜单动作
 * ============================================================ */
/*$(document).ready(function(){
  $('.nav-list  li  a').click(function(){
	  $(this).parent('li').siblings().removeClass('open');
	  $(this).parent('li').siblings().children('.submenu').slideUp();
	  $(this).siblings('.submenu').slideToggle();
	  $(this).parent('li').toggleClass('open');
	  $(this).siblings('.submenu').children('li').click(function(){
		  $(this).siblings('li').removeClass('active');
		  $(this).addClass('active');
		  });
	  })
});*/

/* ============================================================
 * 当窗口改变大小时重新计算滚动条高度
 * ============================================================ */
window.onresize = function(){
    $('.container2 .div_scroll').scroll_absolute({arrows:false});
  }

/* ============================================================
 * 表格隔行变色-针对添加了table-striped样式名的表格
 * ============================================================ */
/* 当鼠标移到表格上是，当前一行背景变色 */
$(document).ready(function(){
	$(".table-striped tr td").mouseover(function(){
		$(this).parent().find("td").css("background-color","#fffedf");
	});
})
/* 当鼠标在表格上移动时，离开的那一行背景恢复 */
$(document).ready(function(){
	$(".table-striped tr td").mouseout(function(){
		var bgc = $(this).parent().attr("bg");
		$(this).parent().find("td").css("background-color",bgc);
	});
})
$(document).ready(function(){
	var color="#f5f5f5"
	$(".table-striped tr:odd td").css("background-color",color);  //改变偶数行背景色
	/* 把背景色保存到属性中 */
	$(".table-striped tr:odd").attr("bg",color);
	$(".table-striped tr:even").attr("bg","#fff");
})


/* ============================================================
 * 列表页面查询条件更多选项动作
 * ============================================================ */
 $(function(){
	 $('.js-moreSel-btn').click(function(){
		 if($(this).parents().siblings('.js-adv-box').is(':hidden')){
			 $(this).parents().siblings('.js-adv-box').slideDown();
			 $(this).html('<i class="\icon-chevron-up mr5\"></i>隐藏选项');
			 }
		 else{
			 $(this).parents().siblings('.js-adv-box').slideUp();
			 $(this).html('<i class="\icon-chevron-down mr5\"></i>更多选项');
			 }
		 })
	 })
/* ============================================================
 * 后台首页图片轮播
 * ============================================================ */
var t = n = 0, count;
$(document).ready(function(){
	count=$("#banner_list a").length;
	$("#banner_list a:not(:first-child)").hide();
	$("#banner_info").html($("#banner_list a:first-child").find("img").attr('alt'));
	$("#banner_info").click(function(){window.open($("#banner_list a:first-child").attr('href'), "_blank")});
	$("#banner li").click(function() {
		var i = $(this).text() - 1;//获取Li元素内的值，即1，2，3，4
		n = i;
		if (i >= count) return;
		$("#banner_info").html($("#banner_list a").eq(i).find("img").attr('alt'));
		$("#banner_info").unbind().click(function(){window.open($("#banner_list a").eq(i).attr('href'), "_blank")})
		$("#banner_list a").filter(":visible").fadeOut(500).parent().children().eq(i).fadeIn(1000);
		document.getElementById("banner").style.background="";
		$(this).toggleClass("on");
		$(this).siblings().removeAttr("class");
	});
	t = setInterval("showAuto()", 4000);
	$("#banner").hover(function(){clearInterval(t)}, function(){t = setInterval("showAuto()", 4000);});
})

function showAuto()
{
	n = n >=(count - 1) ? 0 : ++n;
	$("#banner li").eq(n).trigger('click');
}

/* ============================================================
 * 星星评分
 * ============================================================ */
$(document).ready(function(){
    var stepW = 30;
    var description = new Array("差","中","良","好","优秀");
    var stars = $("#star > li");
    var descriptionTemp;
    $("#showb").css("width",0);
    stars.each(function(i){
        $(stars[i]).click(function(e){
            var n = i+1;
            $("#showb").css({"width":stepW*n});
            descriptionTemp = description[i];
            $(this).find('a').blur();
            return stopDefault(e);
            return descriptionTemp;
        });
    });
    stars.each(function(i){
        $(stars[i]).hover(
            function(){
                $(".description").text(description[i]);
            },
            function(){
                if(descriptionTemp != null)
                    $(".description").text("当前您的评价为："+descriptionTemp);
                else
                    $(".description").text(" ");
            }
        );
    });
});
function stopDefault(e){
    if(e && e.preventDefault)
           e.preventDefault();
    else
           window.event.returnValue = false;
    return false;
}

/* ============================================================
 * 首页右侧工具位置
 * ============================================================ */
function setools(){
  var window_w=$(window).width();
  var T_right=(window_w-1000)/2-58;
  $('.fix-tools').css('right',T_right);
 }
$(window).ready(setools);
window.onresize = setools;

/* ============================================================
 * 产品中心分类滚动
 * ============================================================ */
function addClass( elements,cName ){
        if( !hasClass( elements,cName ) ){
            elements.className += " " + cName;
        };
    };
function removeClass( elements,cName ){
        if( hasClass( elements,cName ) ){
            elements.className = elements.className.replace( new RegExp( "(\\s|^)" + cName + "(\\s|$)" ), " " );
        };
    };
function hasClass( elements,cName ){
        return !!elements.className.match( new RegExp( "(\\s|^)" + cName + "(\\s|$)") );
    };
function getElementsByClassName(className,context){
        context = context || document;       //如果有指定从某个元素里寻找，则会比每次都遍历document快得多

        if(context.getElementsByClassName){                               //如果浏览器支持原生的方法，则直接用原生的方法，为什么？你有把握你写的方法比原生提供的好吗？
            return context.getElementsByClassName(className);
        }

        var nodes = context.getElementsByTagName('*');         //遍历
        var rets = [];                                                     //存放匹配到的节点
        for(var i = 0; i < nodes.length; i++){
            if(hasClass(className,nodes[i])){                      //hasClass派上用场了
                rets.push(nodes[i]);
            }
        }
        return rets;
}
/* ===================================================================
 * 运动框架
 * 获取id实现左右移动
 * 变速运动
 * ===================================================================*/
var _Movetimer=null;
function moveto(object,itarget){
  var obj=object;
    clearInterval(_Movetimer);
    _Movetimer=setInterval(function(){
      var speed=0;
      if(obj.offsetLeft<itarget){//通过位移量除以10，使speed递减，实现减速停止。   乘以10则为加速。通过乘除的数字，控制快慢
        speed=(itarget-obj.offsetLeft)/10;
      }else{
        speed=-(obj.offsetLeft-itarget)/10;
      }
      speed=speed>0?Math.ceil(speed):Math.floor(speed);//取整，解决最后不足1px的位移量被忽略的问题
      if(obj.offsetLeft==itarget){
        clearInterval(_Movetimer);
      }else{
        obj.style.left=obj.offsetLeft+speed+'px';
      };
    },30);
}
function ClassMove(){

}
function ClassMoveLeft(id)
{
  var oP=document.getElementById(id);
  var oul=oP.getElementsByTagName('ul')[0];
  var olis=oul.getElementsByTagName('li');
  var Rw=0;
  for(var i=0;i<olis.length;i++)
  {
    Rw=Rw+olis[i].offsetWidth;
  }
  if(oul.offsetLeft<oP.offsetWidth-Rw)
  {
    oul.style.left=oul.offsetLeft+'px';
  }
  else{
    moveto(oul,oul.offsetLeft-olis[0].offsetWidth);
  }
}
function ClassMoveRight(id)
{
  var oP=document.getElementById(id);
  var oul=oP.getElementsByTagName('ul')[0];
  var olis=oul.getElementsByTagName('li');
  var Rw=0;
  for(var i=0;i<olis.length;i++)
  {
    Rw=Rw+olis[i].offsetWidth;
  }
  if(oul.offsetLeft>=0)
  {
    oul.style.left=0+'px';
  }
  else if(oul.offsetLeft<olis[0].offsetWidth){
     moveto(oul,0);
  }
  else{
     moveto(oul,oul.offsetLeft+olis[0].offsetWidth);
  }
}
/*能力平台导航变色*/
$(window).scroll(function(event) {

    var winPos = $(window).scrollTop();
    if (winPos > 60) {
        $('#js-menu-nav').addClass('active');
    } else {
        $('#js-menu-nav').removeClass('active');
    };
    if (winPos > 320){
      $('.fix-tools').show();
    }else $('.fix-tools').hide();

});

$(document).ready(function($) {
  /*能力平台-能力商城左侧菜单浮动层*/
  $('#js-flLay > li').mouseover(function(){
    $(this).addClass('hoverde');
    $(this).children('.menuFloatLayer').show();
  })
  $('#js-flLay > li').mouseout(function(){
       $(this).children('.menuFloatLayer').hide();
       $(this).removeClass('hoverde');
  })
  /*首页tab*/
  $('#myTabs a').click(function (e) {
    e.preventDefault()
    $(this).tab('show')
  })
  /*导航下拉菜单*/
  $('#js-user').click(function(event) {
    $(this).parents('ul').siblings('.dropdown-menu').toggle();
    $(this).toggleClass('active');
  });
});
