package com.hutsalod.game;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hutsalod.hutmovie.HutMovie;

public class ActivityLevelTwo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);


        final HutMovie person1 = new HutMovie(findViewById(R.id.Person1));
        final HutMovie enemy = new HutMovie(findViewById(R.id.Enemy));

        enemy.x(1000).left(100).repeat(true).spead(3000).onRun();



        findViewById(R.id.Jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person1.jump(30);
                if (person1.isCheck(findViewById(R.id.Enemy)))
                    Toast.makeText(getApplicationContext(), "GAME OVER!!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
