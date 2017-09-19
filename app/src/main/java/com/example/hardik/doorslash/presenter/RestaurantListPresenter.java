package com.example.hardik.doorslash.presenter;

import android.view.View;

import com.example.hardik.doorslash.data.RestaurantList;

import java.util.ArrayList;

/**
 * Created by Hardik on 9/16/2017.
 */
public interface RestaurantListPresenter {

    void showRestList();

    void onDestroy();

    void saveFavorite(int position, ArrayList<RestaurantList> dataset);
}
