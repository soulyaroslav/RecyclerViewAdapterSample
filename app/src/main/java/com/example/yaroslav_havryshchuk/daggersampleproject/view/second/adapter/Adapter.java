package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.yaroslav_havryshchuk.daggersampleproject.view.base.BaseViewHolderFactory;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder.HolderType;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.holder.BaseViewHolder;
import com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.manager.Updatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Yaroslav_Havryshchuk on 9/29/2017.
 */

public class Adapter extends RecyclerView.Adapter<BaseViewHolder<String>> implements Updatable<String> {

    private List<String> list;
    private OnItemClickListener listener;
    private Map<Integer, BaseViewHolderFactory> factories;

    @Inject
    public Adapter(Map<Integer, BaseViewHolderFactory> factories, OnItemClickListener listener) {
        this.factories = factories;
        this.listener = listener;
        this.list = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public BaseViewHolder<String> onCreateViewHolder(ViewGroup parent, int viewType) {
        return factories.get(viewType).create(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<String> holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? HolderType.HEADER_TYPE : HolderType.ITEM_TYPE;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(List<String> dataSet) {
        list.clear();
        list.addAll(dataSet);
    }
}
