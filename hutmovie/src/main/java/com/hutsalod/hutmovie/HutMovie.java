package com.hutsalod.hutmovie;

import android.os.Handler;
import android.view.View;

import com.hutsalod.hutmovie.logic.CollisionMovie;
import com.hutsalod.hutmovie.logic.DownMovie;
import com.hutsalod.hutmovie.logic.FollowMovie;
import com.hutsalod.hutmovie.logic.HideMovie;
import com.hutsalod.hutmovie.logic.JumpMovie;
import com.hutsalod.hutmovie.logic.LeftMovie;
import com.hutsalod.hutmovie.logic.RightMovie;
import com.hutsalod.hutmovie.logic.RotationMovie;
import com.hutsalod.hutmovie.logic.ShowMovie;
import com.hutsalod.hutmovie.logic.ToPointMovie;
import com.hutsalod.hutmovie.logic.UpMovie;
import java.util.ArrayList;
import java.util.List;

public class HutMovie {
    public HutMovie(final View view){
        this.view = view;
    }
    private List<AnimatedActions> hutViews = new ArrayList<>();

    public View view, viewTwo;
    private float speed = 1;
    private Boolean repeat = false;

    public  HutMovie speed(float speed) {
        this.speed = speed;
        return this;
    }
    public  HutMovie repeat(boolean repeat) {
        this.repeat = repeat;
        return this;
    }
    public HutMovie position(float x, float y) {
        this.view.setX(x);
        this.view.setY(y);
        return this;
    }

    public  HutMovie x(float x) {
        this.view.setX(x);
        return this;
    }

    public  HutMovie y(float y) {
        this.view.setY(y);
        return this;
    }

    public HutMovie hide(final int value) {
        hutViews.add(new HideMovie(value));
        return this;
    }

    public HutMovie show(final int value) {
        hutViews.add(new ShowMovie(value));
        return this;
    }

    public HutMovie move(final int x, final int y) {
        hutViews.add(new ToPointMovie(x, y));
        return this;
    }

    public HutMovie left(final int x) {
        hutViews.add(new LeftMovie(view.getX() - x));
        return this;
    }

    public HutMovie right(final int x) {
        hutViews.add(new RightMovie(view.getX() + x));
        return this;
    }

    public HutMovie up(final int y) {
        hutViews.add(new UpMovie(view.getY() - y));
        return this;
    }

    public HutMovie down(final int y) {
        hutViews.add(new DownMovie(view.getY() + y));
        return this;
    }

    public HutMovie jump(final int y) {
        hutViews.add(new JumpMovie(view.getY(), y));
        return this;
    }

    public HutMovie rotation(final int value) {
        hutViews.add(new RotationMovie(value));
        return this;
    }

    public HutMovie follow(final View v) {
        this.viewTwo = v;
        hutViews.add(new FollowMovie());
        return this;
    }

    public HutMovie stop() {
        hutViews.clear();
        return this;
    }

    public  HutMovie collision(final HutMovie view, Collision collision) {
        this.viewTwo = view.view;
        this.collisionListener = collision;
        hutViews.add(new CollisionMovie());
        return this;
    }

    /**
     * CORE
     */
    public HutMovie onRun() {
        final Handler handler = new Handler();

        if (view != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    update();

                    if (hutViews.size() != 0) {
                        handler.post(this);
                    }else {
                        handler.removeCallbacks(this);
                    }

                }
            });
        }
        return HutMovie.this;
    }


    void update(){
        for (int i = 0; i < hutViews.size(); i++) {
            hutViews.get(i).update(view, viewTwo, speed, repeat, new AnimatedActions.Collision() {
                @Override
                public void onCollision(boolean result) {
                    collisionListener.onCollision(result);
                }
            });
            if (hutViews.get(i).value == 0 || (hutViews.get(i).moveX == 0 && hutViews.get(i).moveY == 0)){
                hutViews.remove(i);
            }
        }
    }
    private Collision collisionListener;
    public interface Collision{
        void onCollision(boolean result);
    }
}
