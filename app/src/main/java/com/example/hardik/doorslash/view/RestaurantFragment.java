package com.example.hardik.doorslash.view;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hardik.doorslash.R;
import com.example.hardik.doorslash.adapters.RestaurantItemAdapter;
import com.example.hardik.doorslash.data.RestaurantList;
import com.example.hardik.doorslash.modelBO.RestaurantListInteractorImpl;
import com.example.hardik.doorslash.presenter.RestaurantListPresenter;
import com.example.hardik.doorslash.presenter.RestaurantListPresenterImpl;
import com.example.hardik.doorslash.utils.ClickListener;
import com.example.hardik.doorslash.utils.Commons;
import com.example.hardik.doorslash.utils.RecyclerItemDecoration;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hardik on 9/16/2017.
 */
public class RestaurantFragment extends Fragment implements RestaurantView, ClickListener {

    private View mView;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayoutManager mLinearLayoutManager;
    private RestaurantListPresenter restPresenter;
    private ArrayList<RestaurantList> mDataSet;
    private RestaurantItemAdapter mAdapter;

    //////////////////////////////////////////////////////////////
    ////////// Activity Life cycle methods
    //////////////////////////////////////////////////////////////

    @Override
    public View onCreateView(LayoutInflater inflater
            , @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.restaurant_list, container, false);
        RestaurantListInteractorImpl mInteractor = new RestaurantListInteractorImpl(new WeakReference<Context>(getActivity().getApplicationContext()));
        restPresenter = new RestaurantListPresenterImpl(this, mInteractor);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.item_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setEnabled(false);
        mLinearLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addItemDecoration(new RecyclerItemDecoration(2));
        mDataSet = new ArrayList<>();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }


    @Override
    public void onDestroyView() {
        restPresenter.onDestroy();
        super.onDestroyView();
    }


    @Override
    public void showProgress() {
        mSwipeRefreshLayout.setRefreshing( true );
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setErrorMsg(String errorMessage) {
        Commons.showToast(getActivity(), errorMessage);
    }

    @Override
    public void display(boolean isNetwork) {

    }

    @Override
    public void setData(List<RestaurantList> list) {
        mDataSet.clear();
        mDataSet.addAll(list);

        if (mRecyclerView.getAdapter() == null) {
            mAdapter = new RestaurantItemAdapter(getActivity(), mDataSet);
            mAdapter.setOnItemClickListener(this);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(int position, View v, ArrayList<RestaurantList> dataset, String name) {
        //inform presenter regarding favorite clicked
        if (name.equalsIgnoreCase(Commons.FAVORITE)) {
            if (restPresenter != null)
                restPresenter.saveFavorite(position, dataset);

        }

    }

}
