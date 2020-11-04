package com.example.sampleapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_launch.*


import kotlinx.android.synthetic.main.activity_main.*

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_launch)

        button3.setOnClickListener{

            val intent = Intent(this@LaunchActivity, KitchenMain3Activity::class.java)

            startActivity(intent)

        }
        button4.setOnClickListener{

            val intent = Intent(this@LaunchActivity, MyMedicine::class.java)

            startActivity(intent)

        }
        button5.setOnClickListener{

            val intent = Intent(this@LaunchActivity, MyEntertainment::class.java)

            startActivity(intent)

        }
        button6.setOnClickListener{

            val intent = Intent(this@LaunchActivity, Information::class.java)

            startActivity(intent)

        }

    }

}
