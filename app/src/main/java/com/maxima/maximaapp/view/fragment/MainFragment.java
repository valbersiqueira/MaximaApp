package com.maxima.maximaapp.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.maxima.maximaapp.R;
import com.maxima.maximaapp.mvp.MVP;
import com.maxima.maximaapp.mvp.MainFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MVP.MainFragmentImpl {


    public MainFragment() {
        // Required empty public constructor
    }


    private View view;
    private Button tela1Btn;
    private Button tela2Btn;
    private MVP.MainFragmentPresenterImpl presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null){
            presenter = new MainFragmentPresenter();
        }
        presenter.setFragment(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_main, container, false);

        tela1Btn = (Button) view.findViewById(R.id.pri_tela_1_btn);
        tela2Btn = (Button) view.findViewById(R.id.pri_tela_2_btn);

        tela1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragmente(new ListProdFragment());
            }
        });

        tela2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;

    }

    private void changeFragmente(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();
    }

}
