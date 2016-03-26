package com.example.zawa.touchsample.touch4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.zawa.touchsample.R;

public class Touch4Activity extends AppCompatActivity {


    public void eggTouch(View v){
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.startAnimation(AnimationUtils.loadAnimation(this, R.anim.tap));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch4);
    }

}
