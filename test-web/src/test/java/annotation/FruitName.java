package annotation;

import java.lang.annotation.*;

/**
 * Created by zhangjian on 2016/8/30.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    public String value() default "";
}
