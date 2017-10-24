package com.example.yaroslav_havryshchuk.daggersampleproject.di;

import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.SecondActivity;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.SecondActivityModule;
import com.example.yaroslav_havryshchuk.daggersampleproject.di.scope.PerActivity;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.main.MainActivity;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.main.module.MainActivityModule;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.ViewHolderFactoryModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Yaroslav_Havryshchuk on 9/14/2017.
 */

@Module
public abstract class ActivityBuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = {SecondActivityModule.class, ViewHolderFactoryModule.class})
    abstract SecondActivity bindSecondActivity();
}
