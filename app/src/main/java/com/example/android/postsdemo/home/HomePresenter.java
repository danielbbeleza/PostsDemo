package com.example.android.postsdemo.home;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public interface HomePresenter {
    void getPosts();

    void onAttach(HomeView view);

    void onDetach();
}
