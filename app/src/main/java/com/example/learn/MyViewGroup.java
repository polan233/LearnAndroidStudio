package com.example.learn;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context){
        super(context);
    }
    public MyViewGroup(Context context, AttributeSet attrs){
        super(context,attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec,heightMeasureSpec);

        Log.i("polan","测量宽度："+sizeWidth+" 测量高度："+sizeHeight);
        setMeasuredDimension(sizeWidth,sizeHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l,int t, int r, int b){
        int count=getChildCount();
        int left=0;
        for(int i=0;i<count;i++){
            View child=getChildAt(i);
            int cWidth=child.getMeasuredWidth();
            int cHeight=child.getMeasuredHeight();

            child.layout(left,0,left+cWidth,cHeight);
            left+=cWidth;
        }
    }
}
