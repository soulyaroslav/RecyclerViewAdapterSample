package com.example.yaroslav_havryshchuk.daggersampleproject.di;

import android.app.Application;

import com.example.yaroslav_havryshchuk.daggersampleproject.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Yaroslav_Havryshchuk on 9/14/2017.
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilderModule.class })
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);
}