package com.hutsalod.hutmovie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

//
//  HutMovie
//
//  Created by Hutsalod Dmytro.
//
//

public class HutMovie {

    private Context context;
    private View view = null;

    public HutMovie(){
    }

    public HutMovie(final Context context){
        this.context = context;
    }

    public HutMovie(final View view){
        this.view = view;
        this.view.animate().setDuration(1000);
    }


    /**
     * onBackPressed
     * @return whether back is handled or not.
     */

    public  void hide(final View view, int duration) {
    view.animate().scaleX(0).scaleY(0)
            .setDuration(duration)
            .withEndAction(new Runnable() {
                @Override
                public void run() {
                view.setVisibility(GONE);
            }});
    }

    public  void show(final View view, int duration) {
        view.animate().scaleX(1).scaleY(1)
            .setDuration(duration)
            .withStartAction(new Runnable() {
                @Override
                public void run() {
                view.setVisibility(VISIBLE);
            }});
    }

    public  void position(float x,float y) {
        view.setX(x);
        view.setY(y);
    }

    public  void move(final View view,float x,float y) {
        view.setX(x<0 ?  view.getX()-x :  view.getX()+x);
        view.setY(y<0 ?  view.getY()-y :  view.getY()+y);
    }

    public  void goLeft(final View view, int x) {
        view.setX(view.getX()-x);
    }

    public  void goRight(final View view, int x) {
        view.setX(view.getX()+x);
    }

    public  void goUp(final View view, int y) {
        view.setY(view.getY()-y);
    }

    public  void goDown(final View view, int y) {
        view.setY(view.getY()+y);
    }



    public  HutMovie move(float x,float y) {
        view.animate().x(x).y(y);
        return this;
    }

    public  HutMovie left(int x) {
        view.animate().x(x);
        return this;
    }

    public  HutMovie right(int x) {
        view.animate().x(x);
        return this;
    }

    public  HutMovie down(int y) {
        return this;
    }

    public  HutMovie rotation(int rotation) {
        view.animate().rotation(rotation);
        return this;
    }


    public  boolean isCheck(final View view) {
        return setCheck(this.view, view, 0);
    }

    private boolean setCheck(final View view, final View view2, int size) {
        size = size == 0 ? 0 : size;
        if ((view.getX()+view.getWidth()-size) >= view2.getX() &&
                view.getX() <= (view2.getX()+view2.getWidth()-size) &&
                view.getY() <= (view2.getY()+view2.getHeight()-size) &&
                view.getY() >= (view2.getY()-view2.getHeight()+size) )
            return true;
        return false;
    }


    public  boolean isRoom() {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        if (this.view.getX() == 0 || (this.view.getY() == 0 ) || this.view.getX() == size.x || this.view.getY() == +size.y) {
            return true;
        }
        return false;
    }

    public HutMovie spead(int duration) {
        view.animate().setDuration(duration);
        return this;
    }

    public HutMovie onRun() {
        view.animate().start();
        return HutMovie.this;
    }


    /**
     * onBackPressed
     * @return whether back is handled or not.
     */



    public abstract static class onStart {

        private final  Handler p = new Handler();
        private boolean play = true;
        public abstract void onRun();
        public void stopPlay(){
            play = false;
        }
        public void startPlay(){
            play = true;
        }

        public  onStart(){ p.post(new Runnable() {
            @Override public void run() {
                if (play) {
                    onStart.this.onRun();
                }
                p.post(this);
            }});
        }
    }


}



