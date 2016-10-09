package operator;

import org.junit.Test;

/**
 * Created by zhangjian on 2016/9/12.
 */
public class TestClass {

    @Test
    public void test1(){
        int a = 2;
        int b = 10;
        System.out.println(~a);
        System.out.println(a^b);
        System.out.println(Integer.toHexString(26));
        System.out.println(Integer.toOctalString(10));
        System.out.println(Integer.toBinaryString(10));

        int r = Integer.parseInt("1100110", 2);
        System.out.println(r);
    }
}
