package com.example.retrofitdemo.API;

import com.example.retrofitdemo.domain.JsonResult;
import com.example.retrofitdemo.domain.getWithParamResult;
import com.example.retrofitdemo.domain.postWithParamResult;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface SOBAPI {

    @GET("/get/text")
    Call<JsonResult> getJson();

    @GET("/get/param")
    Call<getWithParamResult> getWithParam(@Query("keyword")String keyword,@Query("page")int page,@Query("order")String order);


    @GET("/get/param")
    Call<getWithParamResult> getWithParam(@QueryMap Map<String,Object> params);

    @POST("/post/string")
    Call<postWithParamResult> postWithParam(@Query("string") String str);

    @POST
    Call<postWithParamResult> postWithUrl(@Url String url);
}
