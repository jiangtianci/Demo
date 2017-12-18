package com.example.fenlei.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by 姜天赐 on 2017/12/8.
 */

public class GridViews extends GridView {
    public GridViews(Context context) {
        super(context);
    }

    public GridViews(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViews(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int grid = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, grid+20);
    }
}
