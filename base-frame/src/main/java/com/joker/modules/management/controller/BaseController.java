package com.joker.modules.management.controller;

import com.joker.common.util.ViewUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author zhangjian
 * @Date 2015/11/17
 */
public class BaseController {

    @ExceptionHandler({Exception.class})
    public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex){
        return new ModelAndView(ViewUtil.getManagementPage("/500")) ;
    }

}
