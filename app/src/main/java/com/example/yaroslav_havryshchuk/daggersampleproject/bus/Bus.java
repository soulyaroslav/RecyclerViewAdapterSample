package com.example.yaroslav_havryshchuk.daggersampleproject.bus;

import android.app.Activity;

import io.reactivex.Observable;

/**
 * Created by Yaroslav_Havryshchuk on 10/5/2017.
 */

public interface Bus {
    <T> Observable<T> listen(final Class<T> instance);
    <T> void post(T event);
    void register(Activity holder);
    void unregister(Activity holder);
}
