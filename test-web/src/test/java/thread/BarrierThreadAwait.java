package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangjian on 2016/8/22.
 */
public class BarrierThreadAwait extends Thread {

    private CyclicBarrier barrier;
    public BarrierThreadAwait(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            System.out.println("aaa");
            barrier.await();
            System.out.println("bbb");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
