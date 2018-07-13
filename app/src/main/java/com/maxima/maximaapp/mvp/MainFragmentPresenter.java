package com.maxima.maximaapp.mvp;

import android.support.v4.app.Fragment;

public class MainFragmentPresenter implements MVP.MainFragmentPresenterImpl {

    private MVP.MainFragmentImpl fragment;
    private MVP.ModelProdutoImpl modelProduto;

    public MainFragmentPresenter() {
        modelProduto = new ModelProduto(this);
    }

    @Override
    public void setFragment(MVP.MainFragmentImpl fragment) {
        this.fragment = fragment;
    }

    @Override
    public Fragment getContext() {
        return (Fragment) fragment;
    }
}
