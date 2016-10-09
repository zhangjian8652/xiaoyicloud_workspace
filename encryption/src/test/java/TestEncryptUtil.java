import com.joker.common.encrypt.util.EncryptUtil;
import org.junit.Test;

/**
 * Created by zhangjian on 2016/9/12.
 */
public class TestEncryptUtil {

    private static String password = "admin";

    @Test
    public void testMD5(){
        System.out.println("password = [" + password + "]");
        System.out.println("MD5 = [" + EncryptUtil.MD5(password) + "]");
        System.out.println("MD5 = [" + EncryptUtil.MD5(password) + "]");
    }

    @Test
    public void testSHA_1(){
        String salt = EncryptUtil.getSalt();
        System.out.println("SHA1 = [" + EncryptUtil.SHA_1(password, salt) + "]");
        System.out.println("SHA1 = [" + EncryptUtil.SHA_1(password, salt) + "]");
    }

    @Test
    public void testSHA_256(){
        String salt = EncryptUtil.getSalt();
        System.out.println("SHA_256 = [" + EncryptUtil.SHA_256(password, salt) + "]");
        System.out.println("SHA_256 = [" + EncryptUtil.SHA_256(password, salt) + "]");
    }
}
