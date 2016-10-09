package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhangjian on 2016/8/29.
 */
public class Demo {

}

class hello{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Demo demo = new Demo();
        System.out.println(demo.getClass().getName());

        System.out.println("====================================================");

        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        demo1 = Class.forName("reflect.Demo");
        demo2 = new Demo().getClass();
        demo3 = Demo.class;

        System.out.println("类名称   "+demo1.getName());
        System.out.println("类名称   "+demo2.getName());
        System.out.println("类名称   "+demo3.getName());

        System.out.println("====================================================");

        Class<?> Person = Class.forName("reflect.Person");

        Person person = (reflect.Person) Person.newInstance();

        person.setName("张三");
        person.setAge(10);
        System.out.println(person.toString());

        System.out.println("====================================================");


       // Person person1 = (reflect.Person) Person.getConstructors()[1].newInstance("a",1);

        //System.out.println(person1.toString());


        Person person2 = (reflect.Person) Person.getConstructor(String.class,int.class).newInstance("张三",13);

        System.out.println(person2);
        System.out.println("====================================================");

        Class<?> intes[] = Person.getInterfaces();


        for (int i = 0; i < intes.length; i++) {
            System.out.println(intes[i].getName());
            
        }

        System.out.println("====================================================");

        Class<?> parent = Person.getSuperclass();
        System.out.println(parent.getName());

        System.out.println("====================================================");

        Person person3 = (reflect.Person) Person.newInstance();

        Field[] declaredFields = Person.getDeclaredFields();

        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            declaredField.setAccessible(true);

            Class<?> type = declaredField.getType();

            if(type.equals(String.class)){
                System.out.println("字符串");
            }
            if(type.equals(int.class)){
                System.out.println("整形");
            }

           // declaredField.set(person,"a");
            
        }

        Method methods[] = Person.getMethods();

        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            Class<?> returnType = method.getReturnType();
            Class<?> paramTypes[] = method.getParameterTypes();
        }

        System.out.println("====================================================");

    }
}

class Person implements China{

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
        return "["+this.name+"  "+this.age+"]";
    }
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age=age;
        this.name=name;
    }

    public Person() {
    }

    @Override
    public void sayChina() {
        System.out.println("我事中国人");
    }

    @Override
    public void sayHello(String name, int age) {
        System.out.println("你好");
    }
}
interface China{
    public static final String name="Rollen";
    public static  int age=20;
    public void sayChina();
    public void sayHello(String name, int age);
}