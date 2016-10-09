package designpattern.pattern.decorator;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public class TestDecorator {
    public static void main(String[] args) {
        GreatestSage monkey = new Monkey();
        System.out.println("一个猴子学会了大圣的技能");
        monkey.move();
        GreatestSage fish = new Fish(monkey);
        fish.move();
    }
}
