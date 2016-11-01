package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by zhangjian on 2016/10/20.
 */

@RestController
public class TestController {

    @RequestMapping("/token")
    @ResponseBody
    public String testAction(HttpServletRequest request) throws IOException {


        Enumeration<String> names = request.getParameterNames();

        while(names.hasMoreElements()){
            System.out.println(request.getParameter(names.nextElement()));
        }

        return request.getParameter("echostr");
    }

    @RequestMapping("/freemarker")
    public ModelAndView testAction(ModelAndView modelAndView) throws IOException {
        modelAndView.addObject("test", "freemarker");
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
