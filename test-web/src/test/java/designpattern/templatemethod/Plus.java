package designpattern.templatemethod;

/**
 * author:zhangjian
 * date:2016-05-22
 * describe:
 **/
public class Plus extends AbstractCalculator{

    @Override
    protected int calculate(int[] array) {
        int result = 0;

        for (int i = 0; i <array.length ; i++) {
            result += array[i];
        }
        return result;
    }
}
