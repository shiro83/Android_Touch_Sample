package com.example.zawa.touchsample.touch1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.zawa.touchsample.R;
import com.example.zawa.touchsample.util.BitmapUtil;

/**
 * Created by zawa on 2015/11/22.
 */
public class Touch1View extends View {

    private Paint paint;
    private Point posTouch = null;

    private Bitmap bgImg = null;

    // 画像のサイズ
    private final static int WIDTH = 800;
    private final static int HEIGHT = 900;

    //コンストラクタ
    public Touch1View(Context context) {
        super(context);

        bgImg = BitmapUtil.createBitmap(getResources(), R.drawable.uma, WIDTH, HEIGHT);

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(60);

        paint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        //描画
        //canvas.drawBitmap(bgImg, 0, 0, paint);
        canvas.drawBitmap(bgImg, 0, 450, paint);


        if(posTouch != null) {
            //画面の中心に円を描く
            canvas.drawCircle(posTouch.x, posTouch.y, 25, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        String sEvent = "";
        String sPressure = "";
        String sTime =String.valueOf(event.getDownTime());
        int posX,posY;

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                //画面がタッチされたときの動作

                posX =(int)event.getX();
                posY =(int)event.getY();

                //タッチされた座標を取得
                posTouch = new Point(posX, posY);

                sEvent = "タッチ";
                sPressure = String.valueOf(event.getPressure());
                viewLog(sEvent, sTime, posX, posY,sPressure);

                // onDraw関数を実行
                invalidate();

                break;

            case MotionEvent.ACTION_MOVE:
                //タッチしたまま移動したときの動作
                posX =(int)event.getX();
                posY =(int)event.getY();

                //タッチされた座標を取得
                posTouch = new Point(posX, posY);

                sEvent = "動かしている";
                sPressure = String.valueOf(event.getPressure());
                viewLog(sEvent, sTime, posX, posY,sPressure);

                // onDraw関数を実行
                invalidate();

                break;

            case MotionEvent.ACTION_UP:
                //タッチが離されたときの動作

                posX =(int)event.getX();
                posTouch = null;
                posY =(int)event.getY();


                sEvent = "離した";
                viewLog(sEvent, sTime, posX, posY);

                // onDraw関数を実行
                invalidate();

                break;
        }

        return true;
    }

    private void viewLog(String sEvent, String sTime, int posX, int posY) {
        // ログを出力します
        Log.v("touch", sEvent + " 時間:" + sTime + "横:" + posX + "縦:" + posY);
    }
    private void viewLog(String sEvent, String sTime, int posX, int posY, String sPressure) {
        // ログを出力します
        Log.v("touch", sEvent + " 時間:" + sTime + "横:" + posX + "縦:" + posY + "強さ" + sPressure);
    }

}
