package com.example.android.postsdemo.modelobjects.general;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public class Comments implements Parcelable {

    @Expose
    @SerializedName("postId")
    private int mPostID;
    @Expose
    @SerializedName("id")
    private int mID;
    @Expose
    @SerializedName("email")
    private String mEmail;
    @Expose
    @SerializedName("body")
    private String mBody;
    @Expose
    @SerializedName("name")
    private String mName;

    public Comments(int mPostID, int mID, String mEmail, String mBody, String mName) {
        this.mPostID = mPostID;
        this.mID = mID;
        this.mEmail = mEmail;
        this.mBody = mBody;
        this.mName = mName;
    }

    public int getmPostID() {
        return mPostID;
    }

    public void setmPostID(int mPostID) {
        this.mPostID = mPostID;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmBody() {
        return mBody;
    }

    public void setmBody(String mBody) {
        this.mBody = mBody;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mPostID);
        dest.writeInt(this.mID);
        dest.writeString(this.mEmail);
        dest.writeString(this.mBody);
        dest.writeString(this.mName);
    }

    protected Comments(Parcel in) {
        this.mPostID = in.readInt();
        this.mID = in.readInt();
        this.mEmail = in.readString();
        this.mBody = in.readString();
        this.mName = in.readString();
    }

    public static final Creator<Comments> CREATOR = new Creator<Comments>() {
        @Override
        public Comments createFromParcel(Parcel source) {
            return new Comments(source);
        }

        @Override
        public Comments[] newArray(int size) {
            return new Comments[size];
        }
    };
}
