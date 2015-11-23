package com.example.zawa.touchsample.touch2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zawa.touchsample.touch2.view.Touch2View;

public class Touch2Activity extends AppCompatActivity {

    private Touch2View touchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        touchView = new Touch2View(this);
        setContentView(touchView);
    }
}
