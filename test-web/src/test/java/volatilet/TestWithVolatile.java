package volatilet;

/**
 * @Author zhangjian
 * @Date 2017/3/8
 * @Copyright:
 * @Describe:
 */
public class TestWithVolatile {
    private static volatile boolean bChanged;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {

            @Override
            public void run() {
                for (;;) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread-1 is:" + bChanged);
                }
            }
        }.start();

        new Thread() {

            @Override
            public void run() {
                for (;;) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread-2 is:" + bChanged);
                }
            }
        }.start();

        new Thread() {

            @Override
            public void run() {
                for (;;) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread-3 is:" + bChanged);
                }
            }
        }.start();


        Thread.sleep(1);
        new Thread() {

            @Override
            public void run() {
                for (;;) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bChanged = !bChanged;
                    System.out.println("change to :" + bChanged);
                }
            }
        }.start();
    }

}
