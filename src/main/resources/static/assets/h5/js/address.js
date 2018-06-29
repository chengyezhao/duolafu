  $("#address").on("click",function(){
        $("#address").selectAddress({
            "ajaxURL":"addressJsonp.json",
            storageBox:$("#address"),
            callback:function(string){
                //执行回调
                console.log("选择的是："+string);
            }
        });
    });
     $("#workaddress").on("click",function(){
        $("#workaddress").selectAddress({
            "ajaxURL":"addressJsonp.json",
            storageBox:$("#workaddress"),
            callback:function(string){
                //执行回调
                console.log("选择的是："+string);
            }
        });
    });
    (function($,window,document,undefined){
        $.fn.selectAddress=function(options){
            self.flag=false;//boolean,通过控制true or false, 防止恶意切换
            self.text=null;//回调时,用来储存选择到的地址数据
            this.default={
                "ajaxURL":"addressJsonp.json",//ajax请求数据的地址
                "speed":300,//切换的速度
                storageBox:"",//在选择地址用，用来储存地址数据的盒子
                callback:function(){}
            }
            this.option=$.extend({},this.default,options);
            var arrText="";//储存选择到的数据，添加到storageBox中
            var op=this.option;
            // 初始化入口
            this.init=function(){
                var self=this;
                this.createEle();
                this.createProvince();
                // 点击关闭按钮的时候按钮的时候
                self.closeBtn.on("click",function(){
                    self.maskHidie();
                })
                self.aInfo.on("click",function(){
                    var index=$(this).index();
                    self.clickInfo($(this),index);
                });
                self.mask.on("click",function(event){
                    if($(event.target).attr("id")=="toogle-mask"){
                        self.maskHidie();
                    }
                })
            }
            // 创建toogle-mask模块
            this.createEle=function(){
                var self=this;
                self.mask=$('<div class="toogle-address-mask" id="toogle-mask"></div>');
                self.maskChild=$('<div class="toogle-address" id="toggleCont"><div class="toogle-address-title border-b"><i class="xs_left"><img src="../../../images/back.png"/></i>配送至<i class="xs_right" id="closeBtn"><img src="../../../images/cha.png"/></i></div><div id="address" class="address01"><div class="address-header"><span class="address-info address-now" id="provience" style="margin-left: 0;">请选择</span><span class="address-info" id="city">请选择</span><span class="address-info" id="county">请选择</span></div><div class="address-content"><div class="address-cont"><ul class="provienc-part" data-create="createCity" data-index="1"></ul><ul class="city-part" data-create="createCounty" data-index="2"></ul><ul class="county-part" data-index="3"></ul></div></div></div></div>');
                $("body").append(self.mask);
                self.mask.append(self.maskChild);
                self.closeBtn=$("#closeBtn",self.mask);//关闭按钮
                self.toogleMask=$("#toggleCont",self.mask);//选择地址的内容区
                self.aInfo=$(".address-info",self.mask);//选择省市区选项
                self.AddressCont=$(".address-cont",self.mask);//三个地址列表包裹的层
                self.mask.animate({
                    opacity:1
                },100,function(){
                    self.maskChild.css({"bottom":'-300px'}).animate({
                        "left":"0",
                        "bottom":"0"
                    },op.speed);
                })
            }
            // 创建省模块
            this.createProvince=function(){
                var self=this;
                self.addressAjax(self.AddressCont.find('.provienc-part'),null,1);
            }
            // 创建市模块
            this.createCity=function(dataValue){
                var self=this;
                self.mask.find("#city").show();
                self.AddressCont.find('.city-part').empty();
                self.addressAjax(self.AddressCont.find('.city-part'),dataValue,2);
            }
            // 创建区域模块
            this.createCounty=function(dataValue){
                var self=this;
                self.mask.find("#county").show();
                self.AddressCont.find('.county-part').empty();
                self.addressAjax(self.AddressCont.find('.county-part'),dataValue,3);
            }
            // 点击选择地址
            this.clickfn=function (district){
                var self=this;
                district.on('click',function(event){
                    var _this=$(this);
                    var parent=_this.parent();
                    var dataValue=_this.data("value");
                    var parentCreate=parent.data("create");
                    var dataIndex=parent.data("index");
                    _this.parent().find('li').removeClass("liNow");
                    _this.addClass("liNow");
                    self.aInfo.eq(dataIndex-1).html(_this.text());
                    if(parentCreate=='createCity'){
                        self.createCity(dataValue);
                    }else if(parentCreate=="createCounty"){
                        self.createCounty(dataValue);
                    }
                    if(dataIndex==3){
                        // 如果dataIndex=3,说明选择的是区域，执行移除toogle-address模块
                        self.maskHidie();
                    }else{
                        // 如果dataIndex小于3，执行clickInfo
                        self.clickInfo(self.aInfo.eq(dataIndex),dataIndex);
                    }
                })
            }
            // 移除toogle-address模块
            this.maskHidie=function(){
                var self=this;
                self.toogleMask.animate({
                    bottom:"-300px"
                },op.speed,function(){
                    self.mask.animate({
                        'opacity':0
                    },200,function(){
                        self.addressInput();
                        if(op.callback&& typeof op.callback=="function"){
                            // 执行回调函数
                            op.callback(self.text);
                        }
                    })
                })
            }
            // 将数据存放到input表单中
            this.addressInput=function(){
                var self=this;
                var boxHtml="";
                var text="";
                for(var i=0;i<op.storageBox.find("span").length;i++){
                    boxHtml+=op.storageBox.find("span").eq(i).text()+" ";
                }
                for(var i=0;i<$(".liNow").length;i++){
                    arrText+="<span>"+$(".liNow").eq(i).text()+"</span>";
                    text+=$(".liNow").eq(i).text()+" ";
                };
                // 如果arrText不为空
                if(arrText!=""){
                    op.storageBox.html(arrText);
                    self.text=text;
                }else{
                    self.text=boxHtml;
                }
                self.mask.remove();
            }
            this.clickInfo=function(ele,index){
                var self=this;
                self.flag=true;
                if(self.flag){
                    self.flag=false;
                    ele.addClass("address-now").siblings().removeClass("address-now");
                    self.AddressCont.animate({
                        "margin-left":"-"+index*100+"%"
                    },op.speed);
                    self.flag=true;
                }
            }
            // 通过ajax请求数据
            this.addressAjax = function(district, cValue, ov,type) {
                var self=this;
                var oType = null;
                district.empty();
                $.ajax({
                    url: this.option.ajaxURL,
                    dataType: 'json',//这里用的是jsonp，json的地址是http://www.zxhuan.com/jsonText/address.json
                    async: false,
                    data:"",
                    //jsonpCallback:"addressJONP",//如果上面用datatype:json,那么这里去掉
                    success: function(data) {
                        console.log(data);
                        district.empty();
                        if (ov == 3) {
                            oType = data.county; //请求区的数据
                        } else if (ov == 2) {
                            oType = data.city; //请求市的数据
                        } else if (ov == 1) {
                            oType = data.provience; //请求省的数据
                        }
                        this.countyItem='';
                        $.each(oType, function(key, value) {
                            if (cValue == null) {
                                this.countyItem =  $("<li data-value='" + value.id + "'>" + value.name + "</li>");
                            } else if (cValue == value.cid) {
                                this.countyItem = $("<li data-value='" + value.id + "'>" + value.name + "</li>");
                            }
                            district.append(this.countyItem);
                        });
                        self.clickfn(district.find("li"));
                    },
                    error: function() {
                        console.log('ajax error')
                    }
                })
            }
            return this.init();
        }
    })(jQuery,window,document);
