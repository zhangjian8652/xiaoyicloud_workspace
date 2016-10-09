package com.joker.common.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @Author zhangjian
 * @Date 2015/12/13
 */
public class JSonUtil {
    private static ObjectMapper mapper = null;

    public static synchronized ObjectMapper getMapperInstance(boolean createNew) {
        if (createNew) {
            return new ObjectMapper();
        } else if (mapper == null) {
            mapper = new ObjectMapper();
        }
        return mapper;
    }


    public static String getJsonString(Object responseData){

        mapper = getMapperInstance(false);

        String json = "";
        try {
            JsonGenerator gen;
            StringWriter writer = new StringWriter();
            gen = new JsonFactory().createJsonGenerator(writer);
            mapper.writeValue(gen, responseData);
            gen.close();
            json = writer.toString();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static Object getJavaBean(String jsonStr, Class clasz) {
        mapper = getMapperInstance(false);
        Object robj = null;
        try {
            robj = mapper.readValue(jsonStr,clasz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return robj;
    }


    public static void main(String[] ags){
        String entityString = "{\"name\":\"wangmengfei\",\"color\":\"白色\",\"age\":\"15\",\"master\":{\"name\":\"飞天猫\",\"age\":\"20\",\"sex\":\"26\"}}";
        mapper = getMapperInstance(false);
        Dog dog = (Dog) getJavaBean(entityString,Dog.class);
        System.out.println("dog = [" + dog + "]");

    }

}