package com.joker.module.shortlongurl.generator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.joker.module.httpclient.HttpRequest;
import com.joker.module.httpclient.domain.Response;
import com.joker.module.shortlongurl.config.Config;
import com.joker.module.shortlongurl.domain.WeChatShortURL;
import com.joker.module.shortlongurl.domain.WechatToken;
import com.joker.module.shortlongurl.thread.TokenVindicator;
import org.apache.commons.httpclient.Header;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangjian on 2016/8/28.
 */
public class WechhatURLGenerator {

    /**
     *
     * @param longURL 需要转换的长链接
     * @return
     */
    public static String long2Short(String longURL){
        WechatToken token = new TokenVindicator().getWechatToken();
        HttpRequest request = new HttpRequest(HttpRequest.TYPE_HTTPS, (Header[]) null,Config.WECHAT_CONFIG_ADDRESS,443);

        StringBuilder uri = new StringBuilder("/cgi-bin/shorturl");
        uri.append("?access_token=");
        uri.append(token.getAccessToken());

        Map<String,String> params = new HashMap<String, String>();
        params.put("action","long2short");
        params.put("long_url",longURL);

        ObjectMapper mapper = new ObjectMapper();
        Response response = null;

        try {
            response = request.post(uri.toString(),mapper.writeValueAsString(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        WeChatShortURL weChatShortURL = null;
        if(response.isSuccess()){
              mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
            try {
                weChatShortURL = mapper.readValue(response.getString(),WeChatShortURL.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return weChatShortURL == null?null:weChatShortURL.getShortUrl() ;
    };
}
