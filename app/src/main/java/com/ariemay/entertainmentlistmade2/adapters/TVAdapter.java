package com.ariemay.entertainmentlistmade2.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ariemay.entertainmentlistmade2.R;
import com.ariemay.entertainmentlistmade2.models.TV;
import com.ariemay.entertainmentlistmade2.views.TVDetails;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class TVAdapter extends RecyclerView.Adapter<TVAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TV> tvs;

    public TVAdapter(Context context, ArrayList<TV> listMovies) {
        this.context = context;
        this.tvs = listMovies;
    }

    public void setMovies(ArrayList<TV> movies) {
        this.tvs = tvs;
    }

    @NonNull
    @Override
    public TVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.tv_list_items, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TVAdapter.ViewHolder viewHolder, int i) {
        Glide.with(context)
                .load(tvs.get(i).getTv_photo())
                .apply(new RequestOptions().override(150,150))
                .into(viewHolder.tvPhoto);

        viewHolder.tvName.setText(tvs.get(i).getTv_name());
        viewHolder.tvGenre.setText(tvs.get(i).getTv_genre());

        viewHolder.tvPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(context, TVDetails.class);
                context.startActivity(detailIntent);
            }
        });
        viewHolder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(context, TVDetails.class);
                context.startActivity(detailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tvs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvGenre;
        private ImageView tvPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.showName);
            tvGenre = itemView.findViewById(R.id.genre);
            tvPhoto = itemView.findViewById(R.id.tv_poster);
        }
    }
}
