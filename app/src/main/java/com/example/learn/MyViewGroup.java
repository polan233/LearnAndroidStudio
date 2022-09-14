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
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec,heightMeasureSpec);

        if(getChildCount()<=0){
            setMeasuredDimension(0,0);
        }
        else{
            if(heightMode==MeasureSpec.AT_MOST&&widthMode==MeasureSpec.AT_MOST){
                int measureWidth=0;
                int maxMeasureHeight=0;
                for(int i=0;i<getChildCount();i++){
                    View child=getChildAt(i);
                    measureWidth+=child.getMeasuredWidth();
                    if(child.getMeasuredHeight()>maxMeasureHeight) maxMeasureHeight=child.getMeasuredHeight();
                }
                setMeasuredDimension(measureWidth,maxMeasureHeight);
            }
            else{
                setMeasuredDimension(sizeWidth,sizeHeight);
            }
        }
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
