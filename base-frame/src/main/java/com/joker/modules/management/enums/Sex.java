package com.joker.modules.management.enums;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjian
 * Date: 2015/9/1
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public enum Sex {
    男(0),女(1);
    private int status;
    private Sex(Integer num){
        this.status = num;
    }
}
