package com.example.yaroslav_havryshchuk.daggersampleproject.view.second.adapter.manager;

import java.util.List;

/**
 * Created by Yaroslav_Havryshchuk on 10/10/2017.
 */

public interface Updatable<T> {
    void update(List<T> dataSet);
}
