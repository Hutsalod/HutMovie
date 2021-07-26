package com.hutsalod.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;


import com.hutsalod.hutmovie.HutMovie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HutMovie person1 = new HutMovie(findViewById(R.id.Person1));
        HutMovie person2 = new HutMovie(findViewById(R.id.Person2));

        person1.move(300,300).onRun();

        person2.move(-300,300).collision(person1)
            .setAction(new HutMovie.Collision() {
                   @Override
                   public void onActionCollision() {
                       Toast.makeText(getApplicationContext(), "WORKING!",Toast.LENGTH_SHORT).show();
                   }})
            .onRun();

    }
}
