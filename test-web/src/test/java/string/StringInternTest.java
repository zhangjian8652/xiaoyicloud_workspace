package string;

import org.junit.Test;

/**
 * Author: zhangjian
 * Date :2017/6/13.
 * Des:
 */
public class StringInternTest {

    @Test
    public void test1() {
        String s = "a";
        String i = s.intern();
        System.out.println(s == i);

    }
}
