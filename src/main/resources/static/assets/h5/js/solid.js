/*
    createBar：创建进度条
        defaluValue：进度条默认参数
            color：进度条颜色，标签颜色
            width：进度条进度
            name：标签名称
    SetColor：设置颜色
    GetValue：获取进度
    SetValue：设置进度
    ScrollBarEvent: 滑动进度条
*/
(function ($) {
    $.fn.extend({
        createBar: function(options) {
            var defaultValue = { //默认参数
                color: '#009ddd',
                value: 0,
                name: '女生'
            };
            if (options != undefined) {  //有参数
                $.each(options, function(n, val) {
                    if (n != null) {
                        defaultValue[n] = val;
                    }
                });
            }
            var $this = $(this);
            $this.append('<div style="margin-top: 50px; margin-left: 50px;">'
                +'<div class="progress-box">'
                    +'<div class="progress-bar-box">'
                        +'<div class="bar-scroll-box" data-width="'+ defaultValue['value'] +'">'
                            +'<span class="bar-mark"></span>'
                            +'<div class="bar-info">'
                                +'<div class="info-arrow"></div>'
                                +'<div class="info-inner">'
                                    +''+ defaultValue['name'] +'：<span>'+defaultValue['value'] +'</span>%'
                                +'</div>'
                            +'</div>'
                        +'</div>'
                    +'</div>'
                +'</div>'
                +'<span class="pro-info"></span>'
            +'</div>');
            this.SetColor($this, defaultValue['color']);
            this.SetValue($this, defaultValue['value']);
            this.ScrollBarEvent($this);
        },
        SetColor: function($box, color) {
            $box.find('.bar-scroll-box').css('background-color', color);
            $box.find('.info-inner').css('background-color', color);
            $box.find('.info-arrow').css('border-top-color', color);
        },
        GetValue: function($box) {
            var $this = $(this);
            this.currentX = $this.find(".bar-scroll-box").data('width');
            return this.currentX;
        },
        SetValue: function ($box, index) { /*设置进度条的的宽度*/
            var $bar = $box.find('.bar-scroll-box');
            if (index === undefined) {　//没有参数
                index = $bar.data('width');
            }
            $bar.css('width', index +'%');
            $bar.attr('data-width', index);
            $bar.find('.info-inner').find('span').html(index);
        },
        ScrollBarEvent: function($box) {
            var thisVal = this;
            var $par = $box.find('.progress-box');
            var barLeft = $par.offset().left; //进度条的开始点位置;
            var barWidth = $par.find('.progress-bar-box').width(); //进度条宽度;
            var scale = barWidth / 100;
            var barRight = barLeft + barWidth; //进度条的结束点位置;
            $box.find(".bar-mark").on('touchstart', function () {
                $box.find('.progress-box').on('touchmove', function (event) {
                    var changeX = event.clientX; //每次移动1px;
                    console.log(changeX)
                    var currentValue = event.clientX - barLeft; //当前移动的位置
                    if (changeX >= barLeft && changeX <= barRight){
                        currentValue = currentValue /scale;
                        thisVal.SetValue($box, Math.round(currentValue));
                    }       
                }); 
            });
            $(document.body).on("touchstart",function(){
                $box.find('.progress-box').off('touchmove');
            });
        }
    });
}(jQuery));