package com.example.assesment;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/trending/movie/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public static RetrofitApi getApiInstance() {
        return retrofit.create(RetrofitApi.class);
    }
}
