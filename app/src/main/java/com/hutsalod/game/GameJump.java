package com.hutsalod.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.hutsalod.hutmovie.HutMovie;

public class GameJump extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_jump);

        HutMovie person = new HutMovie(findViewById(R.id.person));
        HutMovie enemy = new HutMovie(findViewById(R.id.enemy));

        enemy.left(100).speed(5)
                .repeat(true)
                .collision(person, result -> {
                    Toast.makeText(getApplicationContext(), "GAME OVER!", Toast.LENGTH_SHORT).show();
                    enemy.x(1000);
                }).onRun();

        findViewById(R.id.jump_action).setOnClickListener(v -> {
            person.jump(100).speed(5).onRun();
        });
    }
}