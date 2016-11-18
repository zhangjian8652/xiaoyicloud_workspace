import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhangjian on 2016/8/16.
 */
public class JWTTest {
    @Test
    public void test1() throws UnsupportedEncodingException {

        String str = "我是中国ABCDRFG";

        char[] chars = new char[str.length()];
        str.getChars(0, str.length(), chars, 0);

        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        float f = 3;


        String str1 = new String("中".getBytes("utf-8"), "iso-8859-1");
        System.out.println(str1);

        String str2 = new String(str1.getBytes("iso-8859-1"), "utf-8");
        System.out.println(str2);
    }


    public boolean isTrue() {
        return true;
    }


    public void split(String source, int num) {
        int k = 0;
        String temp = "";

        for (int i = 0; i < source.length(); i++) {
            byte[] b = (source.charAt(i) + "").getBytes();
            k += b.length;
            if (k > num) {
                break;
            }

            temp += source.charAt(i);
        }

        System.out.println(temp);

    }
}

interface A{

}


interface B{}

interface C extends A,B{

}