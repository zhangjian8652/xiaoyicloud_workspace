package com.joker.module.wechat.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by zhangjian on 2016/10/28.
 */
public class RetrofitFactory {


    //生成微信api的retrofit对象
    public static Retrofit wechatAPIRetrofit(){


        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy
                .SNAKE_CASE);


        OkHttpClient okHttpClient = createLogOkHttpClient();

        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient)
                .baseUrl("https://api.weixin.qq.com/")
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();

        return retrofit;
    }

    private static OkHttpClient createLogOkHttpClient(){
        // 查看网络request 和 response 的具体的值
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);//设置查看日志的等级

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        okHttpBuilder.interceptors().add(logging);// 这句话是重点
        return okHttpBuilder.build();
    }
}
