package com.example.assesment;

import com.example.assesment.jetpack.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {
    @GET("day?api_key=a9132f98accf2082321b03563d9668a8")
    Call<Movie> getMovieData();
}
