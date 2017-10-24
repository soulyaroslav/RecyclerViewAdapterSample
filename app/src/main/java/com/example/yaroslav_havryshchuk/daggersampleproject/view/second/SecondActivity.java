package com.example.yaroslav_havryshchuk.daggersampleproject.view.second;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.yaroslav_havryshchuk.daggersampleproject.R;
import com.example.yaroslav_havryshchuk.daggersampleproject.bus.MessageEvent;
import com.example.yaroslav_havryshchuk.daggersampleproject.bus.RxBus;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.Adapter;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.DiffStrategy;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.manager.AdapterManager;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.manager.Updatable;
import com.jakewharton.rxbinding2.view.RxView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Yaroslav_Havryshchuk on 9/18/2017.
 */

public class SecondActivity extends AppCompatActivity {

    @Inject
    @Named("Activity")
    Context context;

    @Inject
    @Named("App")
    Context appContext;

    @Inject
    Updatable<String> adapter;

    @Inject
    RxBus bus;

    @Inject
    AdapterManager<String, DiffStrategy> adapterManager;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_acivity);

        Log.d("TAG", "SecondActivity onCreate: hashcode " + context.hashCode());
        Log.d("TAG", "SecondActivity onCreate: app hashcode " + appContext.hashCode());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter((Adapter) adapter);

        List<String> list = new ArrayList<>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
        list.add("Test5");

        adapterManager.data(list)
                .diffStrategy(new DiffStrategy())
                .update();
//        Observable.just("Test1", "Test2", "Test3")
//                .toList()
//                .toObservable()
//                .flatMap(new Function<List<String>, Observable<DiffUtil.DiffResult>>() {
//                    @Override
//                    public Observable<DiffUtil.DiffResult> apply(@NonNull List<String> list) throws Exception {
//                        return Observable.just(DiffUtil.calculateDiff(new DiffStrategy(old, list)));
//                    }
//                })
//                .subscribe(new Consumer<DiffUtil.DiffResult>() {
//                    @Override
//                    public void accept(DiffUtil.DiffResult diffResult) throws Exception {
//                        adapter.update();
//                        diffResult.dispatchUpdatesTo(adapter);
//                    }
//                });
        RxPermissions permissions = new RxPermissions(this);
        RxView.clicks(findViewById(R.id.onStop))
                .compose(permissions.ensure(Manifest.permission.CAMERA))
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Toast.makeText(context, "Granted - " + aBoolean, Toast.LENGTH_SHORT).show();
                    }
                });

        ObservableSource<String> observableOne = Observable.just("java", "spring", "hibernate", "android", "rxjava");
        ObservableSource<String> observableTwo = Observable.just("language", "di", "orm", "os", "ractive p");
        ObservableSource<String> observableThree = Observable.just("1", "2", "3", "4", "5");
        Observable<String> observableFin = Observable.combineLatest(new Function<Object[], String>() {
            @Override
            public String apply(@NonNull Object[] objects) throws Exception {
                String finObj = "";
                for(Object ob : objects){
                    finObj = finObj + ob+ " ";
                }
                return finObj.trim();
            }
        }, 1, observableOne, observableTwo, observableThree);
        observableFin.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("TAG", "accept: " + s);
            }
        });

        Observable<String> observableupstream = Observable.just("language", "framework", "os", "library", "os");
        Observable<String> observabledownstream = observableupstream.compose(new ObservableTransformer<String, String>(){

            //returns new observable that can emit distinct values from source observable
            @Override
            public ObservableSource<String> apply(Observable<String> upstream) {
                return upstream.distinct();
            }});
        observabledownstream.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("TAG", "accept: " + s);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        bus.listen(String.class).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Toast.makeText(context, "RxBus - " + s, Toast.LENGTH_SHORT).show();
            }
        });

        bus.listen(MessageEvent.class).subscribe(new Consumer<MessageEvent>() {
            @Override
            public void accept(MessageEvent messageEvent) throws Exception {
                Toast.makeText(context, "RxBus - " + messageEvent.message, Toast.LENGTH_SHORT).show();
            }
        });

        bus.post("Rx bus works!!");
        bus.post(new MessageEvent("Message event"));

    }
}
