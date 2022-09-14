package com.example.learn;

import android.content.Context;
import android.content.res.TypedArray;
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

                    MyLayoutParams lp=(MyLayoutParams) child.getLayoutParams();
                    measureWidth+=lp.leftMargin+lp.rightMargin;

                    if((child.getMeasuredHeight()+lp.topMargin+lp.topMargin)>maxMeasureHeight) maxMeasureHeight=(child.getMeasuredHeight()+lp.topMargin+lp.topMargin);
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

            MyLayoutParams lp=(MyLayoutParams) child.getLayoutParams();
            int cWidth=child.getMeasuredWidth();
            int cHeight=child.getMeasuredHeight();

            if(lp.position==MyLayoutParams.POSITION_RIGHT){
                child.layout(getWidth()-cWidth-lp.rightMargin,lp.topMargin,getWidth()-lp.rightMargin,lp.topMargin+cHeight);
            }
            else if(lp.position==MyLayoutParams.POSITION_BOTTOM){
                child.layout(left+lp.leftMargin,getHeight()-cHeight-lp.bottomMargin,left+cWidth+lp.leftMargin,getHeight()-lp.bottomMargin);
            }
            else{
                child.layout(left+lp.leftMargin,lp.topMargin,left+cWidth+lp.leftMargin,cHeight+lp.topMargin);
            }
            left+=cWidth+lp.leftMargin+lp.rightMargin;
        }
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs){
        return new MyLayoutParams(getContext(),attrs);
    }

    public static class MyLayoutParams extends MarginLayoutParams {
        public static int POSITION_RIGHT =1;
        public static int POSITION_BOTTOM =2;

        public int position = -1;

        public MyLayoutParams(Context c,AttributeSet attrs){
            super(c,attrs);

            TypedArray a=c.obtainStyledAttributes(attrs,R.styleable.customLayoutLP);
            position=a.getInt(R.styleable.customLayoutLP_layout_position,position);
            a.recycle();
        }
        public MyLayoutParams(int width,int height){
            super(width,height);
        }
        public MyLayoutParams(ViewGroup.LayoutParams source){
            super(source);
        }

    }
}
