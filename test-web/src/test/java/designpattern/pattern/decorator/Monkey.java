package designpattern.pattern.decorator;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public class Monkey implements GreatestSage {
    @Override
    public void move() {
        System.out.println("猴子开始爬着走了");
    }
}
