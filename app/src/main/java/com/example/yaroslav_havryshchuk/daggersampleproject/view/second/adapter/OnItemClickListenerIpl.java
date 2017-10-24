package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Yaroslav_Havryshchuk on 9/29/2017.
 */

public class OnItemClickListenerIpl implements OnItemClickListener {

    private Context context;

    @Inject
    public OnItemClickListenerIpl(@Named("Activity") Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(String item) {
        Toast.makeText(context, item + " is Clicked", Toast.LENGTH_SHORT).show();
    }
}
