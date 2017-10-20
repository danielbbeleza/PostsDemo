package com.example.android.postsdemo.home;

import com.example.android.postsdemo.modelobjects.general.Post;

import java.util.List;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public interface HomeView {

    void showPosts(List<Post> posts);

    void showErrorMessage();

    void showErrorMessageNoWifi();

    void showErrorMessageNoWifiNoData();
}
