package optional;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by zhangjian on 2016/8/24.
 */
public class OptionalTest {

    @Test
    public void testString(){
        Optional<String> str = Optional.of("hello word!");
       // Optional<String> empty = Optional.of(null);

        if(str.isPresent()){
            System.out.println(str.get());
        }

    }


    @Test
    public void testEmpty(){
        Optional<String> empty = Optional.ofNullable(null);

        if(empty.isPresent())
        System.out.println(empty.get());

        //输出：Sanaulla
        //System.out.println(empty.orElseGet(() -> "Default Value"));

    }
}
