package conccurent;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * Author: zhangjian
 * Date :2017/6/20.
 * Des:
 */
public class SemaphoreTest {

    final Semaphore semaphore = new Semaphore(1);

    @Test
    public void test1() throws InterruptedException {

        new Thread(()->{
            try {
                reading();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                reading();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                reading();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        while (true) {
            Thread.sleep(1000);
        }

    }


    void reading() throws InterruptedException {
        semaphore.acquire();
        System.out.println("reading");
        Thread.sleep(10000);
        semaphore.release();
    }

    public static void main(String[] args) {
        for (;;) {
            System.out.println("aaa");
        }
    }
}
