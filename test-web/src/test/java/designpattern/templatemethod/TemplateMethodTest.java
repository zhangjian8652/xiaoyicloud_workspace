package designpattern.templatemethod;

/**
 * author:zhangjian
 * date:2016-05-22
 * describe:
 **/
public class TemplateMethodTest {
    public static void main(String[] args) {

        String s = "1+2+3";
        AbstractCalculator calculator = new Plus();
        System.out.println("plus result = [" + calculator.calculate(s,"\\+") + "]");

        String s2 = "1*2*3";
        AbstractCalculator calculator2 = new Multiply();
        System.out.println("plus result = [" + calculator2.calculate(s2,"\\*") + "]");
    }
}
