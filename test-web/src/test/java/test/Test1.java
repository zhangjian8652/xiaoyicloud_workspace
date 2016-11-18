package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangjian on 2016/11/8.
 */
public class Test1 {

    @Test
    public void test1(){

        System.out.println(1.0d / 0);

        System.out.println(0.0d / 0);

        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(0 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2(){

        int[] arr = new int[]{1,2,3};

        Integer[] arrs = new Integer[]{1,2,3};
        float[] arr3 = new float[]{1,2,3};

        List<int[]> objects = Arrays.asList(arr);
        System.out.println(objects.size());
        System.out.println(objects.contains(1));

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        System.out.println(ints.contains(1));
    }



    @Test
    public void test3(){
        char x = 'X';
        int i = 0;
        System.out.println(true ? x : 0);// X
        System.out.println(false ? i : x);// 88
    }

    @Test
    public void test4(){

        //精度问题
        double total = 2.0;
        double price = 0.1;
        double remaining = total;
        int count = 0;
        while (remaining >= price) {
            count++;
            remaining -= price;
            System.out.println(remaining);
        }


        System.out.println(count);
        System.out.println(remaining);
    }


    public void test5(){

/*        short x = 1;
        int i = 1;
        x += i;
        x = x + i;*/
    }

    public void test6(){
     /*   Object x = 1;
        String i = "";
        x += i;
        x = x + i;*/
    }


    @Test
    public void test7(){
        //char型变量的加法不是连接字符，而是和int类似，但相加的是它的ASCII码，本例中输出78+67=145
        System.out.println('N' + 'C');
    }



    @Test
    public void test8(){
        StringBuffer sb = new StringBuffer('E');
        sb.append('M');
        sb.append('S');
        System.out.println(sb.toString());
    }

    class AA{
    /*    public void test(List<String> lst) {
        }
        public void test(List<Object> lst) {
        }*/
    }



    @Test
    public void test9(){
        /**
         * Integer会cache -127~127的Integer对象，而不在这个范围的则会每次new Integer。
         */
        Integer i = 100;
        Integer j = 100;
        Integer m = 200;
        Integer n = 200;
        System.out.println(i == j);//true
        System.out.println(m == n);//false
    }


    
}
