package com.ariemay.entertainmentlistmade2.views;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ariemay.entertainmentlistmade2.R;
import com.ariemay.entertainmentlistmade2.adapters.MoviesAdapter;
import com.ariemay.entertainmentlistmade2.models.Movies;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Movies> listMovies;
    private String[] moviesName;
    private String[] moviesDate;
    private TypedArray moviesPoster;
    private MoviesAdapter moviesAdapter;

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerView = view.findViewById(R.id.movies_list);
        MoviesAdapter recyclerViewAdapter = new MoviesAdapter(getContext(), listMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepare();
        addItem();
    }

    private void addItem() {
        listMovies = new ArrayList<>();

        for (int i = 0; i < moviesName.length; i++) {
            Movies movie = new Movies();
            movie.setName(moviesName[i]);
            movie.setDate(moviesDate[i]);
            movie.setPhoto(moviesPoster.getResourceId(i, -1));
            listMovies.add(movie);
        }

        moviesAdapter.setMovies(listMovies);
    }

    private void prepare() {
        moviesName = getResources().getStringArray(R.array.movie_name);
        moviesDate = getResources().getStringArray(R.array.movies_date);
        moviesPoster = getResources().obtainTypedArray(R.array.data_photo);
    }
}