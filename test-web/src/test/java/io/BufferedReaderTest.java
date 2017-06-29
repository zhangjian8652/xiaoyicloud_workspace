package io;

import org.junit.Test;

import java.io.*;

/**
 * Author: zhangjian
 * Date :2017/6/26.
 * Des:
 */
public class BufferedReaderTest {

    @Test
    public void test1() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\data.txt"),"GBK");
        BufferedReader bufferedReader = new BufferedReader(isr);

        String str = "";

        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }

        bufferedReader.close();
        isr.close();

    }
}
