package com.maxima.maximaapp.mvp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.util.DebugUtils;
import android.util.Log;
import android.view.View;

import com.maxima.maximaapp.R;
import com.maxima.maximaapp.data.MaximaDbHelper;
import com.maxima.maximaapp.data.contract.FornecedorReaderContract;
import com.maxima.maximaapp.data.contract.ProdutoReaderContact;
import com.maxima.maximaapp.domain.Fornecedor;
import com.maxima.maximaapp.domain.Produto;

import java.util.ArrayList;

public class ModelProduto implements MVP.ModelProdutoImpl {

    private MVP.ListFragmentPresenterImpl presenter;
    private SQLiteDatabase database;

    public ModelProduto(MVP.ListFragmentPresenterImpl presenter) {
        this.presenter = presenter;
        try {

//            this.list();
            this.save();
            this.savePro();
        } catch (Exception e) {
            Log.d("ERRO_TESTE", e.getMessage());
        }
    }

    @Override
    public ArrayList<Produto> list() {
        database = new MaximaDbHelper(presenter.getContext()).getReadableDatabase();
        String sql = new StringBuilder()
                .append("SELECT * FROM " + FornecedorReaderContract.FornecedorEntry.TABLE_NAME + " FOR, ")
                .append(ProdutoReaderContact.ProdutoEntry.TABLE_NAME + " PRO ")
                .append("WHERE FOR." + FornecedorReaderContract.FornecedorEntry._ID + "=PRO." + ProdutoReaderContact.ProdutoEntry.COLUM_FORNECEDOR_ID)
                .toString();

        Cursor cursor = database.rawQuery(sql, null);


        ArrayList<Produto> list = new ArrayList<>();
        while (cursor != null && cursor.moveToNext()) {
            list.add(new Produto(
                    cursor.getInt(cursor.getColumnIndex(ProdutoReaderContact.ProdutoEntry.COLUM_CODIGO_ID)),
                    cursor.getString(cursor.getColumnIndex(ProdutoReaderContact.ProdutoEntry.COLUM_DESCRICAO_NAME)),
                    new Fornecedor(cursor.getInt(cursor.getColumnIndex(FornecedorReaderContract.FornecedorEntry._ID)),
                            cursor.getString(cursor.getColumnIndex(FornecedorReaderContract.FornecedorEntry.COLUM_NAME)),
                            cursor.getInt(cursor.getColumnIndex(FornecedorReaderContract.FornecedorEntry.COLUM_FOTO)))
            ));
        }
        return list;
    }

    public long save() {
        try {
            database = new MaximaDbHelper(presenter.getContext()).getWritableDatabase();

            ArrayList<Integer> fotos = new ArrayList<>();
            fotos.add(R.drawable.sabao);
            fotos.add(R.drawable.arroz);
            fotos.add(R.drawable.arroz_vera);
            fotos.add(R.drawable.carne);
            fotos.add(R.drawable.detergente);
            fotos.add(R.drawable.feijao);
            fotos.add(R.drawable.ioguite);
            fotos.add(R.drawable.leite);
            fotos.add(R.drawable.macarrao);
            fotos.add(R.drawable.macarrao2);

            ArrayList<String> nomes = new ArrayList<>();
            nomes.add("Sabão");
            nomes.add("Arroz");
            nomes.add("Arroz Vera");
            nomes.add("Carne");
            nomes.add("Detergente");
            nomes.add("Feijão");
            nomes.add("Iogute");
            nomes.add("Leite");
            nomes.add("Macarrão");
            nomes.add("Macarrão 2");

            for (int i = 0; i < fotos.size(); i++) {
                ContentValues cv = new ContentValues();
                cv.put(FornecedorReaderContract.FornecedorEntry.COLUM_NAME, nomes.get(i));
                cv.put(FornecedorReaderContract.FornecedorEntry.COLUM_FOTO, fotos.get(i));
                database.insert(FornecedorReaderContract.FornecedorEntry.TABLE_NAME, null, cv);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long savePro() {
        database = new MaximaDbHelper(presenter.getContext()).getWritableDatabase();
        for (int i = 1; i < 10; i++) {
            ContentValues cv = new ContentValues();
            cv.put(ProdutoReaderContact.ProdutoEntry.COLUM_FORNECEDOR_ID, i);
            cv.put(ProdutoReaderContact.ProdutoEntry.COLUM_DESCRICAO_NAME, "Produtos salvos");
            database.insert(ProdutoReaderContact.ProdutoEntry.TABLE_NAME, null, cv);
        }

        return 0;
    }


}
