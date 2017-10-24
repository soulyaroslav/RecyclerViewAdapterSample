package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.manager;

import android.support.v7.util.DiffUtil;
import android.util.Pair;

import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.Adapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by Yaroslav_Havryshchuk on 10/10/2017.
 */

public class AdapterManager<T, D extends BaseDiffStrategy> implements Manager<T, D> {

    private List<T> currentData;
    private List<T> emptyData = new ArrayList<>();
    private Updatable<T> adapter;
    private D callback;

    @Inject
    public AdapterManager(Updatable<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public AdapterManager<T, D> data(List<T> dataSet) {
        currentData = dataSet;
        return this;
    }

    @Override
    public AdapterManager<T, D> diffStrategy(D callback) {
        this.callback = callback;
        return this;
    }

    @Override
    public Disposable update() {
        return Observable.fromIterable(currentData)
                .toList()
                .toObservable()
                .startWith(emptyData)
                .buffer(2, 1)
                .filter(filter())
                .map(map())
                .flatMap(flatMap())
                .subscribe(subscribe());
    }

    private Predicate<List<List<T>>> filter() {
        return new Predicate<List<List<T>>>() {
            @Override
            public boolean test(@NonNull List<List<T>> list) throws Exception {
                return list.size() >= 2;
            }
        };
    }

    private Function<List<List<T>>, Pair<List<T>, List<T>>> map() {
        return new Function<List<List<T>>, Pair<List<T>, List<T>>>() {
            @Override
            public Pair<List<T>, List<T>> apply(@NonNull List<List<T>> list) throws Exception {
                return Pair.create(list.get(0), list.get(1));
            }
        };
    }

    private Function<Pair<List<T>, List<T>>, Observable<Pair<List<T>, DiffUtil.DiffResult>>> flatMap() {
        return new Function<Pair<List<T>, List<T>>, Observable<Pair<List<T>, DiffUtil.DiffResult>>>() {
            @Override
            public Observable<Pair<List<T>, DiffUtil.DiffResult>> apply(@NonNull Pair<List<T>, List<T>> mapper) throws Exception {
                callback.oldList = mapper.first;
                callback.newList = mapper.second;
                return Observable.just(Pair.create(mapper.second, DiffUtil.calculateDiff(callback)));
            }
        };
    }

    private Consumer<Pair<List<T>, DiffUtil.DiffResult>> subscribe() {
        return new Consumer<Pair<List<T>, DiffUtil.DiffResult>>() {
            @Override
            public void accept(Pair<List<T>, DiffUtil.DiffResult> pair) throws Exception {
                adapter.update(pair.first);
                pair.second.dispatchUpdatesTo((Adapter) adapter);
            }
        };
    }
}
