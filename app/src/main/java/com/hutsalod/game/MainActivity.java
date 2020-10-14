package com.hutsalod.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.hutsalod.hutmovie.HutMovie;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Handler play = new Handler();

    private ImageView Person1,Person2;

    private HutMovie hutMovie = new HutMovie();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person1 = findViewById(R.id.Person1);
        Person2 = findViewById(R.id.Person2);

        play.postDelayed(new Runnable() {
            @Override
            public void run() {

                hutMovie.goRight(Person1,3);
                hutMovie.goRight(Person2,2);
                hutMovie.goDown(Person1,2);
                hutMovie.goDown(Person2,3);

                play.post(this);

            }
        },20);
    }

}
