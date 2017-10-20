package com.example.android.postsdemo.home;

import com.example.android.postsdemo.ApiService;
import com.example.android.postsdemo.RetrofitClient;
import com.example.android.postsdemo.modelobjects.general.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public class HomeModelImpl implements HomeModel {

    @Override
    public void getPosts(CallbackPosts callbackPosts) {
        getPostsApiService(callbackPosts);
    }

    private void getPostsApiService(final CallbackPosts callbackPosts){
        ApiService service = RetrofitClient.getClient(RetrofitClient.BASE_URL).create(ApiService.class);

        service.getAllPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                callbackPosts.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                callbackPosts.onError();
            }
        });
    }
}
