package com.maxima.maximaapp.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxima.maximaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListProdFragment extends Fragment {


    public ListProdFragment() {
        // Required empty public constructor
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_prod, container, false);
        return view;
    }

}
