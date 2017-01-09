package thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangjian on 2016/12/21.
 */
public class DemoTest {


    @Test
    public void test1() throws InterruptedException {

        int arrs[] = new int[]{1, 2, 3, 4, 5, 67};
        int arrs2[] = new int[]{1, 4, 3, 111, 12, 67};

        List<Integer> results =new ArrayList<>();

        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(new CountaskRunnale(countDownLatch, results, arrs));
        Thread t2 = new Thread(new CountaskRunnale(countDownLatch, results, arrs2));

        t1.start();
        t2.start();

        countDownLatch.await();



        for (int i = 0; i < results.size(); i++) {
            Integer integer =  results.get(i);
            System.out.println(integer);
        }

    }


    @Test
    public void test2() {
        int arrs[] = new int[]{1, 2, 3, 4, 5, 67};
        int arrs2[] = new int[]{1, 4, 3, 111, 12, 67};

        List<Integer> results =new ArrayList<>();

        Thread t1 = new Thread(new CountTaskRunnable2(results, arrs));
        Thread t2 = new Thread(new CountTaskRunnable2( results, arrs2));

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < results.size(); i++) {
            Integer integer =  results.get(i);
            System.out.println(integer);
        }

    }
}

class CountaskRunnale implements Runnable {

    private CountDownLatch latch;
    private List<Integer> results;
    private int[] arrs;


    /**
     *
     * @param latch 用于通知该线程已经完成
     * @param results 存放该线程执行完的数据
     * @param arrs
     */
    public CountaskRunnale(CountDownLatch latch, List<Integer> results, int[] arrs) {
        this.latch = latch;
        this.results = results;
        this.arrs = arrs;
    }

    @Override
    public void run() {

        int retmp = 0;

        for (int i = 0; i < arrs.length; i++) {
            retmp += arrs[i];
        }

        results.add(retmp);

        latch.countDown();
    }
}

class CountTaskRunnable2 implements Runnable{



    private List<Integer> results;
    private int[] arrs;


    /**
     *
     * @param results 存放该线程执行完的数据
     * @param arrs
     */
    public CountTaskRunnable2(List<Integer> results, int[] arrs) {
        this.results = results;
        this.arrs = arrs;
    }

    @Override
    public void run() {

        int retmp = 0;

        for (int i = 0; i < arrs.length; i++) {
            retmp += arrs[i];
        }

        results.add(retmp);

    }
}



