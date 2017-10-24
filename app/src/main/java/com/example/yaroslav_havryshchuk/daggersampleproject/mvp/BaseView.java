package com.example.yaroslav_havryshchuk.daggersampleproject.mvp;

/**
 * Created by Yaroslav_Havryshchuk on 9/20/2017.
 */

public interface BaseView {
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
}
