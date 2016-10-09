package com.joker.modules.management.controller;

import com.joker.common.util.ViewUtil;
import com.joker.modules.management.exception.VerifyCodeException;
import com.joker.modules.management.info.RMSInfo;
import com.joker.modules.management.service.VerifyCodeService;
import com.joker.modules.management.view.ViewName;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhangjian
 * @Date 2015/10/22
 */
@RestController("RMSLoginController")
@RequestMapping("/admin/login")
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private VerifyCodeService verifyCodeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView loginUI(ModelAndView mav) {
        mav.setViewName(ViewUtil.getManagementPage("/login"));
        return mav;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, ModelAndView mav) {

        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            mav.setViewName(ViewUtil.getManagementRedirect(ViewName.DASHBOARD));
            return mav;
        }else {
            mav.setViewName(ViewUtil.getManagementPage(ViewName.LOGIN));
            mav.addObject("message", "用户名或者密码错误,请重新输入");
        }
        return mav;

    }

    @RequestMapping(value = "/verifycode", method = RequestMethod.GET)
    public void verifycode(HttpServletResponse response) throws IOException, VerifyCodeException {
        String verifyCode = verifyCodeService.getCode(4);

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute(RMSInfo.MANAGEMENT_VERIFYCODE_NAME, verifyCode.toLowerCase());

        verifyCodeService.outImage(response, verifyCode, 100, 46);

    }

    @ResponseBody
    @RequestMapping(value = "/verifycode", method = RequestMethod.POST)
    public boolean matchVerifycode(HttpServletRequest request, HttpServletResponse response, @RequestParam String verifyCode) throws IOException {

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        String sessionVerifyCode = (String) session.getAttribute(RMSInfo.MANAGEMENT_VERIFYCODE_NAME);
        logger.info("[输入验证码:" + verifyCode + "] [session 验证码：" + sessionVerifyCode + "]");
        return sessionVerifyCode.equalsIgnoreCase(verifyCode);

    }


}
