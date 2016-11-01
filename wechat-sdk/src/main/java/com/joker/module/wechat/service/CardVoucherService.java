package com.joker.module.wechat.service;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;
import com.joker.module.wechat.domain.Code;
import com.joker.module.wechat.domain.card.Logo;

/**
 * Created by zhangjian on 2016/10/28.
 */
public interface CardVoucherService {

    @Multipart
    @POST("media/uploadimg")
    Call<Logo> uploadLogo(@Query("access_token") String accessToken, @Query("type")String type, @Part MultipartBody.Part logo);

    @POST("poi/addpoi")
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    Call<Code> addPOI(@Query("access_token") String accessToken, @Body RequestBody body);


}
