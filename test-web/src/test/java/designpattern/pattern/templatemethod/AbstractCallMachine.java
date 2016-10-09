package designpattern.pattern.templatemethod;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public abstract class AbstractCallMachine {

    private void beforeMakeCall(){
        System.out.println("打电话之前做一些事情");
    }

    private void afterMakeCall(){
        System.out.println("打电话之后做一些事情");
    }
    public boolean makeCall(String countryCode, String number){
        beforeMakeCall();
        boolean result = makeCall(countryCode + number);
        afterMakeCall();
        return result;
    }

    protected abstract boolean makeCall(String number);
}
