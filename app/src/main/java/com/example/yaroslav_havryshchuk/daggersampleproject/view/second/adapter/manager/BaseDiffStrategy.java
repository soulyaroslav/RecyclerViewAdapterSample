package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.manager;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by Yaroslav_Havryshchuk on 10/10/2017.
 */

public abstract class BaseDiffStrategy<T> extends DiffUtil.Callback {

    protected List<T> oldList;
    protected List<T> newList;

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }
}
