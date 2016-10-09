package queue;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zhangjian on 2016/9/1.
 */
public class LinkedBlockingQueueTest {

    @Test
    public void testPoll(){
        Queue<String> queue = new LinkedBlockingQueue<String>(100);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }


    @Test
    public void testPeek(){
        Queue<String> queue = new LinkedBlockingQueue<String>(100);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }

    @Test
    public void testPut(){
        Queue<String> queue = new LinkedBlockingQueue<String>(100);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }

}
