package com.example.zawa.touchsample.touch3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zawa.touchsample.touch3.view.Touch3View;

public class Touch3Activity extends AppCompatActivity {

    private static final int MENU_CLEAR = 0;
    private static final int MENU_COLOR_RED = 1;
    private static final int MENU_COLOR_BLUE = 2;
    private static final int MENU_COLOR_GREEN = 3;


    private Touch3View touchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        touchView = new Touch3View(this);

        setContentView(touchView);
    }

    /** メニューの生成イベント */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_CLEAR, 0, "Clear");
        menu.add(0, MENU_COLOR_RED, 0, "RED");
        menu.add(0, MENU_COLOR_BLUE, 0, "BLUE");
        menu.add(0, MENU_COLOR_GREEN, 0, "GREEN");
        return true;
    }
    /** メニューがクリックされた時のイベント */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ( item.getItemId() ) {
            case MENU_CLEAR:
                touchView.clearDrawList();
                break;
            case MENU_COLOR_RED:
                touchView.setColor(Color.RED);
                break;
            case MENU_COLOR_BLUE:
                touchView.setColor(Color.BLUE);
                break;
            case MENU_COLOR_GREEN:
                touchView.setColor(Color.GREEN);
                break;
        }
        return true;
    }
}
