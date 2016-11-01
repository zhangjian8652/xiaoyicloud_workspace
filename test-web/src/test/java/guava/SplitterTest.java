package guava;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by zhangjian on 2016/10/26.
 */
public class SplitterTest {

    @Test
    public void test1(){
        String str = "aa,bb,,vvv, sss";

        List<String> result = Lists.newArrayList(Splitter.on(",").omitEmptyStrings().trimResults().split(str));

        for (String s : result) {
            System.out.println(s);
        }
    }
}
