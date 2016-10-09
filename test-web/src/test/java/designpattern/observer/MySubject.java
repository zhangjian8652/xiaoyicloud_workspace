package designpattern.observer;

/**
 * author:zhangjian
 * date:2016-05-22
 * describe:
 **/
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
            System.out.println("update self!");
            notifyObservers();
    }
}
