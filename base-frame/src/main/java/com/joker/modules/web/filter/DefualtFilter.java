package com.joker.modules.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjian
 * Date: 2015/8/28
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
public class DefualtFilter implements Filter {

    /**
     * Filter实例化进行初始化的回调方法。
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Filter过滤器处理方法。
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     * Filter在释放时回调的方法。
     */
    @Override
    public void destroy() {
    }
}
