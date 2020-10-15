package com.hutsalod.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hutsalod.hutmovie.HutMovie;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private HutMovie game = new HutMovie();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView person1 = findViewById(R.id.Person1);
        final ImageView person2 = findViewById(R.id.Person2);

        game.setGame(new HutMovie.play() {
            @Override
            public void run() {
                game.goRight(person1,3);
                game.goDown(person1,2);
                game.move(person2,2, 3);
            }
        });

    }
}
