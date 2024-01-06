package com.hutsalod.game;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hutsalod.hutmovie.HutMovie;


public class GameExample extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HutMovie person1 = new HutMovie(findViewById(R.id.person1));
        HutMovie person2 = new HutMovie(findViewById(R.id.person2));

        person1.move(300, 300).onRun();

        person2.move(-300, 300)
                .collision(person1, result -> {
                        Toast.makeText(getApplicationContext(), "WORKING!", Toast.LENGTH_SHORT).show();
                    })
                .onRun();

    }
}
