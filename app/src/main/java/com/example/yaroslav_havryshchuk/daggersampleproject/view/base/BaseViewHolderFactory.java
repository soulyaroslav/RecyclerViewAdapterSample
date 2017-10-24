package com.example.yaroslav_havryshchuk.daggersampleproject.view.base;

import android.view.ViewGroup;

import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.factory.ViewFactory;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder.BaseViewHolder;

/**
 * Created by Yaroslav_Havryshchuk on 9/29/2017.
 */

public abstract class BaseViewHolderFactory<VH extends BaseViewHolder<?>> {

    protected ViewFactory factory;

    public BaseViewHolderFactory(ViewFactory factory) {
        this.factory = factory;
    }

    public abstract VH create(ViewGroup parent);
}
