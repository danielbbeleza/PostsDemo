package com.example.android.postsdemo.home;

import com.example.android.postsdemo.modelobjects.general.Post;

import java.util.List;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public class HomePresenterImpl implements HomePresenter {

    private HomeModel mHomeModel;
    private HomeView mHomeView;

    private List<Post> mPostList = null;

    private States mStates;

    private enum States {
        ONSUCCESS, ONERROR, ONNOCONNECTION, ONNOCONNECTIONNOTADA
    }

    public HomePresenterImpl(HomeView homeView, HomeModel homeModel) {
        this.mHomeModel = homeModel;
        this.mHomeView = homeView;
    }

    private void renderView() {

        switch (mStates) {
            case ONSUCCESS:
                mHomeView.showPosts(mPostList);
                break;

            case ONERROR:
                mHomeView.showErrorMessage();
                break;

            case ONNOCONNECTION:
                mHomeView.showErrorMessageNoWifi();
                break;

            case ONNOCONNECTIONNOTADA:
                mHomeView.showErrorMessageNoWifiNoData();
                break;
            default:
                break;
        }
    }

    @Override
    public void getPosts() {
        mHomeModel.getPosts(new HomeModel.CallbackPosts() {
            @Override
            public void onSuccess(List<Post> posts) {
                mStates = States.ONSUCCESS;
                mPostList = posts;

                renderView();
            }

            @Override
            public void onError() {
                mStates = States.ONERROR;

                renderView();
            }

            @Override
            public void onNoConnection() {
                mStates = States.ONNOCONNECTION;

                renderView();
            }

            @Override
            public void onNoConnectionNoData() {
                mStates = States.ONNOCONNECTIONNOTADA;

                renderView();
            }
        });
    }

    @Override
    public void onAttach(HomeView view) {
        mHomeView = view;

        renderView();
    }

    @Override
    public void onDetach() {
        mHomeView = null;
    }
}
