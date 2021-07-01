package com.hutsalod.hutmovie;


import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

//
//  HutMovie
//
//  Created by Hutsalod Dmytro.
//
//

public class HutMovie {
    private View view = null, viewTwo = null;
    private Boolean repeat = false;
    private Boolean collision = false;

    private float speed = 1; //Default 1

    private int up, down, left, right, rotation, jump, jumpY, moveX, moveY, scaleShow, scaleHide;

    public HutMovie(final View view){
        this.view = view;
    }

    /**
     * DESCRIPTION OF LIBRARY FUNCTIONS
     */

    public  HutMovie hide(int scaleHide) {
        this.scaleHide = scaleHide;
        return this;
    }

    public  HutMovie show(int scaleShow) {
        this.scaleShow = scaleShow;
        return this;
    }

    public  HutMovie position(float x,float y) {
        this.view.setX(x);
        this.view.setY(y);
        return this;
    }

    public  HutMovie x(int x) {
        this.view.setX(x);
        return this;
    }

    public  HutMovie y(int y) {
        this.view.setY(y);
        return this;
    }

    public  HutMovie move(final int x, final int y) {
        this.moveX = x;
        this.moveY = y;
        return this;
    }

    public  HutMovie rotation(final int rotation) {
        this.rotation = rotation;
        return this;
    }

    public  HutMovie right(final int x) {
        this.right = (int) (view.getX()+x);

        return this;
    }

    public  HutMovie left(final int x) {
        this.left = (int) (view.getX()-x);
        return this;
    }

    public  HutMovie up(final int y) {
        this.up = (int) (view.getY()-y);
        return this;
    }

    public  HutMovie down(final int y) {
        this.down = (int) (view.getY()+y);
        return this;
    }

    public  HutMovie repeat(boolean repeat) {
        this.repeat = repeat;
        return this;
    }

    public  HutMovie jump(final int jump) {
        this.jump = (int) (view.getY()-jump);
        this.jumpY = (int) (view.getY());
        return this;
    }

    public  HutMovie follow(final View v) {
        this.viewTwo = v;
        return this;
    }

    public HutMovie speed(float speed) {
        this.speed = speed;
        return this;
    }

    public  Boolean isCheck(final View view) {
        return setCheck(this.view, view, 0);
    }


    /**
     * CORE DESCRIPTION OF LIBRARY FUNCTIONS
     */

    private boolean setCheck(final View view, final View view2, int size) {
        size = size == 0 ? 0 : size;
        if ((view.getX()+view.getWidth()-size) >= view2.getX() &&
                view.getX() <= (view2.getX()+view2.getWidth()-size) &&
                view.getY() <= (view2.getY()+view2.getHeight()-size) &&
                view.getY() >= (view2.getY()-view2.getHeight()+size) ) {
            collision = true;
            return true;
        }
        return false;
    }

    private  void toMove() {
        if (moveX >= view.getX() || repeat == true)
            this.view.setX(moveX <= 0 ?  view.getX()-speed :  view.getX()+speed);
        if (moveY >= view.getY() || repeat == true)
            this.view.setY(moveY <= 0 ?  view.getY()-speed :  view.getY()+speed);

        if (moveX <= view.getX() && moveY <= view.getY() && repeat == false) {
            this.moveY = 0;
            this.moveX = 0;
        }
    }

    private HutMovie toLeft() {
        if (left <= view.getX() || repeat == true)
            this.view.setX(view.getX()-speed);
        if (left >= view.getX() && repeat == false)
            this.left = 0;
        return null;
    }

    private  void toRight() {
        if (right >= view.getX() || repeat == true)
            this.view.setX(view.getX()+speed);
        if (right <= view.getX() && repeat == false)
            this.right = 0;
    }

    private HutMovie toUp() {
        if (up <= view.getY() || repeat == true)
            this.view.setY(view.getY()-speed);
        if (up >= view.getY() && repeat == false)
            this.up = 0;
        return null;
    }

    private  void toDown() {
        if (down >= view.getY() || repeat == true)
            this.view.setY(view.getY()+speed);
        if (down <= view.getY() && repeat == false)
            this.down = 0;
    }

    private  void toRotation() {
        if (rotation >= view.getRotation() || repeat == true)
            this.view.setRotation(view.getRotation()+speed);
        if (rotation <= view.getRotation() && repeat == false)
            this.rotation = 0;
    }

    private  void toScaleShow() {
        if (1 >= view.getScaleX()) {
            this.view.setScaleX((float) (view.getScaleX() + 0.001 * scaleShow));
            this.view.setScaleY((float) (view.getScaleY() + 0.001 * scaleShow));
        }
        if (0 <= view.getScaleX())
            this.scaleHide = 0;
    }

    private  void toScaleHide() {
        if (0 <= view.getScaleX()) {
            this.view.setScaleX((float) (view.getScaleX() - 0.001 * scaleHide));
            this.view.setScaleY((float) (view.getScaleY() - 0.001 * scaleHide));
        }
        if (0 >= view.getScaleX())
            this.scaleHide = 0;
    }

    private  void toFollow() {
        this.view.setX(view.getX() >= viewTwo.getX() ? view.getX()-speed : view.getX()+speed);
        this.view.setY(view.getY() >= viewTwo.getY() ? view.getY()-speed : view.getY()+speed);

        if (isCheck(viewTwo))
        collision = true;
        else
        collision = false;
    }

    private   void toJump() {
        if (jump <= view.getY() && jump != 0)
            view.setY(view.getY() - speed);
        if (jumpY >= view.getY() && jump == -1)
            view.setY(view.getY() + speed);
        if (jump >= view.getY())
            jump = -1;
        if (jumpY <= view.getY())
            jump = 0;
    }

    private int isStop() {
        return right | left | down | up | rotation | jump | scaleShow | scaleHide | moveX | moveY | scaleShow | scaleHide;
    }

    private void update() {
        if(right != 0) toRight();
        if(left != 0) toLeft();
        if(down != 0) toDown();
        if(up != 0) toUp();
        if(rotation != 0) toRotation();
        if(jump != 0) toJump();
        if(scaleShow != 0) toScaleShow();
        if(scaleHide != 0) toScaleHide();
        if(moveX != 0 || moveY != 0) toMove();
        if(viewTwo != null) toFollow();

        mListener.onAction(view.getX(),view.getY(), collision);
    }

    /**
     * CORE
     */
    public HutMovie onRun() {
        final  Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override public void run() {

                update();
                handler.post(this);

                if (isStop() == 0)
                handler.removeCallbacks(this);

            }});
        return HutMovie.this;
    }

    private Action mListener = new HutMovie.Action() {
        @Override
        public void onAction(float x, float y, boolean collision) {

        }
    };

    public interface Action{
        void onAction(float x, float y, boolean collision);
    }

    public HutMovie setAction(Action listener){
        mListener = listener;
        return  this;
    }



}



