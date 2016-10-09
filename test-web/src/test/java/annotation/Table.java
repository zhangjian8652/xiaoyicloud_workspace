package annotation;

import java.lang.annotation.*;

/**
 * Created by zhangjian on 2016/8/30.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    public String name() default "className";
}
