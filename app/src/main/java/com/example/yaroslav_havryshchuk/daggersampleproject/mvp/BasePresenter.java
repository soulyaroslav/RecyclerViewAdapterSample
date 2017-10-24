package com.example.yaroslav_havryshchuk.daggersampleproject.mvp;

/**
 * Created by Yaroslav_Havryshchuk on 9/19/2017.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
    T getView();
}
