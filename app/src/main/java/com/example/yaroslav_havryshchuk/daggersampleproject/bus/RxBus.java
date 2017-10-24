package com.example.yaroslav_havryshchuk.daggersampleproject.bus;

import android.app.Activity;
import android.support.v4.util.ArrayMap;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Yaroslav_Havryshchuk on 10/5/2017.
 */

public class RxBus implements Bus {

    private final PublishSubject<Object> publishSubject;
    private ArrayMap<Activity, ArrayList<Disposable>> registerEvents;
    private Activity currentHolder;

    @Inject
    public RxBus() {
        publishSubject = PublishSubject.create();
        registerEvents = new ArrayMap<>();
    }

    @Override
    public <T> void post(T event) {
        publishSubject.onNext(event);
    }

    @Override
    public <T> Observable<T> listen(Class<T> evenType) {
        return publishSubject
                .ofType(evenType)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        registerEvents.get(currentHolder).add(disposable);
                    }
                });
    }

    @Override
    public void register(Activity activity) {
        currentHolder = activity;
        registerEvents.put(activity, new ArrayList<Disposable>());
    }

    @Override
    public void unregister(Activity activity) {
        ArrayList<Disposable> events = registerEvents.remove(activity);
        if(events != null && !events.isEmpty()) {
            for(Disposable disposable : events) {
                disposable.dispose();
            }
        }
    }
}
