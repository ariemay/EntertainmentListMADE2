package com.ariemay.entertainmentlistmade2.models;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;

public class TV implements Parcelable {
    private String tv_name;
    private String tv_genre;
    private int tv_startYear;
    private int tv_endYear;
    private String tv_description;
    private int tv_photo;

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_genre() {
        return tv_genre;
    }

    public void setTv_genre(String tv_genre) {
        this.tv_genre = tv_genre;
    }

    public int getTv_startYear() {
        return tv_startYear;
    }

    public void setTv_startYear(int tv_startYear) {
        this.tv_startYear = tv_startYear;
    }

    public int getTv_endYear() {
        return tv_endYear;
    }

    public void setTv_endYear(int tv_endYear) {
        this.tv_endYear = tv_endYear;
    }

    public String getTv_description() {
        return tv_description;
    }

    public void setTv_description(String tv_description) {
        this.tv_description = tv_description;
    }

    public int getTv_photo() {
        return tv_photo;
    }

    public void setTv_photo(int tv_photo) {
        this.tv_photo = tv_photo;
    }

    protected TV(Parcel in) {
        tv_name = in.readString();
        tv_genre = in.readString();
        tv_startYear = in.readInt();
        tv_endYear = in.readInt();
        tv_description = in.readString();
        tv_photo = in.readInt();
    }

    public static final Creator<TV> CREATOR = new Creator<TV>() {
        @Override
        public TV createFromParcel(Parcel in) {
            return new TV(in);
        }

        @Override
        public TV[] newArray(int size) {
            return new TV[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tv_name);
        dest.writeString(tv_genre);
        dest.writeInt(tv_startYear);
        dest.writeInt(tv_endYear);
        dest.writeString(tv_description);
        dest.writeInt(tv_photo);
    }

    public TV() {

    }
}
