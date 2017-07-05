package string;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangjian on 2016/10/10.
 */
public class StringTest {

    @Test
    public void testStringBuilder() {

        String str = "aaaa";

        int len = str.length();

        char[] value = new char[6];

        value[0] = 'b';
        value[1] = 'c';


        str.getChars(0, len, value, 2);


        System.out.println(value);


        //测试字符串拼接耗时
        long start, end;
        int time = 10000000;


      /*  start = System.currentTimeMillis();

        String startStr = "";
        for (int i = 0; i < time; i++) {
            startStr += "abcdefg";
        }
         end = System.currentTimeMillis();
        System.out.println(end - start);*/


        //不定义容量大小
        start = System.currentTimeMillis();
        String sbString = "asdvad";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < time; i++) {
            sb.append(sbString);
        }

        end = System.currentTimeMillis();

        System.out.println(end - start);

        //定义容量大小
        start = System.currentTimeMillis();
        String sbString2 = "asdvad";
        StringBuilder sb2 = new StringBuilder(sbString2.length() * time);

        for (int i = 0; i < time; i++) {
            sb2.append(sbString2);
        }
        end = System.currentTimeMillis();

        System.out.println(end - start);

    }


    @Test
    public void testStringBuffer() {
        //测试字符串拼接耗时

        long start, end;
        int time = 10000000;

    /*    start = System.currentTimeMillis();

        String startStr = "";
        for (int i = 0; i < time; i++) {
            startStr += "abcdefg";
        }
         end = System.currentTimeMillis();
        System.out.println(end - start);*/


        //不定义容量大小
        start = System.currentTimeMillis();
        String sbString = "asdvad";
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < time; i++) {
            sb.append(sbString);
        }

        end = System.currentTimeMillis();

        System.out.println(end - start);

        //定义容量大小
        start = System.currentTimeMillis();
        String sbString2 = "asdvad";
        StringBuffer sb2 = new StringBuffer(sbString2.length() * time);

        for (int i = 0; i < time; i++) {
            sb2.append(sbString2);
        }

        end = System.currentTimeMillis();

        System.out.println(end - start);
    }


    @Test
    public void testConcat() {

        char[] target = new char[10];
        String str = "hello";

        str.getChars(0, str.length(), target, 0);

        System.out.println(new String(target));

        str = str.concat("hella");

        System.out.println(str);
    }


    @Test
    public void test2() {

        String a = "aaaaaa";

        String b = a;


        chang(b);
        System.out.println(a);

    }

    public void chang(String string) {
        string = "change";
    }


    @Test
    public void testEndsWith() {
        System.out.println("".endsWith("p_reg"));
    }


    @Test
    public void testEqualsObjectToString() {
        Map<String, Object> map = new HashMap<>();

        map.put("a", "hhhhh,aaaa!");


        System.out.println("hhhhh,aaaa!".equals(map.get("a")));


    }


    @Test
    public void testStringConcat() {
        String s1 = "ab";

        String s2 = "a" + "b";

        String s3 = "a";

        String s4 = "b";

        String s5 = s3 + s4;

        System.out.println(s5 == s2);
        System.out.println(s1 == s2);
    }




    @Test
    public void testStringSplit() throws IOException {

        InputStream is = StringTest.class.getClassLoader().getResourceAsStream("data.txt");

        byte[] buf = new byte[1024];
        int len = 0;

        String data = "";


        while ((len = is.read(buf)) >0){
            data += new String(buf, 0, len);
        }

        String[] sts = data.split(System.getProperty("line.separator"));

        for (int i = 0; i < sts.length; i++) {
            if (null != sts[i] && !"".equalsIgnoreCase(sts[i])) {
                System.out.println(sts[i]);
            }else {
                System.out.println("==================");
            }

        }


    }

}
