package com.hutsalod.hutsalodgame;

import android.view.View;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Animate {

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

    public static void goLEFT(final View view, long x) {
        view.setX(view.getX()-x);
    }

    public static void goRIGHT(final View view,long x) {
        view.setX(view.getX()+x);
    }

    public static void goUP(final View view,long y) {
        view.setY(view.getY()+y);
    }

    public static void goDOWN(final View view,long y) {
        view.setY(view.getY()-y);
    }

    public static void goJUMP(final View view,long y,long height) {
        view.setY(view.getY()+y);
        view.setY(view.getY()-y);
    }

    public static boolean hitCheck(final View view, final View view2) {
        boolean b = false;
        if (view.getX() >= view2.getX() && view.getX() <= view2.getX()+view2.getWidth()  && view.getY() >= view2.getY() && view.getY() <= view2.getY()+view2.getHeight()) {
            b=true;
        }
        return b;
    }
}