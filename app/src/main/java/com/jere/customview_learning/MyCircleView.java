package com.jere.customview_learning;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author jere
 */
public class MyCircleView extends View {
    private int mColor;
    public MyCircleView(Context context) {
        this(context, null);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCircleView);
        mColor = typedArray.getColor(R.styleable.MyCircleView_viewColor, Color.GREEN);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, 200);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, 200);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;
        int radius = Math.min(width, height) / 2;

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(mColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(paddingLeft + width / 2, paddingTop + height / 2, radius, paint);
    }

}
