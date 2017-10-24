package com.example.yaroslav_havryshchuk.daggersampleproject.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yaroslav_Havryshchuk on 9/14/2017.
 */

@Module
public abstract class AppModule {

    @Provides
    @Singleton
    @Named("App")
    static Context provideApplicationContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    static SharedPreferences provideSharedPreferences(@Named("App") Context context) {
        return context.getSharedPreferences("Test", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    static LayoutInflater provideLayoutInflator(@Named("App") Context context) {
        return LayoutInflater.from(context);
    }

//    @Provides
//    @Singleton
//    static MySharedPreferences provideMySharedPreferences(SharedPreferences preferences) {
//        return new MySharedPreferences(preferences);
//    }
}
