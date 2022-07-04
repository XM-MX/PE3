package com.example.pe3.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("all")
    Call<Statistics> getStatistics();

}