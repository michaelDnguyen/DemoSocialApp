package com.example.nntai.mycompanyapp;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.nntai.mycompanyapp.constant.myLog;
import com.example.nntai.mycompanyapp.views.MaterialLockView;

import java.util.List;

public class PatternActivity extends AppCompatActivity {

    private String CorrectPattern = ""; // default pattern
    private MaterialLockView materialLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern);

        materialLockView = (MaterialLockView) findViewById(R.id.pattern);

        materialLockView.setOnPatternListener(new MaterialLockView.OnPatternListener() {
            @Override
            public void onPatternDetected(List<MaterialLockView.Cell> pattern, String SimplePattern) {
                myLog.e("SimplePattern", SimplePattern);
                if (!SimplePattern.equals(CorrectPattern)) {
                    // wrong pattern
                    materialLockView.setDisplayMode(MaterialLockView.DisplayMode.Wrong);
                    // materialLockView.clearPattern(); // clear the drawn pattern

                } else {
                    // correct pattern
                    materialLockView.setDisplayMode(MaterialLockView.DisplayMode.Correct);

                }
                super.onPatternDetected(pattern, SimplePattern);
            }

            @Override
            public void onPatternStart() {
                super.onPatternStart();
            }

            @Override
            public void onPatternCellAdded(List<MaterialLockView.Cell> pattern, String SimplePattern) {
                super.onPatternCellAdded(pattern, SimplePattern);
            }

            @Override
            public void onPatternCleared() {
                super.onPatternCleared();
            }
        });

        // checkbox listener
        ((CheckBox) findViewById(R.id.stealthmode)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("checked", isChecked + "");
                materialLockView.setInStealthMode(isChecked);
            }
        });

        ((EditText) findViewById(R.id.correct_pattern_edittext)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CorrectPattern = "" + s;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
