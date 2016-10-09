package designpattern.pattern.decorator;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public class Fish extends Change {

    public Fish(GreatestSage greatestSage) {
        super(greatestSage);
        System.out.println("大圣变成鱼了");
    }

    @Override
    public void move() {
        System.out.println("鱼开始游泳了");
    }

}
