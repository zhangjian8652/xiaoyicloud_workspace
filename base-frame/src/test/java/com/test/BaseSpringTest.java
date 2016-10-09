package com.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author zhangjian
 * @Date 2015/10/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:conf/application-context-*.xml","classpath*:conf/mvc-dispatcher-servlet.xml"})
public class BaseSpringTest extends AbstractJUnit4SpringContextTests {


}
