package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yaroslav_havryshchuk.daggersampleproject.R;

/**
 * Created by Yaroslav_Havryshchuk on 10/11/2017.
 */

public class HeaderViewHolder extends BaseViewHolder<String> {

    TextView tvHeader;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        tvHeader = (TextView) itemView.findViewById(R.id.tvHeader);
    }

    @Override
    public void bind(String item) {
        // no need
    }
}
