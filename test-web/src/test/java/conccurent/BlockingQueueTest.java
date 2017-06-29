package conccurent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Author: zhangjian
 * Date :2017/6/19.
 * Des:
 */
public class BlockingQueueTest {

    @Test
    public void testArrayBlockingQueue() throws InterruptedException {
        BlockingQueue<String> strQue = new ArrayBlockingQueue<String>(10);
        for (int i = 0; i < 10; i++) {
            System.out.println("add method:" + strQue.add(i + 1 + ""));
        }
        System.out.println("add method:" + strQue.offer("11"));

        new Thread(()->{
            System.out.println(strQue.remove("1"));
            try {
                System.out.println(strQue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(strQue.poll());
        }).start();
        strQue.put("12");



    }


    @Test
    public void testDelayQueue() {
        BlockingQueue<DelayedElement> queue = new DelayQueue<DelayedElement>();
    }


    class DelayedElement implements Delayed {

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }

}
