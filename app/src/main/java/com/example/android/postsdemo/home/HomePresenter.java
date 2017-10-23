package com.example.android.postsdemo.home;

import com.example.android.postsdemo.BasePresenter;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public interface HomePresenter extends BasePresenter {
    void getPosts();

    void onAttach(HomeView view);

    void onDetach();
}
