package com.example.hardik.doorslash.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hardik.
 */

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private static String BASE_URL = "https://api.doordash.com";

    // Keep your services here, build them in buildRetrofit method later
    private static GitHubClient service;

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }

        return instance;
    }

    // Build retrofit once when creating a single instance
    private RetrofitClient() {
        // Implement a method to build your retrofit
        getClient();
    }


    private static void getClient() {
//            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//            // set your desired log level
//            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//           // add your other interceptors …
//
//           // add logging as last interceptor
//            httpClient.addInterceptor(logging);

            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();

            // Build your services once
            service = retrofit.create(GitHubClient.class);

    }

    public GitHubClient getService() {
        return service;
    }
}
