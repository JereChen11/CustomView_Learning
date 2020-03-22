package com.jere.customview_learning;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author jere
 */
public class MyTextView extends View {

    private int mTextSize = 10;
    private int mTextColor = Color.BLACK;
    private String mText;
    private Paint mPaint;

    /**
     * 在代码中进行实例化
     * @param context
     */
    public MyTextView(Context context) {
        this(context, null);
    }

    /**
     * 在xml中实例
     * @param context
     * @param attrs
     */
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 在xml中进行实例，但需要style
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        mText = typedArray.getString(R.styleable.MyTextView_MyText);
        mTextSize = (int) typedArray.getDimension(R.styleable.MyTextView_MyTextSize, mTextSize);
        mTextColor = typedArray.getColor(R.styleable.MyTextView_MyTextColor, mTextColor);

        typedArray.recycle();

        mPaint = new Paint();
        //去锯齿
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                //todo
                Rect rect = new Rect();
                mPaint.getTextBounds(mText, 0, mText.length(), rect);
                width = rect.width();
                break;
            case MeasureSpec.EXACTLY:
                //todo
                break;
            case MeasureSpec.UNSPECIFIED:
                //todo
                break;
            default:
                break;
        }

        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                //todo
                Rect rect = new Rect();
                mPaint.getTextBounds(mText, 0, mText.length(), rect);
                height = rect.height();
                break;
            case MeasureSpec.EXACTLY:
                //todo
                break;
            case MeasureSpec.UNSPECIFIED:
                //todo
                break;
            default:
                break;
        }

        setMeasuredDimension(width, height);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint.FontMetricsInt fontMetricsInt = mPaint.getFontMetricsInt();
        int dy = (fontMetricsInt.top - fontMetricsInt.bottom) / 2 - fontMetricsInt.bottom;
        int baseLine = getHeight() / 2 + dy;
        canvas.drawText(mText, 0, baseLine, mPaint);
    }

}
