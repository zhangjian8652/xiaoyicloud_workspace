import com.joker.module.payment.wechat.domain.WechatPrePayOrder;
import com.joker.module.payment.wechat.exception.WechatServiceException;
import com.joker.module.payment.wechat.service.WechatPaymentService;
import com.joker.module.payment.wechat.service.impl.WechatPaymentServiceImpl;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangjian on 2016/8/22.
 */
public class WechatPaymentServiceTest {


    @Test
    public void testURLOrder() throws WechatServiceException {
        WechatPaymentService wechatPaymentService = new WechatPaymentServiceImpl();

        String outTradeNo = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        WechatPrePayOrder wechatPrePayOrder = wechatPaymentService.generateURLPrePayOrder(1, "测试", "充值", outTradeNo, "http://zhangjian.iok.la/wechat/testopen/order", "182.148.29.231");

        System.out.println(wechatPrePayOrder.toString());

    }



    @Test
    public void testOpenPreOrder() throws WechatServiceException {
        WechatPaymentService wechatPaymentService = new WechatPaymentServiceImpl();
        WechatPrePayOrder wechatPrePayOrder = wechatPaymentService.generateOpenPrePayOrder(1, "商品购买", "16082502493539980412", "oR7Jls7DS9fhYcaqvjJZTzE-QHlU", "http://pweb.xiaoyicloud.cn/payment/gateway/ipn","10.172.42.1");
    }

    @Test
    public void testQRCodeURL() throws WechatServiceException, IOException {

        File file = new File("d://qrcode.jpg");
        OutputStream os = new FileOutputStream(file);

        WechatPaymentService wechatPaymentService = new WechatPaymentServiceImpl();

        String outTradeNo = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        wechatPaymentService.generateQRCodePrePayOrder(1, "测试", "充值", outTradeNo, "http://zhangjian.iok.la/wechat/testopen/order", "182.148.29.231",os);

        os.close();
    }

    @Test
    public void testQRCodeLogoURL() throws WechatServiceException, IOException {

        File file = new File("d://qrcode.jpg");
        OutputStream os = new FileOutputStream(file);

        WechatPaymentService wechatPaymentService = new WechatPaymentServiceImpl();

        String outTradeNo = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        wechatPaymentService.generateQRCodePrePayOrder(1, "测试", "充值", outTradeNo, "http://zhangjian.iok.la/wechat/testopen/order", "182.148.29.231",os,new FileInputStream("D://logo.png"));

        os.close();
    }
}

