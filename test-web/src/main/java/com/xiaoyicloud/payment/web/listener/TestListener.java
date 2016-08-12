package com.xiaoyicloud.payment.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by zhangjian on 2016/8/11.
 */
public class TestListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("==============================================================");
        System.out.println("在中文乱码。。。");
        System.out.println("=================================================");
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
