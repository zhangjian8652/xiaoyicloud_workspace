package time;

import org.junit.Test;

/**
 * Created by zhangjian on 2016/11/2.
 */
public class TimeTest {

    @Test
    public void test1(){
        String date = TimeUtil.getCurrentDatetime(TimeUtil.TimeFormat.LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH);
        System.out.println(date);
    }
}
