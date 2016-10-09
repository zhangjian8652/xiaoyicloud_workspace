package com.joker.modules.management.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author zhangjian
 * @Date 2015/10/31
 */
public interface VerifyCodeService {

    /**
     * 获取随机码
     * @param length 随机码长度
     * @return 随机字符串
     */
    String getCode(int length);

    /**
     * Servlet输出图片
     * @param response response对象
     * @param code 随机码
     * @param width 图片宽
     * @param height 图片高
     * @return 成功与否，成功为true 失败为false
     */
    boolean outImage(HttpServletResponse response, String code, int width, int height);

    /**
     * 验证验证码是否匹配
     * @param inputCode 用户输入验证
     * @param sessionCode session中的验证码
     * @return
     */
    boolean matchVerifyCode(String inputCode, String sessionCode);

}
