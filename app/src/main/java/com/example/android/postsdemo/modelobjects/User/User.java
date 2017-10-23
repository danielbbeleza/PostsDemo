package com.example.android.postsdemo.modelobjects.User;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public class User implements Parcelable {
    @Expose
    @SerializedName("id")
    private int mID;
    @Expose
    @SerializedName("name")
    private String mName;
    @Expose
    @SerializedName("username")
    private String mUsername;
    @Expose
    @SerializedName("email")
    private String mEmail;
    @Expose
    @SerializedName("address")
    private Address mAddress;
    @Expose
    @SerializedName("company")
    private Company mCompany;

    public User(int mID, String mName, String mUsername, String mEmail, Address mAddress, Company mCompany) {
        this.mID = mID;
        this.mName = mName;
        this.mUsername = mUsername;
        this.mEmail = mEmail;
        this.mAddress = mAddress;
        this.mCompany = mCompany;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public Address getmAddress() {
        return mAddress;
    }

    public void setmAddress(Address mAddress) {
        this.mAddress = mAddress;
    }

    public Company getmCompany() {
        return mCompany;
    }

    public void setmCompany(Company mCompany) {
        this.mCompany = mCompany;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mID);
        dest.writeString(this.mName);
        dest.writeString(this.mUsername);
        dest.writeString(this.mEmail);
        dest.writeParcelable(this.mAddress, flags);
        dest.writeParcelable(this.mCompany, flags);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.mID = in.readInt();
        this.mName = in.readString();
        this.mUsername = in.readString();
        this.mEmail = in.readString();
        this.mAddress = in.readParcelable(Address.class.getClassLoader());
        this.mCompany = in.readParcelable(Company.class.getClassLoader());
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
