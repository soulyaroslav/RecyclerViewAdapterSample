package com.example.yaroslav_havryshchuk.daggersampleproject.view.main;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Yaroslav_Havryshchuk on 9/15/2017.
 */

public class MainView implements MainContract.View {

    @Inject
    public MainView() {
        Log.d("TAG", "MainView: implementation");
    }

    @Override
    public void showMessage(String message) {
        Log.d("TAG", message);
    }

    @Override
    public void onStart() {
        // use if need
    }

    @Override
    public void onResume() {
        // use if need
    }

    @Override
    public void onPause() {
        // use if need
    }

    @Override
    public void onStop() {
        // use if need
    }

    @Override
    public void onDestroy() {
        // use if need
    }
}
