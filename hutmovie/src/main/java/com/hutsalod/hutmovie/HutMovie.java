package com.hutsalod.hutmovie;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
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
    public View view = null;
    private onStart time;

    public HutMovie(){
    }

    public HutMovie(final Context context){
        this.context = context;
    }

    public HutMovie(final View view){
        this.view = view;
    }

    public  HutMovie setContext(final Context context){
        this.context = context;
        return this;
    }

    public  HutMovie isStart(final Boolean bool){
        if (!bool) time.stopPlay();
        return this;
    }

    public  void setGame(onStart listener){
        time = listener;
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

    public  void position(final View view,float x,float y) {
            view.setX(x);
            view.setY(y);
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


    public void goJump(final View view, final int jump){

        final float[] getY = {view.getY()};
        final byte[] maxJump = {0};

        Handler p = new Handler();
        p.post(new Runnable() {
            @Override public void run() {
                if (maxJump[0] == 1) {
                    getY[0] = getY[0] - 1;
                    if (view.getY() <= (getY[0] - jump))
                        maxJump[0] = 2;
                }
                if (maxJump[0] == 2) {
                    view.setY(view.getY() + 1);
                    if (view.getY() >= getY[0])
                        maxJump[0] = 0;
                }
                view.setY(view.getY());
            }});
    }

    public  void move(float x,float y) {
        if (view != null) {
            view.setX(x < 0 ? view.getX() - x : view.getX() + x);
            view.setY(y < 0 ? view.getY() - y : view.getY() + y);
        }
    }

    public  void goLeft(int x) {
        if (view != null)
            view.setX(view.getX()-x);
    }

    public  void goRight(int x) {
        if (view != null)
            view.setX(view.getX()+x);
    }

    public  boolean isCheck(final View view, final View view2) {
        return setCheck(view, view2, 0);
    }

    public  boolean isCheck(final View view, final View view2, int size) {
        return setCheck(view, view2, size);
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


    public  boolean isRoom(final View view) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        if (view.getX() == 0 || (view.getY() == 0 ) || view.getX() == size.x || view.getY() == +size.y) {
            return true;
        }
        return false;
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
                if (play) onStart.this.onRun();
                p.post(this);
            }});
        }

    }
}



