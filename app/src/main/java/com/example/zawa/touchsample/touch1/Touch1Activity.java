package com.example.zawa.touchsample.touch1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zawa.touchsample.touch1.view.Touch1View;

public class Touch1Activity extends AppCompatActivity {

    private Touch1View touchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        touchView = new Touch1View(this);
        setContentView(touchView);
    }
}
