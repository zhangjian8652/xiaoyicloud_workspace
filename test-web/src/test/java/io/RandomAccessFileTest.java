package io;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Author: zhangjian
 * Date :2017/6/26.
 * Des:
 */
public class RandomAccessFileTest {

    @Test
    public void test1() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\data2.txt", "rw");
        RandomAccessFile randomAccessFile2 = new RandomAccessFile("D:\\data3.txt", "rw");

        long start = System.currentTimeMillis();
        byte[] buffers = new byte[1024 * 1024];
        int len = 0;
        while ((len = randomAccessFile.read(buffers)) > 0){
            randomAccessFile2.write(buffers, 0, len);
        }

        randomAccessFile.close();
        randomAccessFile2.close();
        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }


    @Test
    public void test2() throws IOException {
        int length = 0x8000000; // 128 Mb
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\data2.txt", "rw");
        MappedByteBuffer mappedByteBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);

        //写128M的内容
        for (int i = 0; i < length; i++) {
            mappedByteBuffer.put((byte) 'x');
        }
        System.out.println("Finished writing");
        //读取文件中间6个字节内容
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.print((char) mappedByteBuffer.get(i));
        }
        randomAccessFile.close();

    }

}
