package guava;

import com.google.common.base.CaseFormat;
import org.junit.Test;

/**
 * Created by zhangjian on 2016/10/26.
 */
public class CaseFormatTest {


    /**
     * 格式	范例
     LOWER_CAMEL	lowerCamel
     LOWER_HYPHEN	lower-hyphen
     LOWER_UNDERSCORE	lower_underscore
     UPPER_CAMEL	UpperCamel
     UPPER_UNDERSCORE	UPPER_UNDERSCORE
     */
    @Test
    public void test1(){
        String result =   CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"); // returns "constantName"
        System.out.println(result);
         result =   CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "hello_world"); // returns "helloWorld"
        System.out.println(result);
    }
}
