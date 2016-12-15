package test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.text.NumberFormat;

/**
 * Created by zhangjian on 2016/11/30.
 */
@FixMethodOrder(MethodSorters.JVM)
public class TEST {

    private boolean a = false;

    @Test
    public void test1() {
        a = true;
    }


    @Test
    public void test2() {

        System.out.println(a);

        int ch = 0;

        ch = '\n';

        System.out.println(ch);
        switch (ch) {
            case '\n':
                System.out.println("hello \n");
                break;
            default:
                System.out.println("hello default");
                break;

        }
    }


    @Test
    public void test3(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
    }

}

class A{

}
