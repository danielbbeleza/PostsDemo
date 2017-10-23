package com.example.android.postsdemo.detail;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public interface DetailPresenter {

    void getComments();

    void onAttach(DetailView detailView);

    void onDetach();
}
