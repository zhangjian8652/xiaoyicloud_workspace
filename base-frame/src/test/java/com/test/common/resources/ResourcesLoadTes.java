package com.test.common.resources;

import com.test.BaseSpringTest;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/**
 * author:zhangjian
 * date:2016-01-09
 * describe:
 **/
public class ResourcesLoadTes extends BaseSpringTest {

    @Test
    public void testResourceLoad() throws IOException {

        String jarPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("jar path :" + jarPath);

        Properties properties = new Properties();
        properties.load(ResourcesLoadTes.class.getClassLoader().getResourceAsStream("test.properties"));
        System.out.println(properties.get("com/test"));

        Enumeration<URL> ems =  ResourcesLoadTes.class.getClassLoader().getResources("test.properties");

       while (ems.hasMoreElements()){
           URL u = ems.nextElement();
           System.out.println("URL.path" + u.getPath());
           System.out.println("URL.file" + u.getFile());
           Properties properties2 = new Properties();
           properties2.load(new FileInputStream(u.getPath()));
           System.out.println(properties2.get("com/test"));
       }

    }



}
