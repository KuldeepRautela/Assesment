package com.example.assesment.jetpack.model;

import com.google.gson.annotations.SerializedName;

public class BestMovies{
    private String title;
    private String overview;
    private String release_date;
    private Float vote_average;
    @SerializedName("backdrop_path")
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Float getVote_average() {
        return vote_average;
    }

    public void setVote_average(Float vote_average) {
        this.vote_average = vote_average;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
