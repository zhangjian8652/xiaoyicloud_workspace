package com.xiaoyicloud.payment.web.servlet;


import com.joker.module.payment.wechat.config.WechatPaymentConfig;
import com.joker.module.payment.wechat.domain.WechatPrePayOrder;
import com.joker.module.payment.wechat.domain.WechatUserAuth;
import com.joker.module.payment.wechat.exception.WechatServiceException;
import com.joker.module.payment.wechat.service.WechatPaymentService;
import com.joker.module.payment.wechat.service.impl.WechatPaymentServiceImpl;
import com.joker.module.payment.wechat.util.CommonUtil;
import com.joker.module.payment.wechat.util.WechatPaymentUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangjian on 2016/7/25.
 */
public class WechatPayOrder extends HttpServlet {

    private Logger logger = LogManager.getLogger(WechatPayOrder.class);
    private WechatPaymentService wechatPaymentService = new WechatPaymentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WechatUserAuth wechatUserAuth = (WechatUserAuth) req.getSession().getAttribute(WechatPaymentConfig.WECHAT_USER_AUTH_SESSION_KEY);

        if (wechatUserAuth == null) {
            return;
        }
        logger.debug("session 中的微信认证数据 :" + wechatUserAuth.toString());

        WechatPrePayOrder prePayOrder = null;

        try {
            prePayOrder = wechatPaymentService.generateOpenPrePayOrder(1, "商品购买", WechatPaymentUtil.generateOuteTradeNo("XY"), wechatUserAuth.getOpenid(), "http://zhangjian.iok.la/wechat/payment/test/open/payresult", CommonUtil.getIpAddr(req));
            //wechatPaymentService.generateURLPrePayOrder(1, "商品购买", "productId", "2016081211", "http://zhangjian.iok.la/wechat/payment/test/open/payresult", CommonUtil.getIpAddr(req));
        } catch (WechatServiceException e) {
            e.printStackTrace();
        }



        if(prePayOrder == null){
            return;
        }
        logger.debug("创建的prepay order :" + prePayOrder.toString());

        String h5PayJson = WechatPaymentUtil.generateH5PayJson(prePayOrder);

        logger.debug("h5 json 为 :" + h5PayJson);

        req.setAttribute("h5PayJson",h5PayJson);

        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }

}
