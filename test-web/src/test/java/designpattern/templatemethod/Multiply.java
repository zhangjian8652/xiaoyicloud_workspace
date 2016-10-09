package designpattern.templatemethod;

/**
 * author:zhangjian
 * date:2016-05-22
 * describe:
 **/
public class Multiply extends AbstractCalculator{

    @Override
    protected int calculate(int[] array) {

        int result = 1;

        for (int i = 0; i < array.length; i++) {
            result *= array[i];
        }
        return result;
    }
}
