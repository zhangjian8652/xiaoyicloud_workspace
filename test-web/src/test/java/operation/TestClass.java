package operation;

import org.junit.Test;

/**
 * Created by zhangjian on 2016/9/19.
 */
public class TestClass {

    @Test
    public void test() {
        int i = 99;
        System.out.println(i >> 1);
    }


    @Test
    public void test2() {
        int i = 2;
        int k = 2;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(k));
        System.out.println(i >>> 2);
        System.out.println(k >> 2);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(k));

        System.out.println(1 | 2);
        System.out.println(1 & 2);
        System.out.println(1 ^ 2);
        System.out.println(~1);


        int c = 0;
        System.out.println(++c + c++);
    }
}
