package com.example.yaroslav_havryshchuk.daggersampleproject.pref;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by Yaroslav_Havryshchuk on 9/14/2017.
 */

public class MySharedPreferences {

    private SharedPreferences preferences;

    @Inject
    public MySharedPreferences(final SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public void putData(String key, int data) {
        preferences.edit().putInt(key, data).apply();
    }

    public int getData(String key) {
        return preferences.getInt(key, 0);
    }
}
