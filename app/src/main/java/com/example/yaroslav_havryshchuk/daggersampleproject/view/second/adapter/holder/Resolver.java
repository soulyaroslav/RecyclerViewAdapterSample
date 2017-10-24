package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder;

import android.view.ViewGroup;

/**
 * Created by Yaroslav_Havryshchuk on 10/24/2017.
 */

public interface Resolver<T> {

    T resolve(int type, ViewGroup parent);
}
