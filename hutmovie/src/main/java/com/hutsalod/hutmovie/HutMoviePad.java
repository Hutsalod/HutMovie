package com.hutsalod.hutmovie;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class HutMoviePad extends FrameLayout {

    private Action mListener;
    public Button top, bottom, left, right;
    private boolean blocked = false;

    public HutMoviePad(Context context) {
        super(context);
        init(context, null);
    }

    public HutMoviePad(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init (Context context, AttributeSet attrs){
        View view = LayoutInflater.from(context).inflate(R.layout.layout_pad, this);

        top = view.findViewById(R.id.top);
        bottom = view.findViewById(R.id.bottom);
        left = view.findViewById(R.id.left);
        right = view.findViewById(R.id.right);

        initTouchListener();
    }

    private void initTouchListener(){
        top.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mListener.onTop();
                return false;
            }
        });
        bottom.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mListener.onBottom();
                return false;
            }
        });
        left.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mListener.onLeft();
                return false;
            }
        });
        right.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mListener.onRight();
                return false;
            }
        });
    }

    public HutMoviePad setAction(Action listener){
        mListener = listener;
        return  this;
    }

    public interface Action{
        void onTop();
        void onLeft();
        void onRight();
        void onBottom();
    }
}


