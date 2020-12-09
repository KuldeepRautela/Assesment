package com.example.assesment.jetpack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("results")
    private List<BestMovies> bestMoviesList;

    public List<BestMovies> getBestMoviesList() {
        return bestMoviesList;
    }

    public void setBestMoviesList(List<BestMovies> bestMoviesList) {
        this.bestMoviesList = bestMoviesList;
    }
}
