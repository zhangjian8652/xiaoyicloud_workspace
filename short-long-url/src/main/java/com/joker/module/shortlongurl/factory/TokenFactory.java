package com.joker.module.shortlongurl.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.joker.module.httpclient.HttpRequest;
import com.joker.module.httpclient.domain.Response;
import com.joker.module.shortlongurl.config.Config;
import com.joker.module.shortlongurl.domain.WechatToken;
import com.joker.module.shortlongurl.exception.WechatTokenException;
import org.apache.commons.httpclient.Header;

import java.io.IOException;

/**
 * Created by zhangjian on 2016/8/28.
 */
public class TokenFactory {

    private static TokenFactory instance;


    private TokenFactory() {

    }

    public static TokenFactory getInstance() {
        if (instance == null) {
            synchronized (TokenFactory.class) {
                if (instance == null) {
                    instance = new TokenFactory();
                }
            }
        }

        return instance;
    }

    public WechatToken produceWechatToken() throws WechatTokenException {
        StringBuilder uri = new StringBuilder("/cgi-bin/token");
        uri.append("?grant_type=client_credential");
        uri.append("&appid=" + Config.WECHAT_CONFIG_APPID);
        uri.append("&secret=" + Config.WECHAT_CONFIG_SECRET);

        HttpRequest httpRequest = new HttpRequest(HttpRequest.TYPE_HTTPS, (Header[]) null, Config.WECHAT_CONFIG_ADDRESS, Config.WECHAT_CONFIG_PORT);

        Response response = httpRequest.get(uri.toString());

        if(!response.isSuccess()){
            throw new WechatTokenException("获取微信token失败，请检查网络是否有问题。");
        }

        WechatToken wechatToken = null;

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        try {
            System.out.println(response.getString());
            wechatToken = mapper.readValue(response.getString(),WechatToken.class);
        } catch (IOException e) {
            throw new WechatTokenException("转换token数据失败，联系接口开发人员，微信返回key值改变");

        }

        return wechatToken;

    }

}
