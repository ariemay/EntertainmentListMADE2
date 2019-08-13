package com.ariemay.entertainmentlistmade2.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ariemay.entertainmentlistmade2.R;
import com.ariemay.entertainmentlistmade2.models.Movies;
import com.ariemay.entertainmentlistmade2.views.MovieDetails;
import com.ariemay.entertainmentlistmade2.views.MoviesFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Movies> movies;

    public MoviesAdapter(Context context, ArrayList<Movies> movies) {
        this.context = context;
        this.movies = movies;
    }

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_list_items, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder viewHolder, final int i) {
        Glide.with(context)
                .load(movies.get(i).getPhoto())
                .apply(new RequestOptions().override(150,150))
                .into(viewHolder.poster);

        viewHolder.date.setText(movies.get(i).getDate());
        viewHolder.name.setText(movies.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView date;
        private ImageView poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            poster = itemView.findViewById(R.id.movie_poster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(context, MovieDetails.class);
                    intent.putExtra(MovieDetails.EXTRA_DATA, movies.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }
}
