package com.example.sampleapplication

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_launch.*
import kotlinx.android.synthetic.main.content_hobby_main2.*

class MyEntertainment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_hobby_main2)

        button_game.setOnClickListener{

            val intent = Intent(this@MyEntertainment, EnteratinmentRoom::class.java)
            intent.putExtra("url", "https://www.websudoku.com/");

            startActivity(intent)

        }
        button_color.setOnClickListener{

            val intent = Intent(this@MyEntertainment, EnteratinmentRoom::class.java)
            intent.putExtra("url", "https://www.online-coloring.com/");

            startActivity(intent)

        }


    }

}
