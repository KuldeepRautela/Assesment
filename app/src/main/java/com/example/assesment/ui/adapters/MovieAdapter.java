package com.example.assesment.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assesment.R;
import com.example.assesment.jetpack.model.BestMovies;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<BestMovies> bestMovies;

    public MovieAdapter(List<BestMovies> bestMoviesList) {
        this.bestMovies = bestMoviesList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return bestMovies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView name, overview, releaseDate, voteAverage;
        CircleImageView movieImg;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.id_title);
            releaseDate = itemView.findViewById(R.id.id_releasedata);
            overview = itemView.findViewById(R.id.id_overview);
            voteAverage = itemView.findViewById(R.id.id_voteAvarage);
            movieImg = itemView.findViewById(R.id.id_movieImg);
        }

        public void bind(int position) {
            name.setText("Name : " + bestMovies.get(position).getTitle());
            overview.setText("Overview : " + bestMovies.get(position).getOverview());
            releaseDate.setText("Release Date : " + bestMovies.get(position).getRelease_date());
            voteAverage.setText("Vote Average : " + bestMovies.get(position).getVote_average());
            Glide.with(itemView.getContext()).load("https://image.tmdb.org/t/p/w500"+bestMovies.get(position).getImage()).into(movieImg);
        }
    }
}
