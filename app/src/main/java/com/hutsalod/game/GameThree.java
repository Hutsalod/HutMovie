package com.hutsalod.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Toast;

import com.hutsalod.hutmovie.HutMovie;

public class GameThree extends AppCompatActivity {
    private HutMovie hutMovie = new HutMovie();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_three);

        final HorizontalScrollView scrollView = findViewById(R.id.scroll);
        final ImageView image = findViewById(R.id.imageView);


        new HutMovie.onStart() {
            @Override
            public void onRun() {
              //  scrollView.scrollTo((int) image.getX(), 0);
              // hutMovie.goUp(image, 3);
            }
        };
    }
}