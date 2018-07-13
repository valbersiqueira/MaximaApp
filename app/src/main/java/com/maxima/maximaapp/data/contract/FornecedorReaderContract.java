package com.maxima.maximaapp.data.contract;

import android.provider.BaseColumns;

public final class FornecedorReaderContract {

    private FornecedorReaderContract() {
    }

    public static final class FornecedorEntry implements BaseColumns {

        public static final String TABLE_NAME = "fornecedor";
        public static final String COLUM_NAME = "nome";
        public static final String COLUM_FOTO = "foto_id";
    }
}
