package com.hutsalod.hutmovie;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.concurrent.Future;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class HutMovie {

    public Context context;

    public HutMovie(Context context){
        this.context = context;
    }

    public HutMovie(){
    }

    public play setGame;

    public  void hide(final View view, long duration) {
    view.animate().scaleX(0).scaleY(0)
            .setDuration(duration)
            .withEndAction(new Runnable() {
                @Override
                public void run() {
                view.setVisibility(GONE);
            }});
    }

    public  void show(final View view,long duration) {
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

    public  void move(final View view,float x,float y) {
        view.setX(x<0 ?  view.getX()-x :  view.getX()+x);
        view.setY(y<0 ?  view.getY()-y :  view.getY()+y);
    }

    public  void goLeft(final View view, long x) {
        view.setX(view.getX()-x);
    }

    public  void goRight(final View view,long x) {
        view.setX(view.getX()+x);
    }

    public  void goUp(final View view,long y) {
        view.setY(view.getY()-y);
    }

    public  void goDown(final View view,long y) {
        view.setY(view.getY()+y);
    }

    public  boolean isCheck(final View view, final View view2) {
        if ((view.getX()+view.getWidth()) >= view2.getX() && view.getX() <= (view2.getX()+view2.getWidth()) && view.getY() <= (view2.getY()+view2.getHeight()) && view.getY() >= (view2.getY()-view2.getHeight()) )
            return true;
        return false;
    }

    public  boolean isCheck(final View view, final View view2,int size) {
        if ((view.getX()+view.getWidth()-size) >= view2.getX() && view.getX() <= (view2.getX()+view2.getWidth()-size) && view.getY() <= (view2.getY()+view2.getHeight()-size) && view.getY() >= (view2.getY()-view2.getHeight()+size) )
            return true;
        return false;
    }

    public  boolean isRoom(final View view,Context context) {
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

    public void setGame(play listener){
        setGame = listener;
    }

    public abstract static class play{
        final  Handler p = new Handler();
        public boolean stop = false;
        public  play(){ p.post(new Runnable() {
            @Override public void run() {
                if (!stop)
                play.this.run();
                p.post(this);
               }});
        }
        public abstract void run();
    }

}



