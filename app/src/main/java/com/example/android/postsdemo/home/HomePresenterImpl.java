package com.example.android.postsdemo.home;

import com.example.android.postsdemo.BasePresenter;
import com.example.android.postsdemo.modelobjects.general.CompletePost;

import java.util.List;

/**
 * Created by danielbeleza on 19/10/2017.
 */

public class HomePresenterImpl implements HomePresenter, BasePresenter {

    private Long presenterID;

    private HomeModel mHomeModel;
    private HomeView mHomeView;

    private List<CompletePost> mPostList;

    private States mStates;

    private enum States {
        ONSUCCESS, ONERROR, ONNOCONNECTION, ONNOCONNECTIONNOTADA
    }

    public HomePresenterImpl(HomeModel homeModel) {
        this.mHomeModel = homeModel;
    }

    private void renderView() {

        // If mHomeView was null, we were forcing a method in an empty instance *
        if(mHomeView != null) {
            // If mStates was null, then in the switch condition it would crash
            if(mStates != null) {

                switch (mStates) {
                    case ONSUCCESS:
                        mHomeView.showPosts(mPostList); // *
                        break;

                    case ONERROR:
                        mHomeView.showErrorMessage(); // *
                        break;

                    case ONNOCONNECTION:
                        mHomeView.showErrorMessageNoWifi(); // *
                        break;

                    case ONNOCONNECTIONNOTADA:
                        mHomeView.showErrorMessageNoWifiNoData(); // *
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void getPosts() {
        mHomeModel.getPosts(new HomeModel.CallbackPosts() {
            @Override
            public void onSuccess(List<CompletePost> completePosts) {
                mStates = States.ONSUCCESS;
                mPostList = completePosts;

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

    @Override
    public Long getPresenterID() {
        return presenterID;
    }

    @Override
    public void setPresenterID(Long presenterID) {
        this.presenterID = presenterID;
    }
}
