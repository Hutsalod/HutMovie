package com.hutsalod.game;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hutsalod.hutmovie.HutMovie;
import com.hutsalod.hutmovie.HutMoviePad;

public class GameRpg extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main_rpg_two);


        final HutMovie person1 = new HutMovie(findViewById(R.id.Person1));
        final HutMoviePad pad =  findViewById(R.id.gamepad);

        pad.setAction(new HutMoviePad.Action() {
            @Override
            public void onTop() {
                person1.y(person1.view.getY()-5);
            }

            @Override
            public void onBottom() {
                person1.y(person1.view.getY()+5);
            }

            @Override
            public void onLeft() {
                person1.x(person1.view.getX()-5);
            }

            @Override
            public void onRight() {
                person1.x(person1.view.getX()+5);
            }
        });


        person1.onRun();

    }
}
