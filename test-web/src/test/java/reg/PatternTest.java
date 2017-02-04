package reg;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangjian on 2017/1/13.
 */
public class PatternTest {


    @Test
    public void test1() {

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
    public void test2() {
        System.out.println(Pattern.matches("^[a-z]*$", "abcdaa22"));
    }


    /**
     * 测试pattern split
     */
    @Test
    public void test3() {

        Pattern pattern = Pattern.compile("[,| ]+");
        String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");

        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    @Test
    public void test4() {
        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        String string = matcher.replaceAll("");
        System.out.println(string);
    }


    /**
     * matcher 的方法测试
     */

    @Test
    public void test5() {
        Pattern pattern = Pattern.compile("[a-z]{1,4}[\\d]{2}[a-z]{2}");

        String str = "aa34aa222dddd4444";
        Matcher matcher = pattern.matcher(str);

    /*    boolean result = matcher.find();
        System.out.println(result);*/
        /*
        boolean result2 = matcher.matches();
        System.out.println(result2);*/

    /*    while (matcher.find()){
            int si = matcher.start();
            int ei = matcher.end();
            System.out.println(si + " " + ei);
            System.out.println(str.substring(si,ei));
        }*/

        while(matcher.find()){
            System.out.println(matcher.group());
        }



    }

    @Test
    public void test6(){
        Pattern p=Pattern.compile("([a-z]+)(\\d+)([a-z]+)");
        Matcher m=p.matcher("aaa2223bb");
        m.find();   //匹配aaa2223
        System.out.println(m.groupCount());   //返回2,因为有2组
        System.out.println(m.start(1));   //返回0 返回第一组匹配到的子字符串在字符串中的索引号
        System.out.println(m.start(2));   //返回3
        System.out.println(m.end(1));   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
        System.out.println(m.end(2));   //返回7
        System.out.println(m.group(1));   //返回aaa,返回第一组匹配到的子字符串
        System.out.println(m.group(2));   //返回2223,返回第二组匹配到的子字符串
    }


}
