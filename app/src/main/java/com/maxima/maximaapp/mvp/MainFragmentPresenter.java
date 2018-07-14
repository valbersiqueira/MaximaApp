package com.maxima.maximaapp.mvp;


public class MainFragmentPresenter implements MVP.MainFragmentPresenterImpl {

    private MVP.MainFragmentImpl fragment;

    public MainFragmentPresenter() {
    }

    @Override
    public void setFragment(MVP.MainFragmentImpl fragment) {
        this.fragment = fragment;
    }

    public MVP.MainFragmentImpl getFragment() {
        return fragment;
    }

}
