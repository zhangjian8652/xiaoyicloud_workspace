package designpattern.decorator;

/**
 * author:zhangjian
 * date:2016-05-22
 * describe:
 **/
public class Decorator implements Sourceable{

    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {

        System.out.println("before decorator");
        source.method();
        System.out.println("after decorator");
    }
}
