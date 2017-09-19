package com.example.hardik.doorslash;

import android.test.mock.MockDialogInterface;

import com.example.hardik.doorslash.data.RestaurantList;
import com.example.hardik.doorslash.modelBO.RestaurantListInteractor;
import com.example.hardik.doorslash.presenter.RestaurantListPresenter;
import com.example.hardik.doorslash.presenter.RestaurantListPresenterImpl;
import com.example.hardik.doorslash.utils.Constants;
import com.example.hardik.doorslash.view.RestaurantView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by hardik on 9/18/2017.
 */

public class RestaurantListPresenterTest {
    @Mock
    RestaurantListPresenter presenter;

    @Mock
    RestaurantListInteractor interactor;

    @Mock
    RestaurantView view;

    @Mock
    RestaurantListInteractor.OnRestListFinishedListener listener;


    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        presenter = new RestaurantListPresenterImpl(view, interactor);
    }

    @Test
    public void testInteractorCalled() {
        presenter.showRestList();
        verify(view).showProgress();
    }

}
