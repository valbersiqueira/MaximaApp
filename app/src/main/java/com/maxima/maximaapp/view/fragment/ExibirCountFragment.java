package com.maxima.maximaapp.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxima.maximaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExibirCountFragment extends Fragment {

    private View view;
    private TextView countTxt;

    public ExibirCountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_exibir_count, container, false);
    this.countTxt = view.findViewById(R.id.text_count);

    Bundle data = getArguments();
    if(data != null) {
        countTxt.setText(data.getString("count"));
    }
        return view;
    }

}
