package decimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by zhangjian on 2016/10/18.
 */
public class TestDecimalFormat {

    @Test
    public void test1(){
        double d = 0.206;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(d));

        double d2 = 0.6554;
        String s=String.format("%.2f",d2);
        System.out.println(s);


        double d3 = 1.016;
        BigDecimal bd= new BigDecimal(d3);
        double d4 = bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d4);
    }

}
