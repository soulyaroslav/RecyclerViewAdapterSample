package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.factory;

import android.view.ViewGroup;

import com.example.yaroslav_havryshchuk.daggersampleproject.R;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.base.BaseViewHolderFactory;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder.HeaderViewHolder;

import javax.inject.Inject;

/**
 * Created by Yaroslav_Havryshchuk on 9/29/2017.
 */

public class HeaderViewHolderFactory extends BaseViewHolderFactory<HeaderViewHolder> {

    @Inject
    public HeaderViewHolderFactory(ViewFactory factory) {
        super(factory);
    }

    @Override
    public HeaderViewHolder create(ViewGroup parent) {
        return new HeaderViewHolder(factory.create(parent, R.layout.header));
    }
}
