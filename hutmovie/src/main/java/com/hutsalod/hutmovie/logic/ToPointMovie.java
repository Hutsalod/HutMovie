package com.hutsalod.hutmovie.logic;

import android.view.View;

import com.hutsalod.hutmovie.AnimatedActions;

public class ToPointMovie extends AnimatedActions {



    public ToPointMovie(final float moveX, final float moveY) {
        this.moveX = moveX;
        this.moveY = moveY;
    }
    @Override
    public void update(View view, View viewTwo, float speed, boolean repeat, Collision collisionListener) {
        if (((moveX >= view.getX() || moveX <= view.getX())  || repeat == true) && moveX != 0)
            view.setX(moveX <= 0 ?  view.getX()-speed :  view.getX()+speed);
        if (((moveY >= view.getY() || moveY <= view.getY()) || repeat == true) && moveY != 0)
            view.setY(moveY <= 0 ?  view.getY()-speed :  view.getY()+speed);

        if (moveX <= view.getX() && moveY <= view.getY() && repeat == false) {
            this.moveY = 0;
            this.moveX = 0;
        }
    }
}
