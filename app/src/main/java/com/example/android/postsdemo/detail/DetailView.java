package com.example.android.postsdemo.detail;

import com.example.android.postsdemo.modelobjects.general.Comments;

import java.util.List;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public interface DetailView {

    void showComments(List<Comments> commentList);

    void onError();

    void onConnectionError();

    void onConnectionErrorNoData();

}
