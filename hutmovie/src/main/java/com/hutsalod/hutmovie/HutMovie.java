package com.hutsalod.hutmovie;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class HutMovie {

    public static void Hide(final View view, long duration) {
        view.animate().scaleX(0).scaleY(0).setDuration(duration).withEndAction(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(GONE);
            }
        });
    }
    public static void Show(final View view,long duration) {
        view.animate().scaleX(1).scaleY(1).setDuration(duration).withStartAction(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(VISIBLE);
            }
        });
    }

    public static void xy(final View view,float x,float y) {
        view.setX(x);
        view.setX(y);
    }

    public static void goLeft(final View view, long x) {
        view.setX(view.getX()-x);
    }

    public static void goRight(final View view,long x) {
        view.setX(view.getX()+x);
    }

    public static void goUp(final View view,long y) {
        view.setY(view.getY()-y);
    }

    public static void goDown(final View view,long y) {
        view.setY(view.getY()+y);
    }

    public static boolean isCheck(final View view, final View view2) {
        if ((view.getX()+view.getWidth()) >= view2.getX() && view.getX() <= (view2.getX()+view2.getWidth()) && view.getY() <= (view2.getY()+view2.getHeight()) && view.getY() >= (view2.getY()-view2.getHeight()) ) {
            return true;
        }
        return false;
    }

    public static boolean isCheck(final View view, final View view2,int size) {
        if ((view.getX()+view.getWidth()-size) >= view2.getX() && view.getX() <= (view2.getX()+view2.getWidth()-size) && view.getY() <= (view2.getY()+view2.getHeight()-size) && view.getY() >= (view2.getY()-view2.getHeight()+size) ) {
            return true;
        }
        return false;
    }

    public static boolean isRoom(final View view,Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        if (view.getX() < 0 || view.getY() < 0 || view.getX() > size.x || view.getY() > +size.y) {
            return true;
        }
        return false;
    }



}