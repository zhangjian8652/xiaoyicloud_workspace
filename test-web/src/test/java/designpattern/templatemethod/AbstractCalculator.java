package designpattern.templatemethod;

/**
 * author:zhangjian
 * date:2016-05-22
 * describe:
 **/
public abstract class AbstractCalculator {

    /**
     * 主方法，实现对本类其它方法的调用
     **/
    public final int calculate(String exp, String opt) {
        int[] array = split(exp, opt);
        return calculate(array);
    }

    protected abstract int calculate(int[] array);

    protected int[] split(String exp, String opt){
        String[] strs = exp.split(opt);
        int[] digits = new int[strs.length];
        for (int i = 0; i <strs.length ; i++) {
            try {
                digits[i] = Integer.parseInt(strs[i]);
            } catch (NumberFormatException e) {
                digits[i] = 0;
            }
        }

        return digits;
    }



}