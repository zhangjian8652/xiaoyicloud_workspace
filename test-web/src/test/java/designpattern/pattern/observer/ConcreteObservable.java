package designpattern.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public class ConcreteObservable implements Observable {

    List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void addWatcher(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeWatcher(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllWatchers(String message) {
        for (Observer observer:observers) {
            observer.update(message);
        }

    }
}
