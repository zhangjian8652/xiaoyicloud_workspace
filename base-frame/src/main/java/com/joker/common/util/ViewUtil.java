package com.joker.common.util;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhangjian
 * @Date 2015/10/21
 */
public class ViewUtil {

    private static Logger logger = Logger.getLogger(ViewUtil.class);
    private static final String MANAGEMENT_PAGE = "/management/views";
    private static final String MANAGEMENT_MAPPING = "/admin";
    private static final String WEB_PAGE = "/web/views";
    public static String getManagementPage(String pagePath) {
            return MANAGEMENT_PAGE + addSlash(pagePath);
    }
    public static String getManagementRedirect(String pagePath) {
            return "redirect:" + MANAGEMENT_MAPPING + addSlash(pagePath);
    }

    public static String getManagementMappingName(String mapping){
        return MANAGEMENT_MAPPING + addSlash(mapping);
    }


    private static String addSlash(String path) {
        if(path == null || path.startsWith("/")){
                return path;
        }else {
            return "/" + path;
        }
    }

    public static String getWebPage(String webPagePath){
        return WEB_PAGE + addSlash(webPagePath);
    }


    public static void forwardToManageMentView(String viewPath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewname = MANAGEMENT_PAGE + viewPath;
        logger.debug("用户登陆成功forard到 ; " + viewname);
        request.getRequestDispatcher(viewname).forward(request,response);
    }
}
