package com.hutsalod.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;


import com.hutsalod.hutmovie.HutMovie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HutMovie person1 = new HutMovie(findViewById(R.id.Person1));
        HutMovie person2 = new HutMovie(findViewById(R.id.Person2));

        person1.right(200)
               .repeat(true)
               .onRun();

        person2.move(200,300)
               .repeat(true)
               .onRun();

//        person2.setAction(new HutMovie.Action() {
//            @Override
//            public void onAction(float x, float y, boolean collision) {
//                // if(y > 190) new HutMovie(findViewById(R.id.Person1)).follow(findViewById(R.id.Person2)).onRun();
//            }});

    }
}
