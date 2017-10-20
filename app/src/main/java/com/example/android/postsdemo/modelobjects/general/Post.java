package com.example.android.postsdemo.modelobjects.general;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public class Post implements Parcelable {

    private int mUserId;
    private int mId;
    private String mTitle;
    private String mBody;

    public Post(int userID, int ID, String title, String body){
        this.mUserId = userID;
        this.mId = ID;
        this.mTitle = title;
        this.mBody = body;
    }

    public int getmUserId() {
        return mUserId;
    }

    public void setmUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
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
        dest.writeLong(this.mUserId);
        dest.writeLong(this.mId);
        dest.writeString(this.mTitle);
        dest.writeString(this.mBody);
    }

    protected Post(Parcel in) {
        this.mUserId = in.readInt();
        this.mId = in.readInt();
        this.mTitle = in.readString();
        this.mBody = in.readString();
    }

    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel source) {
            return new Post(source);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}
