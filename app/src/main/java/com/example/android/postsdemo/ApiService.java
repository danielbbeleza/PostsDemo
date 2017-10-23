package com.example.android.postsdemo;

import com.example.android.postsdemo.modelobjects.User.User;
import com.example.android.postsdemo.modelobjects.general.Comments;
import com.example.android.postsdemo.modelobjects.general.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public interface ApiService {

    @GET("users")
    Call<List<User>> getAllUsers();

    @GET("comments")
    Call<List<Comments>> getAllComments();

    @GET("posts")
    Call<List<Post>> getAllPosts();
}
