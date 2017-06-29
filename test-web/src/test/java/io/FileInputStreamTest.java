package io;

import org.junit.Test;

import java.io.*;

/**
 * Author: zhangjian
 * Date :2017/6/26.
 * Des:
 */
public class FileInputStreamTest {


    @Test
    public void test1() throws IOException {
        File file = new File("D:\\data2.txt");
        File file2 = new File("D:\\data3.txt");

        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file2);

        byte[] buffers = new byte[1024 * 1024];

        int len = 0;
        while ((len = fis.read(buffers)) > 0) {
            fos.write(buffers, 0, len);
        }

        fis.close();
        fos.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

}
