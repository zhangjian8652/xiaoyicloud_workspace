import com.joker.module.qrcode.util.QrcodeUtils;
import org.junit.Test;

import java.io.File;

/**
 * Created by zhangjian on 2016/8/27.
 */
public class TestQRUtils {

    @Test
    public void test1() throws Exception {

        QrcodeUtils.gen("weixin://wxpay/bizpayurl?pr=GaedVAD",new File("D://tmp.jpg"),new File("D://logo.png"),400,400);
    }
}
