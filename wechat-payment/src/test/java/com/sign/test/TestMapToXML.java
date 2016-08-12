package com.sign.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.xiaoyicloud.payment.weixin.pay.util.CommonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * Created by zhangjian on 2016/7/29.
 */
public class TestMapToXML {
   private static Logger logger = LogManager.getLogger(TestMapToXML.class);
    public static void main(String[] args) throws IOException {
        SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
        parameters.put("appid", "a");
        parameters.put("body", "c");
        parameters.put("device_info", "adfs");
        parameters.put("mch_id", "你好");
        parameters.put("nonce_str","aa");

        SortedMap<Object,Object> jsonParams = new TreeMap<Object,Object>();
        jsonParams.put("j1","adsd");
        jsonParams.put("j2","adsd");
        jsonParams.put("j13","adsd");
        jsonParams.put("jswde","adsd");

        ObjectMapper mapper = new ObjectMapper();
        String params = mapper.writeValueAsString(jsonParams);

        parameters.put("json","<!CDATA[" +params + "]>");
       logger.debug(CommonUtil.converterMapToXml(parameters));

        XmlMapper xmlMapper = new XmlMapper();
        String xmlParms = xmlMapper.writeValueAsString(parameters);

        logger.debug(xmlParms);


        xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        Order order = xmlMapper.readValue(xmlParms,Order.class);
        logger.debug(order.toString());

    }
}


class Order{
    private String appid;
    private String body;
    private String deviceInfo;
    private String json;
    private String mchId;
    private String nonceStr;


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    @Override
    public String toString() {
        return "Order{" +
                "appid='" + appid + '\'' +
                ", body='" + body + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", json='" + json + '\'' +
                ", mchId='" + mchId + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                '}';
    }
}