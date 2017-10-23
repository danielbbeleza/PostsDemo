package com.example.android.postsdemo.modelobjects.general;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.postsdemo.modelobjects.User.User;
import com.google.gson.annotations.Expose;

/**
 * Created by danielbeleza on 22/10/2017.
 */

public class CompletePost implements Parcelable {

    @Expose
    private Post mPost;
    @Expose
    private User mUser;

    public CompletePost(Post mPost, User mUser) {
        this.mPost = mPost;
        this.mUser = mUser;
    }

    public Post getmPost() {
        return mPost;
    }

    public void setmPost(Post mPost) {
        this.mPost = mPost;
    }

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    public static Creator<CompletePost> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mPost, flags);
        dest.writeParcelable(this.mUser, flags);
    }

    protected CompletePost(Parcel in) {
        this.mPost = in.readParcelable(Post.class.getClassLoader());
        this.mUser = in.readParcelable(User.class.getClassLoader());
    }

    public static final Parcelable.Creator<CompletePost> CREATOR = new Parcelable.Creator<CompletePost>() {
        @Override
        public CompletePost createFromParcel(Parcel source) {
            return new CompletePost(source);
        }

        @Override
        public CompletePost[] newArray(int size) {
            return new CompletePost[size];
        }
    };
}
