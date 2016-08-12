package com.xiaoyicloud.payment.weixin.pay.filter;

import com.xiaoyicloud.payment.weixin.pay.config.WechatPaymentConfig;
import com.xiaoyicloud.payment.weixin.pay.domain.WechatUserAuth;
import com.xiaoyicloud.payment.weixin.pay.exception.WechatServiceException;
import com.xiaoyicloud.payment.weixin.pay.service.WechatPaymentService;
import com.xiaoyicloud.payment.weixin.pay.service.impl.WechatPaymentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangjian on 2016/8/9.
 */
public class WechatPaymentFilter implements Filter {

    private static Logger logger = LogManager.getLogger(WechatPaymentFilter.class);
    private String openAccountAuthURI ;
    private String openAccountAuthResult;
    private String afterAuthURI;

    private static final WechatPaymentService wechatPaymentService = new WechatPaymentServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.openAccountAuthURI = filterConfig.getInitParameter("openAccountAuthURI");
        this.openAccountAuthResult = filterConfig.getInitParameter("openAccountAuthResult");
        this.afterAuthURI = filterConfig.getInitParameter("afterAuthResultURI");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String requestURI = req.getRequestURI();
        String webPath = "http://"+ request.getServerName() + req.getContextPath();
        webPath = webPath.substring(0,webPath.length());

        if (requestURI.equals(this.openAccountAuthURI)) {

            String redirectUrl = null;
            try {
                redirectUrl = wechatPaymentService.generateGetCodeURL(webPath + this.openAccountAuthResult);
            } catch (WechatServiceException e) {
                e.printStackTrace();
            }

            resp.sendRedirect(redirectUrl);
            return;
        }


        if (requestURI.equals(this.openAccountAuthResult)) {
            String code = request.getParameter("code");
            String state = request.getParameter("state");

            WechatUserAuth wechatUserAuth = null;
            try {
                wechatUserAuth = wechatPaymentService.getWechatUserAuth(code);
            } catch (WechatServiceException e) {
                e.printStackTrace();
            }

            req.getSession().setAttribute(WechatPaymentConfig.WECHAT_USER_AUTH_SESSION_KEY,wechatUserAuth);


        }

        resp.sendRedirect(afterAuthURI);
        return;

    }

    @Override
    public void destroy() {

    }


}
