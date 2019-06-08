package com.example.random;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private API api;

    private RetrofitManager(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.airtable.com/v0/appI6G1iijFRZBeGd/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
    }

    private static class Holder{
        public static final RetrofitManager getInstance = new RetrofitManager();
    }

    public static RetrofitManager getInstance(){
        return Holder.getInstance;
    }

    public API getAPI(){
        return api;
    }
}
