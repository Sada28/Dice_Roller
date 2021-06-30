package com.example.dice_roller

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mp = MediaPlayer.create(this, R.raw.die_roll)
        val ivDice = findViewById<ImageView>(R.id.ivDice)
        val btndice = findViewById<Button>(R.id.btndice)
        btndice.setOnClickListener(View.OnClickListener {
            if (mp != null) {
                mp.stop()
                mp.release()
                mp = null
            }
            mp = MediaPlayer.create(applicationContext, R.raw.die_roll)
            mp.start()
            val r = Random()
            val num = r.nextInt(6) + 1
            when (num) {
                1 -> ivDice.setImageResource(R.drawable.dice1)
                2 -> ivDice.setImageResource(R.drawable.dice2)
                3 -> ivDice.setImageResource(R.drawable.dice3)
                4 -> ivDice.setImageResource(R.drawable.dice4)
                5 -> ivDice.setImageResource(R.drawable.dice5)
                6 -> ivDice.setImageResource(R.drawable.dice6)
            }
        })
    }
}