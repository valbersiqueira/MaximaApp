package com.maxima.maximaapp.data.contract;

import android.provider.BaseColumns;

public final class ProdutoReaderContact {

    private ProdutoReaderContact() {
    }

    public static final class ProdutoEntry implements BaseColumns {
        public static final String TABLE_NAME = "produto";
        public static final String COLUM_CODIGO_ID = "codigo";
        public static final String COLUM_DESCRICAO_NAME = "descricao";
        public static final String COLUM_FORNECEDOR_ID = "fornecedor_id";
    }
}
