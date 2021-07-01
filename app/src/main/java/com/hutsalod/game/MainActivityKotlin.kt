package com.hutsalod.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hutsalod.hutmovie.HutMovie

class MainActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HutMovie(findViewById(R.id.Person1))
                .right(200)
                .repeat(true)
                .onRun()

        HutMovie(findViewById(R.id.Person2))
                .down(200)
                .move(200, 300)
                .repeat(true)
                .onRun()

    }
}