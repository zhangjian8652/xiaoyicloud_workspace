package designpattern.proxy.ndynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhangjian on 2017/2/3.
 */
public class OperationHandler implements InvocationHandler {

    private Object tagetObject;

    public Object newProxyIntance(Object tagetObject) {
        this.tagetObject = tagetObject;
        return Proxy.newProxyInstance(tagetObject.getClass().getClassLoader(), tagetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("before excute..." + method.getName());
        Object result = method.invoke(this.tagetObject, args);
        System.out.println("after excute..." + method.getName());
        return result;
    }
}
