package designpattern.pattern.templatemethod;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public class TestTemplateMethod {
    public static void main(String[] args) {
        AbstractCallMachine caller1 = new IP2IPCallMachine();
        AbstractCallMachine caller2 = new IP2PhoneCallMachine();
        caller1.makeCall("86","18328358153");
        caller2.makeCall("86","18328358153");

    }
}
