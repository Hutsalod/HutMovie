package com.hutsalod.game

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hutsalod.hutmovie.HutMovie

class MainActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val person1 = HutMovie(findViewById(R.id.Person1))
        val person2 = HutMovie(findViewById(R.id.Person2))

        person1.right(200)
                .down(200)
                .repeat(true)
                .onRun()

        person2.move(-300, 300)
                .collision(person1)
                .setAction(HutMovie.Action { x, y, collision -> if (collision) Toast.makeText(applicationContext, "WORKING!", Toast.LENGTH_LONG).show() })
                .repeat(true)
                .onRun()

    }
}