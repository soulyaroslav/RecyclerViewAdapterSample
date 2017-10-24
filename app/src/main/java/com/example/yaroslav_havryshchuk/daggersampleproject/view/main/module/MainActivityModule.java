package com.example.yaroslav_havryshchuk.daggersampleproject.view.main.module;

import android.content.Context;

import com.example.yaroslav_havryshchuk.daggersampleproject.di.scope.PerActivity;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.main.MainActivity;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.main.MainContract;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.main.MainView;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.main.Presenter;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Yaroslav_Havryshchuk on 9/15/2017.
 */

@Module
public abstract class MainActivityModule {

    @Binds
    @PerActivity
    @Named("Activity")
    abstract Context activityContext(MainActivity activity);

    @Binds
    @PerActivity
    abstract MainContract.View view(MainView mainView);

    @Binds
    @PerActivity
    abstract MainContract.Presenter presenter(Presenter presenter);

//    @Provides
//    public static MainView provideView() {
//        return new MainView();
//    }

//    @Provides
//    @PerActivity
//    public static Presenter providePresenter(MainView view, MySharedPreferences preferences, @Named("Activity") Context context) {
//        return new Presenter(view, preferences, context);
//    }
}
