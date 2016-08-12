<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>aa</title>
    <script type="text/javascript">
        function onBridgeReady() {
            WeixinJSBridge.invoke(
                    'getBrandWCPayRequest', <%= request.getAttribute("h5PayJson")%>,
                    function (res) {
                        alert(JSON.stringify(res));
                        document.getElementById("result").text = JSON.stringify(res);
                        if (res.err_msg == "get_brand_wcpay_request：ok") {
                            document.getElementById("result").innerHTML = "付款成功"
                        }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                    }
            );
        }
        if (typeof WeixinJSBridge == "undefined") {
            if (document.addEventListener) {
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            } else if (document.attachEvent) {
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        } else {
            onBridgeReady();
        }
    </script>
</head>
<body>
触发付款页面
<div id="result">

</div>
</body>
</html>
