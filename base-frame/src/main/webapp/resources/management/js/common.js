//增加window sroll 禁用和开启
!function () {
    var keys = { 37: 1, 38: 1, 39: 1, 40: 1 };

    function preventDefault(e) {
        e = e || window.event;
        if (e.preventDefault)
            e.preventDefault();
        e.returnValue = false;
    }

    function preventDefaultForScrollKeys(e) {
        if (keys[e.keyCode]) {
            preventDefault(e);
            return false;
        }
    }
    var oldonwheel, oldonmousewheel1, oldonmousewheel2, oldontouchmove, oldonkeydown
        , isDisabled;
    function disableScroll() {
        if (window.addEventListener) // older FF
            window.addEventListener('DOMMouseScroll', preventDefault, false);
        oldonwheel = window.onwheel;
        window.onwheel = preventDefault; // modern standard

        oldonmousewheel1 = window.onmousewheel;
        window.onmousewheel = preventDefault; // older browsers, IE
        oldonmousewheel2 = document.onmousewheel;
        document.onmousewheel = preventDefault; // older browsers, IE

        oldontouchmove = window.ontouchmove;
        window.ontouchmove = preventDefault; // mobile

        oldonkeydown = document.onkeydown;
        document.onkeydown = preventDefaultForScrollKeys;
        isDisabled = true;
    }

    function enableScroll() {
        if (!isDisabled) return;
        if (window.removeEventListener)
            window.removeEventListener('DOMMouseScroll', preventDefault, false);

        window.onwheel = oldonwheel; // modern standard

        window.onmousewheel = oldonmousewheel1; // older browsers, IE
        document.onmousewheel = oldonmousewheel2; // older browsers, IE

        window.ontouchmove = oldontouchmove; // mobile

        document.onkeydown = oldonkeydown;
        isDisabled = false;
    }
    window.scrollHanlder = {
        disableScroll: disableScroll,
        enableScroll: enableScroll
    };
}();


/**
 * 给jquery绑定消息提示对象
 */

(function( factory ) {
    if ( typeof define === "function" && define.amd ) {
        define( ["jquery"], factory );
    } else {
        factory( jQuery );
    }
}(function($){
        // 提示消息对象
        //content：提示的信息类容
        //type ：warn,success,info,error
        function messager(settings){

            var defaultSettings = {
                time:3000,
                tittle:"message-tittle",
                message:"message-content"
            }

            if(settings != undefined && settings != null){
                defaultSettings = $.extend(defaultSettings,settings);
            }
            var $target = $(this);
            var tittle = $target.attr(defaultSettings.tittle);
            var message = $target.attr(defaultSettings.message);
            var hideTimer;

            var infoType="INFO",errorType="ERROR",warnType="WARN",successType="SUCCESS";

            //普通消息提示消息（白色背景）
            function info() {
                beforeTip();
                $target.html(getDefaultTemplate(infoType));
                afterTip();
            }
            //错误提示消息（红色背景）
            function error() {
                beforeTip();
                $target.html(getDefaultTemplate(errorType));
                afterTip();
            }
            //成功提示消息（绿色背景）
            function success() {
                beforeTip();
                $target.html(getDefaultTemplate(successType));
                afterTip();
            }
            //警告提示消息（黄色）
            function warn() {
                beforeTip();
                $target.html(getDefaultTemplate(warnType));
                afterTip()
            }
            function hide(){
                hideTimer = setTimeout(function(){
                    clear();
                },defaultSettings.time);
            }
            function beforeTip(){

            }
            function afterTip(){
                $target.children("button").click(function(){
                    clear();
                });
                hide();
            }

            function clear(){
                $target.html("");
            }

            function getDefaultTemplate(type){

                var content = "<div class='alert alert-{type} alert-dismissable'>"
                + "<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button>"
                + "<h4><i class='icon fa {icon}'></i>"+ tittle + "!</h4>"
                + message
                + "</div>";

                switch (type){
                    case errorType:
                        return content.replace("{type}","danger").replace("{icon}","fa-ban");
                    case warnType:
                        return content.replace("{type}","warning").replace("{icon}","fa-warning");
                    case successType:
                        return content.replace("{type}","success").replace("{icon}","fa-success");
                    case infoType:
                        return content.replace("{type}","info").replace("{icon}","fa-info");
                    default:
                        return content.replace("{type}","info").replace("{icon}","fa-info");
                }

            }

            return {'info':info,'warn':warn,'error':error,'success':success};

        }

        function loadContent(url){

            function getAjaxHtml(url){
                var resultData = "";
                jQuery.ajax({url:url,
                    //默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
                    async:false,
                    beforeSend:function(){

                    },
                    complete:function(){

                    },
                    data:{},
                    success:function(data){
                        resultData = data;
                    },
                    error:function(){

                    },
                    type:'GET',
                    dataType:"html"});

                return resultData;
            }

            var $contentElement = $(this);

            function handleHtml(contentHtml){
                //console.log(contentHtml)
                $contentElement.html(contentHtml);
            }

            var result = getAjaxHtml(url);

            try {
               var jsonData = JSON.parse(result);
                handleJsonResult(jsonData);
            } catch (e) {
                handleHtml(result);
            }

            function handleJsonResult(jsonData){
                console.log(jsonData);
            }


        }


        function modal(){
            var $modalElement = $(this);

            addCoverElement();

            $modalElement.removeClass("hide");

            $modalElement.find(".close-btn").click(function(){
                $modalElement.addClass("hide");
                $(".modal-cover").remove();
                window.scrollHanlder.enableScroll();
            });

            function  addCoverElement(){
                $("body").append("<div class='modal-cover'></div>");
                window.scrollHanlder.disableScroll();
            }
        }

        var settings = {messager:messager,modal:modal,loadContent:loadContent};

        $.fn.extend(settings);

}));

//对内容区域disable和enable管理
function content(action){
    if("enable" == action){
        $("body").append();
    }else if("disable" == action){

    }else{

    }
}

/**
 * Created by Administrator on 2015/11/22.
 */
function LeftNav() {

}
LeftNav.NAVID = "#content";

LeftNav.loadHtml = function (url) {
    $.get(url, {}, function (data) {
        var isJson = false;
        try {
            eval("(" + data + ")");
            isJson = true;
        } catch (e) {
            isJson = false;
        }
        if (isJson) {
            $(this.NAVID).html(data);
        } else {
            $.managementMessager.tip("#message","权限提示","对不起，您的权限不足，请联系管理员！",'ERROR');
        }

    }, "json");
}


function DataTableInit(settings){
    var defaultSettings = {
        bSort: false,
        bAutoWidth:false,
        serverSide: true, //服务端处理
        processing: true, //table在处理状态时显示友好信息
        //deferRender: true, //延迟渲染，可以提高初始化的速度
        stateSave: true, //保存状态
        searching: true,//关闭搜索
        ordering: false,//关闭排序
        //paginationType: full_numbers,//分页效果
        //lengthChange: false, //不可改变每页显示的大小
        displayLength: 10,//每页显示10条
        id:"#table",
        language: {
            /*汉化*/
            lengthMenu: "每页显示 _MENU_ 条记录",
            zeroRecords: "没有检索到数据",
            // info: "第 _START_ 条 到 _END_ 条用户&nbsp;&nbsp;&nbsp;共 _TOTAL_ 用户",
            info: "共 _TOTAL_ 个用户",
            infoEmpty: "没有数据",
            infoFiltered: ("从 _MAX_ 条记录过滤"),
            processing: "正在加载...",
            sSearch:"搜索",
            paginate: {
                first: "首页",
                last: "尾页",
                previous: "上一页",
                next: "下一页"
            }
        }
    }

    $.extend(defaultSettings,settings || {});

    $(defaultSettings.id).DataTable(defaultSettings);

}



