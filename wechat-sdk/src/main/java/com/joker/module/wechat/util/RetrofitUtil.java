package com.joker.module.wechat.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;

/**
 * Created by zhangjian on 2016/10/31.
 */
public class RetrofitUtil {

    public static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy
                .SNAKE_CASE);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    }

    public static MultipartBody.Part createFilePart(String name, File file) {
        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData(name, file.getName(), requestFile);

        return body;

    }

    public static RequestBody createJsonBody(Object object) {

        String jsonData = null;
        try {
             jsonData = objectMapper.writeValueAsString(object);
            System.out.println(jsonData);
            // create RequestBody instance from file
            RequestBody requestJsonBody =
                    RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonData);

            return requestJsonBody;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;


    }
}
