package com.hutsalod.hutmovie.logic;


import android.view.View;

import com.hutsalod.hutmovie.AnimatedActions;

public class FollowMovie extends AnimatedActions {

    public FollowMovie(){

    }
    @Override
    public void update(View view, View viewTwo, float speed, boolean repeat, Collision collisionListener) {
        if (viewTwo != null) {
            view.setX(view.getX() >= viewTwo.getX() ? view.getX() - speed : view.getX() + speed);
            view.setY(view.getY() >= viewTwo.getY() ? view.getY() - speed : view.getY() + speed);
        }
    }
}
