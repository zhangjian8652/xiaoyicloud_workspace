package designpattern.pattern.observer;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public class Doctor implements Observer {
    @Override
    public void update(String message) {
        System.out.println("医生知道" + message + "，马上采取措施");
    }
}
