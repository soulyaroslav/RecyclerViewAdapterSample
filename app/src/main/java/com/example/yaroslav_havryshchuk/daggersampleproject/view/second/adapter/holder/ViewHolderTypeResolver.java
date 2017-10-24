package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder;

import android.view.ViewGroup;

import com.example.yaroslav_havryshchuk.daggersampleproject.view.base.BaseViewHolderFactory;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Yaroslav_Havryshchuk on 10/24/2017.
 */

public class ViewHolderTypeResolver implements Resolver<BaseViewHolder>{

    private Map<Integer, BaseViewHolderFactory> factories;

    @Inject
    public ViewHolderTypeResolver(Map<Integer, BaseViewHolderFactory> factories) {
        this.factories = factories;
    }

    @Override
    public BaseViewHolder resolve(int type, ViewGroup parent) {
        return factories.get(type).create(parent);
    }
}
