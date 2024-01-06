package com.hutsalod.hutmovie.logic;


import android.view.View;

import com.hutsalod.hutmovie.AnimatedActions;

public class DownMovie extends AnimatedActions {


    public DownMovie(final float value) {
        this.value = value;
    }
    @Override
    public void update(View view, View viewTwo, float speed, boolean repeat, Collision collisionListener) {
        if ((value >= view.getY() || repeat == true) && value != 0) {
            view.setY(view.getY() + speed);
        }
        if (value <= view.getY() && repeat == false) {
            value = 0;
        }
    }
}
