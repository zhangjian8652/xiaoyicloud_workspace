package com.joker.modules.management.service.impl;

import com.joker.common.util.VerifyCodeUtil;
import com.joker.modules.management.service.VerifyCodeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhangjian
 * @Date 2015/10/31
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    private Logger logger = Logger.getLogger(VerifyCodeServiceImpl.class);
    @Override
    public String getCode(int length) {
        //生成随机字串
        String verifyCode = VerifyCodeUtil.generateVerifyCode(length);
        return verifyCode;
    }

    @Override
    public boolean outImage(HttpServletResponse response, String verifyCode, int width, int height) {

        //设置头信息
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        try {
            VerifyCodeUtil.outputImage(width, height, response.getOutputStream(), verifyCode);
        } catch (IOException e) {
           return false;
        }
        return true;
    }

    @Override
    public boolean matchVerifyCode(String inputCode, String sessionCode) {

        logger.debug("输入验证码：" + inputCode + "  session中的验证码" + sessionCode);
        if(inputCode == null || sessionCode == null){
            return  false;
        }

        if(!inputCode.equalsIgnoreCase(sessionCode)){
            return false;
        }

        return true;
    }
}
