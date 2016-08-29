package com.joker.module.shortlongurl.config;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by zhangjian on 2016/8/28.
 */
public class Config {
    public static String WECHAT_CONFIG_APPID;
    public static String WECHAT_CONFIG_SECRET;
    public static String WECHAT_CONFIG_ADDRESS;
    public static Integer WECHAT_CONFIG_PORT;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
            WECHAT_CONFIG_APPID = properties.getProperty("config.wechat.appid");
            WECHAT_CONFIG_SECRET = properties.getProperty("config.wechat.secret");
            WECHAT_CONFIG_ADDRESS = properties.getProperty("config.wechat.address");
            WECHAT_CONFIG_PORT = Integer.parseInt(properties.getProperty("config.wechat.port"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
