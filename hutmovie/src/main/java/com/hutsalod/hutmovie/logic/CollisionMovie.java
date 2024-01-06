package com.hutsalod.hutmovie.logic;


import android.view.View;

import com.hutsalod.hutmovie.AnimatedActions;

public class CollisionMovie extends AnimatedActions {

    private boolean collision = false;

    public CollisionMovie(){
    }
    @Override
    public void update(View view, View viewTwo, float speed, boolean repeat, Collision collisionListener) {
        if (viewTwo != null) {
            if (setCheck(view, viewTwo, 0)) {
                if (collision != true) {
                    collisionListener.onCollision(collision);
                }
                collision = true;
                value = 0;
            } else {
                collision = false;
            }
        }
    }

    private boolean setCheck(final View view, final View view2, int size) {
        size = size == 0 ? 0 : size;
        if ((view.getX()+view.getWidth()) >= view2.getX() &&
                view.getX() <= (view2.getX()+view2.getWidth()) &&
                view.getY() <= (view2.getY()+view2.getHeight()) &&
                view.getY() >= (view2.getY()-view2.getHeight()) ) {
            return true;
        }
        return false;
    }
}
