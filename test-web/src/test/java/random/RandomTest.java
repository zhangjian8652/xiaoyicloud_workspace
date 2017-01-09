package random;

import org.junit.Test;

import java.util.Random;

/**
 * Created by zhangjian on 2016/12/15.
 */
public class RandomTest {

    @Test
    public void test1(){
        Random random = new Random();

        int i = random.nextInt(10);
        System.out.println(i);
        float f = random.nextFloat();
        System.out.println(f);

        System.out.println((int)(Math.random()*10));
    }
}
