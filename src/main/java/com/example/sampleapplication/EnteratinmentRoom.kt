package com.example.sampleapplication

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_enteratinment_room.*

class EnteratinmentRoom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enteratinment_room)
        val bundle = intent.extras
        val message = bundle!!.getString("url")

        webView_1.loadUrl(message)
    }

}
