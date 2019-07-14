package com.ariemay.entertainmentlistmade2.views;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ariemay.entertainmentlistmade2.R;
import com.ariemay.entertainmentlistmade2.adapters.TVAdapter;
import com.ariemay.entertainmentlistmade2.models.TV;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<TV> listTv;
    private String[] showName;
    private String[] showGenre;
    private TypedArray tvPhoto;

    public TVListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tvlist, container, false);
        recyclerView = view.findViewById(R.id.tv_list);
        TVAdapter tvAdapter = new TVAdapter(getContext(), listTv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(tvAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TVAdapter tvAdapter = new TVAdapter(getContext(), listTv);
        prepare();
        addItem(tvAdapter);
    }

    private void addItem(TVAdapter tvAdapter) {
        listTv = new ArrayList<>();

        for (int i = 0; i < showName.length; i++) {
            TV tv = new TV();
            tv.setTv_name(showName[i]);
            tv.setTv_genre(showGenre[i]);
            tv.setTv_photo(tvPhoto.getResourceId(i, -1));
            listTv.add(tv);
        }

        tvAdapter.setMovies(listTv);
    }

    private void prepare() {
        showName = getResources().getStringArray(R.array.tv_name);
        showGenre = getResources().getStringArray(R.array.tv_genre);
        tvPhoto = getResources().obtainTypedArray(R.array.data_tv_photo);
    }

}
