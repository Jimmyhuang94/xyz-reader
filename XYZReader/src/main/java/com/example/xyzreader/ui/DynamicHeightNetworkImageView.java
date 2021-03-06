package com.example.xyzreader.ui;

import android.content.Context;
import android.icu.util.Measure;
import android.util.AttributeSet;

import com.android.volley.toolbox.NetworkImageView;

public class DynamicHeightNetworkImageView extends NetworkImageView {
    private float mAspectRatio = 2/3f;

    public DynamicHeightNetworkImageView(Context context) {
        super(context);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAspectRatio(float aspectRatio) {
        mAspectRatio = aspectRatio;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int aspectHeight = (int) (MeasureSpec.getSize(widthMeasureSpec) * mAspectRatio);
        int aspectHeightSpec = MeasureSpec.makeMeasureSpec(aspectHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, aspectHeightSpec);
    }
}
