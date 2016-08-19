import com.joker.module.payment.wechat.domain.WechatPayResult;
import com.joker.module.payment.wechat.util.WechatPaymentUtil;
import org.junit.Test;

/**
 * Created by zhangjian on 2016/8/19.
 */
public class WechatPaymentTest {

    @Test
    public void testNotifyXMLDataParse() {
        String data = "<xml><appid><![CDATA[wx9ba36613cc2989c5]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><device_info><![CDATA[WEB]]></device_info><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1371352602]]></mch_id><nonce_str><![CDATA[f8fc611a7b4547df94f0eb567b93c53c]]></nonce_str><openid><![CDATA[os42NwEpgaH6yqsIeJ9GCchWMaOg]]></openid><out_trade_no><![CDATA[16081911103562248951]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[7E145343A7F8A67105210A62B8426968]]></sign><time_end><![CDATA[20160819111058]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4007122001201608191697410716]]></transaction_id></xml><xml><appid><![CDATA[wx9ba36613cc2989c5]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><device_info><![CDATA[WEB]]></device_info><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1371352602]]></mch_id><nonce_str><![CDATA[f8fc611a7b4547df94f0eb567b93c53c]]></nonce_str><openid><![CDATA[os42NwEpgaH6yqsIeJ9GCchWMaOg]]></openid><out_trade_no><![CDATA[16081911103562248951]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[7E145343A7F8A67105210A62B8426968]]></sign><time_end><![CDATA[20160819111058]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4007122001201608191697410716]]></transaction_id></xml>";
        WechatPayResult wechatPayResult = WechatPaymentUtil.parseNotifyXmlData(data);
        System.out.println(wechatPayResult.toString());
    }


    @Test
    public void testWechatReturnSign() {
        String data = "<xml><appid><![CDATA[wx9ba36613cc2989c5]]></appid>" +
                "<bank_type><![CDATA[CFT]]></bank_type>" +
                "<cash_fee><![CDATA[1]]></cash_fee>" +
                "<device_info><![CDATA[WEB]]></device_info>" +
                "<fee_type><![CDATA[CNY]]></fee_type>" +
                "<is_subscribe><![CDATA[Y]]></is_subscribe>" +
                "<mch_id><![CDATA[1371352602]]></mch_id>" +
                "<nonce_str><![CDATA[f8fc611a7b4547df94f0eb567b93c53c]]></nonce_str>" +
                "<openid><![CDATA[os42NwEpgaH6yqsIeJ9GCchWMaOg]]></openid>" +
                "<out_trade_no><![CDATA[16081911103562248951]]></out_trade_no>" +
                "<result_code><![CDATA[SUCCESS]]></result_code>" +
                "<return_code><![CDATA[SUCCESS]]></return_code>" +
                "<sign><![CDATA[7E145343A7F8A67105210A62B8426968]]></sign>" +
                "<time_end><![CDATA[20160819111058]]></time_end>" +
                "<total_fee>1</total_fee>" +
                "<trade_type><![CDATA[JSAPI]]></trade_type>" +
                "<transaction_id><![CDATA[4007122001201608191697410716]]></transaction_id>" +
                "</xml>";
        WechatPayResult wechatPayResult = WechatPaymentUtil.parseNotifyXmlData(data);

        boolean result = WechatPaymentUtil.checkNotifyUrlSign(wechatPayResult,"9tBWQxPYIfZEHOSKAZuGY2UBQyWlTq8l");
        System.out.println(result);
    }
}
