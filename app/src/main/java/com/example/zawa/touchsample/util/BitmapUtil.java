package com.example.zawa.touchsample.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;

/**
 * Created by zawa on 2015/11/23.
 */
public class BitmapUtil {
    /**
     * 画像生成
     * 表示サイズ合わせて画像生成時に可能なかぎり縮小して生成、
     * のちに正確なサイズにリサイズする。
     *
     * @return 生成Bitmap
     */
    public static Bitmap createBitmap(Resources res, int id, int width, int height) {

        BitmapFactory.Options option = new BitmapFactory.Options();

        // 情報のみ読み込む
        option.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, id, option);

        if (option.outWidth < width || option.outHeight < height) {
            // 縦、横のどちらかが指定値より小さい場合は普通にBitmap生成
            return BitmapFactory.decodeResource(res, id);
        }

        float scaleWidth = ((float) width) / option.outWidth;
        float scaleHeight = ((float) height) / option.outHeight;

        int newSize = 0;
        int oldSize = 0;
        if (scaleWidth > scaleHeight) {
            newSize = width;
            oldSize = option.outWidth;
        } else {
            newSize = height;
            oldSize = option.outHeight;
        }

        // option.inSampleSizeに設定する値を求める
        // option.inSampleSizeは2の乗数のみ設定可能
        // たとえば、inSampleSize=2であれば、 1/2に縮小された画像が、inSampleSize=4であれば、1/4に縮小された画像が読み込まれます。
        // inSampleSizeには2,4,8,16と2のべき上を入れます。
        int sampleSize = 1;
        int tmpSize = oldSize;
        while (tmpSize > newSize) {
            sampleSize = sampleSize * 2;
            tmpSize = oldSize / sampleSize;

            Log.v("image", "tmpSize：" + tmpSize);
            Log.v("image", "oldSize：" + oldSize);
            Log.v("image", "sampleSize：" + sampleSize);
        }

        if (sampleSize != 1) {
            sampleSize = sampleSize / 2;
        }

        Log.v("image", "sampleSize：" + sampleSize);

        option.inJustDecodeBounds = false;
        option.inSampleSize = sampleSize;
        Bitmap bitmap = BitmapFactory.decodeResource(res, id, option);

        // 大雑把に圧縮した後、正確にリサイズする
        return resize(bitmap, width, height);
    }

    public static Bitmap resize(Bitmap bitmap, int width, int height) {

        if (bitmap == null) {
            return null;
        }

        int oldWidth = bitmap.getWidth();
        int oldHeight = bitmap.getHeight();

        if (oldWidth < width && oldHeight < height) {
            // 縦も横も指定サイズより小さい場合は何もしない
            return bitmap;
        }

        float scaleWidth = ((float) width) / oldWidth;
        float scaleHeight = ((float) height) / oldHeight;
        float scaleFactor = Math.min(scaleWidth, scaleHeight);

        Matrix scale = new Matrix();
        scale.postScale(scaleFactor, scaleFactor);

        Bitmap resizeBitmap = Bitmap.createBitmap(bitmap, 0, 0, oldWidth, oldHeight, scale, false);
        bitmap.recycle();

        return resizeBitmap;
    }

}
