package com.hutsalod.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.hutsalod.hutmovie.HutMovie;

public class MainActivity extends AppCompatActivity {

    private HutMovie hutMovie = new HutMovie();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView person1 = findViewById(R.id.Person1);
        final ImageView person2 = findViewById(R.id.Person2);

        new HutMovie.onStart() {
            @Override
            public void onRun() {
                hutMovie.goRight(person1, 3); //Move the Person1 to the Right
                hutMovie.goDown(person1, 2); //Move the Person1 to the Down
                hutMovie.move(person2, 2, 3); //Move Person2 edges by X and Y
            }
        };


    }

}
