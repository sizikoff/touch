package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    TextView textview;

    float x;
    float y;
    String sDown;
    String sMove;
    String sUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textview = new TextView(this);
        textview.setOnTouchListener(this);
        setContentView(textview);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x=event.getX();
        y=event.getY();
        switch (event.getAction()){
            //нажатие
            case MotionEvent.ACTION_DOWN:
                sDown = "Down " +x+"," + y;
                sMove = "";
                sUp = "";
                break;
                //движение
            case MotionEvent.ACTION_MOVE:
                sMove = "Move "+ x+ ","+y;
                break;
                //ОТПУСКАЕМ
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                sMove = "";
                sUp = "UP "+ x + ","+y ;
                break;
        }
        Log.d("TOUCH",sDown+"\n"+sMove+"\n"+sUp);
        return false;
    }
}