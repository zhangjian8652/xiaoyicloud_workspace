package com.test.retrofit.interf;

import com.test.retrofit.domain.Example;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by zhangjian on 2016/10/18.
 */
public interface WethearInfoService {

    @GET("/data/{city}/101190101.html")
    Call<Example> getWeatherInfoByCityCode(@Path("city") String city);
}
