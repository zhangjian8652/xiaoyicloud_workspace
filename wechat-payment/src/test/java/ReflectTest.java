import com.joker.module.payment.wechat.domain.WechatPayResult;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhangjian on 2016/8/19.
 */
public class ReflectTest {
    @Test
    public void testAtrribute() throws InvocationTargetException, IllegalAccessException, IntrospectionException {


        WechatPayResult wechatPayResult = new WechatPayResult();
        wechatPayResult.setAttach("aa");

       Field[] fields = WechatPayResult.class.getDeclaredFields();

        for (Field field:fields){
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
                    wechatPayResult.getClass());
            Method getMethod = pd.getReadMethod();//获得get方法
            Object o = getMethod.invoke(wechatPayResult);//执行get方法返回一个Object
            System.out.println(o);
        }
    }
}
