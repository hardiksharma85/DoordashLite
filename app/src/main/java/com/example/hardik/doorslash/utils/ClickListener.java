package com.example.hardik.doorslash.utils;

import android.view.View;

import com.example.hardik.doorslash.data.RestaurantList;

import java.util.ArrayList;

public interface ClickListener {
    public void onItemClick(int position, View v, ArrayList<RestaurantList> dataset,String name);
}
