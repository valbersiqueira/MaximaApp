package com.maxima.maximaapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.maxima.maximaapp.data.contract.ProdutoReaderContact;

public class MaximaDbHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bd_maxima";
    private static final Integer DATABASE_VERSION = 1;

    public MaximaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(geraDB());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProdutoReaderContact.ProdutoEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private static final String geraDB() {
        return new StringBuilder("CREATE TABLE ")
                .append(ProdutoReaderContact.ProdutoEntry.TABLE_NAME + "( ")
                .append(ProdutoReaderContact.ProdutoEntry.COLUM_CODIGO_ID + " INTEGER PRIMATY KEY AUTOINCREMENTE, ")
                .append(ProdutoReaderContact.ProdutoEntry.COLUM_DESCRICAO_NAME + "TEXT NOT NULL, ")
                .append(ProdutoReaderContact.ProdutoEntry.COLUM_FORNECEDOR_NAME + "TEXT NOT NULL ")
                .append(");")
                .toString();

    }

}
