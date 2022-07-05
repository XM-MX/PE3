package com.example.pe3.Retrofit;

import com.example.pe3.api.History;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitApi {

    @GET("all")
    Call<Statistics> getStatistics();

    @POST("history")
        //on below line we are creating a method to post our data.
    Call<History> createPost(@Body History history);

    @GET("history/:id")
    Call<History> getHistory(@Path("id") int id, @Body History history);

    @GET("history")
    Call<List<History>> getHistories();

    @DELETE("history/:id")
    Call<History> deleteHistory(@Path("id") int id);

}