package com.example.random;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface API {
    //資料表 / id名稱 ? api_key

    /*******************************************************/
    @GET("resta?api_key=key5hoPQlXIf5ig6M")
    Call<Resau> getResau();

    @POST("resta?api_key=key5hoPQlXIf5ig6M") // 用@Body表示要傳送Body資料
    @Headers({
            "Accept: application/json; charset=utf-8",
            "Content-Type: application/json; charset=utf-8"
    })
    Call<Resau> postResau(@Body r_Req fields);
}
