package com.example.zawa.touchsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zawa.touchsample.touch1.Touch1Activity;
import com.example.zawa.touchsample.touch2.Touch2Activity;
import com.example.zawa.touchsample.touch3.Touch3Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void touch1(View v){
        Intent intent = new Intent(getApplicationContext(), Touch1Activity.class);
        startActivity(intent);
    }
    public void touch2(View v){
        Intent intent = new Intent(getApplicationContext(), Touch2Activity.class);
        startActivity(intent);
    }
    public void touch3(View v){
        Intent intent = new Intent(getApplicationContext(), Touch3Activity.class);
        startActivity(intent);
    }
}
