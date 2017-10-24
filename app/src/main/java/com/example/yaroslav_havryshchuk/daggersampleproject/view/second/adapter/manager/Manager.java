package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.manager;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by Yaroslav_Havryshchuk on 10/10/2017.
 */

public interface Manager<T, D extends BaseDiffStrategy> {
    AdapterManager<T, D> data(List<T> dataSet);
    AdapterManager<T, D> diffStrategy(D callback);
    Disposable update();
}
