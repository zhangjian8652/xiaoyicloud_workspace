package reg;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangjian on 2017/1/13.
 */
public class PatternTest {


    @Test
    public void test1(){

        String reg = "\\d+";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher("aaa2223bba345ab");

        String result = matcher.replaceAll("");

        System.out.println(result);

    }


    /**
     * 测试matchs 方法
     */
    @Test
    public void test2(){
        System.out.println(Pattern.matches("^[a-z]*$","abcdaa22"));
    }


    /**
     * 测试pattern split
     */
    @Test
    public void test3(){

        Pattern pattern = Pattern.compile("[,| ]+");
        String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");

        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    @Test
    public void test4(){
        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        String string = matcher.replaceAll("");
        System.out.println(string);
    }

}
