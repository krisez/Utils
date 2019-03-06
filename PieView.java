package com.redrock.my.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2016/8/6.
 */
public class PieView extends View{
    private final static int r = 300;
    private List<CircleData> rate = new ArrayList<>();
    private float start;
    Paint paint = new Paint();
    private double num = 0;

        public PieView(Context context, AttributeSet attrs,List<CircleData> datas) {
        super(context, attrs);
            this.rate = datas;
            for(CircleData i : rate){
                Log.d("TAG",i.getRate() + "");
                num += i.getRate();
            }
    }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            paint.setAntiAlias(true);
            float rr = (float) (r * Math.sin(Math.toRadians(5)) / (1 + Math.sin(Math.toRadians(5))));
            float c = r - rr;
            Log.d("check:"," " + num);
            start = 0;
            for(CircleData i : rate){
                i.setShowData(String.format("%.2f",i.getRate()/num*100) + "%");
                double mind_deg = i.getRate()/num*360/2+start;

                /**
                 * 描边
                 */
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(8);
                canvas.drawArc(Utils.getParentWidth(getContext()) / 2 - r
                                + ((float)Math.cos(Math.toRadians(mind_deg))) * 10 + rr,
                        Utils.getParentHeight(getContext()) / 2 - r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10 + rr,
                        Utils.getParentWidth(getContext()) / 2 + r
                                +  ((float)Math.cos(Math.toRadians(mind_deg))) * 10 - rr,
                        Utils.getParentHeight(getContext()) / 2 + r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10 - rr,
                        start,5f,true,paint);

                start += 5f;
                canvas.drawCircle((float) (Utils.getParentWidth(getContext()) / 2
                                + Math.cos(Math.toRadians(mind_deg)) * 10 + c * Math.cos(Math.toRadians(start))),
                        (float) (Utils.getParentHeight(getContext()) / 2
                                + (Math.sin(Math.toRadians(mind_deg))) * 10 + c * Math.sin(Math.toRadians(start))),rr,paint);

                canvas.drawArc(Utils.getParentWidth(getContext()) / 2 - r
                                + ((float)Math.cos(Math.toRadians(mind_deg))) * 10,
                        Utils.getParentHeight(getContext()) / 2 - r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10,
                        Utils.getParentWidth(getContext()) / 2 + r
                                +  ((float)Math.cos(Math.toRadians(mind_deg))) * 10,
                        Utils.getParentHeight(getContext()) / 2 + r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10,
                        start, Float.parseFloat(Utils.num2deg((float) (i.getRate()/num*360-10))),true,paint);
                start += (float) (i.getRate()/num*360-10);
                canvas.drawArc(Utils.getParentWidth(getContext()) / 2 - r
                                + ((float)Math.cos(Math.toRadians(mind_deg))) * 10 + rr,
                        Utils.getParentHeight(getContext()) / 2 - r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10 + rr,
                        Utils.getParentWidth(getContext()) / 2 + r
                                +  ((float)Math.cos(Math.toRadians(mind_deg))) * 10 - rr,
                        Utils.getParentHeight(getContext()) / 2 + r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10 - rr,
                        start, 5f,true,paint);
                canvas.drawCircle((float) (Utils.getParentWidth(getContext()) / 2
                                + Math.cos(Math.toRadians(mind_deg)) * 10 + c * Math.cos(Math.toRadians(start))),
                        (float) (Utils.getParentHeight(getContext()) / 2
                                + (Math.sin(Math.toRadians(mind_deg))) * 10 + c * Math.sin(Math.toRadians(start))),rr,paint);
                start = start + 5;



                /**
                 * 内容
                 */
                paint.reset();
                start = start - (float) (i.getRate()/num*360);
                paint.setColor(Color.parseColor(i.getColor()));
                paint.setAntiAlias(true);
                canvas.drawArc(Utils.getParentWidth(getContext()) / 2 - r
                                + ((float)Math.cos(Math.toRadians(mind_deg))) * 10 + rr,
                        Utils.getParentHeight(getContext()) / 2 - r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10 + rr,
                        Utils.getParentWidth(getContext()) / 2 + r
                                +  ((float)Math.cos(Math.toRadians(mind_deg))) * 10 - rr,
                        Utils.getParentHeight(getContext()) / 2 + r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10 - rr,
                        start,5f,true,paint);
                canvas.drawCircle((float) (Utils.getParentWidth(getContext()) / 2
                                + Math.cos(Math.toRadians(mind_deg)) * 10 + c * Math.cos(Math.toRadians(start+5))),
                        (float) (Utils.getParentHeight(getContext()) / 2
                                + (Math.sin(Math.toRadians(mind_deg))) * 10 + c * Math.sin(Math.toRadians(start+5))),rr,paint);
                start += 5f;

                paint.setColor(Color.parseColor(i.getColor()));
                canvas.drawArc(Utils.getParentWidth(getContext()) / 2 - r
                                + ((float)Math.cos(Math.toRadians(mind_deg))) * 10,
                        Utils.getParentHeight(getContext()) / 2 - r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10,
                        Utils.getParentWidth(getContext()) / 2 + r
                                +  ((float)Math.cos(Math.toRadians(mind_deg))) * 10,
                        Utils.getParentHeight(getContext()) / 2 + r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10,
                        start, Float.parseFloat(Utils.num2deg((float) (i.getRate()/num*360-10))),true,paint);

                start += (float) (i.getRate()/num*360-10);

                paint.reset();
                paint.setColor(Color.parseColor(i.getColor()));
                canvas.drawArc(Utils.getParentWidth(getContext()) / 2 - r
                                + ((float)Math.cos(Math.toRadians(mind_deg))) * 10 + rr,
                        Utils.getParentHeight(getContext()) / 2 - r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10 + rr,
                        Utils.getParentWidth(getContext()) / 2 + r
                                +  ((float)Math.cos(Math.toRadians(mind_deg))) * 10 - rr,
                        Utils.getParentHeight(getContext()) / 2 + r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10 - rr,
                        start, 5f,true,paint);
                canvas.drawCircle((float) (Utils.getParentWidth(getContext()) / 2
                                + Math.cos(Math.toRadians(mind_deg)) * 10 + c * Math.cos(Math.toRadians(start))),
                        (float) (Utils.getParentHeight(getContext()) / 2
                                + (Math.sin(Math.toRadians(mind_deg))) * 10 + c * Math.sin(Math.toRadians(start))),rr,paint);
                start = start + 5;

                paint.reset();
                paint.setColor(Color.parseColor("#666666"));
                paint.setTextSize(60);
                paint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(i.getShowData(),
                        (Utils.getParentWidth(getContext()) / 2
                                +  ((float)Math.cos(Math.toRadians(mind_deg))) * 200),
                        (Utils.getParentHeight(getContext()) / 2
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 200),
                        paint);
                paint.reset();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(15);
                canvas.drawArc(Utils.getParentWidth(getContext()) / 2 - r
                                + ((float)Math.cos(Math.toRadians(mind_deg))) * 10 + r/4*3,
                        Utils.getParentHeight(getContext()) / 2 - r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10 + r/4*3,
                        Utils.getParentWidth(getContext()) / 2 + r
                                +  ((float)Math.cos(Math.toRadians(mind_deg))) * 10 - r/4*3,
                        Utils.getParentHeight(getContext()) / 2 + r
                                + ((float)Math.sin(Math.toRadians(mind_deg))) * 10 - r/4*3,
                        start -(float) (i.getRate()/num*360),(float) (i.getRate()/num*360),true ,paint);
            }

            paint.reset();
            paint.setColor(Color.parseColor("#ffffff"));
            canvas.drawCircle(Utils.getParentWidth(getContext()) / 2,
                    Utils.getParentHeight(getContext()) / 2 ,r / 4,paint);

            paint.reset();
        }
}
