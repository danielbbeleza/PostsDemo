package com.example.android.postsdemo.modelobjects.general;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public class Comment implements Parcelable {

    @Expose
    private int mPostID;
    @Expose
    private int mID;
    @Expose
    private String mEmail;
    @Expose
    private String mBody;

    public Comment(int mPostID, int mID, String mEmail, String mBody) {
        this.mPostID = mPostID;
        this.mID = mID;
        this.mEmail = mEmail;
        this.mBody = mBody;
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
    }

    protected Comment(Parcel in) {
        this.mPostID = in.readInt();
        this.mID = in.readInt();
        this.mEmail = in.readString();
        this.mBody = in.readString();
    }

    public static final Parcelable.Creator<Comment> CREATOR = new Parcelable.Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel source) {
            return new Comment(source);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };
}
