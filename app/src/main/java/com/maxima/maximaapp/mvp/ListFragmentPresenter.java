package com.maxima.maximaapp.mvp;

import android.content.Context;
import com.maxima.maximaapp.domain.Produto;

import java.util.ArrayList;

public class ListFragmentPresenter implements MVP.ListFragmentPresenterImpl {

    private Context context;
    private MVP.ListFragmentImpl fragment;
    private MVP.ModelProdutoImpl modelProduto;

    public ListFragmentPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void setFragment(MVP.ListFragmentImpl fragment) {
        this.fragment = fragment;
        this.modelProduto = new ModelProduto(this);
    }

    @Override
    public Context getContext() {
        return this.context;
    }

    @Override
    public ArrayList<Produto> list() {
        return modelProduto.list();
    }
}
