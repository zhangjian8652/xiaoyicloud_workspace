package test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by zhangjian on 2016/11/30.
 */
@FixMethodOrder(MethodSorters.JVM)
public class TEST {

    private  boolean a = false;

    @Test
    public void test1(){
        a = true;
    }


    @Test
    public void test2(){
        System.out.println(a);
    }

}
