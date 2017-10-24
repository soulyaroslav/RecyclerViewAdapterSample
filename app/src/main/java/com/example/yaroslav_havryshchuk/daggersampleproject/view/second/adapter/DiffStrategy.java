package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter;

import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.manager.BaseDiffStrategy;

/**
 * Created by Yaroslav_Havryshchuk on 10/9/2017.
 */

public class DiffStrategy extends BaseDiffStrategy<String> {

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).hashCode() == newList.get(newItemPosition).hashCode();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
