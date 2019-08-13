package com.ariemay.entertainmentlistmade2.views;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private String[] moviesActor;
    private String[] moviesDescription;
    private TypedArray moviesPoster;

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
        MoviesAdapter adapter = new MoviesAdapter(getContext(), listMovies);
        prepare();
        addItem(adapter);
    }


    private void addItem(MoviesAdapter adapter) {
        listMovies = new ArrayList<>();

        for (int i = 0; i < moviesName.length; i++) {
            Movies movie = new Movies();
            movie.setName(moviesName[i]);
            movie.setDate(moviesDate[i]);
            movie.setActor(moviesActor[i]);
            movie.setDescription(moviesDescription[i]);
            movie.setPhoto(moviesPoster.getResourceId(i, -1));
            listMovies.add(movie);
        }
        adapter.setMovies(listMovies);
    }

    private void prepare() {
        moviesName = getResources().getStringArray(R.array.movie_name);
        moviesDate = getResources().getStringArray(R.array.movies_date);
        moviesActor = getResources().getStringArray(R.array.artists);
        moviesDescription = getResources().getStringArray(R.array.movies_description);
        moviesPoster = getResources().obtainTypedArray(R.array.data_photo);
    }

    public interface OnFragmentInteractionListener {
    }


}
