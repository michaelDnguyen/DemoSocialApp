package com.example.nntai.mycompanyapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.nntai.mycompanyapp.FacebookActivity;
import com.example.nntai.mycompanyapp.FingerActivity;
import com.example.nntai.mycompanyapp.FingerPrintActivity;
import com.example.nntai.mycompanyapp.GoogleAuthActivity;
import com.example.nntai.mycompanyapp.PatternActivity;
import com.example.nntai.mycompanyapp.R;
import com.example.nntai.mycompanyapp.ZaloActivity;

/**
 * Created by Tai-Nguyen on 4/8/18.
 */

public class DaskboardFragment extends Fragment {

    Button btnGoogle, btnZalo, btnFacebook;
    Button btnFinger, btnPattern, btnPin;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (v == null) {
            v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_daskboard, null);
            initViews(v);
            setListener();

        }

        return v;
    }

    private void initViews(View v) {
        btnFacebook = (Button) v.findViewById(R.id.btnFacebook);
        btnGoogle = (Button) v.findViewById(R.id.btnGoogle);
        btnZalo = (Button) v.findViewById(R.id.btnZalo);
        btnFinger = (Button) v.findViewById(R.id.btnFinger);
        btnPattern = (Button) v.findViewById(R.id.btnPattern);
        btnPin = (Button) v.findViewById(R.id.btnPin);
    }

    private void setListener() {
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GoogleAuthActivity.class));
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FacebookActivity.class));
            }
        });

        btnZalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ZaloActivity.class));
            }
        });

        btnFinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FingerPrintActivity.class));
            }
        });

        btnPattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PatternActivity.class));
            }
        });
    }

}
