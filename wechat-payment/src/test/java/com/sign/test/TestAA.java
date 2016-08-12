package com.sign.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by zhangjian on 2016/8/10.
 */
public class TestAA {
    private static Logger logger = LogManager.getLogger(TestAA.class);

    @Test
    public void testLog4jEncoding() {
        logger.debug("log4j编码");
    }

    @Test
    public void testEncoding(){
        System.out.println("系统编码");
    }
}
