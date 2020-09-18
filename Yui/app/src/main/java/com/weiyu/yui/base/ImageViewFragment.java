package com.weiyu.yui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.weiyu.yui.R;

import java.io.IOException;

public class ImageViewFragment extends Fragment {
    private Context context;
    public ImageViewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_view, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //实现圆角图片
        ImageView imageView = (ImageView)getView().findViewById(R.id.iv_base_fragment_round);
        CornerImageView cornerImageView = new CornerImageView(context);
        cornerImageView.setType(0);
//        BitmapUtil bitmapUtil = new BitmapUtil();
//        Bitmap bitmap = bitmapUtil.getRoundedCornerBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.logo),45);
//        imageView.setImageBitmap(bitmap);
        //实现gif
//        ImageView imageView2 = (ImageView)getView().findViewById(R.id.iv_base_fragment_gif);

    }

    //图片处理类
    class BitmapUtil {
        // 放大缩小图片
        public Bitmap zoomBitmap(Bitmap bitmap, int w, int h) {
            if (bitmap == null)
                return null;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            float scaleWidht = ((float) w / width);
            float scaleHeight = ((float) h / height);
            matrix.postScale(scaleWidht, scaleHeight);
            Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, width, height,
                    matrix, true);
            return newbmp;
        }

        // 将Drawable转化为Bitmap
        public Bitmap drawableToBitmap(Drawable drawable) {
            if (drawable == null)
                return null;
            int width = drawable.getIntrinsicWidth();
            int height = drawable.getIntrinsicHeight();
            Bitmap bitmap = Bitmap.createBitmap(width, height, drawable
                    .getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, width, height);
            drawable.draw(canvas);
            return bitmap;
        }

        // 获得圆角图片的方法
        public Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
            if (bitmap == null)
                return null;
            Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                    bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final int color = 0xff424242;
            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            final RectF rectF = new RectF(rect);

            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return output;
        }

        // 获得带倒影的图片方法
        public Bitmap createReflectionImageWithOrigin(Bitmap bitmap) {
            if (bitmap == null)
                return null;
            final int reflectionGap = 4;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();

            Matrix matrix = new Matrix();
            matrix.preScale(1, -1);

            Bitmap reflectionImage = Bitmap.createBitmap(bitmap, 0, height / 2,
                    width, height / 2, matrix, false);

            Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
                    (height + height / 2), Bitmap.Config.ARGB_8888);

            Canvas canvas = new Canvas(bitmapWithReflection);
            canvas.drawBitmap(bitmap, 0, 0, null);
            Paint deafalutPaint = new Paint();
            canvas.drawRect(0, height, width, height + reflectionGap, deafalutPaint);

            canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);

            Paint paint = new Paint();
            LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0,
                    bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff,
                    0x00ffffff, Shader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()
                    + reflectionGap, paint);

            return bitmapWithReflection;
        }
    }

}