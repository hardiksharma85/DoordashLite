package com.example.hardik.doorslash.modelBO;

import android.content.Context;
import android.view.View;

import com.example.hardik.doorslash.data.RestaurantList;
import com.example.hardik.doorslash.utils.DSErrors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hardik on 9/16/2017.
 */
public interface RestaurantListInteractor {

    interface OnRestListFinishedListener {

        void onError(DSErrors dsErrors);

        void onSuccess(List<RestaurantList> body);
    }

    void save(int position, ArrayList<RestaurantList> dataset);

    void getRestaurantList(double longi, double latti, OnRestListFinishedListener listener);


}
