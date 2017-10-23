package com.example.android.postsdemo.detail;

import com.example.android.postsdemo.modelobjects.general.Comments;

import java.util.List;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public interface DetailModel {

    void getComments(CallbackGetComments callbackGetComments);

    interface CallbackGetComments{
        void onSuccess(List<Comments> commentsList);

        void onError();

        void onConnectionError();

        void onConnectionNoDataError();
    }
}
