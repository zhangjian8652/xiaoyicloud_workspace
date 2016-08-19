import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.joker.module.payment.wechat.domain.WechatUserAuth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by zhangjian on 2016/8/10.
 */

public class OrderTransferTest {

    private static Logger logger = LogManager.getLogger(OrderTransferTest.class);

    @Test
    public void testMapper() throws IOException {
        String data = "{\"access_token\":\"bvVk9JjC0hHFo5VAYBmNbtTo1XMzAlPzTiST4-Xaz8XXsepiO8hZ2ZCylwVX2e1CLIpHO3G-V8PYTEL1F70ELqhY4fdhPJa3e5eYkvLmeig\",\"expires_in\":7200,\"refresh_token\":\"_2iA4HZ8ibUPxeUtL-y4vb4PlUh1XPz_53_V6rar4S9PuQx3S8NnoR5Od5Lrcb7l7wLxbR5B1s0xBqYl5EeJ0yZjPuD1PvVHHmlxkMsbXpk\",\"openid\":\"os42NwH4kriaJOBeK9PaoUgYngkE\",\"scope\":\"snsapi_userinfo\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

        WechatUserAuth userAuth = objectMapper.readValue(data, WechatUserAuth.class);
    }


    @Test
    public void testLog4jEncoding() throws UnsupportedEncodingException {
        logger.debug("你好");
        String a = "忙聰炉盲禄聵氓驴聟茅隆禄盲录聽";
        logger.debug(a);
    }


    @Test
    public void testResourcesRead() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("wechat_payment.properties"));
    }


}