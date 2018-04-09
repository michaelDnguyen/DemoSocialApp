package com.example.nntai.mycompanyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nntai.mycompanyapp.R;

/**
 * Created by Tai-Nguyen on 4/8/18.
 */

public class HomeFragment extends Fragment{

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(v ==null){
            v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_notification,null);
        }

        return v;
    }
}
