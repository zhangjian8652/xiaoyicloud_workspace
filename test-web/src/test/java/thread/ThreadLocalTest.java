package thread;

import org.junit.Test;

/**
 * Created by zhangjian on 2016/11/2.
 */
public class ThreadLocalTest {

    @Test
    public void test1(){
        ThreadLocal<String> a = new ThreadLocal<String>();
        a.set("hello");
        a.get();
    }
}
