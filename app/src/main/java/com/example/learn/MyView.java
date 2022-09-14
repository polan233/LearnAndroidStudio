package com.example.learn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MyView extends View {
    private MyThread myThread;
    private Paint paint;

    private RectF rectF=new RectF(100,100,400,400);
    private int sweepAngle=0;
    private int sweepAngleAdd=20;
    private Random random = new Random();
    private boolean running=true;

    public MyView(Context context, AttributeSet attrs){
        super(context,attrs);
        init(context,attrs);
    }
    public MyView(Context context){
        this(context,null);
    }

    private void init(Context context,AttributeSet attrs){
        paint=new Paint();
        paint.setTextSize(30);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.customStyleView);
        sweepAngleAdd=typedArray.getInt(R.styleable.customStyleView_sweepAngleAdd,0);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas){
        Log.i("Myview","onDraw");
        if(myThread==null){
            myThread=new MyThread();
            myThread.start();
        }
        else{
            canvas.drawArc(rectF,0,sweepAngle,true,paint);
        }
    }

    private class MyThread extends Thread{
        @Override
        public void run(){
            while(running){
                logic();
                postInvalidate();
                try{
                    Thread.sleep(200);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    protected void logic()  {
        sweepAngle+=sweepAngleAdd;

        int r,g,b;
        r=random.nextInt(255);
        g=random.nextInt(255);
        b=random.nextInt(255);
        paint.setARGB(255,r,g,b);

        if(sweepAngle>=360){
            sweepAngle=sweepAngle%360;
        }
    }
    @Override
    protected  void onDetachedFromWindow(){
        running=false;
        super.onDetachedFromWindow();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width,height;
        if(widthMode == MeasureSpec.EXACTLY)
            width=widthSize;
        else{
            width=(int)(getPaddingLeft()+getPaddingRight()+rectF.width()*2);
        }
        if(heightMode== MeasureSpec.EXACTLY)
            height=heightSize;
        else{
            height=(int)(getPaddingTop()+getPaddingBottom()+rectF.height()*2);
        }
        setMeasuredDimension(width,height);
    }
}
