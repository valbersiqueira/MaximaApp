package com.maxima.maximaapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.maxima.maximaapp.data.contract.FornecedorReaderContract;
import com.maxima.maximaapp.data.contract.ProdutoReaderContact;

public class MaximaDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bd_maxima";
    private static final Integer DATABASE_VERSION = 1;

    public MaximaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(geraTbFornecedor());
        sqLiteDatabase.execSQL(geraTbProduto());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FornecedorReaderContract.FornecedorEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProdutoReaderContact.ProdutoEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private static final String geraTbFornecedor() {
        final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";
        return new StringBuilder(CREATE_TABLE)
                .append(FornecedorReaderContract.FornecedorEntry.TABLE_NAME + "( ")
                .append(FornecedorReaderContract.FornecedorEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(FornecedorReaderContract.FornecedorEntry.COLUM_NAME + " TEXT NOT NULL, ")
                .append(FornecedorReaderContract.FornecedorEntry.COLUM_FOTO + " INTEGER ")
                .append(");").toString();

    }


    private String geraTbProduto() {
        final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";
        return new StringBuilder(CREATE_TABLE)
                .append(ProdutoReaderContact.ProdutoEntry.TABLE_NAME + "( ")
                .append(ProdutoReaderContact.ProdutoEntry.COLUM_CODIGO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(ProdutoReaderContact.ProdutoEntry.COLUM_DESCRICAO_NAME + " TEXT NOT NULL, ")
                .append(ProdutoReaderContact.ProdutoEntry.COLUM_FORNECEDOR_ID + " INTEGER NOT NULL, ")
                .append("FOREIGN KEY (" + ProdutoReaderContact.ProdutoEntry.COLUM_FORNECEDOR_ID + ") REFERENCES ")
                .append(FornecedorReaderContract.FornecedorEntry.TABLE_NAME + "(" + FornecedorReaderContract.FornecedorEntry._ID + ")")
                .append(");")
                .toString();
    }

}
