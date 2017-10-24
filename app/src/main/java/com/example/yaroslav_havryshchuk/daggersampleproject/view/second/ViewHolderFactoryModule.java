package com.example.yaroslav_havryshchuk.daggersampleproject.view.second;

import com.example.yaroslav_havryshchuk.daggersampleproject.view.base.BaseViewHolderFactory;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.factory.HeaderViewHolderFactory;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.factory.ItemViewHolderFactory;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder.HolderType;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

/**
 * Created by Yaroslav_Havryshchuk on 10/11/2017.
 */

@Module
public abstract class ViewHolderFactoryModule {

    @Binds
    @IntoMap
    @IntKey(HolderType.HEADER_TYPE)
    abstract BaseViewHolderFactory bindHeaderViewHolderFactory(HeaderViewHolderFactory factory);

    @Binds
    @IntoMap
    @IntKey(HolderType.ITEM_TYPE)
    abstract BaseViewHolderFactory bindItemViewHolderFactory(ItemViewHolderFactory factory);
}
