package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.factory;

import android.view.ViewGroup;

import com.example.yaroslav_havryshchuk.daggersampleproject.R;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.base.BaseViewHolderFactory;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.Adapter;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder.ItemViewHolder;

import javax.inject.Inject;

/**
 * Created by Yaroslav_Havryshchuk on 9/29/2017.
 */

public class ItemViewHolderFactory extends BaseViewHolderFactory<ItemViewHolder> {

    @Inject
    public ItemViewHolderFactory(ViewFactory factory) {
        super(factory);
    }

    @Override
    public ItemViewHolder create(ViewGroup parent) {
        return new ItemViewHolder(factory.create(parent, R.layout.item));
    }
}
