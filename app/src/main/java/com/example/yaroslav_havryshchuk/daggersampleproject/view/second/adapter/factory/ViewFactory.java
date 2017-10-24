package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.factory;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

/**
 * Created by Yaroslav_Havryshchuk on 10/11/2017.
 */

public class ViewFactory implements BaseViewFactory<View> {

    private LayoutInflater inflater;

    @Inject
    public ViewFactory(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public View create(ViewGroup parent, @LayoutRes int layout) {
        return inflater.inflate(layout, parent, false);
    }
}
