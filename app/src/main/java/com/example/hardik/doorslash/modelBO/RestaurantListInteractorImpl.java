package com.example.hardik.doorslash.modelBO;

import android.content.Context;

import com.example.hardik.doorslash.api.GitHubClient;
import com.example.hardik.doorslash.data.RestaurantList;
import com.example.hardik.doorslash.utils.ApiUtils;
import com.example.hardik.doorslash.utils.DSErrors;
import com.example.hardik.doorslash.utils.Preferences;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hardik on 9/16/2017.
 */
public class RestaurantListInteractorImpl implements RestaurantListInteractor {

    private GitHubClient mService;
    private WeakReference<Context> mContext;
    private OnRestListFinishedListener mListener;

    public RestaurantListInteractorImpl(WeakReference<Context> context) {
        this.mContext = context;
    }

    //API call to fetch restaurant list
    @Override
    public void getRestaurantList(double longi, double latti, final OnRestListFinishedListener listener) {
        mListener = listener;
        ApiUtils.getGitHubClient().restList(longi, latti).enqueue(new Callback<List<RestaurantList>>() {
            @Override
            public void onResponse(Call<List<RestaurantList>> call, Response<List<RestaurantList>> response) {
                List<RestaurantList> list = (List<RestaurantList>) response.body();
                listener.onSuccess(sortList(list));
            }

            @Override
            public void onFailure(Call<List<RestaurantList>> call, Throwable t) {
                listener.onError(new DSErrors(t));
            }
        });
    }

    // saving favorite items to shared preference
    //ToDO use SQLite for doing this
    @Override
    public void save(int position, ArrayList<RestaurantList> dataset) {
        //saving favorites
        RestaurantList data = dataset.get(position);
        Set<String> set = Preferences.getFavorites(mContext.get());
        String id = String.valueOf(data.getId());
        if (set.contains(id)) {
            set.remove(id);
        } else {
            set.add(id);
        }
        Preferences.setFavorites(mContext.get(), set);

        mListener.onSuccess(sortList(dataset));


    }

    // Sort the restaurant list based on favorite items on top
    private List<RestaurantList> sortList(List<RestaurantList> list) {
        List<RestaurantList> sortedList = new ArrayList<RestaurantList>();
        Set<String> set = Preferences.getFavorites(mContext.get());
        //adding boolean to keep track of favorited items.
        for (int i = 0; i < list.size(); i++) {

            RestaurantList data = list.get(i);
            if (set.contains("" + data.getId())) {
                data.setFavorited(true);
            } else {
                data.setFavorited(false);
            }

            sortedList.add(data);
        }
        Collections.sort(sortedList, new Comparator<RestaurantList>() {
            @Override
            public int compare(RestaurantList restaurantList, RestaurantList t1) {
                int b1 = restaurantList.isFavorited() ? 1 : 0;
                int b2 = t1.isFavorited() ? 1 : 0;

                return b2 - b1;
            }
        });

        return sortedList;
    }


}
