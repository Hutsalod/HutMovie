package com.hutsalod.game;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hutsalod.hutmovie.HutMovie;

public class ActivityLevelTwo extends AppCompatActivity {

    private HutMovie game = new HutMovie();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);


        final ImageView person1 = findViewById(R.id.Person1);
        final ImageView enemy = findViewById(R.id.Enemy);

        new HutMovie.onStart() {
            @Override
            public void onRun() {
                game.goLeft(person1,2);
                if (game.isCheck(person1, enemy))
                    Toast.makeText(getApplicationContext(), "GAME OVER!!", Toast.LENGTH_SHORT).show();
            }
        };

        findViewById(R.id.Jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.goJump(findViewById(R.id.Person1),10);
            }
        });

    }
}
