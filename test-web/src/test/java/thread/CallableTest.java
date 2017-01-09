package thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhangjian on 2016/12/21.
 */
public class CallableTest {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();


        for (int i = 0; i<10 ;i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        Thread.sleep(2000);

        for (int i = 0; i < results.size(); i++) {
            Future<String> f = results.get(i);

            if (f.isDone()) {
                System.out.println(f.get());
            }else {
                System.out.println("Future result is not yet complete");
            }
        }

        exec.shutdown();

    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        Callable<String> work = new TaskWithResult(1);
        FutureTask<String> task = new FutureTask<String>(work);

        new Thread(task).start();

      while(true){
          if(task.isDone()){
              System.out.println(task.get());
              break;
          }else {
              System.out.println("is not completed");
          }
      }


    }
}




class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + this.id;
    }

}
