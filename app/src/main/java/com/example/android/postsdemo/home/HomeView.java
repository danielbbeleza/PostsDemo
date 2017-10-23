package com.example.android.postsdemo.home;

import com.example.android.postsdemo.modelobjects.general.CompletePost;

import java.util.List;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public interface HomeView {

    void showPosts(List<CompletePost> posts);

    void showErrorMessage();

    void showErrorMessageNoWifi();

    void showErrorMessageNoWifiNoData();

    void sendUserData();
}
