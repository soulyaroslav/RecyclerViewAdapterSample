package com.example.yaroslav_havryshchuk.daggersampleproject.view.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yaroslav_havryshchuk.daggersampleproject.R;

/**
 * Created by Yaroslav_Havryshchuk on 9/20/2017.
 */

public class Frag extends Fragment {

   public static Frag newInstance(final String s) {
       Frag fragment = new Frag();
       Bundle bundle = new Bundle();
       bundle.putString("TAg", s);
       fragment.setArguments(bundle);
       return fragment;
   }

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = LayoutInflater.from(getActivity()).inflate(R.layout.second_acivity, container, false);
       return view;
   }
}
