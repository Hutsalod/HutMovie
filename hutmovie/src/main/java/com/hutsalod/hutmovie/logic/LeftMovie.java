package com.hutsalod.hutmovie.logic;

import android.view.View;

import com.hutsalod.hutmovie.AnimatedActions;

public  class  LeftMovie extends AnimatedActions {

    public LeftMovie(final float value) {
        this.value = value;
    }

    @Override
    public void update(View view, View viewTwo, float speed, boolean repeat, Collision collisionListener) {
        if ((value <= view.getX() || repeat == true) && value != 0) {
            view.setX(view.getX() - speed);
        }
        if (value >= view.getX() && repeat == false) {
            value = 0;
        }
    }
}
