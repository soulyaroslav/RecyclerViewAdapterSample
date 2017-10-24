package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.factory;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

/**
 * Created by Yaroslav_Havryshchuk on 10/11/2017.
 */

public interface BaseViewFactory<T> {
    T create(ViewGroup parent, @LayoutRes int layout);
}
