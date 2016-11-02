package annotation;

import java.lang.annotation.*;

/**
 * Created by zhangjian on 2016/8/30.
 *
 *
 */

/**
 * 表示该注解可以用在什么地方，由ElementType枚举定义
 * CONSTRUCTOR：构造器的声明
 * FIELD：域声明（包括enum实例）
 * LOCAL_VARIABLE：局部变量声明
 * METHOD：方法声明
 * PACKAGE：包声明
 * PARAMETER：参数声明
 * TYPE：类、接口（包括注解类型）或enum声明
 * ANNOTATION_TYPE：注解声明（应用于另一个注解上）
 * TYPE_PARAMETER：类型参数声明（1.8新加入）
 * TYPE_USE：类型使用声明（1.8新加入）
 * PS：当注解未指定Target值时，此注解可以使用任何元素之上，就是上面的类型
 *
 */

@Target(ElementType.FIELD)
/**
 * 表示需要在什么级别保存该注解信息，由RetentionPolicy枚举定义
 * SOURCE：注解将被编译器丢弃（该类型的注解信息只会保留在源码里，源码经过编译后，注解信息会被丢弃，不会保留在编译好的class文件里）
 * CLASS：注解在class文件中可用，但会被VM丢弃（该类型的注解信息会保留在源码里和class文件里，在执行的时候，不会加载到虚拟机（JVM）中）
 * RUNTIME：VM将在运行期也保留注解信息，因此可以通过反射机制读取注解的信息（源码、class文件和执行的时候都有注解的信息）
 * PS：当注解未定义Retention值时，默认值是CLASS
 *
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * 表示注解会被包含在javaapi文档中
 */
@Documented
/**
 * 允许子类继承父类的注解
 */
@Inherited
public @interface Column {
    public String name() default "fieldName";
}
