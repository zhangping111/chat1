package com.example.day401_dianping.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day401_dianping.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class frouthFragment extends Fragment {


    public frouthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_frouth,container,false);
        return view;
    }

}