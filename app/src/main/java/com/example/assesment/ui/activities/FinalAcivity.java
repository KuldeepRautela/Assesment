package com.example.assesment.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.assesment.R;
import com.example.assesment.RetrofitService;
import com.example.assesment.jetpack.model.BestMovies;
import com.example.assesment.jetpack.model.Movie;
import com.example.assesment.ui.adapters.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalAcivity extends AppCompatActivity {
   private MovieAdapter movieAdapter;
   private List<BestMovies> bestMoviesList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_acivity);
        setUpRecyclerView();
        RetrofitService.getApiInstance().getMovieData().enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful()){
                    Log.e("data is ",response.body().getBestMoviesList().get(0).getTitle());
                    bestMoviesList.clear();
                    bestMoviesList.addAll(response.body().getBestMoviesList());
                    movieAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
             Log.e("error ",t.getLocalizedMessage());
            }
        });
    }

    private void setUpRecyclerView() {
        movieAdapter = new MovieAdapter(bestMoviesList);
        RecyclerView recyclerView = findViewById(R.id.id_recyclerView);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
