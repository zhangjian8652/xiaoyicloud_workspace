package guava;

import com.google.common.base.Joiner;
import org.junit.Test;

/**
 * Created by zhangjian on 2016/10/25.
 */
public class JoinerTest {

    @Test
    public void test1(){
        Joiner joiner = Joiner.on("*").skipNulls();
        System.out.println(joiner.join("a","b","c","d"));
        System.out.println(joiner.join("a",null,"c","d"));
    }


    @Test
    public void test2(){
        Joiner joiner = Joiner.on("*").useForNull("i'm null");
        System.out.println(joiner.join("a","b","c","d"));
        System.out.println(joiner.join("a",null,"c","d"));

        Object[] strArr = {"a", 1, null, "", 3.33};
        System.out.println(joiner.join(strArr));

    }


}
