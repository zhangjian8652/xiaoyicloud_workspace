/**
 * Created by Administrator on 2015/10/31.
 */
define(function(require,exports,module){

    //引入jquery模块
    var $ = require("jquery");
    //获取验证码图片dom元素
    var $obj = $(".verify-code");

    //验证码dom元素绑定事件，点击更换
    $obj.click(function(){
        $(this).attr("src",seajs.data.vars.$path + "/admin/login/verifycode" + "?date=" + new Date());
    });

    //使用jquery-validate插件
    var validate = require("jquery-validate");
    validate.init($)

    console.log(seajs.data.vars.$path);
   //登陆表单验证
    if($("form").length > 0){
        $("form").validate({
            //debug: true, //调试模式取消submit的默认提交功能
            errorClass: "error", //默认为错误的样式类为：error
            errorPlacement:function(error, element){ //把错误信息放在验证的元素后面
                   element.parent().parent().removeClass("has-success").addClass("has-error");
                   element.parent().children("span").eq(0).removeClass("glyphicon-ok").addClass("glyphicon-remove");
                   element.parent().children("span").eq(1).removeClass("glyphicon-ok").addClass("glyphicon-remove");
                   error.appendTo(element.parent());
            },
            success:function(label){
                    label.parent().parent().addClass("has-success").removeClass("has-error");
                    label.parent().children("span").eq(0).removeClass("glyphicon-remove").addClass("glyphicon-ok");
                    label.parent().children("span").eq(1).removeClass("glyphicon-remove").addClass("glyphicon-ok");
                    label.remove();
            },
        //    focusInvalid: false, //当为false时，验证无效时，没有焦点响应
        //    onkeyup: false,
        //    submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form
        //        alert("提交表单");
        //        form.submit();   //提交表单
        //    },
            rules:{
                username:{
                    required:true
                    ,minlength:2
                    ,maxlength:20
                },
                password:{
                    required:true
                    ,minlength:2
                    ,maxlength:20
                },
                verifyCode:{
                    required:true
                    ,remote:{
                        url:seajs.data.vars.$path + "/admin/login/verifycode"
                        ,type:"post"
                        ,dataType:"json"
                        ,data:{
                            "verifyCode": function() {
                                return $("#verifyCode").val();
                            }
                        }
                    }
                }
            },
            messages:{
                username:{
                    required:"用户名必须填写"
                    ,minlength:"用户名长度必须大于{0}"
                    ,maxlength:"用户名长度不能大于{0}"
                },
                password:{
                    required:"密码必须填写"
                    ,minlength:"密码长度必须大于{0}"
                    ,maxlength:"密码长度不能大于{0}"
                },
                verifyCode:{
                    required:"请输入验证码"
                    ,remote:"验证码不匹配"
                }
            }
        });
    }


   //验证码懒加载测试用可以不用管
/*
        var lazyload = require("jquery-lazyload");
            lazyload.init($,window,document);

        $("img.lazy").lazyload({
            placeholder : "img/grey.gif",
            effect : "fadeIn"
        });
*/

});

