package com.test.common.date;

import org.junit.Test;

import java.sql.Date;

/**
 * @Author zhangjian
 * @Date 2015/11/21
 */
public class DateTest {

    @Test
    public void testSqlDate(){
        Date d = new Date(System.currentTimeMillis());
        java.util.Date date = new java.util.Date(d.getTime());
    }
}
