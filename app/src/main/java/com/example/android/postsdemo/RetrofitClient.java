package com.example.android.postsdemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by danielbeleza on 20/10/2017.
 */

public class RetrofitClient {

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private static Retrofit sRetrofit = null;

    public static Retrofit getClient(String baseUrl){

        if(sRetrofit == null){

            Gson gson = new GsonBuilder()
                    .setLenient() //This option makes the parser liberal in what it accepts. By default GSON is strict and only accepts JSON
                    .create();

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(loggingInterceptor);

            sRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
        }
        return sRetrofit;
    }
}
