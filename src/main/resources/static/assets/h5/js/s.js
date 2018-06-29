$(function(){
$(".bar-mark").on("touchmove",function(event){
	var $par=$(".bar-scroll-box");
	var $s=$(".progress-box");
	var thisVal = this;
    var barLeft = $par.offset().left; //进度条的开始点位置;
    var barWidth = $s.width(); //进度条宽度;
    var scale = barWidth/100;
    var barRight = barLeft + barWidth; //进度条的结束点位置;
    var changeX = event.originalEvent.changedTouches[0].clientX; //每次移动1px;
    var currentValue = event.originalEvent.changedTouches[0].clientX - barLeft; //当前移动的位置
        if (changeX >= barLeft && changeX <= barRight){
            currentValue = currentValue/scale;
            var t=parseInt(currentValue);
            var foornumbre=Math.floor((2900*(currentValue/100)+100)/100)*100;
           $(".info-inner").html(Math.round(foornumbre));
           $(".bar-scroll-box").css("width",Math.round(currentValue)+"%")
           if(Math.round(currentValue)+"%">"99%"){
           	  $(".info-inner").html(3000);
           }
        }       
})
$(".bar-mark01").on("touchmove",function(event){
	var $par=$(".bar-scroll-box01");
	var $s=$(".progress-box01");
	var thisVal = this;
    var barLeft = $par.offset().left; //进度条的开始点位置;
    var barWidth = $s.width(); //进度条宽度;
    var scale = barWidth/100;
    var barRight = barLeft + barWidth; //进度条的结束点位置;
    var changeX = event.originalEvent.changedTouches[0].clientX; //每次移动1px;
    var currentValue = event.originalEvent.changedTouches[0].clientX - barLeft; //当前移动的位置
    if(changeX >= barLeft && changeX <= barRight){
        currentValue = currentValue/scale;
        if(Math.round(currentValue)+"%"=="100%"){
        	$(".info-inner01").html("3个月");
        }else if(Math.round(currentValue)<="33"){
        	$(".info-inner01").html("14天");
        }else{
        	$(".info-inner01").html("1个月");
        }
       $(".bar-scroll-box01").css("width",Math.round(currentValue)+"%")
    }       
})
})
