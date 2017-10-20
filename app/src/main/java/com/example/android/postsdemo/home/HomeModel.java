package com.example.android.postsdemo.home;

import com.example.android.postsdemo.modelobjects.general.Post;

import java.util.List;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public interface HomeModel {

    void getPosts(CallbackPosts callbackPosts);

    interface CallbackPosts{
        void onSuccess(List<Post> posts);

        void onError();

        void onNoConnection();

        void onNoConnectionNoData();
    }


}
