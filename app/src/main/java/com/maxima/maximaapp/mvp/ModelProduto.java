package com.maxima.maximaapp.mvp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.maxima.maximaapp.R;
import com.maxima.maximaapp.data.MaximaDbHelper;
import com.maxima.maximaapp.data.contract.FornecedorReaderContract;
import com.maxima.maximaapp.domain.Fornecedor;
import com.maxima.maximaapp.domain.Produto;

import java.util.ArrayList;

public class ModelProduto implements MVP.ModelProdutoImpl {

    private MVP.MainFragmentPresenterImpl presenter;
    private SQLiteDatabase database;

    public ModelProduto(MVP.MainFragmentPresenterImpl presenter) {
        this.presenter = presenter;
        database = new MaximaDbHelper(presenter.getContext().getActivity()).getWritableDatabase();
        this.save();
    }

    @Override
    public ArrayList<Produto> list(View view) {
        return null;
    }

    public long save(){
        ContentValues cv = new ContentValues();
        cv.put(FornecedorReaderContract.FornecedorEntry.COLUM_NAME, "arra tipo 1");
        cv.put(FornecedorReaderContract.FornecedorEntry.COLUM_FOTO, R.drawable.arroz);
        return database.insert(FornecedorReaderContract.FornecedorEntry.TABLE_NAME, null, cv);
    }
}
