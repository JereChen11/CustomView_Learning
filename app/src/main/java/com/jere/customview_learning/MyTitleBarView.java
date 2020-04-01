package com.jere.customview_learning;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MyTitleBarView extends ConstraintLayout {
    public MyTitleBarView(Context context) {
        this(context, null);
    }

    public MyTitleBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTitleBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.custom_view_my_title_var, this);
        Button cancelBtn = findViewById(R.id.cancel_btn);
        Button finishBtn = findViewById(R.id.finish_btn);
        TextView titleTv = findViewById(R.id.title_tv);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTitleBarView);

        int color = typedArray.getColor(R.styleable.MyTitleBarView_titleTextColor, Color.BLACK);
        String titleText = typedArray.getString(R.styleable.MyTitleBarView_titleText);
        float titleTextSize = typedArray.getDimension(R.styleable.MyTitleBarView_titleTextSize, 20);
        boolean isShowCancelBtn = typedArray.getBoolean(R.styleable.MyTitleBarView_isShowCancelBtn, true);
        boolean isShowFinishBtn = typedArray.getBoolean(R.styleable.MyTitleBarView_isShowFinishBtn, true);

        titleTv.setText(titleText);
        titleTv.setTextColor(color);
        titleTv.setTextSize(titleTextSize);
        if (isShowCancelBtn) {
            cancelBtn.setVisibility(VISIBLE);
        } else {
            cancelBtn.setVisibility(GONE);
        }

        if (isShowFinishBtn) {
            finishBtn.setVisibility(VISIBLE);
        } else {
            finishBtn.setVisibility(GONE);
        }

        typedArray.recycle();
    }


}
