package com.test.email;

/**
 * author:zhangjian
 * date:2016-05-25
 * describe:
 **/
public interface EmailSender {

    boolean send(Email email);
    Email receive();

}
