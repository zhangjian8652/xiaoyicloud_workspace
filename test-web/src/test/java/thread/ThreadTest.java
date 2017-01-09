package thread;

import org.junit.Test;

/**
 * Created by zhangjian on 2016/12/21.
 */
public class ThreadTest {

    @Test
    public void test1(){


        Thread t1 = new Thread(()->{

                synchronized (this){
                    System.out.println("before t1 waite");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("after t1 waite");
                }

        });



        Thread t3 = new Thread(()->{

            synchronized (this){
                System.out.println("before t3 waite");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after t3 waite");
            }

        });

        Thread t2 = new Thread(()->{

                synchronized (this){
                    System.out.println("before notify");
                    this.notifyAll();
                    System.out.println("after notify");
                }

        });


        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void test2() throws InterruptedException {
        Thread t = new Thread(()->{

            try {
                System.out.println("sleep");
                Thread.sleep(10000);
                System.out.println("continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        t.start();

        Thread.sleep(1000);

        t.join();

        System.out.println("after join");

    }
}
