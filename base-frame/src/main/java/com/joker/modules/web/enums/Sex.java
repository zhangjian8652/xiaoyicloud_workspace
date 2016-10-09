package com.joker.modules.web.enums;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2015/9/1
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public enum Sex {
    Man(0),Woman(1);
    private int status;
    private Sex(Integer num){
        this.status = num;
    }
}
