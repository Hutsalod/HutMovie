package com.hutsalod.hutmovie;

import android.view.View;

public class AnimatedActions {
    public float value = 1;
    public float moveX = 1, moveY = 1;
    public void update(View view, View viewTwo,  float speed, boolean repeat, Collision collisionListener){
    }

    public interface Collision{
        void onCollision(boolean result);
    }
}
