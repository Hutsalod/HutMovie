package com.hutsalod.hutmovie.logic;

import android.view.View;

import com.hutsalod.hutmovie.AnimatedActions;

public class RotationMovie extends AnimatedActions {

    public RotationMovie(final float value) {
        this.value = value;
    }
    @Override
    public void update(View view, View viewTwo, float speed, boolean repeat, Collision collisionListener) {
        if ((value >= view.getRotation() || repeat == true) && value != 0) {
            view.setRotation(view.getRotation() + speed);
        }
        if (value <= view.getRotation() && repeat == false) {
            this.value = 0;
        }
    }
}
