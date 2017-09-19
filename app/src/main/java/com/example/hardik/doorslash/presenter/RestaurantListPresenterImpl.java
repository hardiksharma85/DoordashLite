package com.example.hardik.doorslash.presenter;

import com.example.hardik.doorslash.data.RestaurantList;
import com.example.hardik.doorslash.modelBO.RestaurantListInteractor;
import com.example.hardik.doorslash.utils.Constants;
import com.example.hardik.doorslash.utils.DSErrors;
import com.example.hardik.doorslash.view.RestaurantView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hardik on 9/16/2017.
 */
public class RestaurantListPresenterImpl implements RestaurantListPresenter, RestaurantListInteractor.OnRestListFinishedListener {

    private RestaurantView mView;
    private RestaurantListInteractor mInteractor;

    public RestaurantListPresenterImpl(RestaurantView view, RestaurantListInteractor interatoc) {
        mView = view;
        mInteractor = interatoc;
        showRestList();
    }

    @Override
    public void showRestList() {
        mInteractor.getRestaurantList(Constants.CONS_LAT, Constants.CONS_LONG, this);
    }

    public void onDestroy() {
        mView = null;
    }

    @Override
    public void onError(DSErrors dsErrors) {
        if (mView != null) {
            mView.setErrorMsg(dsErrors.getErrorMessage());
        }
    }

    @Override
    public void onSuccess(List<RestaurantList> list) {
        if (mView != null) {
            mView.hideProgress();
            mView.setData(list);
        }
    }


    @Override
    public void saveFavorite(int position, ArrayList<RestaurantList> dataset) {
        mInteractor.save(position, dataset);
    }
}
