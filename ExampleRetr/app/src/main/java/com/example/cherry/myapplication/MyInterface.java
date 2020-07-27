package com.example.cherry.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyInterface {
    @GET("top-headlines?sources=google-news&apiKey=4e10bb56331648988b2ac6a52eff2e67")
    Call<String> value();
}
