package guava;

import com.google.common.base.CharMatcher;
import org.junit.Test;

/**
 * Created by zhangjian on 2016/10/25.
 */
public class CharMatcherTest {

    @Test
    public void test1() {

        String string = " aaacontAAArole3332aaaa ";
        String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(string); //移除control字符
        System.out.println(noControl);
        String theDigits = CharMatcher.DIGIT.retainFrom(string); //只保留数字字符
        System.out.println(theDigits);
        String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' ');//去除两端的空格，并把中间的连续空格替换成单个空格
        System.out.println(spaced);
        String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*"); //用*号替换所有数字
        System.out.println(noDigits);
        String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string);// 只保留数字和小写字母
        System.out.println(lowerAndDigit);

    }
}
