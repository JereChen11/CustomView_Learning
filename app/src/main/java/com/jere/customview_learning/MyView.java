package com.jere.customview_learning;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import org.w3c.dom.Text;

import androidx.annotation.Nullable;

/**
 * @author jere
 */
public class MyView extends View {
    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        paint.setStyle(Paint.Style.FILL);

//        paint.setStrokeCap(Paint.Cap.ROUND);

        //画圆
//        drawCircle(canvas);

        //画矩形
//        drawRect(canvas);

        //画点
        drawPoints(canvas);


        //画矩形
//        canvas.drawRect(100, 100, 500, 500, paint);
//        canvas.drawPoint(50, 50, paint);
        //画多个点
//        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
//        canvas.drawPoints(points, 2, 8, paint);

        //画一个三角形
//        Path path = new Path();
//        path.moveTo(100, 100);
//        path.lineTo(200, 100);
//        path.lineTo(150, 150);
//        path.close();
//        canvas.drawPath(path, paint);

//        paint.setTextSize(18);
//        String text = "Hello World";
//        canvas.drawText(text, 100, 25, paint);
//        paint.setTextSize(36);
//        canvas.drawText(text, 100, 75, paint);
//        paint.setTextSize(60);
//        canvas.drawText(text, 100, 150, paint);
//        paint.setTextSize(80);
//        canvas.drawText(text, 100, 250, paint);


    }

    /**
     * 画4种圆
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {
        //为画笔开启抗锯齿
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //1.实心圆
        //设置画笔的颜色
        paint.setColor(Color.BLACK);
        //设置画笔的style为画线
        paint.setStyle(Paint.Style.FILL);
        //调用画布，画一个圆
        canvas.drawCircle(150, 150, 100, paint);

        //2.空心圆
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(400, 150, 100, paint);

        //3.蓝色实心圆
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(150, 400, 100, paint);

        //4.线宽为20的空心圆
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(400, 400, 100, paint);
    }

    /**
     * 画矩形
     * @param canvas
     */
    private void drawRect(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(100, 100, 500, 500, paint);
    }

    /**
     * 画点
     * @param canvas
     */
    private void drawPoints(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(20);
        paint.setColor(Color.BLACK);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(100, 100, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(200, 100, paint);
    }
}
