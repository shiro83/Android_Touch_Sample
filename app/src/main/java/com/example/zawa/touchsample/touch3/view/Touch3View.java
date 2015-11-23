package com.example.zawa.touchsample.touch3.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zawa on 2015/11/22.
 */
public class Touch3View extends View {
    private Path path = null; //パス
    private Bitmap bmp = null; //Viewの状態を保存するためのBitmap
    private Canvas bmpCanvas = null;
    private Paint paint;

    public Touch3View(Context context) {
        super(context);

        path = new Path();

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(50);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bmpCanvas = new Canvas(bmp);
        bmpCanvas.drawColor(Color.WHITE);
    }

    /**
     * 描画処理
     */
    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(bmp, 0, 0, null);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float posX = event.getX();
        float posY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //画面がタッチされたときの動作
                path.reset();
                path.moveTo(posX, posY);

                // onDraw関数を実行
                invalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                //タッチしたまま移動したときの動作
                path.lineTo(posX, posY);

                // onDraw関数を実行
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                //タッチが離されたときの動作
                path.lineTo(posX,posY);
                bmpCanvas.drawPath(path, paint);
                path.reset();

                // onDraw関数を実行
                invalidate();
                break;
        }

        return true;
    }

    public void setColor(int color){
        paint.setColor(color);
    }
    public void clearDrawList() {
        bmpCanvas.drawColor(Color.WHITE);
        invalidate();
    }
}
