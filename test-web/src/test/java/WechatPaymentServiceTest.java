import com.joker.module.payment.wechat.domain.WechatPrePayOrder;
import com.joker.module.payment.wechat.exception.WechatServiceException;
import com.joker.module.payment.wechat.service.WechatPaymentService;
import com.joker.module.payment.wechat.service.impl.WechatPaymentServiceImpl;
import org.junit.Test;

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

        WechatPrePayOrder wechatPrePayOrder = wechatPaymentService.generateURLPrePayOrder(1,"测试","充值",outTradeNo,"http://zhangjian.iok.la/wechat/testopen/order","182.148.29.231");

        System.out.println(wechatPrePayOrder.toString());

    }
}
