package com.hutsalod.hutmovie;

import android.view.View;

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


    public static boolean hitCheck(final View view, final View view2) {
        boolean b = false;
        if (view.getX() >= view2.getX() && view.getX() <= view2.getX()+view2.getWidth()  && view.getY() >= view2.getY() && view.getY() <= view2.getY()+view2.getHeight()) {
            b=true;
        }
        return b;
    }

   /* public static boolean isRoom(final View view,final View room) {
        boolean b = false;
        if (view.getX()+view.getWidth() <= 0 || view.getY()+view.getHeight() <= 0 || view.getX()+view.getWidth() >= room.getWidth() || view.getY()+view.getHeight() >= view.getHeight()) {
            b=true;
        }
        return b;
    }*/
}