package designpattern.observer;

/**
 * author:zhangjian
 * date:2016-05-22
 * describe:
 **/
public class ObserverTest {
    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
