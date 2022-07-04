package com.example.pe3.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pe3.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MYActivity1 extends AppCompatActivity {

    TextView tvCases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myactivity1);

        tvCases = findViewById(R.id.tvCases);
        fetchApiDataUsingRetrofit();

    }

    public void fetchApiDataUsingRetrofit(){

        String baseUrl = "https://disease.sh/v3/covid-19/";
        Gson gson = new GsonBuilder().setLenient().create();

        //Create a Retrofit builder and pass the gson in
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build();

        //Implement the Retrofit Client interface function
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);

        Call<Statistics> statisticsCall = retrofitApi.getStatistics();

        statisticsCall.enqueue(new Callback<Statistics>() {

            //success
            @Override
            public void onResponse(Call<Statistics> call, Response<Statistics> response) {
                //bind the data from the API to the views
                tvCases.setText(response.body().getCases()); // return cases value
            }

            //failure
            @Override
            public void onFailure(Call<Statistics> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
                Toast.makeText(MYActivity1.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
