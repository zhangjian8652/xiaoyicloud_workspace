import com.joker.module.shortlongurl.domain.WechatToken;
import com.joker.module.shortlongurl.generator.WechhatURLGenerator;
import com.joker.module.shortlongurl.thread.TokenVindicator;
import org.junit.Test;

/**
 * Created by zhangjian on 2016/8/28.
 */
public class TokenTest {
    @Test
    public void TestWechatLong2Short() {
       String url =  WechhatURLGenerator.long2Short("weixin://wxpay/bizpayurl?pr=rvAxUtV");
        System.out.println(url);
    }

    public static void main(String[] args) {
        final TokenVindicator vindicator = new TokenVindicator();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    WechatToken token = vindicator.getWechatToken();
                    System.out.println(token.getExpiresIn());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        thread.start();
        System.out.println(thread.getState());
    }
}
