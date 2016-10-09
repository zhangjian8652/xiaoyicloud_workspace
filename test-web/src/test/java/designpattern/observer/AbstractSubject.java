package designpattern.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * author:zhangjian
 * date:2016-05-22
 * describe:
 **/
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumoes = vector.elements();
        while (enumoes.hasMoreElements()){
            enumoes.nextElement().update();
        }
     }
}
