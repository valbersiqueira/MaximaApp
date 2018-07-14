package com.maxima.maximaapp.mvp;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.maxima.maximaapp.domain.Fornecedor;
import com.maxima.maximaapp.domain.Produto;

import java.util.ArrayList;

public class MVP {
    public interface ModelProdutoImpl{
        ArrayList<Produto> list();
    }


    public interface MainFragmentImpl{
    }

    public interface ListFragmentImpl{
    }

    public interface MainFragmentPresenterImpl{
        void setFragment(MainFragmentImpl fragment);
    }

    public interface ListFragmentPresenterImpl{
        void setFragment(ListFragmentImpl fragment);
        Context getContext();
        ArrayList<Produto> list();
    }
}
