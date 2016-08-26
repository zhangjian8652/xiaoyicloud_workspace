package nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * Created by zhangjian on 2016/8/22.
 */
public class NIOTest {

    @Test
    public void testWriteFile() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("D://nio.txt", "rw");

        FileChannel outChannel = aFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(30);

        String str = "我们都是中国人";
        buffer.clear();
        buffer.put(str.getBytes());
        buffer.flip();
        outChannel.write(buffer);
        outChannel.close();
        aFile.close();
    }


    @Test
    public void testReadFile() throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("D://nio.txt", "rw");

        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int len = 0;
        while ((len = inChannel.read(buffer)) > 0) {
            System.out.println(len);
            System.out.println(new String(buffer.array(),"utf-8"));
        }

        inChannel.close();
        aFile.close();

    }

    public void noneTest() throws IOException {
        Socket socket = new Socket();
        ServerSocket serverSocket = new ServerSocket(8180);
        serverSocket.accept();
        SelectableChannel serverChannel = serverSocket.getChannel();
        serverChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey key = serverChannel.register(selector, SelectionKey.OP_ACCEPT);

    }


    public void testSelector() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("D://nio.txt", "rw");

        FileChannel channel = aFile.getChannel();





    }

}
