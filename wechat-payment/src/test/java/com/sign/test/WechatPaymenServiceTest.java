package com.sign.test;

import com.xiaoyicloud.payment.weixin.pay.domain.WechatPrePayOrder;
import com.xiaoyicloud.payment.weixin.pay.exception.WechatServiceException;
import com.xiaoyicloud.payment.weixin.pay.service.WechatPaymentService;
import com.xiaoyicloud.payment.weixin.pay.service.impl.WechatPaymentServiceImpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangjian on 2016/8/11.
 */
public class WechatPaymenServiceTest {
    private WechatPaymentService wechatPaymentService = new WechatPaymentServiceImpl();

    @Test
    public void testURL() throws WechatServiceException {
        String outTradeNo = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        WechatPrePayOrder wechatPrePayOrder = wechatPaymentService.generateURLPrePayOrder(1,"测试",outTradeNo,"WX" + outTradeNo,"http://zhangjian.iok.la/wechat/testopen/order","192.168.2.163");
        System.out.println(wechatPrePayOrder.toString());
    }
}
