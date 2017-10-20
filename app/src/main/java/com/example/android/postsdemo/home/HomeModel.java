package com.example.android.postsdemo.home;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public interface HomeModel {

    void getPosts(CallbackPosts callbackPosts);

    interface CallbackPosts{
        void onSuccess();

        void onError();

        void onNoConnection();

        void onNoConnectionNoData();
    }


}
