package com.maxima.maximaapp.mvp;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.maxima.maximaapp.domain.Produto;

import java.util.ArrayList;

public class MVP {
    public interface ModelProdutoImpl{
        ArrayList<Produto> list(View view);
    }


    public interface MainFragmentImpl{
    }

    public interface MainFragmentPresenterImpl{
        void setFragment(MainFragmentImpl fragment);
        Fragment getContext();
    }
}
