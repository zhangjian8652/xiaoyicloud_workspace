package thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangjian on 2016/12/21.
 */
public class CountDownLatchTest {

    @Test
    public void test() throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);


        Thread t1 = new Thread(new RunnableImp(1, countDownLatch));
        Thread t2 = new Thread(new RunnableImp(2, countDownLatch));

        t1.start();
        t2.start();

        countDownLatch.await();

        System.out.println("finished threads.");
    }
}


class RunnableImp implements Runnable{

    private int id;
    private CountDownLatch latch;

    public RunnableImp(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finish" + id);
        latch.countDown();
    }
}
