package com.example.android.postsdemo.modelobjects.User;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public class Address implements Parcelable {

    private String mStreet;
    private String mSuite;
    private String mCity;
    private String mZipCode;
    private GeoLocal mGeoLocal;

    public Address(String mStreet, String mSuite, String mCity, String mZipCode, GeoLocal mGeoLocal) {
        this.mStreet = mStreet;
        this.mSuite = mSuite;
        this.mCity = mCity;
        this.mZipCode = mZipCode;
        this.mGeoLocal = mGeoLocal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mStreet);
        dest.writeString(this.mSuite);
        dest.writeString(this.mCity);
        dest.writeString(this.mZipCode);
        dest.writeParcelable(this.mGeoLocal, flags);
    }

    public Address() {
    }

    protected Address(Parcel in) {
        this.mStreet = in.readString();
        this.mSuite = in.readString();
        this.mCity = in.readString();
        this.mZipCode = in.readString();
        this.mGeoLocal = in.readParcelable(GeoLocal.class.getClassLoader());
    }

    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel source) {
            return new Address(source);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
}
