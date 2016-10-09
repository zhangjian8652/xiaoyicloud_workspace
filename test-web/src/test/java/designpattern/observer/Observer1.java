package designpattern.observer;

/**
 * author:zhangjian
 * date:2016-05-22
 * describe:
 **/
public class Observer1 implements Observer{
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
