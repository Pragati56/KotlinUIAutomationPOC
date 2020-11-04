package com.example.sampleapplication

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_information.*

class Information : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_information)

            webView.loadUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019")


    }

}
