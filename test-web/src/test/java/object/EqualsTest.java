package object;

import org.junit.Test;

/**
 * Author: zhangjian
 * Date :2017/6/13.
 * Des:
 */
public class EqualsTest {

    @Test
    public void test1() {
        System.out.println(3*0.1 == 0.3);
    }


    @Test
    public void test2() {
        String s = "a" + "b";
        String t = "ab";

        System.out.println(s.equals(t));
        System.out.println(s == t);

        System.out.println(s.hashCode());
        System.out.println(t.hashCode());

    }
}
