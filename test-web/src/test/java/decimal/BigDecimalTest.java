package decimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Created by zhangjian on 2016/8/22.
 */
public class BigDecimalTest {

    @Test
    public void testPlus(){
        BigDecimal intA = new BigDecimal(1);
        BigDecimal intB = new BigDecimal(10);

        BigDecimal intC = intA.add(intB);
        System.out.println(intC);
    }

    @Test
    public void testMultiply(){
        BigDecimal intA = new BigDecimal(1.13);
        BigDecimal intB = new BigDecimal(10.22);

        BigDecimal intC = intA.multiply(intB);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println(numberFormat.format(intC));


        NumberFormat numberFormat1 = NumberFormat.getPercentInstance();

        BigDecimal a = new BigDecimal(1.111);
        BigDecimal b = new BigDecimal(10);
        BigDecimal d = a.divide(b);
        System.out.println(d);
    }

    @Test
    public void test(){
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("2");
        BigDecimal c = new BigDecimal("1");
        int result1 = a.compareTo(b);
        int result2 = a.compareTo(c);
        int result3 = b.compareTo(a);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
