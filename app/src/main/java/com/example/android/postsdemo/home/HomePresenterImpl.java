package com.example.android.postsdemo.home;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public class HomePresenterImpl implements HomePresenter {

    private HomeModel mHomeModel;
    private HomeView mHomeView;

    HomePresenterImpl(HomeModel homeModel){
        this.mHomeModel = homeModel;
    }

    @Override
    public void getPosts() {

    }

    @Override
    public void onAttach(HomeView view) {

    }

    @Override
    public void onDetach() {

    }
}
