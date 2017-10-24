package com.example.yaroslav_havryshchuk.daggersampleproject.view.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.yaroslav_havryshchuk.daggersampleproject.R;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.SecondActivity;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    @Named("Activity")
    Context context;

    @Inject
    @Named("App")
    Context appContext;

    @Inject
    Presenter presenter;

    /**
     * If we want to inject an interface then we need to use @Binds. @Inject MainContract.View
     * When we will use Constructor injection then we need to inject implementation of the interface. @Inject MainView
     * */
    @Inject
    MainContract.View mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG", "MainActivity onCreate: hashcode" + context.hashCode());
        Log.d("TAG", "MainActivity onCreate: app hashcode " + appContext.hashCode());

        findViewById(R.id.btnNavigate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                startActivity(intent);
            }
        });

        if(context.hashCode() == this.hashCode()) {
            Toast.makeText(context, "it's works 111", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView((MainView) mainView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
