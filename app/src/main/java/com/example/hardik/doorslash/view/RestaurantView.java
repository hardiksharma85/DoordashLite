package com.example.hardik.doorslash.view;

import com.example.hardik.doorslash.data.RestaurantList;

import java.util.List;

/**
 * Created by Hardik on 9/16/2017.
 */
public interface RestaurantView {

    void showProgress();

    void hideProgress();

    void setErrorMsg(String errorMessage);

    void display(boolean isNetwork);

    void setData(List<RestaurantList> list);
}
