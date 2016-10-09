package designpattern.pattern.observer;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public interface Observable {
   void addWatcher(Observer watcher);
   void removeWatcher(Observer watcher);
   void notifyAllWatchers(String message);
}
