package com.hutsalod.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.hutsalod.hutmovie.HutMovie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new HutMovie(findViewById(R.id.Person1))
                .right(200)
                .repeat(true)
                .onRun();

        new HutMovie(findViewById(R.id.Person2))
                .down(200)
                .move(200,300)
                .repeat(true)
                .onRun();



    }




}
