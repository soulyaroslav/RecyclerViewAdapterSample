package com.example.yaroslav_havryshchuk.daggersampleproject.view.second;

import android.content.Context;

import com.example.yaroslav_havryshchuk.daggersampleproject.di.scope.PerActivity;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.Adapter;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.OnItemClickListener;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.OnItemClickListenerIpl;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.manager.Updatable;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Yaroslav_Havryshchuk on 9/15/2017.
 */

@Module(subcomponents = SecondActivityModule.class)
public abstract class SecondActivityModule {

    @Binds
    @PerActivity
    @Named("Activity")
    abstract Context activityContext(SecondActivity activity);

    @Binds
    @PerActivity
    abstract OnItemClickListener onItemClickListener(OnItemClickListenerIpl ipl);

    @Binds
    @PerActivity
    abstract Updatable<String> updater(Adapter adapter);
}
