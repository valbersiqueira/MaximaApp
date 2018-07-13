package com.maxima.maximaapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable{

    private Integer codigo;
    private String descricao;
    private Fornecedor fornecedor;


    protected Produto(Parcel in) {
        if (in.readByte() == 0) {
            codigo = null;
        } else {
            codigo = in.readInt();
        }
        descricao = in.readString();
        fornecedor = in.readParcelable(Fornecedor.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (codigo == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(codigo);
        }
        dest.writeString(descricao);
        dest.writeParcelable(fornecedor, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
