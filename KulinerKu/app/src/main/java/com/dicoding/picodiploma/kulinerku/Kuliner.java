package com.dicoding.picodiploma.kulinerku;

import android.os.Parcel;
import android.os.Parcelable;

public class Kuliner implements Parcelable{
    private String name, remarks, asal, deskripsi,photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getRemarks() {
        return remarks;
    }

    void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    String getPhoto() {
        return photo;
    }

    void setPhoto(String photo) {
        this.photo = photo;
    }

    String getAsal() {
        return asal;
    }

    void setAsal(String asal) {
        this.asal= asal;
    }

    String getDeskripsi() {
        return deskripsi;
    }

    void setDeskripsi(String deskripsi) {
        this.deskripsi= deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
        dest.writeString(this.asal);
        dest.writeString(this.deskripsi);
    }

    Kuliner(){

    }

    private Kuliner(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
        this.asal = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Parcelable.Creator<Kuliner> CREATOR = new Parcelable.Creator<Kuliner>() {
        @Override
        public Kuliner createFromParcel(Parcel source) {
            return new Kuliner(source);
        }
        @Override
        public Kuliner[] newArray(int size) {
            return new Kuliner[size];
        }
    };

}
