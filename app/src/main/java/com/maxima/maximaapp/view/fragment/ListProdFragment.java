package com.maxima.maximaapp.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;

import com.maxima.maximaapp.R;
import com.maxima.maximaapp.adapter.AdapterProdutoRecyclierView;
import com.maxima.maximaapp.mvp.ListFragmentPresenter;
import com.maxima.maximaapp.mvp.MVP;
import com.maxima.maximaapp.mvp.MainFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListProdFragment extends Fragment implements MVP.ListFragmentImpl {


    public ListProdFragment() {
        // Required empty public constructor
    }

    private View view;
    private ListFragmentPresenter presenter;
    private AdapterProdutoRecyclierView adapterProdutoRecyclierView;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_prod, container, false);

        if (presenter == null) {
            presenter = new ListFragmentPresenter(getActivity());
        }
        presenter.setFragment(this);
        incialiarComponentes(view);
        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_actionbar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                gotBack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void incialiarComponentes(View view) {
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recy_produto);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterProdutoRecyclierView = new AdapterProdutoRecyclierView(this, presenter.list());
        recyclerView.setAdapter(adapterProdutoRecyclierView);
    }

    private void gotBack() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, new MainFragment())
                .commit();
    }

}
