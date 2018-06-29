	/**
 * Created by hechao on 2017/6/25.
 */
(function(){
 
  /**添加window对象hScoll属性*/
  window.hScoll = {
 
 
    buildScoll:function(el,options){
      App.init(el,options);
    }
  }
 
  var App = {
 
    /**初始化组件*/
    init:function(el,option){
      App.options = option;
      App.prevY = 0;
      App.el = document.getElementById(el);
      App.scoll = this.el.children[0];
      App.h = this.el.offsetHeight;//滑动范围高度
      App.ch = this.el.scrollHeight;//内容的高度
      if(parseFloat(this.h)<=parseFloat(this.ch)){
        App.sdiv = document.createElement('div');
        App.scollb = document.createElement('div');
        App.sdiv.setAttribute('class','scrollbars');
        App.scollb.setAttribute('class','scollb');
        App.scollb.style.height = parseFloat(this.h)*parseFloat(this.h)/parseFloat(this.ch) + 'px';
        App.el.appendChild(this.sdiv);
        App.sdiv.appendChild(this.scollb);
        App.initevent();
      }
    },
 
    /**绑定事件*/
    initevent:function (){
      App.el.addEventListener('touchstart', App.touchstart, false);
      App.el.addEventListener('touchmove', App.touchmove, false);
      App.el.addEventListener('touchend', App.touchend, false);
    },
 
    /**记录滑动初始位置*/
    touchstart:function(e){
      var point = App.getPoint(e);
      App.startY = point.pageY;
    },
 
    /**手指移动时，滚动条滚动*/
    touchmove:function(e){
      e.preventDefault();//阻止默认行为
      var point = App.getPoint(e);
      App.moveY = point.pageY;
      App.deltaY = App.startY - App.moveY;
      if((App.prevY - App.deltaY)<=0 && (App.prevY - App.deltaY)>= -(App.ch-App.h)){
        App.domove(App.prevY - App.deltaY);
      }
      if(App.options.interactiveScrollbars){
        App.domove2(App.prevY - App.deltaY);
      }else{
        if((App.prevY - App.deltaY)<=0 && (App.prevY - App.deltaY)>= -(App.ch-App.h)){
          App.domove2(App.prevY - App.deltaY);
        }
      }
    },
 
    /**手指离开时，判断位置*/
    touchend:function(e){
      App.prevY = App.prevY - App.deltaY;
      if(App.prevY >= 0){
        App.prevY = 0;
        App.domove(App.prevY,true);
        App.domove2(App.prevY,true);
      }
      if(App.prevY <= -(App.ch-App.h)){
        App.prevY = -(App.ch-App.h);
        App.domove(App.prevY,true);
        App.domove2(App.prevY,true);
      }
    },
 
    getPoint:function (e) {
      return e.touches ? e.touches[0] : e;
    },
 
    /**内容滑动*/
    domove:function (y,t){
      if(t){
        App.scoll.setAttribute('style', 'transform: translate(0px, '+y+'px);transition:transform 300ms ease');
      }else{
        App.scoll.setAttribute('style', 'transform: translate(0px, '+y+'px);transition:transform 0ms ease');
      }
    },
 
    /**滚动条滑动*/
    domove2:function(y,t){
      if(t){
        App.scollb.setAttribute('style', 'transform: translate(0px, '+-parseFloat(y)*parseFloat(App.h)/parseFloat(App.ch)+'px);transition:transform 0ms ease;height:'+parseFloat(App.h)*parseFloat(App.h)/parseFloat(App.ch) + 'px'+'');
      }else{
        App.scollb.setAttribute('style', 'transform: translate(0px, '+-parseFloat(y)*parseFloat(App.h)/parseFloat(App.ch)+'px);transition:transform 0ms ease;height:'+parseFloat(App.h)*parseFloat(App.h)/parseFloat(App.ch) + 'px'+'');
      }
    }
  }
})();