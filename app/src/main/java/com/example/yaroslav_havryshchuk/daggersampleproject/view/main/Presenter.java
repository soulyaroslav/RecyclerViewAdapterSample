package com.example.yaroslav_havryshchuk.daggersampleproject.view.main;

import android.content.Context;
import android.widget.Toast;

import com.example.yaroslav_havryshchuk.daggersampleproject.pref.MySharedPreferences;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Yaroslav_Havryshchuk on 9/15/2017.
 */

public class Presenter implements MainContract.Presenter<MainView> {

    private MainView view;

    @Inject
    public Presenter(MySharedPreferences preferences, @Named("Activity") Context context) {
        if(preferences != null) {
            Toast.makeText(context, "Presenter: preferences is not null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void attachView(MainView view) {
        this.view = view;
        getView().showMessage("Message");
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public MainView getView() {
        if(view != null) return view;
        throw new RuntimeException("View is not attached");
    }
}
