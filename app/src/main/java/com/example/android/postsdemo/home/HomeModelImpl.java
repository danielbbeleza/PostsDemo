package com.example.android.postsdemo.home;

import com.example.android.postsdemo.ApiService;
import com.example.android.postsdemo.RetrofitClient;
import com.example.android.postsdemo.modelobjects.User.User;
import com.example.android.postsdemo.modelobjects.general.CompletePost;
import com.example.android.postsdemo.modelobjects.general.Post;

import java.util.ArrayList;
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

    private void getPostsApiService(final CallbackPosts callbackPosts) {

        /** Get all Posts Service **/
        ApiService postService = RetrofitClient.getClient(RetrofitClient.BASE_URL).create(ApiService.class);

        postService.getAllPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, final Response<List<Post>> postResponse) {

                /** Get all Users Service **/
                ApiService userService = RetrofitClient.getClient(RetrofitClient.BASE_URL).create(ApiService.class);

                userService.getAllUsers().enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> userResponse) {
                        callbackPosts.onSuccess(mergePostUser(postResponse.body(), userResponse.body()));

                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                callbackPosts.onError();
            }
        });
    }

    // Merge list of posts with list of users
    private List<CompletePost> mergePostUser(List<Post> posts, List<User> users) {

        List<CompletePost> completePosts = new ArrayList<>();

        for (Post post : posts) {
            for (User user : users) {
                if (post.getmUserId() == users.get(0).getmID()) {
                    completePosts.add(new CompletePost(post, user));
                }
            }
        }

        return completePosts;
    }
}
