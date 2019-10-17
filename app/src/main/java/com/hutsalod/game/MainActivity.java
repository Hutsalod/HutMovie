package com.hutsalod.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.hutsalod.hutsalod.Animat;


import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Timer timer = new Timer();
    private Handler handler = new Handler();
    ImageView ImageView,ImageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView = (ImageView)findViewById(R.id.TextView);

        ImageView2 = (ImageView)findViewById(R.id.textView2);


        Animat.Show(ImageView,150);
        ImageView2.setX(ImageView.getX()+800);

        timer.schedule(new TimerTask() {

                @Override
                public void run() {

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Animat.goRIGHT(ImageView,5);

                            if(Animat.hitCheck(ImageView,ImageView2))
                                Animat.Hide(ImageView,150);
                        }
                    });
                }
            }, 0, 20);




    }
}
