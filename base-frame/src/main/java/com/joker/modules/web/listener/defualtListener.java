package com.joker.modules.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjian
 * Date: 2015/8/28
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public class defualtListener implements ServletContextListener {

    /**
     * 启动容器时调用
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    /**
     * 容器销毁时调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
