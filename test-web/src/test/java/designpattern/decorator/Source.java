package designpattern.decorator;

/**
 * author:zhangjian
 * date:2016-05-22
 * describe:
 **/
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("hello this is Source method");
    }
}
