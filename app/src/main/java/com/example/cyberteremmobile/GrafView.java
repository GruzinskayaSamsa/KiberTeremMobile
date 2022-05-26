package com.example.cyberteremmobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GrafView extends View {
    int height;
    int widht;
    float leftAxisY;
    float downAxisX;
    float leftAxisEndY;
    float downAxisEndX;
    Paint axisPaint;
    Float[] downAxisXCoords = new Float[5];
    Float[] leftAxisYCoords = new Float[5];
    


    public GrafView(Context context) {
        super(context);
    }

    public GrafView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public GrafView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setInitialData();
        setInitialCanvas(canvas);




    }

    public void setInitialData() {
        height = getHeight();
        widht = getWidth();
        leftAxisY = 0.9f;
        downAxisX = 0.12f;
        leftAxisEndY = 0.15f;
        downAxisEndX = 0.93f;
        axisPaint = new Paint();
        axisPaint.setStrokeWidth((float)getHeight()*getWidth()/81000f);

        for (int i = 0; i< leftAxisYCoords.length; i++){
            leftAxisYCoords[i] = leftAxisY - i*(leftAxisY-leftAxisEndY)/ leftAxisYCoords.length +
                    0.005f - i*0.024f;
        }
        for (int i = 0; i< downAxisXCoords.length; i++){
            downAxisXCoords[i] = downAxisX + i*downAxisEndX/ downAxisXCoords.length -
                    0f + i*0.008f;
        }


    }

    public void setInitialCanvas(Canvas canvas){
        canvas.drawARGB(255, 128, 128, 255);
        Paint paint = new Paint();

        paint.setTextSize((float)getHeight()*getWidth()/9000f);


        //canvas.drawText(Integer.toString(getWidth()), 100f, 40f, paint);
        //canvas.drawText(Integer.toString(getHeight()), 200f, 40f, paint);
        drawLine(downAxisX,leftAxisY,downAxisEndX,leftAxisY, canvas,axisPaint);
        drawLine(downAxisX, leftAxisY, downAxisX, leftAxisEndY,canvas,axisPaint);
        //drawRotatedText("value",0.1f,0.6f,canvas,paint,90f);
        //drawText("value",(downAxisEndX+downAxisX)/2-0.1f,leftAxisY+0.08f,canvas,paint);
        drawText("Название датчика", 0.25f,0.1f,canvas,paint);
        for(int i = 0;i<downAxisXCoords.length;i++){
            drawText(""+i,downAxisXCoords[i],leftAxisY+0.08f,canvas,paint);
        }
        for(int i =0;i<leftAxisYCoords.length;i++){
            drawText(""+i,downAxisX - 0.06f,leftAxisYCoords[i], canvas,paint);
        }
    }

    public void drawLine(float x0, float y0, float x1, float y1, Canvas canvas, Paint paint) {
        canvas.drawLine(x0*widht,y0*height,x1*widht,y1*height,paint);

    }
    public void  drawRotatedText(String text, float x, float y, Canvas canvas, Paint paint, float rotate){
        canvas.save();
        canvas.rotate(-rotate, x*widht, y*height);

        drawText(text,x,y,canvas,paint);
        canvas.restore();
    }

    public void drawText(String text, float x, float y, Canvas canvas, Paint paint) {
        canvas.drawText(text,x*widht,y*height,paint);

    }


    public class Point {
        float x;
        float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return (int) x;
        }

        public int getY() {
            return (int) y;
        }
    }
}
