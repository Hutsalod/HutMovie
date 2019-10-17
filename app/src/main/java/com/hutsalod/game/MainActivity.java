package com.hutsalod.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hutsalod.hutmovie.HutMovie;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Timer timer = new Timer();
    private Handler handler = new Handler();

    ImageView Person1,Person2;

    HutMovie hutMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hutMovie = new HutMovie();

        Person1 = (ImageView)findViewById(R.id.Person1);
        Person2 = (ImageView)findViewById(R.id.Person2);

        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            hutMovie.goRight(Person1,3);
                            hutMovie.goRight(Person2,2);
                            hutMovie.goDown(Person1,2);
                            hutMovie.goDown(Person2,3);
                        }
                    });
                }
            }, 0, 20);
    }


}
