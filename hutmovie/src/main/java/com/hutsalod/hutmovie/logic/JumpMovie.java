package com.hutsalod.hutmovie.logic;


import android.view.View;

import com.hutsalod.hutmovie.AnimatedActions;

public class JumpMovie extends AnimatedActions {

    private float jump, jumpY;

    public JumpMovie(final float y, final float jump) {
        this.jump = (int) (y - jump * 2);
        this.jumpY = (int) (y);
    }
    @Override
    public void update(View view, View viewTwo, float speed, boolean repeat, Collision collisionListener) {
        if (jump <= view.getY() && jump != -1) {
            view.setY(view.getY() - speed);
        } else if (jumpY >= view.getY() && jump == -1){
            view.setY(view.getY() + speed);
        } else if (jump >= view.getY()){
            jump = -1;
        } else if (jumpY <= view.getY()){
            jump = 0;
        }
    }
}
