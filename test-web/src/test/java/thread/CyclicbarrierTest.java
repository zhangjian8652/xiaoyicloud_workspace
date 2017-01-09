package thread;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangjian on 2016/8/22.
 */
public class CyclicbarrierTest {

    @Test
    public void test() throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            public void run() {
                System.out.println("ok,开始工作");
            }
        });



        new BarrierThreadAwait(barrier).start();
        Thread.sleep(10000);
        System.out.println(barrier.getNumberWaiting());
        new BarrierThreadAwait(barrier).start();

        String s = "";


    }


}
