package designpattern.pattern.observer;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public class Patient extends ConcreteObservable{
    public void headache(){
        System.out.println("病人头好痛");
        notifyAllWatchers("病人开始头痛了");
    }
}
