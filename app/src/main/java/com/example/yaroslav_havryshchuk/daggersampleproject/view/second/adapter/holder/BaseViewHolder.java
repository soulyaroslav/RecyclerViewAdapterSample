package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Yaroslav_Havryshchuk on 10/11/2017.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(T item) {
        // need to override
    }
}
