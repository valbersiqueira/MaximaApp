package com.maxima.maximaapp.domain;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Fornecedor implements Parcelable{

    private Integer id;
    private String name;
    private int picture;

    public Fornecedor(Integer id, String name, int picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    protected Fornecedor(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        picture = in.readParcelable(Bitmap.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        dest.writeInt(picture);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Fornecedor> CREATOR = new Creator<Fornecedor>() {
        @Override
        public Fornecedor createFromParcel(Parcel in) {
            return new Fornecedor(in);
        }

        @Override
        public Fornecedor[] newArray(int size) {
            return new Fornecedor[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
