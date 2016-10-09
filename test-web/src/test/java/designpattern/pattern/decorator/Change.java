package designpattern.pattern.decorator;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public class Change implements GreatestSage {

    private GreatestSage greatestSage;

    public Change(GreatestSage greatestSage) {
        this.greatestSage = greatestSage;
        System.out.println("大圣开始变身了");
    }

    @Override
    public void move() {
        greatestSage.move();
    }
}
