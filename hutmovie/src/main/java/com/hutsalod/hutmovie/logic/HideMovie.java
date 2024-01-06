package com.hutsalod.hutmovie.logic;

import android.view.View;

import com.hutsalod.hutmovie.AnimatedActions;

public class HideMovie extends AnimatedActions {

    public HideMovie(final float value) {
        this.value = value;
    }
    @Override
    public void update(View view, View viewTwo, float speed, boolean repeat, Collision collisionListener) {
        if ((0 <= view.getScaleX()) && value != 0) {
            view.setScaleX((float) (view.getScaleX() - 0.001 * value));
            view.setScaleY((float) (view.getScaleY() - 0.001 * value));
        }
        if (0 >= view.getScaleX()) {
            this.value = 0;
        }
    }
}
