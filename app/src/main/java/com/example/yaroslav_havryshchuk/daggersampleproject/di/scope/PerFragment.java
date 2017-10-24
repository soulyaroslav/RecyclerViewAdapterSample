package com.example.yaroslav_havryshchuk.daggersampleproject.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Yaroslav_Havryshchuk on 9/15/2017.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
