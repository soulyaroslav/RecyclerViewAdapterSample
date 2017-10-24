package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder;

import android.view.View;
import android.widget.TextView;

import com.example.yaroslav_havryshchuk.daggersampleproject.R;

/**
 * Created by Yaroslav_Havryshchuk on 10/11/2017.
 */

public class ItemViewHolder extends BaseViewHolder<String> {

    TextView tvItem;

    public ItemViewHolder(View itemView) {
        super(itemView);
        tvItem = (TextView) itemView.findViewById(R.id.item);
    }

    @Override
    public void bind(String item) {
        tvItem.setText(item);
    }
}
