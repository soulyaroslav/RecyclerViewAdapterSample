package com.example.yaroslav_havryshchuk.daggersampleproject.view.main;

import com.example.yaroslav_havryshchuk.daggersampleproject.mvp.BasePresenter;
import com.example.yaroslav_havryshchuk.daggersampleproject.mvp.BaseView;

/**
 * Created by Yaroslav_Havryshchuk on 9/15/2017.
 */

public interface MainContract {
    interface View extends BaseView {
        void showMessage(String message);
    }

    interface Presenter<T extends BaseView> extends BasePresenter<T> {

    }
}
