package com.example.hardik.doorslash.api;

import com.example.hardik.doorslash.data.RestaurantList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by hardik
 */

public interface GitHubClient {
    @Headers("Content-Type: application/json")
    @GET("/v2/restaurant/")
    Call<List<RestaurantList>> restList(@Query("lat") double lat, @Query("lng") double lng);
}
