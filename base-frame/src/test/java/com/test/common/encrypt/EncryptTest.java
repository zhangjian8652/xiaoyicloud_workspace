package com.test.common.encrypt;

import com.joker.common.encrypt.util.EncryptUtil;
import org.junit.Test;

/**
 * @Author zhangjian
 * @Date 2015/10/31
 */
public class EncryptTest{

    @Test
    public  void test() {
            System.out.println(EncryptUtil.MD5("12233434"));
            String plain = "management:" + "admin";
            String encode = EncryptUtil.BCrypt(plain);
            System.out.println(encode);
            System.out.println(EncryptUtil.matchBCrypt(plain,encode));
            plain = plain +"1";
            System.out.println(EncryptUtil.matchBCrypt(plain,encode));
    }
}
