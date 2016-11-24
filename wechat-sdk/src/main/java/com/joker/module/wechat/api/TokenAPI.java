package com.joker.module.wechat.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.joker.module.wechat.domain.Token;

/**
 * Created by zhangjian on 2016/10/28.
 */
public interface TokenAPI {

    @GET("cgi-bin/token")
    public Call<Token> getToken(@Query("grant_type") String grantType, @Query("appid") String appid, @Query("secret") String secret);
}
