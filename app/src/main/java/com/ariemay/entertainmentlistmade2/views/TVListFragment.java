package com.ariemay.entertainmentlistmade2.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ariemay.entertainmentlistmade2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVListFragment extends Fragment {


    public TVListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvlist, container, false);
    }

}
