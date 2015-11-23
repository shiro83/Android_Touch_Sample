package com.example.zawa.touchsample.touch2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

import com.example.zawa.touchsample.R;
import com.example.zawa.touchsample.util.BitmapUtil;

/**
 * Created by zawa on 2015/11/22.
 */
public class Touch2View extends View {

    private Paint paint = null;
    private Point posTouch = null;

    private Bitmap img1;
    MediaPlayer cat;
    MediaPlayer cat2;

    // 画像のサイズ
    private final static int WIDTH = 400;
    private final static int HEIGHT = 200;

    //コンストラクタ
    public Touch2View(Context context) {
        super(context);

        paint = new Paint();

        img1 = BitmapUtil.createBitmap(getResources(), R.drawable.kuro, WIDTH, HEIGHT);

        cat = MediaPlayer.create(getContext(), R.raw.cat);
        cat2 = MediaPlayer.create(getContext(), R.raw.cat2);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        if (posTouch != null) {
            // 画像を表示
            canvas.drawBitmap(img1, posTouch.x, posTouch.y, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int posX, posY;

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                //画面がタッチされたときの動作

                posX = (int) event.getX();
                posY = (int) event.getY();

                //タッチされた座標を取得
                posTouch = new Point(posX, posY);

                // onDraw関数を実行
                invalidate();

                cat.start();

                break;

            case MotionEvent.ACTION_MOVE:
                //タッチしたまま移動したときの動作
                posX = (int) event.getX();
                posY = (int) event.getY();

                //タッチされた座標を取得
                posTouch = new Point(posX, posY);
                // onDraw関数を実行
                invalidate();

                cat2.start();

                break;

            case MotionEvent.ACTION_UP:
                //タッチが離されたときの動作

                posX = (int) event.getX();
                posY = (int) event.getY();

                //タッチされた座標を取得
                posTouch = new Point(posX, posY);
                // onDraw関数を実行
                invalidate();

                break;
        }

        return true;
    }
}
