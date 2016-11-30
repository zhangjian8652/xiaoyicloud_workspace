package com.joker.module.wechat.api;

import com.joker.module.wechat.api.result.BaseResult;
import com.joker.module.wechat.api.result.CardVoucherAPIResult;
import com.joker.module.wechat.api.result.MemberCardUpdateResult;
import com.joker.module.wechat.domain.Code;
import com.joker.module.wechat.domain.Logo;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by zhangjian on 2016/10/28.
 */
public interface CardVoucherAPI {

    @Multipart
    @POST("cgi-bin/media/uploadimg")
    Call<Logo> uploadLogo(@Query("access_token") String accessToken, @Query("type")String type, @Part MultipartBody.Part logo);


    /**
     * 添加门店
     * @param accessToken 认证token
     * @param body 请求体
     * @return
     */
    @POST("cgi-bin/poi/addpoi")
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    Call<Code> addPOI(@Query("access_token") String accessToken, @Body RequestBody body);


    /**
     * 创建卡券
     * @param accessToken
     * @param body
     * @return
     */
    @POST("card/create")
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    Call<CardVoucherAPIResult> createCardVoucher(@Query("access_token") String accessToken, @Body RequestBody body);


    /**
     * 激活会员卡 当创建会员卡时wx_activate为true
     * @param accessToken
     * @param body
     * @return
     */
    @POST("card/membercard/activateuserform/set")
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    Call<BaseResult> setActiveMemberCardForm(@Query("access_token") String accessToken, @Body RequestBody body);


    /**
     * 更新会员卡信息
     * @param accessToken
     * @param body
     * @return
     */
    @POST("card/membercard/updateuser")
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    Call<MemberCardUpdateResult> updateMemberCard(@Query("access_token") String accessToken, @Body RequestBody body);





}
