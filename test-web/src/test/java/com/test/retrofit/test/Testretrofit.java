package com.test.retrofit.test;

import com.test.retrofit.domain.Example;
import com.test.retrofit.interf.WethearInfoService;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

/**
 * Created by zhangjian on 2016/10/18.
 */
public class Testretrofit {

    @Test
    public void testWeatherInfo() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.weather.com.cn/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        WethearInfoService service = retrofit.create(WethearInfoService.class);

        Call<Example> weatherInfoCall = service.getWeatherInfoByCityCode("sk");

        Response<Example> weatherInfoResponse = weatherInfoCall.execute();

        System.out.println(weatherInfoResponse.body());


    }
}
