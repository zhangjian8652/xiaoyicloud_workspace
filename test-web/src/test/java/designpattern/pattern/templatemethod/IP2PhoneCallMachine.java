package designpattern.pattern.templatemethod;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public class IP2PhoneCallMachine extends AbstractCallMachine {
    @Override
    protected boolean makeCall(String number) {
        System.out.println("我开始打IP2Phone电话到:" + number);
        return false;
    }
}
