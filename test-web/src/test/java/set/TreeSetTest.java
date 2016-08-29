package set;

import org.junit.Test;

import java.util.*;

/**
 * Created by zhangjian on 2016/8/24.
 */
public class TreeSetTest {

    @Test
    public void test1() {
        TreeSet num = new TreeSet();
        num.add(5);
        num.add(2);
        num.add(10);
        num.add(-9);
        System.out.println(num);//输出：[-9,2,5,10]集合元素已经处于排序状态
        System.out.println(num.first());//输出-9
        System.out.println(num.last());//输出10);
        System.out.println(num.headSet(4));//输出-9,2返回小于4的子集
        System.out.println(num.tailSet(5));//输出5,10返回大于等于5的子集
        System.out.println(num.subSet(-9, 5));//输出-9,2返回大于等于-9小于5的子集

    }


    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        List<Integer> n1 = new ArrayList<Integer>();
        n1.add(1);
        n1.add(2);
        n1.add(3);
        n1.add(4);
        for (int i = 0; i < n1.size(); i++) {
            System.out.println(n1.get(i));
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);

        start = System.currentTimeMillis();

        List<Integer> ln = new LinkedList<Integer>();
        ln.add(1);
        ln.add(2);
        ln.add(3);
        ln.add(4);
        ln.add(5);

        for (int i = 0; i < n1.size(); i++) {
            System.out.println(n1.get(i));
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        Map<String,Object> aa = new HashMap<String,Object>();
        aa.put("a","b");
        Set<Map.Entry<String, Object>> cc = aa.entrySet();


    }
}
