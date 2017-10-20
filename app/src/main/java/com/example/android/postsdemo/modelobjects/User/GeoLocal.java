package com.example.android.postsdemo.modelobjects.User;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public class GeoLocal implements Parcelable {

    @Expose
    private String mLatitude;
    @Expose
    private String mLongitude;

    public GeoLocal(String mLatitude, String mLongitude) {
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mLatitude);
        dest.writeString(this.mLongitude);
    }

    public GeoLocal() {
    }

    protected GeoLocal(Parcel in) {
        this.mLatitude = in.readString();
        this.mLongitude = in.readString();
    }

    public static final Parcelable.Creator<GeoLocal> CREATOR = new Parcelable.Creator<GeoLocal>() {
        @Override
        public GeoLocal createFromParcel(Parcel source) {
            return new GeoLocal(source);
        }

        @Override
        public GeoLocal[] newArray(int size) {
            return new GeoLocal[size];
        }
    };
}
