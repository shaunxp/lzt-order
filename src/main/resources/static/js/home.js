;
void
    function() {
        function Pay() {
            this.$keyNum = $(".J_key_num");
            this.$keyDelete = $(".J_key_delete");
            this.$rmbMoney=$("#J_rmb");
            this.$usbMoney=$("#J_usb");
            this.$payBtn=$("#J_pay_btn");
            this.payMoney=""+0;

        }
        $.extend(Pay.prototype ,{
            //初始化事件
            init: function() {
                this.resetWrapper();
                this.bindEvent();
            },
            //页面布局重新加载
            resetWrapper:function(){
                try{
                    var screenHeight= document.body.clientHeight,
                        bottomHeight = $("#J_bottom_wrapper")[0].clientHeight,
                        topHeight = $("#J_top_wrapper")[0].clientHeight;
                    var padding=screenHeight-bottomHeight-topHeight;
                    if(padding>0){
                        if (navigator.userAgent.match(/(iPhone)/)) {
                            if ((screen.availHeight == 812) && (screen.availWidth == 375)) {
                                var paddingCss=Math.floor(padding/2)-20;
                                $("#J_top_wrapper").css("padding",paddingCss+" "+0);
                                $("#J_button_wrapper").css("padding-bottom","60px");
                                return;
                            }
                        }
                        var paddingCss=Math.floor(padding/2);
                        $("#J_top_wrapper").css("padding",paddingCss+" "+0);
                    }else{
                        $("#J_button_wrapper").css("padding-top","15px");
                        $("#J_store_name").css("margin-top","12px");
                        var paddingCss=Math.floor((padding+40)/2);
                        $("#J_top_wrapper").css("padding",paddingCss+" "+0);
                    }
                }catch(e){

                }
            },
            //界面绑定事件
            bindEvent: function() {
                var self = this;
                var $keyNum=self.$keyNum,
                    $keyDelete=self.$keyDelete,
                    $payBtn=self.$payBtn;
                //数字键盘点击点击
                $keyNum.on("touchstart",function(){
                    var keyValue=$(this).data("key");
                    self.getPayMoney(keyValue);
                    self.setMoney();
                    $(this).addClass("active")

                }).on("touchend",function(){
                    var el=$(this);
                    setTimeout(function(){
                        el.removeClass("active")
                    },30)
                });
                //删除按钮点击
                $keyDelete.on("touchstart",function(){
                    var beforePayMoney=self.payMoney;
                    self.payMoney=beforePayMoney.substr(0,(beforePayMoney.length-1));
                    self.setMoney();
                    $(this).addClass("active")
                }).on("touchend",function(){
                    var el=$(this);
                    setTimeout(function(){
                        el.removeClass("active")
                    },30)

                });
                //支付按钮点击
                $payBtn.on("touchstart",function(){
                    if($(this).hasClass("disabled"))
                        return false;
                    paySubmit(self.payMoney);
                })

            },
            //获取支付金额
            getPayMoney:function(key){
                var self=this,
                    beforePayMoney=this.payMoney||0+"";
                var payMoney=("0"===beforePayMoney&&("."!=key))?""+key:beforePayMoney+key;
                if(/((^[-]?([1-9]\d*))|^0)(\.\d{0,2})?$|(^[-]0\.\d{0,2}$)/.test(payMoney)&&payMoney.length<13){
                    this.payMoney=payMoney;
                }

            },
            //金额展示
            setMoney:function(){
                var self=this;

                self.$rmbMoney.html(self.payMoney||0);
            }

        });

        var run=function(){
            var pay = new Pay();
            pay.init();
        };
        run();
    }.call(this);
